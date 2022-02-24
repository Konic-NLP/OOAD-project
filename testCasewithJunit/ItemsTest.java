import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class ItemsTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 


@Test
//Test if all the Player items has the equalized property.
public void testEqualized() throws Exception {
    String expected = "equalized";
    Items testPlayerCD = new PlayerCD();
    String name1 = testPlayerCD.getProperty().getName();
    assertEquals(expected,name1);

    Items testMP3 = new MP3();
    String name2 = testMP3.getProperty().getName();
    assertEquals(expected,name2);

    Items testRecordPlayer = new RecordPlayer();
    String name3 = testRecordPlayer.getProperty().getName();
    assertEquals(expected,name3);

    Items testCassettePlayer = new CassettePlayer();
    String name4 = testCassettePlayer.getProperty().getName();
    assertEquals(expected,name4);
}
@Test
//Test if all the Stringed items has the tuned property.
public void testTuned() throws Exception {
        String expected = "tuned";
        Items testGuitar = new Guitar();
        String name1 = testGuitar.getProperty().getName();
        assertEquals(expected,name1);

        Items testBass = new Bass();
        String name2 = testBass.getProperty().getName();
        assertEquals(expected,name2);

        Items testMandolin = new Mandolin();
        String name3 = testMandolin.getProperty().getName();
        assertEquals(expected,name3);
}
@Test
//Test if all the Wind items has the adjusted property.
public void testAdjusted() throws Exception {
        String expected = "adjusted";
        Items testFlute = new Flute();
        String name1 = testFlute.getProperty().getName();
        assertEquals(expected,name1);

        Items testHarm = new Harmonica();
        String name2 = testHarm.getProperty().getName();
        assertEquals(expected,name2);

        Items testSaxo = new Saxophone();
        String name3 = testSaxo.getProperty().getName();
        assertEquals(expected,name3);
    }
} 
