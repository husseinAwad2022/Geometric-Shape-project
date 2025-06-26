package project_java;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Driver {
	
	static ArrayList<GeometricShape> GeometricShapeList = new ArrayList<GeometricShape>();
	public static void main(String[] args)throws FileNotFoundException, CloneNotSupportedException  {
		
		Scanner input = new Scanner(System.in);
		Scanner file = null;
		boolean loop = true;
		int option;
		
	   	try{
		      Read_File(file);
		      System.out.println("The file was read correctly.");
	   }catch (FileNotFoundException FOUND){
			 System.out.println("Enter the correct location of the file");
			 }
	   	
	   	//**********************************************************************
        System.out.println("************* ALL GeometricShape ****************************");
        for (GeometricShape Shape : GeometricShapeList) 
        {
                System.out.println(Shape.toString());
        }
	   	//**********************************************************************
	   	
		while(loop) {
			List();
			input = new Scanner(System.in);
			option = input.nextInt();
			input.nextLine();
			switch (option) 
			{
         case 1:      
        	 	addCircle(GeometricShapeList);   
                 break;
/////////////////////////////////////////////////////////////////////////////////  
         case 2:                         
        	 	addTriangle(GeometricShapeList);
                 break;
/////////////////////////////////////////////////////////////////////////////////  
         case 3:                        
        	 	addRectangle(GeometricShapeList);
                 break;
/////////////////////////////////////////////////////////////////////////////////  
         case 4:
        	 	cloneShape(GeometricShapeList);
                 break;
/////////////////////////////////////////////////////////////////////////////////  
         case 5:         
             Collections.sort(GeometricShapeList);
             System.out.println("Shapes sorted by size");
                 break;
/////////////////////////////////////////////////////////////////////////////////  
         case 6:
        	 	 Write_File();
        	 	 loop = false;
                 break;
/////////////////////////////////////////////////////////////////////////////////                 
         default:
             	 System.out.println("Invalid choice. Please try again.");               
/////////////////////////////////////////////////////////////////////////////////                     
         }
		}
		input.close();
}

	//------------------------------------------------------------------------------------
    public static void List() {
        System.out.println("\n*****************Welcome to the GeometricShape program****************************************\n");
        System.out.println("In front of you the menu to choose, press the option number ($_$)\n ");
        System.out.println("/////////***************//////////////////***********//////////////**************///////");
        System.out.println("1. Add a Circle");
        System.out.println("2. Add a Triangle");
        System.out.println("3. Add a Rectangle");
        System.out.println("4. Clone a Shape");
        System.out.println("5. Sort all Shapes");
        System.out.println("6. Exit");
        System.out.println("Enter your choice: ");
        System.out.println("/////////***************//////////////////***********//////////////**************///////");
    }
	//------------------------------------------------------------------------------------
    public static void Read_File(Scanner Read)  throws FileNotFoundException
    {
    	File file = new File("GeometricShape.txt");
		Read = new Scanner(file);
		int red,green,blue,x_Axis,y_Axis,x_Corner1,
		y_Corner1,x_Corner2,y_Corner2,x_Corner3,y_Corner3;
		double radius,height,width;
		boolean filled;
		
            while (Read.hasNext()) 
            {
            	
                    String Straight_Line = Read.nextLine();
                    String[] Storage_Place = Straight_Line.toString().split(" ");

                    if (Storage_Place[0].equalsIgnoreCase("Circle")) 
                    {
                    	radius = Double.parseDouble(Storage_Place[1]);
                    	red = Integer.parseInt(Storage_Place[2]);
                    	green = Integer.parseInt(Storage_Place[3]);
                    	blue = Integer.parseInt(Storage_Place[4]);
                    	filled = Boolean.parseBoolean(Storage_Place[5]);
                    	x_Axis = Integer.parseInt(Storage_Place[6]);
                    	y_Axis = Integer.parseInt(Storage_Place[7]);
                    	Color color = new Color(red,green,blue);
                    	Coordinates location = new Coordinates(x_Axis,y_Axis);
                    	
                    	Circle circle = new Circle(radius,color,filled,location);
                        GeometricShapeList.add(circle);
                    } 
                    else if (Storage_Place[0].equalsIgnoreCase("Triangle")) 
                    {
                    		x_Corner1 = Integer.parseInt(Storage_Place[1]);
                    		y_Corner1 = Integer.parseInt(Storage_Place[2]);
                    		x_Corner2 = Integer.parseInt(Storage_Place[3]);
                    		y_Corner2 = Integer.parseInt(Storage_Place[4]);
                    		x_Corner3 = Integer.parseInt(Storage_Place[5]);
                    		y_Corner3 = Integer.parseInt(Storage_Place[6]);
	                    	
	                    	red = Integer.parseInt(Storage_Place[7]);
	                    	green = Integer.parseInt(Storage_Place[8]);
	                    	blue = Integer.parseInt(Storage_Place[9]);
	                    	filled = Boolean.parseBoolean(Storage_Place[10]);
	                    	x_Axis = Integer.parseInt(Storage_Place[11]);
	                    	y_Axis = Integer.parseInt(Storage_Place[12]);
	                    	
	                    	Color color = new Color(red,green,blue);
	                    	Coordinates location = new Coordinates(x_Axis,y_Axis);
	                    	Coordinates firstCorner = new Coordinates(x_Corner1,y_Corner1);
	                    	Coordinates secondCorner = new Coordinates(x_Corner2,y_Corner2);
	                    	Coordinates thirdCorner = new Coordinates(x_Corner3,y_Corner3);
                    		Triangle triangle = new Triangle(firstCorner,secondCorner,thirdCorner,color,filled,location);
                            GeometricShapeList.add(triangle);
                    } 
                    else if (Storage_Place[0].equalsIgnoreCase("Rectangle")) 
                    {
                    		height = Double.parseDouble(Storage_Place[1]);
                    		width = Double.parseDouble(Storage_Place[2]);
                    		
	                    	red = Integer.parseInt(Storage_Place[3]);
	                    	green = Integer.parseInt(Storage_Place[4]);
	                    	blue = Integer.parseInt(Storage_Place[5]);
	                    	
	                    	filled = Boolean.parseBoolean(Storage_Place[6]);
	                    	x_Axis = Integer.parseInt(Storage_Place[7]);
	                    	y_Axis = Integer.parseInt(Storage_Place[8]);
	                    	
	                    	Color color = new Color(red,green,blue);
	                    	Coordinates location = new Coordinates(x_Axis,y_Axis);
                    		
                    		Rectangle rectangle = new Rectangle(height,width,color,filled,location);
                            GeometricShapeList.add(rectangle);
                    }
            }
            Read.close();
    }
	//------------------------------------------------------------------------------------
    public static void Write_File() 
    {
            File GeometricShape_Information = new File("GeometricShape.txt");
            try 
            {
                    FileWriter Write;
                    Write = new FileWriter(GeometricShape_Information);

                    for (GeometricShape geometric_shape :GeometricShapeList) 
                    {
                            if (geometric_shape instanceof Circle) 
                            {
                            	Circle circle = (Circle) geometric_shape;
                                Write.write("Circle " +circle.getRadius() +" "+ circle.getColor().getRed()
                                		    +" "+ circle.getColor().getGreen()+" "+circle.getColor().getBlue()
                                		    +" "+circle.isFilled()+" "+circle.getLocation().getxAxis()
                                		    +" "+circle.getLocation().getyAxis());
                            } 
                            else if (geometric_shape instanceof Triangle)
                            {
                            	Triangle triangle = (Triangle) geometric_shape;

                                    Write.write("Triangle "+" "+triangle.getFirstCorner().getxAxis()+" "+
                                    		triangle.getFirstCorner().getyAxis()+" "+triangle.getSecondCorner().getxAxis()
                                    		+" "+triangle.getSecondCorner().getyAxis()+" "+triangle.getSecondCorner().getyAxis()
                                    		+" "+triangle.getThirdCorner().getxAxis()+" "+triangle.getThirdCorner().getyAxis()
                                    		+triangle.getColor().getRed()+" "+triangle.getColor().getGreen()+" "+
                                    		triangle.getColor().getBlue()+" "+triangle.isFilled()+" "+triangle.getLocation().getxAxis()
                                    		+triangle.getLocation().getyAxis());
                            } 
                            else if (geometric_shape instanceof Rectangle) 
                            {
                            	Rectangle rectangle = (Rectangle) geometric_shape;

                                    Write.write("Rectangle "+rectangle.getHeight()+" "+rectangle.getWidth()+" "+rectangle.getColor().getRed()
                                    		+" "+rectangle.getColor().getGreen()+" "+rectangle.getColor().getBlue()+" "+
                                    		rectangle.isFilled()+" "+rectangle.getLocation().getxAxis()+" "+rectangle.getLocation().getyAxis());
                            }
                    }
                    Write.close();
            } 
            catch (IOException Afatal_Mistake)
            {                	
            	Afatal_Mistake.printStackTrace();
            }
    }
  //------------------------------------------------------------------------------------
    public static void addCircle(ArrayList<GeometricShape> GeometricShapeList) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the radius: ");
        double radius = input.nextDouble();
        System.out.println("Enter the red, green, and blue values for color (e.g., 255 0 0): ");
        int red = input.nextInt();
        int green = input.nextInt();
        int blue = input.nextInt();
        System.out.println("Is the circle filled? (true/false): ");
        boolean filled = input.nextBoolean();
        System.out.println("Enter the x and y coordinates for the center (e.g., 0 0): ");
        int x_Axis = input.nextInt();
        int y_Axis = input.nextInt();
        Color color = new Color(red, green, blue);
        Coordinates location = new Coordinates(x_Axis, y_Axis);
        Circle circle = new Circle(radius,color,filled,location);
        GeometricShapeList.add(circle);
        System.out.println("Circle added successfully.");
    }
    //-------------------------------------------------------------------------------------------
    public static void addTriangle(ArrayList<GeometricShape> GeometricShapeList) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the x and y coordinates for the first corner (e.g., 0 0): ");
        int x_Corner1 = input.nextInt();
        int y_Corner1 = input.nextInt();
        System.out.println("Enter the x and y coordinates for the second corner (e.g., 2 0): ");
        int x_Corner2 = input.nextInt();
        int y_Corner2 = input.nextInt();
        System.out.println("Enter the x and y coordinates for the third corner (e.g., 1 2): ");
        int x_Corner3 = input.nextInt();
        int y_Corner3 = input.nextInt();
        System.out.println("Enter the red, green, and blue values for color (e.g., 255 0 0): ");
        int red = input.nextInt();
        int green = input.nextInt();
        int blue = input.nextInt();
        System.out.println("Is the triangle filled? (true/false): ");
        boolean filled = input.nextBoolean();
        System.out.println("Enter the x and y coordinates for the location (e.g., 0 0): ");
        int x_Axis = input.nextInt();
        int y_Axis = input.nextInt();
        
        Coordinates firstCorner = new Coordinates(x_Corner1, y_Corner1);
        Coordinates secondCorner = new Coordinates(x_Corner2, y_Corner2);
        Coordinates thirdCorner = new Coordinates(x_Corner3, y_Corner3);
        Color color = new Color(red, green, blue);
        Coordinates location = new Coordinates(x_Axis, y_Axis);
        Triangle triangle = new Triangle(firstCorner,secondCorner,thirdCorner,color, filled,location);
        GeometricShapeList.add(triangle);
        System.out.println("Triangle added successfully.");
    }
    //-------------------------------------------------------------------------------------------
        public static void addRectangle(ArrayList<GeometricShape> GeometricShapeList) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the height of the rectangle: ");
            double height = input.nextDouble();
            System.out.println("Enter the width of the rectangle: ");
            double width = input.nextDouble();
            System.out.println("Enter the red, green, and blue values for color (e.g., 255 0 0): ");
            int red = input.nextInt();
            int green = input.nextInt();
            int blue = input.nextInt();
            System.out.println("Is the rectangle filled? (true/false): ");
            boolean filled = input.nextBoolean();
            System.out.println("Enter the x and y coordinates for the location (e.g., 0 0): ");
            int x_Axis = input.nextInt();
            int y_Axis = input.nextInt();
            
            Color color = new Color(red, green, blue);
            Coordinates location = new Coordinates(x_Axis, y_Axis);
            Rectangle rectangle = new Rectangle(height, width,color, filled,location);
            GeometricShapeList.add(rectangle);
            System.out.println("Rectangle added successfully.");
        }
     //----------------------------------------------------------------------------------------------------
        public static void cloneShape(ArrayList<GeometricShape> GeometricShapeList) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the ID of the shape to be cloned: ");
            int userID = input.nextInt();
            
            for (GeometricShape shape : GeometricShapeList) {
                if (shape.getShapeID() == userID) {
                	GeometricShapeList.add(shape);
                	System.out.println("Shape cloned and saved successfully.");
                }
                else {
                	System.out.println("Shape with the specified ID not found.");
                }
            }
        }
     //---------------------------------------------------------------------------------------------------- 
}