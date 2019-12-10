

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DayTest.
 *
 * @author  Barne Kleinen
 */
public class DayTest
{
    private Day day1;
    private Appointment info2;
    private Appointment lab;
    private Appointment gdm;

    /**
     * Default constructor for test class DayTest
     */
    public DayTest()
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
        day1 = new Day(1); // this is the sut - subject under test
        info2 = new Appointment("Info 1", 2);
        lab = new Appointment("Lab", 2);
        day1.makeAppointment(9, info2);
        day1.makeAppointment(12, lab);
        gdm = new Appointment("GDM", 2);
    }

    

    @Test
    public void test2hSlotIsFound()
    {
        // given
        // day with 2h app on 9 and 12 hrs (setup)
        // when
        int actualValue = day1.findSpace(gdm);
        // then
        assertEquals("first slot with 2h available should be found",14, actualValue);
    }
}

