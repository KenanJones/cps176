import java.util.Scanner;

public class forfun1_2
{
   public static void main (String[] party)
   {
   boolean answer;
   int birthYear, age, year, number1;
   Scanner keyboard = new Scanner(System.in);
   
   System.out.println("what year is it?");
   year = keyboard.nextInt();
   
   System.out.println("What year were you born?");
   birthYear = keyboard.nextInt();
   System.out.println("How old are you?");
   age = keyboard.nextInt();
   
   if((birthYear + age) > year)
      System.out.print("It looks like you made a mistake.\nPlease try again.\n");
   else if((birthYear + age) < (year - 1))
      System.out.print("It looks like you made a mistake.\nPlease try again.\n");
   else {
   
   /*if(birthYear > 1946)
      answer = true;
   else answer = false;
   System.out.println(answer + " statement:");*/
   
   if(age > 45)
      System.out.println("you are very old!");
      
   System.out.println("You are " + age + " years old.");
   if(age > 65)
      System.out.println("But you are still young at heart.");
      
   if(birthYear < 2000){
      if(birthYear > 1899)
      System.out.println("You were born in the 20th century.");
      else System.out.println("You were born in the 19th century.");
                        }
   else System.out.println("You were born in the 21th century.");
      }
    
   }
           
 }