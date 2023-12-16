package polymorphism;

import java.util.ArrayList;


public class CustomerTest {

	public static void main(String[] args) {
		
		ArrayList<Customer> list = new ArrayList<Customer>();
		
		Customer lee = new Customer(10010, "이순신");
		Customer shin = new Customer(10020, "신사임당");
		Customer hong = new GoldCustomer(10030, "홍길동");
		Customer youl = new GoldCustomer(10040, "이율곡");
		Customer kim = new VIPCustomer(10050, "김유신", 12345);
		
		list.add(lee);
		list.add(shin);
		list.add(hong);
		list.add(youl);
		list.add(kim);
		
		System.out.println("====== 고객 정보 출력 ======");
		for(Customer customer : list) {
			System.out.println(customer.showCustomerInfo());
		}
		
		System.out.println();
		System.out.println("====== 할인율과 보너스 포인트 계산 ======");
		int price = 10000;
		for(Customer customer : list) {
			int cost = customer.calcPrice(price);
			System.out.println(customer.getCustomerName() 
					+ " 님이 " + cost + "원 지불하셨습니다.");
			System.out.println(customer.getCustomerName()
					+ " 님의 현재 보너스 포인트는 " + customer.bonusPoint + "점입니다.");
		}
		
	}

}
