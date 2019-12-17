
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
public class FullDay014
{
    private Day day1;
    private Appointment GWP;
    private Appointment PandMT;
    private Appointment Mathe;
    private Appointment Eng;
    private Appointment Info;
    /**
     *  Setzt das Testger�st fuer den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @Before
    public void setUp()
    {
        day1 = new Day(1);
        GWP = new Appointment("GWP", 2);
        PandMT = new Appointment("Medientheorie", 1);
        Mathe = new Appointment("mathe", 2);
        Info = new Appointment("Info",2);
        Eng = new Appointment("Englisch",2);
        day1.makeAppointment(1, Mathe);
        day1.showAppointments();
    }
    
    private void DayWithFirstHourFree(){
        day1.makeAppointment(10, GWP);
    }
    private void TagMitFreistunden(){
        day1.makeAppointment(9,Info);
        day1.makeAppointment(11,PandMT);
        day1.makeAppointment(15,Info);
        
    }
    
        private void TagOhneFreistunden(){
        day1.makeAppointment(9,Info);
        day1.makeAppointment(11,Eng);
        day1.makeAppointment(13,Info);
        day1.makeAppointment(15,Mathe);
    }
        @Test
    public void Test1(){
        
        TagMitFreistunden();
        
        boolean actual = day1.makeAppointment(9, PandMT);
       
        day1.showAppointments();
        assertEquals(true, actual);
    }
    
            @Test
    public void Test2(){
        
        TagMitFreistunden();
        
        boolean actual = day1.makeAppointment(9, Info);
        
        day1.showAppointments();
        assertEquals(false, actual);
    }
    
                @Test
    public void Test3(){
        
        TagOhneFreistunden();
        
        boolean actual = day1.makeAppointment(13, GWP);
        
        day1.showAppointments();
        assertEquals(true, actual);
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
