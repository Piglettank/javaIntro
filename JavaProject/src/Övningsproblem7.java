import java.util.Scanner;

/**
 *
 * @author Johan Fallberg, ojaafe-0
 */
public class Övningsproblem7
{

   public static void main(String[] args)
   {
      //get string
      //swap string around
      // -  get first character and swap with last.
      /**
       * first character is index 0 
       * last character is index length - i;
       */
      // +  remove whitespaces and change it to lowercase
      //compare swapped string with 
      
      String initialInput;
      String flippedInput = "";
      String flippedInput2 = "";
      char[] characterIndex;
      
      Scanner input = new Scanner(System.in);
      
      initialInput = input.nextLine();
      initialInput = initialInput.toLowerCase();
      initialInput = initialInput.replace(" ", "");
      
      for(int i = 0; initialInput.length() > i ; i++)
         flippedInput2 += initialInput.charAt((initialInput.length() -1) - i);
      
      System.out.print("Original word: " + initialInput + ", Flipped word: " +  flippedInput2 + "\n");
      
      System.out.println("Is the word a palindrom (t/f)? " + flippedInput2.equals(initialInput));
      
      
      
      
      
      characterIndex = new char[initialInput.length()];
      
      for(int i = 0; initialInput.length()  > i ; i++)
         characterIndex[i] = initialInput.charAt((initialInput.length() -1) - i);
      
      for(char c : characterIndex)
         flippedInput += c;
      
      System.out.println(flippedInput);

   }

}
