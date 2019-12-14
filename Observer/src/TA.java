import java.util.Date;

public class TA implements ProfListener {

    public String name;

    public TA(String name){
        this.name = name;
    }

    public void proctor(Date date, String prof){
        System.out.println(name + " : " + prof + ", it's time to proctor on" + date);
    }

    public void relax(Date date, String prof){
        System.out.println(name + " : " + prof + ", it's time to relax since midterm got postsponed on " + date);
    }
    /**
     *
     * @param e
     */
    @Override
    public void midtermAnounced(CourseEvent e) {
        proctor(e.getMidtermDate(), e.getProfName());
    }

    /**
     *
     * @param e
     */
    @Override
    public void midtermPostponed(CourseEvent e) {
        relax(e.getMidtermDate(), e.getProfName());
    }
}
