package classex;

class MyDog {
	String name;
	String type;
	
	public MyDog() {}
	
	public MyDog(String name, String type) {
		this.name = name;
		this.type = type;
	}

	@Override
	public String toString() {
		return name + ", " + type;
	}
	
}

public class practice {
	public static void main(String[] args) {
		MyDog dog = new MyDog("멍멍이", "진돗개");
		Object dog2 = new MyDog("a", "b");
		System.out.println(dog);
	}
}
