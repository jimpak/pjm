package chapter3;

public class OperationEx2 {

	public static void main(String[] args) {
		// 증가, 감소 연산자
		
		//++num : 먼저 num 값이 1 증가한 후 변수에 대입
		//num++ : 변수에 기존 num값을 먼저 대입한 후 num 값 1 증가
		//num-- : 변수에 기존 num값을 먼저 대입한 후 num 값 1 감소
		
		//--num : 먼저 num 값이 1 감소한 후 변수에 대입
		
		int gameScore = 150;
		
		int lastScore1 = ++gameScore;
		System.out.println(lastScore1);
		
		int lastScore2 = --gameScore;
		System.out.println(lastScore2);
		System.out.println(lastScore1 != lastScore2);
		System.out.println(1 == 2);
		
		// && : 두개의 항이 모두 true 출력 (AND)
		// || : 두개의 항 중 하나가 true면 true 출력 (OR)
		boolean b = true;
		boolean c = !true;
		System.out.println(b);
		System.out.println(c);
		
		int a = 10;
		System.out.println(a+=10);
		System.out.println(a-=10);
		System.out.println(a*=10);
		System.out.println(a/=10);
		System.out.println(a%=10);
		System.out.println(a<<=10);
		System.out.println(a>>=10);
		System.out.println(a>>>=10);
		System.out.println(a&=10);
		System.out.println(a|=10);
		System.out.println(a^=10);
	

	}

}
