public class Rectangle implements Shape {

	public void draw() {
		System.out.println("Drawing Rectangle");
	}

	public void resize() {
		System.out.println("Resizing Rectangle");
	}

	public String description() {
		return "Rectangle object";
	}

	public boolean isHide() {
		return false;
	}

}
