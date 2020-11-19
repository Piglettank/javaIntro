/**
 * Skriver ut texten "Hej Värld!"
 * @author Johan Fallberg, ojaafe-0
 *
 */

public class Uppgift0 
{
   public static void main(String [] args)
   {
      //System.out.println("Hej 'Värld!");
      //System.out.println(InterestCounter.calculateSum(40000));
      //System.out.println(calculate(2, 3));
      ballArranger();
   }

   public static int calculate(int int1, int int2)
   {
      return int1 + int2;
   }
   
   public static void ballArranger()
   {
      String[] marbleArray = {"white", "black", "white", "black", "black"};
      int i = 0;
      int sortCounter = 0;
      int length = marbleArray.length;
      Boolean isBlack = false;
      String temp = "";
      
      //Arranges the balls until the array has been sorted
      while(sortCounter != length)
      {
         if(marbleArray[i] == "black")
         {
            isBlack = true;
         }
         
         if(isBlack == true)
         {
            //swaps the marbles and resets sortCounter
            if(marbleArray[i] == "white")
            {
               temp = marbleArray[i-1];
               marbleArray[i-1] = marbleArray[i];
               marbleArray[i] = temp;
               sortCounter = 0;
            }
         } 
         
         /* sortCounter keeps track and stops the while loop when the the array 
          * has been gone through without picking up any errors
          */
         sortCounter++;
         
         if(i<length-1)
         {
            i++;
         }
         
         else
         {
            i=0;
            isBlack = false;
         }
      }
      
      System.out.println("The marbles have been sorted!\n");
      
      //Prints result
      for(int index = 0; index<length; index++)
      {
         System.out.println(marbleArray[index] + " marble");
      }
   }
}

