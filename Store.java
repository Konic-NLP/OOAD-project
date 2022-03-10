import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Random.*;

// the Store object remain the same around 30 days
public class Store {
    public Inventory inventory;
    private int days=1; //get the today is what day
    private ArrayList<Items>soldList;// all items that have been sold;
//  private ArrayList<Items>outOfStocklist;// the items that has been sold out, it will clean each day
    Staff todayStaff; // who is the today's clerk
    public Register register;
    private Factory factory;
    private GuitarKit guitarKit;
    public Order order;
    private int code;
//    private Publisher publisher;

    public void setTodayStaff(Staff todayStaff) {
        this.todayStaff = todayStaff;
    }
    public Staff getTodayStaff() {
        return this.todayStaff ;
    }
    public Factory getFactory(){
        return this.factory;
    }
    public Store(int code,Factory factory){
        this.code=code;
        this.order=new Order();
        this.soldList=new ArrayList<Items>();
//        this.outOfStocklist=new ArrayList<Items>();
        this.register=new Register();
        this.inventory=new concreteInventory();
        this.factory=factory;
//        this.publisher = new Publisher();
    }
    public int getCode(){
        return this.code;

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

        int num= 2+Helper.getPossionDistribution();
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
    create two arraylist: one is the original the other is for select today's clerk(exclude the ones has work for 2days)
    then check whether the one get sick is the one should have worked for that day, if so, choose other ones in the candidate.
    otherwise, choose the one assigned for that day to work

     */
    public Staff selectStaff(ArrayList<Staff> staffs){

        Random random=new Random();
        ArrayList<Staff> candidate= new ArrayList<>();
        for(Staff staff:staffs){
            candidate.add(staff);
        }
        // exclude who has worked for 3 days
        for(int i=0;i<staffs.size();i++){
            if(staffs.get(i).getCwd()==2){
                staffs.get(i).cleanCwd();
                candidate.remove(staffs.get(i));

            }
        }

        int sickindex=random.nextInt(3);
        int workindex=random.nextInt(candidate.size());

//        Staff assignedStaff=staffs.get(workindex);

        int sickprob=random.nextInt(101);
        //sickprob<10:not invoke
//        workindex<candidate.size(): the one who has been worked for 2 days got sick
        if(sickprob<=10 &staffs.get(sickindex)==candidate.get(workindex)){
            String sickname=staffs.get(sickindex).getName();
            System.out.format("%s had assigned to work for day %d, but %s got sick %n",sickname,this.days,sickname);
            // that should be work for that day take a rest,this one cannot work
            staffs.get(sickindex).cleanCwd();
            candidate.remove(staffs.get(sickindex));
            Collections.shuffle(candidate);
            // the one who assigned to work for that day get sicks
            todayStaff=candidate.get(0);
            todayStaff.addCwd();
            candidate.remove(0);
        }
        else{
            //if the one assigned to that day doesn't get sick, so he/she can work.
            todayStaff=candidate.get(workindex);
            todayStaff.addCwd();
            candidate.remove(candidate.get(workindex));
        }
        // the rest who doesn't work for that day get a rest
        for(Staff staff:candidate){
            staff.cleanCwd();
        }
            System.out.format("arriveAtStore: %s arrives at store at day %d  %n",todayStaff.getName(),days);
        return todayStaff;}




    public ArrayList<Items> do_stock(){
        ArrayList<Items> itemsList=new ArrayList<Items>();
        Class[] classList= new Class[]{};
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
        for (int i = 0; i<3; i++){itemsList.add(new Saxophone());}
        for (int i = 0; i<3; i++){itemsList.add(new Cassette());}
        for (int i = 0; i<3; i++){itemsList.add(new CassettePlayer());}
        for (int i = 0; i<3; i++){itemsList.add(new GigBag());}


//            System.out.println("the total number of items in the inventory is  "+itemsList.size());
        return itemsList;}

    public GuitarKit CreateGuitarKit(){
        int [] nums=new int[6];
        for(int i=0;i<6;i++){
            int num=Helper.random_number(3,0);
            nums[i]=num;
        }

       return  factory.generate(nums[0],nums[1],nums[2],nums[3],nums[4],nums[5]);
    }}




