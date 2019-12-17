
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DayTest.
 *
 * @author  Barne Kleinen
 */
public class DayTest011
{
    private Day day1;
    private Appointment appointment1;

    public void setupFairlyEmptyDay()
    {
        day1 = new Day(1);
        appointment1 = new Appointment("Soccer Practice", 2);
        day1.makeAppointment(12,appointment1);
    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void AppointmentsOverlapping()
    {
        //Given
        // don't call @Before method explicitely! 
        // if you use 2 different setups in this class,
        // remove the @Before annotations.
        setupFairlyEmptyDay();

        //when
        Appointment appointment1 = new Appointment("Dentist", 1);
        boolean res = day1.makeAppointment(12, appointment1);

        //Then
        assertEquals(false,res);

    }

    Day day2;
    public void TestSetUp()
    {
        // this setup did only modify local variables which made it useless
        day2 = new Day(2);
        Appointment appointment1 = new Appointment("Dentist", 1);
        Appointment appointment2 = new Appointment("Lunch Date", 2);
        Appointment appointment3 = new Appointment("Important business meeting", 2);
        day2.makeAppointment(9, appointment1);
        day2.makeAppointment(11, appointment2);
        day2.makeAppointment(14, appointment3);
    }

    @Test
    public void TestingGroceryShoppingOnAFullDay()
    {
        //given
        TestSetUp();

        //when
        Appointment appointment4 = new Appointment("Grocery Shopping", 1);
        boolean result = day2.makeAppointment(14, appointment4);

        //then
        assertEquals(false, result);
    }
    @Test
    public void TestingGroceryShoppingOnAnEmptyDay()
    {
        //given
        setupFairlyEmptyDay();

        //when
        Appointment appointment4 = new Appointment("Grocery Shopping", 1);
        boolean result = day1.makeAppointment(14, appointment4);

        //then
        assertEquals(true, result);
    }


    @Test
    public void testingYogaOnAPositiveDay()
    {
        //given
        setupFairlyEmptyDay();
        // this is unclear - this setup initializes day2, but you are using 
        // day1 in your test case!
        // assuming that you meant day2, I've adapted the test case below

        //when
        Appointment appointment5 = new Appointment("Yoga", 1);
        boolean result = day1.makeAppointment(10, appointment5);

        //then
        assertEquals(true, result);


    }
    @Test
    public void testingYogaOnANegativeDay()
    {
        //given
        TestSetUp();
        // this is unclear - this setup initializes day2, but you are using 
        // day1 in your test case!
        // assuming that you meant day2, I've adapted the test case below

        //when
        Appointment appointment5 = new Appointment("Yoga", 1);
        boolean result = day2.makeAppointment(9, appointment5);

        //then
        assertEquals(false, result);


    }


}
