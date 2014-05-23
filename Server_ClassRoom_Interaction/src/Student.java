import java.util.*;

public class Student
{
	// this class stores the student information
	//BufferedImage studentImage;
	String studentName,macAddress,pic,doubtSubject,textMessage="Text............................................";
	
	static LinkedList<Student> studentList=new LinkedList<Student>();
	
	Student(String studentName,String macAddress,String pic,String doubtSubject)
	{
		this.doubtSubject=doubtSubject;
		this.studentName=studentName;
		this.macAddress=macAddress;
		this.pic=pic;
		studentList.add(this);
	}
	
	public static LinkedList<Student> getStudentList()
	{
		return studentList;
	}
}