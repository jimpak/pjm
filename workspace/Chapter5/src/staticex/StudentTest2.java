package staticex;

public class StudentTest2 {

	public static void main(String[] args) {
		
		Student1 lee = new Student1();
		lee.setStudentName("이지원");
		System.out.println(lee.serialNum);
		System.out.println(lee.studentName + " 학번 : " + lee.studentID);
		
		Student1 son = new Student1();
		son.setStudentName("손수경");
		System.out.println(son.serialNum);
		System.out.println(son.studentName + " 학번 : " + son.studentID);
		
		for (int i = 0; i < 100; i++) {
			Student1 student = new Student1();
			System.out.println(student.studentID);
		}
	}

}
