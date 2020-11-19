/**
 * Calculates the amount of years it takes to reach a certain capital with interest.
 * @author Johan Fallberg 
 * 
 */
public class InterestCounter
{
   static double interest = 1.2;
   
   public static String calculateSum(double desiredCapital)
   {
      double capital = 10000;
      int year = 0;
      String returnString = "";
      System.out.println("Year: " + year + ", Capital: " + capital);
      
      while(capital < desiredCapital) 
      {
         capital = capital*interest;
         year++;
         returnString = returnString + "Year: " + year + ", Capital: " + capital + "\n";
      }     
      return returnString;
   }
}
