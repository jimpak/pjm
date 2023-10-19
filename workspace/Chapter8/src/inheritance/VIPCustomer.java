package inheritance;

public class VIPCustomer extends Customer {

	private int agentID; // VIP 고객 담당 상담원 아이디
	double saleRatio; // 할인율
	
	// 디폴트 생성자
	public VIPCustomer() {
		super(); // 부모를 부르는 예약어
		customerGrade = "VIP"; // 고객 등급 VIP
		bonusRatio = 0.05; // 보너스 적립 5%
		saleRatio = 0.1; // 할인율 10%
		System.out.println("VIPCustomer() 생성자 호출");
	}
	
	public VIPCustomer(int customerID, String customerName, int agentID) {
		super(customerID, customerName); // 부모를 부르는 예약어
		customerGrade = "VIP"; // 고객 등급 VIP
		bonusRatio = 0.05; // 보너스 적립 5%
		saleRatio = 0.1; // 할인율 10%
		this.agentID = agentID;
		System.out.println("VIPCustomer(int, String, int) 생성자 호출");
	}
	
	// 오버라이딩 : 상위 클래스에서 정의한 메서드가 하위 클래스에서 구현할 내용과 맞지 않을 경우에 사용
	@Override
	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio; // 보너스 포인트 적립
		return price - (int)(price * saleRatio); // 할인된 가격을 계산하여 반환
	}
	
	// VIP 고객에게만 필요한 메서드
	public int getAgentID() {
		return agentID;
	}
	
	public String showVIPInfo() {
		return super.showCustomerInfo() + "담당 상담원 아이디는 " + agentID + "입니다.";
	}
}

/*
public class VIPCustomer {
	// Customer 클래스와 겹치는 멤버 변수
	private int customerID;
	private String customerName;
	private String customerGrade;
	int bonusPoint;
	double bonusRatio;
	//VIP 고객 관련 기능을 구현할 때만 필요한 멤버 변수
	private int agentID; // VIP 고객 담당 상담원 아이디
	double saleRatio; // 할인율
	
	// 디폴트 생성자
	public VIPCustomer() {
		customerGrade = "VIP"; // 고객 등급 VIP
		bonusRatio = 0.05; // 보너스 적립 5%
		saleRatio = 0.1; // 할인율 10%
	}
	
	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;
		return price - (int)(price * saleRatio); // 할인율 적용
	}
	
	// VIP 고객에게만 필요한 메서드
	public int getAgentID() {
		return agentID;
	}
	
	public String showCustomerInfo() {
		return customerName + " 님의 등급은 " + customerGrade + "이며, 보너스 포인트는 " + bonusPoint + "입니다.";
	}
}
*/