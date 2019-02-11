package employees;

public class ManageEmployee 
{

	public static void main(String[] args) 
	{
		Employee [] emps = new Employee[200];
		int numEmps = 0;
		
		emps[0] = new AcademicEmployee("Bill Gates", 100000.00, null, 'E');
		numEmps++;
		emps[1] = new ProfessionalEmployee("Mel deBoss", 100000.00, emps[0], 8);
		numEmps++;
		emps[2] = new AcademicEmployee("Mike Mogan", 50000.00, emps[1], 'C');
		numEmps++;
		
		System.out.printf("%s\n", "List of emps BEFORE changes:"); 
		for(int i = 0; i < numEmps; i++)
		{
			emps[i].print();
			System.out.println();
		}
		
		emps[1].raiseSalary(20000);
		((ProfessionalEmployee) emps[1]).setLevel(9);
		
		emps[2].raiseSalary(20000);
		((AcademicEmployee) emps[2]).setLevel('D');
		
		emps[3] = new AcademicEmployee("Teresa deGoddess", 5000000.00, null, 'E');
		numEmps++;
		emps[4] = new ProfessionalEmployee("Poor Slave", 5000.00, emps[1], 1);
		numEmps++;
		
		emps[0].setBoss(emps[3]);
		
		System.out.println();
		System.out.printf("%s\n", "List of emps AFTER changes:"); 
		
		for(int i = 0; i < numEmps; i++)
		{
			emps[i].print();
			System.out.println();
		}
		
		System.out.println();
		AllBosses("Poor Slave", emps, numEmps);
	}
	
	public static int Search(String name, Employee [] emp, int n)
	{
		for (int i = 0; i < n; i++)
		{
			if (emp[i].getName() == name)
				return i;
		}
		return -999;
	}
	
	public static void AllBosses(String name, Employee [] emp, int n)
	{
		Employee temp = null;
		if (Search(name, emp, n) >= 0)
		{
			temp = emp[Search(name, emp, n)];
			System.out.print(temp.getName());
			while (temp.getBoss() != null)
			{
				temp = emp[Search(temp.getBoss().getName(), emp, n)];
				System.out.print("<<" + temp.getName());
			}
		}
		else
			System.out.println("no such employee");
	}

}
