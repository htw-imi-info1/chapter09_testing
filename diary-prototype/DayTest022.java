



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DayTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DayTest022
{
    private Day day1;
    private Appointment TutINFO;
    private Appointment INFO;
    private Appointment CS;
    private Appointment Break;

    
    
    
    

    /**
     * Default constructor for test class DayTest
     */
    public DayTest022()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        day1 = new Day(344);
        TutINFO = new Appointment("TutINFO", 1);
        INFO = new Appointment("INFO", 4);
        Break = new Appointment("Break", 2);
        day1.makeAppointment(12, Break);
    }

    
    

    @Test
    public void doesNotFit()
    {
        //given empty day & break from 12-14
        //when info is 4h long
        //then it should return false when tying to put before the break.
        //because there is not enough time 
        //before the break. Should be recommended after break.
        assertEquals(false, day1.makeAppointment(9, INFO));
    }


    @Test
    public void recommendAfterBreak()
    {  
        //given empty day & break from 12-14
        //when INFO would overwrite break
        //then recommend INFO after break
        assertEquals(14, day1.findSpace(INFO));
    }

    @Test
    public void noOverwrite()
    {
        //given- a day with a 2 hour break from 12pm to 2pm
        //when appointment overwrites break
        //then return false
        assertEquals(true, day1.validTime(12));
        assertEquals(false, day1.makeAppointment(9, INFO));     
    }

    @Test
    public void doWeHaveBreak()
    {
        //given empty day & break from 12-14
        //when we look up if we have our break
        //then we have the appointment break at 12 & 13
        assertEquals(Break, day1.getAppointment(12));
        assertEquals(Break, day1.getAppointment(13));
    }
}






