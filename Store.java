import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Random.*;

// the Store object remain the same around 30 days
public class Store {
    private int days; //get the today is what day
    private ArrayList<Items>soldList;// all items that have been sold;
    private ArrayList<Items>outOfStocklist;// the items that has been sold out, it will clean each day
    Staff todayStaff; // who is the today's clerk
    public Register register;
    public Store(){
        this.soldList=new ArrayList<Items>();
        this.outOfStocklist=new ArrayList<Items>();
        this.register=new Register();
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
        int num= Helper.getPossionDistribution()+2;
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
    public Staff selectStaff(ArrayList<Staff> staffs){
        Random random=new Random();
        ArrayList<Staff> candidate= new ArrayList<Staff>();
        // exclude who has worked for 3 days
        for(int i=0;i<staffs.size();i++){
            if(staffs.get(i).getCwd()==2){
                staffs.get(i).cleanCwd();

            }else{
                candidate.add(staffs.get(i));
            }
        }

        int sickindex=random.nextInt(3);
        int workindex=random.nextInt(staffs.size());
//        Staff assignedStaff=staffs.get(workindex);

        int sickprob=random.nextInt(100);
        if(sickprob<=10 & workindex==sickindex){
            // that should be work for that day take a rest,this one cannot work
            staffs.get(workindex).cleanCwd();
            candidate.remove(workindex);
            Collections.shuffle(candidate);
            // the one who assigned to work for that day get sicks
            todayStaff=candidate.get(0);
            candidate.remove(0);
        }
        else{
            //if the one assigned to that day doesn't get sick, so he/she can work.
            todayStaff=staffs.get(workindex);
            candidate.remove(workindex);
        }
        // the rest who doesn't work for that day get a rest
        for(Staff staff:candidate){
            staff.cleanCwd();
        }




    System.out.format("%s arrives at store at day %d  %n",todayStaff.getName(),days);

    return todayStaff;
    }

        public void removeItem(){

        this.outOfStocklist.clear();

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


