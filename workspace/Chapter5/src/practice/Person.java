package practice;


public class Person {
	public String personName;
	public int money;
	
	public Person(String personName, int money) {
		this.personName = personName;
		this.money = money;
	}
	
	public void take(Store store) {
		switch(store.storeName) {
		case "별다방":
			switch(store.menu) {
			case "아메리카노":
				this.money -= 4000;
				break;
			case "라테":
				this.money -= 4500;
				break;
			}
			break;
		case "콩다방":
			switch(store.menu) {
			case "아메리카노":
				this.money -= 4000;
				break;
			case "라테":
				this.money -= 4500;
				break;
			}
			break;
		}
	}
	
	public void showInfo() {
		System.out.println(personName + "님의 남은 돈은" + money + "입니다.");
	}
}
