import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Drawing extends JPanel
{
private static JFrame frame;
private static int x = -1;
private static String number;
      
   public static void main(String[] args)
   {
      frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(300, 300);
      frame.add(new Drawing());
      frame.setVisible(true);
      Object[] options = {"paint","don't"};
      x = JOptionPane.showOptionDialog(null,"Choose One.","Title",0,3,null,options,null);
      number = JOptionPane.showInputDialog(null,"Choose a number of rectangles.");
      frame.repaint();
   }
    
      @Override
   public void paintComponent(Graphics g)
   {
         //this paints a default background.
      super.paintComponent(g);
         //rectangle originated at 10,10 with width and height 240
      g.drawRect(10, 10, 240, 240);
         //filled Rectangle with rounded corners.    
      g.fillRoundRect(50, 50, 100, 100, 80, 80);
      
      ImageIcon floor = new ImageIcon("jFloor.png");
              
      floor.paintIcon(this, g, 150, 150);
      
      if(x == 0)
         paintIt(g);
   }
   
   public static void paintIt(Graphics g)
   {
   try{
      int num = Integer.parseInt(number);
      for(int i = 1; i <= num; i++)
         {
         g.drawRect(10*i, 10*i, 260-20*i, 260-20*i);    
         //g.drawLine(50, 50, 150, 150);
         }
      }catch(NumberFormatException e){}
   }

}