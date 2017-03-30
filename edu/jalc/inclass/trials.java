import javax.swing.*;
/**This class determines the letter grade you received by using nested
if statements on your numeric score.*/
public class trials
{
   public static void main (String[] exit)
   {
   char grade;
   
   String pointsString = JOptionPane.showInputDialog(null, "How many points did you earn?");
   double points = Double.parseDouble(pointsString);
   String possibleString = JOptionPane.showInputDialog(null, "How many possible points was the test?");
   double possible = Double.parseDouble(possibleString);
   double score = points/possible*100;
   
   if(score >= 90)
   {grade = 65;}
   else if(score >= 80)
   {grade = 66;}
   else if(score >= 70)
   {grade = 67;}
   else if(score >= 60)
   {grade = 68;}
   else{grade = 70;}
   
   JOptionPane.showMessageDialog(null,"You got " + score + "%\nYour grade is " + grade);
   //this ends without a System.exit(0);
   }
}