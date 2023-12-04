package testhelper;
import static org.junit.jupiter.api.Assertions.*;

public class Bug
{
    public static boolean FAIL_BUGS = true;

    public static void assertEqualsBug(Object expected, Object actual){
        if (!FAIL_BUGS)
            return;
        StackTraceElement caller = Thread.currentThread().getStackTrace()[2];
        String context = caller.toString();
        assertEquals(expected,actual,"found BUG in "+caller+":");
    }
}
