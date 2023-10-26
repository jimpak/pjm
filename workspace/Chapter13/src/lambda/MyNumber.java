package lambda;

@FunctionalInterface
public interface MyNumber {
	int getMax(int num1, int num2);
	
	// 람다식은 이름이 없는 익명 함수로 구현하기 때문에 인터페이스에 여러 개 있다면 오류 발생
	// 따라서 람다식은 오직 하나의 메서드만 선언.
//	int add(int num1, int num2);
}
