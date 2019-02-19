import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.model.TestTimedOutException;

import static org.junit.Assert.*;

public class DriverTest {

    @Rule
    public Timeout globalTimeout = Timeout.millis(100);

    @Test
    public void testDriverInstance()
    {
        Driver tanner = new Driver("tanner",101);
        assertEquals("tanner",tanner.getDriverName());
        assertEquals(101,tanner.getDriverNum());
    }

    @Test
    public void testGetDriverName()
    {
        Driver tanner = new Driver("tanner",101);
        assertEquals("tanner",tanner.getDriverName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetDriverNameFail()
    {
        Driver tanner = new Driver("",101);
    }

    @Test
    public void testGetDriverNumber()
    {
        Driver tanner = new Driver("tanner",101);
        assertEquals(101,tanner.getDriverNum());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetDriverNumberFail()
    {
        Driver tanner = new Driver("tanner",99);
    }

    @Test
    public void testToString()
    {
        Driver tanner = new Driver("tanner",101);
        String expectedResult = "\nDriver Name: tanner\nDriver Number: "+101;
        assertEquals(expectedResult, tanner.toString());
    }

    @Test
    public void testCheckStatus()
    {
        Driver tanner = new Driver("tanner",101);
        assertFalse(tanner.check_status());
    }

    @Test(expected = TestTimedOutException.class)
    public void testWaitTillBanned()
    {
        Driver tanner = new Driver("tanner",101);
        tanner.waitTillBanned();
    }
}