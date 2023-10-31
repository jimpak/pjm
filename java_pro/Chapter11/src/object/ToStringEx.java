package object;

class Book {
	int bookNumber;
	String bookTitle;
	
	Book(int bookNumber, String bookTitle) {
		this.bookNumber = bookNumber;
		this.bookTitle = bookTitle;
	}
	
	@Override
	public String toString() {
		return bookTitle + ", " + bookNumber;
	}
	
	public boolean equals(Object obj) {
		
		if(obj instanceof Book) {
			Book book = (Book)obj;
			if(this.bookNumber == book.bookNumber
					&&this.bookTitle.equals(book.bookTitle)) {
				return true;
			}
		}
		
		return false;
	}
	
}

	
public class ToStringEx {
	public static void main(String[] args) {
		Book book1 = new Book(200, "개미");
		System.out.println(book1); // 개미, 200
		System.out.println(book1.toString()); // 개미, 200
		
		Book book2 = book1;
		book2.bookTitle = "베짱이";
		System.out.println(book1); // 베짱이, 200
		System.out.println(book2); // 베짱이, 200
		
		Book book3 = new Book(200, "개미");
		System.out.println(book1); // 베짱이, 200
		System.out.println(book2); // 베짱이, 200
		System.out.println(book3); // 개미, 200
		
		System.out.println(book1.equals(book2));
		System.out.println(book1 == book2);
		System.out.println(book1.equals(book3));
		System.out.println(book1 == book3);
	}
}