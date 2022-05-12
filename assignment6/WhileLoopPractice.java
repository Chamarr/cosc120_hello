public class WhileLoopPractice 
{
  public static void main( String[] args )
  {
    // Should print 5, 6, 7, 8, 9, and 10 on separate lines
    printIntegersBetween(5, 10); 
    // Should print 1, 2, 3, 5, 6, 10, 15, 30
    printFactors( 30 );
    // Should return 9
    System.out.println( calculateSum( 315 ) );
    // Should return aaabbbccc
    System.out.println( multiplyLetters( "abc", 3 ));
    // Should return ea 
    System.out.println( findVowels( "beta" ) );
  }
  /**
  * Print numbers between n1 and n2 inclusive.
  * @param n1 first or last number within range of numbers
  * @param n2 first or last number within range of numbers
  */
  public static void printIntegersBetween( int n1, int n2 )
  {
 		int min = n1;
		int max = n2;
		if ( n1 > n2)
		{
			min = n2;
			max = n1;
		}
		int count = min;
		while ( count <= max)
			{
				System.out.println( count );
				count++;
			}
  }
  /**
  * Print factors (numbers that evenly divide) of n. 
  * The modulus operator (%) might be handy here. If you take
  * the modulus of n and x (where x is the value you're testing),
  * if the result is 0 (no remainder) then x divides n evenly
  * (x is a factor of n). Otherwise x is not a factor of n.
  * @param n Number for which factors should be printed
  */
	public static void printFactors( int n )
  {
    int value = n;
		while ( value <= n)
			{
				if ( n % value != 0)
				{
					value++;
				}
				else 
				{
					System.out.println( value );
					value++;
				}
			}
  }
  /**
  * Calculate the sum of the digits in n.
  * @param n Number whose digits should be summed
  * @return The sum of the digits in n
  */
  public static int calculateSum( int n )
  {
    int sum = 0;
		
		while ( n > 0)
			{
				sum += n % 10;
				n /= 10;
			}
    return sum;
  }
  /**
  * Create a String in which each letter in word is repeated n times.
  * @param word String whose letters should be expanded
  * @param n Number of times each letter should be repeated
  * @return "Multiplied" String
  */
  public static String multiplyLetters( String word, int n )
  {
		int letterIndex = 0;
    String result = "";
		
		while ( letterIndex < word.length())
			{
				String letter = word.substring(letterIndex, letterIndex + 1);
				int count = n;
				while ( count > 0)
					{
						count--;
						result += letter;
					}
				letterIndex++;
			}
    return result;
  }

  /**
  * Identify all the vowels in word.
  * @param word String whose vowels should be identified
  * @return String of vowels found in word
  */
  public static String findVowels( String word )
  {
		String target = "aeiou";
    String vowels = "";
		for (int i = 0; i < word.length();i++ )
			{
				String letter = word.substring( i, i+1);
				if (target.contains(letter))
				{
					vowels += letter;
				}
			}
    return vowels;
  }
}