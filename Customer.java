import java.util.*;


public class Customer {

    private String name;

    public String getName(){
        return this.name;
    }

}

class Buyer extends Customer{

    private String name = Helper.random_name("Buyer");

    private String itemWantToBuy;
    private boolean buyOrNot;
    private boolean buyOrNotWithHigherPrice;
    @Override
    public String getName(){

        return this.name;
    }
    public String randomItemWantToBuy(){
        String[] typeList = {"PaperScore", "MusicCD", "Vinyl", "PlayerCD", "RecordPlayer", "MP3"
                , "Guitar", "Bass", "Mandolin", "Flute", "Harmonica", "Hats", "Shirts", "Bandanas"
                , "PracticeAmps", "Cables", "Strings"};

        String itemName = typeList[new Random().nextInt(typeList.length)];
        return itemName;
    }
    public String getItemWantToBuy(){
        return this.randomItemWantToBuy();
    }
//
//    public boolean getBuyOrNot(){
//        return this.buyOrNot;
//    }

//    public boolean getBuyOrNotWithHigherPrice(){
//        return this.buyOrNotWithHigherPrice;
//    }


    // Check if the store inventory has the item that the customer want to buy.
    // If the inventory does not have the item, the buyer will leave directly.
    public boolean checkItemsInStore(Inventory inventory){

//        String[] typeList = {"PaperScore", "MusicCD", "Vinyl", "PlayerCD", "RecordPlayer", "MP3"
//                , "Guitar", "Bass", "Mandolin", "Flute", "Harmonica", "Hats", "Shirts", "Bandanas"
//                , "PracticeAmps", "Cables", "Strings"};
//
//        String itemName = typeList[new Random().nextInt(typeList.length)];
        String itemName = this.randomItemWantToBuy();
//        System.out.println(itemName);
//        if(inventory)

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

    public boolean getBuyOrNot(){

        double a= Math.random();
//        System.out.println(a);
        return a< 0.5;
    }

    public boolean getBuyOrNotWithHigherPrice(){

        double b= Math.random();
//        System.out.println(b);
        return b < 0.75;
    }
}


class Seller extends Customer{
    private String name = Helper.random_name("Seller");
    private Items itemWantToSell;
    private boolean sellOrNot;
    private boolean sellOrNotWithHigherPrice;
    @Override
    public String getName(){
        return this.name;

    }
//    public Items initialize(Store store){
//
//        itemWantToSell.initialize_main(store.getDays());
//        itemWantToSell.initialize_price();
//        return itemWantToSell;
//    }

    public Items getItemsWantToSell() {
        Items items = Classpicker.MakeRandomInstance();
        return items;

    }

    public boolean getsellOrNot(){
        double a= Math.random();
//        System.out.println(a);
        return a< 0.5;
    }

    public boolean getsellOrNotWithHigherPrice(){
        double b= Math.random();
//        System.out.println(b);
        return b < 0.75;
    }
}
