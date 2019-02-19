import static org.junit.Assert.*;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class DriverPrivateTest {

    /**
     * Accessing a private member
     * Test of age member, of class Robot.
     */

    @Test
    public void testDriverNum() throws Exception {
        System.out.println("testDriverNum");
        Driver target = new Driver("tanner", 101);
        Class secretClass = target.getClass();

        /*Retrieve the field age */
        Field f = secretClass.getDeclaredField("driverNum");

        /* make sure the field is accessible. */
        f.setAccessible(true);

        /* get the value of the field */
        System.out.println("The value in f (driverNum) is " + f.get(target));

        int result =  f.getInt(target);
        assertEquals("The driverNums should be equal", 101,  result);
    }

    /**
     * Accessing a private member
     * Test of setAge method, of class robot.
     */

    @Test
    public void testSetDriverNum() throws Exception {
        System.out.println("testSetDriverNum");
        /* Set up a new Robot */
        Driver target = new Driver("tanner", 909);

        /* get the setAge method details */
        Method method = Driver.class.getDeclaredMethod("setDriverNum", int.class);

        /* make the method assessible */
        method.setAccessible(true);

        /* invoke the method setAge with the value 7 */
        method.invoke(target, 909);

        /*access the field age and check its value is set to 7*/
        Class secretClass = target.getClass();

        Field f = secretClass.getDeclaredField("driverNum");

        f.setAccessible(true);

        int result =  f.getInt(target);
        System.out.println("The value in f (driverNum) is " + f.get(target));
        assertEquals("The driverNums should be equal", 909,  result);
    }
}