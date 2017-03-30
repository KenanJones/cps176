 import javax.swing.*;
 import java.awt.event.*;
 
 public class PanelMaker extends JFrame implements ActionListener
 {
 private String[] list;
 private JCheckBox[] checks;
 private JPanel panel;
 private JLabel messageLabel;
 private JTextField kiloTextField;
 private JButton calcButton;
 private JCheckBox c1;
 private final int WINDOW_WIDTH = 310;
 private final int WINDOW_HEIGHT = 100;
   /**Constructor*/
   public PanelMaker()
   {
   setTitle("Kilometer Converter");
   setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   setLocationRelativeTo(null);  
   buildPanel();
   add(panel);
   setVisible(true);
   }
   /**The buildPanel method adds a label, a text field,and a button to a panel.*/
   private void buildPanel()
   {
   messageLabel = new JLabel("Enter a distance " + "in kilometers");
   // Create a text field 10 characters wide.
   kiloTextField = new JTextField(10);
   calcButton = new JButton("Calculate");
   calcButton.addActionListener(this);
   
   list = new String[]{"1","2","3","4"};
   checks = new JCheckBox[list.length];
   for(int i=0;i<list.length;i++)
      {
      JCheckBox cBox = new JCheckBox(list[i]);
      cBox.setActionCommand(list[i]);
      cBox.addActionListener(this);
      checks[i] = cBox;
      }   
   
   panel = new JPanel();
   // Add the label, text field, and button components to the panel.
   panel.add(messageLabel);
   panel.add(kiloTextField);
   panel.add(calcButton);
   for(int j=0;j<list.length;j++)
      {
      panel.add(checks[j]);
      }
   }
   
   public void actionPerformed(ActionEvent ae)
   {
   final double CONVERSION = 0.6214;
   String input; // To hold the user's input
   double miles; // The number of miles

   // Get the text entered by the user into the
   // text field.
   try{
      input = kiloTextField.getText();
   
      // Convert the input to miles.
      miles = Double.parseDouble(input) * CONVERSION;
   
      // Display the result.
      JOptionPane.showMessageDialog(null, input +
      " kilometers is " + miles + " miles.");
   }catch(NumberFormatException e){}
   
   for(int i = 0; i < 4; i++)
      {
      if(checks[i].isSelected()){System.out.print(list[i]);}
      if(i == 3){System.out.println("");}
      }
   //System.out.println(c1.isSelected());
   }
   /**main method*/
   public static void main(String[] args)
   {
   new PanelMaker();
   //System.exit(0); ends the program instantly.
   }
 }
