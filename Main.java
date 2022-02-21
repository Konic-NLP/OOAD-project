import java.util.ArrayList;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {
    public static  void main(String args []) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        //Initialize order, bank, store, register and inventory.
        Order order = new Order();
        Bank bank = new Bank();
        Store FNMS = new Store();
        FNMS.nextDay();
//        Register register = new Register();
        Inventory inventory = new Inventory();

        //Initialize three objects of each subclass in the Items class and update the inventory.
        ArrayList<Items> totall_list = FNMS.do_stock();

        for (int i = 0; i < totall_list.size(); i++ ){
            inventory.updateStock(totall_list.get(i));
        }
        //Initialize the staffs.
        ArrayList<Staff> staffs=new ArrayList<Staff>();
        staffs.add(new Staff(5,"Velma",new haphazard()));
        staffs.add(new Staff(20,"Shaggy",new Electronic()));
        staffs.add( new Staff(15,"Daphne",new Mannual()));;


        //Run the Store for 30 days.
        for(int i=0;i<30;i++){
            if (FNMS.getDays()%7==0){
                FNMS.nextDay();
                System.out.println("today is Sunday, so the store closed ");
                System.out.println("-----------------------------------");
                for(Staff staff:staffs){
                    staff.cleanCwd();
                }
                continue;
            }else{

        Staff todayStaff = FNMS.selectStaff(staffs);
        todayStaff.arriveAtStore(order,inventory,FNMS);
        todayStaff.checkRegister(bank,FNMS);

        todayStaff.doInventory(inventory,order,FNMS);
        Seller[] sellers=FNMS.createSellers();
        Buyer[] buyers= FNMS.createBuyers();

        todayStaff.openStore(sellers,buyers,inventory,FNMS);

        todayStaff.cleanStore(inventory);
        todayStaff.leaveTheShop(FNMS);
        System.out.println("---------------------------");

        FNMS.nextDay();
            }
        }


        System.out.println("-----------------------summarization-------------------------");
        System.out.println("The total value of items in the inventory is $"+ FNMS.todayStaff.getTotalValue(inventory));
        System.out.println("The items in the inventory is "+inventory.itemsList);

        int totalsoldvalue=0;
        for(int d=0;d<FNMS.getSoldList().size();d++){

            Items solditem= (Items) FNMS.getSoldList().get(d);
            System.out.format("%s sell a price for $%d on day %d %n",solditem.getName(),solditem.getSalePrice(),solditem.getDaySold());
            totalsoldvalue+=solditem.getSalePrice();
        }  System.out.println("The total value for sold items is $"+totalsoldvalue);
        System.out.println("The sum of money in the register is $"+FNMS.register.getMoneysum());
            bank.getSum();

    }
}
