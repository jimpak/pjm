package chapter4;

public class IfExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int age = 8;
		if(age >= 8 ) {
			System.out.println("학교에 다닙니다.");
		} else {
			System.out.println("학교에 다니지 않습니다.");
		}
		
		
		int score;
		char grade;
		
		score = 60;
		
		if(score <= 100 && score >= 90) {
			grade = 'A';
		} else if(score <= 89 && score >= 80) {
			grade = 'B';
		} else if(score <= 79 && score >= 70) {
			grade = 'C';
		} else if(score <= 69 && score >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}
		
		System.out.println("당신의 성적은 " + grade + "입니다!!");
		
		char grade2 = 
				(score >= 90) ? 'A' : 
				(score >= 80) ? 'B' :
				(score >= 70) ? 'C' :
				(score >= 60) ? 'D' : 'F';
		
		System.out.println("당신의 성적은 " + grade2 + "입니다!!");
	}

}
