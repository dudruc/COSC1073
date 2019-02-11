package topic4;

public class TestMark 
{
	public static void main (String[] args)
	{
		Mark[] marks = 
				new Mark[]{new Mark(55, "s123"), new Mark(85, "s456"), new Mark(75,"s789"), new Mark(65, "s234"), new Mark(30, "s345")};
	
		for(Mark mark : marks)
			System.out.println(mark);
	}
	

}
