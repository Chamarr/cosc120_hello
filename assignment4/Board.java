public class Board
{
  /* DO NOT EDIT THESE INSTANCE (OBJECT) VARIABLES */
  private String board = "0 1 2 " +
                         "3 4 5 " + 
                         "6 7 8 " ;
  private String occupied = "---" + 
                            "---" +
                            "---" ;
  
  /* DO NOT MODIFY THE getWinner() METHOD */
  public String getWinner()
  {
    String winner = allTheSame( 0, 1 ) ; // Row 1
    if ( !isPlayer( winner ) )
    {
      winner = allTheSame( 3, 1 ) ; // Row 2
    }
    if ( !isPlayer( winner ) )
    {
      winner = allTheSame( 6, 1 ) ; // Row 3
    }
    if ( !isPlayer( winner ) )
    {
      winner = allTheSame( 0, 3 ) ; // Col 1
    }
    if ( !isPlayer( winner ) )
    {
      winner = allTheSame( 1, 3 ) ; // Col 2
    }
    if ( !isPlayer( winner ) )
    {
      winner = allTheSame( 2, 3 ) ; // Col 3
    }
    if ( !isPlayer( winner ) )
    {
      winner = allTheSame( 0, 4 ) ; // Left-to-right diag
    }
    if ( !isPlayer( winner ) )
    {
      winner = allTheSame( 2, 2 ) ; // Right-to-left diag
    }
    return winner;
  }

  public boolean spotIsFree(int spot)
  {
    // TODO 1: Update this method to make sure only 
    // legal values for the parameter (spot) are passed. 
    // Legal values are integers between 0 and 8 (inclusive). 
    // If spot is NOT a legal value, return false, otherwise 
    // proceed with the algorithm.

    /* Put your implementation here */
		if (spot < 0 || spot > 8)
		{
			return false;
		}


    String symbol = this.occupied.substring( spot, spot + 1 );
    boolean isFree = false;

    // TODO 2: If the local variable (symbol) is a minus sign (-),
    // the spot is free; any other symbol means it is occupied.
    // If symbol is a -, set the local variable (isFree) to true; otherwise 
    // set the local variable (isFree) to false.
    // Remember, when comparing the values of objects (such as String),
    // use the .equals(String) method, not the == operator.

    /* Put your implementation here */
		if (symbol.equals("-"))
		{
			isFree = true;
		}
		else
		{
			isFree = false;
		}
    return isFree;

    // TEST: To test this method, in jshell you should:
    // 1. open Board.java (/open Board.java)
    // 2. Create an object from the Board class 
    //    Board b = new Board()
    // 3. call this method with illegal parameters and 
    //    confirm you get false (not errors)
    //    ie b.spotIsFree(-1); should return false
    //       b.spotIsFree(9); should return false
    // 4. call this method with a legal parameter; 
    //.   ie b.spotIsFree(5); you should get true
    // 5. set the spot you just tested to a symbol
    //    ie b.setSpot("X", 5); 
    // 6. call this method with the spot you're testing
    //    ie b.spotIsFree(5); you should get false
  }

  public boolean setSpot( String symbol, int spot )
  {
    // TODO 4: If the parameter (spot) is NOT free, return false.
    // HINT: Use the spotIsFree(int) method completed earlier

    /* Put your implementation here */

	if ( ! spotIsFree(spot))
	{
		return false;
	}

    String before = this.board.substring( 0, spot*2 );
    String after = this.board.substring( spot*2 + 1, this.board.length() );
    this.board = before + symbol + after;

    before = this.occupied.substring( 0, spot );
    after = this.occupied.substring( spot + 1, this.occupied.length() );
    this.occupied = before + symbol + after;

    return true;

    // TEST: To test this method, in jshell you should:
    // 1. open Board.java (/open Board.java)
    // 2. Create an object from the Board class 
    //    (Board b = new Board())
    // 3. call this method with illegal parameters and 
    //    confirm you get false (not errors)
    //    ie b.setSpot("X",-1); should return false
    //       b.setSpot("X",9); should return false
    // 4. call this method with a legal parameter; 
    //    ie b.setSpot("X",5); you should get true
    // 6. Look at the board and confirm 5 is replaced with X
    //    ie b.getBoard()
  }

  public boolean isFull()
  {
    boolean isFull = false;
    // TODO 5: Use the contains(String) method to determine
    // if the instance variable (this.occupied) has any open spaces
    // remaining. An open space is denoted as a minus sign (-).
    // Ie, Consider a String called foo with the value "hello"
    //     foo.contains("a") returns false
    //     foo.contains("e") returns true
    // Set the local variable (isFull) to true if the instance
    // variable (this.occupied) contains no minus signs (-)

    /* Put your implementation here */
		if (!this.occupied.contains("-"))
		{
			isFull = true;
		}

    return isFull;

    // TEST: To test this method, in jshell you should:
    // 1. open Board.java (/open Board.java)
    // 2. create an object from the Board class
    //    Board b = new Board();
    // 3. Confirm the board is NOT full
    //    b.isFull()
    //    Should return false
    // 4. Set all spaces on the board
    //    b.setSpot("X",0)
    //    b.setSpot("X",1)
    //    b.setSpot("X",2)
    //    ... and so on up to
    //    b.setSpot("X",8)
    // 5. Confirm the board IS full
    //    b.isFull()
    //    Should return true
  }

  public String allTheSame( int startAt, int countBy )
  {
    int sq1 = startAt;
    int sq2 = startAt + countBy;
    int sq3 = startAt + countBy * 2;
    String first = this.occupied.substring(sq1, sq1 + 1);
    String second = this.occupied.substring(sq2, sq2 + 1);
    String third = this.occupied.substring(sq3, sq3 + 1);
    String same = "-";

    // TODO 6: If first, second, and third are the same, set
    // the local variable (same) to their value; otherwise set it 
    // to a minus sign (-). 
    // Remember, to compare the values of objects  (such as Strings),  
    // use the .equals(String) method,  not the == operator.

    /* Put your implementation here. */
		if (first.equals(second) && second.equals(third))
		{
			same = first;
		}
		else
		{
			same = "-";
		}

    return same;
    // TEST: To test this method, in jshell you should:
    // 1. open Board.java (/open Board.java)
    // 2. create an object from the Board class
    //    Board b = new Board();
    // 3. Confirm method returns - for first row
    //    b.allTheSame(0, 1)
    //    should return -
    // 4. Set first row to all Xs
    //    b.setSpot("X",0)
    //    b.setSpot("X",1)
    //    b.setSpot("X",2)
    // 5. Confirm that method returns X for first row
    //    b.allTheSame(0, 1)
    //    should return X
  }

  public boolean isPlayer( String letter )
  {
    boolean isPlayer = false;
    // TODO 7: If parameter (letter) is an X or an O, set
    // the value of the local variable (isPlayer) to true;
    // Otherwise, set it to false.

    /* Put your implementation here. */
		if (letter.equals("X") || letter.equals("O"))
		{
			isPlayer = true;
		}
		else
		{
			isPlayer = false;
		}

    return isPlayer;
    // TEST: To test this method, in jshell you should:
    // 1. open Board.java (/open Board.java)
    // 2. create an object from the Board class
    //    Board b = new Board();
    // 3. Query the board to see if X is a legitimate player
    //    b.isPlayer("X")
    //    should return true
    // 4. Query the board to see if O is a legitimate player
    //    b.isPlayer("O")
    //    should return true
    // 5. Query the board to see if A is a legitimate player
    //    b.isPlayer("A")
    //    should return false
  }

  public String getBoard()
  {
    return this.board.substring( 0, 6 ) + "\n" +
           this.board.substring( 6, 12 ) + "\n" + 
           this.board.substring( 12, 18 ) ;
  }
}