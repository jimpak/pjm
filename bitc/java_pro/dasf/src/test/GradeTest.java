package test;

import java.io.FileInputStream;
import java.io.IOException;

import school.School;
import school.Score;
import school.Student;
import school.Subject;
import school.report.GenerateGradeReport;
import utils.Define;

public class GradeTest {
	School goodSchool = School.getInstance();
	Subject korean;
	Subject math;
	Subject dance;
	Subject code;
	GenerateGradeReport gradeReport = new GenerateGradeReport();
	
	public static void main(String[] args) {
		GradeTest test = new GradeTest();
		
		String subjectFistSpell;
		String subjectName;
		int subjectId;
		
		test.createSubject();
		test.createSubject2();
		test.createStudent();
		
		String report = test.gradeReport.getReport();
		System.out.println(report);
	}
	
	public void createSubject() {
		korean = new Subject("국어", Define.KOREAN);
		math = new Subject("수학", Define.MATH);
		dance = new Subject("방송 댄스", Define.DANCE);
		code = new Subject("전공코드", Define.CODE);
		
		dance.setGradeType(Define.PF_TYPE);
		
		goodSchool.addSubject(korean);
		goodSchool.addSubject(math);
		goodSchool.addSubject(dance);
		goodSchool.addSubject(code);
	}
	
	public void createSubject2() {	
			try (FileInputStream fis = new FileInputStream("studentInfo.txt")) {
				byte[] bs = new byte[10];
				int i;
				
				while((i = fis.read(bs)) != -1) {
					for(byte b : bs) {
						System.out.print((char)b);
					}
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("end");
	}
	
	
	public void createStudent() {
		Student student = new Student(231030, "박정민", korean);

		goodSchool.addStudent(student);
		
		korean.register(student);
		
		math.register(student);
		
		dance.register(student);
		
		code.register(student);
		
		addScoreForStudent(student, korean, 100);
		addScoreForStudent(student, math, 100);
		addScoreForStudent(student, dance, 100);
		addScoreForStudent(student, code, 2001);
		
	}
	
	public void addScoreForStudent(Student student, Subject subject, int point) {
		Score score = new Score(student.getStudentId(), subject, point);
		student.addStudentScore(score);
	}
}
