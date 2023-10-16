package array;

public class ObjectCopy1 {

	public static void main(String[] args) {
		// 메모리 주소값을 복사하는 것이기 때문에 하나를 수정하면 모든 값이 변함

		Book[] bookArray1 = new Book[3];
		Book[] bookArray2 = new Book[3];
		
		bookArray1[0] = new Book("태백산맥", "조정래");
		bookArray1[1] = new Book("데미안", "헤르만 헤세");
		bookArray1[2] = new Book("어떻게 살 것인가", "유시민");
		System.arraycopy(bookArray1, 0, bookArray2, 0, 3);
		
		bookArray2[0].setBookName("나목");
//		bookArray2[0].setAuthor("박완서");
		
		for(int i = 0; i < bookArray2.length; i++) {
			bookArray2[i].showBookInfo();
			
			System.out.println(bookArray1[i]);
			System.out.println(bookArray2[i]);
		}

	}

}
