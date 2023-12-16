package chapter4;

import java.util.Scanner;

public class ContinueExample {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int total = 0;
		int num = sc.nextInt();
		
		for(int i = 1; i <= num; i++) {
			if(i % 2 == 0) continue;
			total += i;
		}
		System.out.println("1부터 " + num + "까지 홀수의 합은? " + total + "입니다~~" );

	}

}
