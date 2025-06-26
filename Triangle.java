package project_java;

public class Triangle extends GeometricShape {
	
	private Coordinates firstCorner;
	private Coordinates secondCorner;
	private Coordinates thirdCorner;
	//========================================
	public Triangle() {
		super();
	}

	public Triangle(Coordinates firstCorner, Coordinates secondCorner, Coordinates thirdCorner) {
		
		this.firstCorner = firstCorner;
		this.secondCorner = secondCorner;
		this.thirdCorner = thirdCorner;
	}
	
	public Triangle(Coordinates firstCorner, Coordinates secondCorner, Coordinates thirdCorner,Color color,boolean filled,Coordinates location) {
		
		this.firstCorner = firstCorner;
		this.secondCorner = secondCorner;
		this.thirdCorner = thirdCorner;
	}
	//========================================

	public Coordinates getFirstCorner() {
		return firstCorner;
	}

	public void setFirstCorner(Coordinates firstCorner) {
		this.firstCorner = firstCorner;
	}

	public Coordinates getSecondCorner() {
		return secondCorner;
	}

	public void setSecondCorner(Coordinates secondCorner) {
		this.secondCorner = secondCorner;
	}

	public Coordinates getThirdCorner() {
		return thirdCorner;
	}

	public void setThirdCorner(Coordinates thirdCorner) {
		this.thirdCorner = thirdCorner;
	}
	//========================================

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
		
		double area = 0.5 * Math.abs(firstCorner.getxAxis() * (secondCorner.getyAxis() - thirdCorner.getyAxis()) + 
				secondCorner.getxAxis() * (thirdCorner.getyAxis() - firstCorner.getyAxis()) + 
				thirdCorner.getxAxis() * (firstCorner.getyAxis() - secondCorner.getyAxis()));
		
		return area;
	}

	@Override
	public double getPerimeter() {
		double des1 = Math.sqrt(Math.pow(secondCorner.getxAxis() - firstCorner.getxAxis(), 2) + 
				Math.pow(secondCorner.getyAxis() - firstCorner.getyAxis(), 2));
		
		double des2 = Math.sqrt(Math.pow(secondCorner.getxAxis() - thirdCorner.getxAxis(), 2) + 
				Math.pow(secondCorner.getyAxis() - thirdCorner.getyAxis(), 2));
		
		double des3 = Math.sqrt(Math.pow(thirdCorner.getxAxis() - firstCorner.getxAxis(), 2) + 
				Math.pow(thirdCorner.getyAxis() - firstCorner.getyAxis(), 2));
		
		return des1+des2+des3;
	}

	@Override
	public String toString() {
		return "Triangle [firstCorner=" + firstCorner + ", secondCorner=" + secondCorner + ", thirdCorner="
				+ thirdCorner + "]";
	}
}
