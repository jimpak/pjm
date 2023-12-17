package classpart;

public class FunctionTest {

	public static void main(String[] args) {

		operationPrint(10, 20);
		
		//스택 : 처음 저장되었던 내용이 마지막에 삭제된다.
	}
	
	
	
	public static int add(int n1, int n2) {
		int result = n1 + n2;
		return result;
	}
	
	public static int subtract(int n1, int n2) {
		int result = n1 - n2;
		return result;
	}
	
	public static int multiply(int n1, int n2) {
		int result = n1 * n2;
		return result;
	}
	
	public static int divide(int n1, int n2) {
		int result = n1 / n2;
		return result;
	}

	public static void operationPrint(int num1, int num2) {
		int sum = add(num1, num2);
		int sub = subtract(num1, num2);
		int mul = multiply(num1, num2);
		int div = divide(num1, num2);
		System.out.println(num1 + " + " + num2 + " = " + sum + " 입니다.");
		System.out.println(num1 + " - " + num2 + " = " + sub + " 입니다.");
		System.out.println(num1 + " x " + num2 + " = " + mul + " 입니다.");
		System.out.println(num1 + " / " + num2 + " = " + div + " 입니다.");
	}
	
}
