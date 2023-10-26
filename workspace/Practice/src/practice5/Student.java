package practice5;

import java.util.ArrayList;

//5. 클래스 실습문제2
public class Student {
	int sno;
	String name;
	String dept;
	int[] scores = new int[3];
	double avg;
	int rank;
	
	public Student() {}
	public Student(int sno, String name, String dept, int[] scores) {
		this.sno = sno;
		this.name = name;
		this.dept = dept;
		this.scores = scores;
	}
	
	
	public int getSno() {
		return sno;
	}

	public String getName() {
		return name;
	}

	public String getDept() {
		return dept;
	}

	public int[] getScores() {
		return scores;
	}

	public double getAvg() {
		return avg;
	}

	public int getRank() {
		return rank;
	}




	public int sum() {
		int sum = 0;
		for(int scoreNum : scores) {
			sum += scoreNum;
		}	
		return sum;
	}
	
	public double avg() {
		int sum = 0;
		avg = 0;
		
		for(int i = 0; i <= scores.length; i++) {
			sum += scores[i];
			if(i == scores.length)
				avg = sum/(i+1);
		}	
		return avg;
	}
	
	public int rank() {
		Student[] students = new Student[3];
		
		for(int i = 0; i < 3; i++) {
			rank = 1;
			for(int j = 0; j < 3; j++) {
				if(students[i].sum() < students[j].sum())
					rank++;
			}
			students[i].rank = rank;
		}
		
		return rank;
	}
	
	public void print() {
		Student[] students = new Student[3];
		
		System.out.println("학번 이름   학과  성적1  성적2  성적3  총점   평균   석차");
		for(Student stuArr : students) {
			System.out.println(stuArr.getSno() + 
					stuArr.getName() + "   " +
					stuArr.getDept() + "  " +
					stuArr.getScores()[0] + "    " +
					stuArr.getScores()[1] + "    " +
					stuArr.getScores()[2] + "   " +
					stuArr.sum() + "  " +
					stuArr.avg() + "  " +
					stuArr.rank()
					);
		}
	}
	
	
}
