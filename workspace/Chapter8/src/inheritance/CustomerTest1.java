package inheritance;

public class CustomerTest1 {

	public static void main(String[] args) {
		
		Customer lee = new Customer();
		// ID, Name은 protected 이므로 set() 메서드 호출
		lee.setCustomerID(10010);
		lee.setCustomerName("이순신");
		lee.bonusPoint = 1000;
		System.out.println(lee.showCustomerInfo());
		
		// 상위 클래스를 상속받은 하위 클래스가 생성될 때 반드시 상위 클래스가 먼저 호출
		// 상위 클래스 생성자가 호출될 때 상위 클래스의 멤버 변수가 메모리에 생성
		VIPCustomer kim = new VIPCustomer();
		kim.setCustomerID(10020);
		kim.setCustomerName("김유신");
		kim.bonusPoint = 10000;
		System.out.println(kim.showCustomerInfo());
		
		VIPCustomer park = new VIPCustomer(10030, "박정민", 1001);
		park.bonusPoint = 5000;
		System.out.println(park.showVIPInfo());
		
		Customer a = new VIPCustomer(10040, "a", 1002);
		a.bonusPoint = 3000;
		// 오버라이딩 되지 않은 메서드는 호출할 수 없음.
//		System.out.println(a.getAgentID);
		System.out.println(a.calcPrice(10000));
	}

}
