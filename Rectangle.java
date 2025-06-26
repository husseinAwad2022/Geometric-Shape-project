 package project_java;
 
public class Rectangle extends GeometricShape {
	
	private double height;
	private double width;
	//=======================================
	public Rectangle() {
		
	}

	public Rectangle(double height, double width) {
		
		this.height = height;
		this.width = width;
	}

	public Rectangle(double height, double width,Color color,boolean filled,Coordinates location) {
		
		this.height = height;
		this.width = width;
	}
	//=======================================

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}
	//=======================================

	@Override
	public Coordinates getLocation() {
		return location;
	}

	@Override
	public void setLocation(Coordinates location) {
		this.location = location;
		
	}

	@Override
	public double getArea() {
		
		return height * width;
	}

	@Override
	public double getPerimeter() {
		
		return (2 * height) + (2 * width) ;
	}

	@Override
	public String toString() {
		return "Rectangle [height=" + height + ", width=" + width + "]";
	}	
}
