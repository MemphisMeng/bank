package Fancy_Bank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Fancy_Bank.Params;

public class Loan {
	static JTextField userText;
	static JTextField toLoan;
	
	public static void mymain() {
      JFrame showJframe = new JFrame("Custom");
      // Setting the width and height of frame
      showJframe.setSize(500, 200);
      showJframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      JPanel panel = new JPanel();
      showJframe.add(panel);
      placeComponents(panel);

      showJframe.setVisible(true);
      showJframe.setLocation(500,300);
      showJframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	private static void placeComponents(JPanel panel) {

      panel.setLayout(null);

      JLabel userName = new JLabel("Amount of USD: ");
      userName.setBounds(10,10,300,25);
      panel.add(userName);
      
      userText = new JTextField(20);
      userText.setBounds(10,40,165,25);
      panel.add(userText);
      
      JLabel userID = new JLabel("What to mortgage: ");
      userID.setBounds(10,70,300,25);
      panel.add(userID);
      
      toLoan = new JTextField(20);
      toLoan.setBounds(10,100,300,25);
      panel.add(toLoan);
      
      JButton submitButton = new JButton("submit");
      submitButton.setBounds(10, 130, 200, 25);
      addActionListenerloan(submitButton);
      panel.add(submitButton);
  }
	
	private static void addActionListenerloan(JButton saveButton) {
        // Action Listener of the loaning button
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 Params.mortgageThings = toLoan.getText();
            	 Params.moneytoLoan = userText.getText();
            	 System.out.println(Params.mortgageThings+":"+Params.moneytoLoan);
            	 JOptionPane.showMessageDialog(null, "Submitted!");
            	 CreateList.myListCustom("Submit a loan");
            }
        });
    }

}
