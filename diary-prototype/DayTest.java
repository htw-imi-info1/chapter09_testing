

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DayTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DayTest
{
    /**
     * Default constructor for test class DayTest
     */
    public DayTest()
    {
    }
 Day day1;
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
      day1  = new Day(1);
    }

    

    @Test
    public void positiveFindSpace()
    {
        // given an empty day & and a 2 h Appointment:      
        Appointment appointm1 = new Appointment("Zahnarzt", 2);
        //when
        int actual = day1.findSpace(appointm1);
        //then
        assertEquals("first slot of day should be returned",
        9, actual);
    }
     @Test
    public void negativeFindSpace()
    {
        // given a full day & and a 2 h Appointment:
        Appointment appointm1 = new Appointment("lang", 8);
        assertEquals(true, day1.makeAppointment(9, appointm1));
        Appointment appointm2 = new Appointment("Zahnarzt", 2);
        //when
        int actual = day1.findSpace(appointm2);
        //then
        assertEquals("no available time, -1 should be returned",
        -1, actual);
    }

    @Test
    public void positiveMakeAppointment()
    {
        Appointment appointm1 = new Appointment("lang", 8);
        assertEquals(true, day1.makeAppointment(9, appointm1));
        assertEquals(appointm1, day1.getAppointment(9));
    }
}


