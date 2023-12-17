package prectice;

import java.util.HashMap;

class Car {
	String name;
	public Car() {}
	public Car(String name) {
		this.name = name;
	}
}

class CarFactory {
	// 싱글톤
	private static CarFactory instance = new CarFactory();
	private CarFactory() {}
	public static CarFactory getInstance() {
		return instance;
	}
	//해쉬맵
	private HashMap<String, Car> map = new HashMap();
	
	public Car createCar(String name) {
		// 중복확인
		if(map.containsKey(name) ) {
			return map.get(name);
		}
		
		Car car = new Car(name);
		map.put(name, car);
		return car;
	}
}

public class CarTest {

	public static void main(String[] args) {
		
		CarFactory factory = CarFactory.getInstance();
		Car sonata1 = factory.createCar("연수 차");
		Car sonata2 = factory.createCar("연수 차");
		System.out.println(sonata1 == sonata2); // true
		
		Car avante1 = factory.createCar("승연 차");
		Car avante2 = factory.createCar("승연 차");
		System.out.println(avante1 == avante2); // true
		
		System.out.println(sonata1 == avante1); // false
		
		
	}

}