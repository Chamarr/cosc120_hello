import java.util.Scanner;
public class Lecture
{
	public static void main( String[] args)
	{
		Scanner in = new Scanner( System.in );
		System.out.println("Enter a number");
		int x = in.nextInt();
		if ( x != 10 )
		{
			System.out.println( "nice number");
		}
		else
		{
			System.out.println( "horrible mumber");
		}
		/*
		boolean x = true;

		if ( x )
		{
			System.out.println( "X is true");
		}
		
		/*
		String x = "abcdefg";
		String y = x.substring( 2, 5);
		System.out.println(y);
		System.out.println( x.length() );
		*/
	}
}