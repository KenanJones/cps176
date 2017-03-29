/*Kenan Jones 10-28-2016
this program rolls two dice 10000 times each in the roll dice method.
it then determines how many doubles of each number were rolled.
it uses a while loop first, then a do-while, then a for loop.
at the end, the results of all the loops are displayed*/
import java.util.*;
import javax.swing.*;
import java.io.*;

public class KenanDieProject
{
private static final int MAX = 10000;

private static int ones = 0;
private static int twos = 0;
private static int threes = 0;
private static int fours = 0;
private static int fives = 0;
private static int sixes  = 0;

private static int die1;
private static int die2;

private static Random die = new Random();

   public static void main (String[] dice) throws IOException
   {
   Random die = new Random();
   
   String whileString;
   String doWhileString;
   String forString;
   
      //the while loop
   int i = 0;
   while(i < MAX)
      {
      i++;
      rollDice();
      }
   
   whileString = getString("while");
   
   ones = 0; twos = 0; threes = 0;
   fours = 0; fives = 0; sixes = 0;
   
      //the do-while loop
   i = 0;
   do
      {
      i++;
      rollDice();
      }
   while(i < MAX);
   
   doWhileString = getString("do while");
   
   ones = 0; twos = 0; threes = 0;
   fours = 0; fives = 0; sixes = 0;
   
      //the for loop
   for(i = 0; i < MAX; i++)
      {
      rollDice();
      }
   forString = getString("for");
      
   JOptionPane.showMessageDialog(null,whileString + "\n" + doWhileString + "\n" + forString);
   }
   
   public static void rollDice()
   {
   die1 = die.nextInt(6) + 1;
   die2 = die.nextInt(6) + 1;
   if(die1 == die2)
      {
      if(die1 == 1 && die2 == 1)
         {ones++;}
      else if(die1 == 2 && die2 == 2)
         {twos++;}
      else if(die1 == 3 && die2 == 3)
         {threes++;}
      else if(die1 == 4 && die2 == 4)
         {fours++;}
      else if(die1 == 5 && die2 == 5)
         {fives++;}
      else if(die1 == 6 && die2 == 6)
         {sixes++;}
      }
   }
   
   public static String getString(String type)
   {
   String returnString = String.format("In %,d rolls,\nthe %s loop generated:\n" +
      "%8d double ones\n%8d double twos\n%8d double threes\n%8d double fours" +
      "\n%8d double fives\n%8d double sixes",MAX,type,ones,twos,threes,fours,fives,sixes);
   return returnString;
   }
}
