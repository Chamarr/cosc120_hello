public class SubstitutionCipher 
{
  // Initialize instance data to hold the user's message,
  // and the encryption and decryption keys.
  private String message = "";
  private String encryptKey = "abcdefghijklmnopqrstuvwxyz";
  private String decryptKey = "abcdefghijklmnopqrstuvwxyz";
  
  // Store the passed parameter into the instance data
  public void setMessage( String message )
  {
    this.message = message;
  }

  // Store the passed parameter into the instance data.
  // Note the use of "throwing" exceptions ... there's 
  // no way to handle the situation of receiving an 
  // inappropriate key, so if that happens the method
  // will violently protect. Exceptions are beyond the
  // scope of this class, but worth looking into independently
  // if you're interested in going further in Java.
  public void setKey( String key )
  {
    if ( key.length() < this.encryptKey.length() )
    {
      throw new RuntimeException("Key is too short!");
    }
    this.encryptKey = key.toLowerCase();
  }
  // Accessor method to return the key's length. Note that
  // accessors can "generate" their value from other instance
  // data ... they don't necessarily have to just echo back
  // the value of instance data.
  public int getKeyLength()
  {
    return this.encryptKey.length();
  }
  // Generate a random key by swapping each letter in the 
  // default encryption key with a random letter.
  public String generateKey()
  {
    String key = this.encryptKey;
    int keyLength = key.length();
    // TODO 1: Write a loop that will go through each letter
    // in the local variable (key).  To do this: 
    // First declare and initialize a loop control variable. 
    // In this case, your loop control variable will point to
    // each letter, one at a time, until it gets to the last letter.
    // It should be initialized to 0.

    /* Declare and initialize your loop control variable here. */
				int letterCount = 0;
				
    // Next, write a while statement with a boolean expression that
    // evaluates to true as long as your loop control variable
    // is less than the length of the key (local variable keyLength)

    /* Put your while statement here. Remember, DO NOT put a semicolon after it */
    	while ( letterCount < keyLength)
    // Within the curly braces below, write a loop body that does two things:
    // First, it changes the value of key to the value returned 
    // by calling the shuffle method. You will have to look at the class diagram
    // or look at the method header below to determine how to use the
    // shuffle method.
    // Second, add one to your loop control variable (so that
    // the next time through the loop, you will be looking at the 
    // next letter in the key).
    { 
      /* Put your loop body here. */
			key = shuffle (key, letterCount);
			letterCount ++;
    }
    this.encryptKey = key;
    return key;
  }
  public String shuffle( String word, int idx )
  {
    // Store the letter that is about to be swapped.
    String originalLetter = word.substring( idx, idx+1 );
    // Pick a random position in the word and grab the letter there
    int swapIdx = (int)(Math.random() * word.length());
    String swapLetter = word.substring( swapIdx, swapIdx + 1 );
    // Insert the random letter where the original was
    word = word.substring( 0, idx ) + swapLetter + word.substring(idx + 1);
    // Insert the original letter where the random one was
    word = word.substring( 0, swapIdx ) + originalLetter + word.substring(swapIdx + 1);
    // Return the result
    return word;
  }
  public String encrypt()
  {
    return swapLettersInStrings( this.encryptKey, this.decryptKey );
  }
  public String decrypt()
  {
    return swapLettersInStrings( this.decryptKey, this.encryptKey );
  }
  private String swapLettersInStrings( String a, String b )
  {
    int messageLength = this.message.length();
    String code = "";
    // Initialize loop control variable (idx) to 0
    int idx = 0;
    // Create a while statement whose boolean expression will be true
    // as long as the loop control variable is less than the messageLength
    while ( idx < messageLength )
    {
      // Identify where in String a the current letter appears
      String letter = this.message.substring( idx, idx + 1 );
      letter = letter.toLowerCase();
      int location = a.indexOf( letter );
      // If the letter is not in String a, it's probably 
      // punctuation or a number ... just put it onto the coded message
      if ( location == -1 )
      {
        code = code + letter;
      }
      // Otherwise, find the letter in the same position
      // in String b and put that letter onto the coded word.
      else
      {
        String newLetter = b.substring( location, location + 1 );
        code = code + newLetter;
      }
      // Change the loop control variable by 1 so that we eventually finish!
      idx = idx + 1;
    }
    // Return resulting code
    return code;
  }
}
