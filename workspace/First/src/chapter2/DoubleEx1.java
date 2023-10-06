package chapter2;

public class DoubleEx1 {

	public static void main(String[] args) {
		
		double dnum = 3.14;
		float fnum = 3.14f;
		System.out.println(dnum);
		System.out.println(fnum);
		
		dnum = 1;
		for(int i = 0; i < 10000; i++) {
			dnum = dnum + 0.1;
		}
		System.out.println(dnum);
		
		fnum = 1;
		for(int i = 0; i < 10000; i++) {
			fnum = fnum + 0.1f;
		}
		System.out.println(fnum);
	}

}
