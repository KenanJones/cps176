package net.codejava.swing.jcheckbox;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SwingJCheckBoxDemo extends JFrame {
	// create three check boxes that allow selecting three numbers
	private JCheckBox checkboxOne = new JCheckBox("$100");
	private JCheckBox checkboxTwo = new JCheckBox("$200");
	private JCheckBox checkboxThree = new JCheckBox("$300");
	
	// a label and a text field to display sum
	//private JLabel labelSum = new JLabel("Sum: ");
	private JTextField textFieldSum = new JTextField(10);
	
	int sum = 0;	// sum of 3 numbers
	
	public SwingJCheckBoxDemo() {
		super("Swing JCheckBox Demo Program");
		setLayout(new FlowLayout());
		
		// add the check boxes to this frame
		add(checkboxOne);
		add(checkboxTwo);
		add(checkboxThree);
		
		//add(labelSum);
		
		//textFieldSum.setEditable(false);
		add(textFieldSum);
		
		// add action listener for the check boxes
		ActionListener actionListener = new ActionHandler(); 
		checkboxOne.addActionListener(actionListener);
		checkboxTwo.addActionListener(actionListener);
		checkboxThree.addActionListener(actionListener);
		
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			JCheckBox checkbox = (JCheckBox) event.getSource();
			if (checkbox.isSelected()) {
				if (checkbox == checkboxOne) {
					sum += 100;
				} else if (checkbox == checkboxTwo) {
					sum += 200;
				} else if (checkbox == checkboxThree) {
					sum += 300;
				}
			} else {
				if (checkbox == checkboxOne) {
					sum -= 100;
				} else if (checkbox == checkboxTwo) {
					sum -= 200;
				} else if (checkbox == checkboxThree) {
					sum -= 300;
				}
			}
			textFieldSum.setText(String.valueOf(sum));
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SwingJCheckBoxDemo().setVisible(true);
			}
		});
	}
}