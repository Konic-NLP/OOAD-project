import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public abstract class abstractdecorator extends Inventory {

}
class addgigbag extends abstractdecorator{
     Inventory inventory;
     public addgigbag(Inventory inventory){
          this.inventory=inventory;

//          System.out.println(this.inventory.);


     }
     public ArrayList<Items> Getitemstosell(String buyitemtype){

          ArrayList<Items> originalitems=this.inventory.Getitemstosell(buyitemtype);
          boolean whetherstring = false;
          Random random= new Random();
          int chance=random.nextInt(101);
          if (originalitems!=null){
          for(Items item:originalitems){
               if(item.getClass().getSuperclass().getName().contains("Stringed")){
                    System.out.println("*******************************");
                    whetherstring=true;
               }
          }}
          if(whetherstring&chance<20){
//               System.out.println(this.inventory.itemsList);
               for(Items item:this.inventory.getItemsList()){
                    if(item.getItemType()=="MusicCD"){
                         originalitems.add(item);
                         System.out.println(originalitems);
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

     @Override
     public ArrayList<Items> getItemsList() {
          return this.inventory.getItemsList();
     }
}
