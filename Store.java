import java.util.ArrayList;
import java.util.Random;
import java.util.Random.*;

// the Store object remain the same around 30 days
public class Store {
    private int days; //get the today is what day
    private ArrayList<Items>soldList;// all items that have been sold;
    private ArrayList<Items>outOfStocklist;// the items that has been sold out, it will clean each day
    Staff todayStaff; // who is the today's clerk

    public Store(){
        this.soldList=new ArrayList<Items>();
        this.outOfStocklist=new ArrayList<Items>();
            }

    public int getDays(){
        // get today, and increase the date
        int today=this.days;

        return  today;
    }

    public void nextDay(){

        this.days+=1;

    }
    public ArrayList getSoldList(){
        return this.soldList;


    }

//    public void getnostock(Inventory inventory){
//
//        this.outOfStocklist=inventory.checkstock();
//
//    };
    public void addSoldItem(Items item){
        //record what item has been sold
        this.soldList.add(item);


    }
    /*

    select today's staff
    if a keeps working

     */
    public void selectStaff(Staff a, Staff b){
        if(a.getCwd()==3){
            this.todayStaff=b;
            b.addCwd();
            a.cleanCwd();
        }
        else if(b.getCwd()==3){

            this.todayStaff=a;
            a.addCwd();
            b.cleanCwd();

        }
        else{

            // select one from two  https://www.coder.work/article/867957
            Random random =new Random();
            todayStaff= random.nextBoolean()?a:b;
            if (todayStaff==a){
                a.addCwd();
                b.cleanCwd();

            }
            else{
                b.addCwd();
                a.cleanCwd();
            }

        }



    }

        public void removeItem(){

        this.outOfStocklist.clear();

        }

}
