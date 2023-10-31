package school;

import java.util.ArrayList;

public class School {
	public static School instance = new School();

	private static String SCHOOL_NAME = "Good School";
	
	private ArrayList<Student> studentList = new ArrayList<Student>();
	private ArrayList<Subject> subjectList = new ArrayList<Subject>();

	private School() {}
	
	public static School getInstance() {
		if(instance == null)
			instance = new School();
		return instance;
	}

	public void addStudent(Student student) {

		studentList.add(student);
	}

	public void addSubject(Subject subject) {

		subjectList.add(subject);
	}


	public static void setInstance(School instance) {
		School.instance = instance;
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}

	public ArrayList<Subject> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(ArrayList<Subject> subjectList) {
		this.subjectList = subjectList;
	}


}

