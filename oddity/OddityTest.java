
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class OddityTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class OddityTest
{
    private Oddity oddity1;
    public OddityTest(){
    }
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        oddity1 = new Oddity();
    }

    @Test
    public void testCaseWith1()
    {
        assertEquals(true, oddity1.isOdd(1));
    }

    @Test
    public void testCaseWith2()
    {
        assertEquals(false, oddity1.isOdd(2));
    }

    @Test
    public void testCaseWith17()
    {
        assertEquals(true, oddity1.isOdd(17));
    }

    @Test
    public void testCaseWith2000()
    {
        assertEquals(false, oddity1.isOdd(2000));
    }


    @Test
    public void testTheAnswer()
    {
        assertEquals(false, oddity1.isOdd(42));
    }

    @Test
    public void testCaseWithMinusOne()
    {
        assertEquals(true, oddity1.isOdd(-1));
    }
      @Test
    public void testCaseWithMinusOdd()
    {
        assertEquals(true, oddity1.isOdd(-3));
    }
    @Test
    public void testCaseWithMinusEven()
    {
        assertEquals(false, oddity1.isOdd(-4));
    }
    
    

    @Test
    public void testCaseWithMinusSth()
    {
        assertEquals(false, oddity1.isOdd(-10928734));
    }

    @Test
    public void testCaseWithZero()
    {
        assertEquals(false, oddity1.isOdd(0));
    }
       

}

