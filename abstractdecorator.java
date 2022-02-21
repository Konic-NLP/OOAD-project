import java.util.ArrayList;
import java.util.Collections;

public abstract class abstractdecorator extends abstractInventory {

}
class addgigbag extends abstractdecorator{
     abstractInventory inventory;
     public addgigbag(abstractInventory inventory){
          this.inventory=inventory;


     }
     public ArrayList<Items> Getitemstosell(String buyitemtype){
          ArrayList<Items> originalitems=this.inventory.Getitemstosell(buyitemtype);
          boolean whetherstring = false;
          for(Items item:originalitems){
               if(item.getClass().getName().contains("Stringed")){
                    whetherstring=true;
               }
          }
          if(whetherstring){
               for(Items item:this.inventory.itemsList){
                    if(item.getItemType()=="Gigbag"){
                         originalitems.add(item);
                         break;
                    }

               }
               return originalitems;

               }
          return originalitems;
          }


     public ArrayList<Items> checkStock(Order order) throws InstantiationException, IllegalAccessException{
          return this.inventory.checkStock(order);

     };
     public void updateStock(Items items){
          this.inventory.updateStock(items);
     };
     public void removeItems(Items items){

          this.inventory.removeItems(items);
     };
     public Items randomItem(){
          return this.inventory.randomItem();
     };
     public boolean queryClothingStock(){
          return this.inventory.queryClothingStock();

     };



}
