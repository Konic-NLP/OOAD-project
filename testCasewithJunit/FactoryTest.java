//package testCasewithJunit;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

public class FactoryTest {
    @Test
    public void testGenerateNorth(){
        int expected = 24;
        FactoryNorth factoryNorth = new FactoryNorth();
        GuitarKit guitarKit = factoryNorth.generate(1,1,1,1,1,1);
        int price = guitarKit.getSalePrice();
        System.out.println(price);
        System.out.println(guitarKit.getElements());
        System.out.println((guitarKit.getElementList()));
        assertTrue(price == expected );
    }
    @Test
    public void testGenerateSouth(){
        int expected = 48;
        FactorySouth factorySouth = new FactorySouth();
        GuitarKit guitarKit = factorySouth.generate(1,1,1,1,1,1);
        int price = guitarKit.getSalePrice();
        System.out.println(price);
        System.out.println(guitarKit.getElements());
        System.out.println((guitarKit.getElementList()));
        assertTrue(price == expected );
    }
}
