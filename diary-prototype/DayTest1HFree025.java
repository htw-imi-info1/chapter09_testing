import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DayTest.
 *
 * @author  Barne Kleinen
 */
public class DayTest1HFree025
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
    public void test2hSlotIsFound()
    {
        // given
        // day with 2h app on 9 and 12 hrs (setup)
        dayWith1hBreak();
        // when
        int actualValue = day1.findSpace(gdm);
        // then
        assertEquals("first slot with 2h available should be found",14, actualValue);
    }

    @Test
    public void testMakeApp15()
    {
        // given
        // day with 2h app on 9 and 12 hrs (setup)
        dayWith1hBreak();
        // when
        boolean actual = day1.makeAppointment(15, gdm);
        // then
        assertEquals(true, actual);
    }

    @Test
    public void testMakeApp16()
    {
        // given
        // day with 2h app on 9 and 12 hrs (setup)
        dayWith1hBreak();
        // when
        boolean actual = day1.makeAppointment(16, gdm);
        // then
        assertEquals(true, actual);
    }

    @Test
    public void testMakeApp17()
    {
        // given
        // day with 2h app on 9 and 12 hrs (setup)
         dayWith1hBreak();
       // when
        boolean actual = day1.makeAppointment(17, gdm);
        // then
        assertEquals(false, actual);
    }

    @Test
    public void testMakeApp18()
    {
        // given
         dayWith1hBreak();
       // day with 2h app on 9 and 12 hrs (setup)
        // when
        boolean actual = day1.makeAppointment(18, gdm);
        // then
        assertEquals(false, actual);
    }

    @Test
    public void testMakeApp9()
    {
        // given
        // empty day
        // when
        boolean actual = day1.makeAppointment(9, gdm);
        // then
        assertEquals(true, actual);
    }

    @Test
    public void testAppointmentWasActuallyScheduled()
    {
        // given empty day
        // when 
        day1.makeAppointment(14, info2);
        // then appointment is in schedule
        Appointment actual = day1.getAppointment(14);
        assertEquals(info2, actual);
    }
    
    //Zu 1.)
    @Test
    public void testCorrectNextFreeTime()
    {
        Appointment testEvent = new Appointment("testEvent", 1);
        day1.makeAppointment(9, testEvent);
        int nextFreeTime = day1.findSpace(testEvent);
        
        //Wenn zurueckgegebene naechst-freie Zeit um 10 Uhr
        assertEquals(nextFreeTime, 10);
    }
    
    //Zu 2.)
    @Test
    public void testAlreadyFullDay()
    {
        Appointment testEvent = new Appointment("testEvent", 9);
        day1.makeAppointment(9, testEvent);
        int nextFreeTime = day1.findSpace(testEvent);
        
        //Wenn zurueckgegebene naechst-freie Zeit um 10 Uhr
        assertEquals(nextFreeTime, -1);
    }
    
    //Zu 4.)
    @Test
    public void testTimeCollision()
    {
        //Ein-Stunden Termin ab 09 Uhr
        Appointment testEvent01 = new Appointment("testEvent01", 1);
        boolean termin01Status = day1.makeAppointment(9, testEvent01);
        
        //Vier-Stunden Termin ab 09 Uhr
        Appointment testEvent02 = new Appointment("testEvent02", 4);
        boolean termin02Status = day1.makeAppointment(9, testEvent02);
        
        assertEquals(termin01Status && termin02Status, true);
    }
    
    //Zu 6.)
    @Test
    public void testCorrectDay()
    {
        int dayDate = 10;
        Day testDay = new Day(dayDate);
        
        int returnedDayDate = testDay.getDayNumber();
        
        assertEquals(returnedDayDate, dayDate);
    }
    
    @Test
    public void testTerminNachts()
    {
        //Zehn-Stunden Termin ab 16 Uhr
        Appointment testEvent = new Appointment("testEvent", 10);
        day1.makeAppointment(16, testEvent);
    }
}


