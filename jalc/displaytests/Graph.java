import java.awt.*;

import javax.swing.*;

class Graph extends JPanel {

    /*public Graph() {
        setBackground(Color.WHITE);
    }*/

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawOval(10, 10, getWidth()-20, getHeight()-20);
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(500, 500);
        jFrame.add(new Graph());
        jFrame.setVisible(true);
    }
}