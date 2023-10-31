package chapter2;

public class Variable1 {

	public static void main(String[] args) {

		int level; // 변수의 선언
		level = 10; // 변수에 값 대입, 초기화
		System.out.println(level); // 변수의 이름으로 값을 사용
		
		int level2 = -2147483648; // -2147483648 ~ 2147483647
		System.out.println(level2);
		
		byte b1 = -128; // -128~127
		short s1 = -32768; // -32768~32767
		long l1 = 9223372036854775807l; // -9223372036854775808 ~ 9223372036854775807
		System.out.println(b1);
		System.out.println(s1);
		System.out.println(l1);
		
		long i1 = 1000000000;
		long i2 = 1200000000;
		long sum = i1 + i2;
		System.out.println(sum);
		
		short sVal = 10;
		byte bVal = 20;
		System.out.println(sVal + bVal);
	}
}
