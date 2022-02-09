import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class Staff {
    private String name;
    private int cwd;// to represent 'consecutiveworkdays' althought it may mix with current work directory :)
    private float damageChance;
    private int workDays = 0;

    public int addWorkDays() {

        this.workDays += 1;
        return workDays;
    }

    public void arriveAtStore(){

    }

    public void checkRegister(Register register){

        if (register.getMoneysum() < 75) {

            goToBank();
        }
    }

    public void goToBank(Register register){

        register.addmoney();
    }

    public void doInventory(Inventory inventory){

        System.out.println("The total value of all the items in the store is " + inventory.getTotalValue());

    }

    public void checkInventory(Map countItems, ArrayList<Items> outOfStockList){

        Iterator countItemsIterator = countItems.entrySet().iterator();

        while (countItemsIterator.hasNext()){

            Map.Entry mapElement = (Map.Entry)countItemsIterator.next();

            if ((int)mapElement.getValue() == 0){
                outOfStockList.add((Items) mapElement.getKey());
            }
        }
//        for (Map.Entry<Items, Integer> entry : countItems.entrySet()){
//            if (entry.getValue() == 0){
//                outOfStockList.add(entry.getKey());
//                placeAnOrder();
//            }
//        }

//        inventory.forEach((itemType, amount) -> {
//            if (amount.equals(0) = Ture){
//            }
//        });
    }

    public void placeAnOrder(ArrayList<Items> outOfStockList, ArrayList<Items> orderList, Store store){

        for(Items items: outOfStockList) {
            orderList.add(items);
        }

        store.removeItem();
    }
}
