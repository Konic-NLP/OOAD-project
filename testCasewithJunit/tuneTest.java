import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import java.util.ArrayList;
import static org.junit.Assert.*;


public class tuneTest {

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

@Test
//The operation will only return true when the tuning process happened and it is from the true state to false state.
//The operation method will return false if the items does not have property or the tuning is from false state to true state.
public void testHaphazard(){
    tuneAlgorithms testHap = new haphazard();
    Items test1 =  new PaperScore();
    Items test2 =  new Saxophone();
    String name = "test";
    assertFalse(testHap.operation(name,test1));
    assertNull(test1.getProperty());
    testHap.operation(name,test2);
    assertNotNull(test2.getProperty().getValue());
}
@Test
//The operation will only return true when the tuning process happened and it is from the true state to false state.
//The operation method will return false if the items does not have property or the tuning is from false state to true state.
public void testManual(){
    tuneAlgorithms testMan = new Mannual();
    Items test1 =  new PaperScore();
    Items test2 =  new Saxophone();
    String name = "test";
    assertFalse(testMan.operation(name,test1));
    assertNull(test1.getProperty());
    testMan.operation(name,test2);
    assertNotNull(test2.getProperty().getValue());
}
@Test
//The operation will only return true when the tuning process happened and it is from the true state to false state.
//The operation method will return false if the items does not have property or the tuning is from false state to true state.
public void testElectronic(){
        tuneAlgorithms testEle = new Electronic();
        Items test1 =  new PaperScore();
        Items test2 =  new Saxophone();
        String name = "test";
        assertFalse(testEle.operation(name,test1));
        assertNull(test1.getProperty());
        testEle.operation(name,test2);
        assertTrue(test2.getProperty().getValue());
    }
}

