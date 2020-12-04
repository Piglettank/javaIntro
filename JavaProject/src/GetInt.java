import java.util.Scanner;

public class GetInt
{

   static Scanner userInput = new Scanner(System.in);
   
   public static void main(String[] args)
   {
   // in the main you will have something
      Boolean something = true;
      int rad = 0;
      int heigth = 0;

      while(something)
      {
      rad = getInt();

      if (rad == Integer.MAX_VALUE)
         break;

      heigth = getInt();

      if (heigth == Integer.MAX_VALUE)
         break;

      System.out.println("rad: " + rad + " height: " + heigth);
      }
      
   }

   public static int getInt()
   {
      
      String str;
      int number ;
      number = Integer.MAX_VALUE;
      while (true)
      {
         if (userInput.hasNextInt())
         {
            number = userInput.nextInt();
            return number;
         }
         else
         {
            if(userInput.hasNext())
            {
               str = userInput.next();
               if (str.equals("q"))
               {
                  userInput.nextLine();
                  return number;
               }
            }

         }

      } // while true

   }
}
