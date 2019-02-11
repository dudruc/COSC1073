package topic5;

public class TestStudent 
{

	public static void main(String[] args) 
	{
		Student student1 = new Student ("S3637675", "Zitao Zheng");
		student1.addMark(85, "C123");
		student1.addMark(75, "C234");
		student1.addMark(80, "cosc1236");
		student1.addMark(10, "cosc1237");
		student1.addMark(20, "cosc1238");
		student1.addMark(30, "cosc1239");
		student1.removeMark("cosc1236");
		student1.removeMark("cosc1235");
		student1.printStudent();

	}

}
