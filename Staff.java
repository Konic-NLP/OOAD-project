import java.io.*;
import java.util.*;
import java.util.Random.*;

public class Staff {
    private String name;
    private int cwd;// to represent 'consecutiveworkdays' although it may mix with current work directory :)
    private int damageChance;

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
                System.out.format(" the %String get arrived at the store at days %d", ordereditem.getName(),today);
                inventory.updateStock(ordereditem);

            };
        }

    }

    public void checkRegister(Register register,Bank bank,Store store){
        int money=register.getMoneysum();
        int today=store.getDays();
        System.out.format("today %d, %d in the register",today,money);
        if (register.getMoneysum() < 75) {

            goToBank(register,bank);
        }
    }

    public void goToBank(Register register,Bank bank){
        int money=bank.withdraw();
        register.addmoney(money);
    }

    public void doInventory(Inventory inventory,Order order,Store store){

        System.out.println("The total value of all the items in the store is " + inventory.getTotalValue());
        ArrayList<Items> waitorder=inventory.checkStock(order,store);
        if(waitorder.size()!=0){
        this.placeAnOrder(waitorder,order);
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

    public void placeAnOrder(ArrayList<Items> waitorder, Order order){

        for(Items items: waitorder) {
            order.orderItems(items);
        }
    }
    public void openStore(Seller[] sellers,Buyer[] buyers, Register reg,Inventory inventory,Store store){
        for(Buyer buyer:buyers){

                checkWithBuyer(buyer,reg,inventory,store);


            }

        for(Seller seller:sellers){





        }



            }





    public int bidToSeller(Items items){

        /*

            the seller give the item to the staff and the staff
            demonstrate the price based on the condition of the item

         */
        int itemprice = items.condition* Helper.random_number(10,1);
        return itemprice;
    }

    public void checkWithSeller(Seller seller,Register reg, Inventory inventory){
        Items selleritems=seller.getItemsWantToSell();
        int sellprice=bidToSeller(selleritems);
        if(seller.getsellOrNot() == true){
            reg.deductmoney(sellprice);
            inventory.updateStock(selleritems);
        }else{
            sellprice=(int)(sellprice*1.1);
            if(seller.getsellOrNot()==true){
                reg.deductmoney(sellprice);
                inventory.updateStock(selleritems);

            }else{
                System.out.println("leave");

            }

        }


}
    public void checkWithBuyer(Buyer buyer,Register reg, Inventory inventory,  Store store){
        String buyitemtype=buyer.getItemWantToBuy();
        ArrayList<Items> itemsforbuy =new ArrayList<Items>();
        for(Items items:inventory.itemsList){
            if (items.getName().startsWith(buyitemtype)){
                itemsforbuy.add(items);

            }

        }
        Collections.shuffle(itemsforbuy);
        Items buyitem=itemsforbuy.get(0);
        if(buyer.checkItemsInStore(inventory)){
        if (buyer.getBuyOrNot()== true){
            reg.deductmoney(buyitem.getListPrice());
            inventory.removeItems(buyitem);
            store.addSoldItem(buyitem);

        }else{
            buyitem.setListPrice((int)(buyitem.getListPrice()*0.9));
            if(buyer.getBuyOrNotWithHigherPrice()==true){

                reg.deductmoney(buyitem.getListPrice());
                inventory.removeItems(buyitem);
                store.addSoldItem(buyitem);


            }else{

                System.out.format("%String doestn't buy anything and leave",buyer.getName());
            }



        }
    }else{


            System.out.format("%String doestn't buy anything and leave",buyer.getName());

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


            }else{
                System.out.println("nothing");


            }
        }




    }



}

