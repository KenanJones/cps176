package jalc.game;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.Timer; //tells the computer to use the swing timer

public class game2 implements KeyListener, ActionListener
{
private int[][] terrain;
private ImageIcon[][] icons;
private int[] key;

private static JFrame frame;
private static JTextField field;
private Display board;

private Player player;
private ArrayList<Character> guys2 = new ArrayList<Character>();

private Random random;
private Timer clock;
public static String action;
   
   public game2()
   {
   action = "none";
   key = new int[4];
   random = new Random();
   clock = new Timer(100,this);
   frame = new JFrame();
   frame.setSize(666,689);
   frame.setLocation(320,90);
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   player = new Player(6,6);
   buildPanel();
   frame.setVisible(true);
   guys2.add(new Character(Color.green));
   guys2.add(new Character(Color.green));
   guys2.add(new Character(Color.green));
   guys2.add(new Character(Color.red));
   guys2.add(new Character(Color.blue));
   clock.start();
   }
   
   public void buildPanel()
   {
   field = new JTextField();
   field.addKeyListener(this);
   frame.add(field);
   board = new Display();
   board.build();
   frame.add(board);
   }
   
   public static void main (String[] args)
   {
   new game2();
   }
   
   public void badMove()
   {
   boolean test = true;
   while(test)
      {
      if(player.xP < 0) {player.xP += 20; key[0] = 0;}
      else if(player.xP > board.XSIZE*50-26) {player.xP -= 20; key[2] = 0;}
      else if(player.yP < 0) {player.yP += 20; key[1] = 0;}
      else if(player.yP > board.YSIZE*50-26) {player.yP -= 20; key[3] = 0;}
      else test = false;
      }
   }
   
   public void doAction()
   {
   if(action.equals("teleport"))
      player.teleport();
   if(action.equals("explore"))
      try{
         if(terrain[player.xP/50][player.yP/50] == 6 && player.has("torch","ladder"))
            System.out.println("Cave Explored!");
         }
      catch(ArrayIndexOutOfBoundsException e){System.out.println("Error detected");}
   if(action.equals("attack"))
      removeCharacters();
   }
   
   public void removeCharacters()
   {
   int[] pA = player.getArea();
   int x = player.xP, y = player.yP;
   Rectangle pRect = player.rect;
   /*if(player.area[2]>0)
      {pRect = new Rectangle(player.area[0],player.area[1],player.area[2],player.area[3]);}//(x-pA[0],y-pA[1],pA[0]+pA[2],pA[1]+pA[3]);
   else {pRect = new Rectangle(player.area[0]+player.area[2],player.area[1]+player.area[3],player.area[2],player.area[3]);}*/
   for(int j = 0; j < guys2.size(); j++)
      {
      Rectangle cRect = new Rectangle(guys2.get(j).xP, guys2.get(j).yP, guys2.get(j).xSize, guys2.get(j).ySize);
      if (cRect.intersects(pRect))
         guys2.remove(j);
      }
   }
   
   public void actionPerformed(ActionEvent evt)
   {
   board.repaint();
   }

   public void keyPressed(KeyEvent e)
   {
   action = "none";
   //System.out.println(e.getKeyCode());
   switch(e.getKeyCode())
      {
      case 37: if(key[0] == 0)key[0] = (key[2]==0)? 5: 10-key[2]; break;
      case 38: if(key[1] == 0)key[1] = (key[3]==0)? 5: 10-key[3]; break;
      case 39: if(key[2] == 0)key[2] = (key[0]==0)? 5: 10-key[0]; break;
      case 40: if(key[3] == 0)key[3] = (key[1]==0)? 5: 10-key[1]; break;
      case 68: action = "dive"; break;
      case 69: action = "explore"; break;
      case 84: action = "teleport"; break;
      case 32: action = "attack"; break;
      }
   doAction();
   }
   public void keyTyped(KeyEvent e) {}
   public void keyReleased(KeyEvent e) {}
   
      //the display class
   public class Display extends JPanel
   {
   private final int XSIZE = 25;
   private final int YSIZE = 25;
   @Override
   public void paintComponent(Graphics g)
      {
      super.paintComponent(g);
      show(g);
      player.show(g);
      for(Character guy: guys2)
         {
         guy.show(g);
         }
      }
   public void build()
      {
      String icon;
      terrain = new int[XSIZE][YSIZE];
      icons = new ImageIcon[XSIZE][YSIZE];
      for(int row = 0; row < XSIZE; row++)
         {
         for(int col = 0; col < YSIZE; col++)
            {
            int val = random.nextInt(3)+random.nextInt(3)+random.nextInt(3);
            terrain[row][col] = val;
            switch(val)
            {
            case 0: icon = "jRocks.png"; break;//1
            case 1: icon = "jRocks.png"; break;//3
            case 2: icon = "jGrass.png"; break;//6
            case 3: icon = "jWater.png"; break;//7
            case 4: icon = "jGrass.png"; break;//6
            case 5: icon = "jPond.png"; break;//3
            case 6: icon = "jCave.png"; break;//1
            default: icon = "jalc/game/images/jBlack.png"; break;
            }
            icons[row][col] = new ImageIcon("jalc/game/images/" + icon);
            }
         }
      }
      public void show(Graphics g)
      {
      int xStart = player.xP/50 - 6;
      int yStart = player.yP/50 - 6;
      int xShift = player.xP%50-12;
      int yShift = player.yP%50-12;
      
      for(int i = -1; i < 14; i++)//this would be 0-13, the extra numbers prevent white on the borders
         {
         for(int j = -1; j < 14; j++)
            {
            try
               {
               icons[xStart+i][yStart+j].paintIcon(this,g,i*50-xShift,j*50-yShift);
               }
            catch(ArrayIndexOutOfBoundsException e)
               {
               ImageIcon icon = new ImageIcon("jBlack.png");
               icon.paintIcon(this,g,i*50-xShift,j*50-yShift);
               }
            }
         }
      }
   }
      //this is you!
   public class Player
   {
   private int xP;//position on display in pixels
   private int yP;//position on display in pixels
   private final int XP = 312;//the position on the screen in pixels
   private final int YP = 312;//the position on the screen in pixels
   private double life;
   private int direction;
   private int[] area; //the weapon effect area
   private Rectangle rect; //the weapon affect area
   private String[] tools;
   private String weapon;
   
   public Player(int xVal, int yVal)
   {
   xP = xVal*50 + 12;
   yP = yVal*50 + 12;
   area = new int[4];
   tools = new String[]{"torch","ladder","boat","potion"};
   weapon = "gun";
   }
   
   public void move()
      {
      if(key[0] > 0)
         {
         key[0] -= 1;
         xP -= 10;
         direction = 37;
         }
      if(key[1] > 0)
         {
         key[1] -= 1;
         yP -= 10;
         direction = 38;
         }
      if(key[2] > 0)
         {
         key[2] -= 1;
         xP += 10;
         direction = 39;
         }
      if(key[3] > 0)
         {
         key[3] -= 1;
         yP += 10;
         direction = 40;
         }
      badMove();
         }
      
   public void teleport()
   {
   int x = random.nextInt(board.XSIZE);
   int y = random.nextInt(board.YSIZE);
   xP = x*50 + 12;
   yP = y*50 + 12;
   }
   
   public void show(Graphics g)
      {
      Graphics2D g2 = (Graphics2D) g;
      
      move();
      if(action == "attack")
         showWeapon(g2);
      
      g2.setColor(new Color(250,220,180));
         //the face
      g2.drawOval(8+XP,1+YP,8,6);
      g2.fillOval(8+XP,1+YP,8,6);
      g2.setColor(Color.blue);
      g2.drawLine(10+XP,3+XP,10+XP,3+XP);
      g2.drawLine(14+XP,3+XP,14+XP,3+XP);
      g2.setColor(new Color(130,60,30));
         //the hair
      int[] points = new int[]{8,2,10,0,8,3,11,0,14,0,16,2,13,0,16,3,12,0,12,0};
      for(int i = 0; i < points.length; i++)
         {
         g2.drawLine(points[i]+XP,points[++i]+YP,points[++i]+XP,points[++i]+YP);
         }
      g2.setColor(new Color(160,130,90));
      g2.drawLine(12+XP,4+YP,12+XP,4+YP);
         //the body
      g2.fillOval(9+XP,9+YP,9,9);
      g2.setStroke(new BasicStroke(3,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
      int [] xPoints = new int[]{1,1,3,8,9,5,4,5,14,15,18,20,18,15,14,18,24,17,16,9};
      int [] yPoints = new int[]{5,9,11,11,19,19,25,19,19,22,23,25,23,22,19,10,17,10,9,9};
      //g2.drawPolyline(xPoints, yPoints, 20);
      for(int i = 1; i < xPoints.length; i++)
         {
         g2.drawLine(xPoints[i-1]+XP,yPoints[i-1]+YP,xPoints[i]+XP,yPoints[i]+YP);
         }
      /*g2.drawRect(player.area[0]+XP-xP,player.area[1]+YP-yP,player.area[2],player.area[3]);
      if(player.area[2]>0)
      {g2.drawRect(player.area[0],player.area[1],player.area[2],player.area[3]);}
      else {g2.drawRect(player.area[0]+player.area[2],player.area[1]+player.area[3],player.area[2],player.area[3]);}*/
      }
   
   public void showWeapon(Graphics2D g2)
      {
      action = "none";
      int[] range = getArea();
      
      if(weapon == "sword")
         {
         g2.setColor(Color.white);
         g2.drawLine(XP,YP,XP-range[0],YP);
         g2.drawLine(XP,YP,XP,YP-range[1]);
         g2.drawLine(XP,YP,XP+range[0],YP);
         g2.drawLine(XP,YP,XP,YP+range[1]);
         }
      if(weapon == "gun")
         {
         g2.setColor(Color.white);
         g2.drawLine(XP,YP,XP+range[0],YP+range[1]);
         }
      }
   
   public boolean has(String... neededTools)
      {
      boolean returned = true;
      boolean hasTool = false;
      for(String tool: neededTools)
         {
         for(String toolHad: tools)
            {
            if(tool.equals(toolHad))
            hasTool = true;
            }
         if(hasTool == false)
         returned = false;
         }
      return returned;
      }
   
   public int[] getArea()
      {
      int[] a;
      int xD = direction==37?-1:direction==39?1:0;
      int yD = direction==38?-1:direction==40?1:0;
      switch(weapon)
         {
         case "sword": a = new int[]{30,30};
            //area = new int[]{xP-40,yP-40,80,80};
            rect = new Rectangle(xP+30*xD, yP+30*yD, 30, 30); break;
         case "gun": a = new int[]{300*xD, 300*yD};
            //area = new int[]{xP-5,yP-5,200*xD+10,200*yD+10};
            rect = new Rectangle(xD<0?xP-300:xP+10*xD-10,
               yD<0?yP-300:yP+10*yD-10, xD!=0?300:20, yD!=0?300:20); break;
         default: a = new int[]{10,10}; break;
         }
      return a;
      }
   }
      //all automated characters on the board
   public class Character
   {
   private int xP;
   private int yP;
   private int xSize;
   private int ySize;
   private Color type;
   private double life;
   private int speed;
   
   public Character()
      {
      xSize = 26;
      ySize = 26;
      xP = random.nextInt(board.XSIZE)*50+(50-xSize)/2;
      yP = random.nextInt(board.YSIZE)*50+(50-ySize)/2;
      type = Color.green;
      speed = 2;
      }
   public Character(Color color)
      {
      xSize = 26;
      ySize = 26;
      xP = random.nextInt(board.XSIZE)*50+(50-xSize)/2;
      yP = random.nextInt(board.YSIZE)*50+(50-ySize)/2;
      type = color;
      if(color == Color.red) speed = 3;
      else if(color == Color.green) speed = 2;
      else speed = 1;
      }
   
   public void move()
      {
      int xMove = random.nextInt(speed + 1);
      int yMove = speed - xMove;
      if(player.xP > xP)
         {xP += xMove*5;}
      else{xP -= xMove*5;}
      if(player.yP > yP)
         {yP += yMove*5;}
      else{yP -= yMove*5;}
      }
   
   public void show(Graphics g)
      {
      move();
      int x = xP - player.xP + player.XP-12;
      int y = yP - player.yP + player.YP-12;
      Graphics2D g2 = (Graphics2D) g;
      g2.setStroke(new BasicStroke(1));
      
      g2.setColor(type);
      g2.drawOval(15+x,10+y,20,20);//the body
      g2.drawRect(15+x,20+y,20,15);
      g2.fillOval(15+x,10+y,20,20);
      g2.fillRect(15+x,20+y,20,15);
      g2.setColor(Color.white);//the eyes
      g2.fillOval(18+x,20+y,6,5);
      g2.fillOval(27+x,20+y,6,5);
      g2.setColor(Color.black);
      g2.drawOval(18+x,20+y,6,5);//the outlines
      g2.drawOval(27+x,20+y,6,5);
      g2.drawLine(22+x,30+y,29+x,30+y);
      }
   }
}