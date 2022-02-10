import java.util.*;


public class Customer {

    private String name;

}

class Buyer extends Customer{

    private String itemWantToBuy;
    private boolean buyOrNot;
    private boolean buyOrNotWithHigherPrice;

    public String getItemWantToBuy(){
        return this.itemWantToBuy;
    }

    public boolean getBuyOrNot(){
        return this.buyOrNot;
    }

    public boolean getBuyOrNotWithHigherPrice(){
        return this.buyOrNotWithHigherPrice;
    }


    // Check if the store inventory has the item that the customer want to buy.
    // If the inventory does not have the item, the buyer will leave directly.
    public boolean checkItemsInStore(Inventory inventory){

        String[] typeList = {"PaperScore", "MusicCD", "Vinyl", "PlayerCD", "RecordPlayer", "MP3"
                , "Guitar", "Bass", "Mandolin", "Flute", "Harmonica", "Hats", "Shirts", "Bandanas"
                , "PracticeAmps", "Cables", "Strings"};

        String itemName = typeList[new Random().nextInt(typeList.length)];


        return (inventory.countItems.get(itemName)!=0);



//        List<Items> keyAsArray = new ArrayList<Items>(inventory.countItems.keySet());

//        Random r = new Random();
//
//        Items item = (Items)keyAsArray.get(r.nextInt(keyAsArray.size()));
//
//        return itemName.equals(item.getName());
//        Iterator countItemsIterator = countItems.entrySet().iterator();
//
//        while(countItemsIterator.hasNext()){
//
//            Map.Entry mapElement = (Map.Entry)countItemsIterator.next();
//
//            return (int) mapElement.getValue() != 0;
//        }
//        for (Map.Entry<Items, Integer> entry : countItems.entrySet()){
//            if (entry.getValue() == 0){
//                return false;
//            }else{
//                return true;
//            }
//        };
    }

    public boolean getbuyOrNot(){

        return Math.random() < 0.5;
    }

    public boolean getbuyOrNotWithHigherPrice(){

        return Math.random() < 0.75;
    }
}

class Seller extends Customer{

    private Items itemWantToSell;
    private boolean sellOrNot;
    private boolean sellOrNotWithHigherPrice;

    public Items initialize(Store store){

        itemWantToSell.initialize_main(store.getDays());
        itemWantToSell.initialize_price();
        return itemWantToSell;
    }

    public Items getItemsWantToSell(){
        return this.itemWantToSell;
    }

    public boolean getsellOrNot(){

        return Math.random() < 0.5;
    }

    public boolean getsellOrNotWithHigherPrice(){

        return Math.random() < 0.75;
    }
}
