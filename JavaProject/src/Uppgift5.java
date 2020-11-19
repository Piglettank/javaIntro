import java.util.ArrayList;
import java.util.Scanner;

/**
 * Program with mathematical methods for: 
 *    - Calculating area and volume of a cone
 *       1. Calculating area of base
 *       2. Calculating area of mantle
 *       3. Calculating volume
 *    - Simplifying fractions
 *       - Given numerator and denominator the program will simplify the fraction as long as possible, separating the wholes and the fractions remaining.
 * 
 * User inputs the values that are used by the program. It will move to the next task or end the program when user inputs "q" or "Q". 
 * 
 * @author Johan Fallberg, ojaafe-0
 */

public class Uppgift5
{
   static Scanner userInput = new Scanner(System.in);
   
   public static void main(String[] args)
   {
      //Declaring variables
      String divider = "----------------------------------";
      System.out.printf("%s%n%s%n%s%n", divider, "# Test of area and volume methods", divider);
      
      int radius = 0;
      int height = 0;
      double coneBaseArea = 0.0;
      double coneMantleArea = 0.0;
      double coneVolume = 0.0;
      
      //Gets input from user
      int[] inputArray = intInput();
      
      //Calculates and prints base area, mantle area and volume of a cone for each pair of inputs provided
      for(int i = 0; inputArray.length > i+1; i += 2)
      {
         radius = Math.abs(inputArray[i]);
         height = Math.abs(inputArray[i+1]);
         
         coneBaseArea = area(radius);
         coneMantleArea = area(radius, height);
         coneVolume = volume(height, coneBaseArea);
         
         System.out.println("r = " + radius + " h = " + height + "\n");
         System.out.printf("%s%2.2f%n", "Base area:   ", coneBaseArea);
         System.out.printf("%s%2.2f%n", "Mantle area: ", coneMantleArea);
         System.out.printf("%s%2.2f%n", "Volume:      ", coneVolume);
         System.out.println();
      }
      
      System.out.printf("%s%n%s%n%s%n", divider, "# Test of fraction methods", divider);
      
      //Gets a new set of input
      inputArray = intInput();
      
      //Calculates and prints the fractions
      printFraction(inputArray);
       
   }

   /**
    * Simplifies and prints out fractions
    * 
    * @param Arraylist of integers with values of fractions that will be simplified and printed out
    */
   public static void printFraction(int[] parts)
   {
      int numerator = 0;
      int denominator = 0;
      int[] fractionArray;
      
      //For each pair of inputs calculate and print
      for(int i = 0; parts.length > i+1; i += 2)
      {
         numerator = parts[i];
         denominator = parts[i+1];
        
         fractionArray = fraction(numerator, denominator);
         
         if(fractionArray == null)
            System.out.printf("%3d/%d = %s", numerator, denominator, "\"Error\"");
         else if(fractionArray[0] == 0)
         {
            if(fractionArray[1] == 0 || fractionArray[2] == 0)
               System.out.printf("%3d/%d = %d", numerator, denominator, 0);
            else
               System.out.printf("%3d/%d = %d/%d", numerator, denominator, fractionArray[1], fractionArray[2]);
         }
         else if(fractionArray[1] == 0 || fractionArray[2] == 0)
            System.out.printf("%3d/%d = %d", numerator, denominator, fractionArray[0]);
         else
            System.out.printf("%3d/%d = %d %d/%d", numerator, denominator, fractionArray[0], fractionArray[1], fractionArray[2]);
         System.out.println();
            
      }
      
   }


   /**
    * Takes in a numerator and denominator of a fraction to simplify it using the Euclidean's algorithm and returning
    * an array with wholes followed by fractions. 
    * 
    * @param numerator of fraction to be simplified
    * @param denominator of fraction to be simplified
    * @return Returns an array with a length of 3 with first value being wholes and the other two being fractions.
    * i.e. 1 3/4 as [1, 3, 4]. 
    * If numerator is 0 return {0, 0, 0}
    * If the denominator is 0 return null
    */
   public static int[] fraction(int numerator, int denominator)
   {
      int[] simplifiedFraction = new int[3];
      int largestCommonDenominator;
      
      //If the denominator is 0 and the numerator is 0 returns an empty list. If the numerator isn't 0 it returns null.
      if(numerator == 0)
         return new int[3];
      if(denominator == 0)
         return null;
        
      largestCommonDenominator = sgd(numerator, denominator);
      
      numerator = numerator/largestCommonDenominator;
      denominator = denominator/largestCommonDenominator;
      
      //The amount of wholes are simply how many times the numerator goes in the denominator
      simplifiedFraction[0] = numerator/denominator;
      
      //New numerator of fraction is what's left of the old numerator after taking out the wholes modulus
      //the largest common denominator
      simplifiedFraction[1] = numerator - (simplifiedFraction[0]*denominator);
      
      //The denominator simplified by the largest common denominator
      simplifiedFraction[2] = denominator;
      
      return simplifiedFraction;
      
   }

   /**
    * Takes in a numerator and denominator to calculate the largest common denominator using Euclidean's algorithm
    * 
    * @param a numerator
    * @param b denominator
    * @return Integer with largest common denominator of a and b
    */
   public static int sgd(int a, int b)
   {
      int c = 0;
      
      //redundant
      if(b > a)
      {
         int temp = b;
         b = a;
         a = temp;
      }
      
      //Performing the Euclidean's algorithm
      while (b != 0)
      {
         c = a%b;
         a = b;
         b = c;
      }
         
      return a;
      
   }

   /**
    *  User writes input 
    *    * If it a viable integer, add integer to an ArrayList
    *    * If the user inputs "q", move to the next task in the program
    *    * If it's anything else, ignore it 
    *  Converts the ArrayList to a int[]
    *  
    * @return Array of input integers 
    */
   public static int[] intInput()
   {
      int inputNumber = 0;
      Boolean hasNext = true;
      ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
      String inputText = "";
      
      System.out.print("> ");
      
      //Keeps adding values until the user inputs q or Q
      while(hasNext)
      {
         if(userInput.hasNextInt())
         {
            inputNumber = userInput.nextInt();
            listOfNumbers.add(inputNumber);
         }
         else
         {
            inputText = userInput.next().toLowerCase();
            if(inputText.equals("q"))
               hasNext = false;
         }
      }
      
      //Converts ArrayList into int[]
      int[] newArray = new int[listOfNumbers.size()];
      for(int i = 0; newArray.length > i; i++)
      {
         newArray[i] = listOfNumbers.get(i);
      }      
      
      return newArray;
   }
   
   
   /**
    * Calculates the area of the base of a cone when given the cone's radius as an integer.
    * 
    * @param int value of the base of the cone's radius
    * @return double the area of the base of the cone
    */
   public static double area(int radius)
   {
      double baseArea = Math.PI * (Math.pow(radius, 2));
      
      return baseArea;
   }
   
   /**
    * Calculates the area of the mantle of a cone when given the cone's radius and height
    * 
    * @param radius of cone's base
    * @param height of cone
    * @return double with the area of the mantle of the cone
    */
   public static double area(int radius, int height)
   {
      double s = pythagoras(radius, height);
      double area = Math.PI * radius * s;
      
      return area;
   }
   
   
   /**
    * Method that takes in two sides of a perpendicular triangle, calculates and returns the hypotenuse 
    * using Pythagorean's theorem
    * 
    * @param sideA integer with the value one of the sides of the triangle
    * @param sideB integer with the value of the other side of the triangle
    * @return double with the length of the hypotenuse
    */
   public static double pythagoras(int sideA, int sideB)
   {
      double sideC = 0.0;
      double sideASquared = 0.0;
      double sideBSquared = 0.0;      
      double sideCSquared = 0.0;      
      
      sideASquared = Math.pow(sideA, 2);
      sideBSquared = Math.pow(sideB, 2);
      
      sideCSquared = sideASquared + sideBSquared;
      
      sideC = Math.sqrt(sideCSquared); 
      
      return sideC;
   }
   
   /**
    * Calculates the volume of a cone provided height and base area
    * 
    * @param int with height of cone
    * @param double baseArea of the base of cone
    * @return double with volume of cone
    */
   public static double volume(int height, double baseArea)
   {  
      return (height * baseArea) / 3;
   }
  
}
