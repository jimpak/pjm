package practice;

public class Q3 {
	public static void main(String[] agrs) {
		int[] array  = new int[5];
		int val = 0;
		int sum = 0;

		for (int i = 0; i < array.length; i++) {
			val += 2;
			array[i] += val;
			sum += array[i];
			System.out.println(array[i] + " " + val + " " + sum);
		}
	}
}
