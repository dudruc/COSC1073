package employees;

public class ProfessionalEmployee extends Employee 
{
	int HEWlevel;

	public ProfessionalEmployee(String name, double salary, Employee boss, int HEWlevel) 
	{
		super(name, salary, boss);
		this.HEWlevel = HEWlevel;
	}

	public int getLevel() 
	{
		return HEWlevel;
	}

	public void setLevel(int HEWlevel) 
	{
		this.HEWlevel = HEWlevel;
	}

	@Override
	public double computeBonus() 
	{
		return super.getSalary() * HEWlevel / 100;
	}
	
	public void print()
	{
		super.print();
		System.out.print(", " +HEWlevel);
	}
}
