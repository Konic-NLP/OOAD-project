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
//        System.out.println(num);
        Seller[] sellers= new Seller[num];
        for(int i=0;i<sellers.length;i++){
            sellers[i]=new Seller();
        }


        return sellers;
    }

    public Buyer[] createBuyers(){
        Random random= new Random();
        int num= random.nextInt((10-4)+1)+4;
//        System.out.println(num);
        Buyer[] buyers=new Buyer[num];
        for(int i=0;i<buyers.length;i++){
            buyers[i]=new Buyer();
        }


        return buyers;

    }

//    public void getnodo_stock(Inventory inventory){
//
//        this.outOfdo_stocklist=inventory.checkdo_stock();
//
//    };
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
//
            PaperScore ps1 = new PaperScore();
//            ps1.do_stock();
            itemsList.add(ps1);
            Items ps2 = new PaperScore();
//            ps2.do_stock();
            itemsList.add(ps2);
            Items ps3 = new PaperScore();
//            ps3.do_stock();
            itemsList.add(ps3);
//
        MusicCD mcd1 = new MusicCD();
//        mcd1.do_stock();
        itemsList.add(mcd1);
        MusicCD mcd2 = new MusicCD();
//        mcd2.do_stock();
        itemsList.add(mcd2);
        MusicCD mcd3 = new MusicCD();
//        mcd3.do_stock();
        itemsList.add(mcd3);
//
        Vinyl v1 = new Vinyl();
//        v1.do_stock();
        itemsList.add(v1);
        Vinyl v2 = new Vinyl();
//        v2.do_stock();
        itemsList.add(v2);
        Vinyl v3 = new Vinyl();
////        v3.do_stock();
        itemsList.add(v3);
//
        PlayerCD pcd1 = new PlayerCD();
//        pcd1.do_stock();
        itemsList.add(pcd1);
        PlayerCD pcd2 = new PlayerCD();
//        pcd2.do_stock();
        itemsList.add(pcd2);
        PlayerCD pcd3 = new PlayerCD();
//        pcd3.do_stock();
        itemsList.add(pcd3);
//
        RecordPlayer rp1 = new RecordPlayer();
//        rp1.do_stock();
        itemsList.add(rp1);
        RecordPlayer rp2 = new RecordPlayer();
//        rp2.do_stock();
        itemsList.add(rp2);
        RecordPlayer rp3 = new RecordPlayer();
//        rp3.do_stock();
        itemsList.add(rp3);
//
        MP3 mp31= new MP3();
//        mp31.do_stock();
        itemsList.add(mp31);
        MP3 mp32= new MP3();
//        mp32.do_stock();
        itemsList.add(mp32);
        MP3 mp33= new MP3();
//        mp33.do_stock();
        itemsList.add(mp33);
//
        Guitar g1 = new Guitar();
//        g1.do_stock();
        itemsList.add(g1);
        Guitar g2 = new Guitar();
//        g2.do_stock();
        itemsList.add(g2);
        Guitar g3 = new Guitar();
//        g3.do_stock();
        itemsList.add(g3);
//
        Bass b1 = new Bass();
//        b1.do_stock();
        itemsList.add(b1);
        Bass b2 = new Bass();
//        b2.do_stock();;
        itemsList.add(b2);
        Bass b3 = new Bass();
//        b3.do_stock();
        itemsList.add(b3);
//
//        Mandolin m1 = new Mandolin();
//        m1.do_stock();
//        itemsList.add(m1);
//        Mandolin m2 = new Mandolin();
//        m2.do_stock();
//        itemsList.add(m2);
//        Mandolin m3 = new Mandolin();
//        m3.do_stock();
//        itemsList.add(m3);
//
//        Flute f1 = new Flute();
//        f1.do_stock();
//        itemsList.add(f1);
//        Flute f2 = new Flute();
//        f2.do_stock();
//        itemsList.add(f2);
//        Flute f3 = new Flute();
//        f3.do_stock();
//        itemsList.add(f3);
//
//        Harmonica h1 = new Harmonica();
//        h1.do_stock();
//        itemsList.add(h1);
//        Harmonica h2 = new Harmonica();
//        h2.do_stock();;
//        itemsList.add(h2);
//        Harmonica h3 = new Harmonica();
//        h2.do_stock();
//        itemsList.add(h3);
//
//        Hats hat1 = new Hats();
//        hat1.do_stock();
//        itemsList.add(hat1);
//        Hats hat2 = new Hats();
//        hat2.do_stock();
//        itemsList.add(hat2);
//        Hats hat3 = new Hats();
//        hat3.do_stock();
//        itemsList.add(hat3);
//
//        Shirts sht1 = new Shirts();
//        sht1.do_stock();
//        itemsList.add(sht1);
//        Shirts sht2 = new Shirts();
//        sht2.do_stock();
//        itemsList.add(sht2);
//        Shirts sht3 = new Shirts();
//        sht3.do_stock();
//        itemsList.add(sht3);
//
//        Bandanas bd1 = new Bandanas();
//        bd1.do_stock();
//        itemsList.add(bd1);
//        Bandanas bd2 = new Bandanas();
//        bd2.do_stock();
//        itemsList.add(bd2);
//        Bandanas bd3 = new Bandanas();
//        bd3.do_stock();
//        itemsList.add(bd3);
//
//        PracticeAmps pa1 = new PracticeAmps();
//        pa1.do_stock();
//        itemsList.add(pa1);
//        PracticeAmps pa2 = new PracticeAmps();
//        pa2.do_stock();
//        itemsList.add(pa2);
//        PracticeAmps pa3 = new PracticeAmps();
//        pa3.do_stock();
//        itemsList.add(pa3);
//
//        Cables c1 = new Cables();
//        c1.do_stock();
//        itemsList.add(c1);
//        Cables c2  = new Cables();
//        c2.do_stock();
//        itemsList.add(c2);
//        Cables c3 = new Cables();
//        c3.do_stock();
//        itemsList.add(c3);
//
//        Strings s1 = new Strings();
//        s1.do_stock();
//        itemsList.add(s1);
//        Strings s2 = new Strings();
//        s2.do_stock();
//        itemsList.add(s2);
//        Strings s3 = new Strings();
//        s3.do_stock();
//        itemsList.add(s3);

        return itemsList;
    }



        }


