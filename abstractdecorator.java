import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
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
          /* Decorator
          get the original list, and check the stock based on the probability and the electric property
          if the addition is at stock, add to the original list.
           */
          ArrayList<Items> originalitems=this.inventory.Getitemstosell(buyitemtype);
          //get the original list
          boolean whetherstring = false;
          Random random=new Random();
          int threshold=10;
          int chance= random.nextInt(101);
          if (originalitems!=null) {
               Items originalitem=originalitems.get(0);
//
               // confirm that the buyer want to buy a stringed instruments and it in the stock,then get the eletric
          if (originalitem.getClass().getSuperclass().getName().contains("Stringed")) {
               // using forced type conversion to get the electric field
               whetherstring = true;
               Stringed stringedinstrument= (Stringed) originalitem;
               if(stringedinstrument.getElectric()){
                    threshold+=10;// if so, then the probability increase
               }
          }


               if (whetherstring & chance <= threshold) {
                    // if stringed in list
//               System.out.println(this.inventory.itemsList);
                    for (Items item : this.inventory.getItemsList()) {
                         // check the stock and add the item to the list
                         if (Objects.equals(item.getItemType(), "Gigbag")) {
                              originalitems.add(item);
                              System.out.println("add one gigbag additionally into the cart");
                              break;
                         }

                    }
               }
//               System.out.println(originalitems);
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

class addPracticeAmp extends abstractdecorator{
     Inventory inventory;
     public addPracticeAmp(Inventory inventory){
          this.inventory=inventory;

//          System.out.println(this.inventory.);


     }
     public ArrayList<Items> Getitemstosell(String buyitemtype){

          ArrayList<Items> originalitems=this.inventory.Getitemstosell(buyitemtype);
          boolean whetherstring = false;
          Random random=new Random();
          int threshold=15;
          int chance= random.nextInt(101);
          if (originalitems!=null){
               Items originalitem=originalitems.get(0);
//               boolean electric=false;
               // confirm that the buyer want to buy a stringed instruments and it in the stock,then get the eletric
               if (originalitem.getClass().getSuperclass().getName().contains("Stringed")) {

                    whetherstring = true;
                    Stringed stringedinstrument= (Stringed) originalitem;
                    if(stringedinstrument.getElectric()){
                         threshold+=10;
                    }
               }
          if(whetherstring&chance <=threshold){
//               System.out.println(this.inventory.itemsList);
               for(Items item:this.inventory.getItemsList()){
                    if(Objects.equals(item.getItemType(), "PracticeAmps")){
                         originalitems.add(item);
                         System.out.println("add a practiceamp additionally into a cart");
                         break;
                    }

               }}

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
class addCables extends abstractdecorator{
     Inventory inventory;

     public addCables(Inventory inventory){
          this.inventory=inventory;

//          System.out.println(this.inventory.);


     }
     public ArrayList<Items> Getitemstosell(String buyitemtype){

          ArrayList<Items> originalitems=this.inventory.Getitemstosell(buyitemtype);
          boolean whetherstring = false;
          Random random=new Random();
          int num=random.nextInt(2)+1;
          int chance= random.nextInt(101);
          int threshold=20;
          if (originalitems!=null){
                 Items originalitem=originalitems.get(0);
                    if(originalitem.getClass().getSuperclass().getName().contains("Stringed")){

                         whetherstring=true;
                         Stringed stringeditem=(Stringed)originalitem;
                         if(stringeditem.getElectric()){
                              threshold+=10;
                         };
                    }
               }
          if(whetherstring&chance <=threshold){
//               System.out.println(this.inventory.itemsList);
               for(Items item:this.inventory.getItemsList()){
                    if(Objects.equals(item.getItemType(), "Cables")){
                         originalitems.add(item);
                         System.out.println("add a cables additionally into the cart");
                         num-=1;
                         if (num==0){
                         break;}

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
class addStrings extends abstractdecorator{
     Inventory inventory;

     public addStrings(Inventory inventory){
          this.inventory=inventory;

//          System.out.println(this.inventory.);


     }
     public ArrayList<Items> Getitemstosell(String buyitemtype){

          ArrayList<Items> originalitems=this.inventory.Getitemstosell(buyitemtype);
          boolean whetherstring = false;
          Random random=new Random();
          int num=random.nextInt(3)+1;
          int chance= random.nextInt(101);
          int threshold=30;
          if (originalitems!=null){
               Items originalitem=originalitems.get(0);
                    if(originalitem.getClass().getSuperclass().getName().contains("Stringed")){

                         whetherstring=true;
                         Stringed stringeditem=(Stringed)originalitem;
                         if(stringeditem.getElectric()){
                              threshold+=10;
                         };
                    }
               }
          if(whetherstring&chance <=threshold){
//               System.out.println(this.inventory.itemsList);
               for(Items item:this.inventory.getItemsList()){
                    if(Objects.equals(item.getItemType(), "Strings")){
                         originalitems.add(item);
                         System.out.println("add a Strings additionally into the cart");
                         num-=1;
                         if (num==0){
                              break;}
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
