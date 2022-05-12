import java.util.Scanner;
public class Game
{
  public static void main( String[] args )
  {
    Board b = new Board();
    Scanner in = new Scanner( System.in );
    takeTurn( in, b, "X" );
  }

  public static void takeTurn( Scanner in, Board b, String player )
  {
    String winner = b.getWinner();
    if ( b.isPlayer( winner ) || b.isFull() )
    {
      gameOver(b);
    }
    else
    {
      System.out.println( b.getBoard() );
      System.out.println( "Player " + player + ", choose a square." );
      int choice = in.nextInt();
      boolean ok = b.setSpot( player, choice );
      if ( !ok )
      {
        takeTurn( in, b, player );
      }
      nextTurn( in, b, player );
    }
  }

  public static void nextTurn( Scanner in, Board b, String player )
  {
    if ( player.equals( "X" ) )
    {
      takeTurn( in, b, "O" );
    }
    else
    {
      takeTurn( in, b, "X" );
    }
  }
  public static void gameOver( Board b )
  {
    System.out.println( b.getBoard() );
    String winner = b.getWinner();
    System.out.println( "The winner is " + winner );
  }
}