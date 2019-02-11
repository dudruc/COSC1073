package examprep;

import java.util.Arrays;

public class reverse 
{

	public static void main(String[] args) 
	{
		int[] arr1 = new int[]{1, 2, 3, 4, 5, 6}; 
		int temp;
		for (int i = 0; i < arr1.length/2; i++)
		{
			temp = arr1[i];
			arr1[i] = arr1[arr1.length - i - 1];
			arr1[arr1.length - i - 1] = temp;
		}
		System.out.println(Arrays.toString(arr1));
	}

}
