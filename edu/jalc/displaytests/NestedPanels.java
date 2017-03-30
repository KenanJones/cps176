import javax.swing.*;
import java.awt.event.*;
import java.awt.GridLayout;
//import java.awt.BorderLayout;

public class NestedPanels extends JFrame implements ActionListener
{
//this only works with gridbaglayout:  pizzaNum.setPreferredSize(new Dimension(8,25));
private String toppings;
private String[] toppOptions;
private JCheckBox[] boxes;
private JPanel panel;
private JPanel outside;
private JButton b;
private int x;
private int y;
   /*Constructor*/
   public NestedPanels()
   {
   setTitle("Toppings");
   setLocationRelativeTo(null);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
   buildPanel();
   add(outside);
   y = 150; x = 450;
   setSize(x,y);
   setVisible(true);
   }
   //helps in construction
   private void buildPanel()
   {
   toppOptions = new String[]{"sausage","pepperoni","mushroom","onion","green pepper","pineapple",
      "bacon","ham","sliced tomato","olives","extra cheese"};
   boxes = new JCheckBox[toppOptions.length];
   panel = new JPanel(new GridLayout(0,4));
   for(int j = 0;j < toppOptions.length;j++)
      {
      boxes[j] = new JCheckBox(toppOptions[j]);
      panel.add(boxes[j]);
      }
   outside = new JPanel();
   b = new JButton("Choose Toppings");
   b.setActionCommand("go");
   b.addActionListener(this);
   outside.add(panel);
   outside.add(b);
   
   }
   //action listener
   public void actionPerformed(ActionEvent e)
   {
   toppings = new String("cheese");
   for(int i = 0; i < toppOptions.length; i++)
   {
   if(boxes[i].isSelected()){toppings = toppings + ", " + toppOptions[i];}
   }
   setVisible(false);
   System.out.println(toppings);
   System.exit(0);
   }
   //main method
   public static void main(String[] args)
   {
   Object p = new NestedPanels();
   }
}