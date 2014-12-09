import java.util.*;
/**
 * Write a description of class NoteBook here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NoteBook
{
    // instance variables - replace the example below with your own
    private ArrayList<String> notes;

    /**
     * Constructor for objects of class NoteBook
     */
    public NoteBook()
    {
       notes = new ArrayList<>();
    }

    public void addNote(String note){
        notes.add(note);
    }
    
    public int size(){
        return notes.size();
    }
    public boolean removeNoteContaining(String searchString){
        Iterator<String> it = notes.iterator();
        while(it.hasNext()){
            String note = it.next();
            if(note.contains(searchString)){
                it.remove(); 
                return true;
            }
        }
        return false;
    }
}
