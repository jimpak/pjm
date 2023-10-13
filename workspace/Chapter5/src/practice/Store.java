package practice;

public class Store {
	String storeName;
	String menu;
	int money;
	
	public Store(String storeName, String menu) {
		this.storeName = storeName;
		this.menu = menu;
	}
	
	public void take(int money) {
		this.money += money;
	}
	
	public void showInfo() {
		System.out.println(
				);
	}
}
