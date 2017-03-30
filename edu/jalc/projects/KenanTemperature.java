/*Kenan Jones 11-15-2016
this program prompts the user to enter 5 Fahrenheit temperatures
and displays the temperatures entered and their celcius equivalents in a table.*/

import javax.swing.*;

public class KenanTemperature
{
private static final int length = 5; //the number of temperatures
private static double[] fTemp; //the Fahrenheit temperatures
private static double[] cTemp; //the Celsius temperatures

   public static void main (String[] temp)
   {
   fTemp = new double[length]; //initialize the array
   
   enterTemps(fTemp); //allows the user to enter values
   
   String display = "   Fahrenheit           Celsius\n=========================\n";
   
   for(int i = 0; i < length; i++)
      {
      display += String.format("%10.2f%35.2f\n",fTemp[i],cTemp[i]); //add a line to the table
      }
   JOptionPane.showMessageDialog(null,display,"Temperature Calculator",-1); //display the table
   }
      //prompts the user to enter a Fahrenheit temperature *length* times
   public static void enterTemps(double[] temps)
   {
   cTemp = new double[length];
   double temp = 0;
   
   for(int i = 0; i < length; i++)
      {
      boolean test = true;
      while(test)
         {
         String input = JOptionPane.showInputDialog(null, String.format(
            "Please enter Fahrenheit temperature number %d", i+1));
         try
            {
            temp = Double.parseDouble(input);
            test = false; //don't execute the while loop, execute the for loop
            }
         catch(NumberFormatException | NullPointerException e)
            {} //if the catch is activated, the while loop executes again
         }
      temps[i] = temp;
      cTemp[i] = celsius(temps[i]);
      }
   }
      //requires a Fahrenheit temp, returns a Celsius temp.
   public static double celsius(double f)
   {
   return 5.0/9.0*(f-32);
   }
}