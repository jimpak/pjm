package abstractex;

//public class Computer {
public abstract class Computer {
//	public void display();
	public abstract void display();
//	public void typing();
	public abstract void typing();
	public void turnOn() {
		System.out.println("전원을 켭니다.");
	}
	public void turnOff() {
		System.out.println("전원을 끕니다.");
	}
}
