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
            if (ordereditem.getDaySold()==today-1){
                System.out.format(" the %String get arrived at the store at days %d %n", ordereditem.getName(),today);
                inventory.updateStock(ordereditem);

            };
        }

    }

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

    public void doInventory(Inventory inventory,Order order,Store store) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        System.out.println("The total value of all the items in the store is " + inventory.getTotalValue());
        ArrayList<Items> waitorder=inventory.checkStock(order,store);
        if(waitorder.size()!=0){
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

        for(Items items: waitorder) {
            order.orderItems(items.getClass(),store);
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





//    public int bidToSeller(Items items){
//        int itemprice=0;
        /*

            the seller give the item to the staff and the staff
            demonstrate the price based on the condition of the item

         */

//        return itemprice;
//    }

    public void checkWithSeller(Seller seller,Register reg, Inventory inventory) throws InstantiationException, IllegalAccessException {
//        System.out.println(seller.getItemsWantToSell(inventory));

        try{Items selleritems= seller.getItemsWantToSell(inventory);
            selleritems.setPurchasePrice(selleritems.getCondition() * Helper.random_number(10, 1));
//            selleritems.initialize_main(5);
//            selleritems.initialize_price();
//            selleritems.initialize_forSelller(3);
        System.out.println(selleritems+selleritems.getName());
        int sellprice=selleritems.getPurchasePrice();
        if(seller.getsellOrNot() == true){

            reg.deductmoney(sellprice);
            selleritems.setSalePrice(sellprice);
            inventory.updateStock(selleritems);
            System.out.format("%s sell a %s at a price %d %n",seller.getName(),selleritems.name,sellprice);
        }else{
            sellprice=(int)(sellprice*1.1);
            if(seller.getsellOrNot()==true){
                reg.deductmoney(sellprice);
                selleritems.setSalePrice(sellprice);
                inventory.updateStock(selleritems);
                System.out.format("%s sell a %s at a price %d after increase 10 %n",seller.getName(),selleritems.name,sellprice);
            }else{
                System.out.println("not content for price leave");

            }

        }}
        catch (Exception e){System.out.println("Wrong");}}


    public void checkWithBuyer(Buyer buyer,Register reg, Inventory inventory,  Store store){
        String buyitemtype=buyer.getItemWantToBuy();
        ArrayList<Items> itemsforbuy =new ArrayList<Items>();
        for(Items items:inventory.itemsList){
//            System.out.println(buyitemtype);
//            System.out.println(items.);
//            if (items.getName()==null){
//                System.out.println(items.itemType);
//                System.out.println(items.dayArrived);
//
//            }
//            System.out.println(items.getItemType()+buyitemtype);
//            String a=items.itemType
            if (items.getItemType().equals(buyitemtype)){
                itemsforbuy.add(items);

            }

        }
        if(itemsforbuy.size()==0){
            System.out.println("no I want to leave");
        }else{
        Collections.shuffle(itemsforbuy);
        Items buyitem=itemsforbuy.get(0);
        System.out.println(buyitem+buyitem.getName());
//        if(buyer.checkItemsInStore(inventory)){
        if (buyer.getBuyOrNot()== true){
            reg.deductmoney(buyitem.getListPrice());
            inventory.removeItems(buyitem);
            store.addSoldItem(buyitem);
            System.out.format("%s buy a %s at %d %n",buyer.getName(),buyitem.name,buyitem.getListPrice());
        }else{
            buyitem.setListPrice((int)(buyitem.getListPrice()*0.9));
            if(buyer.getBuyOrNotWithHigherPrice()==true){

                reg.deductmoney(buyitem.getListPrice());
                inventory.removeItems(buyitem);
                store.addSoldItem(buyitem);
                System.out.format("%s buy a %s at %d after 10%n",buyer.getName(),buyitem.name,buyitem.getListPrice());

            }else{

                System.out.format("%s doestn't buy anything and leave due to second not content%n",buyer.getName());
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
                System.out.println("something destroyed");

            }


            }else{
            System.out.println("nothing");
        }




    }



}

