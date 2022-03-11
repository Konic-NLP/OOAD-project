import java.io.Console;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public interface Command {
    public void execute() throws IOException;

}

/*
each command just hold a store object as the receiver

 */

// get the name of the staff at the corresponding store.
class clerkCommand implements Command{
    Store store;
    public clerkCommand(Store store){
        this.store=store;

    }
    public void execute(){
        System.out.println(this.store.todayStaff.getName());

    }


}

// get the current system time using simpleDate package and data package https://www.yisu.com/zixun/200579.html
class timeCommand implements Command{
    Store store;
    public timeCommand(Store store){
        this.store=store;

    }
    public void execute(){
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");
        Date date = new Date();// 获取当前时间
        System.out.println("Right now is ：" + sdf.format(date));

    }


}
// buy an item from the store based on the command input
class buyCommand implements  Command{
   Store store;
    Scanner scanner=new Scanner(System.in);
    public buyCommand(Store store){

        this.store=store;
    }
    public void execute() throws IOException {
        System.out.println("please input your items want to buy");
        String buyitemtype=scanner.next();
//        ArrayList<Items> buyitems=this.store.inventory.Getitemstosell( scanner.next());
        Inventory inventory1= new addgigbag(this.store.inventory);
        inventory1=new addCables(inventory1);
        inventory1=new addPracticeAmp(inventory1);
        inventory1=new addStrings(inventory1);
        ArrayList<Items> buyitems=inventory1.Getitemstosell(buyitemtype);
        if(buyitems ==null){
        System.out.println("Sorry, we currently out of stock for such items");
    }else{
        System.out.println("Would you want to buy?");
        String answer1=scanner.next();
        if (Objects.equals(answer1, "Y")){
            int sum=0;
            if(buyitems.size()>1){System.out.println("additional sold items:" +Helper.mergeString(new ArrayList<Items>(buyitems.subList(1,buyitems.size()))));}
            for(Items items:buyitems){

                this.store.todayStaff.sellitem(items,store,items.getListPrice());
                sum+=items.getListPrice();

            }

            // operation: update the inventory, deduct the money from the register, change the saleprice, add record
            // to the soldlist
//

            this.store.getPublisher().notifyObservers(8,this.store.getCode(),this.store.todayStaff.getName(),buyitems.size());
            System.out.format("openStore: %s sold a %s to CommandUser  for  %d  %n",store.todayStaff.getName(),Helper.mergeString(buyitems),sum);

        }else{
            System.out.println("We can give you a 10% discount, would you want to buy ?  1 for yes ,2 for No" );
            int answer2= scanner.nextInt();
            if (answer2==1){
                int discountprice=(int)(buyitems.get(0).getListPrice()*0.9);
                int sum=0;
                if(buyitems.size()>1){System.out.println("additional sold items:" +Helper.mergeString(new ArrayList<Items>(buyitems.subList(1,buyitems.size()))));}
                for(Items items:buyitems){

                    this.store.todayStaff.sellitem(items,store,discountprice);
                    sum+=items.getSalePrice();

                }

                // operation: update the inventory, deduct the money from the register, change the saleprice, add record
                // to the soldlist
//

                this.store.getPublisher().notifyObservers(8,this.store.getCode(),this.store.todayStaff.getName(),buyitems.size());
                System.out.format("openStore: %s sold a %s to CommandUser  for  %d  %n",store.todayStaff.getName(),Helper.mergeString(buyitems),sum);
        }else{

                System.out.println("No problem, please have a look at other items");

            }

        }
    }


}}
// sell an item to the store and the item created by the method not by the command line and the user just
//decide whether to sell or not
class SellCommand implements Command{
    Scanner scanner=new Scanner(System.in);
    Store store;
    public SellCommand(Store store){
        this.store=store;

    };

    public void execute() throws IOException {
        Items selleritems=Classpicker.MakeRandomInstance();
        selleritems.setPurchasePrice(selleritems.getCondition() * Helper.random_number(10, 1));
        int purchaseprice=selleritems.getPurchasePrice();
        //get the price based on the condition
        if(selleritems.getClass().getSuperclass().getName().contains("Clothing") & store.inventory.queryClothingStock()){
            // once any subtype of clothing was sold out, the store will not buy clothing from sellers anymore.
            System.out.println("we don't buy any Clothing from the seller due to the stock issues");}

        else{
            System.out.println("Do you want to sell this items?   Y/N");
            String answer1= scanner.next();
            if(Objects.equals(answer1, "Y")){
                this.store.register.deductmoney(purchaseprice);// buy the item from the register
//            selleritems.setSalePrice(purchaseprice);
                store.inventory.updateStock(selleritems);// add the item to the inventory
                String condition= Items.getConditionList()[(int)(selleritems.getCondition())];// get the condition

                this.store.getPublisher().notifyObservers(9,this.store.getCode(),this.store.todayStaff.getName(),1);
                System.out.format("OpenStore: %s bought a %s %s %s from %s for %d %n",this.store.todayStaff.getName(),
                        condition,
                        selleritems.getNewOrUsed(),
                        selleritems.getItemType(),
                        "CommandUser",
                        purchaseprice);


            }else{
                System.out.println("Do you want to sell this item if I increase the 10% price? Y/N ");
                String answer2= scanner.next();
                if(Objects.equals(answer2, "Y")){
                purchaseprice=(int)(purchaseprice*1.1);
                this.store.register.deductmoney(purchaseprice);
                this.store.inventory.updateStock(selleritems);
                String condition= Items.getConditionList()[(int)(selleritems.getCondition())-1];
                    this.store.getPublisher().notifyObservers(9,this.store.getCode(),this.store.todayStaff.getName(),1);
                System.out.format("openStore: %s bought a %s %s %s from %s for %d  %n",this.store.todayStaff.getName(),//staff's name
                        condition,  //condition
                        selleritems.getNewOrUsed(), // new or old
                        selleritems.getItemType(),  // the type of the item
                        "CommandUser",     //the name of the seller
                        purchaseprice);




            }else{System.out.println("No worries, welcome to come here next time"); }




        }



    }





    }




}

/* buy a guitar kit from the store and the guitarkit is created by the abstract factory, the choice for each product type
is created randomly*/
class guitaCommand implements Command{
    Store store;
    Scanner scanner;
    public guitaCommand(Store store){

    this.store=store;
    this.scanner=new Scanner(System.in);
    }

    @Override
    public void execute() {
     // call the method of the store and get the guitar kit
     System.out.println("please input your choice(0-2) for each elements of the Guitar kit and seperate by space");
     String [] input=scanner.nextLine().split(" ");
     int[] nums= Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
     // get the choice from the command line user

        /*
        randomly generate the choice for each of the elements.
         */
//        int [] nums=new int[6];
//        for(int i=0;i<6;i++){
//            int num=Helper.random_number(3,0);
//            nums[i]=num;
//        }
     GuitarKit guitarKit=this.store.CreateGuitarKit(nums);
     int saleprice=guitarKit.getSumPrice();

     guitarKit.setSalePrice(saleprice);
     store.addSoldItem(guitarKit);
     store.register.addmoney(saleprice);
     System.out.println("Thanks for your purchase, enjoy the guitar");
        System.out.format("openStore: %s sold a %s to CommandUser  for  %d  %n",store.todayStaff.getName(),"GuitarKit",saleprice);
    }}




//
//}

