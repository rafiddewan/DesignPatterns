import java.util.Date;

public class Student implements ProfListener {

    private  String name;

    public Student(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void party(Date date, String prof){
        System.out.println(name + " : " + prof + ", let's get lit fam since the midterm got pushed back to " +  date);
    }

    public void study(Date date, String prof){
        System.out.println(name  + " : " + prof  + ", you will end me on " + date);
    }
    /**
     *
     * @param e
     */
    @Override
    public void midtermAnounced(CourseEvent e) {
        study(e.getMidtermDate(), e.getProfName());
    }

    @Override
    public void midtermPostponed(CourseEvent e) {
        party(e.getMidtermDate(), e.getProfName());
    }
}
