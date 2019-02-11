package topic6;

public class TestBank 
{

	public static void main(String[] args) 
	{
		BankAccount account1 = new SavingsAccount ("1", 1000.0);
		BankAccount account2 = new SavingsAccount ("2", 1000.0);
		BankAccount account3 = new CreditAccount ("3", 1000.0);
		BankAccount account4 = new CreditAccount ("4", 1000.0);
		account1.transfer(200.0, account3);
		account2.transfer(100.0, account1);
		System.out.println(account1);
		System.out.println(account2);
		System.out.println(account3);
		System.out.println(account4);
	}

}
