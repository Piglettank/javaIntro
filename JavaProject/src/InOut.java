/**
 * Showing how to use the Scanner-klass for reading data
 * @author Fredrik Åhman, e-mail: fred@hig.se
 */

import java.util.Scanner;
public class InOut
{
   public static void main(String args[])
   {
       // Representing persons birthday
       int day, month, year;
 
       // Creating scanner object for reading from input stream 
       Scanner userInput = new Scanner(System.in);
      
       // Set delimiter to '-' or '/' or whitespace 
       userInput.useDelimiter("[-/\\s]+");
 
       /* If the plus sign is added the input gets more robust
          For example if a space is typed before the year
          Try for example to type 22/05 -1989 instead of 22/05-1989
          It should work only if you change the pattern to:
          input.useDelimiter("[-/\\s]+"); */

       // Instructions to the user
       System.out.print("Ditt personnummer (dd/mm-åååå): ");
      
       // Input
       day = userInput.nextInt();
       month = userInput.nextInt();       
       year = userInput.nextInt();

       // Print the result
       System.out.println(year + "" + month + "" + day + "-xxxx");  
       
       userInput.close();
   }
}