package chapter2;

public class Constant {

	public static void main(String[] args) {
		// 상수 선언
		final int MAX_NUM = 100;
		final int MIN_NUM;
		
		MIN_NUM = 0; // 사용하기 전에 초기화 하지 않으면 오류 발생.
		
		System.out.println(MAX_NUM);
		System.out.println(MIN_NUM);
		
//		MAX_NUM = 1000;
		// 상수 값은 변경할 수 없음.

	}

}
