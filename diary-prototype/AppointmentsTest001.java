import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DayTest.
 *
 * @author  AK
 */
public class AppointmentsTest001
{
    private Day day1;
    private Day day2; // zweiter Tag hinzugef�gt f�r den "setUp"
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
        day1 = new Day(1); // Tag, um die Tests �berhaupt ausf�hren zu k�nnen.
        day2 = new Day(2); // Weiteren Tag hinzugef�gt um weitere Tests auszuf�hren
                           // um die �bersicht beizuhalten.

        // Parameter, um die Termine mit ihren Stunden festlegen zu k�nnen.
        info2 = new Appointment("Info 1", 2);
        lab = new Appointment("Lab", 2);
        gdm = new Appointment("GDM", 3); // GDM von 2 Stunden auf 3 Stunden gewechselt
    }

    // erster Tag f�r ersten Test
    private void day1With1hBreak(){
        day1.makeAppointment(9, info2);
        day1.makeAppointment(12, lab);
    }

    // erster Test
    @Test
    public void makeApp11(){
        day1With1hBreak();
        // mit "findSpace()" versucht zu gucken, ob f�r "info2" was frei ist.
        int space = day1.findSpace(info2);
        // dann festgesetzt, dass die Variable, die sich bilden soll, nach den
        // Terminen passiert. Sprich 12 - 14 das "lab", deshalb ab 14 Uhr schauen
        // ob es Platz gibt
        assertEquals(14, space);
        // Die Variable space dann einsetzen als Basis f�r weitere Termine.
        // In diesem Fall funktioniert es, weil "space" = 14 => Tag geht bis 17 Uhr.
        // Daraus folgt, dass durch 3 Stunden frei, ein Termin mit "info2" reinpasst.
        boolean actual = day1.makeAppointment(space, info2);
        assertEquals(true, actual);
    }

    // zweiter Tag f�r zweiten Test
    public void day2with3hBreak(){
        day2.makeAppointment(9, info2);
        day2.makeAppointment(14, lab);
    }

    // zweiter Test
    @Test
    public void makefalseApp(){
        // when
        day2with3hBreak();
        // Selbe Prozedere, nur das die Variable "gdm" f�r 3 Stunden geht.
        boolean actual = day2.makeAppointment(16, gdm);
        // Bei dem Festsetzen der Zeit (hier 16), ist es nicht m�glich einen Termin
        // festzusetzen, weil die Dauer des Termins �ber die Grenze hinausgeht.
        // Zur Info: Grenze, um Termine einzutragen ist von 09:00 Uhr bis 17:00 Uhr
        assertEquals ("bug!",false, actual);
        //BK: this is a negative test - it is expected to return false
    }


    //Ausklammerung von den Methoden aus der Vorlesung

    /**
    @Test //f�r �bergrenzen der Zeit = Falsch
    public void testMakeApp16()
    {
        // given
        // day with 2h app on 9 and 12 hrs (setup)
        day1With1hBreak();
        // when
        boolean actual = day1.makeAppointment(16, gdm);
        // then
        assertEquals(true, actual);
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
        boolean actual = day1.makeAppointment(0, gdm);
        // then
        assertEquals(true, actual);
    }



    @Test
    public void testAppointmentWasActuallyScheduled()
    {
        // given empty day
        // when
        day1.makeAppointment(13, info2);
        // then appointment is in schedule
        Appointment actual = day1.getAppointment(14);
        assertEquals(info2, actual);
    }*/
}
