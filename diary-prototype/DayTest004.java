

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Die Test-Klasse DayTest.
 *
 * @author  (AK)
 * @version (14.12.2019)
 */
public class DayTest004
{
    private Day day1;
    private Appointment apmtn1;

    public DayTest004()
    {
    }

    @Before
    public void Appointment1()
    {
     day1 = new Day(1);
     apmtn1= new Appointment("Fu�ball", 2);
     day1.makeAppointment(9, apmtn1);

    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void appointmentUeberschneidung(){
    Appointment1();
    Appointment arzt = new Appointment("Arzt Termin", 2);
    boolean pa = day1.makeAppointment(10, arzt);
    assertEquals(false, pa);
    }

    @Before
    public void appointment2(){
    Day day1 = new Day(2);
    Appointment apmtn2 = new Appointment("Arbeit", 7);
    Appointment apmtn3 = new Appointment("Joggen", 1);
    day1.makeAppointment(9, apmtn2);
    day1.makeAppointment(17, apmtn3);
    }

    @Test
    public void gl�hweinTrinken(){
    appointment2();
    Appointment apmtn4 = new Appointment("Gl�hwein trinken", 1);
    boolean pa2= day1.makeAppointment(16, apmtn4);
    assertEquals(true, pa2);

    }
}
