

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Die Test-Klasse DayTest.
 *
 * @author  AS
 * @version 13.12.2019
 */
public class DayTest003
{
    private Day day1;
    private Appointment appointm1;

    /**
     * Konstruktor fuer die Test-Klasse DayTest
     */
    public DayTest003()
    {
    }

    /**
     *  Setzt das Testger�st fuer den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @Before
    public void AppointmentAtSix()
    {
        day1 = new Day(1);
        appointm1 = new Appointment("piano lesson", 2);
        day1.makeAppointment(6, appointm1);
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
    public void AppointmentsOverlapping()
    {
        //given
        AppointmentAtSix();
        //when
        Appointment concert = new Appointment("Trettman", 3);
        boolean actual = day1.makeAppointment(7, concert);
        //then
        assertEquals(false, actual);
    }


    @Before
    public void LunchBreak()
    {
        Day day1 = new Day(2);
        Appointment appointm2 = new Appointment("Math", 4);
        Appointment appointm3 = new Appointment("Info", 2);
        Appointment appointm4 = new Appointment("CS", 1);
        day1.makeAppointment(9, appointm3);
        day1.makeAppointment(12, appointm2);
        day1.makeAppointment(16, appointm4);
    }

    @Test
    public void LunchBreakAppointment()
    {
        //given
        LunchBreak();
       //when
       Appointment appointm4 = new Appointment ("LunchBreak", 1);
       boolean result= day1.makeAppointment(11, appointm4);
       //then
       assertEquals(true, result);
    }


}
