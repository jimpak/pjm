package staticex;

public class Student2 {
	// static : 정적 변수
	private static int serialNum = 1000;
	public int studentID;
	public String studentName;
	public int grade;
	public int address;
	
	public Student2() {
		serialNum++;
		studentID = serialNum;
	}
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		setSerialNum(123);
		this.studentName = studentName;
	}
	
	public static int getSerialNum() {
		int i = 10;
//		studentName = "이지원"; //에러
		return serialNum;
	}
	
	public static void setSerialNum(int serialNum) {
		Student2.serialNum = serialNum;
	}
	
}
