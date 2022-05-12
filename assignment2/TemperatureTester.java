public class TemperatureTester
{
	public static void main(String[] args)
	{
		Temperature t1 = new Temperature();
		Temperature t2 = new Temperature();
		t1.setFarenheit(25.0);
		t2.setCelsius(25.0);
		Temperature t3 = t1.add(t2);
		System.out.println( t3.getCelsius() );
	}
}