/*Kenan Jones 10-04-16
this program allows the user to order a pizza.
the user specifies the size, crust type, and toppings.
program flow:
main - PizzaOrder constructor - ButtonListener - costCalc - finishOrder*/

//please note that if you close the topping seltion window,
//the program will continue to execute but you will not be able to do anything else.

import javax.swing.*;
import java.awt.event.*;

//this class will get all the information needed and display it.
public class PizzaOrder extends JFrame implements ActionListener
{
//lots of fields!
private String name;
private String size;
private String crust;
private double cost;
private double baseCost;
private double tax;
private String toppings;
private int toppingCount;
private boolean discount;
private String discountStr;
private JPanel menu;
private JLabel label;
private JCheckBox topp1;
private JCheckBox topp2;
private JCheckBox topp3;
private JCheckBox topp4;
private JButton button;
   
   //the constructer gets the user's name and the pizza size and crust type.
   //it then calls the buildPanel method and brings up a JPanel to get the toppings
   public PizzaOrder()
   {
   //the user's name
   name = JOptionPane.showInputDialog(null,"What is your first name?","Mike and Diane's",3);
   
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
   size = sizeChosen.toString();//the size as a string
   cost = 0;//initilize the cost field
   
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
   if(chosenCrust != null){crustletter = chosenCrust.charAt(0);}
   else{JOptionPane.showMessageDialog(null,"Invalid Choice.\n" +
         "Default choice is Hand Tossed crust.","Mike and Diane's",1);}
      
      //initialize the crust field with the crust letter
   crust = "" + crustletter;
   
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
   
      //builds a panel
   setTitle("Mike and Diane's");
   setIconImage(null);
   setSize(450,150);
   setLocationRelativeTo(null);
   buildPanel();
   add(menu);
   setVisible(true);
   }
   //builds a panel containing a label, 4 check boxes, and a button that closes the panel
   private void buildPanel()
   {
      //make the components
   label = new JLabel("All pizzas come with cheese.\n" + 
      "Select additional toppings for $1.25 each.");
   topp1 = new JCheckBox("Sausage");
   topp2 = new JCheckBox("Pepperoni");
   topp3 = new JCheckBox("Mushroom");
   topp4 = new JCheckBox("Onion");
   button = new JButton("Select Toppings");
   
      //add an action listener to the button only!
   button.addActionListener(this);//(new ButtonListener());
   
      //add the components to the panel
   menu = new JPanel();
   menu.add(label);
   menu.add(topp1);
   menu.add(topp2);
   menu.add(topp3);
   menu.add(topp4);
   menu.add(button);
   }
   //calculates the cost so that it can be displayed in the finishOrder method
   public void costCalc()
   {
   baseCost = cost;
   cost += (toppingCount * 1.25);
      //if name is empty you don't get a discount.
      //if it contains something, then compare to see if you get a discount.
   if(name != null)
      {
      if(name.equalsIgnoreCase("Mike")){discount = true;}
      if(name.equalsIgnoreCase("Diane")){discount = true;}
      }
      //add the tax
   tax = cost * 0.08;
   cost += tax;
      //call the finish order method
   finishOrder();
   }
   //displays the order summary for the user to confirm
   public void finishOrder()
   {
      //the discount string is displayed in the finishOrder method every time.
      //it is empty unless discount is true.
   discountStr = "";
   if(discount){cost -= 2.0;discountStr = "Your $2 discount has been applied!\n";}
   
   JOptionPane.showMessageDialog(null,String.format("Your order is as follows:\n" +
      "%s inch %s pizza\nToppings:\n%5s%s.\nBase Cost:%37.2f\n" +
      "Toppings:%40.2f\n%sTax:%50.2f\nYour Total Bill is $%,.2f",
      size,crust," ",toppings,baseCost,toppingCount * 1.25,discountStr,tax,cost),"Mike and Diane's",-1);
   
   JOptionPane.showMessageDialog(null,
      "Your order will be ready for pickup in 30 minutes.","Mike and Diane's",-1);
   
   System.exit(0);
   }
   //the action listener detects when the user clicks the select toppings button,
   //determines which checkboxes are selected at that time,
   //hides the panel, and calls the costCalc method.
   public void actionPerformed(ActionEvent e)
   {
      //all pizzas come with cheese
   toppings = "Cheese";
   toppingCount = 0;
  
      //for each box, if it's selected, increment toppingCount,
      //and add the selected topping to the toppings string.
   if(topp1.isSelected()){toppingCount ++;toppings = toppings + ", Sausage";}
   if(topp2.isSelected()){toppingCount ++;toppings = toppings + ", Pepperoni";}
   if(topp3.isSelected()){toppingCount ++;toppings = toppings + ", Mushroom";}
   if(topp4.isSelected()){toppingCount ++;toppings = toppings + ", Onion";}
      //hide the panel
   setVisible(false);
      //call the cost calc method
   costCalc();
   }
   //welcomes the user and makes a new pizza order object
   public static void main(String[] args)
   {
   JOptionPane.showMessageDialog(null,"Welcome to Mike and Diane's Pizza","Mike and Diane's",-1);
      
   new PizzaOrder();
   }
}
