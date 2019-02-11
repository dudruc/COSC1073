package employees;

public abstract class Employee 
{
	private String name;
	private double salary;
	private Employee boss;
	
	public Employee(String name, double salary, Employee boss) 
	{
		super();
		this.name = name;
		this.salary = salary;
		this.boss = boss;
	}

	public String getName() 
	{
		return name;
	}

	public double getSalary() 
	{
		return salary;
	}

	public Employee getBoss() 
	{
		return boss;
	}

	public void raiseSalary(double amount) 
	{
		this.salary += amount;
	}

	public void setBoss(Employee theBoss) 
	{
		this.boss = theBoss;
	} 
	
	public abstract double computeBonus();

	public void print() 
	{
		System.out.printf("%s, %s, %.2f", getName(), (getBoss() == null ? "NO BOSS" : getBoss().getName()), getSalary());
	}
}
