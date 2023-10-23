package map.hashmap;

import java.util.HashMap;
import java.util.Iterator;

import collection.Member;

public class MemberHashMap {
	private HashMap<Integer, Member> hashMap;
	
	public MemberHashMap() {
		hashMap = new HashMap<Integer, Member>();
	}
	
	// key-value 쌍으로 추가
	// HashMap에 회원을 추가하는 메서드
	public void addMember(Member member) {
		hashMap.put(member.getMemberId(), member);
	}
	
	// HashMap에 매개변수로 받은 키 값인 회원 아이디가 있다면 HashMap에서 회원을 삭제하는 메서드
	public boolean removeMember(int memberId) {
		if(hashMap.containsKey(memberId)) {
			hashMap.remove(memberId);
			return true;
		}
		System.out.println(memberId + "가 존재하지 않습니다.");
		return false;
	}
	
	// Iterator를 사용해 전체 회원을 출력하는 메서드
	public void showAllMember() {
		Iterator<Integer> ir = hashMap.keySet().iterator();
		while(ir.hasNext()) {
			int key = ir.next();
			Member member = hashMap.get(key);
			System.out.println(member);
		}
		System.out.println();
	}
	
}
