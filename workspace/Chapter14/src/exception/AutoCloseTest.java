package exception;

public class AutoCloseTest {

	public static void main(String[] args) {
		
		// 사용할 리소스 선언
		// 작성한 AutoCloseObj클래스를 실행.
		try(AutoCloseObj obj = new AutoCloseObj()) {
			throw new Exception(); // 강제 예외 발생
		}	catch(Exception e) {
			System.out.println("예외 부분입니다");
		}

		AutoCloseObj obj = new AutoCloseObj();
		// 다른 참조 변수로 다시 선언해야 함
		try(AutoCloseObj obj2 = obj) {
			throw new Exception(); // 강제 예외 발생
		}	catch(Exception e) {
			System.out.println("예외 부분입니다");
		}
		
		// 외부에서 선어한 변수를 그대로 쓸 수 있음.
		try(obj) {
			throw new Exception(); // 강제 예외 발생
		}	catch(Exception e) {
			System.out.println("예외 부분입니다");
		}
	}

}
