package hiding;

public class StudentTest {

	public static void main(String[] args) {
		
		Student lee = new Student();
//		lee.studentName = "이상원";
		lee.setStudentName("이상원");
		
		System.out.println(lee.getStudentName());
		
		lee.setStudentID(156795);
		System.out.println(lee.getStudentID());
		
//		lee.setStudentID(55555);
//		System.out.println(lee.getStudentID());
	}

}
