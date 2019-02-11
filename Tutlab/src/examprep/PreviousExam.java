package examprep;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class PreviousExam 
{

	public static void main(String[] args) 
	{
//		int[] myArray = new int[] {0, 2, 1, 3};
//		for (int i = 0; i < myArray.length; i++)
//		{
//			if(myArray[i] == i)
//				System.out.println(i);
//		}
		
//		int[] values = new int[] {1, 2, 3, 4, 5};
//		int temp = values[values.length - 1];
//		for (int i = values.length - 1; i > 0; i--)
//			values[i] = values[i-1];
//		values[0] = temp;
//		System.out.println(Arrays.toString(values));
		
//		int[] myArray = new int[10];
//		myArray[0] = 5;
//		myArray[1] = 8;
//		for (int i = 2; i < myArray.length; i++)
//			myArray[i] = myArray[i - 1] + myArray[i - 2];
//		System.out.println(Arrays.toString(myArray));
		
		String line;    
		String fileName;   
		int lc = 0, vc = 0; // line and volume counters 
	       
		System.out.println("Enter the file name: "); 
		Scanner console = new Scanner(System.in); 
		fileName = console.nextLine(); 
		console.nextLine();
		Scanner sc;
		try 
		{
			sc = new Scanner(new FileReader(fileName));
			sc.close();
			while(sc.hasNext())
				vc++;
			while(sc.hasNextLine())
				lc++;
			System.out.printf("Number of lines in data.txt is %d%n", lc);
			System.out.printf("The file volume of data.txt is %d%n", vc);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		
		  
	}

}
