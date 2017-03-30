/*Kenan Jones 11-17-16
This program allows the user to enter grades until they close the input window,
then it prints the scores to the screen,
prints the scores after sorting them in decending order,
and prints the mean of the scores.*/

import javax.swing.*;

public class KenanProject7
{
private static double[] numbers = new double[0];
   
   //main method shows program flow: enter, print, sort, calculate mean
   public static void main (String[] args)
   {
   enterGrades();
   System.out.println("Here are the scores you entered:");
   printArray(numbers);
   System.out.println("Sorted in decending order:");
   selectionSort(numbers);
   System.out.printf("The mean is %,.2f", calcMean(numbers));
   }
      //allows the user to enter grades in the outer loop,
      //and calls addNumber each time.
   public static void enterGrades()
   {
   int count = 1;
   boolean test1 = true;
   while(test1)
      {
      boolean test2 = true;
      while(test2)   //an exception handling loop
         {
         String score = JOptionPane.showInputDialog(null,
            "enter score number " + (count) + "\n Or close to stop.");
         try
            {
            addNumber(Double.parseDouble(score));
            test2 = false;
            }
         catch(NumberFormatException e)   //ask the user to enter valid input
            {JOptionPane.showMessageDialog(null,"invalid input");}
         catch(NullPointerException ex)   //end both loops because there are no more scores
            {test1 = false; test2 = false;}
         }
      count++;
      }
   }
      //sorts the array and calls printArray once it is done
   public static void selectionSort(double[] array)
   {
   int startScan, index, minIndex;
   double minValue;
   
   for (startScan = 0; startScan < (array.length-1); startScan++)
      {
      minIndex = startScan;
      minValue = array[startScan];
      for(index = startScan + 1; index < array.length; index++)
         {
         if (array[index] < minValue)
            {
            minValue = array[index];
            minIndex = index;
            }
         }
      array[minIndex] = array[startScan];
      array[startScan] = minValue;
      }
   printArray(array);
   }
      //prints each value of the array on one line with commas separating them
   public static void printArray(double[] array)
   {
   for(double value: array)
      {
      System.out.print(value + ", ");
      }
   System.out.println();
   }
      //finds the total of the numbers in the array and divides by the length of the array
   public static double calcMean(double[] array)
   {
   double total = 0;
   for(double value: array)
      {
      total += value;
      }
   return total/array.length;
   }
      //increases the length of numbers by one and put the parameter in the new space.
   public static void addNumber(double num)
   {
   double[] values = numbers;
   numbers = new double[values.length + 1];
   for(int i = 0; i < values.length; i++)
      {
      numbers[i] = values[i];
      }
   numbers[numbers.length - 1] = num;
   }
}