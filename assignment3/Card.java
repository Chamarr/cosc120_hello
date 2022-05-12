public class Card
{
	private String side1;
	private String side2;

	public void setCard(String a, String b)
	{
		this.side1 = a;
		this.side2 = b;
	}
	public String getSideA()
	{
		return this.side1;
	}
	public String getSideB()
	{
		return this.side2;
	}
}