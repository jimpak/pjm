package practice2;

import java.util.Scanner;

public class 박정민 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//배열실습문제1_Q1
		System.out.println("===== Q1 ======");
		System.out.print("알파벳 한 문자를 입력하세요>>");
		String s = sc.next(); // 문자열로 읽음
		char c = s.charAt(0); // 문자열의 첫 번째 문자
		
		for(int i = 97; i <= c; i++) {
			for(int j = i; j <= c; j++) {
				char str = (char)j;
				System.out.print(str);
			}
			System.out.println();
		}
		
		//배열실습문제1_Q2
		System.out.println();
		System.out.println("===== Q2 ======");
		System.out.print("정수 10개 입력>>");
		int[] numList = new int[10];
		
		for(int i = 0; i < 10; i++) {
			numList[i] = sc.nextInt();
			if(numList[i] % 3 == 0) {
			 System.out.println(numList[i]);
			}
		}
		
		
		
		//배열실습문제1_Q3
		System.out.println();
		System.out.println("===== Q3 ======");
		System.out.print("정수를 입력하세요>>");
		
		try {
			int num = sc.nextInt();
			if(num % 2 == 0) System.out.println("짝수");
			else if(num % 2 == 1) System.out.println("홀수");
		}
		catch (Exception e) {
			System.out.println("수를 입력하지 않아 프로그램을 종료합니다.");
		}


		
		//배열실습문제1_Q5
		System.out.println();
		System.out.println("===== Q2 ======");
		System.out.print("정수 10개 입력>>");
		int[] intArr = new int[10];
		
		for(int i=0; i<intArr.length; i++) {
			intArr[i] = sc.nextInt();
		}
		
		for(int a=0; a<intArr.length; a++) {			
			for(int b=a; b<intArr.length; b++) {
				if(intArr[a] > intArr[b]) {
					int tmp = intArr[a];
					intArr[a] = intArr[b];
					intArr[b] = tmp;
				}
			}			
		}
		
		for(int a=0; a<intArr.length; a++) {
			System.out.print(intArr[a] + " ");
		}
		
	}
}

