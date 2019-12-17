
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
public class DayFirstHourFree009
{
    private Day day1;
    private Appointment mathematik;
    private Appointment hausaufgaben;
    private Appointment gwp;

    /**
     *  Setzt das Testger�st fuer den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @Before
    public void setUp()
    {
        day1 = new Day(1);
        mathematik = new Appointment("Mathematik", 7);
        hausaufgaben = new Appointment("Hausaufgaben", 1);
        gwp = new Appointment("GWP", 2);
    }
    
    private void DayWithFirstHourFree(){
        day1.makeAppointment(10, mathematik);
    }

    @Test
    public void testFirstHourFree(){
        //given a day with the first hour free
        DayWithFirstHourFree();
        //when I put a one hour long appointment in the first hour
        boolean actual = day1.makeAppointment(9, hausaufgaben);
        //then should return true
        assertEquals(true, actual);
    }
    
    @Test
    public void testOnlyOneHourFree(){
        //given a day with the first hour free
        DayWithFirstHourFree();
        //when I put a two hour long appointment in the first hour
        boolean actual = day1.makeAppointment(9, gwp);
        //then should return false
        assertEquals(false, actual);
    }
    
    /**
     * Gibt das Testger�st wieder frei.
     *
     * Wird nach jeder Testfall-Methode aufgerufen.
     */
    @After
    public void tearDown()
    {
    }
}
