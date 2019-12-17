import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Die Test-Klasse DayTest1HFree.
 *
 * @author  Julius Schultz
 */
public class DayTest1HFree012
{
    private Day day1;
    private Appointment appointm1;
    private Appointment GWP;
    private Appointment Medientheorie;
    private Appointment Mathe1;


    /**
     *  Setzt das Testger?st fuer den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @Before
    public void setUp()
    {
        day1 = new Day(350);
        GWP = new Appointment("GWP", 2);
        Medientheorie = new Appointment("Medientheorie", 3);
        Mathe1 = new Appointment("Mathe1", 3);
        //given
        makeAppointments();
    }

    public void makeAppointments()
    {
        //given
        // day with one hour break at 11:00
        day1.makeAppointment(9, GWP);
        day1.makeAppointment(12, Medientheorie);
        day1.makeAppointment(15, Mathe1);
    }

    @Test
    public void OneHourAppointmentInBreak()
    {
       //when an appointment with one hour length takes place in the free hour
        Appointment Break = new Appointment("Break", 1);
        boolean actualValue = day1.makeAppointment(11, Break);
       //then
        assertEquals(true, actualValue);
    }

    @Test
    //this test has found a bug because it doesn't evaluates to the expected value
    public void TwoHourAppointmentInBreak()
    {
        //when an appointment with two hour length takes place in the free hour
        Appointment Break = new Appointment("Break", 2);
        boolean actualValue = day1.makeAppointment(11, Break);
        //then
        assertEquals(false, actualValue);
    }

    @Test
    public void TwoHourAppointmentInAppointment()
    {
        //when an appointment takes place in an occupied hour
        Appointment Break = new Appointment("Break", 2);
        boolean actualValue = day1.makeAppointment(9, Break);
        //then
        assertEquals(false, actualValue);
    }

    @Test
    //when day1.validTime(18) gets invoked
    public void invalidTime()
    {
        //then
        assertEquals(false, day1.validTime(18));
    }

    @Test
    //when day1.validTime(13) gets invoked
    public void validTime()
    {
        //then
        assertEquals(true, day1.validTime(13));
    }

    @Test
    //when day1.findSpace(Medientheorie) gets invoked
    public void findSpaceNoSpace()
    {
        //then
        assertEquals(-1, day1.findSpace(Medientheorie));
    }

    @Test
    //when day1.findSpace(Medientheorie) gets invoked
    public void AssignmentAtNegativeOne()
    {
        boolean actualValue = day1.makeAppointment(-1, Medientheorie);
        //then
        assertEquals(false, actualValue);
    }

    @Test
    //when getDescription()  of the Appointment class gets invoked
    public void TestGetDescriptionOfAppointments()
    {
        //then
        assertEquals("GWP", GWP.getDescription());
        //then
        assertEquals("Mathe1", Mathe1.getDescription());
    }

    @Test
    public void TestShowAppointments()
    {
        day1.showAppointments();
    }

 /**
 *
 * @author  (Julius Schultz)
 */

    @Test
    //when day1.validTime(18) gets invoked
    public void invalidTimeMorning()
    {
        //then false should be returned
        assertEquals(false, day1.validTime(8));
    }

    public void OneHourAppointment()
    {
       //when an appointment with one hour length takes place in the free hour
        Appointment Break = new Appointment("Break", 1);
        boolean actualValue = day1.makeAppointment(11, Break);
       //then true should be returned
        assertEquals(true, actualValue);
    }

    public void ZeroHourAppointment()
    {
       //when an appointment with one hour length takes place in the free hour
        Appointment Break = new Appointment("Break", 0);
        boolean actualValue = day1.makeAppointment(11, Break);
       //then true should be returned
        assertEquals(true, actualValue);
    }

    @Test
    //when: check if the day number ist still 350
    public void DayStillCorrect()
    {
        //then 350 should be the returned value
        assertEquals(350, day1.getDayNumber());
    }

}
