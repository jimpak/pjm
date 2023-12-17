package cooperation;

public class TakeTrans {

	public static void main(String[] args) {
		Student james = new Student("James", 5000);
		Student tomas = new Student("Tomas", 10000);
		Student edward = new Student("Edward", 10000);
		
		Bus bus100 = new Bus(100);
		james.takeBus(bus100);
		james.showInfo();
		bus100.showInfo();
		
		Subway subwayGreen = new Subway("2호선");
		tomas.takeSubway(subwayGreen);
		tomas.showInfo();
		subwayGreen.showInfo();
		
		Taxi taxi9920 = new Taxi(9920);
		edward.takeTaxi(taxi9920);
		edward.showInfo();
		taxi9920.showInfo();
	}

}
