package abstractex;

// 상속받은 클래스는 추상 메서드 포함
// 추상 메서드를 모두 구현하든가 DeskTop도 추상 클래스로 만들던가
public class DeskTop extends Computer {

	@Override
	public void display() { System.out.println("DeskTop display()"); }
	@Override
	public void typing() { System.out.println("DeskTop typing()"); }
}
