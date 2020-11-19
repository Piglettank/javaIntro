import java.util.Scanner;

/**
    *
    * Johan Fallberg, ojaafe-0
    */
public class Uppgiftsbank4
{

   public static void main(String[] args)
   {
      ///HERE GOES NUMBER ________________________
      uppgift10();
   }
   
   public static void uppgift1()
   {
      final int AGE_REQUIREMENT = 18;
      int age;
      Scanner input = new Scanner(System.in);
      
      System.out.print("Please insert your age: ");
      
      age = input.nextInt();
      
      if(age >= AGE_REQUIREMENT)
         System.out.println("You are eligible to apply for driver's license");

      if(age < AGE_REQUIREMENT)
         System.out.println("You are NOT eligible to apply for driver's license");
      
      input.close();

   }
   
   public static void uppgift2()
   {
      final double BOILING_POINT = 100;
      int currentTemperature;
      Scanner input = new Scanner(System.in);
      
      System.out.print("Current temperature: ");
      
      currentTemperature = input.nextInt();
      
      if(currentTemperature > BOILING_POINT)
         System.out.println("Is above boiling point, electricity is off");

      if(currentTemperature == BOILING_POINT)
         System.out.println("Is boiling");

      if(currentTemperature < BOILING_POINT)
         System.out.println("Is below boiling point, electricity is on");
      
      input.close();
   }
   
   public static void uppgift3()
   {
      final int ONE_SCOOP_COST = 10;
      final int TWO_SCOOP_COST = 15;
      final int THREE_SCOOP_COST = 20;
      
      int weeklyAllowance;
      Scanner input = new Scanner(System.in);
      
      System.out.print("Girl's weekly allowance: ");
      
      weeklyAllowance = input.nextInt();
      
      if(weeklyAllowance >= ONE_SCOOP_COST && weeklyAllowance < TWO_SCOOP_COST)
         System.out.println("The girl can only buy one scoop");
      
      if(weeklyAllowance >= TWO_SCOOP_COST && weeklyAllowance < THREE_SCOOP_COST)
         System.out.println("The girl can buy max two scoops");
      
      if(weeklyAllowance >= THREE_SCOOP_COST)
         System.out.println("The girl can buy max three scoops");
      
      if(weeklyAllowance > ONE_SCOOP_COST)
         System.out.println("The girl can't buy shit");
       
      input.close();
   }
   
   public static void uppgift4()
   {
      final int LUNCH_START = 1200;
      final int LUNCH_END = 1300;
      
      int currentTime;
      Scanner input = new Scanner(System.in);
      
      System.out.print("Insert current time: ");
      
      currentTime = input.nextInt();
      input.close();
      
      //LÖSNING 1
      /*if(currentTime >= LUNCH_START && currentTime <= LUNCH_END)
         System.out.println("It's lunch");
      else
         System.out.println("It's not lunch");*/
      
      //LÖSNING 2
      if(currentTime >= LUNCH_START)
      {
         if(currentTime <= LUNCH_END)
         {
            System.out.println("It's lunch");
            return;
         }
         else
            System.out.println("It's not lunch");
      }
      else
         System.out.println("It's not lunch");
      
   }

   public static void uppgift5()
   {
      Boolean isMale = false;
      Boolean isFemale = true;
      
      if(isMale ^ isFemale) //If one of these are true
         System.out.println("Enkönad");
      else if(isMale && isFemale) //If both are true 
         System.out.println("Hermafroditer");
   }
   
   public static void uppgift6()
   {
      int number;
      Scanner input = new Scanner(System.in);
      
      System.out.print("Enter an integer: ");
      number = input.nextInt();
      
      while(number >= 0)
      {
         System.out.println("Enter a new integer that is less than 0");
         number = input.nextInt();
      }
      
      System.out.println("You did it !");
      input.close();
   }
   
   public static void uppgift7()
   {
      Scanner userInput = new Scanner(System.in);
      int tal = 0;
      
      do
      {
        System.out.print("Mata in ett heltal: ");
        tal = userInput.nextInt();
        System.out.println("Talet: " + tal);
      } while(tal >0); 
      
      userInput.close();
   }
   
   public static void uppgift8()
   {
      int i = 0;
      
      while(i < 10) 
      {
         i++;
         System.out.println("Kärlek, kärlek överallt " + i);

         ++i;
         System.out.println("Kärlek, kärlek överallt " + i);
      }
   }
      
   public static void uppgift9()
   {  
      int i = 0;
      
      for(; i < 10;) 
      {
         System.out.println("Kärlek, kärlek överallt " + i);
         i++;
      }

   }
   
   public static void uppgift10()
   {  
      //Starts with A
      char alpha = '\u0041';
      
      for(int i = 0; i < 52; i++) 
      {
         System.out.println(alpha + " " + '\u2129');
         if(alpha > '\u0059' && alpha < '\u0061')
            alpha = '\u0061';
         else
            alpha++;
      }
      
   }
   
}
