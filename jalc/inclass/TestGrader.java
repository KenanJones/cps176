import java.util.Scanner;
import javax.swing.JOptionPane;

public class TestGrader
{
   public static void main (String[]args)
   {
   int score, possible;
   double percent;
   /*//make a scanner object and get the required input
   Scanner keyboard = new Scanner(System.in);
   
   System.out.println("What is the student's name?");
   String name = keyboard.nextLine();
   System.out.println("How many points did the student earn?");
   score = keyboard.nextInt();
   System.out.println("How many possible points was the test?");
   possible = keyboard.nextInt();
   
   percent = score * 100.0 / possible;
   percent = Math.round(percent); //your number has 2 decimal places
   //now display everything in the proper format
   System.out.println("\nStudent Name: " + name);
   System.out.println("\nPoints Earned: " + score);
   System.out.println("\nTotal Points Possible: " + possible);
   System.out.println("\nGrade for the test: " + percent +
                      "%");*/
   String name = JOptionPane.showInputDialog("What is the student's name?");
   String points = JOptionPane.showInputDialog("How many points did the student earn?");
   score = Integer.parseInt(points);
   String possPoints = JOptionPane.showInputDialog("How many possible points was the test?");
   possible = Integer.parseInt(possPoints);
   percent = (int)(score * 100.0 / possible);
   JOptionPane.showMessageDialog(null,"Student Name: " + name + "\n\nPoints Earned: " + score +
      "\n\nTotal Points Possible : " + possible + "\n\nGrade for the test: " + percent);
   }
}