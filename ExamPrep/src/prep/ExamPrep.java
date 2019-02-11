package prep;

import java.awt.Rectangle;
import java.util.Arrays;

public class ExamPrep
{
	public ExamPrep()
	{
		bool();
		ifs();
		rect();
		exep();
		stars();
		reverse();
	}

	private void bool()
	{
		System.out.printf("true && false=%b\n", true && false);
		System.out.printf("false || true=%b\n", false || true);
		System.out.printf("(false || true) && (false || true)=%b\n", (false || true) && (false || true));
		int x = 0, y = 1;
		x++;
		++x;
		System.out.printf("(y > x) && (y !=0)=%b\n", (y > ++x) && (y != 0));
		if (x + 1 > 0 && y + 2 * 1 < 6)
			;
	}

	public void ifs()
	{
		int x = 4;
		if (x > 0)
		{
			System.out.println("1a");
			System.out.println("1b");
		}
		if (x == 4)
			System.out.println("4");
		else
			System.out.println("not 4");
		if (x == 1)
			System.out.println("1");
		else if (x == 2)
		{
			System.out.println("2");
		}
		else
		{
			System.out.println("last else");
		}
	}

	private void rect()
	{
		Rectangle rect1 = new Rectangle(1, 2, 3, 4);
		Rectangle rect2 = rect1;
		rect1.setBounds(2, 3, 4, 5);
		rect2.setBounds(1, 2, 3, 4);
		System.out.printf("rect1: %s\n", rect1);
		System.out.printf("rect2: %s\n", rect2.toString());
	}

	class Exception1 extends Exception
	{
	}

	class Exception2 extends Exception1
	{
	}

	@SuppressWarnings("hiding")
	private void exep()
	{
		try
		{
			System.out.println("statement1");
			throw new Exception2();
			//System.out.println("statement2");
		}
		catch(Exception2 e2)
		{
			System.out.println("statement3");
		}
		catch(Exception1 e1)
		{
			System.out.println("statement4");
		}
		finally
		{
			System.out.println("statement5");
		}
	}

	private void stars()
	{
		for(int lines=1; lines <=5; lines++)
		{
			for(int stars=1 ; stars <=lines; stars++)
				System.out.print('*');
			System.out.println();
		}
	}
	
	private void reverse()
	{
		int ints[]=new int[]{1,2,3,4,5,6};
		
		for(int i=0; i < ints.length / 2; i++)
		{
			int temp=ints[i];
			ints[i]=ints[ints.length-i-1];
			ints[ints.length-i-1]=temp;
		}
		System.out.println(Arrays.toString(ints));
	}
	public static void main(String[] args)
	{
		new ExamPrep();
	}
}
