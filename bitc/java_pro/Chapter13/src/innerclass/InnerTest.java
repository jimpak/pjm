package innerclass;

class OutClass {
	private int num = 10;
	private static int sNum = 20;
	
	static class InStaticClass {
		int inNum = 100;
		static int sInNum = 200;
		
		void inTest() {
			System.out.println("InStaticClass inNum = " + inNum + "(내부 클래스의 인스턴스 변수 사용)");
			System.out.println("InStaticClass sInNum = " + sInNum + "(내부 클래스의 정적 변수 사용)");
			System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 정적 변수 사용)");
		}
		
		static void sTest() {
			System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 정적 변수 사용)");
			System.out.println("InStaticClass sInNum = " + sInNum + "(내부 클래스의 정적 변수 사용)");
		}
	}
	
	// 내부 클래스 자료형 변수를 먼저 선언
	private InClass inClass;
	
	// 외부 클래스 디폴트 생성자. 외부 클래스가 생성된 후에 내부 클래스 생성 가능.
	public OutClass() {
		inClass = new InClass();
	}
	
	class InClass {
		int inNum = 100;
		
		// 인스턴스 내부 클래스에 정적 변수 선언 불가능. 오류가 발생하므로 주석 처리.
//		static int sInNum = 200;
		
		void inTest() {
			System.out.println("OutClass num = " + num + "(외부 클래스의 인스턴스 변수)");
			System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 정적 변수)");
		}
		
		// 정적 메서드 역시 정의 불가능. 오류가 발생하므로 주석 처리
//		static void sTest() {}
		
	}
	
	public void usingClass() {
		inClass.inTest();
	}

}

public class InnerTest {

	public static void main(String[] args) {
		OutClass outClass = new OutClass();
		System.out.println("외부 클래스 이용하여 내부 클래스 기능 호출");	
		// 내부 클래스 기능 호출
		outClass.usingClass();
		
		System.out.println();
		
		OutClass.InStaticClass sInClass = new OutClass.InStaticClass();
		System.out.println("정적 내부 클래스 일반 메서드 호출");
		sInClass.inTest();
		
		System.out.println();
		System.out.println("정적 내부 클래스의 정적 메서드 호출");
		OutClass.InStaticClass.sTest();
	}

}