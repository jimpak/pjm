package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

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
		
		test.createSubject2();		
		test.createStudent2();
//		test.createResultInfo();

		String report = test.gradeReport.getReport();		
		System.out.println(report);
	}
	
	public void createSubject2() {
		
		FileInputStream fis = null;
		
		try {
			
			fis = new FileInputStream("subjectInfo.txt");
			Scanner scanner = new Scanner(fis);
			
			while(scanner.hasNextLine()) {
				String subjectFirstSpell = scanner.next();
				String subjectName = scanner.next();
				int subjectId = scanner.nextInt();
				Subject subject = new Subject(subjectName, subjectId);
				
				if(subjectFirstSpell.equals("K")) {
					korean = subject;
				}
				else if(subjectFirstSpell.equals("M")) {
					math = subject;
				}
				else if(subjectFirstSpell.equals("D")) {
					dance = subject;
				} 
				else if(subjectFirstSpell.equals("C")) {
					code = subject;
				} else {
					System.out.println("값이 존재하지 않습니다.");
				}

			}
			
			goodSchool.addSubject(korean);
			goodSchool.addSubject(math);
			goodSchool.addSubject(dance);
			goodSchool.addSubject(code);
			
			scanner.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@SuppressWarnings("resource")
	public void createStudent2() {
		
		FileInputStream fis = null;

		try {
			Student student = null;
			
			Scanner scanner = new Scanner(System.in);
			System.out.print("본인 이름 추가 : ");
			String name = scanner.next();
			System.out.print("학번 : ");
			int id = scanner.nextInt();
			System.out.print("국어 점수 : ");
			int koreanScore = scanner.nextInt();
			System.out.print("수학 점수 : ");
			int mathScore = scanner.nextInt();
			System.out.print("방송댄스 점수 : ");
			int danceScore = scanner.nextInt();
			System.out.print("전공코드 : ");
			int code = scanner.nextInt();
			
			if(dance.toString().length() == 4) {
				code = danceScore;
			} else {
				code = scanner.nextInt();
			}
			
			if(code == Define.KOREAN) {
				student = new Student(id, name, korean);
			} else if(code == Define.MATH) {
				student = new Student(id, name, math);
			} else if(code == Define.DANCE) {
				student = new Student(id, name, dance);
			}	
			goodSchool.addStudent(student);		
			korean.register(student);		
			math.register(student);		
			dance.register(student);		
			addScoreForStudent(student, korean, koreanScore);
			addScoreForStudent(student, math, mathScore);
			addScoreForStudent(student, dance, danceScore);
			
			fis = new FileInputStream("studentInfo.txt");
			scanner = new Scanner(fis);
			
			while(scanner.hasNextLine()) {
				name = scanner.next();
				id = scanner.nextInt();
				koreanScore = scanner.nextInt();
				mathScore = scanner.nextInt();
				danceScore = scanner.nextInt();
				code = scanner.nextInt();

				System.out.println(name);
				System.out.println(id);
				System.out.println(koreanScore);
				System.out.println(mathScore);
				System.out.println(danceScore);
				System.out.println(code);
				System.out.println();
				
				if(dance.toString().length() == 4) {
					code = danceScore;
				} else {
					code = scanner.nextInt();
				}
				
				if(code == Define.KOREAN) {
					student = new Student(id, name, korean);
				} else if(code == Define.MATH) {
					student = new Student(id, name, math);
				} else if(code == Define.DANCE) {
					student = new Student(id, name, dance);
				}
				
				student = new Student(id, name, korean);
				goodSchool.addStudent(student);				
				korean.register(student);				
				math.register(student);				
				dance.register(student);
				addScoreForStudent(student, korean, koreanScore);
				addScoreForStudent(student, math, mathScore);
				addScoreForStudent(student, dance, danceScore);

			}
			
			scanner.close();
			
		} catch (Exception e) {
		      System.out.println(e.getMessage());
		}
	}
	
	public void createResultInfo() {
		try(FileOutputStream fos = new FileOutputStream("resultInfo.txt");
				OutputStreamWriter osw = new OutputStreamWriter(System.out)){
			osw.write("지금까지자바정말재미있게공부했어요^^");
		} catch(IOException e) {
			System.out.println(e);
		}
		
		System.out.println("a.txt 파일을 열어보세요.");
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
	
	public void createStudent() {
		Student student1 = new Student(181213, "안성원", korean);
		Student student2 = new Student(181518, "오태훈", math);
		Student student3 = new Student(171230, "이동호", korean);
		Student student4 = new Student(171255, "조성욱", korean);
		Student student5 = new Student(171590, "최태평", math);
		
		goodSchool.addStudent(student1);
		goodSchool.addStudent(student2);
		goodSchool.addStudent(student3);
		goodSchool.addStudent(student4);
		goodSchool.addStudent(student5);
		
		korean.register(student1);
		korean.register(student2);
		korean.register(student3);
		korean.register(student4);
		korean.register(student5);
		
		math.register(student1);
		math.register(student2);
		math.register(student3);
		math.register(student4);
		math.register(student5);
		
		dance.register(student1);
		dance.register(student2);
		dance.register(student3);
		
		addScoreForStudent(student1, korean, 95);
		addScoreForStudent(student1, math, 56);
		addScoreForStudent(student1, dance, 95);
		
		addScoreForStudent(student2, korean, 95);
		addScoreForStudent(student2, math, 95);
		addScoreForStudent(student2, dance, 85);
		
		addScoreForStudent(student3, korean, 100);
		addScoreForStudent(student3, math, 88);
		addScoreForStudent(student3, dance, 55);
		
		addScoreForStudent(student4, korean, 89);
		addScoreForStudent(student4, math, 95);
		
		addScoreForStudent(student5, korean, 85);
		addScoreForStudent(student5, math, 56);
	}
	
	public void addScoreForStudent(Student student, Subject subject, int point) {
		Score score = new Score(student.getStudentId(), subject, point);
		student.addStudentScore(score);
	}
}
