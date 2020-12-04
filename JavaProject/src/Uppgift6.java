import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * Cashier system that allows for:
 *    -  Adding articles
 *    -  Removing articles
 *    -  Displaying articles
 *    -  Selling articles
 *    -  Displaying sales history
 *
 * Start with menu() 
 *    - Asks the user which method they would like to use (1-6)
 *    - Takes input with input() that checks for input errors. 
 *    - runs input() again if a number that was not between 1-6 was provided
 *    1. insertArticle() 
 *       - Checks if the matrix of articles is above 50% capacity
 *           if true: 
 *             - Makes a new matrix twice the size
 *             - Copies old articles over to the new matrix
 *       - Adds a number of articles to articles[][]
 *          * The number is based on input from the user using input()
 *          * The amount is random from 1-10
 *          * The price is random from 100-1000 / each
 *          * Looks through the matrix of articles to insert the article in the first empty spot
 *          * Between every added item; checks if the list of matrix of articles is more than half full with checkFull()
 *       - Returns the last used article number
 *    2. removeArticle()
 *       - Gets input of article number to remove from user, using input()
 *       - Resets all fields in that row to 0 
 *    3. showArticles()
 *       - Prints the current articles, their number, amount, and price
 *    4. sellArticle()
 *       - Gets input for article number 
 *       - Checks if the article has enough in stock to sell it
 *          - Remove the sold amount out of the amount in stock
 *          - Add the article number, amount sold and total cost to the first empty slot of sales[][]
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

   public static void main(String[] args)
   {
      //Declaring variables
      // * Initial matrix of articles can contain up to 10 articles 
      int[][] articles = new int[10][3];
      int[][] sales = new int[10][3];
      Date[] salesDate = new Date[10];
      int articleNumber = 1000;
      Boolean hasExited = false;
      
      //Keeps running until the user ends the program
      while(hasExited == false) 
      {
         //returns 1-6
         switch(menu()) 
         {
            //Insert article(s)
            case 1:
               //Double size of articles if above 50% capacity
               articles = checkFull(articles);
               articleNumber = insertArticle(articles, articleNumber);
               break;
            //Remove article
            case 2:
               removeArticle(articles);
               break;
            //Show all articles
            case 3:
               showArticles(articles);
               break;
            //Sell an article
            case 4: 
               sales = checkFull(sales);
               sellArticle(sales, salesDate, articles);
               break;
            //Print your sell history
            case 5:
               printSales(sales, salesDate);
               break;
            //Exit program
            case 6:
               System.out.println("Exiting program...");
               hasExited = true;
               break;
         
         }
      }
      
      userInput.close();

   }
   
   /**
    * Prints all sales done so far. Article number, amount, sum and time. 
    * 
    * @param sales matrix
    * @param array with dates items have been sold
    */
   private static void printSales(int[][] sales, Date[] salesDate)
   {
      Boolean articlesToShow = false;
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd, HH:mm");
      
      System.out.println();
      for(int i = 0; sales.length > i; i++) 
         if(sales[i][0] != 0)
         {
            System.out.printf("%s%8d | %s%8d | %s%4d SEK | %s %s%n", 
                  "Article #: ", sales[i][0], 
                  "Sold: ", sales[i][1], 
                  "Sum: ", sales[i][2],
                  "Sold at: ", formatter.format(salesDate[i]));
            articlesToShow = true;
         }
      
      if(!articlesToShow)
         System.out.println("No articles have been sold.");
   }
   
   
   /**
    * Sells an article by number and amount input by user and adds the sale to the matrix of 
    * sales and the date to the Date array
    * 
    * @param Matrix with sales [article number, amount, sum]
    * @param Array with dates to store time of purchase
    * @param Matrix with current articles [article number, amount, cost] 
    */
   private static void sellArticle(int[][] sales, Date[] salesDate, int[][] articles)
   {
      int articleToSell = 0;
      int amountToSell = 0;
      int articleIndex = 0;
      Boolean articleFound = false;
      Boolean articleSold = false;
      
      System.out.print("\nWhat article would you like to sell? ");
      
      //Searches for the article and saves the index
      while(!articleFound)
      {
         articleToSell = input();
         
         for(int i = 0; articles.length > i; i++)
         {
            if(articles[i][0] == articleToSell)
            {
               articleIndex = i;
               articleFound = true;
            }
         }
         
         //Let the user know if the article didn't exist
         if(!articleFound)
            System.out.println("Article #" + articleToSell + " not found");
      }
      
      //Checks if there's any articles left in stock
      if(articles[articleIndex][1] == 0)
      {
         System.out.println("Article out of stock");
         return;
      }
      
      System.out.print("How many would you like to sell? (in stock: " + articles[articleIndex][1] + ") ");
      
      //Checks if there are enough of the article and sells it storing the sales and time of sale
      while(!articleSold)
      {
         amountToSell = input();
         
         if(amountToSell != 0)
         {
            if(articles[articleIndex][1] >= amountToSell)
            {
               //Add item in sales on the first spot with 0
               for(int index = 0; sales.length > index; index++)
               {
                  if(sales[index][0] == 0)
                  {
                     //Add the article and increase the articleNumber
                     sales[index][0] = articles[articleIndex][0];
                     sales[index][1] = amountToSell;
                     sales[index][2] = amountToSell * articles[articleIndex][2];
                     
                     //Remove amount from article matrix
                     articles[articleIndex][1] -= amountToSell;
                     
                     //Add to order history
                     salesDate[index] = new Date(System.currentTimeMillis());
                     
                     System.out.println(sales[index][1] + " Article #" + sales[index][0] + " have been sold for " + sales[index][2] + " SEK");
                     
                     break;
                  }
               } 
               articleSold = true;
            }
            
            //Let the user know if the article didn't exist
            if(!articleSold)
               System.out.println("Not enough in stock...");
         }
         
         else
            System.out.println("You need to sell at least 1 article.");
         
         
      }
   }

   
   /**
   * Gets input of article number to remove from the matrix of articles
   * @param matrix with articles
   */
   private static void removeArticle(int[][] articles)
   {
      int articleToRemove = 0;
      Boolean articleRemoved = false;
      
      System.out.print("\nWhich article would you like to remove? ");
      
      //Keep asking until article removed
      while(!articleRemoved)
      {
         articleToRemove = input();
         for(int i = 0; articles.length > i; i++)
         {
            if(articles[i][0] == articleToRemove)
            {
               //Set all values in row to 0
               articles[i][0] = 0;
               articles[i][1] = 0;
               articles[i][2] = 0;
               System.out.println("Article #" + articleToRemove + " has been removed");
               articleRemoved = true;
            }
         }
         
         //If it didn't find the article, let the user know
         if(!articleRemoved)
            System.out.println("Article #" + articleToRemove + " not found");
      }
   }
   

   /**
    * Adds a number of articles to articles[][]
    *    - The number of new articles is based on input from the user 
    *    - The amount is random from 1-10
    *    - The price is random from 100-1000 / each
    * @param matrix with articles
    * @param to be used article number
    * @return the last used article number
    * 
    */
   public static int insertArticle(int[][] articles, int articleNumber)
   {
      final int MAXPRICE = 1000;
      final int MINPRICE = 100;
      final int MAXAMOUNT = 10;
      final int MINAMOUNT = 1;
      
      int amountNewArticles = 0;
      SecureRandom random = new SecureRandom();
      
      System.out.print("\nHow many articles would you like to add? ");
      amountNewArticles = input();
      
      //For every new articles about to be added
      for(int i = 0; amountNewArticles > i; i++)
      {  
         //increase size if matrix is above 50% capacity
         //articles = checkFull(articles);
         
         //Check for the first empty spot
         for(int index = 0; articles.length > index; index++)
         {
            if(articles[index][0] == 0)
            {
               //Add the article and increase the articleNumber
               articles[index][0] = articleNumber;
               articles[index][1] = random.nextInt(MAXAMOUNT - MINAMOUNT) + MINAMOUNT;
               articles[index][2] = random.nextInt(MAXPRICE - MINPRICE) + MINPRICE;
               articleNumber++;
               break;
            }
         } 
      }
      
      return articleNumber;
   }
   

   /**
    * Checks if given matrix is filled to more than half with data, in which case it doubles the amount of rows.
    * @param Matrix to check
    * @return Returns original matrix if <50% full, otherwise returns the matrix double the size
    */
   private static int[][] checkFull(int[][] matrix)
   {
      int emptyCounter = 0;
      int filledCounter = 0;
      
      //Adds to the empty and filled counter for each row
      for(int i = 0; matrix.length > i; i++)
      {
         if(matrix[i][0] == 0)
            emptyCounter++;
         else
            filledCounter++;
      }
      
      //If there are more filled slots than empty slots, copy over existing values to a new matrix of twice the size 
      if(filledCounter > emptyCounter)
      {
         //new matrix
         int[][] newMatrix = new int[matrix.length*2][3];
         
         //copy over values
         for(int v = 0; filledCounter > v; v++)
         {
            newMatrix[v][0] = matrix[v][0];
            newMatrix[v][1] = matrix[v][1];
            newMatrix[v][2] = matrix[v][2];
         }
         
         matrix = newMatrix;
      }
      
      return matrix;
      
   }
   

   /**
    * Prints the provided matrix. Only if the first column (article number) if not empty. 
    * @param Matrix with articles [number, amount, price]
    */
   private static void showArticles(int[][] articles)
   {
      Boolean articlesToShow = false;
      
      System.out.println();
      
      //Print every row that has articles added
      for(int i = 0; articles.length > i; i++) 
      {
         if(articles[i][0] != 0)
         {
            System.out.printf("%s%8d | %s%8d | %s%4d SEK |%n", "Article #: ", articles[i][0], "Amount: ", articles[i][1], "Price: ", articles[i][2]);
            articlesToShow = true;
         }
      }
      
      if(!articlesToShow)
         System.out.println("No articles have been added.");
      
   }

   
   /**
    * Program's menu, provides the user with the 6 available choices
    * @return integer 1-6, chosen by user
    */
   private static int menu()
   {
      int option = 0;
      Boolean optionChosen = false;
      
      System.out.print("\n1. Add articles\n"
            + "2. Remove articles\n"
            + "3. Show article \n"
            + "4. Sales\n"
            + "5. Order history\n"
            + "6. Exit\n"
            + "Your choice: ");
      
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
