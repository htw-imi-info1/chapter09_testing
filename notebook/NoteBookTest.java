
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class NoteBookTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class NoteBookTest
{
    
     NoteBook noteBook1;
    /**
     * Default constructor for test class NoteBookTest
     */
    public NoteBookTest()
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
        noteBook1 = new NoteBook();
        noteBook1.addNote("A");
        noteBook1.addNote("B");
        noteBook1.addNote("C");
    }

    @Test
    public void addingOneElementResultsInSizeOne(){
        // given: an empty notebook
        NoteBook noteBook = new NoteBook();
        // when: I add one elemnent
        noteBook.addNote("my note");
        // then: the size is one
        int actualSize = noteBook.size();
        assertEquals("there should be one element in the list",1,actualSize);

    }


    @Test
    public void removingOneElementReducesSizeByOne()
    {
    
        noteBook1.removeNoteContaining("C");
        assertEquals("size should be smaller than before",2, noteBook1.size());
    }

    @Test
    public void removingOneElementReturnsTrue()
    {      
        boolean deletedSomething =noteBook1.removeNoteContaining("C");
        assertEquals("should have deleted something",true,deletedSomething);
    }

    @Test
    public void removeFromEmptyNoteBookReturnsFalse()
    {
        NoteBook noteBook1 = new NoteBook();
        boolean deletedSomething = noteBook1.removeNoteContaining("X");
        assertEquals("should not have deleted something",false,deletedSomething);
    }
}

