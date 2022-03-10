//package testCasewithJunit;//package testCasewithJunit;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertTrue;

public class TrackerTest {
    @Test
    public void testGetInstance() throws FileNotFoundException {
        Publisher publisher = new Publisher();
        Tracker A = Tracker.getInstance();
        Tracker B = Tracker.getInstance();
        assertTrue(A.equals(B));

    }
}
