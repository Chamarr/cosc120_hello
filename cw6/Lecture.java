import java.util.Scanner;
public class Lecture
{
	public static void main( String[] args )
	{
		String x = "abc";
		String z = "";

		int length = x.length();
		int count = 0;
		while ( count < x.length() )
		{
		z = z + x.substring( length - 1 - count, length - count );
		count = count + 1;
		}

		System.out.println( z );
	}
	public static void demo()
	{
		Scanner keyboard = new Scanner( System.in );
		System.out.println( "Enter a number between 1 and 10 (inclusive)");
		int n = keyboard.nextInt();
		while ( n < 1 || n > 10)
		{
			System.out.println( "Enter a number between 1 and 10 (inclusive)");
			n = keyboard.nextInt();
		}
		//print the numbers from 1 to 10 inclusive
		int a = 1;
		while( a <= 10)
		{
			System.out.println( a );
			a = a + 1;
		}
		//print the numbers from 15 to 5 inclusive
		int b = 15;
		while ( b >= 5 )
		{
			System.out.println( b );
			b = b - 1;
		}
		//print odd nummbers between -10 and 10
		int c = -10;
		while ( c <= 10)
		{
			if ( c % 2 == 1 || c % 2 == -1)
			{
				System.out.println( c );
			}
			c = c + 1;
		}
	}
}