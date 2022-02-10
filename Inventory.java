import java.util.*;
import java.io.*;

public class Inventory {

    public ArrayList<Items> itemsList=new ArrayList<Items>();

    public HashMap<Items, Integer> countItems = new HashMap<Items, Integer>();


//    public ArrayList<Items> returnList(){
//
//        ArrayList<Items> itemlist =  Collections.unmodifiableList(itemsList);
//
//
//    }

    public Inventory(){

        this.countItems = new HashMap<Items, Integer>();

    }

    // calculate the total purchase price of the items in the store inventory
    public int getTotalValue(){
        int totalValue = 0;
        for (Items items: this.itemsList){

            totalValue += items.purchasePrice;
        }

        return totalValue;
    }

    public ArrayList<Items> checkStock(Order order,Store store){

        ArrayList<Items> waitorder= new ArrayList<Items>();
        for (Map.Entry<Items,Integer> entry : this.countItems.entrySet()){
            // stock =0 and this has not been ordered in orderlist.
            if (entry.getValue() == 0 & !order.getorderlist().contains(entry.getKey())){
                Items newitem=entry.getKey();
                newitem.initialize_main(store.getDays());
                newitem.initialize_price();
                waitorder.add(newitem);

    }}
        return waitorder;
    }

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

    public int getItemslistSize(){

        return this.itemsList.size();

    }

    // method to randomly choose a lucky item which might be damaged by clerk.
    public Items randomItem(){

        int index = (int)(Math.random() * this.itemsList.size());
        Items luckyItem = this.itemsList.get(index);

        return luckyItem;
    }
}
