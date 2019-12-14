public class XMLDocument {
    private Element root;

    public XMLDocument(Element root){
        this.root = root;
    }

    @Override
    public String toString() {
        return root.toString();
    }

    public static void main(String[] args){
        SimpleElement se = new SimpleElement("student", "babak");
        XMLDocument doc1 = new XMLDocument(se);
        System.out.println(doc1);
        CompositeElement ce = new CompositeElement("uni");
        ce.addElement(se);
        XMLDocument doc2 = new XMLDocument(ce);
        System.out.println(doc2);
        SimpleElement se2 = new SimpleElement("student", "vicky");
        ce.addElement(se2);
        System.out.println(doc2);
        CompositeElement ce2 = new CompositeElement("world");
        ce2.addElement(ce);
        ce2.addElement(se);
        XMLDocument doc3 = new XMLDocument(ce2);
        System.out.println(doc3);
    }
}
