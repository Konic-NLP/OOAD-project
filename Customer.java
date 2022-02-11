import java.util.*;


abstract class Customer {

    private String name;
    public String getName(){return this.name;}
    
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
    
    // The below method is to random pick a string representing sublcass in the subclass list.
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

    // The below method is to check if the store inventory has the item that the customer want to buy.
    // If the inventory does not have the item, the buyer will leave directly.
    public boolean checkItemsInStore(Inventory inventory){
        
        String itemName = this.randomItemWantToBuy();
        return (inventory.countItems.get(itemName)!=0);
    }
    // The below method is to random chance if the buyer will buy the item or not.
    public boolean getBuyOrNot(){
        double a= Math.random();
        return a< 0.5;
    }

    public boolean getBuyOrNotWithHigherPrice(){
        double b= Math.random();
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

    //The below method is to call the MakeRandomInstance method to create an object of random subclass in items.
    public Items getItemsWantToSell() {
        Items items = Classpicker.MakeRandomInstance();
        return items;
    }

    //The blow method is to random chance if the seller will sell his item to the store or not.
    public boolean getsellOrNot(){
        double a= Math.random();
        return a< 0.5;
    }

    public boolean getsellOrNotWithHigherPrice(){
        double b= Math.random();
        return b < 0.75;
    }
}
