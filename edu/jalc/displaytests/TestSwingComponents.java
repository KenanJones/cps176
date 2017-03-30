import javax.swing.*;
import java.awt.event.*;
public class TestSwingComponents implements ActionListener
{
private JCheckBox box;
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
   
   public static void main (String[] args)
   {
   Object[] formulas = new Object[]{"one","two","three"};
   int form = JOptionPane.showOptionDialog(null,"Choose one","Input",0,3,null,formulas,null);
   System.out.println(form);
   System.out.println(formulas[form].toString());
   /* minus one is no icon 
   zero is the red x icon
   one is the purple i icon
   two is the yellow ! icon
   three is the green ? icon
   */
   String chosenTopp = "cheese";
   Object[] toppings = {"sausage","pepperoni","mushroom","onion","green pepper"};
   boolean test = true;
   while(test){
      toppings = arrayMaker(toppings);
      int topp = JOptionPane.showOptionDialog(null,"Select a topping to add.","Mike and Diane's",0,3,null,toppings,null);
      if(topp == -1){test = false;}//{System.exit(0);}
      else{
         chosenTopp += ", " + toppings[topp];
         toppings[topp] = null;
         System.out.println(chosenTopp);
         }
      }
   new TestSwingComponents();
   }
   public TestSwingComponents()
   {
   makePanel();
   }
   public void makePanel()
   {
   JFrame frame = new JFrame();
   JPanel panel = new JPanel();
   JButton button = new JButton("go");
   button.addActionListener(this);
   box = new JCheckBox("do it");
   panel.add(box);
   panel.add(button);
   frame.add(panel);
   frame.setLocation(400,300);
   frame.setSize(200,200);
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.setVisible(true);
   }
   public void actionPerformed(ActionEvent e)
   {
   if(box.isSelected())System.out.println("yep!");
   System.out.println("hi");
   }
}
