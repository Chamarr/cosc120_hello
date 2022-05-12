public class Fraction
	{
		public static int gcf(int x, int y)
		{
			int min = x;
			int max = y;
			if ( x > y)
			{
				min = y;
				max = x;
			}
			while ( y != 0)
				{
					int temp = max;
					max = min;
					min = temp % min;
				}
			return x;
		}
	}