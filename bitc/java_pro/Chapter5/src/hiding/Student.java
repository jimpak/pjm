package hiding;

public class Student {
//	1. private : 같은 클래스 내부에서만 접근가능
//	2. protected : 같은 패키지 내부의 상속관계 클래스에서만 접근가능
//	3. public : 외부 클래스 어디에서든 접근 가능
	int studentID;
	//private : 외부 클래스에서 불러올 수 없다.
	private String studentName;
	int grade;
	String address;
	
	
	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		if(studentID > 99999) {
			this.studentID = studentID;
		}
		else {
			System.out.println("글자수를 6글자 이상으로 설정해주세요.");
		}
	}

	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
}
