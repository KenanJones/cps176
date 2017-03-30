/*Kenan Jones 10-12-2016
This is my second version of the pizza ordering program.
it gets the user's name, the size, crust, and toppings they want,
and displays this information with the price for confirmation*/
import javax.swing.*;

public class PizzaOrder2
{
   public static void main (String[] pizza)
   {
   String name = JOptionPane.showInputDialog(null,"What is your first name?","Mike and Diane's",3);
   
      //the sizes and prices that go in the drop down menu
   Object[] sizes = {"10 inch    ----------      $10.99","12 inch    ----------      $12.99",
            "14 inch    ----------      $14.99","16 inch    ----------      $16.99"};
   
   Object sizeChosen = new Object();
   boolean test = true;
   
      //exception handling loop that executes until a size is chosen
   while(test){
      sizeChosen = JOptionPane.showInputDialog(null, "What size pizza would you like?",
                  "Mike and Diane's",3, null, sizes, null);
      if(sizeChosen == null){JOptionPane.showMessageDialog(null,
         "Please enter a size","Mike and Diane's",1);}
      else {test = false;}
      }
   String size = sizeChosen.toString();//the size as a string
   double cost = 0;//initilize the cost variable
   
      //put the base cost in cost and define size as simply a number
   if(size.equals("10 inch    ----------      $10.99")){cost = 10.99; size = "10";}
   else if(size.equals("12 inch    ----------      $12.99")){cost = 12.99; size = "12";}
   else if(size.equals("14 inch    ----------      $14.99")){cost = 14.99; size = "14";}
   else if(size.equals("16 inch    ----------      $16.99")){cost = 16.99; size = "16";}
   
      //this string should be a single letter
   String chosenCrust = JOptionPane.showInputDialog(null,String.format("Do you want " +
      "hand-tossed, thin, or deep-dish crust?\n%32s%19s%20s","(H)","(T)","(D)"),"Mike and Diane's",3);
      //the default crust is 'h' - the hand tossed crust
   char crustletter = 'h';
      
      //if the user entered something, define crustletter as the first letter of the string
      //otherwise, tell the user that the default, hand tossed crust, has been chosen
   if(chosenCrust != null){
   if(!chosenCrust.equals("")){crustletter = chosenCrust.charAt(0);}
   else{JOptionPane.showMessageDialog(null,"Invalid Choice.\n" +
         "Default choice is Hand Tossed crust.","Mike and Diane's",1);}}
      
      //initialize the crust field with the crust letter
   String crust = "" + crustletter;
   
      //fill the crust field with its proper value and
      //display a message telling the user if the default value is used
   switch(crust){
      case"t":
      case"T":crust = "thin crust";break;
      case"d":
      case"D":crust = "deep dish";break;
      case"h":
      case"H":crust = "hand tossed";break;
      default: crust = "hand tossed";
      JOptionPane.showMessageDialog(null,"Invalid Choice.\n" +
         "Default choice is Hand Tossed crust.","Mike and Diane's",1);break;
      }
   String chosenTopp = "cheese";
   Object[] toppings = {"sausage","pepperoni","mushroom","onion","green pepper"};
   test = true;
   int toppingCount = 0,topp = 0;
   while(test){
      toppings = arrayMaker(toppings);
      topp = JOptionPane.showOptionDialog(null,"Select a topping to add. Close when finished.",
         "Mike and Diane's",0,3,null,toppings,null);
      if(topp == -1){test = false;}
      else{
      chosenTopp += ", " + toppings[topp];
      toppings[topp] = null;
      toppingCount++;
      }}
   double baseCost = cost;
   cost += (toppingCount * 1.25);
      //if name is empty you don't get a discount.
      //if it contains something, then compare to see if you get a discount.
   boolean discount = false;
   if(name != null)
      {
      if(name.equalsIgnoreCase("Mike")){discount = true;}
      if(name.equalsIgnoreCase("Diane")){discount = true;}
      }
      //add the tax
   double tax = cost * 0.08;
   cost += tax;
      
      //the discount string is displayed every time.
      //it is empty unless discount is true.
   String discountStr = "";
   if(discount){cost -= 2.0;discountStr = "Your $2 discount has been applied!\n";}
   
   JOptionPane.showMessageDialog(null,String.format("Your order is as follows:\n" +
      "%s inch %s pizza\nToppings:\n%5s%s.\nBase Cost:%37.2f\n" +
      "Toppings:%40.2f\n%sTax:%50.2f\nYour Total Bill is $%,.2f",
      size,crust," ",chosenTopp,baseCost,toppingCount * 1.25,discountStr,tax,cost),"Mike and Diane's",-1);
   
   JOptionPane.showMessageDialog(null,
      "Your order will be ready for pickup in 30 minutes.","Mike and Diane's",-1);
   
   System.exit(0);
   }
   //this method takes any array and returns an array that contains all the 
   //elements of the old array without any null values.
   public static Object[] arrayMaker (Object[] start)
   {
   int count = 0;//the length without null elements counted
   for(int i = 0; i < start.length; i++){
      if(start[i] != null)
         {count += 1;}}//increment count if something is in the array at that position

   Object[] finish = new Object[count];//new array of proper length
   int k = 0; // a counter
   for(int j = 0; j < start.length; j++){// fill the new array
      if(start[j] != null)
         {finish[k] = start[j];
         k++;}}
   return finish;//return the finished array
   }
}