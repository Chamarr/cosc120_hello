public class DataDemo
{
	public static void main ( String[] args)
	{
		int gr1 = 98;
		int gr2 = 100;
		int gr3 = 98;

		int sum = gr1 + gr2 + gr3;
		int avg = sum / 3;
		double avgd = sum / 3.0;

		System.out.println( avg );
		System.out.println( avgd);

		boolean x = true;
		x = false;

		x = avg > 100;
		System.out.println( x );

	}
}