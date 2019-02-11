package employees;

public class AcademicEmployee extends Employee 
{
	private char academicLevel;

	public AcademicEmployee(String name, double salary, Employee boss, char academicLevel) 
	{
		super(name, salary, boss);
		this.academicLevel = academicLevel;
	}

	public char getLevel() 
	{
		return academicLevel;
	}

	public void setLevel(char academicLevel) 
	{
		this.academicLevel = academicLevel;
	}

	@Override
	public double computeBonus() 
	{
		if(getLevel() == 'A')
			return super.getSalary() * 0.08;
		else if(getLevel() == 'B')
			return super.getSalary() * 0.06;
		else if(getLevel() == 'C')
			return super.getSalary() * 0.04;
		else if(getLevel() == 'E')
			return super.getSalary() * 0.02;
		return 0;
	}
	
	public void print()
	{
		super.print();
		System.out.print(", " +academicLevel);
	}

}
