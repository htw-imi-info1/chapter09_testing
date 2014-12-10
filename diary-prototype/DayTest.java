
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
    private Day day1;
    Appointment breakfast,info1;

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
        day1 = new Day(10);
        breakfast = new Appointment("Frühstück", 1);
        info1 = new Appointment("Info1 Vorlesung", 2);
        assertEquals(true, day1.makeAppointment(9, breakfast));
        assertEquals(true, day1.makeAppointment(11, info1));

    }

    
    @Test
    public void findsSpaceFor1HourAppointment()
    {
        //given (setup)
        //when trying to find space for 1 hour
        Appointment dentist = new Appointment("Zahnarzt", 1);
        int actual = day1.findSpace(dentist);
        //then 10 is returned
        assertEquals(10, actual);
    }

    @Test
    public void findsSpaceFor2HourAppointment()
    {
        //given (setup)
        //when trying to find space for 2 hour
        Appointment hardwareStore = new Appointment("Baumarkt", 2);
        int actual = day1.findSpace(hardwareStore);
        //then 13 is returned
        assertEquals(13, actual);
    }
    private void fillDayBut10(){
           Appointment app1 = new Appointment("X", 2);
           Appointment app2 = new Appointment("Y", 3);
           day1.makeAppointment(13, app1);
           day1.makeAppointment(15, app2); 
    }
    @Test
    public void findsSpaceFor2HourAppointmentInAlmostFullDay()
    {
        //given a day with only 1 hour free (10:00)
        fillDayBut10();
        //when trying to find space for 2 hour
        Appointment hardwareStore = new Appointment("Baumarkt", 2);
        int actual = day1.findSpace(hardwareStore);
        //then -1 is returned
        assertEquals(-1, actual);
    }
}

