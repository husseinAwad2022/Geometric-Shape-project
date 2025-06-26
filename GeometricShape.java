package project_java;
import java.util.ArrayList;
import java.util.Date;

abstract public class GeometricShape implements Comparable<GeometricShape>,Cloneable{
	
	private Color color;
	private boolean filled;
	private long shapeID;
	private java.util.Date timeCreated;
	@SuppressWarnings("unused")
	private int shapeCount;
	private ArrayList<Integer> idList = new ArrayList<Integer>();
	protected Coordinates location;
	//===========================================================================
	protected GeometricShape() {	
		this.shapeID = IdMaker.makeUniqueID(idList);
		this.timeCreated = new Date();
		shapeCount++;
	}
	//===========================================================================
	public GeometricShape(Color color, boolean filled, Coordinates location) {
		this.shapeID = IdMaker.makeUniqueID(idList);
		this.timeCreated = new Date();
		shapeCount++;
		this.color = color;
		this.filled = filled;
		this.location = location;
	}
	//===========================================================================
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public long getShapeID() {
		return shapeID;
	}
	
	public java.util.Date getTimeCreated() {
		
		return timeCreated;
	}
	
	@Override
	public int compareTo(GeometricShape o) {
		
		if(o instanceof GeometricShape) {
		return (int) (this.getArea() - o.getArea());
		}
		System.out.println("Error");
		return -1;
	}

	abstract public Coordinates getLocation();
	abstract public void setLocation(Coordinates location);
	abstract public double getArea();
	abstract public double getPerimeter();
	abstract public String toString();
}