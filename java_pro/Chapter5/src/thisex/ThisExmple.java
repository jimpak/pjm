package thisex;

//this : 생성된 인스턴스 스스로를 가리키는 예약어
class BirthDay {
	int day;
	int month;
	int year;
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void printThis() {
		System.out.println(this);
	}
}


public class ThisExmple {	
	public static void main(String[] args) {

		BirthDay bDay = new BirthDay();
		bDay.setYear(2000);
		System.out.println(bDay);
		bDay.printThis();
	}

}
