package school;

import java.util.ArrayList;

public class Student {
	private int studentId;
	private String studentName;
	private Subject majorSubject;
	private ArrayList<Subject> studentSubject;
	private ArrayList<Score> scoreList;

	public Student(int studentId, String studentName, Subject majorSubject) {

		this.studentId = studentId;
		this.studentName = studentName;
		this.majorSubject = majorSubject;
		scoreList = new ArrayList<Score>();

	}

	public void addStudentScore(Score score) {
		scoreList.add(score);
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Subject getMajorSubject() {
		return majorSubject;
	}

	public void setMajorSubject(Subject majorSubject) {
		this.majorSubject = majorSubject;
	}

	public ArrayList<Subject> getStudentSubject() {
		return studentSubject;
	}

	public void setStudentSubject(ArrayList<Subject> studentSubject) {
		this.studentSubject = studentSubject;
	}

	public ArrayList<Score> getScoreList() {
		return scoreList;
	}

	public void setScoreList(ArrayList<Score> scoreList) {
		this.scoreList = scoreList;
	}
}
