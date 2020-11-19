/**
 * 
 * Prints a table that calculates time until a car battery is fully charged
 * @author Johan Fallberg, ojaafe-0
 * 
 * 1. Make an array out of the different ampere and voltage values that will be used
 * 2. Print battery capacity, tabs and the "=" divider
 * 3. For each of the items in the array of ampere and voltage
 *    - Calculate the charging effect in kW
 *    - Calculate the time it would take until the charging effect would fully charge the battery
 *    - Print one line with Ampere, Voltage, Charging effect and Charging time 
 */

public class Uppgift1
{
   

   public static void main(String[] args)
   {
      // Declaring variables and instantiating constants
      final double BATTERY = 35.8;
      final int[] VOLTAGE = {230, 230, 400, 400, 400};
      final int[] AMPERE = {10, 16, 10, 16, 32};
      double chargingEffect, timeUntilCharged;
      
      //Prints battery capacity
      System.out.print("Batteri: " + BATTERY + "(kWh)\n\n");
      
      //Prints names of the tabs
      String tabTitles = "Ström(A) \tSpänning(V) \tLaddeffekt(kW) \tLaddningstid(h)";
      System.out.print(tabTitles + "\n");
      
      //Prints the "=" divider in the same length as the text above it. 
      for(int i = 0; i < tabTitles.length() + 9; i++) // + 9 to make up for the tabs
         System.out.print("=");
      
      System.out.print("\n");
      
      //Calculates and prints the each row using each item of the ampere and voltage arrays
      for(int i = 0; i < VOLTAGE.length; i++)
      {
         chargingEffect = Math.round(calculateEffect(AMPERE[i], VOLTAGE[i])*100)/100d; //Calculates the effect by using the calculateEffect function and then rounds to two decimals
         timeUntilCharged = Math.round(BATTERY/chargingEffect*100)/100d; //Calculates duration until battery is fully charged and rounds to two decimals
         System.out.print(AMPERE[i] + "\t\t" + VOLTAGE[i] + "\t\t" + chargingEffect + "\t\t" + timeUntilCharged); //Prints all the values
         System.out.print("\n");
      }
   }
   
   /**
    * Calculates the rate that the battery charging 
    * @param ampere is one value out of the array of different ampere values
    * @param voltage is one value out of the array of different voltage values
    * @return 
    */
   public static double calculateEffect(double ampere, double voltage)
   {
      double effect = 0;
      
      if(voltage == 400)
         effect = ampere * voltage * Math.sqrt(3);
      else
         effect = ampere * voltage;
      
      return effect/1000; //divides with 1000 to get kW instead of W
   }
   
}
