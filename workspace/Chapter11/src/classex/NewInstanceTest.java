package classex;

public class NewInstanceTest {

	public static void main(String[] args) throws ClassNotFoundException 
			, InstantiationException, IllegalAccessException {
		
		Person person1 = new Person();
		System.out.println(person1);
		
		Class pClass = Class.forName("classex.Person");
		Person person2 = (Person)pClass.newInstance();
		System.out.println(person2);
		
		
		System.out.println();
		
		
		NewInstanceTest instance1 = new NewInstanceTest();
		System.out.println(instance1);
		
		Class iClass = Class.forName("classex.NewInstanceTest");
		NewInstanceTest instance2 = (NewInstanceTest)iClass.newInstance();
		System.out.println(instance2);
	}

}

