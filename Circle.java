package project_java;

public class Circle extends GeometricShape {
	
	private double radius;

	public Circle() {
		super();
	}

	public Circle(double radius) {
			super();
			this.radius = radius;
		}
	
	public Circle(double radius,Color color,boolean filled,Coordinates location) {
		super();
		this.radius = radius;
	}	
	//==============================================
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}	
	//==============================================

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
		
		return 2 * Math.PI * radius;
	}

	@Override
	public double getPerimeter() {
		
		return Math.PI * Math.pow(radius,2);
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}
}