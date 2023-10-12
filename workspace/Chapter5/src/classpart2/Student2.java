package classpart2;

import java.util.Scanner;

import classpart.Student;

public class Student2 {
	
	public static void main(String[] args) {
		
		Student studentPark = new Student();
		Scanner sc = new Scanner(System.in);
		studentPark.setStudentName(sc.next());

		System.out.println(studentPark.getStudentName());
	}
}
