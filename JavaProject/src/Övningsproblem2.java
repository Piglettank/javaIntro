
public class Övningsproblem2
{
   public static void main(String[] args)
   {
      areaCalculator();
   }
   
   public static void inbjudan()
   {
      System.out.println("Du är välkommen till oss på Java-party"
            + "\nlördagen den 21 maj kl. 19.30");
   }
   
   public static void tärningskast()
   {
      int firstRoll = (int)(Math.random()*6+1);
      int secondRoll = (int)(Math.random()*6+1);
      int thirdRoll = (int)(Math.random()*6+1);
      
      System.out.println(firstRoll + " " + secondRoll + " " + thirdRoll + " "  );
      System.out.println(firstRoll + secondRoll + thirdRoll);
   }
   
   public static void phoneNumber()
   {
      String lastName = "Fallberg";
      String firstName = "Johan";
      int areaCode = 46;
      int phoneNumber = 722439523;
      
      System.out.println(firstName + " " + lastName);
      System.out.println("+" + areaCode + phoneNumber);
   }
   
   public static void areaCalculator()
   {
      double circleRadius = (double)Math.random()*9+1;
      double pi = 3.1415;
      double calculatedArea = pi * Math.pow(circleRadius, 2);
      
      System.out.println("Circle's radius: " + circleRadius);
      System.out.println("The area is: " + calculatedArea);
   }
   
}
