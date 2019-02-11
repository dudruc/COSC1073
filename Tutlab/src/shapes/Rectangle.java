package shapes;

import java.awt.Color;

public class Rectangle extends AbstractShape
{
	
	private double width;
	private double height;
	
	public Rectangle (Color color, double width, double height)
	{
		super(color);
		this.width = width;
		this.height = height;
	}
	
	@Override
	public double area()
	{
		return width * height;
	}
	
}
