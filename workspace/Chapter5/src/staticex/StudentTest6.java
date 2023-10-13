package staticex;

public class StudentTest6 {

	public static void main(String[] args) {
		
		Student3 lee = new Student3();
		lee.setStudentName("이지원");
		System.out.println(lee.studentName + " 학번 : " + lee.studentID +
				" 카드번호 : " + lee.cardNum);
		
		Student3 son = new Student3();
		son.setStudentName("손수경");
		System.out.println(son.studentName + " 학번 : " + son.studentID +
				" 카드번호 : " + son.cardNum);	
		
		for (int i = 0; i < 100; i++) {
			Student3 student = new Student3();
			student.setStudentName("이름없음" + i);
			System.out.println(student.studentName +" 학번 : " + student.studentID +
					" 카드번호 : " + student.cardNum);	
		}
		
		StudentTest6 test = new StudentTest6();
		int total = test.add(1, 2);
		System.out.println(total);
		if(total>60) {
			total = 0;
			int i = 0;
		}
//		System.out.println(i);
	}
	
	public int add(int num1, int num2) {
		int sum = num1 + num2;
		System.out.println(sum);
		return sum;
	}

}

