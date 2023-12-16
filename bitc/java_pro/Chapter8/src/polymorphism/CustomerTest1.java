package polymorphism;

public class CustomerTest1 {

	public static void main(String[] args) {
		
		Customer lee = new Customer();
		// ID, Name은 protected 이므로 set() 메서드 호출
		lee.setCustomerID(10010);
		lee.setCustomerName("이순신");
		lee.bonusPoint = 1000;
		System.out.println(lee.showCustomerInfo());
		
		Customer kim = new VIPCustomer(10020, "김유신", 12345);
		kim.bonusPoint = 10000;
		System.out.println(kim.showCustomerInfo());
		
		System.out.println();
		System.out.println("====== 할인율과 보너스 포인트 계산 =======");
		
		int price = 10000;
		int leePrice = lee.calcPrice(price);
		int kimPrice = kim.calcPrice(price);
		
		System.out.println(lee.getCustomerName() + " 님이" + leePrice + "원 지불하셨습니다.");
		System.out.println(lee.showCustomerInfo());
		
		System.out.println(kim.getCustomerName() + " 님이" + kimPrice + "원 지불하셨습니다.");
		System.out.println(kim.showCustomerInfo());
	}

}
