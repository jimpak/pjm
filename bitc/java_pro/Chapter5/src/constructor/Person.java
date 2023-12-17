package constructor;

public class Person {
	String name;
	float height;
	float weight;
	
	// 생성자 오버로드 : 매개변수를 다르게 하여 여러가지 생성자를 선언하는 방법
	// 오버로드는 매개변수의 개수, 매개변수의 자료형에 따라 구성
	//디폴트 생성자
	public Person() {} // 자바 컴파일러가 자동으로 제공하는 디폴트 생성자
	
	public Person(String pname) {
		name = pname;
	} // 사람이름을 파라미터로 받아서 Person클래스를 생성하는 생성자
	
	public Person(float pheight) {
		height = pheight;
	}
	
//	public Person(float pweight) {
//		weight = pweight;
//	}
	
	public Person(String pname, float pheight) {
		name = pname;
		height = pheight;
	}
	
	public Person(float pheight, String pname) {
		height = pheight;
		name = pname;
	}
	
	public Person(String pname, float pheight, float pweight) {
		name = pname;
		height = pheight;
		weight = pweight;
	}
}
