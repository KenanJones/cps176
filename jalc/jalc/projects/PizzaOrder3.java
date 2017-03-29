/* Kenan Jones 10-28-2016
This is my third pizza order program.
It allows the user to specify any number of pizza types,
which each have a size, crust type, topping list, and number of pizzas.
It brings up one big JFrame where the user can enter all the needed information.*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PizzaOrder3 implements ActionListener
{
   //contains each pizza ordered
private static PizzaOrder3[] pizzaTypes;

private String name;//the customer's name

//the fields that tell about the pizza:
private int number;        //the number of pizzas like this
private int size;          //the pizza size
private String crust;      //the pizza crust type
private String toppings;   //the pizza toppings
private int toppCount;     //the number of toppings
private double baseCost;   //determined by the size
private double toppCost;   //cost of the toppings
private double subTotal;   //(base cost + topping cost) times number
private double tax;        //the tax for each pizza
private double cost;       //the total cost of all the pizzas like this

//the fields that are used to diplay the main menu:
private JFrame frame;

private JPanel sizePanel;
private String[] sizeOptions;
private ButtonGroup sizeGroup;
private JRadioButton[] sizes;

private JPanel crustPanel;
private String[] crustOptions;
private ButtonGroup crustGroup;
private JRadioButton[] crusts;

private JPanel toppPanel;
private String[] toppOptions;
private JCheckBox[] boxes;

private JPanel numPanel;
private JLabel instruc;
private JTextField pizzaNum;

private JPanel costPanel;
private JLabel base;
private JLabel topp;
private JLabel sub;

private JPanel buttonPanel;
private JButton orderButton;
private GridBagConstraints c;
private JButton addButton;

private JPanel menu;
private int yc; //the y constraint
private int yCost; // the y constraint for the cost panel

//for the checkout frame:
private JFrame finalFrame;
private JPanel checkout;
private JLabel[] finish;
private String[] fin;
private JPanel buttons;
private JButton change;
private JButton addIt;
private JButton confirm;
private JPanel[] display;
private JPanel summary;
private JLabel discount1;
private JLabel discount2;
private JLabel costLabel;
private String dCount1;
private String dCount2;
private double discount;
   
      //Constructor
   public PizzaOrder3(String theName)
   {
   name = theName;
     
   //make the frame and add the content (in menu) to it.
   frame = new JFrame();
   frame.setLocation(400,300);
   frame.setTitle("Mike and Diane's");
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   buildPanel();
   frame.add(menu);
   frame.setSize(400,450);
   frame.setVisible(true);
   }
   
   //makes the sub panels and adds them to the main panel (menu)
   private void buildPanel()
   {
   //menu uses grid bag layout with weight of each component equal to one.
   menu = new JPanel(new GridBagLayout());
   c = new GridBagConstraints();
   c.gridx = 0; yc = 0;
   c.weightx = 1; c.weighty = 1;
   
      //the size panel
   c.gridy = yc; yc++;
   sizeOptions = new String[]{"10","12","14","16"};//the text for the buttons
   sizes = new JRadioButton[sizeOptions.length];//the buttons
   sizePanel = new JPanel();//the panel
   sizeGroup = new ButtonGroup();//group the buttons so only one can be selected at a time.
   for(int i = 0; i < sizeOptions.length; i++)
      {
      sizes[i] = new JRadioButton(sizeOptions[i] + " inch");
      sizes[i].setActionCommand("size");
      sizes[i].addActionListener(this);
      sizes[0].setSelected(true);//the default button
      sizeGroup.add(sizes[i]);
      sizePanel.add(sizes[i]);
      }
   menu.add(sizePanel,c);
   
      //the crust panel
   c.gridy = yc; yc++;
   crustOptions = new String[]{"hand tossed","thin","deep dish"};
   crusts = new JRadioButton[sizeOptions.length];
   crustPanel = new JPanel();
   crustGroup = new ButtonGroup();
   for(int i =0; i < crustOptions.length; i++)
      {
      crusts[i] = new JRadioButton(crustOptions[i] + " crust");
      crusts[0].setSelected(true);
      crustGroup.add(crusts[i]);
      crustPanel.add(crusts[i]);
      }
   menu.add(crustPanel,c);
   
      //the topping panel
   c.gridy = yc; yc++;
   toppOptions = new String[]{"sausage","pepperoni","mushroom","onion","green pepper",
      "pineapple","bacon","ham","sliced tomato","olives","extra cheese"};
   boxes = new JCheckBox[toppOptions.length];
      //this is a sub panel with a grid layout of three columns and any number of rows
   toppPanel = new JPanel(new GridLayout(0,3));
   for(int j = 0;j < toppOptions.length;j++)
      {
      boxes[j] = new JCheckBox(toppOptions[j]);
      boxes[j].setActionCommand("topping");
      boxes[j].addActionListener(this);
      toppPanel.add(boxes[j]);
      }
   menu.add(toppPanel,c);
   
      //the number panel
   c.gridy = yc; yc++;
   instruc = new JLabel("How many pizzas like this do you want?");
   pizzaNum = new JTextField(3);
   pizzaNum.setText("1");
   pizzaNum.setActionCommand("number");
   pizzaNum.addActionListener(this);
   numPanel = new JPanel();
   numPanel.add(instruc);
   numPanel.add(pizzaNum);
   menu.add(numPanel,c);
   
      //make the cost panel
   costPanel = new JPanel(new GridLayout(0,1));
   yCost = yc; yc++;
   //yCost is the y constraint of the cost panel.
   //when the cost panel is updated, it needs to have the right y constraint.
   updateCost();
      
      //buttons to complete the order  
   c.gridy = yc;
   buttonPanel = new JPanel();
   addButton = new JButton("Add another Pizza");
   addButton.setActionCommand("add");
   addButton.addActionListener(this);
   orderButton = new JButton("Order Pizza");
   orderButton.setActionCommand("finish");
   orderButton.addActionListener(this);

   buttonPanel.add(addButton);
   buttonPanel.add(Box.createHorizontalGlue());//this just adds a little space. I'm not sure why.
   buttonPanel.add(orderButton);
   menu.add(buttonPanel,c);
   }
   //the action listener
   public void actionPerformed(ActionEvent ae)
   {
   String ac = ae.getActionCommand();
   
   if(ac.equals("size"))
      {
      updateCost();
      }
   if(ac.equals("topping"))
      {
      updateCost();
      }
   if(ac.equals("number"))
      {
      getNumber();
      updateCost();
      }
   if(ac.equals("add"))
      {
      getNumber();
      getCrust();
      frame.setVisible(false);
      addPizza();
      }
   if(ac.equals("addIt"))
      {
      finalFrame.setVisible(false);
      addPizza();
      }

   if(ac.equals("change"))
      {
      finalFrame.setVisible(false);
      changeOrder();
      }
   if(ac.equals("finish"))
      {
      frame.setVisible(false);
      getNumber();
      getCrust();
      getDiscount();
      finishOrder();
      }
   if(ac.equals("confirm"))
      {
      finalFrame.setVisible(false);
      JOptionPane.showMessageDialog(null,
      "Your order will be ready for pickup in 30 minutes.","Mike and Diane's",-1);
      System.exit(0);
      }
   }
   //this method calculates the cost and updates the cost panel.
   public void updateCost()
   {
      //update the size field
   for(int i = 0; i < sizeOptions.length; i++){
      if(sizes[i].isSelected())
         {
         size = Integer.parseInt(sizeOptions[i]);
         baseCost = size + 0.99;
         }
      }
      
   toppCount = 0;
   toppings = "cheese";
      
      //update the toppCount and toppings fields
   for(int j = 0; j < toppOptions.length; j++){
      if(boxes[j].isSelected())
         {
         toppCount += 1;
         toppings += ", " + toppOptions[j];
         }
      }
      //calculate the sub total
   getNumber();
   subTotal = (baseCost + toppCount * 1.25) * number;
      //calculate the tax
   tax = (baseCost + toppCount * 1.25) * 0.08;
   cost = subTotal + tax * number;
      //remove the old components and add the new ones
   c.gridy = yCost;
   costPanel.removeAll();
   base = new JLabel(String.format("Base Cost:\t$%.2f" ,baseCost));
   topp = new JLabel(String.format("Topping Cost:$%.2f", toppCount * 1.25));
   sub = new JLabel(String.format("Sub Total:$%.2f", subTotal));
   costPanel.add(base);
   costPanel.add(topp);
   costPanel.add(sub);
   menu.add(costPanel,c);
   frame.setVisible(true);
   }
   
      //displays the checkout jframe,
      //which allows the user to add a pizza, change an existing pizza, or confirm the order.
   public void finishOrder()
   {
   
   c = new GridBagConstraints();
   c.gridx = 0; c.gridy = 0;
   c.weightx = 1; c.weighty = 1;
   
   display = new JPanel[pizzaTypes.length];
   finish = new JLabel[7];
   fin = new String[]{"","","","","","",""};
   for(int i = 0; i < pizzaTypes.length; i++)
      {
      fin[0] = String.format("Pizza number %d:", i+1);
      fin[1] = String.format("%d inch %s pizza.",pizzaTypes[i].size,pizzaTypes[i].crust);
      fin[2] = String.format("%s",pizzaTypes[i].toppings);
      fin[3] = String.format("Base Cost:%32s$%.2f","",pizzaTypes[i].baseCost);
      fin[4] = String.format("Toppings:%35s$%.2f","",pizzaTypes[i].toppCount * 1.25);
      fin[5] = String.format("Tax:%45s$%.2f","",pizzaTypes[i].tax);
      fin[6] = String.format("Pizza Total: $%,.2f (for %d)",pizzaTypes[i].cost,pizzaTypes[i].number);
      display[i] = new JPanel(new GridBagLayout());
      for(int j = 0; j < fin.length; j++)
         {
         finish[j] = new JLabel(fin[j]);
         c.gridy = j;
         display[i].add(finish[j],c);
         }
      }
   checkout = new JPanel(new GridBagLayout());
   c.gridy = 0;
   for(int k = 0; k < pizzaTypes.length; k++)
      {
      c.gridx = k;
      checkout.add(display[k],c);
      }
   c.gridx = 0; c.gridwidth = pizzaTypes.length;//these stay the same for everything afterward
   
   c.gridy = 1;
   discount1 = new JLabel(dCount1);
   checkout.add(discount1,c);
   
   c.gridy = 2;
   discount2 = new JLabel(dCount2);
   checkout.add(discount2,c);
   
   c.gridy = 3;
   costLabel = new JLabel(String.format("Total Bill: $%,.2f",getTotal()));
   checkout.add(costLabel,c);
   
   c.gridy = 4;
   buttons = new JPanel();
   addIt = new JButton("Add a pizza");
   addIt.setActionCommand("addIt");
   addIt.addActionListener(this);
   change = new JButton("Change Order");
   change.setActionCommand("change");
   change.addActionListener(this);
   confirm = new JButton("Confirm Order");
   confirm.setActionCommand("confirm");
   confirm.addActionListener(this);
   buttons.add(addIt);
   buttons.add(change);
   buttons.add(confirm);
   checkout.add(buttons,c);
   
   finalFrame = new JFrame();
   int xLocat = (pizzaTypes.length == 1)?400:600-130*pizzaTypes.length;
   finalFrame.setLocation(xLocat,300);
   finalFrame.setTitle("Mike and Diane's");
   finalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   finalFrame.add(checkout);
   int xSize = (pizzaTypes.length < 2)?450:280*pizzaTypes.length;
   finalFrame.setSize(xSize,250);
   finalFrame.setVisible(true);
   }
   
      //the main method
   public static void main (String[] args)
   {
   String name = JOptionPane.showInputDialog(null,"Please enter your name.","Mike and Diane's",-1);
   
   pizzaTypes = new PizzaOrder3[1];
   pizzaTypes[0] = new PizzaOrder3(name);
   }
   
   //adds one element to the pizza types array
   public void addPizza()
   {
   PizzaOrder3[] newArray = new PizzaOrder3[pizzaTypes.length + 1];
   for(int i = 0; i < pizzaTypes.length; i++)
      {
      newArray[i] = pizzaTypes[i];
      }
   newArray[pizzaTypes.length] = new PizzaOrder3(name);
   pizzaTypes = new PizzaOrder3[newArray.length];
   for(int j = 0; j < newArray.length; j++)
      {
      pizzaTypes[j] = newArray[j];
      }
   }
   
   public void changeOrder()
   {
   Object[] options = new Object[pizzaTypes.length];
   for(int i = 0; i < pizzaTypes.length; i++)
      {
      String op = String.format("%d inch %s pizza\n $%,.2f",
         pizzaTypes[i].size,pizzaTypes[i].crust,pizzaTypes[i].cost);
      options[i] = op;
      }
   int result = JOptionPane.showOptionDialog(null,"Select a pizza to change?",
      "Mike and Diane's",0,3,null,options,null);
   if(result == -1)
      {finalFrame.setVisible(true);}
   else pizzaTypes[result].frame.setVisible(true);//.show();
   }
   
      //gets the total price of the order
   public double getTotal()
   {
   double total = 0;
   for(int i = 0; i < pizzaTypes.length; i++)
      {
      total += pizzaTypes[i].cost;
      }
   total -= discount;
   return total;
   }
   
      //returns the total number of pizzas ordered so far
   public int getPizzaCount()
   {
   int count = 0;
   for(int i = 0; i < pizzaTypes.length; i++)
      {
      count += pizzaTypes[i].number;
      }
   return count;
   }
   
      //updates the two discount strings and the dicount its self.
   public void getDiscount()
   {
   discount = 0;
   
   if(getTotal() > 100)
      {dCount2 = "Your $10 bulk order discount has been applied.";
      discount += 10;}
   if(name.equalsIgnoreCase("Mike") || name.equalsIgnoreCase("Diane"))
      {dCount1 = String.format("Your $%d owner discount has been applied.",2*getPizzaCount());
      discount += 2 * getPizzaCount();}
   }
   
      //The get number method updates the value of the number field.
      //It also returns true if the user entered a valid number or false otherwise.
   public void getNumber()
   {
   try
      {number = Integer.parseInt(pizzaNum.getText());}
   catch (NumberFormatException e)
      {
      JOptionPane.showMessageDialog(null,"Invalid Input!");
      number = 1;
      pizzaNum.setText("1");
      }
   }
   
      //updates the value of the crust field
   public void getCrust()
   {
   for(int i = 0; i < crustOptions.length; i++)
         {
         if(crusts[i].isSelected())
            {crust = crustOptions[i] + " crust";}
         }
    }
}