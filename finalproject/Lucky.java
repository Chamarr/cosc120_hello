/* Authors:
Chamarr Auber
Camden Butler
*/

//Lucky class
public class Lucky
{
    private int money;
    private String name;
    //Accessors and Mutators
	// The accessor getName will return the name that the user has inputted as their name
    public String getname()
		{
        return name;
    }
   // The mutator setName will put in place the name that it was given
    public void setname(String n)
		{
        name = n;
    }
	// isWinner checks if the players money is equal to or greater than 20000
	public boolean isWinner()
	{
		return this.money >=20000;
	}
	// Other method not including accessors and mutators
   public Lucky()
		{
       money = -1;
   	}
   // The accessor getMoney will retrieve the the money that its mutator has set
   public int getmoney()
		{
       return money;
   	}
   // The mutator setMoney saves the amount of money that the user has
   public void setmoney(int m)
		{
       money = m;
   	}
   // Other method not including accessors and mutators that will check use the getMoney class to check your money and respond accordingly
   public String toString()
		{
			//If statement that checks if the user has over $20000 and responds accordingly
       if(money >= 20000)
			 {
            return "Congtratulations " + name + " looks like you were lucky enough! You're going home with $ " + getmoney() + "!";
        }
        else 
			 	{
            return "Sorry " + name + " looks like you weren't lucky enough this time, try again!";
        }
   }
}