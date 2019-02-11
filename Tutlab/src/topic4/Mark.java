package topic4;

public class Mark 
{
	private int mark;
	private String courseID;
	private String grade;
	
	public Mark(int mark, String courseID)
	{
		this.mark = mark;
		this.courseID = courseID;
		setGrade(mark);
	}

	public void setGrade(int mark)
	{
		if (mark >= 80)
			grade = "HD";
		else if (mark >= 70)
			grade = "DI";
		else if (mark >= 60)
			grade = "CR";
		else if (mark >= 50)
			grade = "PA";
		else grade = "NN";
	}
	
	public int getMark()
	{
		return mark;
	}
	
	public String getGrade()
	{
		return grade;
	}
	
	public String getCourseID() 
	{
		return courseID;
	}

	@Override
	public String toString()
	{
		return String.format("course ID = %s, Mark = %d, Grade = %s",courseID, mark, grade);
	}
}
