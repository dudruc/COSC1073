package tutlab8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tutlab8_1 
{

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner (System.in);
		boolean flag = false;
		while(!flag)
		{
			try
			{
				System.out.print("Please Enter an Integer: ");
				int a = scanner.nextInt();
				flag = true;
			}
			catch (InputMismatchException e)
			{
				scanner.nextLine();
				System.out.println("Not An Integer! Try Again!");
				
			}
		}
	}
}
