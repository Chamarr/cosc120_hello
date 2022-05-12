public class TestCard
{
	public static void main(String[] args )
	{
		Card c1 = new Card();
		c1.setCard("Alpha", "Beta");
		System.out.println(c1.getSideA() );
		System.out.println(c1.getSideB() );
	}
}