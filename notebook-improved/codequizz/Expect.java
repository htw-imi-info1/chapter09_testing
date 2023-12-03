package codequizz;
import static org.junit.jupiter.api.Assertions.*;

public class Expect
{
    public static boolean ON = false;
    public static final String ____ = "FILL THIS IN";

    public static void expect(String expected, String actual){
        StackTraceElement caller = Thread.currentThread().getStackTrace()[2];
        String clazz = caller.getClassName();
        String method = caller.getMethodName();
        int line = caller.getLineNumber();
        String context = clazz+"::"+method+":"+line;
        context = caller.toString();
        
        if(!ON || expected.equals(actual)) return;
        if(____.equals(expected))
            fail("fill in: "+context);
        else 
            fail("\""+expected + "\" is not correct! - try again: "+context);
    }
}
