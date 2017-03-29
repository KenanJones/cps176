import java.util.Scanner;

public class forfun2
{
   public static void main (String[] args)
   {
            
   int number, date, code;
   Scanner keyboard = new Scanner(System.in);
   System.out.println("what year is it?");
   date = keyboard.nextInt();
   keyboard.nextLine();
   
   System.out.println("please enter a character.");
   String words = new String(keyboard.nextLine());
   code = words.codePointAt(0);
   char letter = words.charAt(0);
      
   System.out.println("enter a number");
   number = keyboard.nextInt();
   
   if(7 > number) number *= (number + 5);
   else {
      number += (date - 2000);
      if (number > 65)
      number -= 75;
         }
   double number2 = Math.pow(number , 2);
   System.out.print("The result is " + number + ".  ");
   System.out.println("The charater code " + code + " stands for " +  letter + ".");
   System.out.println(number + " squared = " + number2);
   }
}