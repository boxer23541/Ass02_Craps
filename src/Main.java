import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);
        int die1;
        int die2;
        int roll;
        int point;
        boolean playAgain = false;
        boolean reroll = false;

        do
        {
            System.out.println("New Game: Craps");
            System.out.println("Rolling...");
            die1 = rnd.nextInt(6) + 1;
            die2 = rnd.nextInt(6) + 1;
            roll = die1 + die2;

            System.out.println("Die 1: " + die1 + "\nDie 2: " + die2);

            switch (roll)
            {
                case 2: case 3: case 12:
                    System.out.println("You rolled " + roll + ". You crapped out and lose!");
                break;
                case 7: case 11:
                    System.out.println("You rolled " + roll + ". You got a natural and win!");
                break;
                default:
                    point = roll;
                    System.out.println("You rolled " + roll + ". The point is now " + point + ".");

                    do
                    {
                        System.out.println("Rerolling...");
                        die1 = rnd.nextInt(6) + 1;
                        die2 = rnd.nextInt(6) + 1;
                        roll = die1 + die2;
                        System.out.println("Die 1: " + die1 + "\nDie 2: " + die2);
                        if (roll == 7)
                        {
                            System.out.println("You rolled 7. You lose!");
                            reroll = false;
                        } else if (roll == point)
                        {
                            System.out.println("You rolled " + roll + ". The point was " + point + ". You win!");
                            reroll = false;
                        }
                        else
                        {
                            System.out.println("You rolled " + roll + ". Trying again:");
                            reroll = true;
                        }
                    }while (reroll);
            }
            playAgain = getYNConfirm(in, "Would you like to play again? [Y/N]: ");
        }while(playAgain);
    }
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        boolean retYN = false;
        boolean validInput = false;
        String response;

        do
        {
            System.out.print("\n" + prompt);
            response = pipe.nextLine();
            if(response.equalsIgnoreCase("Y"))
            {
                retYN = true;
                validInput = true;
            }
            else if(response.equalsIgnoreCase("N"))
            {
                retYN = false;
                validInput = true;
            }
            else
            {
                System.out.println("Invalid Input. Enter [Y/N]");
            }
        }while(!validInput);
        return retYN;
    }
}
