package practice1;

import java.util.Scanner;

public class 박정민 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 1.
		int a1 = sc.nextInt();
		int b1 = sc.nextInt();
		System.out.println(a1 + "+" + b1 + "=" + (a1+b1));
		
		// 2.
		System.out.print("몇 층인지 입력하세요>>");
		int floor = sc.nextInt();
		System.out.println(floor*5 + "m 입니다.");
		
		// 3.
		System.out.print("x 값을 입력하세요>>");
		int x = sc.nextInt();
		System.out.println("x=" + x + ", y=" + (int)(Math.pow(x, 2) - (3 * x) + 7));
		
		// 5.
		System.out.print("논리연산을 입력하세요>>");
		boolean a5 = sc.nextBoolean();
		String op = sc.next();
		boolean b5 = sc.nextBoolean();
		
		switch(op) {
		case "AND":
			if(a5 == b5) {
				System.out.println("ture");
			} else {
				System.out.println("false");
			}
			break;
		case "OR":
			if(a5 == false && b5 == false) {
				System.out.println("false");
			} else {
				System.out.println("true");
			}
			break;
		}
		
		// 6.
		System.out.print("돈의 액수를 입력하세요>>");
		int won = sc.nextInt();
		int w50000 = won/50000;
		won -= 50000*w50000;
		int w10000 = won/10000;
		won -= 10000*w10000;
		int w5000 = won/5000;
		won -= 5000*w5000;
		int w1000 = won/1000;
		won -= 1000*w1000;
		int w500 = won/500;
		won -= 500*w500;
		int w100 = won/100;
		won -= 100*w100;
		int w50 = won/50;
		won -= 50*w50;
		int w10 = won/10;
		won -= 10*w10;
		int w1 = won%10;
		
		System.out.println("오만원" + w50000 + "개, " +
				"만원" + w10000 + "개, " +
				"오천원" + w5000 + "개, " +
				"천원" + w1000 + "개, " +
				"500원" + w500 + "개, " +
				"100원" + w100 + "개, " +
				"50원" + w50 + "개, " +
				"10원" + w10 + "개, " +
				"1원" + w1 + "개, "
				);
		
//		int change = 0;
//		System.out.print("돈의 액수를 입력하세요>>");
//		int won = sc.nextInt();
//		
//		for(change=0; won >= 50000; change++) {
//			won -= 50000;
//		}
//		System.out.print("5만원" + change + "개, ");
//		
//		for(change = 0; won >= 10000; change++) {
//			won -= 10000;
//		}
//		System.out.print("1만원" + change + "개, ");
//		
//		for(change = 0; won >= 5000; change++) {
//			won -= 5000;
//		}
//		System.out.print("5천원" + change + "개, ");
//		
//		for(change = 0; won >= 1000; change++) {
//			won -= 1000;
//		}
//		System.out.print("천원" + change + "개, ");
//		
//		for(change = 0; won >= 500; change++) {
//			won -= 500;
//		}
//		System.out.print("500원" + change + "개, ");
//		
//		for(change = 0; won >= 100; change++) {
//			won -= 100;
//		}
//		System.out.print("100원" + change + "개, ");
//		
//		for(change = 0; won >= 50; change++) {
//			won -= 50;
//		}
//		System.out.print("50원" + change + "개, ");
//		
//		for(change = 0; won >= 10; change++) {
//			won -= 10;
//		}
//		System.out.print("10원" + change + "개, ");
//		
//		for(change = 0; won >= 1; change++) {
//			won -= 1;
//		}
//		System.out.print("1원" + change + "개");
		
		
		// 7.
		System.out.print("학점을 입력하세요>>");
		switch(sc.next()) {
		case "A":
		case "B":
			System.out.println("Excellent");
			break;
		case "C":
		case "D":
			System.out.println("Good");
			break;
		case "F":
			System.out.println("Bye");
			break;
		}
		
		
		// 8.
		// if
//		System.out.print("커피 주문하세요>>");
//		String coffee = sc.next();
//		int val = sc.nextInt();
//		int price = 0;
//		
//		if(coffee.equals("에스프레소")) {
//			price = 2000;
//		}
//		else if(coffee.equals("아메리카노")) {
//			price = 2500;
//		}
//		else if(coffee.equals("카푸치노")) {
//			price = 3000;
//		}
//		else if(coffee.equals("카페라떼")) {
//			price = 3500;	
//		}
//		System.out.println(price*val + "원입니다.");
		
		
		//switch
		System.out.print("커피 주문하세요>>");
		String coffee = sc.next();
		int val = sc.nextInt();
		int price = 0;
		
		switch(coffee) {
		case "에스프레소":
			price = 2000;
			break;
		case "아메리카노":
			price = 2500;
			break;
		case "카푸치노":
			price = 3000;
			break;
		case "카페라떼":
			price = 3500;
			break;
		}
		System.out.println(price*val + "원입니다.");
		
	}

}
