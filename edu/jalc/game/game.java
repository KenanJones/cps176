import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class game extends JPanel implements KeyListener
{
private static JFrame display;
private static JTextField field;
private Display board;

public static int xPos;
public static int yPos;
public static String actionString;
public static int lastMove;
   
   public game()
   {
   actionString = "none";
   lastMove = 0;
   xPos = 6; yPos = 6;
   display = new JFrame();
   display.setSize(666,689);
   display.setLocation(320,90);//320,190
   display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   buildPanel();
   display.add(field);
   board = new Display();
   display.add(board);
   display.setVisible(true);

   }
   public void buildPanel()
   {
   field = new JTextField();
   field.addKeyListener(this);
   }
   
   public static void main (String[] args)
   {
   new game();
   }
   
   public boolean badMove()
   {
   boolean bad = true;
   int type = board.terrainType(xPos,yPos);
   if(type != 0)
      {
      bad = false;
      }
   return bad;
   }
   
   public void store(int key)
   {
   lastMove = key;
   }
      
   public void keyPressed(KeyEvent e)
   {
   actionString = "none";
   //System.out.println(e.getKeyCode());
   switch(e.getKeyCode())
      {
      case 37: xPos--; if(badMove())xPos++; store(37); break;
      case 38: yPos--; if(badMove())yPos++; store(38); break;
      case 39: xPos++; if(badMove())xPos--; store(39); break;
      case 40: yPos++; if(badMove())yPos--; store(40); break;
      case 68: actionString = "dive"; break;
      case 84: actionString = "teleport"; break;
      case 32: actionString = "shoot"; break;
      }
   board.repaint();
   }
   public void keyTyped(KeyEvent e) {}//System.out.println("typed");}
   public void keyReleased(KeyEvent e) {}//System.out.println("released");}
}