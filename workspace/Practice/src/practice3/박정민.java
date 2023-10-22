package practice3;

import java.util.Scanner;

public class 박정민 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Q1
		int[] n = new int[10];
		System.out.print("돈의 액수를 입력하세요>>");
		int won = sc.nextInt();
		n[0] = won/50000;
		won -= 50000*n[0];
		n[1] = won/10000;
		won -= 10000*n[1];
		n[2] = won/5000;
		won -= 5000*n[2];
		n[3] = won/1000;
		won -= 1000*n[3];
		n[4] = won/500;
		won -= 500*n[4];
		n[5] = won/100;
		won -= 100*n[5];
		n[6] = won/50;
		won -= 50*n[6];
		n[7] = won/10;
		won -= 10*n[7];
		n[8] = won%10;

		System.out.println("오만원" + n[0] + "개, " +
				"만원" + n[1] + "개, " +
				"오천원" + n[2] + "개, " +
				"천원" + n[3] + "개, " +
				"500원" + n[4] + "개, " +
				"100원" + n[5] + "개, " +
				"50원" + n[6] + "개, " +
				"10원" + n[7] + "개, " +
				"1원" + n[8] + "개, "
		);



		System.out.println("====== Q2 ======");
		// Q2
		System.out.print("1~99사이의 정수를 입력>>");
		int num = sc.nextInt();

		int a = num/10; //십의 자리 수
		int b = num%10; //1의 자리 수
		int cnt=0;

		if(num <10) { //num이 1의 자리인 경우
			if (b%3 == 0 )
				cnt++;
		}

		else {  //num이 10의 자리인 경우
			if(a %3 == 0) { //10의 자리수가 3으로 나뉠 때
				cnt++;
			}
			if(b%3 == 0 ){//1의 자리수가 3으로 나뉠 때
				cnt++;
			}
		}

		switch(cnt) {
			case 0:
				System.out.println("박수 없음");
				break;
			case 1:
				System.out.println("박수짝");
				break;
			case 2:
				System.out.println("박수짝짝");
				break;
		}



		System.out.println("====== Q3 ======");
		// Q3
		System.out.println(" | 1  2  3  4  5  6  7  8  9");
		System.out.println("-+---------------------------");
		for (int i=1;i<10;i++) {
			System.out.print(i);
			for (int j=1;j<10;j++) {
				System.out.printf("%3d", i*j);
			}
			System.out.println();
		}



		System.out.println("====== Q4 ======");
		// Q4
		System.out.print("소문자 알파벳 하나를 입력하시오>> ");
		String s = sc.next();
		char c = s.charAt(0);

		for(int i=c-'a'; i>=0; i--){
			for(int j=0; j<=i; j++)
				System.out.print((char)('a'+j));
			System.out.println();
		}



		System.out.println("====== Q5 ======");
		// Q5
		int[] arr = new int[10];

		for (int i = 0; i < 10; i++) {
			//Math.random() * 100의 경우 0~99까지 출력되기 때문에 +1추가
			int result = (int)(Math.random() * 100 + 1);
			if(result % 3 == 0) {
				arr[i] = result;
				System.out.print(arr[i] + " ");
			} else i--;
		}


		System.out.println();
		System.out.println("====== Q6 ======");
		// Q6
//		선택 정렬
//		- 최솟값을 찾아서 맨 앞으로 이동하는 방식
//		- 버블 정렬보다 좋음
//		삽입 정렬
//		- 앞에서부터 차례대로 이미 정렬된 부분과 비교하여 교환하는 방식
//		- 셋 중에 제일 빠르지만 배열이 길어질수록 효율성이 떨어짐
// 		버블 정렬
//		- 인접한 원소끼리 비교하여 교환하는 방식
//		- 셋 중에 제일 느리지만 단순함
		int [] arr2 = {15,7,2,9,10,12,17,11,20,5};

		// 선택 정렬
		for(int i=0 ; i<arr2.length ; i++){
			int idx = i;
			int tmp = 0;

			for(int j=i+1 ; j<arr2.length ; j++){
				if(arr2[idx] > arr2[j]) idx = j;
			}

			tmp = arr2[idx];
			arr2[idx] = arr2[i];
			arr2[i] = tmp;
		}

		for(int val : arr2) {
			System.out.print(val + " ");
		}
		System.out.println();

		// 선택 정렬
		int q;
		for(int i=1 ; i<arr2.length ; i++){
			int idx = arr2[i];

			for(q = i - 1; q >= 0; q--){
				if(arr2[q] > idx) arr2[q + 1] = arr2[q];
				else break;
			}
			arr[q + 1] = idx;
		}

		for(int val : arr2) {
			System.out.print(val + " ");
		}
		System.out.println();

		// 버블 정렬
		for(int i = 0; i < arr2.length; i++){
			for(int j = 1; j<arr2.length-i; j++){
				if(arr2[j - 1] > arr2[j]) {
					int tmp = arr2[j - 1];
					arr2[j - 1] = arr2[j];
					arr2[j] = tmp;
				}
			}
		}

		for(int val : arr2) {
			System.out.print(val + " ");
		}
		System.out.println();



		System.out.println("====== Q7 ======");
		// Q7
		for(int i=1; i<=5; i++) {
			for (int j=1; j<=5-i; j++) {
				System.out.print("  "); //공백
			}
			for (int j=1; j<=i*2-1; j++) { //별
				System.out.print("* ");
			}
			System.out.println();
		}

		for(int i=4; i>0; i--) {    //하단
			for (int j=4; j>=i; j--) {
				System.out.print("  "); //공백
			}
			for (int j=1; j<=i*2-1; j++) {
				System.out.print("* ");
			}

			System.out.println();
		}

	}
}


