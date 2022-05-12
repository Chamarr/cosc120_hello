import java.util.Scanner;
public class TestSubCipher
{
  // ONE_OR_TWO is a constant value (code can't change it).
  // It represents a "regular expression," which is a way
  // of describing a pattern that a String must conform to.
  // You don't need to know regular expressions for this
  // class, but the gist of the pattern here is that only 
  // Strings consisting of a single 1 or a single 2 will match.
  // Google regex for more... regular expressions are 
  // very powerful tools!
  private static final String ONE_OR_TWO = "^[12]$";
  public static void main( String[] args )
  {
    // Initialize local variables
    Scanner in = new Scanner( System.in );
    SubstitutionCipher cipher = new SubstitutionCipher();
    
    // Prompt user for key and set it in the cipher object
    TestSubCipher.setKey( in, cipher );
    
    // Prompt user for message and set it in the cipher object
    System.out.println( "Enter your message." );
    String message = in.nextLine().trim();
    cipher.setMessage( message );

    // Prompt user for choice (encrypt or decrypt)
    int choice = TestSubCipher.getChoice(in);

    // Perform appropriate action
    String result = "";
    if ( choice == 1 )
    {
      result = cipher.encrypt();
    }
    else if ( choice == 2 )
    {
      result = cipher.decrypt();
    }

    // display result
    System.out.println( result );
  }
  public static int getChoice( Scanner in )
  {
    // Assume choice is an illegal value
    String choice = "x";
    // While choice does not match a 1 or a 2
    while ( !choice.matches( TestSubCipher.ONE_OR_TWO ) )
    {
      // Prompt user for valid choice
      System.out.println( "Enter 1 to encrypt or 2 to decrypt." );
      choice = in.nextLine().trim();
    }
    // The only way out of the above loop is for the user
    // to enter a 1 or a 2, so at this point I know I can
    // convert whatever their choice is to an integer.
    return Integer.parseInt( choice );
  }
  public static void setKey( Scanner in, SubstitutionCipher cipher )
  {
    // Assume an empty (illegal) key
    String key = "";
    // Get the required key length and generate the 
    // prompt for the user. (String.format() simplifies
    // combining String literals with variables; it is
    // beyond the scope of this class, but google it if 
    // you're interested ... it can make code more readable.)
    int requiredLength = cipher.getKeyLength();
    String msg = String.format("Enter a %d-letter key or enter.", requiredLength);
    // As long as the key is too short, keep prompting the 
    // user for a valid key
    while ( key.length() < requiredLength )
    {
      System.out.println( msg );
      key = in.nextLine().trim();
      // If the user enters no key at all, generate a key
      if ( key.length() == 0 )
      {
        key = cipher.generateKey() ;
        System.out.println( "Your key is " + key );
      }
    }
    // Set the cipher's key
    cipher.setKey(key);
  }
}