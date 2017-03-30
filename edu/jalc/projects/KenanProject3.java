/*Kenan Jones        10-03-2016
This program allows a user to order a pizza.
The user specifies the size, crust, and toppings they want,
and the program calculates the cost and displays everything on the screen.*/
import java.util.Scanner;
import javax.swing.JOptionPane;
public class KenanProject3
{
   public static void main (String[] args)
   {
   Scanner keyboard = new Scanner(System.in);
   
   JOptionPane.showMessageDialog(null,"Welcome to Mike and Diane's Pizza");
   String name = JOptionPane.showInputDialog(null,"What is your first name?");
   System.out.println("Pizza size (inches)    Cost");
   System.out.printf("%8d%20s\n%8d%20s\n%8d%20s\n%8d%20s\n",
                     10,"$10.00",12,"$12.00",14,"$14.00",16,"$16.00");
   
   Object[] sizes = {"10 inch    ----------      $10.99","12 inch    ----------      $12.99",
            "14 inch    ----------      $14.99","16 inch    ----------      $16.99"};
   Object sizeChosen = new Object();
   boolean test = true;
   //exception handling loop
   while(test){
      sizeChosen = JOptionPane.showInputDialog(null, "What size pizza would you like?",
                  "Mike and Diane's",3, null, sizes, null);
      if(sizeChosen == null){JOptionPane.showMessageDialog(null,"Please enter a size");}
      else {test = false;}
      }
   String size = sizeChosen.toString();
   double cost = 0;
   switch(size){
      case "10 inch    ----------      $10.99":cost += 10.99;size = "10 inch";break;
      case "12 inch    ----------      $12.99":cost += 12.99;size = "12 inch";break;
      case "14 inch    ----------      $14.99":cost += 14.99;size = "14 inch";break;
      case "16 inch    ----------      $16.99":cost += 16.99;size = "16 inch";break;
   }
   String crustletter = JOptionPane.showInputDialog(null,String.format("Do you want hand-tossed, " +
         "thin, or deep-dish crust?\n%32s%20s%20s","(H)","(T)","(D)"));
   String crust = "";
   if(crustletter.equalsIgnoreCase("t")){crust = "thin crust";}
   else if(crustletter.equalsIgnoreCase("d")){crust = "deep dish";}
   else{crust = "hand tossed";}
   
   JOptionPane.showMessageDialog(null,"All Pizzas come with cheese.");
   
   String toppings = "cheese";
   Object[] optionTop = {"sausage","mushroom","peperoni","onion"};
   test = true;
   int toppingCount = 0;
   
   while(test){
   Object topping = JOptionPane.showInputDialog(null, "Select a topping.",
                  "Mike and Diane's",3, null, optionTop, null);
   if(topping != null)
      {toppings = toppings + ", " + topping.toString();
      toppingCount += 1;}
   else{test = false;}
   }
   boolean discount = false;
   if(name.equalsIgnoreCase("mike")){discount = true;}
   if(name.equalsIgnoreCase("diane")){discount = true;}
   
   cost += (toppingCount * 1.25);
   if(discount){cost -= 2.0;}
   double tax = cost * 0.08;
   cost += tax;
   
   JOptionPane.showMessageDialog(null,String.format("Your order is as follows:\n" +
      size + " " + crust + " pizza\nToppings:\n" + toppings +
      "\nYour Total Bill is $%,.2f",cost));
   JOptionPane.showMessageDialog(null,"Your order will be ready for pickup in 30 minutes.");
   }
}