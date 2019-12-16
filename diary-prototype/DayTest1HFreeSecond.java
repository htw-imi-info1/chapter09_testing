
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DayTest.
 *
 * @author  Barne Kleinen
 */
public class DayTest1HFreeSecond
{
    private Day day1;
    private Appointment info2;
    private Appointment lab;
    private Appointment gdm;

  

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        day1 = new Day(1); // this is the sut - subject under test
        info2 = new Appointment("Info 1", 2);
        lab = new Appointment("Lab", 2);
        gdm = new Appointment("GDM", 2);
        day1.makeAppointment(9, info2);
        day1.makeAppointment(12, lab);

    }


  

    @Test
    public void test2hAppIn1hSlot()
    {
        // given day with 1 h free @ 11:00
        // when I put an 2h appointment at 11:00
        boolean result = day1.makeAppointment(11, gdm);
        // then false should be returned
        assertEquals("when I put an 2h appointment at 11:00",false, result);
    }
    
     @Test
    public void test2hAppIn1hSlotDoesNotOverwriteExistingApp()
    {
        // given day with 1 h free @ 11:00
        // when I put an 2h appointment at 11:00
        boolean result = day1.makeAppointment(11, gdm);
        // then existing was not overwritten should be returned
        assertEquals(lab,day1.getAppointment(12));
    }
}



