package shapes;

public interface Shape
{
	public abstract double area();
	public abstract int getColor();
	public abstract void setColor(int color);
}

abstract class AbstractShape implements Shape
{
	private int color;
	
	public AbstractShape(int color)
	{
		setColor(color);
	}
	
	@Override
	public abstract double area();
	
	@Override
	public int getColor()
	{
		return color;
	}
	@Override
	public void setColor(int color)
	{
		this.color=color;
	}
}

class Circle extends AbstractShape
{
	private double radius;
	
	public Circle(int color, double radius)
	{
		super(color);
		this.radius=radius;
	}
	
	@Override
	public double area()
	{
		return radius * radius * Math.PI;
	}
}