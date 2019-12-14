import java.util.ArrayList;
import java.util.Date;

public class Prof {

    private ArrayList<ProfListener> profListeners;
    private String name;

    public Prof(String name){
        this.name = name;
        profListeners = new ArrayList<>();
    }

    public void setMidtermDate(Date midtermDate) {
        CourseEvent e = new CourseEvent(midtermDate, this);
        for(ProfListener cl: profListeners){
            cl.midtermAnounced(e);
        }
    }

    public void postponeMidtermDate(Date midtermDate){
        CourseEvent e = new CourseEvent(midtermDate, this);
        for(ProfListener cl: profListeners){
            cl.midtermPostponed(e);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<ProfListener> getProfListeners() {
        return profListeners;
    }

    public boolean removeProfListener(int index){
        if(profListeners.size() != 0 && index < profListeners.size()) {
            profListeners.remove(index);
            return true;
        }
        return false;
    }

    public void addProfListener(ProfListener c){
        if(c != null) {
            profListeners.add(c);
        }
    }

    public static void main(String[] args){
        Prof Babak = new Prof("Babak");
        Student Rafid = new Student("Rafid");
        TA Moe = new TA("Moe");

        //Add Prof Listeners
        Babak.addProfListener(Rafid);
        Babak.addProfListener(Moe);

        //Set the midterm date
        Babak.setMidtermDate(new Date());
        Babak.postponeMidtermDate(new Date());
    }

}
