package project_java;

public class Coordinates {
	
	private int xAxis;
	private int yAxis;
	//========================================
	public Coordinates() {
		
	}
	
	public Coordinates(int xAxis, int yAxis) {
		this.xAxis = xAxis;
		this.yAxis = yAxis;
	}
	//========================================

	public int getxAxis() {
		return xAxis;
	}

	public void setxAxis(int xAxis) {
		this.xAxis = xAxis;
	}

	public int getyAxis() {
		return yAxis;
	}

	public void setyAxis(int yAxis) {
		this.yAxis = yAxis;
	}
}
