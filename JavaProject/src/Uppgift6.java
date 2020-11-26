import java.security.SecureRandom;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * Start with menu() 
 *    - Asks the user which method they would like to use (1-6)
 *    - Takes input with input() that checks for input errors. 
 *    - runs input() again if a number that was not between 1-6 was provided
 *    1. insertArticle() 
 *       - Adds a number of articles to articles[][]
 *          * The number is based on input from the user using input()
 *          * The amount is random from 1-10
 *          * The price is random from 100-1000 / each
 *          * Looks through the matrix of articles to insert the article in the first empty spot
 *          * Between every added item; checks if the list of matrix of articles is more than half full with checkFull()
 *             - Makes a new matrix twice the size
 *             - Copies old articles over to the new matrix
 *             - Returns the new matrix
 *       - Returns the last used article number
 *    2. removeArticle()
 *       - Gets input of article number to remove from user, using input()
 *       - Resets all fields in that row to 0 
 *    3. showArticles()
 *       - Prints the current articles, their number, amount, and price
 *    4. sellArticle()
 *       - Gets input of article number 
 *       - Checks if the article has enough in stock to sell it
 *          - Remove the sold amount out of the amount in stock
 *          - Add the article number, amount sold and total cost to the first empty slot of sales[][]
 *             - Check if the matrix is full with checkFull()
 *          - Add the time the item was sold to the array of Date salesDate[] on corresponding spot
 *    5. printSales()
 *       - Print each row of the sales[][] together with corresponding index of salesDate[]
 *    6. Exits program
 *    
 *    
 * @author Johan Fallberg, ojaafe-0
 */

public class Uppgift6
{
   static Scanner userInput = new Scanner(System.in);
   SecureRandom random = new SecureRandom();
   Date lolo = new Date();

   public static void main(String[] args)
   {
      int[][] articles = new int[1][3];
      Boolean hasExited = false;
      
      while(hasExited == false) 
      {
         switch(menu()) 
         {
            //Insert article
            case 1:
               System.out.println("case 1");
               insertArticle();
               break;
            case 2:
               //removeArticle();
               break;
            case 3:
               showArticles(articles);
               break;
            case 4: 
               //sellArticle();
               break;
            case 5:
               //printSales();
               break;
            case 6:
               System.out.println("Exiting program...");
               hasExited = true;
               break;
            default:
               System.out.println("Error! menu() returned something that wasn't between 1-6. Terminating...");
               hasExited = true;
               break;
            
            
         
         }
      }
      userInput.close();

   }

   /**
    * 
    */
   private static void insertArticle(int[][] articles)
   {
      
      
   }

   /**
    * 
    * @param Matrix with articles [number, amount, price]
    */
   private static void showArticles(int[][] articles)
   {
      for(int i = 0; articles.length > i; i++) 
      {
         System.out.printf("%s%7d | %s%7d | %s%7d |%n", "Article #: ", articles[i][0], "Amount: ", articles[i][1], "Price: ", articles[i][2]);
      }
      
   }

   /**
    * Prompts the user to input a number between 1-6. Then returns said number. 
    * @return integer with the option chosen by user
    */
   private static int menu()
   {
      int option = 0;
      Boolean optionChosen = false;
      
      //Keep asking for input until the user provides a number between 1-6. 
      do 
      {
         option = input();
         
         if(option > 0 && option < 7)
            optionChosen = true;
         
         else
            System.out.println("Please insert a number between 1-6");
            
      } while(!optionChosen);
      
      return option;
   }

   /**
    * Gets input from user and returns an integer.
    * If the input is not an integer, the user will get a new chance to type an integer in.
    * 
    * @return input integer
    */
   private static int input()
   {
      int input = 0;
      Boolean checkingInput = true;
      
      while(checkingInput)
      {
         if(userInput.hasNextInt())
         {
            input = userInput.nextInt();
            return input;
         }
         
         else if(userInput.hasNext())
         {
            userInput.next();
         }
         
            
         
      }
      return input;
   }

   
}
