package chapter2;

public class TypeInference {

	public static void main(String[] args) {
		
		var i = 10;
		var j = 10.0;
		var str = "hello";
		var f = 3.14f;
		
		System.out.println(i);
		System.out.println(j);
		System.out.println(str);
		System.out.println(f);
		
		str = "test";
		// str = 3;
		// str은 앞에서 String으로 사용되었기 때문에 정수값 사용불가

	}

}

// F5 : 메서드의 경우 메서드 안으로, 변수 선언이라면 다음 줄로
// F6 : 다음 줄로 이동
// F7 : 중괄호를 기준으로 중괄호를 끝내는 단축키
// F8 : 다음 브레이크 포인트까지 이동, 브레이크 포인트가 없다면 프로그램이 끝날때까지 실행
