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
    public void arriveAtStore(Order order,Inventory inventory,Store store){

        int today=store.getDays();
        ArrayList<Items> orderlist =order.getorderlist();
        for(Items ordereditem:orderlist){
            if (ordereditem.getDayArrived()==today){// means the ordered items arrived at the store
                System.out.format(" the  %s get arrived at the store at days %d %n", ordereditem.getName(),today);
                inventory.updateStock(ordereditem);//update the inventory
                ordereditem.setDayArrived(-1);//signal that the one has been arrived
//                orderlist.remove(ordereditem);

            }else if  (ordereditem.getDayArrived()==today-1 & (today-1)%7==0){
                // if the day before today is sunday and by chance there was an order get arrived,
                // today to pick up the order
                System.out.format(" the  %s get arrived at the store at days %d %n", ordereditem.getName(),today);
                inventory.updateStock(ordereditem);
                ordereditem.setDayArrived(-1);
//                orderlist.remove(ordereditem); ; may induce conModificationException
        }

    }}

    public void checkRegister(Bank bank,Store store){
        //if register money lower than the threshold, enter to the bank.
        int money=store.register.getMoneysum();
        int today=store.getDays();
        System.out.format("today %d, %d in the register%n",today,money);
        if (store.register.getMoneysum() < 75) {

            goToBank(store,bank);
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

    public void doInventory(Inventory inventory,Order order,Store store) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // get the items that required to order
        System.out.println("The total value of all the items in the store is " + getTotalValue(inventory));
        ArrayList<Items> waitorder=inventory.checkStock(order);
        if(waitorder.size()!=0){ //if any need to be required
        this.placeAnOrder(waitorder,order,store);

    }}

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

    public void placeAnOrder(ArrayList<Items> waitorder, Order order,Store store) throws InstantiationException, IllegalAccessException {
        // place an order
        for(Items items: waitorder) {
            System.out.format("%s ordered %s at the %d day %n",this.getName(),items.getItemType(),store.getDays());
            order.orderItems(items.getClass(),store);  // order items

            store.register.deductmoney(items.getPurchasePrice());  // then deduct the money for the order
        }
    }

    public void openStore(Seller[] sellers,Buyer[] buyers,Inventory inventory,Store store) throws InstantiationException, IllegalAccessException {
        for(Buyer buyer:buyers){

                checkWithBuyer(buyer,inventory,store);


            }

        for(Seller seller:sellers){

            checkWithSeller(seller,store.register,inventory);



        }



            }
    public int getTotalValue(Inventory inventory){
        int totalValue = 0;
        ArrayList<Items> maydamage= new ArrayList<Items>();
        for (Items items: inventory.getItemsList()){
            this.tunealgorithms.operation(items);

            if (this.tunealgorithms.T2F){

                maydamage.add(items);
            }

            totalValue += items.purchasePrice;
        }
        for(Items item:maydamage){
            damageItems(item,inventory,10);}

        return totalValue;
    }



    public void leaveTheShop(Store store){
        System.out.format("%s close the store at the day %d and back home %n",this.getName(),store.getDays());

    }


    public void checkWithSeller(Seller seller,Register reg, Inventory inventory) throws InstantiationException, IllegalAccessException {
//        System.out.println(seller.getItemsWantToSell(inventory));

        try{Items selleritems= seller.getItemsWantToSell();// get what's the item that the seller want to buy
//            System.out.println(selleritems);
            selleritems.setPurchasePrice(selleritems.getCondition() * Helper.random_number(10, 1));
            int purchaseprice=selleritems.getPurchasePrice();
            //get the price based on the condition
            if(selleritems.getClass().getSuperclass().getName().contains("Clothing") & inventory.queryClothingStock()){
                System.out.println("we don't buy any Clothing from the seller due to the stock issues");
            }

        else if(seller.getsellOrNot(50) == true){

            // cohesion, the getsellornot just give me the boolean value whether the customer is willing to buy
            // if the the seller agree to sell
            reg.deductmoney(purchaseprice);// buy the item from the register
//            selleritems.setSalePrice(purchaseprice);
            inventory.updateStock(selleritems);// add the item to the inventory
            String condition= Items.getConditionList()[(int)(selleritems.getCondition())];// get the condition

            System.out.format("%s bought a %s %s %s from %s for %d %n",this.getName(),
                    condition,
                    selleritems.getNewOrUsed(),
                    selleritems.getItemType(),
                    seller.getName(),
                    purchaseprice);
        }else{
            purchaseprice=(int)(purchaseprice*1.1);// if the seller disagree, increase the price to appeal the customer
            if(seller.getsellOrNot(75)==true){
                reg.deductmoney(purchaseprice);
//                selleritems.setSalePrice(sellprice);
                inventory.updateStock(selleritems);
                String condition= Items.getConditionList()[(int)(selleritems.getCondition())-1];

                System.out.format("%s bought a %s %s %s from %s for %d  %n",this.getName(),//staff's name
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
        e.printStackTrace();}}


    public void checkWithBuyer(Buyer buyer, Inventory inventory,  Store store){
        String buyitemtype=buyer.randomItemWantToBuy();
        Inventory inventory1= new addgigbag(inventory);
       ArrayList<Items> buyitems=inventory1.Getitemstosell(buyitemtype);
//       System.out.println(buyitems);
       if(buyitems ==null){
            System.out.format("%s want to buy a %s but none were in inventory , so left%n", buyer.getName(),buyitemtype );
        }else{
            // if the buyer agree to buy with the original price
        if (buyer.getBuyOrNot(buyitems,50)== true){

//            System.out.println(addgigbag);
//            buyitems=addgigbag.Getitemstosell(buyitemtype);
            int sum=0;
            for(Items items:buyitems){
                sellitem(items,store,inventory);
                sum+=items.getListPrice();

            }

            // operation: update the inventory, deduct the money from the register, change the saleprice, add record
            // to the soldlist
//

            if(buyitems.size()>1){
            System.out.print(buyitems);};
            System.out.format("%s sold a %s to %s  for  %d  %n",this.getName(),Helper.mergeString(buyitems),buyer.getName(),sum);
        }else{
            // otherwise, we will give the buyer a discount
            int discountprice=(int)(buyitems.get(0).getListPrice()*0.9);
            if(buyer.getBuyOrNot(buyitems,75)==true){
                Inventory addgigbag= new addgigbag(inventory);
                buyitems=addgigbag.Getitemstosell(buyitemtype);
                int sum=0;
                for(Items items:buyitems){
                    sellitem(items,store,inventory);
                    sum+=items.getListPrice();
                }
                if(buyitems.size()>1){
                    System.out.print(buyitems);};

                System.out.format("%s sold a %s to %s  for  %d after a 10%% discount %n",
                        this.getName(),
                        Helper.mergeString(buyitems),
                        buyer.getName(),
                        discountprice);

            }else{
                // if the customer don't want to buy even with a discount

                System.out.format("%s doesn't buy anything and leave because the dissatisfaction for the price %n",buyer.getName());
            }



        }

    }





    }
    public void sellitem(Items buyitem,Store store,Inventory inventory){
            store.register.addmoney((buyitem.getListPrice()));
            inventory.removeItems(buyitem);
            buyitem.setSalePrice(buyitem.getListPrice());
            store.addSoldItem(buyitem);}

    public void cleanStore(Inventory inventory){

        Items destroyitems=inventory.randomItem();
        damageItems(destroyitems,inventory,this.damageChance);



    }
    public void damageItems(Items destoryeditem,Inventory inventory,int chance){

        Random random=new Random();
        int prob=random.nextInt(100);
        //generate a probability and see whether it invoke the change to damage
        if(prob<chance){
            destoryeditem.setCondition(destoryeditem.getCondition()-1);
            destoryeditem.setListPrice((int)(destoryeditem.getListPrice()*0.8));
            // result of damage: condition-1, price decrease 20%
            if (destoryeditem.getCondition()==0){
                // condition=0, disappear forever
                inventory.removeItems(destoryeditem);
                System.out.format("%s destoryed a %s by accident %n",this.getName(),destoryeditem.getName());

            }


        }else{
            System.out.println("nothing happened");
        }


    }




}

