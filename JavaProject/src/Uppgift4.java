import java.security.SecureRandom;
import java.util.Scanner;

/**
  * Program that sorts an amount of random numbers and then separates and counts them based on if they are uneven or even. 
  * 
  * 1. User inputs the amount of randomized numbers
  * 2a. Create an array in the size of the input number
  * 2b. Go through the array and assign a random number between 0-999 to each element
  * 3. Print the unsorted array 
  * 4. Sort the array
  *   - If the number is even. Add to the "even-array" and the "even-counter"
  *   - If the number is uneven. Add to the "uneven-array" and the "even-counter"
  * 5. Sort the "even-array":
  *      Compare every element in the array to the element after until sorted
  *         - Check if the element is bigger. In that case, swap the two elements.
  * 6. Sort the "uneven-array"   
  *      Compare every element in the array to the element after until sorted
  *         - Check if the element is smaller. In that case, swap the two elements.
  * 7. Replace the value of the unsorted array with the "even-array" and "uneven-array" in that order.
  * 8. Print the new array with a "-" dividing even and uneven numbers. Use the "even-counter" to place the "-".
  * 9. Print the counter for uneven and even numbers. 
  * 
  * @author Johan Fallberg, ojaafe-0
  */
public class Uppgift4
{

   public static void main(String[] args)
   {
      //Declaring variables
      final int MAX_RANDOM = 999;
      
      int numberAmount = 0;
      int[] randomNumberArray;
      
      int[] evenArray;
      int[] unevenArray;
      int evenCounter = 0;
      int unevenCounter = 0;
      Boolean sorted = false;
      
      Scanner input = new Scanner(System.in);
      SecureRandom random = new SecureRandom();
      
      //Prompt asking for the amount of number to be randomized
      System.out.print("How many numbers would you like to randomize? ");
      numberAmount = input.nextInt();
      input.close();
      
      //Sets the arrays' length to the integer given from the user
      randomNumberArray = new int[numberAmount];
      evenArray = new int[numberAmount];
      unevenArray = new int[numberAmount];
      
      //Randomizes all numbers in the array to a number between 0-999
      for(int index = 0; index < randomNumberArray.length; index++)
         randomNumberArray[index] = random.nextInt(MAX_RANDOM + 1);
      
      //Prints the array 
      System.out.println("\nHere are the randomized numbers: ");
      for(int number : randomNumberArray)
         System.out.printf("%d ", number);
      System.out.println();
      
      //Add even numbers to the evenArray and increments evenCounter
      for(int i = 0; i < randomNumberArray.length; i++)
      {
         if(randomNumberArray[i]%2 == 0)
         {
            evenArray[evenCounter] = randomNumberArray[i];
            evenCounter++;
         }
      }
      
      //Add uneven numbers to the uneven array and increments uneven counter
      for(int i = 0; i < randomNumberArray.length; i++)
      {
         if(randomNumberArray[i]%2 == 1)
         {
            unevenArray[unevenCounter] = randomNumberArray[i];
            unevenCounter++;
         }
      }
      
      
      //Sort array of even numbers
      do
      {
         sorted = true;
         
         //For each number that was added into the evenArray (Skipping the 0s that weren't changed)
         for(int i = 0; i < evenCounter-1; i++)
         {
            //If the number is larger than the next - swap the two
            if(evenArray[i] > evenArray[i+1])
            {
               swapElementWithNext(evenArray, i);
               sorted = false;
            }
         }
         
      } while(!sorted);
      
      //Sort array of uneven numbers
      do
      {
         sorted = true;
         
         //For each number that was added into the unevenArray (Skipping the 0s that weren't changed)
         for(int i = 0; i < unevenCounter-1; i++)
         {
            //If the number is smaller than the next - swap the two
            if(unevenArray[i] < unevenArray[i+1])
            {
               swapElementWithNext(unevenArray, i);
               sorted = false;
            }
         }
         
      } while(!sorted);
      
      
      System.out.println("\nHere are the randomized numbers sorted: ");
      //Add the even and uneven arrays together
      for(int i = 0; i < evenCounter; i++)
         randomNumberArray[i] = evenArray[i];
      

      for(int i = 0; i < unevenCounter; i++)
         randomNumberArray[i+evenCounter] = unevenArray[i];
      
      
      //Print the randomNumberArray with a "-" after the random numbers
      for(int i = 0; i < randomNumberArray.length; i++)
         if(i == evenCounter-1)
            System.out.printf("%d%s", randomNumberArray[i], " - ");
         else
            System.out.printf("%d ", randomNumberArray[i]);
      
      
      //Print the total of even and uneven numbers
      System.out.printf("%n%n%s%d%n%s%d", "Amount of even numbers: ", evenCounter, "Amount of uneven numbers: ", unevenCounter);
      
   }
   

   /**
    * Function to swap given index with the next in an array of integers
    * @param Array to modify 
    * @param index of that array to be swapped with the next
    */
   public static void swapElementWithNext(int[] list, int index)
   {
      int firstValue = list[index];
      list[index] = list[index+1];
      list[index+1] = firstValue;
   }
}
