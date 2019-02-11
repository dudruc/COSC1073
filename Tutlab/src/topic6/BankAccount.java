package topic6;

public class BankAccount 
{
	
	protected String ID;
	protected double balance;
	
	public BankAccount (String ID, double balance)
	{
		this.ID = ID;
		this.balance = balance;
	}
	
	public void deposit(double amount)
	{
		balance += amount;
	}
	
	public boolean withdraw(double amount)
	{
		return false;
	}
	
	public boolean transfer(double amount, BankAccount destAccount)
	{
		if(withdraw(amount))
		{
			destAccount.deposit(amount);
			return true;
		}
		else 
			return false;
	}
	
	@Override
	public String toString()
	{
		return String.format("ID: %s, balance: %.2f", ID, balance);
	}

}
