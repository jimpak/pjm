package practice;

public class DogTest {

	public static void main(String[] args) {
		
		Dog[] dogList = new Dog[5];
		
		for(int i = 0; i < dogList.length; i++) {
			dogList[i] = new Dog("이름" + i, "품종" + i);
		}
		
		// for문
		for(int i = 0; i < dogList.length; i++) {
			System.out.println(dogList[i].showDogInfo());
		}
		
		// 향상된 for문
		System.out.println("==========");
		for(Dog dog : dogList) {
			System.out.println(dog.showDogInfo());
		}
	}

}
