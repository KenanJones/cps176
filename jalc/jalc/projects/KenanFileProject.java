/*Kenan Jones 10-27-16
This program reads numbers from a file,
calculates the mean and standard deviation of the numbers,
and prints the mean and standard deviation to a file.*/
import java.util.*;
import javax.swing.*;
import java.io.*;

public class KenanFileProject
{
   public static void main (String[] files)throws IOException
   {
   double total = 0;//the accumulator
   int count = 0;//the counter
   double mean;//the mean value
   double var;//the variance
   double stDev;//the standard deviation

   String filename = JOptionPane.showInputDialog(null,"Enter the input file name.");
   
   File file1 = new File(filename);
   Scanner inputFile1 = new Scanner(file1);
   
   while(inputFile1.hasNext())
      {
      double num = inputFile1.nextDouble();//read the next number
      total += num;//add the number to the total
      count++;
      }
   inputFile1.close();
   
   mean = total / count;
   
   File file2 = new File(filename);
   Scanner inputFile2 = new Scanner(file2);
   //reset the accumulator and counter
   total = 0;
   count = 0;
   double diff = 0;//the difference between the mean and the current value
   while(inputFile2.hasNext())
      {
      double num = inputFile2.nextDouble();
      diff = num - mean;
      total += diff * diff;//add the square of the difference to the total
      count++;
      }
   inputFile2.close();
   
   var = total / count;//the variance is the total divided by count
   stDev = Math.sqrt(var);//the standard deviation is the square root of the variance
   
   //print the mean and standard deviation to the file.
   filename = JOptionPane.showInputDialog(null,"Enter the output file name.");
   
   FileWriter fw = new FileWriter(filename,true);
   PrintWriter outputFile = new PrintWriter(fw);
   
   outputFile.println(String.format("The Mean is %.3f",mean));
   outputFile.println(String.format("The Standard Deviation is %.3f",stDev));
   
   outputFile.close();
   }
}