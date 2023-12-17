package interfaceex;

public interface Calc {
	double PI = 3.14;
	int ERROR = -999999999;
	
	int add(int num1, int num2);
	int substract(int num1, int num2);
	int times(int num1, int num2);
	int divide(int num1, int num2);
	int square(int num);
	
	// Calc 인터페이스에 디폴트 메서드 구현하기
	default void description() {
		System.out.println("정수 계산기를 구현합니다.");
		myMethod(); // 디폴트 메서드에서 private 메서드 호출
	}
	
	// 정적 메서드
	static int total(int[] arr) {
		int total = 0;
		
		for(int i : arr) {
			total += i;
		}
		myStaticMethod(); // 정적 메서드에서 private static 메서드 호출
		return total;
	}
	
	
	// private는 외부에서 사용할 수 없다.
	// private 메서드
	private void myMethod() {
		System.out.println("private 메서드입니다.");
	}

	// static 메서드에서만 사용할 수 있다.
	// private static 메서드	
	private static void myStaticMethod() {
		System.out.println("private static 메서드입니다.");
	}
	
}
