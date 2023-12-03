
public class Note
{
    String title, text;

    public Note(String title, String text){
        this.title = title; 
        this.text = text;
    }

    @Override
    public String toString(){
        return "# "+title+"\n"+text+"\n";
    }

    @Override
    public boolean equals(Object other){
        if (!(other instanceof Note))
            return false;
        Note otherNote = (Note)other;
        return this.toString().equals(otherNote.toString());
    }

    @Override
    public int hashCode(){
        return toString().hashCode();
    }

}
