
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DayTest.
 *
 */
public class DayTest
{
    private Day day1;

    /**
     * Default constructor for test class DayTest
     */
    public DayTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        day1 = new Day(1);
    }

    @Test
    public void testFindSpace(){
        // given: Empty Day (in setup)
        // and two hour Appointment
        Appointment app = new Appointment("info", 2);
        // when findSpace is called
        int hour = day1.findSpace(app);
        // then 
        assertEquals(9,hour);

    }

    @Test
    public void testMakeAppointmentSucceeds()
    {
        // given empty day and 2hr appointment
        Appointment info1 = new Appointment("Info1", 2);
        // when makeApp is called then it succeeds
        assertEquals(true, day1.makeAppointment(9, info1));
    }

    @Test
    public void testMakeAppointmentActuallyPutsAppInCalendar()
    {
        // given a day after makeApp called
        Appointment info1 = new Appointment("Info1", 2);
        day1.makeAppointment(9, info1);
        // when getApp is called then it returns the same appoint
        assertEquals(info1, day1.getAppointment(9));
    }
}

