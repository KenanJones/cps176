import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

public class Animation_Test extends JPanel implements ActionListener
{
private static JFrame display;
private static Timer clock;
private static int i = 0;
private static final int step = 1;

public static void main (String[] args)
   {
   Animation_Test test = new Animation_Test();
   clock = new Timer(50,test);
   display = new JFrame();
   display.setSize(600,624);
   display.setLocation(300,200);
   display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   display.add(test);
   display.setVisible(true);
   clock.start();
   }
   
   @Override
   public void paintComponent(Graphics g)
   {
   if(10+i > 624) i = -1;
   super.paintComponent(g);
   g.drawLine(10+i,10+i,10+i,10+i);
   }
   
   public void actionPerformed(ActionEvent evt)
   {
   //System.out.println("fired");
   i+= step;
   repaint();
   }
}