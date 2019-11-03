package Fancy_Bank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MainPageManager {
	
	public static void mymain() {
		 // Initialize JFrame object
        JFrame frame = new JFrame("Manager");
        // Setting the width and height of frame
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();    
        
        frame.add(panel);
        
        placeComponents(panel);

//        ImageIcon icon=new ImageIcon("manager.jpg");
//  		//将图片放入label中
//  		JLabel label=new JLabel(icon);		
//  		//设置label的大小
//  		label.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
//  		frame.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
//  		//获取frame的顶层容器,并设置为透明
//  		JPanel j=(JPanel)frame.getContentPane();
//  		j.setOpaque(false);
//  		panel.setOpaque(false);
//  		frame.setSize(icon.getIconWidth(),icon.getIconHeight());

        // 设置界面可见
        frame.setLocation(500,300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
	}

	private static void placeComponents(JPanel panel) {

        panel.setLayout(null);

        JButton viewCustoms = new JButton("view Custom info");
        viewCustoms.setBounds(10, 10, 300, 25);
        addActionListenerviewCustoms(viewCustoms);
        
        JButton generatereports = new JButton("Generate a Report");
        generatereports.setBounds(10, 50, 300, 25);
        addActionListenergeneratereports(generatereports);
        
        panel.add(generatereports);        
        panel.add(viewCustoms);
        
    }
	
	private static void addActionListenerviewCustoms(JButton Button) {
        // The action listener to inside viewing the customers
        Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 对话框
               CustomInfo.mymain();
            }
        });
    }
	
	private static void addActionListenergeneratereports(JButton saveButton) {
        // The action listener to daily report
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 对话框
            	ShowReportsForManager.mymain("", "", "");
            }
        });
    }
}
