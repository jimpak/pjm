package staticex;

public class Student3 {
	// static : 정적 변수
	private static int serialNum = 1000;
	public int cardNum;
	public int studentID;
	public String studentName;
	public int grade;
	public int address;
	
	public Student3() {
		serialNum++;
		studentID = serialNum;
		cardNum = serialNum + 100;
	}
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
//		setSerialNum(123);
		this.studentName = studentName;
	}
	
	public static int getSerialNum() {
		int i = 10;
//		studentName = "이지원"; //에러
		return serialNum;
	}
	
	public static void setSerialNum(int serialNum) {
		Student3.serialNum = serialNum;
	}

	public int getCardNum() {
		return cardNum;
	}

	public void setCardNum(int cardNum) {
		this.cardNum = cardNum;
	}
	
	
}
