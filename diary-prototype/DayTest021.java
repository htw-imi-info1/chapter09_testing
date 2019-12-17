
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
public class DayTest021
{
    private Day day;
    private Appointment apo;
    private Appointment red;
    /**
     * Konstruktor fuer die Test-Klasse DayTest
     */
    public DayTest021()
    {

    }

    /**
     *  Setzt das Testger�st fuer den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @Before
    public void setUp()
    {
        day = new Day(1);
        apo = new Appointment("Englisch", 8);
        red = new Appointment("GWP",1);
    }

    public void dayWithLastHFree()
    {
        day.makeAppointment(9, apo);
    }

    /*@Test
    public void testAllHFull(){
        //given day with the last hour (16-17) free
        dayWithLastHFree();
        //when I put an Appointment for every hour from 9 - 15 
        boolean actual=false;
        for(int i=9; i<17;i++){
            actual=day.makeAppointment(i,red); 
            if(actual){
                
            }
        }
        //then false should be returned
        assertEquals(false,actual);
    }*/

    @Test
    public void testLastHourFree(){
        //given day with the last hour (17-18) free
        dayWithLastHFree();
        //when I put an appointment on the last hour
        boolean actual = day.makeAppointment(17, red);
        //then true should be returned
        assertEquals(true,actual);
    }
    
    @Test
    public void testFirstHourFree()
    {
        //given day with the last hour (17-18) free
        dayWithLastHFree();
        //when I put an appointment on the first hour
        boolean actual = day.makeAppointment(1, red);
        //the false should be returned
        assertEquals(false,actual);
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
