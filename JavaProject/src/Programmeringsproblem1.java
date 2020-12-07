import java.security.SecureRandom;
import java.util.Scanner;


/**
  * User inputs 1-12 
  * Starts a quiz of multiplication table with provided number (n)
  *   - Provided number * 1 through 12
  *   - Questions are in random order
  *   - Get answer input and compare it to the randomized number * n
  *      - On right answer, add 1 to the first column of the matrix
  *      - On wrong answer, add 1 to the second column of the matrix
  *   - Repeat until each question has been answered correctly 3 times then end quiz 
  *   - If the user inputs "0", the quiz also ends
  * 
  * When quiz ends, the user is presented which questions they got wrong, and how many times.
  *   
  *   
  * @author Johan Fallberg, ojaafe-0
  */
public class Programmeringsproblem1
{

   public static void main(String[] args)
   {
      //Matrix with the 12 numbers to be multiplied with n 
      int[][] results = new int[12][2];
      int n;
      Boolean quizComplete = false;
      Boolean hasExited = false;
      
      while(hasExited == false)
      {
         //Asks user which multiplication table they want to test
         n = menu();
         
         //Keeps asking questions until all answers are 3
         while(!quizComplete)
         {
            //Should return results 
            results = askQuestion(results, n);
            
            //Check if the quiz is over
            quizComplete = checkComplete(results);   
         }
      
      //Print result
      //printResults(results);
      
      //Reset results
      
      }
   }
   
   
   private static int menu()
   {
      final int HIGHEST_MULTIPLIER = 12;
      final int LOWEST_MULTIPLIER = 1;
      
      int chosenTable = 0;
      Boolean choiceMade = false;
      
      System.out.println("Which multiplication table would you like to practice? ("+ LOWEST_MULTIPLIER + " - " + HIGHEST_MULTIPLIER + ")");
      
      while(!choiceMade)
      {
         chosenTable = input();
         
         if(chosenTable >= LOWEST_MULTIPLIER || chosenTable <= HIGHEST_MULTIPLIER)
            choiceMade = true;
         else
            System.out.println("Please enter a number between 1-12");
      }
      
      return chosenTable;
   }


   /**
    * Checks if input is correct and returns next int.
    * @return integer input
    */
   private static int input()
   {
      Scanner input = new Scanner(System.in);
      int inputNumber = 0;
      Boolean checkingInput = true;
      
      while(checkingInput)
      {
         if(input.hasNextInt())
         {
            inputNumber = input.nextInt();
            checkingInput = false;
         }
         else if(input.hasNext())
         {
            //Clear line
            input.nextLine();
            System.out.println("Please enter a valid number");
         }
      }
      
      return inputNumber;
   }


   /**
    * Asks a random question that hasn't been answered 3 times already, 
    *    - checks if answer is right 
    *    - adds 1 to the right or wrong columns of the results
    *    
    * 
    * @param results
    * @param n
    * @return
    */
   private static int[][] askQuestion(int[][] results, int n)
   {
      Boolean questionAsked = false;
      int answer;
      int multiplier;
      SecureRandom random = new SecureRandom();
      
      
      while(!questionAsked)
      {
         //Randomizes a number between 1 - 12
         multiplier = random.nextInt(results.length) + 1;
         
         System.out.print("Question: " + multiplier + " * " + n);
         
         //Checks if question has been answered less than three times 3 times, if not, create a new question
         if(results[multiplier-1][0] < 3)
         {
            System.out.println("\nQuestion hasn't been correctly answered three times");
            
            //Ask question
            
            answer = input();
            
            System.out.println("you just input: " + answer);
            
            //If it's right add 1 to right column
            if(answer == multiplier * n)
               results[multiplier-1][0]++;
            
            //If it's wrong, add 1 to wrong column
            else
               results[multiplier-1][1]++;
            
            for(int i = 0; results.length > i; i++)
            {
               System.out.printf("%d %s %3d %s %3d%n", i, "Correct:", results[i][0], ", Wrong:", results[i][1]);
            }
            
            questionAsked = true;
         }
         
      }
      
      return results;
   }


   private static Boolean checkComplete(int[][] results)
   {
      Boolean complete = false;
      int completeAnswers = 0;
      
      for(int i = 0; results.length > i; i++)
      {
         //If any result is 3, move onto the question
         if(results[i][0] == 3)
         {
            completeAnswers++;
         }
         
         //If the user entered "0" during the question phase return true early
         else if(results[i][0] == Integer.MAX_VALUE)
         {
            complete = true;
            return complete;
         }
         
         else
            complete = false;
      }
      
      //If the player has answered all 12 questions three times each
      if(completeAnswers == 12)
         complete = true;
       
      System.out.println("Checkcomplete returning: " + complete);
      return complete;
   }

  
}
