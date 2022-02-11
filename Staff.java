import java.io.*;
import java.util.*;
import java.util.Random.*;
import java.lang.Object;
public class Staff {
    private String name;
    private int cwd;// to represent 'consecutiveworkdays' although it may mix with current work directory :)
    private int damageChance;
    public String getName(){
        return this.name;

    }
    public Staff(int chance, String name){
        this.damageChance=chance;
        this.name=name;
    }

    public int getCwd() {
        return this.cwd;
    }

    public void addCwd(){
        this.cwd+=1;

    }

    public void cleanCwd(){

        this.cwd=0;
    }
    public void arriveAtStore(Order order,Inventory inventory,Store store){

        int today=store.getDays();
        ArrayList<Items> orderlist =order.getorderlist();
        for(Items ordereditem:orderlist){
            if (ordereditem.getDayArrived()==today){
                System.out.format(" the 3 %String get arrived at the store at days %d %n", ordereditem.getName(),today);
                inventory.updateStock(ordereditem);
                ordereditem.setDayArrived(-1);
//                orderlist.remove(ordereditem);

            }else if  (ordereditem.getDayArrived()==today-1 & (today-1)%7==0){
                // if the day before today is sunday and by chance there was an order get arrived,
                // today to pick up the order
                System.out.format(" the 3 %String get arrived at the store at days %d %n", ordereditem.getName(),today);
                inventory.updateStock(ordereditem);
                ordereditem.setDayArrived(-1);
//                orderlist.remove(ordereditem); ;
        }

    }}

    public void checkRegister(Register register,Bank bank,Store store){
        int money=register.getMoneysum();
        int today=store.getDays();
        System.out.format("today %d, %d in the register%n",today,money);
        if (register.getMoneysum() < 75) {

            goToBank(register,bank);
        }
    }

    public void goToBank(Register register,Bank bank){
        int money=bank.withdraw();
        register.addmoney(money);
    }

    public void doInventory(Inventory inventory,Order order,Store store,Register reg) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        System.out.println("The total value of all the items in the store is " + inventory.getTotalValue());
        ArrayList<Items> waitorder=inventory.checkStock(order,store);
        if(waitorder.size()!=0){
        this.placeAnOrder(waitorder,order,store,reg);
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

    public void placeAnOrder(ArrayList<Items> waitorder, Order order,Store store,Register reg) throws InstantiationException, IllegalAccessException {

        for(Items items: waitorder) {
            order.orderItems(items.getClass(),store);
            reg.deductmoney(items.getPurchasePrice());
        }
    }

    public void openStore(Seller[] sellers,Buyer[] buyers, Register reg,Inventory inventory,Store store) throws InstantiationException, IllegalAccessException {
        for(Buyer buyer:buyers){

                checkWithBuyer(buyer,reg,inventory,store);


            }

        for(Seller seller:sellers){

            checkWithSeller(seller,reg,inventory);



        }



            }




    public void leaveTheShop(Store store){
        System.out.format("%s close the store at the day %d and back home %n",this.getName(),store.getDays());

    }

    public void checkWithSeller(Seller seller,Register reg, Inventory inventory) throws InstantiationException, IllegalAccessException {
//        System.out.println(seller.getItemsWantToSell(inventory));

        try{Items selleritems= seller.getItemsWantToSell();
//            System.out.println(selleritems);
            selleritems.setPurchasePrice(selleritems.getCondition() * Helper.random_number(10, 1));

//        System.out.println(selleritems+selleritems.getName());
        int purchaseprice=selleritems.getPurchasePrice();
        if(seller.getsellOrNot() == true){

            reg.deductmoney(purchaseprice);
//            selleritems.setSalePrice(purchaseprice);
            inventory.updateStock(selleritems);
            String condition= Items.getConditionList()[(int)(selleritems.getCondition())];

            System.out.format("%s bought a %s %s %s from %s for %d %n",this.getName(),
                    condition,
                    selleritems.getNewOrUsed(),
                    selleritems.getItemType(),
                    seller.getName(),
                    purchaseprice);
        }else{
            purchaseprice=(int)(purchaseprice*1.1);
            if(seller.getsellOrNot()==true){
                reg.deductmoney(purchaseprice);
//                selleritems.setSalePrice(sellprice);
                inventory.updateStock(selleritems);
                String condition= Items.getConditionList()[(int)(selleritems.getCondition())];

                System.out.format("%s bought a %s %s %s from %s for %d  %n",this.getName(),//staff's name
                        condition,  //condition
                        selleritems.getNewOrUsed(), // new or old
                        selleritems.getItemType(),  // the type of the item
                        seller.getName(),     //the name of the seller
                        purchaseprice);    // the terminal price bought from the customer
            }else{
                System.out.format("the %s doesn't sell %s since he dissatisfied with the price %n",
                        seller.getName(),selleritems.getItemType());

            }

        }}
        catch (Exception e){System.out.println("Wrong");
        e.printStackTrace();}}


    public void checkWithBuyer(Buyer buyer,Register reg, Inventory inventory,  Store store){
        String buyitemtype=buyer.getItemWantToBuy();
        ArrayList<Items> itemsforbuy =new ArrayList<Items>();
        for(Items items:inventory.itemsList){

            if (items.getItemType().equals(buyitemtype)){
                itemsforbuy.add(items);

            }

        }
        if(itemsforbuy.size()==0){
            System.out.format("%s want to buy a %s but none were in inventory , so left%n", buyer.getName(),buyitemtype );
        }else{
        Collections.shuffle(itemsforbuy);
        Items buyitem=itemsforbuy.get(0);
//        System.out.println(buyitem+buyitem.getName());
//        if(buyer.checkItemsInStore(inventory)){
        if (buyer.getBuyOrNot()== true){
            reg.addmoney((buyitem.getListPrice()));
            inventory.removeItems(buyitem);
            buyitem.setSalePrice(buyitem.getListPrice());
            store.addSoldItem(buyitem);

            System.out.format("%s sold a %s to %s  for  %d  %n",this.getName(),buyitem.getItemType(),buyer.getName(),buyitem.getListPrice());
        }else{
            int discountprice=(int)(buyitem.getListPrice()*0.9);
            if(buyer.getBuyOrNotWithHigherPrice()==true){

                reg.addmoney(discountprice);
                inventory.removeItems(buyitem);
                buyitem.setDaySold(store.getDays());
                buyitem.setSalePrice(discountprice);
                store.addSoldItem(buyitem);

                System.out.format("%s sold a %s to %s  for  %d after a 10%% discount %n",
                        this.getName(),
                        buyitem.getItemType(),
                        buyer.getName(),
                        discountprice);

            }else{

                System.out.format("%s doesn't buy anything and leave because the dissatisfaction for the price %n",buyer.getName());
            }



        }
    }





    }

    public void cleanStore(Inventory inventory){


        Items destoryeditem = inventory.randomItem();
        Random random=new Random();
        int prob=random.nextInt(100);
        if(prob<this.damageChance){
            destoryeditem.setCondition(destoryeditem.getCondition()-1);
            destoryeditem.setListPrice((int)(destoryeditem.getListPrice()*0.8));

            if (destoryeditem.getCondition()==0){
                inventory.removeItems(destoryeditem);
                System.out.format("%s destoryed a %s by accident %n",this.getName(),destoryeditem.getName());

            }


            }else{
            System.out.println("it's wonderful day");
        }




    }



}

