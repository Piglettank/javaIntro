import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 *
 * Johan Fallberg, ojaafe-0
 */
public class Övningsproblem3
{

   public static void main(String[] args)
   {
      temperature();
   }

   public static void temperature()
   {
      // Declare variables
      double[] temperatures = {10, 55, 40, 10, 40, 45, -10};
      double averageTemperature;
      int averageTemps = 0;
      double highestTemperature = temperatures[0]; 
      int highestTempDay = 0;
      double lowestTemperature = temperatures[0];
      int lowestTempDay = 0;
      double sum = 0;
      
      
      
      //for each temperature. if lowest/highest temperature == null or if higher/lower than their values. Replace them.
      for(int count = 0; count < temperatures.length; count++)
      {
         sum = sum + temperatures[count];
         if(temperatures[count] < lowestTemperature)
         {
            lowestTemperature = temperatures[count];
            lowestTempDay = count + 1;
         }
            
         if(temperatures[count] > highestTemperature)
         {
            highestTemperature = temperatures[count];
            highestTempDay = count + 1;
         }
            
      }
      
      //temperatures sum / temperatures length = sum
      averageTemperature = sum/temperatures.length;
      
      for(int count = 0; count < temperatures.length; count++)
      {
         if(temperatures[count] > averageTemperature)
            averageTemps++;
      }
     
      //Output
      System.out.println("The highest temperature of the month is: " + highestTemperature + " on the " + highestTempDay + "th day.");
      System.out.println("The lowest temperature of the month is: " + lowestTemperature + " on the " + lowestTempDay + "th day.");
      System.out.println("The average temperature is: " + averageTemperature);
      System.out.println("Above average: " + averageTemps + " times");
   }
   
   
   public static void timeConverter()
   {
      //Declare variables
      int hours, minutes, seconds, totalSeconds;
      
      Scanner input = new Scanner(System.in);
      input.useDelimiter("[:|\\s+]");
      
      //Prompt asking to insert time
      System.out.println("Mata in tim, min och sec på formen (tt:mm:ss)");
      
      //Read input to variables
      hours = input.nextInt();
      minutes = input.nextInt();
      seconds = input.nextInt();
      
      totalSeconds = (hours*60*60) + (minutes*60) + seconds;
      
      System.out.println("Det blir " + totalSeconds + " sekunder");
      
      input.close();
   }
   
   
   public static void autoCashier()
   {
      //Declaring variables
      int twenties = 20;
      int tens = 10;
      int fives = 5;
      int ones = 1;
      int returningMoney;
      
      //Input money
      returningMoney = Integer.parseInt(JOptionPane.showInputDialog(null, "Hur många stålar?", "Kassa", 3));      
      twenties = returningMoney/20;
      tens = (returningMoney%20)/10;
      fives = ((returningMoney%20)%10)/5;
      ones = (((returningMoney%20)%10)%5)/1; //or returningMoney - (twenties*20 + tens*10 + fives*5);
      
      //Output the different moneys in a dialog box
      JOptionPane.showMessageDialog(null, 
            "Twenties: " + twenties +
            "\nTens: " + tens + 
            "\nFives: " + fives  +
            "\nOnes: " + ones
      );
      
      
   }

}
