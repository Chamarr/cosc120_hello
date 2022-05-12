public class Phrase
{
	private String prefix;
	private String suffix;
	private String word;
	private String partOfSpeech;

	public void set(String a, String b, String c)
	{
		this.prefix = a;
		this.suffix = b;
		this.partOfSpeech = c;
	}
	public void setWord( String a )
	{
		this.word = a;
	}
	public String getPrompt()
	{
		String value = "Enter a " + this.partOfSpeech;
		return value;
	}
	public String getPhrase()
	{
		return this.prefix + this.word + this.suffix;
	}
}