

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

/**
 * The test class DayTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DayTest
{
    private Day day1;
    private Appointment a1;

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
        day1 = new Day(1);
        a1 = new Appointment("one hour appointment a1", 1);
    }
    public void fillDay(){
      Appointment a2,a3,a4,a5,a6,a7,a8,a9;
        a2 = new Appointment("a2", 1);
        a3 = new Appointment("a3", 1);
        a4 = new Appointment("a4", 1);
        a5 = new Appointment("a5", 1);
        a6 = new Appointment("a6", 1);
        a7 = new Appointment("a7", 1);
        a8 = new Appointment("a8", 1);
        a9 = new Appointment("a9", 1);
        day1.makeAppointment(9, a1);
        day1.makeAppointment(10, a2);
        day1.makeAppointment(11, a3);
        day1.makeAppointment(12, a4);
        day1.makeAppointment(13, a5);
        day1.makeAppointment(14, a6);
        day1.makeAppointment(15, a7);
        day1.makeAppointment(16, a8);
        day1.makeAppointment(17, a9);
    }
   

    @Test
    public void t4a_firstAppointmentInEmptyDayShouldSucceed()
    {
        //given: empty day 
        // (from setup)
        // when: make appointment
        boolean success = day1.makeAppointment(9, a1);
        // then: is successfull
        assertEquals(true,success );
    }
     @Test
    public void t4b_firstAppointmentInEmptyDayShouldActuallyScheduleAppointment()
    {
        //given: empty day 
        // (from setup)
        // when: make appointment
        boolean success = day1.makeAppointment(9, a1);
        // then: appoint is scheduled
        assertEquals(a1, day1.getAppointment(9) );
    }
     @Test
    public void t5_appointmentTooEarlyShouldFail()
    {
        //given: empty day 
        // (from setup)
        // when: make appointment @ 800
        boolean success = day1.makeAppointment(8, a1);
     // then: is not successfull
        assertEquals(false,success );
    }
      @Test
    public void t6_appointmentTooLateShouldFail()
    {
        //given: empty day 
        // (from setup)
        // when: make appointment @ 800
        boolean success = day1.makeAppointment(18, a1);
     // then: is not successfull
        assertEquals(false,success );
    }
    @Test
    public void t7a_secondAppointmentInNonEmptySlotFails()
    {
        //given: day w/ app. @1100
        Appointment originalAppointment = new Appointment("first",1);
        day1.makeAppointment(11, originalAppointment);
        // when: make appointment
        boolean success = day1.makeAppointment(11, a1);
        // then: is successfull
        assertEquals(false,success );
    }
    @Test
    public void t7b_secondAppointmentInNonEmptySlotLeavesFirstAppointment()
    {
          //given: day w/ app. @1100
        Appointment originalAppointment = new Appointment("first",1);
        day1.makeAppointment(11, originalAppointment);
        // when: make appointment
        boolean success = day1.makeAppointment(11, a1);
       // then: appoint not scheduled
        assertEquals(originalAppointment, day1.getAppointment(11) );
    }
}

