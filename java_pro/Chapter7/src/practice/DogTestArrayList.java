package practice;

import java.util.ArrayList;

public class DogTestArrayList {

	public static void main(String[] args) {

		ArrayList<Dog> dogList = new ArrayList<Dog>();
		
		for(int i = 0; i < 5; i++) {
			dogList.add(new Dog("이름" + i, "품종" + i));
		}
		
		// for문
		for(int i = 0; i < dogList.size(); i++) {
			Dog dog = dogList.get(i);
			System.out.println(dog.showDogInfo());
		}
		
		// 향상된 for문
		System.out.println("==== 향상된 for문 ====");
		for(Dog object : dogList) {
			System.out.println(object.showDogInfo());
		}
		
		
	}

}
