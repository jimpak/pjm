package practice;


public class Customer {
	public String personName;
	public int money;
	
	public Customer(String personName, int money) {
		this.personName = personName;
		this.money = money;
	}
	
	public void buyStarCafe(StarCafe cafe, int money) {
		this.money -= money;
		cafe.buyCoffee(money);
		System.out.println(personName + "님이 " + money + "에 아메리카노를 구매했습니다.");
	}
	
	public void buyKongCafe(KongCafe cafe, int money) {
		this.money -= money;
		cafe.buyCoffee(money);
		System.out.println(personName + "님이 " + money + "에 라떼를 구매했습니다.");
	}
	
	public void showInfo() {
		System.out.println(personName + "님의 남은 돈은 " + money + "원 입니다.");
	}
}
