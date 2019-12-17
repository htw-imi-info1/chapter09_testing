
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

    @Before
    public void AppointmentTest1()
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
        AppointmentTest1();

        //when
        Appointment appointment1 = new Appointment("Dentist", 1);
        boolean res = day1.makeAppointment(12, appointment1);

        //Then
        assertEquals(true,res);

    }


    @Before
    public void TestSetUp()
    {
        Day day2 = new Day(2);
        Appointment appointment1 = new Appointment("Dentist", 1);
        Appointment appointment2 = new Appointment("Lunch Date", 2);
        Appointment appointment3 = new Appointment("Important business meeting", 2);
        day2.makeAppointment(9, appointment1);
        day2.makeAppointment(11, appointment2);
        day2.makeAppointment(14, appointment3);
    }

    @Test
    public void TestingGroceryShopping()
    {
        //given
        TestSetUp();

        //when
        Appointment appointment4 = new Appointment("Grocery Shopping", 1);
        boolean result = day1.makeAppointment(14, appointment4);

        //then
        assertEquals(true, result);
    }


    @Test
    public void TestingYoga()
    {
        //given
        TestSetUp();

        //when
        Appointment appointment5 = new Appointment("Yoga", 1);
        boolean result = day1.makeAppointment(10, appointment5);

        //then
        assertEquals(false, result);


    }


}
