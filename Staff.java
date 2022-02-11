import java.io.*;
import java.util.*;
import java.util.Random.*;
import java.lang.Object;
public class Staff {
    private String name;
    private int cwd;// to represent 'consecutive_work_days' although it may mix with current work directory :)
    private int damageChance;// to the chance for damaging things

    public String getName(){// to get the name of Staff.
        return this.name;

    }
    public Staff(int chance, String name){// to use constructor to instantiate the object
        this.damageChance=chance;
        this.name=name;
    }

    public int getCwd() {
        return this.cwd;
    }

    //If the stall is on duty that day, cwd will increase by one.
    public void addCwd(){
        this.cwd+=1;
    }
    // If the stall is not on duty that day, cwd will set to zero.
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

    public void checkRegister(Register register,Bank bank,Store store){
        //if register money lower than the threshold, enter to the bank.
        int money=register.getMoneysum();
        int today=store.getDays();
        System.out.format("today %d, %d in the register%n",today,money);
        if (register.getMoneysum() < 75) {

            goToBank(register,bank);
        }
    }

    public void goToBank(Register register,Bank bank){
        int money=bank.withdraw();//bank cutdowns the money
        register.addmoney(money); //register increase the money
    }

    public void doInventory(Inventory inventory,Order order,Store store,Register reg) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // get the items that required to order
        System.out.println("The total value of all the items in the store is " + inventory.getTotalValue());
        ArrayList<Items> waitorder=inventory.checkStock(order);
        if(waitorder.size()!=0){ //if any need to be required
        this.placeAnOrder(waitorder,order,store,reg);
        }
    }

    public void placeAnOrder(ArrayList<Items> waitorder, Order order,Store store,Register reg) throws InstantiationException, IllegalAccessException {
        // place an order
        for(Items items: waitorder) {
            System.out.format("%s ordered %s at the %d day %n",this.getName(),items.getItemType(),store.getDays());
            order.orderItems(items.getClass(),store);  // order items
            reg.deductmoney(items.getPurchasePrice());  // then deduct the money for the order
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

        try{Items selleritems= seller.getItemsWantToSell();// get what's the item that the seller want to buy
//            System.out.println(selleritems);
            selleritems.setPurchasePrice(selleritems.getCondition() * Helper.random_number(10, 1));
            //get the price based on the condition

        int purchaseprice=selleritems.getPurchasePrice();
        if(seller.getsellOrNot() == true){
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
            }else{// if even the seller doesn't accept the higher price
                System.out.format("the %s doesn't sell %s since he dissatisfied with the price %n",
                        seller.getName(),selleritems.getItemType());

            }

        }}
        catch (Exception e){System.out.println("Wrong");
        e.printStackTrace();}}


    public void checkWithBuyer(Buyer buyer,Register reg, Inventory inventory,  Store store){
        String buyitemtype=buyer.getItemWantToBuy();  //get the itemtype in the inventory that a buyer want to buy
        ArrayList<Items> itemsforbuy =new ArrayList<Items>();
        // get all the items in the inventory that belongs to the specific itemtypes
        for(Items items:inventory.itemsList){

            if (items.getItemType().equals(buyitemtype)){
                itemsforbuy.add(items);

            }

        }
        // if there is no items that qualified the buyer's expectation
        if(itemsforbuy.size()==0){
            System.out.format("%s want to buy a %s but none were in inventory , so left%n", buyer.getName(),buyitemtype );
        }else{
        Collections.shuffle(itemsforbuy); // use shuffle to simulate select randomly
        Items buyitem=itemsforbuy.get(0);
//        System.out.println(buyitem+buyitem.getName());
//        if(buyer.checkItemsInStore(inventory)){

            // if the buyer agree to buy with the original price
        if (buyer.getBuyOrNot()== true){
            reg.addmoney((buyitem.getListPrice()));
            inventory.removeItems(buyitem);
            buyitem.setSalePrice(buyitem.getListPrice());
            store.addSoldItem(buyitem);
            // operation: update the inventory, deduct the money from the register, change the saleprice, add record
            // to the soldlist
            System.out.format("%s sold a %s to %s  for  %d  %n",this.getName(),buyitem.getItemType(),buyer.getName(),buyitem.getListPrice());
        }else{
            // otherwise, we will give the buyer a discount
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
                // if the customer don't want to buy even with a discount

                System.out.format("%s doesn't buy anything and leave because the dissatisfaction for the price %n",buyer.getName());
            }
        }
        }
    }

    public void cleanStore(Inventory inventory){


        Items destoryeditem = inventory.randomItem();
        Random random=new Random();
        int prob=random.nextInt(100);
        //generate a probability and see whether it invoke the change to damage
        if(prob<this.damageChance){
            destoryeditem.setCondition(destoryeditem.getCondition()-1);
            destoryeditem.setListPrice((int)(destoryeditem.getListPrice()*0.8));
            // result of damage: condition-1, price decrease 20%
            if (destoryeditem.getCondition()==0){
                // condition=0, disappear forever
                inventory.removeItems(destoryeditem);
                System.out.format("%s destoryed a %s by accident %n",this.getName(),destoryeditem.getName());

            }
            }else{
            System.out.println("it's wonderful day: nothing was damaged");
        }
    }
}

