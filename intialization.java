import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
public class intialization {
//    Store FNMS =new Store();
    Factory southfac=new FactorySouth();
    Factory northfac=new FactoryNorth();
    Store SouthFNMS =new Store(1,southfac);
    Store NorthFNMS =new Store(0,northfac);
    Bank bank=new Bank();
    Publisher publisher=new Publisher();
    ArrayList<Staff> staffs= new ArrayList<>();
    Tracker tracker=Tracker.getInstance(publisher);



    public intialization() throws FileNotFoundException {

    //Initialize order, bank, store and inventory.
//    Order order = new Order();
//    Bank bank = new Bank();
//    Store FNMS = new Store();
//            this.FNMS.nextDay();
//        Register register = new Register();
//    Inventory inventory = new concreteInventory();
//    Publisher publisher = new Publisher();



    //Initialize three objects of each subclass in the Items class and update the inventory.
//    ArrayList<Items> totall_list = FNMS.do_stock();
//
//        for (int i = 0; i < totall_list.size(); i++ ){
//        FNMS.inventory.updateStock(totall_list.get(i));
//    }
        dostock(NorthFNMS);
        dostock(SouthFNMS);



    //Initialize the staffs.
//    ArrayList<Staff> staffs=new ArrayList<Staff>();
        staffs.add(new Staff(5,"Velma",new haphazard()));
        staffs.add(new Staff(20,"Shaggy",new Electronic()));
        staffs.add( new Staff(15,"Daphne",new Mannual()));
        staffs.add(new Staff(10,"Tom",new Mannual()));
        staffs.add(new Staff(10,"Jerry",new Electronic()));
    // new clerk

}
    public ArrayList<Command> Commandintil(Store store){
        ArrayList<Command> commandlist=new ArrayList<Command>();
        Command command1=new clerkCommand(store);
        commandlist.add(command1);
        Command command2=new timeCommand(store);
        commandlist.add(command2);
        Command command3=new buyCommand(store);
        commandlist.add(command3);
        Command command4=new SellCommand(store);
        commandlist.add(command4);
        Command command5=new guitaCommand(store);
        commandlist.add(command5);
        return commandlist;
    }
    public void dostock(Store store){
    ArrayList<Items> totall_list = store.do_stock();

        for (int i = 0; i < totall_list.size(); i++ ){
        store.inventory.updateStock(totall_list.get(i));
    }}

//    public void  day_run(Store store,Publisher publisher) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
//        store.todayStaff.arriveAtStore(store.order,store,publisher);
//        store.todayStaff.checkRegister(bank,FNMS,publisher);
//        store.todayStaff.doInventory(FNMS.order,FNMS,publisher);
//    }
//    public void transaction_run(Store store,Publisher publisher) throws IOException, InstantiationException, IllegalAccessException {
//        Seller[] sellers=store.createSellers();
//        Buyer[] buyers= store.createBuyers();
//        store.todayStaff.openStore(sellers,buyers,store,publisher);
//        store.todayStaff.cleanStore(FNMS.inventory,publisher);
//        store.todayStaff.leaveTheShop(FNMS,publisher);
//
//    }
    public void summerize(Store store){
        int totalvalue=0;
        for(Items item:store.inventory.getItemsList()){
            totalvalue+=item.getPurchasePrice();
        }
        System.out.println("The total value of items in the inventory is $"+ totalvalue);
        System.out.println("The items in the inventory is "+store.inventory.getItemsList());

        int totalsoldvalue=0;
        for(int d=0;d<store.getSoldList().size();d++){

            Items solditem= (Items) store.getSoldList().get(d);
            System.out.format("%s sell a price for $%d on day %d %n",solditem.getName(),solditem.getSalePrice(),solditem.getDaySold());
            totalsoldvalue+=solditem.getSalePrice();
        }  System.out.println("The total value for sold items is $"+totalsoldvalue);
        System.out.println("The sum of money in the register is $"+store.register.getMoneysum());
        bank.getSum();}

    public void run() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        int totaldays=Helper.random_number(30,10);
        if(totaldays%7==0){totaldays=totaldays+1;}
        double [] itemsale=new double[totaldays];
        double [] resgiters=new double[totaldays];
        System.out.format("The store will run %d days in total %n",totaldays);
        for(int i=0;i<totaldays;i++){
            if ((i+1)%7==0){
                SouthFNMS.nextDay();
                NorthFNMS.nextDay();
                publisher.notifyObservers(11,0,"",0);
                publisher.notifyObservers(11,1,"",0);
                System.out.println("today is Sunday, so the store closed ");
                publisher.notifyObservers(12,0,"",0);
//                publisher.notifyObservers(12,1,"",0);
                System.out.println("-----------------------------------");
                for(Staff staff:staffs){
                    staff.cleanCwd();
                }

                continue;
            }else{

                Staff[]  todaystaffs=Helper.assignStaff(staffs);
                Logger logger=Logger.getInstance(publisher,String.valueOf(1));

                System.out.println(logger);
                SouthFNMS.setTodayStaff(todaystaffs[0]);
                NorthFNMS.setTodayStaff(todaystaffs[1]);
                logger.setout(SouthFNMS.getDays());
                System.out.println("*************Below is the activity about the South store*********");
                Staff StodayStaff=SouthFNMS.getTodayStaff();
                StodayStaff.arriveAtStore(SouthFNMS.order,SouthFNMS,publisher);
                StodayStaff.checkRegister(bank,SouthFNMS,publisher);
                StodayStaff.doInventory(SouthFNMS.order,SouthFNMS,publisher);
                Seller[] sellers=SouthFNMS.createSellers();
                Buyer[] buyers= SouthFNMS.createBuyers();
                if (i==totaldays-1){
                    Invoker invoker=new Invoker();
                    ArrayList<Command> SCommandlist=Commandintil(SouthFNMS);
                    ArrayList<Command> NCommandlist=Commandintil(NorthFNMS);
                    invoker.setCommandlist(0,NCommandlist);
                    invoker.setCommandlist(1,SCommandlist);
                    invoker.interaction();


                }else{
                StodayStaff.openStore(sellers,buyers,SouthFNMS,publisher);

                StodayStaff.cleanStore(SouthFNMS,publisher);
                StodayStaff.leaveTheShop(SouthFNMS,publisher);}

//                publisher.notifyObservers(12,1,"",0);
//                logger.CCGlogger();
                System.out.println("*************Below is the activity about the North store*********");
                Staff NtodayStaff=NorthFNMS.getTodayStaff();
                NtodayStaff.arriveAtStore(NorthFNMS.order,NorthFNMS,publisher);
                NtodayStaff.checkRegister(bank,NorthFNMS,publisher);
                NtodayStaff.doInventory(NorthFNMS.order,NorthFNMS,publisher);
                sellers=NorthFNMS.createSellers();
                buyers= NorthFNMS.createBuyers();
                if(i!=totaldays-1) {
                    NtodayStaff.openStore(sellers, buyers, NorthFNMS, publisher);

                    NtodayStaff.cleanStore(NorthFNMS, publisher);
                    NtodayStaff.leaveTheShop(NorthFNMS, publisher);
//                    logger.CCGlogger();

//                    publisher.notifyObservers(12, 0, "", 0);



                    System.out.println("------------------------------------------------------------------------------------------");
                }

                logger.CCGlogger();
                publisher.notifyObservers(12, 0, "", 0);

                resgiters[SouthFNMS.getDays()-1]=SouthFNMS.register.getMoneysum()+NorthFNMS.register.getMoneysum();
                itemsale[SouthFNMS.getDays()-1]=SouthFNMS.todayStaff.getSellsum()+NorthFNMS.todayStaff.getSellsum();
                System.out.println(Arrays.toString(Arrays.stream(resgiters).toArray()));
                System.out.println(Arrays.toString(Arrays.stream(itemsale).toArray()));
                NorthFNMS.nextDay();
                SouthFNMS.nextDay();

        }


        }

        double [] date= new double[totaldays];
        for(int c=0; c<totaldays;c++){
            date[c]=c+1;
        }
        double[][]graph1 =new double[][]{resgiters,itemsale};
        String[] seriesNames_1 = new String[] { "Total Register","Item Sales"};
        XYChart chart_1 = QuickChart.getChart("Chart#1", "Date", "$", seriesNames_1, date, graph1);
        new SwingWrapper(chart_1).displayChart();
    System.out.println("-----------------------summarization-------------------------");

//    int totalvalue=0;
//    for(Items item:SouthFNMS.inventory.getItemsList()){
//        totalvalue+=item.getPurchasePrice();
//    }
//    System.out.println("The total value of items in the inventory is $"+ totalvalue);
//    System.out.println("The items in the inventory is "+SouthFNMS.inventory.getItemsList());
//
//    int totalsoldvalue=0;
//    for(int d=0;d<SouthFNMS.getSoldList().size();d++){
//
//        Items solditem= (Items) SouthFNMS.getSoldList().get(d);
//        System.out.format("%s sell a price for $%d on day %d %n",solditem.getName(),solditem.getSalePrice(),solditem.getDaySold());
//        totalsoldvalue+=solditem.getSalePrice();
//    }  System.out.println("The total value for sold items is $"+totalsoldvalue);
//    System.out.println("The sum of money in the register is $"+SouthFNMS.register.getMoneysum());
//    bank.getSum();
        summerize(SouthFNMS);
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^");
        summerize(NorthFNMS);
}





}


