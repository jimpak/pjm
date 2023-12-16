package classpart;


public class Student {
	//멤버 변수
	int studentID; //학번
	String studentName; //학생이름
	int grade; //학년
	String address; //주소
	
	//파스칼 표기법 : 단어의 첫글자를 대문자로 작성, (프로젝트 이름, 클래스이름)
	//카멜 표기법 : 첫 단어의 첫글자를 소문자로 작성, 띄어쓰기 대신 이어지는 글자를 대문자로 작성(메서드, 변수에 주로 사용)
	//언더스코어 표기법 : 단어의 사이에 띄어쓰기 대신에 _(언더바)로 나누어 작성 (데이터베이스 칼럼명)
	
	//메서드
	public String showStrudentInfo() {
		//void를 제외한 자료형은 return값 필요
		System.out.println(studentName + ", " + address);
		String str = studentName + ", " + address;
		return str;
	}
	
	public void nextGrade() {
		grade = grade + 1;
	}
	
	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String name) {
		studentName = name;
	}

}
