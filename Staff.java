import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Random.*;

public class Staff {
    private String name;
    private int cwd;// to represent 'consecutiveworkdays' althought it may mix with current work directory :)
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
        Arraylist<Items> orderlist =order.getorderlist();
        for(Items ordereditem:orderlist){
            if (ordereditem.getDaySolid()==today-1){

                inventory.updatestock(ordereditem);

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

    public void doInventory(Inventory inventory,Order order){

        System.out.println("The total value of all the items in the store is " + inventory.getTotalvalue());
        ArrayList<Items> waitorder=checkInventory(inventory.countItems);
        if(waitorder.size()!=0){
        this.placeAnOrder(waitorder,order);
    }}

    public ArrayList<Items> checkInventory(Map countItems){
        ArrayList<Items> waitorder= new ArrayList<Items>();
        for (Map.Entry<Items, Integer> entry : countItems.entrySet()){
            if (entry.getValue() == 0){
                waitorder.add(entry.getKey());

            }
        }
//        inventory.forEach((itemType, amount) -> {
//            if (amount.equals(0) = Ture){
//            }
//        });

        return waitorder;
    }

    public void placeAnOrder(ArrayList<Items> waitorder, Order order){

        for(Items items: waitorder) {
            order.orderItems(items);
        }
    }
    public void openStore(){



    };

    public int bidToSeller(Items items){
        int itemprice=0;
        /*

            the seller give the item to the staff and the staff
            demonstrate the price based on the condition of the item

         */

        return itemprice;
    }

    public void checkWithSeller(Seller seller,double price,Register reg, Inventory inventory){
        if(seller.getSellOrNot()=true){
            reg.deductmoney(seller.itemsWantToSell.getPurchasePrice);
            inventory.updateStock(items);
        }else{
            price=price*1.1;
            if(seller.getSellOrNotWithHigerPrice()=true){
                reg.deductmoney(seller.itemsWantToSell.getPurchasePrice);
                inventory.updateStock(items);

            }else{
                pass;

            }

        }


}
    public void checkWithBuyer(Buyer buyer,Register reg, Inventory inventory,  Store store){
        buyitem=buyer.itemsWanttoBuy;
        if (buyer.buyOrNot= true){
            reg.deductmoney(buyitem.getSalePrice);
            inventory.removeItems(buyitem);
            store.addSoldItem(buyitem);

        }else{
            buyitem.setSalePrice(buyitem.getSalePrice()*0.9);
            if(buyer.getBuyNotWithLowerPrice()=true){

                reg.deductmoney(buyitem.getSalePrice);
                inventory.removeItems(buyitem);
                store.addSoldItem(buyitem);


            }else{

                System.out.format("%String doestn't buy anything and leave",buyer.name);
            }



        }
    }

    public void cleanStore(Inventory inventory){
        int index =(int)(Math.random()*inventory.itemList.size());

        Items destoryeditem = inventory.itemList.get(index);
        Random random=new Random();
        int prob=random.nextInt(100);
        if(prob<5){
            destoryeditem.setCondition(destoryeditem.getCondition()-1);
            destoryeditem.setListPrice((int)(destoryeditem.getListPrice*0.8));
            if (destoryeditem.getCondition=0){
                inventory.removeItems(destoryeditem);


            }else{
                pass;


            }
        }




    }



}

