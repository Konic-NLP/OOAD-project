import java.util.ArrayList;

public class Main {
    public static  void main(String args []){


        Order order = new Order();

        Bank bank = new Bank();

        Store FNMS = new Store();
        FNMS.nextDay();


        Register register = new Register();
        Inventory inventory = new Inventory();


        ArrayList<Items> totall_list = FNMS.do_stock();

        for (int i = 0; i < totall_list.size(); i++ )
            inventory.updateStock(totall_list.get(i));


        Staff Velma = new Staff(5,"Velma");
        Staff Shaggy = new Staff(20,"Shaggy");

        Staff todayStaff = FNMS.selectStaff(Shaggy,Velma);
        todayStaff.arriveAtStore(order,inventory,FNMS);
        todayStaff.checkRegister(register,bank,FNMS);

        todayStaff.doInventory(inventory,order,FNMS);
        Seller[] sellers=FNMS.createSellers();
        Buyer[] buyers= FNMS.createBuyers();
        //inialize customer
        //return a list of customer;
        todayStaff.openStore(sellers,buyers,register,inventory,FNMS);
        // if store.getDays()%7==0: continue;

//        todayStaff.bidToSeller();
        todayStaff.cleanStore(inventory);






}
