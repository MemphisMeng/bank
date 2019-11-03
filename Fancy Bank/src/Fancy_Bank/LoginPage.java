package Fancy_Bank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Fancy_Bank.Bank;
import Fancy_Bank.Client;
import Fancy_Bank.Account;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField; 
import Fancy_Bank.MainPageCustom;
import Fancy_Bank.MainPageManager;
import Fancy_Bank.Params;

public class LoginPage {
	static JFrame frame = new JFrame("Welcome to Fancy Bank!");
	static JLabel showInfo = new JLabel("Please select your identity.");
	static Bank theBank = new Bank("Fancy Bank");
	
    public static void main(String[] args) {
    	
    	Client client = theBank.addClient("John", "Doe", "1234");
    	Account newAccount = new Account("Checking", client, theBank);
    	client.addAccount(newAccount);
    	theBank.addAccount(newAccount);
        // Initialize the JFrame object
        // Setting the width and height of frame
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(); 
        
        frame.add(panel);
        placeComponents(panel);      
//        ImageIcon icon=new ImageIcon("bankbg.jpg");
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

        frame.setLocation(500,300);
        
        frame.setVisible(true);
    }
    
    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);
        JLabel userLabel = new JLabel("User:");
        userLabel.setBounds(10,30,80,25);
        panel.add(userLabel);
 
        JTextField userText = new JTextField(20);
        userText.setBounds(10,60,165,25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10,90,80,25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(10,120,165,25);
        panel.add(passwordText);
        
        JButton loginmanager = new JButton("manager");
        loginmanager.setBounds(10, 0, 120, 25);
        addActionListenerloginmanager(loginmanager);
        panel.add(loginmanager);
        
        JButton logincustom = new JButton("custom");
        logincustom.setBounds(130, 0, 120, 25);
        addActionListenerlogincustom(logincustom);
        panel.add(logincustom);
        
        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 150, 80, 25);
        addActionListener(loginButton, userText, passwordText);
        panel.add(loginButton);
        
        showInfo.setBounds(10,180,300,25);
        panel.add(showInfo);
    }
    
    private static void addActionListener(JButton Button, JTextField userText, JPasswordField passwordText) {
        // Listening to Login action
        Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String accountNumber;
            	String password;
            	Client authClient;
            	
            	if (Params.role == 0) {
            		accountNumber = userText.getText();
	            	password = new String(passwordText.getPassword());
	            	authClient = theBank.userLogin(accountNumber, password);
	            	do {
	            		if (authClient == null) {
	            			JOptionPane.showMessageDialog(null,"Incorrect client ID/pin combination. Please try again.");
	            			userText.setText("");
	            			passwordText.setText("");
	            		}
	            	} while(authClient == null);
        		MainPageCustom.mymain();
				}
            	if (Params.role == 1) {
            		accountNumber = userText.getText();
	            	password = new String(passwordText.getPassword());
	            	authClient = theBank.userLogin(accountNumber, password);
            		do {
	            		if (authClient == null) {
	            			JOptionPane.showMessageDialog(null,"Incorrect manager ID/pin combination. Please try again.");
	            			userText.setText("");
	            			passwordText.setText("");
	            		}
	            	} while(authClient == null);
        		MainPageManager.mymain();
    
				}
            	
            }
        });
    }
    
    private static void addActionListenerlogincustom(JButton Button) {
        // Listening to Customers' Login action
        Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	showInfo.setText("Now you are custom!");
            	Params.role = 0;
            	JOptionPane.showMessageDialog(null, "Now you are custom!");
            }
        });
    }
    
    private static void addActionListenerloginmanager(JButton Button) {
        // Listening to Manager's Login
        Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	showInfo.setText("Now you are manager!");
            	Params.role = 1;
            	JOptionPane.showMessageDialog(null, "Now you are manager!");
            }
        });
    }
}
