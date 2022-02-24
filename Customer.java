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
                , "PracticeAmps", "Cables", "Strings","Saxophone","Cassette","CassettePlayer","GigBag"};

        String itemName = typeList[new Random().nextInt(typeList.length)];
        return itemName;
    }
    public String getItemWantToBuy(){
        return this.randomItemWantToBuy();
    }

    // The below method is to check if the store inventory has the item that the customer want to buy.
    // If the inventory does not have the item, the buyer will leave directly.
    public boolean checkItemsInStore(concreteInventory inventory){
        
        String itemName = this.randomItemWantToBuy();
        return (inventory.countItems.get(itemName)!=0);
    }
    // The below method is to random chance if the buyer will buy the item or not.
    public boolean getBuyOrNot(ArrayList<Items> items,int threshold){
//        System.out.println(items.property);
        String[] words={"Wind","Stringed","Players"};
        //using stream justify a string whether include sevral substrings
        // : https://blog.csdn.net/neweastsun/article/details/108265666
        List<String> classlist=Arrays.asList(words);
        // detect the items whether belongs to the classes that have property, if so, look up the property and
        // get the corresponding chance and add it to the random chance
        List<String> classname=Arrays.asList(items.get(0).getClass().getSuperclass().getName().split("\\$"));
        int finalchance=0;
        Random random=new Random();
        int basicprob=random.nextInt(101);
        if (classlist.stream().anyMatch(classname::contains)){
            if (items.get(0).getProperty().getValue()){
            int chance=items.get(0).getProperty().getChance();

        finalchance= basicprob+chance;
        }
        else{
            finalchance=basicprob;
        }


    }
        return finalchance< threshold;

}}



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
    public boolean getsellOrNot(int threshold){
        Random random= new Random();
        int chance=random.nextInt(101);
        return chance< threshold;
    }


}
