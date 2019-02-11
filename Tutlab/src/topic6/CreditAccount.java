package topic6;

public class CreditAccount extends BankAccount 
{
	
	private double creditLimit = 10000.0;

	public CreditAccount(String ID, double balance) 
	{
		super(ID, balance);
	}

	@Override
	public boolean withdraw(double amount) 
	{
		if(amount <= balance+creditLimit)
		{
			balance-=amount;
			return true;
		}
		return false;
	}
	
	@Override
	public String toString()
	{
		return String.format("Credit Account: %s Credit Limit: %.2f", super.toString(), creditLimit);
	}

}
