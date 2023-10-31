package array;

public class TwoDimensionAlphabets {

	public static void main(String[] args) {
		
		char[][] alphabets = new char[13][2];
		char first = 'a';
			
		for(int i = 0; i < alphabets.length; i++) {
			for(int j = 0; j < alphabets[i].length; j++) {
				alphabets[i][j] = first++;
				System.out.print(alphabets[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("\n");
		
		for(char[] arr : alphabets) {
			for(char ch : arr) {
				System.out.print(ch + " ");
			}
			System.out.println();
		}
		
	}

}