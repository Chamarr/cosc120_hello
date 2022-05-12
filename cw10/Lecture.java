public class Lecture
{
	public static int x = 5;
	public int y = 10;
	public void printY()
	{
		System.out.println( this.y );
	}
	public static void main ( String[] args )
	{
		System.out.println("I am here");
		Lecture a = new Lecture();
		Lecture b = new Lecture();
		Lecture.x = 20;
		System.out.println( Lecture.x );
		System.out.println( a.x );
		System.out.println(  b.x );
	}
	static
	{
		System.out.println( "Lecture.x is" + Lecture.x);
	}
	{
		System.out.println( "I am declaring instance data");
	}
}