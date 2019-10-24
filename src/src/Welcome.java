/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.OutputStream;
import java.nio.file.Files;
import javax.swing.JOptionPane;
import java.nio.file.Path;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;
import static java.nio.file.StandardOpenOption.WRITE;
import java.sql.*;

/**
 *
 * @author Anzhe Meng U50590533
 */
public class Welcome extends javax.swing.JFrame {
    
    public static Bank bank = new Bank("Fancy Bank");
//    public static File f1 = new File("Client_Data.txt"); 
//    public static File f2 = new File("Account_Data.txt");
//    public static File f3 = new File("Manager_Data.txt");
//    public static Path clientData = java.nio.file.Paths.get("Client_Data.txt");
//    public static Path accountData = java.nio.file.Paths.get("Account_Data.txt");
//    public static Path managerData = java.nio.file.Paths.get("Manager_Data.txt");
    public static String driver = "com.mysql.jdbc.Driver";
    public static String url = "jdbc:MySQL://192.168.1.2:3306/bank";
    public static String username = "root";
    public static String password = "Memphis_Meng2735";
    /**
     * Creates new form Welcome
     */
    public Welcome() {
//        try {
//            if (!f1.exists()) {
//                f1.createNewFile();
//            } 
//        } catch (IOException ex) {
//            JOptionPane.showMessageDialog(null, "Failed to create file Client_Data.txt!");
//            }
//        try {
//            if (!f2.exists()) {
//                f2.createNewFile();
//            } 
//        } catch (IOException ex) {
//            JOptionPane.showMessageDialog(null, "Failed to create file Account_Data.txt!");
//            }
//        try {
//            if (!f3.exists()) {
//                f3.createNewFile();
//            } 
//        } catch (IOException ex) {
//            JOptionPane.showMessageDialog(null, "Failed to create file Manager_Data.txt!");
//            }
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement statement = conn.createStatement();
            String sql_1 = "CREATE TABLE Client(" +
                    "Client_ID varchar(6) not null," +
                    "Username varchar(30) not null," +
                    "FirstName varchar(30) not null," +
                    "LastName varchar(30) not null," +
                    "Password varchar(30) not null," + 
                    "PRIMARY KEY (Client_ID))" +
                    "charset=utf8;";
            String sql_2 = "CREATE TABLE Client_Owned_Account(" +
                    "Client_ID varchar(6) not null," +
                    "Account_ID_1 varchar(30) not null," +
                    "Account_Name_1 varchar(30) not null," +
                    "Account_ID_2 varchar(30) not null," +
                    "Account_Name_2 varchar(30) not null," + 
                    "PRIMARY KEY (Client_ID))" +
                    "charset=utf8;";
            String sql_3 = "CREATE TABLE Account(" +
                    "Account_ID varchar(30) not null," +
                    "USD double not null," +
                    "RMB double not null," +
                    "HKD double not null," + 
                    "PRIMARY KEY (Account_ID))" +
                    "charset=utf8;";
            String sql_4 = "CREATE TABLE Manager(" +
                    "Manager_ID varchar(7) not null," +
                    "Alias varchar(30) not null," +
                    "FirstName varchar(30) not null," +
                    "LastName varchar(30) not null," +
                    "Password varchar(30) not null," + 
                    "PRIMARY KEY (Manager_ID))" +
                    "charset=utf8;";
         
            if (statement.executeLargeUpdate(sql_1) == 0) {
                JOptionPane.showMessageDialog(null, "Successfully create table Client");
            }
            if (statement.executeLargeUpdate(sql_2) == 0) {
                JOptionPane.showMessageDialog(null, "Successfully create table Client_Owned_Account");
            }
            if (statement.executeLargeUpdate(sql_3) == 0) {
                JOptionPane.showMessageDialog(null, "Successfully create table Account");
            }
            if (statement.executeLargeUpdate(sql_4) == 0) {
                JOptionPane.showMessageDialog(null, "Successfully create table Manager");
            }
            statement.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        Manager manager = new Manager("manager1", "Memphis", "Mong","123456", bank);
        String sql_save_manager = "INSERT INTO Manager VALUES('2345612', " +
                "'manager', 'Memphis', 'Mong', '123456');"; // To make it simple, I just hardcode a certain manager identity into the database.
        try {
            Statement statement = conn.createStatement();
            if (statement.executeLargeUpdate(sql_save_manager) == 0) {
                JOptionPane.showMessageDialog(null, "Successfully initialize the information of managers");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        managerButton = new javax.swing.JButton();
        clientButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -1, -1, 300));

        jLabel1.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome! What can I help you?");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 48, 400, 100));

        managerButton.setFont(new java.awt.Font("宋体", 1, 15)); // NOI18N
        managerButton.setText("Manager");
        managerButton.setName("managerButton"); // NOI18N
        managerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managerButtonActionPerformed(evt);
            }
        });
        getContentPane().add(managerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        clientButton.setFont(new java.awt.Font("宋体", 1, 15)); // NOI18N
        clientButton.setText("Client");
        clientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clientButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, -1, -1));

        jLabel2.setFont(new java.awt.Font("宋体", 1, 15)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Select your identity.");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 220, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void managerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managerButtonActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Good to see you again, boss!");
        dispose();
        new Manager_Login().setVisible(true);
    }//GEN-LAST:event_managerButtonActionPerformed

    private void clientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientButtonActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Welcome, client!");
        dispose();
        new Client_Login().setVisible(true);
    }//GEN-LAST:event_clientButtonActionPerformed
    
//    private void save(Manager manager) {
//        String s = "";
//        s += manager.getID() + " " + manager.getManagerAlias() + " " + manager.getFirstName() + " " + manager.getLastName() + " " + manager.getPassword();
//        
//        byte md[] = s.getBytes();
//
//        try (OutputStream out = new BufferedOutputStream(
//            Files.newOutputStream(Welcome.managerData, WRITE, TRUNCATE_EXISTING))) {
//            out.write(md, 0, md.length);
//        } catch (IOException ex) {
//            JOptionPane.showMessageDialog(null, "Error occurs when saving manager data!");
//        }
//    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Welcome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clientButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton managerButton;
    // End of variables declaration//GEN-END:variables
}
