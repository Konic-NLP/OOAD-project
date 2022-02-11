import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {
    public static  void main(String args []) throws ClassNotFoundException, InstantiationException, IllegalAccessException {


        Order order = new Order();

        Bank bank = new Bank();

        Store FNMS = new Store();
        FNMS.nextDay();


        Register register = new Register();
        Inventory inventory = new Inventory();


        ArrayList<Items> totall_list = FNMS.do_stock();

        for (int i = 0; i < totall_list.size(); i++ ){
//            System.out.println(totall_list.get(i));
//            if(totall_list.get(i).getName()==null){
//                System.out.println(i);
//            }
//            System.out.println(totall_list.get(i).getClass());
            inventory.updateStock(totall_list.get(i));}


        Staff Velma = new Staff(5,"Velma");
        Staff Shaggy = new Staff(20,"Shaggy");
        for(int i=0;i<30;i++){
            if (FNMS.getDays()%7==0){
                FNMS.nextDay();
                continue;
            }else{
            System.out.println("---------------------------");System.out.println("money in the register"+register.getMoneysum());
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
        todayStaff.leaveTheShop(FNMS);

        System.out.println("total value"+inventory.getTotalValue());
        System.out.println(inventory.itemsList);
        int totalsoldvalue=0;
        for(int d=0;d<FNMS.getSoldList().size();d++){

            Items solditem= (Items) FNMS.getSoldList().get(d);
//            System.out.format("%s sell a price for %d at day %d %n",solditem.getName(),solditem.getDaySold(),solditem.getSalePrice());
            totalsoldvalue+=solditem.getSalePrice();
        }
        System.out.println(totalsoldvalue);
        System.out.println("The sum of money in the register is "+register.getMoneysum());


        System.out.println(order.getorderlist().stream().map(Items::getDayArrived).collect(Collectors.toList()));

        FNMS.nextDay();

//        System.out.println(inventory.countItems.toString());


}
//                totalsoldvalue+=solditem.getSalePrice();
            }bank.getSum();
        for(int d=0;d<FNMS.getSoldList().size();d++){

            Items solditem= (Items) FNMS.getSoldList().get(d);
            System.out.format("%s sell a price for %d at day %d %n",solditem.getName(),solditem.getDaySold(),solditem.getSalePrice());} }}
