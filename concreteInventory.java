import java.lang.reflect.Constructor;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class concreteInventory extends Inventory {
    // justify whether one of the clothing subtype has been soldout;
    private boolean clothingsellout=false;
    public ArrayList<Items> itemsList=new ArrayList<Items>(); //to record the stock

    public HashMap<Class, Integer> countItems = new HashMap<Class, Integer>();  // to record the itemtype and correspondent number

    public concreteInventory(){

        this.countItems = new HashMap<Class, Integer>();

    }
    public ArrayList<Items> getItemsList(){
        return this.itemsList;
    }
    // to calculate the total purchase price of the items in the store inventory= total value



    // The below method is adapted and inspired from (1) https://www.codegrepper.com/code-examples/java/java+stream+get+list+of+one+field,
    // (2) and  https://techvidvan.com/tutorials/java-object-creation/
    public ArrayList<Items> checkStock(Order order) throws InstantiationException, IllegalAccessException {
        //update
        ArrayList<Items> waitorder= new ArrayList<Items>();// get the items that may need to restock
        for (Map.Entry<Class,Integer> entry : this.countItems.entrySet()){
            if(entry.getKey().getClass().getSuperclass().getName().contains("Clothing")){
                if (entry.getValue()==0| clothingsellout == true){
                    // once one kind of clothing was soldout, all kinds of clothing will soldout
                    this.countItems.remove(entry.getKey());
                    clothingsellout=true;
                }

            }
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

    // to add new items into store inventory
    public void updateStock(Items items){

        this.itemsList.add(items);
        // to avoid the keyError
        try{   // to catch the exception if there exists more chance to invoke exception
        if(this.countItems.containsKey(items.getClass())){
            this.countItems.put(items.getClass(),this.countItems.get(items.getClass())+1);

        }else{
            this.countItems.put(items.getClass(),1);

        }


    }catch (Exception e){System.out.println(items+"this is");
                e.printStackTrace();}}

    // to remove item from store inventory
    public void removeItems(Items items){

        this.itemsList.remove(items);
        this.countItems.put(items.getClass(),this.countItems.get(items.getClass())-1);

    }


    public int getItemslistSize(){

        return this.itemsList.size();

    }

    // to randomly choose a lucky item which might be damaged by clerk.
    public Items randomItem(){
        int index = (int)(Math.random() * this.itemsList.size());
        Items luckyItem = this.itemsList.get(index);
        return luckyItem;
    }
    public boolean queryClothingStock(){
        return  this.clothingsellout;

    }
    public ArrayList<Items> Getitemstosell(String buyitemtype) {
//        String buyitemtype = buyer.getItemWantToBuy();
        ArrayList<Items> buyitems=new ArrayList<>();
        ArrayList<Items> itemsforbuy = new ArrayList<Items>();
        // get all the items in the inventory that belongs to the specific itemtypes
        for (Items items : this.itemsList) {//polymorphic I don't care about the what's the specific type of the items

            if (items.getItemType().equals(buyitemtype)) {//identity
                itemsforbuy.add(items);

            }

        }
        // if there is no items that qualified the buyer's expectation
        Items buyitem;
        if (itemsforbuy.size() == 0) {

            return null;

        } else {
            Collections.shuffle(itemsforbuy); // use shuffle to simulate select randomly
            buyitems.add( itemsforbuy.get(0));

            return buyitems;
        }

    }}
