package staticex;

public class StudentTest1 {

	public static void main(String[] args) {
		
		Student lee = new Student();
		lee.setStudentName("이지원");
		System.out.println(lee.serialNum); //1000
		System.out.println(Student.serialNum); //1000
		lee.serialNum++; //static 변수 값 증가
		
		Student son = new Student();
		son.setStudentName("손수경");
		System.out.println(son.serialNum); //1001
		System.out.println(lee.serialNum); //1001

	}

}
