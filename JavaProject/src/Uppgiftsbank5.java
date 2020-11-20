
/**
 * 
 * @author Johan Fallberg, ojaafe-0
 */
public class Uppgiftsbank5
{

   public static void main(String[] args)
   {
      uppgift2();
   }
   
   public static void uppgift1()
   {
      int[] c = {1, 3, 7, 13, 11};
      
      System.out.printf("%s %9s %n", "Index", "Value");
      for(int i = 0; i < c.length; i++)
      {
         System.out.printf("%5d %9d %n", i, c[i]);
      }
      
      System.out.println("First number in array: " + c[0]);
      System.out.println("Last number in array: " + c[c.length-1]);
   }

   public static void uppgift2()
   {
      int[] itemId = {0, 1, 2, 3, 4};
      double[] itemPrice = {10.0, 15.0, 24.0, 20.0, 50.0};
      String[] itemName = {"Satsuma", "Apples", "Banana", "Sauce", "Quorn"};
      int[] itemAmount = {24, 55, 34, 10, 40};
      
      System.out.printf("%7s%13s%13s%13s%n", "Item ID", "Name", "Price", "Amount");
      System.out.println("==============================================");
      
      for(int number : itemId)
      {
         System.out.printf(
               "%7d" 
               + "%13s" 
               + "%10.2f kr"
               + "%10d st"
               + "%n", 
               itemId[number], 
               itemName[number],    
               itemPrice[number], 
               itemAmount[number]);
      }
   }
   
   public static void uppgift3()
   {
      Boolean sorted;
      double[] myList = {5, 2, 1, 10, 40, 3};
      
      do 
      {
         sorted = true;
         
         for(int i = 0; i < myList.length-1; i++)
         {
            if(myList[i] > myList[i+1])
            {
               SwapElements(myList, i);
               sorted = false;
            }
         }
      } while(!sorted);
      
      for(int count = 0; count < myList.length; count++)
         System.out.println((count + 1) + ": " + myList[count]);
      
      
   }
   
   public static void SwapElements(double[] list, int index)
      {
         double higherValue = list[index];
         list[index] = list[index+1];
         list[index+1] = higherValue;
         
      }
   
}
