package collection.treeset;

import collection.Member;

public class MemberTreeSetTest {

	public static void main(String[] args) {
		
		MemberTreeSet memberTreeSet = new MemberTreeSet();
		
		Member park = new Member(1003, "박서훤");
		Member lee = new Member(1001, "이지원");
		Member son = new Member(1002, "손민국");
				
		memberTreeSet.addMember(lee);
		memberTreeSet.addMember(son);
		memberTreeSet.addMember(park);
		memberTreeSet.showAllMember();
		
		Member hong = new Member(1003, "홍길동");
		memberTreeSet.addMember(hong);
		memberTreeSet.showAllMember();
		
	}

}