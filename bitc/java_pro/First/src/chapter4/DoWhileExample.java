package chapter4;

public class DoWhileExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 1;
		int sum = 0;
		
		do {
			sum += num;
			System.out.println(sum);
			num++;
		} while(num == 10);
		// do while문은 조건문에 해당하지 않아서 1번은 실행된다.
		
		System.out.println("1부터 10까지의 합은 " + sum + "입니다.");
	}

}
