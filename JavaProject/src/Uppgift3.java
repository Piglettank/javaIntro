import java.util.Scanner;

/**
  * Roll-three-die game
  * 
  * 1. Declare variables for all three die. The sum and the current score (W-L)
  * 2. While the sum of all die is less than 12, choose any of the following actions.
  *      - Re roll any of the three die unless it has been rolled before
  *         * Roll a random number between 1 and 6. 
  *      - Press "Q" to exit the game
  * 3. If the sum of the die is 12 
  *      - Add 1 to the win-counter
  *      - Reset the die
  *      - new round
  * 4. If the sum of the die is above 12
  *      - Add 1 to the lose-counter
  *      - Reset the die
  *      - new round
  * 5. If all dies have been rolled.
  *      - Reset die
  *      - new round
  * 
  * @author Johan Fallberg, ojaafe-0
  */

public class Uppgift3
{

   public static void main(String[] args)
   {
      //Declaring variables
      final int VICTORY_SUM = 12;
      final double DIE_FACES = 6;
      final double LOWEST_ROLL = 1;
      int dice1 = 0, dice2 = 0, dice3 = 0;
      String inputKey = "";
      int victories = 0, losses = 0;
      int sum = 0;
      
      Scanner input = new Scanner(System.in);
      
      System.out.println("Välkommen till spelet 12. Du ska slå 1-3 tärningar och försöka få summan 12...");
      
      //Run the game as long as sum is less than 12
      while(sum < 12)
      {
         //Prompt asking for the player to choose action
         System.out.print("Ange vilken tärning du vill slå [1,2,3](avsluta med q): ");
         inputKey = input.next();
         
         //Checks what the player input and rolls one of the die, or exits game.
         if (inputKey.equals("1"))
         {
            if(dice1 == 0)
               //Rolls a number between 1 and 6. (Math random randomizes a double between 0 and 1)
               dice1 = (int)((Math.random() * (DIE_FACES)) + LOWEST_ROLL);
            else
               System.out.println("Tärning 1 är redan slagen.");
         }
            
         else if (inputKey.equals("2"))
         {
            if(dice2 == 0)
               dice2 = (int)((Math.random() * DIE_FACES) + LOWEST_ROLL);
            else
               System.out.println("Tärning 2 är redan slagen."); 
         }
         
         else if (inputKey.equals("3"))
         {
            if(dice3 == 0)
               dice3 = (int)((Math.random() * DIE_FACES) + LOWEST_ROLL);
            else
               System.out.println("Tärning 3 är redan slagen.");
         }
           
         //exit if q is pressed
         else if (inputKey.equals("q") || inputKey.equals("Q"))
         {
            System.out.println("Avslutar spel!");
            //Stop the loop
            break;
         }
         
         //Throws message if the player enters something that doesn't have an action
         else 
         {
            System.out.println("Ogiltig input!");
            System.out.println("Ange vilken tärning du vill slå [1,2,3](avsluta med q): ");
         }
            
         
         //Calculates and prints new sum and chooses response based on if the player has won or lost
         sum = dice1 + dice2 + dice3;
         System.out.printf("%d %d %d %s %d ", dice1, dice2, dice3, "sum:", sum);
         
         //If the sum of the die is 12: get a win and reset the die
         if(sum == VICTORY_SUM)
         {  
            //Adds 1 to the amount of victories and prints the current standings
            victories++;
            System.out.printf("%s %d %s %d%n", "#vinst:", victories, "#förlust:", losses);
            
            //Resets dice and sum
            dice1 = 0;
            dice2 = 0;
            dice3 = 0;
            sum = 0;
            
            //Blank space
            System.out.println("Nästa omgång!");
         }

         //If the sum is above 12: get a loss and reset the die, if above 5 losses it's game over
         else if (sum > VICTORY_SUM)
         {
            // Adds 1 to the amount of losses and prints the current standings
            losses++;
            System.out.printf("%s %d %s %d%n", "#vinst:", victories, "#förlust:", losses);

            // Resets dice and sum
            dice1 = 0;
            dice2 = 0;
            dice3 = 0;
            sum = 0;

            System.out.println("Nästa omgång!");
         }

         //If all dies have been rolled 
         else if(dice1 != 0 && dice2 != 0 && dice3 != 0)
         {
            System.out.printf("%s %d %s %d%n", "#vinst:", victories, "#förlust:", losses);
            //Resets dice and sum
            dice1 = 0;
            dice2 = 0;
            dice3 = 0;
            sum = 0;
            
            System.out.println("Nästa omgång!");
         }
         
         else
            System.out.printf("%s %d %s %d%n", "#vinst:", victories, "#förlust:", losses);
      }
      
      input.close();
   }
  
}
