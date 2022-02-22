import java.util.ArrayList;

public abstract class Inventory {
//    public ArrayList<Items> itemsList;
    abstract ArrayList<Items> Getitemstosell(String buyitemtype);
    abstract public ArrayList<Items> checkStock(Order order) throws InstantiationException, IllegalAccessException;
    abstract public void updateStock(Items items);
    public abstract void removeItems(Items items);
    public abstract Items randomItem();
    public abstract boolean queryClothingStock();
    public abstract ArrayList<Items> getItemsList();
}
