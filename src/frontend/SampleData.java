import java.util.ArrayList;
import java.util.HashMap;

public class SampleData{
	public static Stock stock1 = new Stock("JOA", "Jordan Ang", 1234.22, 3230.14);
	public static Stock stock2 = new Stock("JOH", "John Harm", 3032.22, 10.20);
	public static Stock stock3 = new Stock("KEN", "Kenn Huynh", 55.32, 2022.12);
	public static Stock stock4 = new Stock("KAL", "Kall Allen", 3551.32, 253.12);
	public static Stock stock5 = new Stock("FRE", "Fomo Eagel", 6533.32, 755.12);
	public static Stock stock6 = new Stock("MON", "Moreal Nguyen", 655.32, 85.12);
	public static Stock stock7 = new Stock("TOU", "Tom Uynh", 557.32, 43.12);

	public static Person person1 = new Person("JOA", "Jordan Ang", "08-30-1996");
	public static Person person2 = new Person("JOH", "John Harm", "02-22-2000");
	public static Person person3 = new Person("KEN", "Kenn Huynh", "01-11-1999");
	public static Person person4 = new Person("KAL", "Kall Allen", "04-44-1993");
	public static Person person5 = new Person("FRE", "Fomo Eagel", "06-63-1976");
	public static Person person6 = new Person("MON", "Moreal Nguyen", "07-77-1936");
	public static Person person7 = new Person("TOU", "Tom Uynh", "11-11-1956");

	public static HashMap<String, Person> personMap = new HashMap<String, Person>();

	public SampleData(){
		personMap.put("JOA", person1);
		personMap.put("JOH", person2);
		personMap.put("KEN", person3);
		personMap.put("KAL", person4);
		personMap.put("FRE", person5);
		personMap.put("MON", person6);
		personMap.put("TOU", person7);

		

	return;
	}
}