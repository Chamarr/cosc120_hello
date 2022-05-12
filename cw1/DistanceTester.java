public class DistanceTester
{
	public static void main(String[] args)
	{
		Distance d1 = new Distance();
		Distance d2 = new Distance();
		d1.setInches(3.0);
		d2.setCentimeters(3.0);
		Distance d3 = d1.add(d2);
		System.out.println( d3.getInches() );
	}
}
