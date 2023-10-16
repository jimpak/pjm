package array;

import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {
		
		int[] array = new int[10];
		array[0] = 1;
		array[1] = 1;
		array[2] = 1;
		array[3] = 1;
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		
		System.out.println();
		
		int [] array2 = {1,2,3,4};	
		for(int i = 0; i < array2.length; i++) {
			System.out.print(array2[i]+ " ");
		}
		
		System.out.println();
		
		int [] array3 = {1,2,3,4,1634,315732,13257,23457};
		System.out.println(array3.toString());
		System.out.println(Arrays.toString(array3));
		
		int array4 [] = new int[10];
		String array5 [] = new String[10];

	}

}
