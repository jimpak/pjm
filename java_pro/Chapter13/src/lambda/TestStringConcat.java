package lambda;

public class TestStringConcat {
	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = "World";
		
		// 인스턴스를 생성하고 참조 변수 concat을 사용해서 makeString() 메서드를 호출.
		StringConCatImpl concat1 = new StringConCatImpl();
		concat1.makeString(s1, s2);
		
		// 람다식
		StringConcat concat2 = (s, v) -> System.out.println(s + ", " + v);
		concat2.makeString(s1, s2);
		
		// 익명 객체
		StringConcat concat3 = new StringConcat() {
			public void makeString(String s1, String s2) {
				System.out.println(s1 + ", " + s2);
			}
		};
		concat3.makeString(s1, s2);
	}
}
