

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;
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
    /**
     * das gehört natürlich auch nicht in die Endgültige
     * Testklasse!
     */
    @Test
    public void 
    whatWeHaveLearned(){
        assertEquals(-2147483648,Integer.MIN_VALUE);
        assertEquals(2147483647,Integer.MAX_VALUE);
        assertEquals(-1,-5%2);
        assertEquals(2147483646,Integer.MAX_VALUE-1);
        // und deshalb hatten wir die endlosschleife:
        assertEquals(-2147483648,(Integer.MAX_VALUE-1)+2);
        assertEquals(true,(Integer.MAX_VALUE-1)+2 < Integer.MAX_VALUE);
    }
    
    /*
     * this test is too slow!
     */
    public void allEvenNumbers(){
        for (int i=Integer.MIN_VALUE;i<=Integer.MAX_VALUE-2; i+=2){
          assertEquals(false,Oddity.isOdd(i));
        }
    }
    /*
     * this test is too slow!
     */
    @Ignore
    public void allOddNumbers(){
        for (int i=Integer.MIN_VALUE+1;i<=Integer.MAX_VALUE-2; i+=2){
          assertEquals(true,Oddity.isOdd(i));
        }
    }
    @Test
    public void fourIsEven()
    {
        assertEquals(false, Oddity.isOdd(4));
    }
    @Test
    public void threeIsOdd()
    {
        assertEquals(true, Oddity.isOdd(3));
    }

    @Test
    public void zeroShouldBeEven()
    {
        assertEquals(false, Oddity.isOdd(0));
    }
    @Test
    public void minusThreeIsOdd()
    {
        assertEquals(true, Oddity.isOdd(-3));
    }
    @Test
    public void minusFourHundredIsEven()
    {
        assertEquals(false, Oddity.isOdd(-400));
    }

}


