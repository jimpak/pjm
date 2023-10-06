package chapter4;

import java.util.Scanner;

public class prectice {
	
	public static void main(String[] args) {
		
		//Q1
		int num1 = 10;
		int num2 = 2;
		int result = 0;
		char operator = '/';
		//if문
		if (operator == '+') {
			result = num1+num2;
			System.out.println(num1 + "+" + num2 + "=" + result);
		} else if (operator == '-') {
			result = num1-num2;
			System.out.println(num1 + "-" + num2 + "=" + result);
		} else if (operator == '*') {
			result = num1*num2;
			System.out.println(num1 + "*" + num2 + "=" + result);
		} else if (operator == '/') {
			result = num1/num2;
			System.out.println(num1 + "/" + num2 + "=" + result);
		}
		
		System.out.println("\n\n\n\n\nQ2-----------------------");
		
		//Q2
		for(int i=2; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				if(i % 2 == 1) continue;
				System.out.println(i + "x" + j + "=" + i*j);
			}
			System.out.println();
		}
		
		System.out.println("\n\n\n\n\nQ3-----------------------");
		
		//Q3
		for(int i=2; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				if(i >= j)
				System.out.println(i + "x" + j + "=" + i*j);
				else {
					break;
				}
			}
			System.out.println();
		}
		
		System.out.println("\n\n\n\n\n");
		
		
		//Q4
		for(int i=0;i<4;i++){
			for(int j=0;j<3-i;j++){
				System.out.print(" "); 
			}
			for(int j=0;j<2*i+1;j++){
				System.out.print("*"); 
			}
			System.out.println("");
		} 
		
		System.out.println("\n\n\n\n\n");
		
		
		//Q5
		for (int i=0; i<7; i++){
		  for (int j=0; j<7; j++)
		  {
		     if (i <= 7/2)// 위쪽 영역
		     {
		        if (i+j <= 7/2-1)// 왼쪽 위 공백찍기
		           System.out.print(" ");
		        else if (j-i >= 7/2+1) // 오른쪽 위 공백찍기
		        	System.out.print(" ");
		        else
		           System.out.print("*");// *찍기
		     }
		     else if (i > 7/2) //아래쪽 영역
		     {
		        if (i-j >= 7/2+1) //왼쪽 밑 공백
		        	System.out.print(" ");
		        else if (i+j >= 7/2*3+1)//오른쪽 밑 공백
		        	System.out.print(" ");
		        else
		        	System.out.print("*"); // *찍기
		     }
		  }
		  System.out.println();//줄바꿈
		}
		
		
		// Q6.
		// 윤년계산하기
		// 1. 4로 나누어 떨어지는 윤년
		// 2. 100으로 나누어 떨어지면 윤년이 아닙니다.
		// 3. 400으로 나누어 떨어지면 윤년입니다.
		// 4. Scanner 클래스로 숫자를 입력받아 윤년인지 판단
		System.out.print("년도 입력>>");
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		
		if (year % 4 == 0 || year % 400 == 0) {
			System.out.println(year + "년은 윤년 입니다.");
		}
		else if (year % 100 == 0) {
			System.out.println(year + "년은 윤년이 아닙니다.");
		} 
	}
}
