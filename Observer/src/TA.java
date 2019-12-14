import java.util.Date;

public class TA implements ProfListener {

    public String name;

    public TA(String name){
        this.name = name;
    }

    public void proctor(Date date){
        System.out.println(name + " : Time to proctor on" + date);
    }

    public void relax(Date date){
        System.out.println(name + "Time to relax since midterm got postsponed too" + date);
    }
    /**
     *
     * @param e
     */
    @Override
    public void midtermAnounced(CourseEvent e) {

    }

    /**
     *
     * @param e
     */
    @Override
    public void midtermPostponed(CourseEvent e) {

    }
}
