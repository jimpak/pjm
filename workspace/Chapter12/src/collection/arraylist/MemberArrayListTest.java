package collection.arraylist;

import collection.Member;

public class MemberArrayListTest {

	public static void main(String[] args) {
		
		MemberArrayList memberArrayList = new MemberArrayList();
		
		// 새로운 회원 인스턴스 생성
		Member lee = new Member(1001, "이지원");
		Member son = new Member(1002, "손민국");
		Member park = new Member(1003, "박서훤");
		Member hong = new Member(1004, "홍길동");
		
		// ArrayList에 회원 추가
		memberArrayList.addMember(lee);
		memberArrayList.addMember(son);
		memberArrayList.addMember(park);
		memberArrayList.addMember(hong);
		
		// 전체 회원 출력
		memberArrayList.showAllMember();
		
		// 홍길동 회원 삭제
		memberArrayList.removeMember(hong.getMemberId());
		// 홍길동 회원 삭제 후 전체 출력
		memberArrayList.showAllMember();
		
		
		memberArrayList.insertMember(hong, 0);
		memberArrayList.showAllMember();
		
	}

}
