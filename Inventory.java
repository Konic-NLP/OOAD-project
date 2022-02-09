import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class Inventory {

    public ArrayList<Items> itemsList;

    HashMap<Items, Integer> countItems = new HashMap<Items, Integer>();

    public Inventory(){

        this.countItems = new HashMap<Items, Integer>();

    }

    // calculate the total purchase price of the items in the store inventory
    public int getTotalValue(ArrayList<Items> itemsList){
        int totalValue = 0;
        for (Items items: itemsList){

            totalValue += items.purchasePrice;
        }

        return totalValue;
    }

//    public void checkStock(){
//
//    }

    // add new items into store inventory
    public void updateStock(Items items){

        this.itemsList.add(items);
        this.countItems.put(items,this.countItems.get(items)+1);

    }

    // remove item from store inventory
    public void removeItems(Items items){

        this.itemsList.remove(items);
        this.countItems.put(items,this.countItems.get(items)-1);

    }

    // method to randomly choose a lucky item which might be damaged by clerk.
//    public Items randomItem(ArrayList<Items> itemsList){
//
//        int index = (int)(Math.random() * itemsList.size());
//        Items luckyItem = itemsList.get(index);
//
//        return luckyItem;
//    }
}
