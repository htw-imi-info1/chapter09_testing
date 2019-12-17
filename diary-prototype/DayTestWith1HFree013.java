
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DayTest.
 *
 * @author  Barne Kleinen
 */
public class DayTestWith1HFree013
{
    private Day day1;
    private Appointment info2;
    private Appointment lab;
    private Appointment gdm;
    private Appointment cs;
    private Appointment eng;

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
        cs = new Appointment("CS", 2);
        eng = new Appointment("ENG", 1);
    }

    private void dayWithFreeAfternoon(){
        day1.makeAppointment(9, info2); // 9-11
        day1.makeAppointment(11, eng);  // 11-12
                                        // 1h launch break
        day1.makeAppointment(13, gdm);  //13-15
        day1.makeAppointment(15, cs);   //15-17
    }
    
    //Test for 1h launch break at 12h (positiv)
    @Test
    public void launchBreakAt12H()
    {
        // given
        dayWithFreeAfternoon();
        // when
        boolean actualValue = day1.makeAppointment(12 ,eng);
        // then
        assertEquals(true, actualValue);
    }
    
    //Test for Appointments at certain times (negativ)
    @Test
    public void testForAppAt9()
    {
        // given
        dayWithFreeAfternoon();
        // when
        boolean actual = day1.makeAppointment(9, eng);
        // then
        assertEquals(false, actual); 
    }
    @Test
    public void testForAppAt10()
    {
        // given
        dayWithFreeAfternoon();
        // when
        boolean actual = day1.makeAppointment(10, eng);
        // then
        assertEquals(false, actual); 
    }
    @Test
    public void testForAppAt11()
    {
        // given
        dayWithFreeAfternoon();
        // when
        boolean actual = day1.makeAppointment(11, eng);
        // then
        assertEquals(false, actual); 
    }
    @Test
    public void testForAppAt13()
    {
        // given
        dayWithFreeAfternoon();
        // when
        boolean actual = day1.makeAppointment(13, eng);
        // then
        assertEquals(false, actual); 
    }
    @Test
    public void testForAppAt14()
    {
        // given
        dayWithFreeAfternoon();
        // when
        boolean actual = day1.makeAppointment(14, eng);
        // then
        assertEquals(false, actual); 
    }   
    @Test
    public void testForAppAt15()
    {
        // given
        dayWithFreeAfternoon();
        // when
        boolean actual = day1.makeAppointment(15, eng);
        // then
        assertEquals(false, actual); 
    }
    @Test
    public void testForAppAt16()
    {
        // given
        dayWithFreeAfternoon();
        // when
        boolean actual = day1.makeAppointment(16, eng);
        // then
        assertEquals(false, actual); 
    }
    
}


