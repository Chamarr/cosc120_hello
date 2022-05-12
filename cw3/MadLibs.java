import java.util.Scanner;
public class MadLibs
{
	public static void main(String[] args)
	{
		Phrase one = new Phrase();
		one.set("Mary had a little ", ", ", "animal");
		Phrase two = new Phrase();
		two.set("whose fleece was ", " as snow.", "color");

		Scanner keyboard = new Scanner( System.in );
		System.out.println(one.getPrompt() );
		String response = keyboard.nextLine();
		one.setWord( response );

		System.out.println( two.getPrompt() );
		response = keyboard.nextLine();
		two.setWord( response );


		String story = one.getPhrase() + two.getPhrase();

		System.out.println( story );
	}
}