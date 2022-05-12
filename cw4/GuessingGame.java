import java.util.Scanner;
public class GuessingGame
{
	public static void main(String[] args )
	{
		Target t = new Target();
		t.setUp(0, 10);
		Scanner in = new Scanner( System.in );
		playGame( in, t);
	}

	public static void playGame(Scanner in, Target t )
	{
		System.out.println( "Pick a number. ");
		int guess = in.nextInt();
		if (t.tooHigh( guess) )
		{
			System.out.println( "Too High" );
			playGame( in, t);
		}
		if ( t.tooLow( guess) )
		{
			System.out.println( "Too Low" );
			playGame( in, t);
		}
		if ( t.Equal( guess) )
		{
			System.out.println( "Right" );
		}
	}
}