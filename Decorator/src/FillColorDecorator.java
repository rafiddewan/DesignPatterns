public class FillColorDecorator extends ShapeDecorator {
	protected Color color;

	public FillColorDecorator(Shape decoratedShape, Color color) {
		super(decoratedShape);
		this.color = color;
	}

	public void draw() {
		decoratedShape.draw();
		System.out.println("Fill Color: " + color);
	}

	// no change in the functionality
	// we can add in the functionality if we like. there is no restriction
	// except we need to maintain the structure of the Shape APIs
	public void resize() {
		decoratedShape.resize();
	}

	public String description() {
		return decoratedShape.description() + " filled with " + color + " color.";
	}

	// no change in the functionality
	public boolean isHide() {
		return decoratedShape.isHide();
	}

}
