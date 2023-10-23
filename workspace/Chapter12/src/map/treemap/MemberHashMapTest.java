package map.treemap;

import collection.Member;

public class MemberHashMapTest {

	public static void main(String[] args) {
		
		MemberTreeMap memberTreeMap = new MemberTreeMap();
		
		Member lee = new Member(1001, "이지원");
		Member son = new Member(1002, "손민국");
		Member park = new Member(1003, "박서훤");
		Member hong = new Member(1004, "홍길동");
		
		memberTreeMap.addMember(lee);
		memberTreeMap.addMember(son);
		memberTreeMap.addMember(park);
		memberTreeMap.addMember(hong);
		
		memberTreeMap.showAllMember();
		
		memberTreeMap.removeMember(1004);
		memberTreeMap.showAllMember();

	}

}
