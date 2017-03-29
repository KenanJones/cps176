import java.util.Scanner;

public class charIdentifier
{
   public static void main (String[] args)
   {
   
   Scanner keyboard = new Scanner(System.in);
   
   int number, code;
   char letter;
   String words = new String();
   boolean test = true;
   
   System.out.println("Enter character codes one at a time.\nType exit to exit.");
   
   while(test)
   {
      words = keyboard.nextLine();//get user input
      if (words.equalsIgnoreCase("exit"))test = false;//test for exit code
      else//if the exit code was not activated, run identifier
      {
      number = Integer.parseInt(words);//get the input number
      letter = (char)number;//cast as a char
      System.out.println("the number " + number + " stands for the character " + letter);
   }}
   
   System.out.println("Enter characters one at a time.\nType exit to exit.");
   
   test = true;
   while(test) //keep going until the break
   {
      words = keyboard.nextLine();  //get user input (the directions say one character)
      if (words.equalsIgnoreCase("exit")) test = false;
      else
      {
      code = words.codePointAt(0);  //get the unicode for the first character
      letter = words.charAt(0);     //get the first character itself
      System.out.println("The charater code " + code + " stands for " +  letter + ".");
   }}
   System.out.print("Thank you for using Character Identifier!");
   
   }
}