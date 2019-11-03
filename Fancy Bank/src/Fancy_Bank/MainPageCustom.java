package Fancy_Bank;

import java.awt.event.ActionEvent;
import Fancy_Bank.ShowCurrency;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import Fancy_Bank.Params;
import Fancy_Bank.Loan;
import Fancy_Bank.ATM;


public class MainPageCustom {
	
	static JLabel savingaccount;
	static JLabel checkingaccount;
	
	public static void mymain() {
		 // Initialize JFrame object
        JFrame frame = new JFrame("Custom");
        // Setting the width and height of frame
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();    
        frame.add(panel);
        /**
         * Customized method of designing the panel
         */
        placeComponents(panel);
    
//        ImageIcon icon=new ImageIcon("custom.jpg");
//		//Image im=new Image(icon);
//		//将图片放入label中
//		JLabel label=new JLabel(icon);		
//		//设置label的大小
//		label.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
//		frame.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
//		//获取frame的顶层容器,并设置为透明
//		JPanel j=(JPanel)frame.getContentPane();
//		j.setOpaque(false);
//		panel.setOpaque(false);
//		frame.setSize(icon.getIconWidth(),icon.getIconHeight());

        // 设置界面可见
        frame.setLocation(500,300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
	}
	
	private static void placeComponents(JPanel panel) {

        panel.setLayout(null);

        JLabel userName = new JLabel("UserName: Memphis");
        userName.setBounds(10,10,300,25);
        panel.add(userName);
        
        JLabel userID = new JLabel("UserID: 50590533");
        userID.setBounds(10,40,300,25);
        panel.add(userID);
        
        checkingaccount = new JLabel("checking account: "+Params.Checkingaccount);
        checkingaccount.setBounds(10,70,250,25);
        panel.add(checkingaccount);
        savingaccount = new JLabel("Saving account: "+Params.savingaccount);
        savingaccount.setBounds(10,100,250,25);
        panel.add(savingaccount);

        JButton Bcheckingaccount = new JButton("Balance");
        Bcheckingaccount.setBounds(250, 70, 80, 25);
        addActionListenerBcheckingaccount(Bcheckingaccount);
        panel.add(Bcheckingaccount);
        
        JButton Bsavingaccount = new JButton("Balance");
        Bsavingaccount.setBounds(250, 100, 80, 25);
        addActionListenerBsavingaccount(Bsavingaccount);
        panel.add(Bsavingaccount);
        
        JButton creataccount = new JButton("CreatAccounts");
        creataccount.setBounds(10, 130, 200, 25);
        addActionListenercreataccount(creataccount);
        panel.add(creataccount);
        
        JButton loan = new JButton("Apply for loan");
        loan.setBounds(10, 160, 200, 25);
        addActionListenerloan(loan);
        panel.add(loan);
        
        JButton ATM = new JButton("ATM");
        ATM.setBounds(10, 190, 200, 25);
        addActionListenerATM(ATM);
        panel.add(ATM);
        
    }
	
	private static void addActionListenerBcheckingaccount(JButton Button) {
        // The action listener to checking account movement
        Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ShowCurrency.mymain("12.50", "990.560", "5.10");
                CreateList.myListCustom("view accounts");
            }
        });
    }
	
	private static void addActionListenerBsavingaccount(JButton Button) {
        // The action listener to saving account movement
        Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 ShowCurrency.mymain("54.10", "542.45", "20.00");
            	 CreateList.myListCustom("view accounts");
            }
        });
    }
	
	private static void addActionListenercreataccount(JButton Button) {
        // The action listener to creating account movement
        Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
            	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
            	df.format(System.currentTimeMillis());
            	Params.operationsList.add((String)df.format(System.currentTimeMillis())+"Creat accounts");

            	Params.Checkingaccount = "145151351512";
            	Params.savingaccount = "9414846463115";
            	savingaccount.setText("Saving account: "+Params.savingaccount);
            	checkingaccount.setText("checking account: "+Params.Checkingaccount);
            	JOptionPane.showMessageDialog(null, "Your accounts is created by our bank!");
            	CreateList.myListCustom("Creat accounts");
            }
        });
    }
	
	private static void addActionListenerloan(JButton Button) {
        // The action listener to loaning movement
        Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 对话框
            	Loan.mymain();
            	CreateList.myListCustom("Apply for a loan");
            }
        });
    }
	
	private static void addActionListenerATM(JButton Button) {
        // The action listener to opening the ATM
        Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 对话框
            	ATM.mymain();
            	CreateList.myListCustom("open ATM");
            }
        });
    }
}
