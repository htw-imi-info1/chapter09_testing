
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static testhelper.Bug.assertEqualsBug;
import static testhelper.Bug.FAIL_BUGS;

/**
 * This Class shows an example how to document a bug
 * with using assertEqualsBug from the testhelper 
 * package
 *
 * @author Barne Kleinen
 */
public class BugTestDemo
{
    public BugTestDemo(){
        FAIL_BUGS = false;
    }

    @Test
    public void demoOKTest(){
        String expected = "expected is the same as actual value";
        String actual = "expected is the same as actual value";
        assertEquals(actual, expected);
    }

    @Test
    public void demoBugTest(){
        String expected = "expected value";
        String actual = "actual value";

        assertEqualsBug(expected, actual);
    }
}
