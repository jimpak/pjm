package staticex;

public class StudentTest4 {

	public static void main(String[] args) {
		
		Student2 lee = new Student2();
		lee.setStudentName("이지원");
		System.out.println(Student2.getSerialNum());
		System.out.println(lee.studentName + " 학번 : " + lee.studentID);
		
		Student2 son = new Student2();
		son.setStudentName("손수경");
		System.out.println(Student2.getSerialNum());
		System.out.println(son.studentName + " 학번 : " + son.studentID);
	}

}

