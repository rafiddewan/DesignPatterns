public class LineThicknessDecorator extends ShapeDecorator {
	protected double thickness;

	public LineThicknessDecorator(Shape decoratedShape, double thickness) {
		super(decoratedShape);
		this.thickness = thickness;
	}

	public void draw() {
		decoratedShape.draw();
		System.out.println("Line thickness: " + thickness);
	}

	// no change in the functionality
	public void resize() {
		decoratedShape.resize();
	}

	public String description() {
		return decoratedShape.description() + " drawn with line thickness " + thickness + ".";
	}

	// no change in the functionality
	public boolean isHide() {
		return decoratedShape.isHide();
	}

}
