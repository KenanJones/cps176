import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class DrawToFile
{

  public static void main(String[] args) throws IOException
  {
    BufferedImage bimage = new BufferedImage(200, 200,
        BufferedImage.TYPE_BYTE_INDEXED);

    Graphics2D g2 = bimage.createGraphics();

    /*g2d.setColor(Color.red);
    g2d.fillOval(0,0,200,100);//(new Ellipse2D.Float(0, 0, 200, 100));*/
    g2.setColor(new Color(250,220,180));
    g2.drawOval(8,1,8,6);
    g2.fillOval(8,1,8,6);//position of corner, size
    g2.setColor(new Color(130,60,30));
    g2.drawLine(8,2,10,0);
    g2.drawLine(8,3,11,0);
    g2.drawLine(14,0,16,2);
    g2.drawLine(13,0,16,3);
    g2.drawLine(12,0,12,0);
    g2.setColor(new Color(160,130,90));
    g2.drawLine(12,4,12,4);
    g2.setStroke(new BasicStroke(3,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
    int [] xPoints = new int[]{10,10,30,30,30,20,20,20,10,20,30};
    int [] yPoints = new int[]{15,20,20,15,20,20,15,30,40,30,40};
    g2.drawPolyline(xPoints, yPoints, 11);
    ImageIO.write(bimage, "PNG", new File("testImage.png"));
    g2.dispose();
  }
}