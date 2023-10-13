package staticex;

public class Student {
	// static : 정적 변수
	public static int serialNum = 1000;
	public int studentID;
	public String studentName;
	public int grade;
	public int address;
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
}
