package constructor;

import java.util.Scanner;

public class PersonTest {
	public static void main(String[] args) {
		Person personAhn = new Person();
		personAhn.name = "Ahn";
		personAhn.height = 177.7f;
		personAhn.weight = 81.7f;
		
		Person personLee = new Person("Lee");
		Person person1 = new Person(177.7f, "Park");
		Person person2 = new Person(79, "Kim");
		Person person3 = new Person("Jeong", 64.5f);
		Person person4 = new Person("No", 153, 47.3f);
		Person person5 = new Person("Ha", 176, 53);
		
		Integer i = new Integer(0);
		Scanner sc = new Scanner(System.in);
	}
}
