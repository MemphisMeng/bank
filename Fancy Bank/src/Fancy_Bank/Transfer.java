package Fancy_Bank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Transfer {
	public static void mymain(String ii, String jj, String kk) {
       JFrame showJframe = new JFrame("Custom");
       showJframe.setSize(500, 500);
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

       JLabel userName = new JLabel("Which account to transfer:");
       userName.setBounds(10,10,300,25);
       panel.add(userName);
       
       JTextField userText = new JTextField(20);
       userText.setBounds(10,40,300,25);
       panel.add(userText);
       
       JLabel Amount = new JLabel("Amount:");
       Amount.setBounds(10,70,300,25);
       panel.add(Amount);
       
       JTextField amountM = new JTextField(20);
       amountM.setBounds(10,100,300,25);
       panel.add(amountM);
       
       JButton submit = new JButton("submit");
       submit.setBounds(10, 130, 200, 25);
       addActionListenerATM(submit);
       panel.add(submit);
   }
	
	private static void addActionListenerATM(JButton Button) {
        Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(null, "successfully done!");
            }
        });
	}
}
