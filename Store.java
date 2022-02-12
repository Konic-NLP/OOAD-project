import java.util.ArrayList;
import java.util.Random;
import java.util.Random.*;

// the Store object remain the same around 30 days
public class Store {
    private int days; //get the today is what day
    private ArrayList<Items>soldList;// all items that have been sold;
    private ArrayList<Items>outOfdo_stocklist;// the items that has been sold out, it will clean each day
    Staff todayStaff; // who is the today's clerk

    public Store(){
        this.soldList=new ArrayList<Items>();
        this.outOfdo_stocklist=new ArrayList<Items>();
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
    public Seller[] createSellers(){
        Random random= new Random();
        int num= random.nextInt((10-4)+1)+4;
        Seller[] sellers= new Seller[num];
        for(int i=0;i<sellers.length;i++){
            sellers[i]=new Seller();
        }
        return sellers;
    }

    public Buyer[] createBuyers(){
        Random random= new Random();
        int num= random.nextInt((10-4)+1)+4;
        Buyer[] buyers=new Buyer[num];
        for(int i=0;i<buyers.length;i++){
            buyers[i]=new Buyer();
        }
        return buyers;

    }

    public void addSoldItem(Items item){
        //record what item has been sold
        item.setDaySold(days);
        this.soldList.add(item);


    }
    /*

    select today's staff
    if a keeps working

     */
    public Staff selectStaff(Staff a, Staff b){
        if(a.getCwd()==2){
            this.todayStaff=b;
            b.addCwd();
            a.cleanCwd();
        }
        else if(b.getCwd()==2){

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
    System.out.format("%s arrives at store at day %d  %n",todayStaff.getName(),days);

    return todayStaff;
    }

        public void removeItem(){

        this.outOfdo_stocklist.clear();

        }
        public ArrayList<Items> do_stock(){
            ArrayList<Items> itemsList=new ArrayList<Items>();
            Class[] classlist= new Class[]{};

            for (int i = 0; i<3; i++){
                itemsList.add(new PaperScore());
            }
            for (int i = 0; i<3; i++){
                itemsList.add(new MusicCD());
            }
            for (int i = 0; i<3; i++){
                itemsList.add(new Vinyl());
            }
            for (int i = 0; i<3; i++) {
                itemsList.add(new RecordPlayer());
            }
            for (int i = 0; i<3; i++){
                itemsList.add(new PlayerCD());
            }
            for (int i = 0; i<3; i++){
                itemsList.add(new MP3());
            }
            for (int i = 0; i<3; i++){
                itemsList.add(new Guitar());
            }
            for (int i = 0; i<3; i++){
                itemsList.add(new Mandolin());
            }
            for (int i = 0; i<3; i++){
                itemsList.add(new Bass());
            }
            for (int i = 0; i<3; i++){
                itemsList.add(new Flute());
            }
            for (int i = 0; i<3; i++){
                itemsList.add(new Harmonica());
            }
            for (int i = 0; i<3; i++){
                itemsList.add(new Hats());
            }
            for (int i = 0; i<3; i++){
                itemsList.add(new Shirts());
            }
            for (int i = 0; i<3; i++){
                itemsList.add(new Bandanas());
            }
            for (int i = 0; i<3; i++){
                itemsList.add(new PracticeAmps());
            }
            for (int i = 0; i<3; i++){
                itemsList.add(new Cables());
            }
            for (int i = 0; i<3; i++){
                itemsList.add(new Strings());
            }
//            System.out.println(itemsList.size());
        return itemsList;}
}


