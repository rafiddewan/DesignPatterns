import java.util.Date;

public class Student implements ProfListener {

    private  String name;
    private Date midterm;

    public Student(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void party(Date date){
        this.midterm = date;
        System.out.println(name + " : Let's get lit fam since the midterm got pushed back to " +  this.midterm);
    }

    public void study(Date date){
        this.midterm = date;
        System.out.println(name  + " : my funeral is on" + this.midterm);
    }
    /**
     *
     * @param e
     */
    @Override
    public void midtermAnounced(CourseEvent e) {

    }

    @Override
    public void midtermPostponed(CourseEvent e) {

    }
}
