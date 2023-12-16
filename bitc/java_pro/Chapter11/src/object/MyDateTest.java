package object;

class MyDate {
	int day;
	int month;
	int year;

	public MyDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof MyDate) {
			MyDate date = (MyDate)obj;
			if(this.day == date.day
					&& this.month == date.month
					&& this.year == date.year)
				return true;
			else
				return false;
		}
		return false;
	}
}

public class MyDateTest {
	public static void main (String[] args) {
		MyDate date1 = new MyDate(9, 18, 2004);
		MyDate date2 = date1;
		MyDate date3 = new MyDate(9, 18, 2005);
		System.out.println(date1.equals(date2));
		System.out.println(date1.equals(date3));
		System.out.println(date1.hashCode());
		System.out.println(date2.hashCode());
		System.out.println(date1.toString());
		
		String str1 = new String("a");
		String str2 = new String("a");
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
	}
}