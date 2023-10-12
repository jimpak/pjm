package reference;

public class StudentTest {

	public static void main(String[] args) {
		
		Student3 ahn = new Student3();
		ahn.studentID = 123;
		ahn.studentName = "Ahn";
		ahn.korean.scorePoint = 80;
		ahn.korean.subjectName = "국어";
		ahn.math.scorePoint = 90;
		ahn.math.subjectName = "수학";
		
		System.out.println(ahn.studentID);
		System.out.println(ahn.studentName);
		System.out.println(ahn.korean.scorePoint);
		System.out.println(ahn.korean.subjectName);
		System.out.println(ahn.math.scorePoint);
		System.out.println(ahn.math.subjectName);
		

	}

}
