import java.io.*;
import java.util.ArrayList;
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

        if (register.getMoney() < 75) {

            goToBank();
        }
    }

    public void goToBank(Register register){

        register.addMoney();
    }

    public void doInventory(Inventory inventory){

        System.out.println("The total value of all the items in the store is " + inventory.getTotalvalue());

    }

    public void checkInventory(Map countItems, Arraylist<items> outOfStockList){

        for (Map.Entry<items, Integer> entry : countItems.entrySet()){
            if (entry.getValue() == 0){
                outOfStockList.add(entry.getKey());
                placeAnOrder();
            }
        }
//        inventory.forEach((itemType, amount) -> {
//            if (amount.equals(0) = Ture){
//            }
//        });
    }

    public void placeAnOrder(Arraylist<items> outOfStockList, Arraylist<items> orderList, Store store){

        for(items items: outOfStockList) {
            orderList.add(items);
        }

        store.remove();
    }
}
