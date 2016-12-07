
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DayTest.
 *
 * @author  BlueJ
 */
public class DayTest
{
    private Day day;
    private Appointment info1;

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
        day = new Day(3);
        info1 = new Appointment("Info1", 2);

    }

    @Test
    public void makeAppointmentInEmptyDay(){
        //given empty day from setup
        //when
        boolean result = day.makeAppointment(10, info1);
        //then
        assertEquals("should return true",true,result);
        assertEquals("info1 should be at first hour",info1,day.getAppointment(10));
        assertEquals("info1 should be at second hour",info1,day.getAppointment(11));
    }

    @Test
    public void secondAppointmentOnSameTime()
    {
        //given
        Appointment info2 = new Appointment("Info2", 2);
        day.makeAppointment(10, info1);
        //when & then
        assertEquals(false, day.makeAppointment(10, info2));
        assertEquals("info1 should still be at first hour",info1,day.getAppointment(10));
        assertEquals("info1 should still be at second hour",info1,day.getAppointment(11));
    }

    @Test
    public void makeAppAfter1800()
    {
        boolean actual = day.makeAppointment(17, info1);
        assertFalse("should not be possible to make app",actual);

    }

    @Test
    public void findSpaceInAlmostFullDay()
    {
        //given
        day.makeAppointment(9, info1);
        Appointment info2 = new Appointment("Info2", 2);
        day.makeAppointment(12, info2);
        Appointment info3 = new Appointment("Info3", 2);
        day.makeAppointment(16, info3);
        
        //when
        Appointment rails = new Appointment("Rails", 2);
        int time = day.findSpace(rails);
        
        //then
        assertEquals(14,time);

    }
}

