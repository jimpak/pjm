package practice4;

import java.util.ArrayList;
import java.util.Scanner;

class Song {
	String title;
	
	public Song(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
}

class Phone {
	private String name, tel;
	public Phone(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	public String getName() { return name; }
	public String getTel() { return tel; }
}

class Rect {
	private int width, height;
	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
	}
	public int getArea() { return width*height; }
}


public class 박정민 {
	public static void main(String[] args) {
		
		//Q1
		Song mySong = new Song("Nessum Dorma");
		Song yourSong = new Song("공주는 잠 못 이루고");
		System.out.println("내 노래는 " + mySong.getTitle());
		System.out.println("너 노래는 " + yourSong.getTitle());
		
		
		System.out.println();
		//Q2
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름과 전화번호 입력 >> ");
		Phone bob = new Phone(sc.next(), sc.next());
		System.out.print("이름과 전화번호 입력 >> ");
		Phone jing = new Phone(sc.next(), sc.next());
		
		System.out.println(bob.getName() + "의 번호 " + bob.getTel());
		System.out.println(jing.getName() + "의 번호 " + jing.getTel());
		
		
		System.out.println();
		//Q3
		ArrayList<Rect> rectArr = new ArrayList<Rect>();
		int sum = 0;
		for(int i = 1; i <= 4; i++) {
			System.out.print(i + " 너비와 높이 >> ");
			Rect rect = new Rect(sc.nextInt(), sc.nextInt());
			rectArr.add(rect);
		}
		System.out.println("저장하였습니다...");
		
		for(Rect arr : rectArr) {
			sum += arr.getArea();
		}
		System.out.println("사각형의 전체 합은 " + sum);
		
	}
}

