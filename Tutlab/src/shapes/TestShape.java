package shapes;

import java.awt.Color;

public class TestShape 
{
	
	public static void main(String[] args)
	{
		Shape[] shapes = new Shape[]
				{new Circle(Color.YELLOW, 1.5), new Rectangle(Color.RED, 2, 3)};
		
		for (Shape shape : shapes)
		{
//			if(shape instanceof Circle)
//				((Circle) shape).setRadius(((Circle) shape).getRadius()*0.1);
			System.out.println(shape.toString());
		}
			
		
	}
}
