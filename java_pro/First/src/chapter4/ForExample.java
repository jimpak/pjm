package chapter4;

public class ForExample {
	public static void main (String[] args) {
		int sum = 0;
		for(int i = 1; i <= 10; i++) {
			// 1.초기값; 2.조건식; 4.증가감식
			sum += i; // 3.실행문
		}
		System.out.println("1부터 10까지의 합은 " + sum + " 입니다.");
	}
}
