import java.util.Scanner;

/**
  * Calculates the energy production and value provided by sun cells on a summer day
  * 
  * 1. Declares constant variables
  *   - Suncell: amount, size, maximum produced energy, efficiency
  *   - Price for electricity
  *   - Radiation from sun
  * 2. Receives date from user and checks if it is correct
  *   - Date has to be between first of June to last of July
  *      * if it is not; stop application
  * 3. Receives time for sunrise and sunset from user and checks if it is correct
  *   - Checks if what was input is a valid time (Between 00:00 - 23:59)
  *      * if it is not; stop application
  * 4. Counts the total amount of sunshine hours from the input
  *   - Time at sunset - time at sunrise
  * 5. Calculates energy produced during those hours
  *   - hours of sun * energy produced per cell * amount of cells
  * 6. Calculates price generated from that energy
  *   - energy * price
  * 7. Prints result
  * 
  * @author Johan Fallberg, ojaafe-0
  */

public class Uppgift2
{

   public static void main(String[] args)
   {
      
      //Instantiate constant variables
      final int SUN_CELL_COUNT = 26;
      final double SUN_CELL_SIZE = 1.7; //1.7 sq. meters
      final double EFFICIENCY = 0.2; //20 %
      final double ELECTRICITY_PRICE = 0.9; //kr/kWh
      final int SUN_RADIATION = 166; //Wh per sq. meter
      final int KILO = 1000; //Used to convert Wh to kWh
      
      //Declares variables
      int sunRiseHour;
      int sunRiseMinute; 
      int sunSetHour;
      int sunSetMinute;
      double energyProduced;
      double energyProducedPerCell;
      double sunshineHours;
      double energyValue;
      String month;
      String day;
      
      //Receive and check if the date is written correctly
      Scanner dateInput = new Scanner(System.in);
      dateInput.useDelimiter("[-\\s]+");
      System.out.print("Skriv dagens datum [mm-dd]:");
      month = dateInput.next();
      day = dateInput.next();
      CheckDate(month, day);
      
      //Receive and check time if the time is written correctly
      Scanner timeInput = new Scanner(System.in);
      timeInput.useDelimiter("[\\s:]+");
      
      //Sunrise input
      System.out.print("Skriv in tidpunkt soluppgång [hh:mm]");
      sunRiseHour = timeInput.nextInt();
      sunRiseMinute = timeInput.nextInt();
      CheckTime(sunRiseHour, sunRiseMinute);
     
      //Sunset input
      System.out.print("Skriv in tidpunkt solnedgång [hh:mm]");
      sunSetHour = timeInput.nextInt();
      sunSetMinute = timeInput.nextInt();
      CheckTime(sunSetHour, sunSetMinute);
      
      //Prints divider
      System.out.println("=============================");
      
      //Counts and prints the amount of sunshine hours with 2 decimals 
      sunshineHours = (sunSetHour + HourConverter(sunSetMinute)) - (sunRiseHour + HourConverter(sunRiseMinute));
      if(sunshineHours < 0) //Handles the case if sun set is past midnight
      {
         sunshineHours = 24 + sunshineHours;
      }
      System.out.printf("Soltimmar: %.2f\n", sunshineHours);
      
      //Calculates how much energy each cell produces
      energyProducedPerCell = SUN_RADIATION * sunshineHours * SUN_CELL_SIZE * EFFICIENCY;
   
      //Total energy produced
      energyProduced = energyProducedPerCell * SUN_CELL_COUNT / KILO; //divided by 1000 to get kWh from Wh
      
      
      //Calculate the value of the energy produced
      energyValue = energyProduced * ELECTRICITY_PRICE;
      
      //Prints end result
      System.out.printf("Produktionen: " + month + "-" + day + " blir: %.2f kWh till ett värde av: %.2f kr. ", energyProduced, energyValue);
      
      timeInput.close();
      dateInput.close();
   }
   
   
   /**
    * Method that checks if a given date is correct (between 1st of June to 31st of July) 
    *    - otherwise stops application
    * @param month of year as a string
    * @param day of month as a string
    */
   public static void CheckDate(String month, String day)
   {  
      int dayAsInt = Integer.parseInt(day);
      
      //If the month isn't June or July () ->
      if(month.contains("06") == false && month.contains("07") == false) 
      {
         System.out.println("Only works on the months June and July (Month 6 and 7)");
         System.exit(0);
      }
      
      if(month.contains("06") == true) //June only has 30 days
      {
         if(dayAsInt < 1 || dayAsInt > 30)
         {
            System.out.println("Please enter a day from 1-30");
            System.exit(0);
         }
      }
      
      if(month.contains("07") == true) //July has 31 days
      {
         if(dayAsInt < 1 || dayAsInt > 31)
         {
            System.out.println("Please enter a day from 1-31");
            System.exit(0);
         }
      }
   }
   
   
   /**
    * Method that checks if given time is correct (between 00:00 and 23:59), otherwise stops application.
    * @param hour of sunrise or sunset as input by the user
    * @param minute of sunrise or sunset as input by the user
    */
   public static void CheckTime(int hour, int minute)
   {
      if(hour < 0 || hour > 23)
      {
         System.out.println("Time needs to be between 00:00 - 23:59");
         System.exit(0);
      }
      
      if(minute < 0 || minute > 59)
      {
         System.out.println("Minute needs to be between 00 - 59");
         System.exit(0);
      }
   }
   
   
   /**
    * Method that takes minutes and turn into fractions of an hour 
    * @param integer with minutes to convert into hour-fractions
    * @return double with minutes as fractions of hour
    */
   public static double HourConverter(int minutes)
   { 
      final int MINUTES_PER_HOUR = 60;
      
      double minutesAsDouble = minutes;
      return minutesAsDouble/MINUTES_PER_HOUR;
   }

   
}
