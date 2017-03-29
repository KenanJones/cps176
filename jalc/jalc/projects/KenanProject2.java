/*Kenan Jones 09-14-16 this program perform 4 tasks:
1. calculates the volume of a sphere, 2. gets the user's full name,
3. uses string tools on the name, 4. uses jOptionPane to get the user's name.
I added a bonus fifth task to properly format the user's name.*/

import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class KenanProject2
{
   public static void main (String[] project)
   {
   //Task # 1: calulate the volume of a sphere using the math class and the diameter from keyboard input
   
   Scanner keyboard = new Scanner(System.in);   //create a scanner object
   double diameter, radius, volume;
   
   System.out.print("Please enter the diameter of a sphere:   ");
   diameter = keyboard.nextDouble(); keyboard.nextLine();
   //the second one elimates the return character so any nextline in the future works
   
   radius = diameter / 2;
   volume = 4.0 / 3.0 * Math.PI * Math.pow(radius,3); //the formula for the volume of a sphere
   System.out.println("The volume of the sphere is " + volume + ".");
   
   //Task # 2: asks the user to input their first and last names and then returns their full name
   
   System.out.print("what is your first name?   ");
   String firstName = new String(keyboard.nextLine());   //gets the user's first name
   System.out.print("what is your last name?   ");
   String lastName = new String(keyboard.nextLine()); //gets the user's last name
   String fullName = new String(firstName + " " + lastName);//remember the space
   System.out.println(fullName);
   
   //Task # 3: prints the user's initials and full name in uppercase letters
   
   char firstInitial = firstName.charAt(0);  // finds the first letter in the first name
   char lastInitial = lastName.charAt(0);    // finds the first letter in the last name
   int length = fullName.length();           // finds the length of the full name (with the space)
   fullName = fullName.toUpperCase();        // stores full name in all capital letters
   System.out.print("There are " + length + " characters in " + fullName +
                      ".\nYour initials are " + firstInitial + " " + lastInitial);
   
   //Task # 4: uses JOptionPanes to get the user's name and display it
   
   JFrame frame = new JFrame();
   //gets the first and last names with pop-ups:
   //I used the same variable names so I don't need to define more
   firstName = JOptionPane.showInputDialog(frame, "what is your first name?");
   lastName = JOptionPane.showInputDialog(frame, "what is your last name?");
   fullName = (firstName + " " + lastName);
   JOptionPane.showMessageDialog(frame, fullName);//display the full name in a pop-up
   
   //Bonus Task # 5: I want to get the name properly capitalized, even if the user doesn't enter it that way.
   
   firstName = firstName.toLowerCase();         //now all the letters are lower case
   String firstI = firstName.substring(0,1);    // a STRING first initial, not a char first initial
   String firstNameEnd = firstName.substring(1);// the rest of the name without the first initial
   firstI = firstI.toUpperCase();               //firstI is a string, so I can make it upper case
   firstName = (firstI + firstNameEnd);         // put the name back together properly capitilized
   
   //now do the same for the last name:
   lastName = lastName.toLowerCase();
   String lastI = lastName.substring(0,1);
   lastI = lastI.toUpperCase();
   String lastNameEnd = lastName.substring(1);
   lastName = (lastI + lastNameEnd);
   
   //now put the full name together and display it in a pop-up
   fullName = (firstName + " " + lastName);
   JOptionPane.showMessageDialog(frame, fullName);
   System.exit(0);   //the program doesn't end without this.
   
   }
}