import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class timerClass implements ActionListener
{
   public timerClass()
   {
   int delay = 1000; //milliseconds
   
   System.out.println("listener made");
   Timer clock = new Timer(delay, this);
   System.out.println("made");
   clock.start();
   System.out.println("started");
   JFrame frame = new JFrame();
   frame.setSize(200,200);
   frame.setVisible(true);
   }
   
   public void actionPerformed(ActionEvent evt)
      {
      System.out.println("fired");
      }
   
   public static void main (String[] args)
   {
   new timerClass();
   }
}