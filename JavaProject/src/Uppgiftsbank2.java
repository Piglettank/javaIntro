import java.math.RoundingMode;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Uppgifter från andra uppgiftsbanken
 * @author Johan Fallberg, ojaafe-0
 */
public class Uppgiftsbank2
{
   
   
   public static void main(String[] args)
   {
      uppgift1();
      uppgift2();
      System.out.println("\nUppgift 3: ");
      uppgift3();
      System.out.println("\nUppgift 4: ");
      uppgift4();
      System.out.println("\nUppgift 5: ");
      uppgift5();
      System.out.println("\nUppgift 6: ");
      uppgift6();
      System.out.println("\nUppgift 7: ");
      uppgift7();
   }
   
   //Calculates how old you are thisYear from birthDay
   public static void uppgift1() 
   {     
      int birthDay = 1998;
      int thisYear = 2020;
      int age = thisYear - birthDay;  
      System.out.println("You are " + age + " years old");
   }
   
   //Printing weight of envelope
   public static void uppgift2()
   {
      final int maxWeight = 100;
      double pi = Math.PI;
      
      System.out.println("Maximum weight for the envelope is: " + maxWeight + " g");
   }
   
   //tests the limits of int, long, short, float, double, byte
   public static void uppgift3()
   {
      int intLimit = 1234567890;
      long longLimit = 1032419804;
      short shortLimit = 12343;
      float floatLimit = 1;
      double doubleLimit = 1.1234567890123456789012345678901234567890123456789;
      byte byteLimit = 127;
      char character = '\u2030';
      
      System.out.println("Int has a maximum of " + String.valueOf(intLimit).length() + " digits. "
            + "\nLong seem to have the same limit as int, can't get it to work. "
            + "\nShorts are half the length of an int with a total of " + String.valueOf(shortLimit).length() + "digits. "
            + "\nFloats are decimal up to 6-7 digits, when assigning a float you want to add 'f' after decimals (6.21f) to convert it to a float. "
            + "\nDoubles are pretty much limitless."
            + "\nBytes have a maximum of 128 numbers which means the highest byte is " + byteLimit);
   }
   
   //Prints pi with 2, 3 and 4 decimals
   public static void uppgift4()
   {
      double pi = 3.141524;
      
      System.out.printf("2 Decimals: %.2f\n", pi);
      System.out.printf("3 Decimals: %.3f\n", pi);
      System.out.printf("4 Decimals: %.4f\n", pi);
   }

   //1.9 - 0.1 = 1.79999998???
   public static void uppgift5()
   {
      double a = 1.7;
      double b = 1.9;
      double c = a + 0.1;
      double d = b - 0.1;
      System.out.println("c: " + c);
      System.out.println("d: " + d);
      System.out.println("Result of: System.out.printf(\"%.1f\\n\", d);▼");
      System.out.printf("%.1f\n", d);

   }
   
   //Arithmetics with mixed float and integer
   public static void uppgift6()
   {
      /* Simple arithmetic with pure integer operands */
      int firstSum = 10000 + 10*100;

      /* Simple arithmetic with mixed operands
         second operand as float */
      float secondSum = 10000 + (101.36f*10);

      /* Print result of first pure integer operands */
      System.out.print("Första summan: ");
      System.out.println(firstSum);

      /* Print result of second calculation */
      System.out.print("Andra summan: ");
      System.out.println(secondSum);
   }
   
   
   public static void uppgift7()
   {
      /* Both nominator, denominator as integer – no remainder */
      int first = 3/4;

      /* Denominator as float – result includes remainder and 
        must be of type double or float. Observe that (F) 
        always proceeds float value. */ 
      float second = 3/4.0f;

      /* Print result from first division */
      System.out.print("Första divisionen: ");
      System.out.println(first);

      /* Print result from second division */
      System.out.print("Andra divisionen: ");
      System.out.println(second);
   }
   
   public static void uppgift8()
   {
      /* Both nominator, denominator as integer – no remainder */
      int first = 3/4;
      
      /* Denominator as float – result includes remainder and 
        must be of type double or float. Observe that (F) 
        always proceeds float value. */ 
      float second = 3/4.0f;
      
      /* Print result from first division */
      System.out.print("Första divisionen: ");
      System.out.println(first);
      
      /* Print result from second division */
      System.out.print("Andra divisionen: ");
      System.out.println(second);
   }
   
   
}
