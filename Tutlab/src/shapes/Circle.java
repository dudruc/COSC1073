package shapes;

import java.awt.Color;

public class Circle extends AbstractShape 
{
	
	private double radius;
	public Circle (Color color, double radius)
	{
		super(color);
		this.radius =radius;
	}
	
	@Override
	public double area() 
	{
		return Math.PI * radius * radius;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s area = %.2f", super.toString(), area());
	}
	
}
