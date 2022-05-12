
/* Authors:
Chamarr Auber
Camden Butler
*/
//To run the game, run it as 'java MakeItOrBreakIt'

import java.util.Scanner;
import java.util.Random; //(String Manipulation)

//Class DealOrNoDeal

public class MakeItOrBreakIt
{
    public static void main(String args[]){
        //Random number generator which sets a random value to each case and Scanner input which allows the user to interact with the interface
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        // These instructions explain the rules of the game to its users 
        System.out.println("Hi! Welcome to the game Make it or Break it!");
        System.out.println("In case you don't know how to play, here's some information about the game:");
        System.out.println("1. 20 numbers will be displayed and each number will either have a value of money to give you, or will give you a Game Over which ends the game");
        System.out.println("2. 5 of the numbers contain a Game Over, but as long as you don't pick one of them you will get to keep picking numbers");
        System.out.println("3. Your goal is to pick the right numbers and accumulate $20,000 or more to win the game");
        System.out.println("4. If you don't get $20,000 or if you get a Game Over, you lose");
        System.out.println("Before we start, what is your name?");
      // stores player name for game to come
        String name = scan.next();
        
        System.out.println("Alright " + name +", the closest someone has come to winning was $19,000, let's see if you are the luck winner, goodluck!");
        // starting value of cash for the user, int data type
        int money = 0;

        //Lucky class (defined in lucky.java)
        Lucky l = new Lucky(); 
        l.setmoney(money);
        l.setname(name);
       
        System.out.println("Pick a number 1-20");
        System.out.println("Keep track of what numbers you picked to make sure you don't guess the same one twice");       
        String gameOverNum = "";
        int guess = scan.nextInt();
			
        //While loop that keeps going until the game is over
        while(money <= 20000 && !gameOverNum.equals("Game Over")){
        
        int numResult = 0;
        
        //Switch Cases that represent 20 brief cases in Deal or No Deal with money values in each one

        switch (guess){
            case 1: numResult = rand.nextInt(9) + 1;
                money += numResult;
                break;
            case 2: numResult = rand.nextInt(90) + 10;
                money += numResult;
                break;
            case 4: numResult = rand.nextInt(400) + 100;
                money += numResult;
                break;
            case 5: numResult = rand.nextInt(500) + 500;
                money += numResult;
                break;
            case 6: numResult = rand.nextInt(4000) + 1000;
                money += numResult;
                break;
            case 8: numResult = rand.nextInt(9) + 1;
                money += numResult;
                break;
            case 9: numResult = rand.nextInt(90) + 10;
                money += numResult;
                break;
            case 11: numResult = rand.nextInt(400) + 100;
                money += numResult;
                break;
            case 12: numResult = rand.nextInt(500) + 500;
                money += numResult;
                break;
            case 13: numResult = rand.nextInt(400) + 100;
                money += numResult;
                break;
            case 14: numResult = rand.nextInt(500) + 500;
                money += numResult;
                break;
            case 16: numResult = rand.nextInt(4000) + 1000;
                money += numResult;
                break;
            case 17: numResult = rand.nextInt(5000) + 5000;
                money += numResult;
                break;
            case 18: numResult = rand.nextInt(500) + 500;
                money += numResult;
                break;
            case 19: numResult = rand.nextInt(5000) + 5000;
                money += numResult;
                break;
            // The numbers that are not listed above in the switch statement are cases that automatically give the user a Game Over. They have no value
            default: gameOverNum = "Game Over";
                
                
        }
          // this if statement shows the 5 cases that if selected will end the game 
        if(guess == 3 || guess == 7 || guess == 10 || guess == 15 || guess == 20){
        System.out.println("Game Over");
        }
          // this if statement says that if a case that is not one of the  bad ones is selected the game will continue until the player either wins or loses 
        if(guess!= 3 && guess!= 7 && guess!= 10 && guess!= 15 && guess!= 20){
            l.setmoney(money);
          // this prints the amount of $ won and adds it to prevoius winnings
        System.out.println("Congratulations, that number got you $" + numResult);
          // This if statement asks if the player has earned $20000 or more in winnings. If they they have, in Lucky.java congrats in printed to the winner
        if(l.isWinner()){
            System.out.println("Wait...");
        } else {
            System.out.println("You've earned $" + l.getmoney() + " so far, Pick another number");
            guess = scan.nextInt();
        }
        
        }
        
    }
    System.out.println(l.toString());
}
}