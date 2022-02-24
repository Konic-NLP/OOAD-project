import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class concreteInventoryTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 


@Test
//Test if the queryClothingStock will return True when there is no clothing items left in the inventory.
public void testQueryClothingStock() throws Exception { 


    Order testOrder = new Order();
    concreteInventory testInventory = new concreteInventory();

    testInventory.updateStock(new GigBag());
    testInventory.updateStock(new CassettePlayer());
    testInventory.updateStock(new Cassette());
    testInventory.updateStock(new GigBag());
    testInventory.updateStock(new MusicCD());

    Hats testHat = new Hats();
    testInventory.updateStock(testHat);
    ArrayList<Items> list = testInventory.checkStock(testOrder);
    System.out.println(testInventory.countItems);
    assertFalse(testInventory.queryClothingStock());

    testInventory.removeItems(testHat);
    list = testInventory.checkStock(testOrder);
    System.out.println(testInventory.countItems);
    assertTrue(testInventory.queryClothingStock());
}
} 
