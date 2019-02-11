package examprep;

public class Demo 
{

	public static void main(String[] args) 
	{
		int value1 = 1;
        int value2 = 2;
        if((value1 == 1) && (value2 == 2))
            System.out.println("value1 is 1 AND value2 is 2");
        if((value1 == 1) || (value2 == 1))
            System.out.println("value1 is 1 OR value2 is 1");
        
        int result = 3;
        result = result % 7;
        // result is now 3
        System.out.println( "3 % 7 = " + result);
        


	}

}
