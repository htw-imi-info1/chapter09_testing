
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
    /**
     * Default constructor for test class OddityTest
     */
    public OddityTest()
    {
    }

    @Test
    public void test5(){
        assertEquals(true,Oddity.isOdd(5));
    }

    @Test
    public void test6(){
        assertEquals(false,Oddity.isOdd(6));
    }

    @Test
    public void test0(){
        assertEquals(false,Oddity.isOdd(0));
    }

    @Test
    public void testminus2(){
        assertEquals(false,Oddity.isOdd(-2));
    }

    @Test
    public void testminus723(){
        assertEquals(true,Oddity.isOdd(-723));

    }
}
