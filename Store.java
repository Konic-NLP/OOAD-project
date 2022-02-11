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
            PaperScore ps1 = new PaperScore();
            itemsList.add(ps1);
            Items ps2 = new PaperScore();
            itemsList.add(ps2);
            Items ps3 = new PaperScore();
            itemsList.add(ps3);
            MusicCD mcd1 = new MusicCD();
            itemsList.add(mcd1);
            MusicCD mcd2 = new MusicCD();
            itemsList.add(mcd2);
            MusicCD mcd3 = new MusicCD();
            itemsList.add(mcd3);
            Vinyl v1 = new Vinyl();
            itemsList.add(v1);
            Vinyl v2 = new Vinyl();
            itemsList.add(v2);
            Vinyl v3 = new Vinyl();
            itemsList.add(v3);
            PlayerCD pcd1 = new PlayerCD();
            itemsList.add(pcd1);
            PlayerCD pcd2 = new PlayerCD();
            itemsList.add(pcd2);
            PlayerCD pcd3 = new PlayerCD();
            itemsList.add(pcd3);
            RecordPlayer rp1 = new RecordPlayer();
            itemsList.add(rp1);
            RecordPlayer rp2 = new RecordPlayer();
            itemsList.add(rp2);
            RecordPlayer rp3 = new RecordPlayer();
            itemsList.add(rp3);
            MP3 mp31= new MP3();
            itemsList.add(mp31);
            MP3 mp32= new MP3();
            itemsList.add(mp32);
            MP3 mp33= new MP3();
            itemsList.add(mp33);
            Guitar g1 = new Guitar();
            itemsList.add(g1);
            Guitar g2 = new Guitar();
            itemsList.add(g2);
            Guitar g3 = new Guitar();
            itemsList.add(g3);
            Bass b1 = new Bass();
            itemsList.add(b1);
            Bass b2 = new Bass();
            itemsList.add(b2);
            Bass b3 = new Bass();
            itemsList.add(b3);
        return itemsList;}
}


