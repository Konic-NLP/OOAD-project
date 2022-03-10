//package testCasewithJunit;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class LoggerTest {
@Test
    public void testGetInstance() throws FileNotFoundException {
        Publisher publisher = new Publisher();
        String day = "0";
        Logger A = Logger.getInstance(publisher,day);
        Logger B = Logger.getInstance(publisher,day);
        assertTrue(A.equals(B));

    }
}
