package practice;

public class TakeTrans {
	
	/*
	Q5. 아침 출근길에 김 씨는 4,000원을 내고 별다방에서 아메리카노를 사 마셨습니다.
	이 씨는 콛다방에서 4,500원을 내고 라테를 사 마셨습니다.
	
	Q6. 카드 회사에서 카드를 발급할 때마다 카드 고유 번호를 부여해 줍니다.
	06-3의 <학번 생성하기>예제를 참고하여 카드가 생성될 때마다 카드 번호가 자동으로 증가할 수 있도록
	클래스를 만들고 생성해 보세요.
	
	Q7. Q6에서 구현한 내용에 카드 회사 클래스 CardCompany를 싱글톤 피턴을 사용하여 구현해 보세요.
	*/
	public static void main(String[] args) {
		Person kim = new Person("김씨", 5000);
		Person lee = new Person("이씨", 10000);
		
		Store store1 = new Store("별다방", "아메리카노");
		kim.take()
	}
}
