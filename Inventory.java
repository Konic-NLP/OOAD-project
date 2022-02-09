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

    public int getTotalValue(ArrayList<Items> itemsList){

        for (int i = 0; i < itemsList.size(); i++){

            totalValue += items.purchasePrice;
        }

        return totalValue;
    }

    public void checkStock(){

    }

    public void updateStock(ArrayList<Items> itemsList, Items items){

        itemsList.add(items);
    }

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
