package chapter4;

import java.util.Scanner;

public class RCP {
	public static void main(String[] args) {
		// 키보드 입력을 받기위한 Scanner클래스 생성
		Scanner sc = new Scanner(System.in);
		// nextInt()나 next()로 키보드 값 받아오기
		int player = sc.nextInt();
		// 컴퓨터의 랜덤값 생성
		int computer = (int)(Math.random()*3);
		// Math.random()*3 : 0~1 사이의 소수점 숫자
		// 0.9 * 3 = 2.7, 0.99 * 3 = 2.97, 0.99999999999 * 3 = 2.99999999997
		// 2이상의 값이 나오지 않는다.
		
		System.out.println(player);
		System.out.println(computer);
		
		
		//가위바위보 게임의 if문 작성
		//가위=0, 바위=1, 보=2
		if ((player == 0 && computer == 0) || 
				(player == 1 && computer == 1) ||
					(player == 2 && computer == 2)) {
			System.out.println("비겼습니다");
		}
		else if ((player == 0 && computer == 1) ||
					(player == 1 && computer == 2) ||
						(player == 2 && computer == 0)) {
			System.out.println("졌습니다");
		}
		else if ((player == 0 && computer == 2) ||
					(player == 1 && computer == 0) ||
						(player == 2 && computer == 1)) {
			System.out.println("이겼습니다");
		}
		else {
			System.out.println("무효입니다. 다시하세요.");
		}
		
		
		
	}
	
}