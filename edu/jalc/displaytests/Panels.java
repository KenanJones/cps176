import javax.swing.*;
import java.awt.event.*;

public class Panels extends JFrame implements ActionListener
{
private String toppings;
private String[] names;
private JCheckBox[] boxes;
private JPanel panel;
private JButton b;
   /*Constructor*/
   public Panels()
   {
   setTitle("list of boxes!");
   setSize(300,100);
   setLocationRelativeTo(null);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
   buildPanel();
   add(panel);
   setVisible(true);
   }
   //helps in construction
   private void buildPanel()
   {
   names = new String[]{"sausage","pepperoni","mushroom","onion"};
   boxes = new JCheckBox[names.length];
   for(int i=0;i<names.length;i++)
   {
   JCheckBox cBox = new JCheckBox(names[i]);
   cBox.setActionCommand(names[i]);
   //cBox.addActionListener(this);
   boxes[i] = cBox;
   }
   b = new JButton("Choose Toppings");
   b.setActionCommand("go");
   b.addActionListener(this);
   panel = new JPanel();
   
   for(int j = 0;j < names.length;j++)
      {
      panel.add(boxes[j]);
      }
   panel.add(b);
   }
   //action listener
   public void actionPerformed(ActionEvent e)
   {
   toppings = new String("cheese");
   for(int i = 0; i < 4; i++)
   {
   if(boxes[i].isSelected()){toppings += ", " + names[i];}
   }
   setVisible(false);
   System.out.println(toppings);
   System.exit(0);
   }
   //main method
   public static void main(String[] args)
   {
   new Panels();
   }
}