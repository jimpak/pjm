package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsException {

	public Class loadClass(String fileName, String className) 
			// 두 예외를 메서드가 호출될 때 처리하도록 미룸
			throws FileNotFoundException, ClassNotFoundException {
		//FileNotFoundException 발생 가능
		FileInputStream fis = new FileInputStream(fileName);
		//ClassNotFoundException 발생 가능
		Class c = Class.forName(className);
		return c;
	}
	
	public static void main(String[] args)  {
		
		ThrowsException test = new ThrowsException();
		
		try {
		// 메서드를 호출할 때 예외를 처리
			test.loadClass("a.txt", "java.lang.String");
		// 여러 예외를 한 문장으로 처리.
		} catch (FileNotFoundException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			// 메서드를 호출할 때 예외를 처리
				test.loadClass("a.txt", "java.lang.String");
			// 여러 예외를 한 문장으로 처리.
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();			
			// Exception 클래스로 그 외 예외 상황 처리.
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		

	}

}
