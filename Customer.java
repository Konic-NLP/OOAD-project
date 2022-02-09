import java.util.Iterator;
import java.util.Map;


public class Customer {

    private String name;

}

class Buyer extends Customer{

    private String itemWantToBuy;
    private boolean buyOrNot;
    private boolean buyOrNotWithHigherPrice;

    // check if the store inventory has the item that the customer want to buy
    public boolean checkItemsInStore(Map countItems){

        Iterator countItemsIterator = countItems.entrySet().iterator();

        while(countItemsIterator.hasNext()){

            Map.Entry mapElement = (Map.Entry)countItemsIterator.next();

            return (int) mapElement.getValue() != 0;
        }
//        for (Map.Entry<Items, Integer> entry : countItems.entrySet()){
//            if (entry.getValue() == 0){
//                return false;
//            }else{
//                return true;
//            }
//        };
    }

    public boolean getBuyOrNot(){

        return Math.random() < 0.5;
    }

    public boolean getBuyOrNotWithHigherPrice(){

        return Math.random() < 0.75;
    }
}

class Seller extends Customer{

    private Items itemWantToSell;
    private boolean sellOrNot;
    private boolean sellOrNotWithHigherPrice;

    public boolean getSellOrNot(){

        return Math.random() < 0.5;
    }

    public boolean getSellOrNotWithHigherPrice(){

        return Math.random() < 0.75;
    }
}
