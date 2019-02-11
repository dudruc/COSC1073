package topic6;

public class SavingsAccount extends BankAccount 
{

	public SavingsAccount(String ID, double balance) 
	{
		super(ID, balance);
	}

	@Override
	public boolean withdraw(double amount) 
	{
		if (balance >= amount)
		{
			balance -= amount;
			return true;
		}
		return false;
	}

	@Override
	public String toString() 
	{
		return String.format("Savings Account: %s", super.toString());
	}

}
