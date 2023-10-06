package chapter4;

import java.util.Scanner;

public class SwitchCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int ranking = 1;
		char medalColor;

		switch (ranking) {
		case 1:
			medalColor = 'G';
			break;
		case 2:
			medalColor = 'S';
			break;
		case 3:
			medalColor = 'B';
			break;
		default:
			medalColor = 'A';
		}

		System.out.println(ranking + "등 메달은 " + medalColor + " 입니다.");

		if (ranking == 1) {
			medalColor = 'G';
		} else if (ranking == 2) {
			medalColor = 'S';
		} else if (ranking == 3) {
			medalColor = 'B';
		} else {
			medalColor = 'A';
		}

		System.out.println(ranking + "등 메달은 " + medalColor + " 입니다.");

		int month = 4;
		int day = 0;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			day = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			day = 30;
			break;
		case 2:
			day = 28;
		}

		System.out.println(month + "월은 " + day + "일까지 입니다.");

	
		
		int floor = 3;
		String use = "약국";
		
		switch (floor) {
		case 1:
			floor = 1;
			use = "약국";
			break;
		case 2:
			floor = 2;
			use = "정형외과";
			break;
		case 3:
			floor = 3;
			use = "피부과";
			break;
		case 4:
			floor = 4;
			use = "치과";
			break;
		case 5:
			floor = 5;
			use = "헬스 클럽";
			break;
		}
		System.out.println(floor + "층은 " + use + "입니다!!");
		
	
		
		
		
		Scanner scan = new Scanner(System.in);
		
//		scan.nextByte()		// byte 형 입력 및 리턴
//		scan.nextShort()		// short 형 입력 및 리턴
//		scan.nextInt();		// int 형 입력 및 리턴
//		scan.nextLong()		// long 형 입력 및 리턴
//		 
//		scan.nextFloat()		// float 형 입력 및 리턴
//		scan.nextDouble()		// double 형 입력 및 리턴
//		 
//		scan.nextBoolean()	// boolean 형 입력 및 리턴
//		 
//		scan.next()			// String 형 입력 및 리턴	(공백을 기준으로 한 단어를 읽음)
//		scan.nextLine();		// String 형 입력 및 리턴 (개행을 기준으로 한 줄을 읽음)
		
		switch (scan.nextInt()) {
		case 1:
			System.out.println("1층은 약국입니다!!");
			break;
		case 2:
			System.out.println("2층은 정형외과입니다!!");
			break;
		case 3:
			System.out.println("3층은 피부과입니다!!");
			break;
		case 4:
			System.out.println("4층은 치과입니다!!");
			break;
		case 5:
			System.out.println("5층은 헬스 클럽입니다!!");
			break;
		}
		
	}

}
