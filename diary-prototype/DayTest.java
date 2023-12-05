
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static testhelper.Bug.assertEqualsBug;
import static testhelper.Bug.assertEqualsBugException;
import static testhelper.Bug.FAIL_BUGS;
import static testhelper.Bug.SILENCE_ALL_BUGS;
public class DayTest
{
    private Day day1;
    private Appointment info1;
    private Appointment info2;

    /**
     * Default constructor for test class DayTest
     */
    public DayTest()
    {
        FAIL_BUGS = false;
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        day1 = new Day(1);
        info1 = new Appointment("info1", 2);
        day1.makeAppointment(11, info1);
        info2 = new Appointment("info2", 2);
    }

    @Test
    public void makeAppointmentWith2ndHourFull()
    {   //given 
        // day1 one has one 2h appointment at 1100
        // when I try to make 2hr app. at 10
        boolean actual = day1.makeAppointment(10, info2);
        // then false should be returned
        boolean expected = false;
        assertEqualsBug(expected, actual);
    }

    @Test
    public void findSpace()
    {   //given 
        // day1 one has one 2h appointment at 1100
        // when I try to make 2hr app. at 10
        int actual = day1.findSpace(info2);
        // then false should be returned
        int expected = 9;
        assertEquals(expected, actual);
    }
}

