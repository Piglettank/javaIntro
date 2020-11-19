/**
 * Counts the price for a phone bill
 * @author Johan Fallberg 
 * 
 */
public class PhoneBill 
{
   public static void main(String[] args) 
   {
      double cheapMinutes = 300;
      double expensiveMinuteCost = 0.45*1.125;
      double minutesUsed = 350;
      double cost = 29.95;
      
      if(minutesUsed > cheapMinutes) 
      {
         cost = cost + ((minutesUsed - cheapMinutes) * expensiveMinuteCost);
      }
      System.out.println("Cost: " + cost);  
   }
}
