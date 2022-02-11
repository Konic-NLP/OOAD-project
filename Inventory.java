import java.lang.reflect.Constructor;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Inventory {

    public ArrayList<Items> itemsList=new ArrayList<Items>(); //record the stock

    public HashMap<Class, Integer> countItems = new HashMap<Class, Integer>();  // record the itemtype and correspondent number


//    public ArrayList<Items> returnList(){
//
//        ArrayList<Items> itemlist =  Collections.unmodifiableList(itemsList);
//
//
//    }

    public Inventory(){

        this.countItems = new HashMap<Class, Integer>();
//        String[] typeList = {"PaperScore", "MusicCD", "Vinyl", "PlayerCD", "RecordPlayer", "MP3"
//                , "Guitar", "Bass", "Mandolin", "Flute", "Harmonica", "Hats", "Shirts", "Bandanas"
//                , "PracticeAmps", "Cables", "Strings"};
////        for(String string:typeList){
//            Items items=new string();
//            this.countItems.put(,1);
//        }
//        this.countItems.put(items,1);

    }

    // calculate the total purchase price of the items in the store inventory= total value
    public int getTotalValue(){
        int totalValue = 0;
        for (Items items: this.itemsList){

            totalValue += items.purchasePrice;
        }

        return totalValue;
    }

    public ArrayList<Items> checkStock(Order order,Store store) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        ArrayList<Items> waitorder= new ArrayList<Items>();// get the items that may need to restock
        for (Map.Entry<Class,Integer> entry : this.countItems.entrySet()){
            /*get the itemtype that has been ordered to avoid order repeatly.
             https://www.codegrepper.com/code-examples/java/java+stream+get+list+of+one+field

             */
            List<Class> namelist= order.getorderlist().stream().map(Items::getClass).collect(Collectors.toList());

            // stock =0 and this has not been ordered in orderlist.
            if (entry.getValue() ==0 & !namelist.contains(entry.getKey())){
                /* use reflect meachanism in java to instantiate object from a "class"
                https://techvidvan.com/tutorials/java-object-creation/
                 */
                Items newitem= (Items) entry.getKey().newInstance();
//                System.out.println(newitem);

                waitorder.add(newitem);

    }}

        return waitorder;
    }

    // add new items into store inventory
    public void updateStock(Items items){

        this.itemsList.add(items);
//        if(items.getClass()==null){
//            System.out.println(items.getItemType()+items.getName());
//        };
        // avoid the keyError
        try{   // catch the exception if there exists more chance to invoke exception
        if(this.countItems.containsKey(items.getClass())){
            this.countItems.put(items.getClass(),this.countItems.get(items.getClass())+1);

        }else{
            this.countItems.put(items.getClass(),1);

        }


    }catch (Exception e){System.out.println(items+"this is");
                e.printStackTrace();}}

    // remove item from store inventory
    public void removeItems(Items items){

        this.itemsList.remove(items);
        this.countItems.put(items.getClass(),this.countItems.get(items.getClass())-1);

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
