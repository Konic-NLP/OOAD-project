import java.util.Iterator;
import java.util.Map;


public class Customer {

    private String name;

}

class Buyer extends Customer{

    private Items itemWantToBuy;
    private boolean buyOrNot;
    private boolean buyOrNotWithHigherPrice;

    // check if the store inventory has the item that the customer want to buy
    public boolean checkItemsInStore(Map countItems){

        Iterator countItemsIterator = countItems.entrySet().iterator();

        while(countItemsIterator.hasNext()){

            Map.Entry mapElement = (Map.Entry)countItemsIterator.next();

            if ((int)mapElement.getValue() == 0){
                return false;
            }else{
                return true;
            }
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

        if (Math.random() < 0.5){
            return true;
        }else{
            return false;
        }
    }

    public boolean getBuyOrNotWithHigherPrice(){

        if (Math.random() < 0.75){
            return true;
        }else{
            return false;
        }
    }
}

class Seller extends Customer{

    private Items itemWantToSell;
    private boolean sellOrNot;
    private boolean sellOrNotWithHigherPrice;

    public boolean getSellOrNot(){

        if (Math.random() < 0.5){
            return true;
        }else{
            return false;
        }
    }

    public boolean getSellOrNotWithHigherPrice(){

        if (Math.random() < 0.75){
            return true;
        }else{
            return false;
        }
    }
}
