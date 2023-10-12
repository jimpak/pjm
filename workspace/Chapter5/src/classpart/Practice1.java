package classpart;

public class Practice1 {

	//p.152
	public static void main(String[] args) {
		//1.
		Man man = new Man();
		
		man.age = 40;
		man.name = "James";
//		man.isMarried = true;
		man.setMarried(true);
//		man.child = 3;
		man.setChild(3);
		
		System.out.println("이 사람의 나이 " + man.getAge());
		System.out.println("이 사람의 이름 " + man.getName());
		System.out.println("이 사람의 결혼 여부 " + man.isMarried);
		System.out.println("이 사람의 자녀 수 " + man.getChild());
		
		
		System.out.println("\n");
		
		//2.
		Order order = new Order();
		Order order2 = new Order();
		
		order.number = "201803120001";
		order.id = "abc123";
		order.date = "2018년 3월 12일";
		order.name = "홍길순";
		order.sn = "PD0345-12";
		order.address = "서울시 영등포구 여의도동 20번지";
		
		order2.number = "202310120005";
		order2.id = "qwer1234";
		order2.date = "2023년 10월 12일";
		order2.name = "정도전";
		order2.sn = "PD0345-33";
		order2.address = "부산광역시 부산진구";
		
		order.showOrderInfo();
		System.out.println();
		order2.showOrderInfo();
	}

}
