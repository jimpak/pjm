package exception;

public class ArrayExceptionHandling {

	public static void main(String[] args) {
		
		int[] arr = new int[5];
		
		// 실행문
		try {
			for(int i = 0; i <= 5; i++) {
				arr[i] = i;
				System.out.println(arr[i]);
			}
		// 예외 처리
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
			System.out.println("예외 처리 부문");
		}
		System.out.println("프로그램 종료");

	}

}
