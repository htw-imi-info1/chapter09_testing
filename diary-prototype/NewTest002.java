import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * The test class Test.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class NewTest002
{
    private Day day1;
    private Appointment gwp;
    private Appointment info1;
    private Appointment cs;
    private Appointment doctor;

    /**
     * Default constructor for test class Test
     */
    public NewTest002()
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
        gwp = new Appointment("GWP", 3);
        info1 = new Appointment("Info1", 2);
        cs = new Appointment("CS", 2);
        doctor = new Appointment("Doctor", 1);
    }
    public void DayWith1hBreak(){
    day1.makeAppointment(9, gwp);
        day1.makeAppointment(13, info1);
        day1.makeAppointment(15, cs);
        day1.makeAppointment(17, doctor);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void negativeFindSpace()
    {
        //given a day with 1h break
        DayWith1hBreak();
        Appointment math = new Appointment("Math", 2);
        //when
        int actual = day1.findSpace(math);
        //then
        assertEquals("This time isn't available. -1 should be returned",-1, actual);
    }

    @Test
    public void availableTime()
    {
         //given a day with 1h break
        DayWith1hBreak();
        Appointment lab = new Appointment("Lab", 1);
        //when
        int value = day1.findSpace(lab);
        //then
        assertEquals("Slot at 12 should be found",12, value);
    }
      @Test
    public void testGetAppointment()
    {
        //given a day with 1h break
        DayWith1hBreak();
        //when
        Appointment actual = day1.getAppointment(9);
        //then
        assertEquals("gwp should be returned", gwp, actual);
    }

}
