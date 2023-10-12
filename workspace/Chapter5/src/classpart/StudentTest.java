package classpart;

import java.util.Scanner;

public class StudentTest {
	
	public static void main(String[] args) {
		
		Student studentPark = new Student();
		Scanner sc = new Scanner(System.in);
		studentPark.studentName = sc.next();
		
		System.out.println(studentPark.studentName);
		System.out.println(studentPark.getStudentName());
		
		Student studentPark2 = new Student();
		studentPark2.studentName = "박정민";
		
		System.out.println(studentPark2.studentName);
		System.out.println(studentPark2.getStudentName());
		
		System.out.println(studentPark);
		System.out.println(studentPark2);
	}
}
