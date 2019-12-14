import java.util.Date;
import java.util.EventObject;

public class CourseEvent extends EventObject {

    private Date midtermDate;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public CourseEvent(Object source) {
        super(source);
    }


}
