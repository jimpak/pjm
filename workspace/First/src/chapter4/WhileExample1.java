package chapter4;

public class WhileExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 0;
		int sum = 0;
		
		while(num <= 10) { // 조건식 : true, false 값이 들어가야함
			sum += num; // 실행문
			System.out.println("num : " + num + ", sum : " + sum);
			num++; // 증가감
		}
		System.out.println("1부터 10까지의 합은 " + sum + "입니다.");
	}

}
