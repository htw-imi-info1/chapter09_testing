
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DayTest.
 *
 * @author  Nico Mania
 */
public class DayTestLast1HFree023
{
    private Day day1;
    private Appointment info2;
    private Appointment lab;
    private Appointment gdm;
    private Appointment lunch;
  
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        day1 = new Day(1); // this is the sut - subject under test
        info2 = new Appointment("Info 2", 3);
        lab = new Appointment("Lab", 4);
        gdm = new Appointment("GDM", 2);
        lunch = new Appointment("Lunch", 1);
    }

    private void dayWithlast1hfree(){
        // this day has more than last hour free.
        day1.makeAppointment(9, gdm);
        day1.makeAppointment(12, info2);
    }

    @Test
    public void test1hSlotIsFound()
    {
        // given
        // day with app on 9 and 12h and last 1h free (setup)
        dayWithlast1hfree();
        // when
            int actualValue = day1.findSpace(lunch);
        // then
        assertEquals("first slot with 1h available should be found",11, actualValue);
    }
    @Test
    public void testMakeApp9onAnotherApp()
    {
        // given
        // day with app on 9 and 12h and last 1h free (setup)
        dayWithlast1hfree();
        // when
        boolean actual = day1.makeAppointment(12, lunch);
        // then
        assertEquals(false, actual); // this returns false correctly.
    }
    @Test
    public void testMakeApp12()
    {
        // given
        // day with app on 9 and 12h and last 1h free (setup)
        dayWithlast1hfree();
        // when
        boolean actual = day1.makeAppointment(12, lunch);
        // then
        assertEquals(false, actual); // 12 is taken!
    }

    @Test
    public void testMakeApp11()
    {
        // given
        // day with app on 9 and 12h and last 1h free (setup)
        dayWithlast1hfree();
        // when
        boolean actual = day1.makeAppointment(11, lunch);
        // then
        assertEquals(true, actual);
    }
    @Test
    public void testMakeApp9()
    {
        // given
        // day with app on 9 and 12h and last 1h free (setup)
        dayWithlast1hfree();
        // when
        boolean actual = day1.makeAppointment(9, lunch);
        // then
        assertEquals(false, actual);
    }

}


