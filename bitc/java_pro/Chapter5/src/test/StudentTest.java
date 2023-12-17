package test;

import classpart.Student;

public class StudentTest {

	public static void main(String[] args) {
		
		Student lee = new Student();
//		lee.studentName = "이상원";
		lee.setStudentName("이상원");
		System.out.println(lee.getStudentName());
		
	}

}
