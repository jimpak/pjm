package thisex;

class Person {
	String name;
	int age;

	
	// 생성자에서 다른 생성자를 호출
	Person() {
		this("이름 없음", 1);  // this를 사용해 Person(String, int) 생성자 호출
	}
	
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// 자신의 주소를 반환하는 this
	Person returnItSelf() {
		return this; // this로 반환
	}
}

public class CallAnotherConst {

	public static void main(String[] args) {
	
		Person noName = new Person();
		System.out.println(noName.name);
		System.out.println(noName.age);
		
		Person p = noName.returnItSelf(); // this 값을 클래스 변수에 대입
		p.name = "안연수";
		p.age = 20;
		
		System.out.println(p); // noName.returnItSelf()의 반환 값 출력
		System.out.println(noName); // 참조 변수 출력
		System.out.println(p.name);
		System.out.println(p.age);
		System.out.println(noName.name);
		System.out.println(noName.age);
		// 주소값이 같기 때문에 p를 변경하면 noName도 따라서 변경됨.
	}

}
