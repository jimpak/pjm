package sorting;

public class HeapSort implements Sort {

	String sort = "HeapSort";
	
	@Override
	public void ascending(int[] arr) {
		System.out.println(sort + " ascending");
	}
	
	@Override
	public void descending(int[] arr) {
		System.out.println(sort + " descending");
	}
	
	@Override
	public void description() {
//		Sort.super.description();
		System.out.println("숫자를 정렬하는 알고리즘입니다.");
		System.out.println(sort + " 입니다.");
	}
	
}
