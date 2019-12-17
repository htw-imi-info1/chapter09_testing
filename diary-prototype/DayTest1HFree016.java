import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Die Test-Klasse DayTest.
 *
 * @author  (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class DayTest1HFree016
{
    private Day day1;
    private Appointment GWP;
    private Appointment Medientheorie;
    private Appointment Mathe1;


    /**
     *  Setzt das Testger�st fuer den Test.
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
    public void validTimeTrue()
    {
        //when day1.validTime(13) gets called
        //then
        assertEquals(true, day1.validTime(13));
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
}