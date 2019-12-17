

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
public class DayTest010
{
    /**
     * Konstruktor fuer die Test-Klasse DayTest
     */
    public DayTest010()
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

    @Test
    public void Test_1h_break()
    {
        //give 1h break
        Day day2 = new Day(1);
        //when 2 appointments set with 3 and 5 h during the day
        Appointment appointm1 = new Appointment("schlafen", 3);
        Appointment appointm2 = new Appointment("essen", 5);
        //then appointment is in shedule 
        assertEquals(true, day2.makeAppointment(9, appointm1));
        assertEquals(true, day2.makeAppointment(12, appointm2));
    }

    @Test
    public void Test_half_day_full()
    {
        //given half day full
        Day day1 = new Day(1);
        //when 1 appointment set 4h
        Appointment appointm1 = new Appointment("essen", 4);
        //then the appointment is in shedule
        assertEquals(true, day1.makeAppointment(9, appointm1));
    }
    // negative test missing
}


