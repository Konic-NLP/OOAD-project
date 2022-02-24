import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import java.util.ArrayList;
import static org.junit.Assert.*;


public class StoreTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

@Test
//Test if the do_stock method creates right number of objects of Items.
public void testDo_stock() throws Exception {
    int expected = 63;
    Store testStore = new Store();
    ArrayList<Items> list = testStore.do_stock();
    assertEquals(expected,list.size());
    assertNotNull(list);
} 


} 
