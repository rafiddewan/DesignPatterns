public class LineStyleDecorator extends ShapeDecorator {
	protected LineStyle style;

	public LineStyleDecorator(Shape decoratedShape, LineStyle style) {
		super(decoratedShape);
		this.style = style;
	}

	public void draw() {
		decoratedShape.draw();
		System.out.println("Line Style: " + style);
	}

	// no change in the functionality
	public void resize() {
		decoratedShape.resize();
	}

	public String description() {
		return decoratedShape.description() + " drawn with " + style + " lines.";
	}

	// no change in the functionality
	public boolean isHide() {
		return decoratedShape.isHide();
	}

}
