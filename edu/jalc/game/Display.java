import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.Timer;

public class Display extends JPanel implements ActionListener
{
public final int X = 25;
public final int Y = 25;
public int x = 312;
public int y = 312;
private int[][] pics = new int[X][Y];
private ImageIcon[][] icons = new ImageIcon[X][Y];
private int xVal;
private int yVal;
private boolean shootTest;
private int direction = 38;

private static JFrame display;
private Timer clock = new Timer(150,this);
   
   public static void main (String[] args)
   {
   display = new JFrame();
   display.setSize(600,624);
   display.setLocation(300,200);
   display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   display.add(new Display());
   display.setVisible(true);
   }
@Override
   public void paintComponent(Graphics g)
   {
   super.paintComponent(g);
   
   xVal = game.xPos - 6; yVal = game.yPos - 6;
   
   for(int i = xVal; i < xVal+13; i++)
      {
      for(int j = yVal; j < yVal+13; j++)
         {
         try
            {
            icons[i][j] = new ImageIcon(getImage(i,j));
            icons[i][j].paintIcon(this,g,50*(i-xVal),50*(j-yVal));
            }
         catch(ArrayIndexOutOfBoundsException e)
            {
            ImageIcon icon = new ImageIcon("images/jBlack.png");
            icon.paintIcon(this,g,50*(i-xVal),50*(j-yVal));
            }
         
         }
      }
   doAction(game.actionString, g);
   
   if (shootTest)
      {
      g.setColor(Color.red);
      int width = (direction == 37 || direction == 39)?20:15;
      int height = (direction == 38 || direction == 40)?20:15;
      g.fillOval(x,y,width,height);
      }
      
   ImageIcon guy = new ImageIcon(getGuy(game.actionString));
   guy.paintIcon(this,g,312,312);
   }
   public String getImage(int x, int y)
   {
   int num, idNum;
   if(pics[x][y] == 0)
      {
      Random random = new Random();
      num = random.nextInt(8) + 1;
      }
   else
      {
      num = pics[x][y];
      }
   String pic = "";
   if(num == 1 || num == 5){idNum = 1;}
   else if(num == 2 || num == 6 || num == 7){idNum = 2;}
   else if(num == 3){idNum = 3;}
   else{idNum = 4;}
   
   pics[x][y] = idNum;
   
   switch (idNum)
      {
      case -1: pic = "images/jBlack.png"; break;
      case 1: pic = "images/jRocks.png"; break;
      case 2: pic = "images/jGrass.png"; break;
      case 3: pic = "images/jPond.png"; break;
      case 4: pic = "images/jWater.png"; break;
      }
   
   return pic;
   }
   
   public int terrainType(int xPos, int yPos)
   {
   int type;
   try
      {
      type = pics[xPos][yPos];
      }
   catch(ArrayIndexOutOfBoundsException e)
      {
      type = 0;
      }
   return type;
   }
   
   public String getGuy(String command)
   {
   String guy = "images/jGuy.jpg";
   if (command.equals("none"))
      guy = "images/jGuy.jpg";
   else if (command.equals("dive") && (pics[xVal+6][yVal+6] == 3 || pics[xVal+6][yVal+6] == 4))
      guy = "images/jDive.png";
  
   return guy;
   }
   
   public void doAction(String command, Graphics g)
   {
   if (command.equals("teleport"))
      teleport();
   else if (command.equals("shoot"))
      {clock.stop(); x = 312; y = 312; getDirection(); clock.start();}
   }
   
   public void teleport()
   {
   Random random = new Random();
   game.xPos = random.nextInt(X);
   game.yPos = random.nextInt(Y);
   game.actionString = "none";
   repaint();
   }
   
   public void actionPerformed(ActionEvent evt)
   {
   switch(direction)
      {
      case 37: x -= 50; break;
      case 38: y -= 50; break;
      case 39: x += 50; break;
      case 40: y += 50; break;
      }
   
   shootTest = true;
   game.actionString = "none";
   if (x <= 0 || x >= 800 || y <= 0 || y >= 800)
      {
      clock.stop();
      shootTest = false;
      x = 312; y = 312;
      }
   repaint();
   }
   
   public void getDirection()
   {
   switch(game.lastMove)
      {
      case 37: direction = 37; break;
      case 38: direction = 38; break;
      case 39: direction = 39; break;
      case 40: direction = 40; break;
      }
   }
}