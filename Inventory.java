import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class Inventory {

    private ArrayList<Items> itemsList;
    private int totalValue = 0;
    HashMap<Items, Integer> countItems = new HashMap<>();

    public void CountItems(){

        this.countItems = new HashMap<Items, Integer>();

    }

    // calculate the total purchase price of the items in the store inventory
    public int getTotalValue(ArrayList<Items> itemsList){

        for (Items items: itemsList){

            totalValue += items.purchasePrice;
        }

        return totalValue;
    }

//    public void checkStock(){
//
//    }

    // add new items into store inventory
    public void updateStock(ArrayList<Items> itemsList, Items items){

        itemsList.add(items);
    }

    // remove item from store inventory
    public void removeItems(ArrayList<Items> itemsList, Items items){

        itemsList.remove(items);
    }

    // method to randomly choose a lucky item which might be damaged by clerk.
    public Items randomItem(ArrayList<Items> itemsList){

        int index = (int)(Math.random() * itemsList.size());
        Items luckyItem = itemsList.get(index);

        return luckyItem;
    }

    public toString(){

    }
}
