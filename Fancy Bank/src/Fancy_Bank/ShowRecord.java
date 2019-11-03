package Fancy_Bank;

import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Fancy_Bank.Params;

public class ShowRecord {
	public static void mymain(String ii, String jj, String kk) {
      JFrame showJframe = new JFrame("Custom");
      showJframe.setSize(500, 700);
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
      JLabel[] myLabel = new JLabel[100];
      for (int i = 0; i < Params.Custom_trade_recoder.size(); i++) {
		myLabel[i] = new JLabel((String)Params.Custom_trade_recoder.get(i));
		myLabel[i].setBounds(10,10+i*30,500,25);
		panel.add(myLabel[i]);
	}
  }
}
