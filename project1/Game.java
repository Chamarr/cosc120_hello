import java.util.Scanner;
public class Game
{
  private Scanner in;
	private Board board;
	private int spotsRemaining;
	private boolean guessedBomb;
	private int width;
	private int height;
  private int bombs;

	public static void main( String[] args )
	{
	  Game minesweeper = new Game(10, 10, 10);
    minesweeper.gameLoop();
    if ( minesweeper.gameWon() )
    {
      System.out.println( "You Won" );
    }
		else
		{
			System.out.println( "You Lose!" );
		}
	}
	public Game ( int width, int height, int bombs )
	{
		this.width = width;
		this.height = height;
		this.bombs = bombs;
		this.in = new Scanner( System.in );
		this.board = new Board(width, height, bombs);
		this.guessedBomb = false;
		this.spotsRemaining = (width * height) - bombs;
	}

	public void gameLoop()
	{
	 while ( this.guessedBomb == false || gameWon() == false)
	 {
	  	displayBoard();
		  takeTurn();
	 }
	}

	public void takeTurn()
	{
		int row = getIntBetween("row", 1, this.height);
		int col = getIntBetween("column", 1, this.width);
		if ( !this.board.getGuessed(row, col))
		{
			String n = this.board.reveal( row, col);
		  if ( n.equals(Board.BOMB))
		  {
				this.guessedBomb = true;
			}
			else
			{
			this.spotsRemaining--;
			}
    }
	}

	public void displayBoard()
	{
	  String out = "";
    for ( int row = 0; row < this.height; row++ )
    {
      for ( int col = 0; col < this.width; col++ ) 
      {
        if ( this.board.getGuessed( row, col) )
        {
          String spot = this.board.getSpot( row, col );
          out += spot;
        }
        else
        {
          out += "-";
        }
      }
      out += "\n";
    }
		System.out.println( out );
	}

	public boolean gameWon()
	{
		if (this.spotsRemaining == 0)
		{
			return true;
		}
		return false;
	}

	public int getIntBetween(String prompt, int min, int max)
	{
		System.out.println("Pick a "+prompt+" between "+ min +"and" + max + "inclusive");
		int n = min - 1;
		while ( n < min || n > max)
		{
		  n = in.nextInt();
		}
		return n;	
	}
}