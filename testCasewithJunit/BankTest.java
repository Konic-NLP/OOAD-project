import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 
import static org.junit.Assert.*;
public class BankTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

@Test
//Test the one_time withdraw value.
public void testWithdraw() throws Exception {
    int expected = 1000;
    assertEquals(expected,new Bank().withdraw());
} 

@Test
//Test the accumulated withdraw value.
public void testGetSum() throws Exception {
    int expected= 3000;
    Bank testBank = new Bank();
    testBank.withdraw();
    testBank.withdraw();
    testBank.withdraw();
    assertEquals(expected,testBank.getSum());
}
} 
