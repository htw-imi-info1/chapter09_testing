
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DayTest.
 *
 * @author  Barne Kleinen
 */
public class DayTestFullDay024
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
    public void setUpFullDay()
    {
        day1 = new Day(1); // this is the sut - subject under test
        info2 = new Appointment("Info 2", 3);
        lab = new Appointment("Lab", 3);
        gdm = new Appointment("GDM", 3);
        day1.makeAppointment(9, info2);
        day1.makeAppointment(12, lab);
        day1.makeAppointment(15, gdm);
    }
    
    @Before
    public void setUpHalfDay()
    {
        day1 = new Day(1); // this is the sut - subject under test
        info2 = new Appointment("Info 2", 3);
        lab = new Appointment("Lab", 3);
 
        day1.makeAppointment(9, info2);
        day1.makeAppointment(12, lab);

    }

    @Test //negative Case
    public void testMakeAppointmentOverApp()
    {
        // given
        setUpFullDay();
        // when
        boolean actual = day1.makeAppointment(15, gdm);
        // then
        assertEquals(false, actual);
    }
    
    @Test //negative Case
    public void testMakeAppointmentOutOfTime()
    {
        // given
        setUpFullDay();
        // when
        boolean actual = day1.makeAppointment(21, gdm);
        // then
        assertEquals(false, actual);
    }
    
    @Test  //positive Case
    public void testMakeAppointmentHalfDay()
    {
        // given
        setUpHalfDay();
        // when
        boolean actual = day1.makeAppointment(15, gdm);
        // then
        assertEquals(true, actual);
    }

    @Test  //negative Case
    public void testFindSpace()
    {
        // given
        setUpFullDay();
        // when
        int actual = day1.findSpace(gdm);
        // then
        assertEquals(-1, actual);
    }
}
    

    
    
 


