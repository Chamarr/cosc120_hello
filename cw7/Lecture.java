public class Lecture
	{
		public static void main( String[] args )
		{
			// Is it a palindrome
			boolean itIs = isPalindrome ("racecar");
			System.out.println( itIs );
		}
		public static boolean isPalindrome( String x )
		{
			boolean isPal = true;
			int letter = 0;

			while ( letter < x.length() / 2)
				{
					String first = x.substring( letter, letter + 1 );
					String last = x.substring( x.length() - 1 - letter, x.length() - letter );
				
			
					if ( !first.equals(last) )
					{
						isPal = false;
					}
					letter++;
				}
			return isPal;
		}
	}