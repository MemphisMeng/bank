package Fancy_Bank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShowCurrency {
	public static void mymain(String ii, String jj, String kk) {
       JFrame showJframe = new JFrame("Custom");
       showJframe.setSize(500, 200);
       showJframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       JPanel panel = new JPanel();    
       showJframe.add(panel);
       placeComponents(panel,ii,jj,kk);
       showJframe.setVisible(true);
       showJframe.setLocation(500,300);
       showJframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	private static void placeComponents(JPanel panel,String ii, String jj, String kk) {
       panel.setLayout(null);
       JLabel userName = new JLabel("USD: "+ii);
       userName.setBounds(10,10,300,25);
       panel.add(userName);
       
       JLabel userID = new JLabel("CNY: "+jj);
       userID.setBounds(10,40,300,25);
       panel.add(userID);
       
       JLabel checkingaccount = new JLabel("Euro: "+kk);
       checkingaccount.setBounds(10,70,250,25);
       panel.add(checkingaccount);
   }
}
