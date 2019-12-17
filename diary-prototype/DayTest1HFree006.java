
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DayTest.
 *
 * @author  Barne Kleinen
 */
public class DayTest1HFree006
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

    }

    private void dayWith1hBreak(){
        day1.makeAppointment(9, info2);
        day1.makeAppointment(12, lab);
    }

    @Test
    public void ownTest1()
    {
        dayWith1hBreak();

        boolean actual = day1.makeAppointment(11, gdm);

        assertEquals("2 hours appointment shouldn't be created at 11 a.m. because an appointment already exists at 12 p.m.",false, actual);
    }

    @Test
    public void ownTest2()
    {
        dayWith1hBreak();

        day1.makeAppointment(14, lab);
        day1.makeAppointment(16, info2);

        int actualValue = day1.findSpace(gdm);

        assertEquals("No slot should be found",-1, actualValue);
    }
}
