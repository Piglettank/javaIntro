import java.util.Scanner;

/**
 *
 * @author Johan Fallberg, ojaafe-0
 */
public class Övningsproblem7
{

   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      
      palindrom(input.nextLine());
      
      

      input.close();

   }

   /**
    * <h1 get string \h1>
    * swap string around <p fuking ell /p>
    * -  get first character and swap with last.
    * first character is index 0 
    * +  remove whitespaces and change it to lowercase
    * last character is index length - i;
    * compare swapped string with original
    * @param initialInput
    */
   private static void palindrom(String initialInput)
   {
      String flippedInput = "";
      
      initialInput = initialInput.toLowerCase();
      initialInput = initialInput.replace(" ", "");
      
      for(int i = 0; initialInput.length() > i ; i++)
         flippedInput += initialInput.charAt((initialInput.length() -1) - i);
      
      System.out.print("Original word: " + initialInput + ", Flipped word: " +  flippedInput + "\n");
      
      System.out.println("Is the word a palindrom (t/f)? " + flippedInput.equals(initialInput));
      
   }

}
