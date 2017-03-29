import java.util.Scanner;

public class Scam
{
   public static void main (String[] args)
   {
   int cardNumber, date, speed;
   
   Scanner keyboard = new Scanner(System.in);
   
   System.out.println("please enter the current year");
   date = keyboard.nextInt();
   
   System.out.println("where do you live?");
   keyboard.nextLine(); keyboard.nextLine();
   
   System.out.println("what is your favorite color?");
   String color = new String(keyboard.nextLine());
   
   System.out.println("what is the airspeed of an unlaiden swallow?");
   speed = keyboard.nextInt();
   
   System.out.println("Congratulations! your answers qualify you for a special offer!\n" +
            "Press enter to continue");
            keyboard.nextLine();
            keyboard.nextLine();
   System.out.println("Your personilized special offer is...\nA " +color +" " + date +
                      " V8 Ford Mustang convertable!");
   System.out.println("Press enter to continue");
   keyboard.nextLine();
   System.out.println("Oh no! an error has occured.\nBecause of your current location, " +
               "a $10 shipping fee must be applied.\n" +
               "Please enter your credit card number to continue."); 
   cardNumber = keyboard.nextInt();
   System.out.println("Thank you!\nYour new car is on the way!");
   System.out.println("Enter your favorite food for more special offers.");
   keyboard.nextLine(); keyboard.nextLine();
   System.out.println("Our supplier just notified us that your special offer is " +
            "no longer available.\nThe $5000 cancellation fee has been charged to " +
            "Credit card number " + cardNumber + ".");
   System.out.println("We are sorry for any inconvience this may have caused.");
   }
}