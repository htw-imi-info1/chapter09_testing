
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DayTest.
 *
 * @author  Barne Kleinen
 */
public class DayTestLast2HFree019
{
    private Day day1;
    private Appointment info2;
    private Appointment lab;
    private Appointment gdm;
    private Appointment kp;
  
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        day1 = new Day(1); // this is the sut - subject under test
        info2 = new Appointment("Info 1", 3);
        lab = new Appointment("Lab", 4);
        gdm = new Appointment("GDM", 2);
        kp = new Appointment("KP", 3);
    }

    private void dayWithlast2hrfree(){
        day1.makeAppointment(9, info2);
        day1.makeAppointment(12, lab);
    }

    @Test
    public void test2hSlotIsFound()
    {
        // given
        // day with app on 9 and 12 hrs and last 2hrs free (setup)
        dayWithlast2hrfree();
        // when
        int actualValue = day1.findSpace(gdm);
        // then
        assertEquals("first slot with 2h available should be found",16, actualValue);
    }
    @Test
    public void testMakeApp9onAnotherApp()
    {
        // given
        // day with app on 9 and 12 hrs and last 2hrs free (setup)
        dayWithlast2hrfree();
        // when
        boolean actual = day1.makeAppointment(9, gdm);
        // then
        assertEquals(false, actual);
    }
    @Test
    public void testMakeApp15()
    {
        // given
        // day with app on 9 and 12 hrs and last 2hrs free (setup)
        dayWithlast2hrfree();
        // when
        boolean actual = day1.makeAppointment(15, gdm);
        // then
        assertEquals(false, actual);
    }

    @Test
    public void testMakeApp16()
    {
        // given
        // day with app on 9 and 12 hrs and last 2hrs free (setup)
        dayWithlast2hrfree();
        // when
        boolean actual = day1.makeAppointment(16, gdm);
        // then
        assertEquals(true, actual);
    }
    @Test
    public void testMakeApp16with3()
    {
        // given
        // day with app on 9 and 12 hrs and last 2hrs free (setup)
        dayWithlast2hrfree();
        // when
        boolean actual = day1.makeAppointment(16, kp);
        // then
        assertEquals(true, actual);
    }
    @Test
    public void testMakeApp17()
    {
        // given
        // day with app on 9 and 12 hrs and last 2hrs free (setup)
         dayWithlast2hrfree();
       // when
        boolean actual = day1.makeAppointment(17, gdm);
        // then
        assertEquals(false, actual);
    }

    @Test
    public void testMakeApp18()
    {
        // given
         dayWithlast2hrfree();
        // day with app on 9 and 12 hrs and last 2hrs free (setup)
        // when
        boolean actual = day1.makeAppointment(18, gdm);
        // then
        assertEquals(false, actual);
    }

    @Test
    public void testAppointmentWasActuallyScheduled()
    {
        // given empty day
        // when 
        day1.makeAppointment(14, info2);
        // then appointment is in schedule
        Appointment actual = day1.getAppointment(14);
        assertEquals(info2, actual);
    }
}


