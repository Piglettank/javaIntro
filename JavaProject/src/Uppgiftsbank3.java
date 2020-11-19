import java.util.Scanner;


/**
 * 
 * @author Johan Fallberg, ojaafe-0
 *
 */
public class Uppgiftsbank3
{


   public static void main(String[] args)
   {
      int taskChosen = 0;
      String[] restart = new String[0];
      
      //Prompt: Asking for task
      System.out.println("Uppgiftsbank 3: \n");
      System.out.println("Vilken uppgift vill du kolla? \n");
      
      //Input
      Scanner task = new Scanner(System.in);
      try 
      {
         taskChosen = task.nextInt();
      }
      catch(java.util.InputMismatchException e) 
      {
         System.out.println("That ain't no number, dumbass!\n");
         main(restart);
      }
      
      //Choose task based on input
      if(taskChosen == 1)
      {
         uppgift1();
      }
      else if(taskChosen == 2)
      {
         uppgift2();
      }
      else
      {
         uppgift3();
      }
      
      task.close();
      
   }

   public static void uppgift1()
   {
    //Declaring variables
      String printLine = "";
      String inputtedText = "";
      
      Scanner input = new Scanner(System.in);

      
      //Prompt
      System.out.println("Skriv in sökvägen: ");

      //Input
      inputtedText = input.nextLine();
      input.close();
      
      //Create a new scanner using the input text 
      Scanner storedInput = new Scanner(inputtedText);
      storedInput.useDelimiter("[\\\\:]+");
      
      
      //Create a string by adding all the tokens of the input text together. 
      while(storedInput.hasNext())
      {
         printLine = printLine + storedInput.next() + "\n";
      }
      
      //Output
      System.out.println(printLine);
      
      
      storedInput.close();
   }
   
   private static void uppgift2()
   {
      
      int age;
      String name;
    
      Scanner userInputAge = new Scanner(System.in);
      Scanner userInputName = new Scanner(System.in);

      
      System.out.print("Skriv in din ålder: ");
      age = userInputAge.nextInt();
      
         
      System.out.print("Skriv in ditt namn: ");
      name = userInputName.nextLine();
      //gets input from the first line since it was using the same scanner?
      
      System.out.println("Du heter " + name + " och är " + age + " år");  
   
      userInputName.close();
      userInputAge.close();
      
   }
   
   private static void uppgift3()
   {
      // Declaration and initialization of characters 
      char firstChar = '\u0041', secondChar='\u006E',
            thirdChar = 110, fourthChar = 97;
    
         // Print concatenated string 
      System.out.println("Den sammanslagna strängen blir : "
          + firstChar + secondChar + thirdChar + fourthChar);
   }
   
      public static void interest(){
         double amount;// amount on deposit at end of each year
         double principal = 1000.0; // initial amount before interest 
         double rate = 0.05;// interest rate 
         // display headers 
         System.out.printf("%s%20s%n","Year","Amount on deposit");
         //calculate amount on deposit for each of ten years
         for(int year =1; year <=10; ++year){ // calculate new amount for specified year
            amount = principal * Math.pow(1.0+ rate, year);
            
            // display the year and the amount
            System.out.printf("%4d%,20.2f%n", year, amount);
         }
   }
}
