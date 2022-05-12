public class Board
{
  public static void main( String[] args )
  {
    Board b = new Board(10, 10, 10);
    if (b.width != 10 ) 
			System.out.println("Problem with width");

		if (b.height != 10 ) 
			System.out.println("Problem with height");

		if (b.bombs.length() != 100 ) 
			System.out.println("Problem with bombs initializer");
  }
  public static final String EMPTY = "0";
  public static final String BOMB = "9";
	public static final String GUESSED = "1";
	public static final String NOT_GUESSED = "0";

	private String bombs;
  private String guessed;
	private int width;
	private int height;
	private int bombCount;
	

  public Board( int w, int h, int b )
	{
		this.width = w;
		this.height = h;
		this.bombCount = b;
		this.bombs = "";
		this.guessed = "";
		initializeBoard();
    placeBombs();
    calculateHints();
	}
  
	public int convertIndexToRow(int idx)
	{
		int row = idx / this.width;
		return row;
	}
  public int convertIndexToColumn( int idx )
  {
    int col = idx % this.width;
    return col;
  }
  public int convertRowColumnToIndex( int row, int col )
  {
		int idx = row * this.width + col;
    return idx;
  }
  public void setSpot(int row, int col, String symbol)
	{
		int idx;
		idx = convertRowColumnToIndex(row, col);
    String before = this.bombs.substring( 0, idx );
    String after = this.bombs.substring( idx + 1, this.bombs.length() );
    this.bombs = before + symbol + after; 
	}
	public String getSpot( int row, int col )
	{
    int idx;
    idx = convertRowColumnToIndex(row, col);
    String value = this.bombs.substring( idx, idx+1);
		return value;
	}
	public void setGuessed( int row, int col, String symbol)
	{
		int idx;
		idx = convertRowColumnToIndex(row, col);
    String before = this.guessed.substring( 0, idx );
    String after = this.guessed.substring( idx + 1, this.guessed.length() );
    this.guessed = before + GUESSED + after;
	}
	public boolean getGuessed(int row, int col )
	{
		int idx;
    idx = convertRowColumnToIndex(row, col);
    String spark = this.guessed.substring( idx, idx+1);
    if ( spark.equals(GUESSED) )
    {
      return true;
    }
		return false;
	}
	public String reveal( int row, int col )
	{
		setGuessed( row, col, GUESSED );
		getSpot( row, col);
		return getSpot( row, col);
	}
	public boolean isLegalSpot( int row, int col)
	{
		if ( row < 0)
		{
			return false;
		}
		else if ( col < 0)
		{
			return false;
		}
		else if ( row >= this.height)
		{
			return false;
		}
		else if ( col >= this.width)
		{
			return false;
		}
		return true;
	}
	public int countBombSurrounding( int row, int col)
	{
		int count = 0;
    for ( int r = -1; r < 2; r++ )
    {
      for ( int c = -1; c < 2; c++ )
      {
        int rr = row + r;
        int cc = col + c;
        if ( !isLegalSpot( rr, cc) )
        {
          continue;
        }
        if ( getSpot( rr, cc ).equals(Board.BOMB) )
        {
          count++;
        }
      }
    }
    return count;
	}
	public void calculateHints()
	{
		int counter = 0;
    while ( counter < this.width * this.height )
    {
      int row = convertIndexToRow(counter);
      int col = convertIndexToColumn(counter);
      String v = getSpot(row, col);
			if( !BOMB.equals(v) )
      {
        int cb = countBombSurrounding( row, col);
        setSpot( row, col, String.valueOf(cb) );
			}
			counter++;
    }
	}
	public void placeBombs()
	{
		int counter = 0;
    while ( counter < this.bombCount )
    {
      int row = -1;
      int col = -1;
      while ( row < 0 || getSpot(row, col).equals(BOMB) )
      {
        row = (int)(Math.random() * this.height);
				col = (int)(Math.random() * this.width);
    	}
      setSpot( row, col, BOMB );
			counter++;
    }
  }
	public void initializeBoard()
	{
		int totalCells = this.width * this.height;
		int count = 0;
    while ( count < totalCells )
    {
      this.bombs = this.bombs + Board.EMPTY;
      count++;
			this.guessed += Board.NOT_GUESSED;
    }
	}
}