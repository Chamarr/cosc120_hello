public class TempDemo
{
	public static void main ( String[] args )
	{
		double f = 212.0;
		// f - 32 * 5 / 9
		double c = (f - 32) * 5 / 9;
		double c2 = 5.0 / 9.0 * ( f-32 );

		System.out.println( c );
		System.out.println( c2 );
	}
}