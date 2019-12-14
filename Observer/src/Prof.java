import java.util.ArrayList;
import java.util.Date;

public class Prof {

    private ArrayList<ProfListener> profListeners;
    private Date midtermDate;
    private String name;

    public Prof(String name){
        this.name = name;
    }

    public Date getMidtermDate() {
        return midtermDate;
    }

    public void setMidtermDate(Date midtermDate) {
        this.midtermDate = midtermDate;
        CourseEvent e = new CourseEvent(this);
        for(ProfListener cl: profListeners){
            cl.midtermAnounced(e);
        }
    }

    public void postponeMidtermDate(Date midtermDate){
        this.midtermDate = midtermDate;
        CourseEvent e = new CourseEvent(this);
        for(ProfListener cl: profListeners){
            cl.midtermPostponed(e);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean removeCourseListener(ProfListener c){
        if(profListeners.size() != 0) {
            profListeners.remove(c);
            return true;
        }
        return false;
    }

    public void addCourseListener(ProfListener c){
        profListeners.add(c);
    }

    public static void main(String[] args){
        Prof Babak = new Prof("Babak");
        Student Rafid = new Student("Rafid");
        TA Moe = new TA("Moe");
        Babak.setMidtermDate(new Date());
    }

}
