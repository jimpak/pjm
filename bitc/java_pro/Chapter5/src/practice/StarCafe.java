package practice;

public class StarCafe {
	String name;
	String menu;
	int customerCount;
	int money;
	
	public StarCafe(String name) {
		this.name = name;
	}
	
	public void buyAmericano(int money) {
		this.money += money;
		customerCount++;
	}
	
	public void buyCoffee(int money) {
		this.money += money;
		customerCount++;
	}
}
