public class SimpleElement extends Element {

    private String value;

    public SimpleElement(String tag, String value) {
        super(tag);
        this.value = value;
    }

    @Override
    public String toString() {
        return "<" + getTag() + ">" + value + "</" + getTag() + ">";
    }
}
