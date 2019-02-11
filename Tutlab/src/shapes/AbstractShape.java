package shapes;

import java.awt.Color;

public abstract class AbstractShape implements Shape 
{
	private Color color;
	
	public AbstractShape(Color color)
	{
		this.color = color;
	}

	@Override
	public Color getColor() 
	{
		return color;
	}

	@Override
	public abstract double area();
	
	@Override
	public String toString()
	{
		return String.format("Color = %s", color.toString());
	}

}
