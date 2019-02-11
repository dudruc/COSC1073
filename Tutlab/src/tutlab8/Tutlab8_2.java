package tutlab8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tutlab8_2 
{

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner (System.in);
		try
		{
			System.out.print("Please Enter A Double: ");
			scanner.close();
			double a = scanner.nextDouble();
		}
		catch (IllegalStateException e)
		{
			System.out.println("Scanner Closed");
				
		}
	}
}
