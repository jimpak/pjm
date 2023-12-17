package classpart;

public class Order {
	String number;
	String id;
	String date;
	String name;
	String sn;
	String address;
	
	public void showOrderInfo() {
		System.out.println("주문 번호 : " + number);
		System.out.println("주문자 아이디 : " + id);
		System.out.println("주문 날짜 : " + date);
		System.out.println("주문자 이름 : " + name);
		System.out.println("주문 상품 번호 : " + sn);
		System.out.println("배송 주소 : " + address);
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
