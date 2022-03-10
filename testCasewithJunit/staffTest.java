//package testCasewithJunit;

import org.junit.Test;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertTrue;


public class staffTest {

    @Test
    public void testCWD(){
        Factory southfac=new FactorySouth();
        Factory northfac=new FactoryNorth();
        Store SouthFNMS =new Store(1,southfac);
        Store NorthFNMS =new Store(0,northfac);
        Bank bank=new Bank();
        Publisher publisher=new Publisher();
        ArrayList<Staff> staffs= new ArrayList<>();
        Tracker tracker=Tracker.getInstance(publisher);
        staffs.add(new Staff(5,"Velma",new haphazard()));
        staffs.add(new Staff(20,"Shaggy",new Electronic()));
        staffs.add( new Staff(15,"Daphne",new Mannual()));
        staffs.add(new Staff(10,"Tom",new Mannual()));
        staffs.add(new Staff(10,"Jerry",new Electronic()));
        for (int i=0; i<30;i++) {
            Staff[] staffList = Helper.assignStaff(staffs);
            boolean bool1 = staffList[0].getCwd() <= 3;
            boolean bool2 = staffList[1].getCwd() <= 3;
            assertTrue(bool1);
            assertTrue(bool2);
        }
    }
}
