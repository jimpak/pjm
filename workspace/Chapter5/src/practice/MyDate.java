package practice;

public class MyDate {
	private int day;
	private int month;
	private int year;
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public MyDate () {}
	public MyDate (int day, int month, int year) {
//		this.day = day;
//		this.month = month;
//		this.year = year;
		setDay(day);
		setMonth(month);
		setYear(year);
	}
	
	public String isValid() {
		// 4년마다 1년은 윤년
		// 100년이 되는 해에는 평년
		// 40년이 되는 해는 다시 윤년
		// 윤년 = 366일
		// 평년 = 365일
		if(month == 1 || month == 3 || month == 5 ||
				month == 7 || month == 8 || month == 10 || month == 12 ) {
			if(day <= 31) {
				return "유효한 날짜입니다.";
			}
		}
		else if (month == 2) {
			if(day <= 28) {
				return "유효한 날짜입니다.";
			}
		}
		else if (month == 4 || month == 6 || month == 9 || month == 11) {
			if(day <= 30) {
				return "유효한 날짜입니다.";
			}
		}
		
		return "유효하지 않은 날짜입니다";
		
	}
	
}

