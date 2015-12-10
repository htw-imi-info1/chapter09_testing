
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CalcEngineTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
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

    @Test
    public void testMinusWithHistory()
    {
        // given: 6-2= C
        calcEngine.numberPressed(6);
        calcEngine.minus();
        calcEngine.numberPressed(2);
        calcEngine.equals();
        calcEngine.clear();
        // when...
        calcEngine.numberPressed(3);
        calcEngine.minus();
        calcEngine.numberPressed(4);
        calcEngine.equals();
        // then
        assertEquals(-1,calcEngine.getDisplayValue());

    }

    @Test
    public void testSimpleMinus()
    {
        // given: new CalcEngine
        // when...
        calcEngine.numberPressed(3);
        calcEngine.minus();
        calcEngine.numberPressed(4);
        calcEngine.equals();
        // then
        assertEquals(-1,calcEngine.getDisplayValue());

    }

}
