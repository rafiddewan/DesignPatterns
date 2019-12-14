import java.util.Date;
import java.util.EventObject;

public class CourseEvent extends EventObject {

    private Date midtermDate;

    /**
     * Constructs a prototypical Event.
     *
     */
    public CourseEvent(Date date, Prof prof) {
        super(prof);
        this.midtermDate = date;
    }

    public Date getMidtermDate(){
        return this.midtermDate;
    }

    public String getProfName(){
        Prof p = (Prof) getSource();
        return p.getName();
    }

}
