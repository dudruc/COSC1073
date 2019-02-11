package topic5;

import topic4.Mark;

public class Student 
{
	private String ID;
	private String name;
	private int numMarks;
	
	private final int MAX_MARKS = 5;
	
	private Mark[] marks = new Mark[MAX_MARKS];
	
	public Student (String ID, String name)
	{
		this.ID = ID;
		this.name = name;
	}
	
	public void addMark(int mark, String courseID)
	{
		if(numMarks < MAX_MARKS)
		{
			marks[numMarks] = new Mark(mark, courseID);
			numMarks++;
		}
	}
	
	private int getMarkIndex(String courseID)
	{
		for (int i = 0; i < numMarks; i++)
		{
			if (marks[i].getCourseID().equals(courseID))
				return i;
		}
		return -1;
	}
	
	public Mark getMark(String courseID)
	{
		int i = getMarkIndex(courseID);
		return i < 0 ? null : marks[i];
	}
	
	public boolean removeMark(String courseID)
	{
		int i = getMarkIndex(courseID);
		if (i >= 0)
		{
			for (int j = i; j < marks.length - 1; j++)
				marks[j] = marks[j+1];
			numMarks--;
			return true;
		}
		return false;
	}
	
	public void printStudent()
	{
		System.out.println(this);
		for(int i = 0; i < numMarks; i++)
		{
			System.out.println(marks[i]);
		}
	}
	
	@Override
	public String toString()
	{
		return String.format("Student ID: %s, Name: %s", ID, name);
	}
	

}