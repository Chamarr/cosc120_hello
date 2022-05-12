public class Lecture
{
	public static void main ( String[] args )
	{
		printIntegersBetween(5, 10);
	}
	public static void printIntegersBetween( int n1, int n2)
	{
		int min = n1;
		int max = n2;
		if ( n1 > n2)
		{
			min = n2;
			max = n1;
		}
		int count = min;
		while ( count <= max)
			{
				System.out.println( count );
				count++;
			}
		System.out.println ( count );
		int i;
		for ( i = min; i <= max; i++)
			{
				System.out.println( i );
			}
		System.out.println( i );
	}
}