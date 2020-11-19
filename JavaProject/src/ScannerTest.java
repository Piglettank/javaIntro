import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 * 
 * @author Johan Fallberg, ojaafe-0
 *
 */

public class ScannerTest
{ 
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      int firstNumber = 0;
      int secondNumber = 0;
      int helloNumber = JOptionPane.showConfirmDialog(null, "Hello?");  
      if(helloNumber == JOptionPane.YES_OPTION)
      {
         JOptionPane.showMessageDialog(null, "Yeeee");
      }
      else 
      {
         JOptionPane.showMessageDialog(null, "Hello integer = " + helloNumber);
      }
      String name = JOptionPane.showInputDialog("Enter your name.", "name");
      
      
      System.out.print("Enter the first number: ");
      
      try{
         firstNumber = input.nextInt(); //Get first input
      }
      catch(NoSuchElementException e)
      {
         secondNumber = 0;
         System.out.println("error handled! :^), firstNumber = 0 now"); //Handling the wrong format error
      }
      
      System.out.print("Enter the second number: ");
      
      try
      {
         secondNumber = input.nextInt(); //Get second input
      }
      catch(NoSuchElementException e)
      {
         secondNumber = 0;
         System.out.println("error handled! :^), second number = 0 now"); //Handling the wrong format error
      }
      
      
      //Print everything
      System.out.println(name);
      if (firstNumber == secondNumber)
      {
         System.out.print("Both numbers are " + firstNumber);
      }
      else 
      {
         System.out.printf("%2d and %d%n", firstNumber, secondNumber);
      }
      
      input.close();
   }
}
