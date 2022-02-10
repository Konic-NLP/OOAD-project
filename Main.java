public class Main {
    public static  void main(String args []){


        Order order = new Order();

        Bank bank = new Bank();

        Store FNMS = new Store();
        FNMS.nextDay();


        Register register = new Register();
        Inventory inventory = new Inventory();


//function to do all the items *3
        inventory.updateStock();


        Staff Velma = new Staff(5,"Velma");
        Staff Shaggy = new Staff(20,"Shaggy");

        FNMS.selectStaff(Shaggy,Velma);
        Staff todayStaff = FNMS.todayStaff;
        todayStaff.arriveAtStore(order,inventory,FNMS);
        todayStaff.checkRegister(register,bank,FNMS);

        todayStaff.doInventory(inventory,order,FNMS);

        //inialize customer
        //return a list of customer;
        todayStaff.openStore() ;



        todayStaff.bidToSeller();

        todayStaff.cleanStore();






}
