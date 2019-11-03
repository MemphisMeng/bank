package Fancy_Bank;

import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Fancy_Bank.CreateList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Fancy_Bank.Params;
import Fancy_Bank.Transfer;

public class ATM {
	static JLabel Checkingaccount;
	static JButton toLoan;
	static JLabel savingbalance;
	
	public static void mymain() {
      JFrame showJframe = new JFrame("Custom");
      showJframe.setSize(500, 500);
      showJframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      JPanel panel = new JPanel();    

      placeComponents(panel);
           
//      ImageIcon icon=new ImageIcon("atm.jpg");
//		//Image im=new Image(icon);
//		//将图片放入label中
//		JLabel label=new JLabel(icon);		
//		//设置label的大小
//		label.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
//		showJframe.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
//		//获取frame的顶层容器,并设置为透明
//		JPanel j=(JPanel)showJframe.getContentPane();
//		j.setOpaque(false);
//		panel.setOpaque(false);
//		showJframe.setSize(icon.getIconWidth(),icon.getIconHeight());

      showJframe.setVisible(true);
      showJframe.setLocation(500,300);
      showJframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private static void placeComponents(JPanel panel) {
      panel.setLayout(null);

      savingbalance = new JLabel("Saving account:"+Params.savingaccount);
      savingbalance.setBounds(10,10,300,25);
      panel.add(savingbalance);
      
      Checkingaccount = new JLabel("Checking account:"+Params.Checkingaccount);
      Checkingaccount.setBounds(10,40,300,25);
      panel.add(Checkingaccount);
      
      toLoan = new JButton("Loan");
      toLoan.setBounds(10,70,300,25);
      addActionListenerloan(toLoan);
      panel.add(toLoan);
      
      JButton Transfer = new JButton("Transfer");
      Transfer.setBounds(10, 100, 300, 25);
      addActionListenerTransfer(Transfer);
      panel.add(Transfer);
      
      JButton deposit = new JButton("Deposit");
      deposit.setBounds(10, 130, 300, 25);
      addActionListenerDeposit(deposit);
      panel.add(deposit);
      
      JButton withdraw = new JButton("Withdraw");
      withdraw.setBounds(10, 160, 300, 25);
      addActionListenerWithdraw(withdraw);
      panel.add(withdraw);
      
      JButton View = new JButton("View balance");
      View.setBounds(10, 200, 300, 25);
      addActionListenerView(View);
      panel.add(View);   
	}
	
	private static void addActionListenerloan(JButton Button) {
        Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Loan.mymain();
            	CreateList.myListCustom("Apply for a loan");
            	JOptionPane.showMessageDialog(null, "You will be charged $0.05!");
            }
        });
    }
	
	private static void addActionListenerTransfer(JButton saveButton) {
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Transfer.mymain("","","");
            	CreateList.myListCustom("Transfer money");
            	JOptionPane.showMessageDialog(null, "You will be charged $0.05!");
            }
        });
    }
	
	private static void addActionListenerDeposit(JButton saveButton) {
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Deposit.mymain("","","");
            	CreateList.myListCustom("Deposit");
            	JOptionPane.showMessageDialog(null, "You will be charged $0.05!");
            }
        });
    }
	
	private static void addActionListenerWithdraw(JButton saveButton) {
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Withdraw.mymain("","","");
            	CreateList.myListCustom("Withdraw");
            	JOptionPane.showMessageDialog(null, "You will be charged $0.05!");
            }
        });
    }
	
	private static void addActionListenerView(JButton saveButton) {
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ShowRecord.mymain("","","");
            	CreateList.myListCustom("View record");
            }
        });
    }
}
