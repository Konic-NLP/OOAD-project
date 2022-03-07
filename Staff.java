import java.io.*;
import java.util.*;
import java.util.Random.*;
import java.lang.Object;
import java.util.stream.Collectors;

public class Staff {
    private String name;
    private int cwd;// to represent 'consecutive_work_days' although it may mix with current work directory :)
    private int damageChance;// the chance for damaging things
    private tuneAlgorithms tunealgorithms;

    public String getName(){// get the name of Staff.
        return this.name;

    }
    public Staff(int chance, String name,tuneAlgorithms tunealgorithms){// use constructor to instantiate the object
        this.damageChance=chance;
        this.name=name;
        this.tunealgorithms=tunealgorithms;

    }

    public int getCwd() {
        return this.cwd;
    }

    public void addCwd(){
        // encapsulation. we don't require the store know how to add the consecutive work days,
        // they just call the method
        this.cwd+=1;

    }

    public void cleanCwd(){
        this.cwd=0;
    }

    public void arriveAtStore(Order order,Inventory inventory,Store store,Publisher publisher) throws IOException {
        int count = 0;
        int today=store.getDays();
        ArrayList<Items> orderlist =order.getorderlist();
        for(Items ordereditem:orderlist){
            if (ordereditem.getDayArrived()==today){// means the ordered items arrived at the store
                System.out.format("arriveAtStore: the  %s get arrived at the store at days %d %n", ordereditem.getName(),today);
                inventory.updateStock(ordereditem);//update the inventory
                ordereditem.setDayArrived(-1);//signal that the one has been arrived
//                orderlist.remove(ordereditem);
                count+=1;

            }else if  (ordereditem.getDayArrived()==today-1 & (today-1)%7==0){
                // if the day before today is sunday and by chance there was an order get arrived,
                // today to pick up the order
                System.out.format("ArriveAtStore: the  %s get arrived at the store at days %d %n", ordereditem.getName(),today);
                inventory.updateStock(ordereditem);
                ordereditem.setDayArrived(-1);
//                orderlist.remove(ordereditem); ; may induce conModificationException
                count+=1;
            }
        }
        publisher.notifyObservers(0,this.getName(),0);
        publisher.notifyObservers(1,this.getName(),count);

    }


    public void checkRegister(Bank bank,Store store,Publisher publisher) throws IOException {
        //if register money lower than the threshold, enter to the bank.
        int money=store.register.getMoneysum();
        publisher.notifyObservers(2,this.getName(),money);
        int today=store.getDays();
        System.out.format("Check register: today %d, %d in the register%n",today,money);
        if (store.register.getMoneysum() < 75) {

            goToBank(store,bank);
            publisher.notifyObservers(3,this.getName(),store.register.getMoneysum());
        }
    }

    /*
    abstraction:I don't worry about the implementation of the withdraw and addmoney,
    I just delegate these methods.

     */
    public void goToBank(Store store,Bank bank){
        int money=bank.withdraw();//bank cutdowns the money
        store.register.addmoney(money); //register increase the money
    }

    public void doInventory(Inventory inventory,Order order,Store store,Publisher publisher) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

        int totalvalue=getTotalValue(inventory,publisher);
        System.out.println("Do inventory: The total value of all the items in the store is " + totalvalue);
        publisher.notifyObservers(4,this.getName(),inventory.getItemsList().size());
        publisher.notifyObservers(5,this.getName(),totalvalue);
        // get the items that required to order
        ArrayList<Items> waitorder=inventory.checkStock(order);
        if(waitorder.size()!=0) { //if any need to be ordered
            this.placeAnOrder(waitorder, order, store,publisher);
        }
    }

//    public ArrayList<Items> checkInventory(Inventory inventory,Store store,Order order){
//        ArrayList<Items> waitorder= new ArrayList<Items>();
//        HashMap<Items,Integer> alllist=inventory.countItems;
//        for (Map.Entry<Items,Integer> entry : alllist.entrySet()){
//            // stock =0 and this has not been ordered in orderlist.
//            if (entry.getValue() == 0 & !order.getorderlist().contains(entry.getKey())){
//                Items newitem=entry.getKey();
//                newitem.initialize_main(store.getDays());
//                newitem.initialize_price();
//                waitorder.add(newitem);
//
//            }
//        }
//        inventory.forEach((itemType, amount) -> {
//            if (amount.equals(0) = Ture){
//            }
//        });

//        return waitorder;
//    }

    public void placeAnOrder(ArrayList<Items> waitorder, Order order,Store store,Publisher publisher) throws InstantiationException, IllegalAccessException, IOException {
        // place an order

        for(Items items: waitorder) {
            System.out.format("PlaceOrder: %s ordered %s at the %d day %n",this.getName(),items.getItemType(),store.getDays());
            order.orderItems(items.getClass(),store);  // order items

            store.register.deductmoney(items.getPurchasePrice());  // then deduct the money for the order

        }
        publisher.notifyObservers(7,this.getName(), waitorder.size()*3);
    }

    public void openStore(Seller[] sellers,Buyer[] buyers,Inventory inventory,Store store,Publisher publisher) throws InstantiationException, IllegalAccessException, IOException {
        int boughtCount =0;
        int soldCount =0;
        for(Buyer buyer:buyers){
            boughtCount += checkWithBuyer(buyer,inventory,store);
        }

        for(Seller seller:sellers){
            soldCount += checkWithSeller(seller,store.register,inventory);
        }
        publisher.notifyObservers(8,this.getName(),boughtCount);
        publisher.notifyObservers(9,this.getName(),soldCount);


            }
    public int getTotalValue(Inventory inventory,Publisher publisher) throws IOException {
        int totalValue = 0;
        int damageCount = 0;
        ArrayList<Items> maydamage= new ArrayList<Items>();
        for (Items items: inventory.getItemsList()){
            boolean T2F=this.tunealgorithms.operation(this.name,items); // get wehther true to false


            if (T2F&items.getProperty()!=null){ // may damage one item from such a list

                maydamage.add(items);
            }

            totalValue += items.purchasePrice;
        }
        for(Items item:maydamage){
            damageCount +=damageItems(item,inventory,10);} // call damage item
        publisher.notifyObservers(6,this.name,damageCount);
        return totalValue;
    }



    public void leaveTheShop(Store store,Publisher publisher) throws IOException {
        System.out.format("Leave Store: %s close the store at the day %d and back home %n",this.getName(),store.getDays());
        publisher.notifyObservers(11,this.getName(),0);
    }


    public int checkWithSeller(Seller seller,Register reg, Inventory inventory) throws InstantiationException, IllegalAccessException {
//        System.out.println(seller.getItemsWantToSell(inventory));
        int count = 0;
        try{Items selleritems= seller.getItemsWantToSell();// get what's the item that the seller want to buy
//            System.out.println(selleritems);
            selleritems.setPurchasePrice(selleritems.getCondition() * Helper.random_number(10, 1));
            int purchaseprice=selleritems.getPurchasePrice();
            //get the price based on the condition
            if(selleritems.getClass().getSuperclass().getName().contains("Clothing") & inventory.queryClothingStock()){
                // once any subtype of clothing was sold out, the store will not buy clothing from sellers anymore.
                System.out.println("we don't buy any Clothing from the seller due to the stock issues");
                // test case
//                System.out.println(inventory.getItemsList());
            }

        else if(seller.getsellOrNot(50) == true){
            count+=1;
            // cohesion, the getsellornot just give me the boolean value whether the customer is willing to buy
            // if the the seller agree to sell
            reg.deductmoney(purchaseprice);// buy the item from the register
//            selleritems.setSalePrice(purchaseprice);
            inventory.updateStock(selleritems);// add the item to the inventory
            String condition= Items.getConditionList()[(int)(selleritems.getCondition())];// get the condition

            System.out.format("OpenStore: %s bought a %s %s %s from %s for %d %n",this.getName(),
                    condition,
                    selleritems.getNewOrUsed(),
                    selleritems.getItemType(),
                    seller.getName(),
                    purchaseprice);
        }else{
            purchaseprice=(int)(purchaseprice*1.1);// if the seller disagree, increase the price to appeal the customer
            if(seller.getsellOrNot(75)==true){
                count+=1;
                reg.deductmoney(purchaseprice);
//                selleritems.setSalePrice(sellprice);
                inventory.updateStock(selleritems);
                String condition= Items.getConditionList()[(int)(selleritems.getCondition())-1];

                System.out.format("openStore: %s bought a %s %s %s from %s for %d  %n",this.getName(),//staff's name
                        condition,  //condition
                        selleritems.getNewOrUsed(), // new or old
                        selleritems.getItemType(),  // the type of the item
                        seller.getName(),     //the name of the seller
                        purchaseprice);    // the terminal price bought from the customer
            }else{// if even the seller doesn't accept the higher price
                System.out.format("the %s doesn't sell %s since he dissatisfied with the price %n",
                        seller.getName(),selleritems.getItemType());

            }

        }}
        catch (Exception e){System.out.println("Wrong");
        e.printStackTrace();}
    return count;
    }


    public int checkWithBuyer(Buyer buyer, Inventory inventory,  Store store) throws IOException {
        String[] notype= new String[]{"Shirts","Hats","Bandanas"};
        String buyitemtype=buyer.randomItemWantToBuy();
//        if(Arrays.asList(notype).contains(buyitemtype)&inventory.queryClothingStock()){
//
//            System.out.println("The Clothing items in the store is outofstock");
//        }else{
        /* decorator: the client will treat the decorated class as the same way as
        the original class object without decorating

         */
        Inventory inventory1= new addgigbag(inventory);
        inventory1=new addCables(inventory1);
        inventory1=new addPracticeAmp(inventory1);
        inventory1=new addStrings(inventory1);
       ArrayList<Items> buyitems=inventory1.Getitemstosell(buyitemtype);

       if(buyitems ==null){
            System.out.format("openStore: %s want to buy a %s but none were in inventory , so left%n", buyer.getName(),buyitemtype );
        }else{

            // if the buyer agree to buy with the original price
        if (buyer.getBuyOrNot(buyitems,50)== true){
//            System.out.println(addgigbag);
//            buyitems=addgigbag.Getitemstosell(buyitemtype);
            int sum=0;
            if(buyitems.size()>1){System.out.println("additional sold items:" +Helper.mergeString(new ArrayList<Items>(buyitems.subList(1,buyitems.size()))));}
            for(Items items:buyitems){

                sellitem(items,store,inventory);
                sum+=items.getListPrice();

            }

            // operation: update the inventory, deduct the money from the register, change the saleprice, add record
            // to the soldlist
//


            System.out.format("openStore: %s sold a %s to %s  for  %d  %n",this.getName(),Helper.mergeString(buyitems),buyer.getName(),sum);
            return buyitems.size();
        }else{
            // otherwise, we will give the buyer a discount
            int discountprice=(int)(buyitems.get(0).getListPrice()*0.9);
            if(buyer.getBuyOrNot(buyitems,75)==true){

                int sum=0;
                if(buyitems.size()>1){System.out.println("additional sold items:" +Helper.mergeString(new ArrayList<Items>(buyitems.subList(1,buyitems.size()))));}

                for(Items items:buyitems){

                    sellitem(items,store,inventory);
                    sum+=items.getListPrice();
                }
//                if(buyitems.size()>1){
//                    System.out.print(buyitems);};

                System.out.format("%s sold a %s to %s  for  %d after a 10%% discount %n",
                        this.getName(),
                        Helper.mergeString(buyitems),
                        buyer.getName(),
                        sum);
                return buyitems.size();

            }else{
                // if the customer don't want to buy even with a discount

                System.out.format("%s doesn't buy anything and leave because the dissatisfaction for the price %n",buyer.getName());
            }
        }
       }
//        return 0;
//    }
        return 0;}

    public void sellitem(Items buyitem,Store store,Inventory inventory){
            store.register.addmoney((buyitem.getListPrice()));
            inventory.removeItems(buyitem);
            buyitem.setSalePrice(buyitem.getListPrice());
            store.addSoldItem(buyitem);}

    public void cleanStore(Inventory inventory,Publisher publisher) throws IOException {

        Items destroyitems=inventory.randomItem();
        int count = damageItems(destroyitems,inventory,this.damageChance);
        publisher.notifyObservers(10,this.getName(),count);



    }
    public int damageItems(Items destoryeditem,Inventory inventory,int chance) throws IOException {
        int count=0;
        Random random=new Random();
        int prob=random.nextInt(101);
        //generate a probability and see whether it invoke the change to damage
        if(prob<chance){
            count=1;
            destoryeditem.setCondition(destoryeditem.getCondition()-1);
            destoryeditem.setListPrice((int)(destoryeditem.getListPrice()*0.8));
            // result of damage: condition-1, price decrease 20%
            if (destoryeditem.getCondition()==0){
                // condition=0, disappear forever
                inventory.removeItems(destoryeditem);
                System.out.format("Damage: %s destroyed a %s by accident %n",this.getName(),destoryeditem.getName());
            }
        }else{

//            System.out.println("nothing happened");
        }
        return count;
    }

}

