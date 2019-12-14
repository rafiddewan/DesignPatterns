import java.util.ArrayList;
import java.util.List;

public class CompositeElement extends  Element {

    private List<Element> element;

    public CompositeElement(String tag) {
        super(tag);
        this.element = new ArrayList<>();
    }

    public void addElement(Element elem){
        try{ element.add(elem); }
        catch (ClassCastException e) { e.printStackTrace(); }
    }

    @Override
    public String toString() {
        String s;
        s = "<" + getTag() + ">";
        s+= "\n";
        for (Element elem: element) {
            s += "\t" + elem;
            s += "\n";
        }
        s+= "\n";
        s += "</" + getTag() + ">";
        return s;
    }
}
