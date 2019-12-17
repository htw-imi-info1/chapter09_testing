

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Die Test-Klasse DayTest.
 *
 * @author  LK
 */
public class DayTest008
{
    private Day day1;
    private Appointment info1;
    private Appointment lab;

    /**
     * Konstruktor fuer die Test-Klasse DayTest
     */
    public DayTest008()
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
        day1 = new Day(1);
        info1 = new Appointment("Info1", 2);
        lab = new Appointment("Lab", 2);
        day1.makeAppointment(14, info1);
        day1.makeAppointment(16, info1);
    }

    @Test
    public void negativtest()
    {
        //when
        boolean actual=day1.makeAppointment(9,lab);
        //then
        assertEquals(false,actual);
    }

    @Test
    public void positivtest()
    {
        int actual=day1.findSpace(lab);
        assertEquals(9,actual);
    }
}
