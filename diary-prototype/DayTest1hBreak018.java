

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
public class DayTest1hBreak018
{
    private Day day1;
    private Appointment appointm1;
    private Appointment Info1;
    private Appointment Lap;
    private Appointment Mathe;
    private Appointment GWP;
    private Appointment MT;

    /**
     * Konstruktor fuer die Test-Klasse DayTest
     */
    public DayTest1hBreak018()
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
        day1 = new Day(351);
        appointm1 = new Appointment("Info1", 2);
        Info1 = new Appointment("Info1", 2);
        Lap = new Appointment("Lap", 2);
        Mathe = new Appointment("Mathe", 2);
        GWP = new Appointment("GWP", 2);
        day1.getAppointment(9);
        day1.makeAppointment(9, Info1);
        day1.makeAppointment(11, Lap);
        day1.makeAppointment(14, Mathe);
        day1.makeAppointment(16, GWP);
        MT = new Appointment("MT", 1);
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
    
    public void dayWith1HourBreak(){
    
    }

    @Test
    public void App1hAt13()
    {
        //given
        //full day with one hour break at 13 o'clock
        setUp();
        //when
        boolean actualValue = day1.makeAppointment(13, MT);
        //then
        assertEquals(true, actualValue);
    }
    @Test
    public void App1hAt14()
    {
        //given
        //full day with one hour break at 13 o'clock
        //when
        boolean actualValue = day1.makeAppointment(14, MT);
        //then
        assertEquals(false, actualValue);
    }
    @Test
    public void App1hAt18()
    {
        //given
        //full day with one hour break at 13 o'clock
        //when
        //trying to make 1 hour appointment at 18 o'clock
        boolean actualValue = day1.makeAppointment(18, MT);
        //then
        assertEquals(false, actualValue);
    }

    @Test
    public void App2hAt13()
    {
        //given
        //full day with one hour break at 13 o'clock
        //when
        //trying to make 2 hour appointment at 13 o'clock
        boolean actual = day1.makeAppointment(13, Lap);
        //then
        assertEquals(false, actual);
    }

    @Test
    public void findSpace2hApp()
    {
        //given
        //full day with one hour break at 13 o'clock
        //when
        //search for free space with 2h Appointment
        int actualValue = day1.findSpace(Lap);
        //then
        assertEquals(-1, actualValue);
    }
    @Test
    public void findSpace1hApp()
    {
        //given
        //full day with one hour break at 13 o'clock

        //when
        //search for free space with 2h Appointment
        int actualValue = day1.findSpace(MT);
        //then
        assertEquals(13, actualValue);
    }
}




