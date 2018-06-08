
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CalcEngineTest.
 */
public class CalcEngineTest
{
    private CalcEngine calcEngine;

    /**
     * Default constructor for test class CalcEngineTest
     */
    public CalcEngineTest()
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
        calcEngine = new CalcEngine();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testMinusEqualsPlus()
    {
        calcEngine.numberPressed(3);
        calcEngine.minus();  
        calcEngine.numberPressed(2);
        calcEngine.equals();
        calcEngine.plus();
        calcEngine.numberPressed(1);
        calcEngine.equals();
        assertEquals(2, calcEngine.getDisplayValue());
    }

    @Test
    public void testSimplePlus()
    {
        calcEngine.numberPressed(7);
        calcEngine.numberPressed(5);
        calcEngine.plus();
        calcEngine.numberPressed(3);
        calcEngine.equals();
        assertEquals(78, calcEngine.getDisplayValue());
    }

    @Test
    public void testSimpleMinus()
    {
        calcEngine.numberPressed(7);
        calcEngine.numberPressed(5);
        calcEngine.minus();
        calcEngine.numberPressed(2);
        calcEngine.numberPressed(0);
        calcEngine.equals();
        assertEquals(55, calcEngine.getDisplayValue());
    }

    @Test
    public void testSeveralPlus()
    {
        calcEngine.numberPressed(7);
        calcEngine.plus();
        calcEngine.numberPressed(5);
        calcEngine.plus();
        calcEngine.numberPressed(3);
        calcEngine.plus();
        calcEngine.numberPressed(5);
        calcEngine.equals();
        assertEquals(20, calcEngine.getDisplayValue());
    }

    @Test
    public void testSeveralMinus()
    {
        calcEngine.numberPressed(1);
        calcEngine.numberPressed(0);
        calcEngine.numberPressed(0);
        calcEngine.minus();
        calcEngine.numberPressed(5);
        calcEngine.minus();
        calcEngine.numberPressed(3);
        calcEngine.numberPressed(0);
        calcEngine.minus();
        calcEngine.numberPressed(5);
        calcEngine.equals();
        assertEquals(60, calcEngine.getDisplayValue());
    }

    @Test
    public void previousState()
    {
        // given: Calculator that did a minus op,
        // c pressed
        calcEngine.numberPressed(1);
        calcEngine.minus();  
        calcEngine.numberPressed(1);
        calcEngine.equals();
        calcEngine.clear();

        // when calculation is performed
        calcEngine.numberPressed(3);
        calcEngine.minus();  
        calcEngine.numberPressed(2);
        calcEngine.plus();
        calcEngine.numberPressed(1);
        calcEngine.equals();
        // then it should return 2
        assertEquals(2, calcEngine.getDisplayValue());
    }

    @Test
    public void clear()
    {
        // given: Calculator that did a minus op,
        // c pressed

        calcEngine.minus(); 
        calcEngine.clear();

        // when calculation is performed
        calcEngine.numberPressed(3);
        calcEngine.minus();  
        calcEngine.numberPressed(2);
        calcEngine.plus();
        calcEngine.numberPressed(1);
        calcEngine.equals();
        // then it should return 2
        assertEquals(2, calcEngine.getDisplayValue());
    }

}

