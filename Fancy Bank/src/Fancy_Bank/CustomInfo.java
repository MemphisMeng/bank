package Fancy_Bank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CustomInfo {
	static JLabel savingaccount;
	static JLabel checkingaccount;
	
	public static void mymain() {
       JFrame frame = new JFrame("Custom");
       // Setting the width and height of frame
       frame.setSize(700, 500);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       JPanel panel = new JPanel();    
       
       frame.add(panel);
       placeComponents(panel);

       frame.setLocation(500,300);
       frame.setVisible(true);
	}

	private static void placeComponents(JPanel panel) {

       panel.setLayout(null);

       JLabel userName = new JLabel("UserName: Jonny");
       userName.setBounds(10,10,300,25);
       panel.add(userName);
       
       JLabel userID = new JLabel("UserID: 007512358");
       userID.setBounds(10,40,300,25);
       panel.add(userID);
       
       checkingaccount = new JLabel("checking account: "+Params.Checkingaccount);
       checkingaccount.setBounds(10,70,250,25);
       panel.add(checkingaccount);
       savingaccount = new JLabel("Saving account: "+Params.savingaccount);
   }
}
