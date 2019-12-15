public class LineColorDecorator extends ShapeDecorator {
	protected Color color;

	public LineColorDecorator(Shape decoratedShape, Color color) {
		super(decoratedShape);
		this.color = color;
	}

	public void draw() {
		decoratedShape.draw();
		System.out.println("Line Color: " + color);
	}

	// no change in the functionality
	public void resize() {
		decoratedShape.resize();
	}

	public String description() {
		return decoratedShape.description() + " drawn with " + color + " color.";
	}

	// no change in the functionality
	public boolean isHide() {
		return decoratedShape.isHide();
	}

}
