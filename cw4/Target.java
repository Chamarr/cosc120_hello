public class Target
{
	private int target;
	private int min;
	private int max;

	public void setUp( int min, int max )
	{
		this.min = min;
		this.max = max;
		int scale = max - min;
		this.target = (int)(Math.random() * scale + min);
	}
	public boolean tooHigh(int guess)
	{
		boolean value;
		if ( guess > target)
		{
			value = true;
		}
		else
		{
			value = false;
		}
		return value;
	}
	public boolean tooLow(int guess)
	{
		boolean value;
		if ( guess < target)
		{
			value = true;
		}
		else
		{
			value = false;
		}
		return value;
	}
	public boolean Equal(int guess)
		{
			boolean value;
			if ( guess == this.target )
			{
				value = true;
			}
			else
			{
				value = false;
			}
			return value;
		}

	public void dump()
	{
		System.out.println(target);
	}
}