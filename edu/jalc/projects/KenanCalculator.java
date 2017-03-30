import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class KenanCalculator implements ActionListener
{
private JFrame frame;
private JPanel menu;
private JTextField num1;
private JTextField num2;
private JComboBox op;

private double number1;
private double number2;
private String command;
private String type;

   //the main method makes a new object of type KenanCalculator
public static void main (String[] math)
   {
   new KenanCalculator();
   }
   
      //Constructor
   public KenanCalculator()
   {
   frame = new JFrame();
   frame.setLocation(400,300);
   frame.setTitle("Calculator");
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   buildPanel();
   frame.add(menu);
   frame.setSize(400,350);
   frame.setVisible(true);
   }
      //this method adds all the components to the correct panels,
      //and adds the panels to the frame
   public void buildPanel()
   {
   menu = new JPanel(new GridBagLayout());
   GridBagConstraints c = new GridBagConstraints();
   c.gridx = 0; c.gridy = 0;
   c.weightx = 1; c.weighty = 1;
   c.ipadx = 5; c.ipady = 5;
   
   JLabel text1 = new JLabel("This is a simple calculator.");
   JLabel text2 = new JLabel("Enter 2 numbers and an operation to continue.");
   
   JPanel text = new JPanel(new GridLayout (0,1));
   text.add(text1);
   text.add(text2);
   
   menu.add(text,c);
   
   num1 = new JTextField(3);
   num2 = new JTextField(3);
   
   JPanel panel = new JPanel(new GridLayout (0,3));
   panel.add(new JLabel("number 1"));
   panel.add(new JLabel("number 2"));
   panel.add(new JLabel("Select an Operation"));
   panel.add(num1);
   panel.add(num2);
   
   String[] operations = {"Addition","Subtraction","Multiplication","Division"};
   op = new JComboBox<String>(operations);
   
   panel.add(op);
   
   c.gridy = 1;
   menu.add(panel,c);
   
   JButton calc = new JButton("Calculate");
   calc.addActionListener(this);
   JPanel buttonP = new JPanel();
   buttonP.add(calc);
   
   c.gridy = 2;
   menu.add(buttonP,c);
   }
      //the action listener
   public void actionPerformed(ActionEvent ae)
   {
   frame.setVisible(false);
   try
      {
      number1 = Double.parseDouble(num1.getText());
      number2 = Double.parseDouble(num2.getText());
      command = (String)op.getSelectedItem();
      process();
      }
   catch(NumberFormatException e)
      {
      JOptionPane.showMessageDialog(null,"Please enter two numbers.");
      frame.setVisible(true);
      }
   }
   
      //this method uses a switch statement to determine the wanted action
   public void process()
   {
   switch(command.toLowerCase())
      {
      case "addition": type = "sum"; add(); break;
      case "subtraction": type = "difference"; subtract(); break;
      case "multiplication": type = "product"; multiply(); break;
      case "division": type = "quotient"; divide(); break;
      }
   }
   
      //these methods simply do the action their name implies,
      //then they each call the display method of the result
   public void add()
   {
   double sum = number1 + number2;
   display(sum);
   }
   public void subtract()
   {
   double difference = number1 - number2;
   display(difference);
   }
   public void multiply()
   {
   double product = number1 * number2;
   display(product);
   }
   public void divide()
   {
   double quotient = number1 / number2;
   display(quotient);
   }
   
      //the display method displays the result and the original numbers in a JOptionPane,
      //and gives the user the choice of ending the program or calculating again.
   public void display(double result)
   {
   String[] options = {"Continue","Done"};
   int x = JOptionPane.showOptionDialog(null,String.format("the %s of %f and %f is %f",type,number1,number2,result),
      "Calculator",0,3,null,options,null);
   if(x == -1 || options[x].equals("Done"))
      {
      JOptionPane.showMessageDialog(null,"Thank you for using Kenan's Calculator");
      System.exit(0);
      }
         //set the frame back to default with the result in box 1
   else if(options[x].equals("Continue"))
      {
      num1.setText(String.format("%f",result));
      num2.setText(null);
      op.setSelectedIndex(0);
      frame.setVisible(true);
      }
   }

}
   