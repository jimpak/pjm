package singleton;

// 싱글톤 패턴 : 인스턴스를 단 하나만 생성하는 디자인 패턴
// static을 응용하여 프로그램 전반에서 사용하는 인스턴스를 하나만 구현하는 방식
public class Company {
	// 2. 클래스 내부에 static으로 유일한 인스턴스 생성
	private static Company instance = new Company();; 
	// 1. 생성자를 private로 만들기
	private Company() {}
	
	// 3. 외부에서 참조할 수 있는 public 메서드 만들기
	public static Company getInstance() {
		if(instance == null) {
			instance = new Company();
		}
		return instance;
	}
}
