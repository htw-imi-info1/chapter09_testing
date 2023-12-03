import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static codequizz.Expect.*;
import static org.junit.jupiter.api.Assertions.*;
/**
 * This class is an exercise in understanding object references.
 * First, start the code Quizz by setting CodeQuizz.ON = true;
 * Go through the test cases, and find the places where you need 
 * to fill in your solution, for example:
 * CodeQuizz.expect(____,note1.getText());
 * 
 * replace the ____ with your expectation of the result.
 */
public class ObjectReferencePlayground
{

    public static final String ____ = CodeQuizz.____;
    public ObjectReferencePlayground()
    {
        CodeQuizz.ON = true;
    }

    @Test
    public void koan01(){
        Note note1 = new Note("one title", "some longer text");
        Note note2 = note1;
        assertEquals("some longer text",note1.getText());
        note2.setText("new text");
        CodeQuizz.expect(____,note1.getText());

    }

    @Test
    public void koan2(){
        Note note1 = new Note("one title", "some longer text");
        Note note2 = new Note("one title", "some longer text");
        assertEquals("some longer text",note1.getText());
        note2.setText("new text");
    }
}
