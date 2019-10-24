/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.ArrayList;
import java.util.Random;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import static src.Welcome.driver;
import static src.Welcome.password;
import static src.Welcome.url;
import static src.Welcome.username;

/**
 *
 * @author Anzhe Meng U50590533
 */


public class Bank {
	private String name;
	private ArrayList<Client> clients; 
	private ArrayList<Account> accounts;
        private ArrayList<Manager> managers;
	
	public Bank(String name) {
                this.name = name;
		this.clients = new ArrayList<Client>();
		this.accounts = new ArrayList<Account>();
                this.managers = new ArrayList<Manager>();
                
                String s1 = "SELECT * FROM Client;";
                String s2 = "SELECT cAID1.cID,cAID1.AID1,cAID1.Aname1,cAID2.AID2,"
                        + "cAID2.Aname2, cAID1.AID1_HKD,cAID2.AID2_HKD, "
                        + "cAID1.AID1_USB,cAID2.AID2_USB, cAID1.AID1_RMB,"
                        + "cAID2.AID2_RMB FROM (SELECT Client_Owned_Account.Client_ID cID,"
                        + " Client_Owned_Account.Account_ID_1 AID1, "
                        + "Client_Owned_Account.Account_Name_1 Aname1, "
                        + "Account.HKD AID1_HKD,Account.USD AID1_USB,Account.RMB "
                        + "AID1_RMB FROM Client_Owned_Account LEFT JOIN Account "
                        + "ON Client_Owned_Account.Account_ID_1=Account.Account_ID)"
                        + " cAID1 LEFT ON (SELECT Client_Owned_Account.Client_ID"
                        + " cID, Client_Owned_Account.Account_ID_2 AID2, "
                        + "Client_Owned_Account.Account_Name_2 Aname2, Account.HKD "
                        + "AID2_HKD,Account.USD AID2_USB,Account.RMB AID2_RMB "
                        + "FROM Client_Owned_Account LEFT JOIN Account ON "
                        + "client.Account_ID_2=Account.Account_ID) cAID2 ON"
                        + " cAID1.cID=cAID2.cID";
                String s3 = "SELECT * FROM Manager;";
                
                try {
                    Class.forName(driver);
                    Connection conn = DriverManager.getConnection(url, username, password);
                    Statement statement = conn.createStatement();
                    ResultSet rs1 = statement.executeQuery(s1);
                    ResultSet rs2 = statement.executeQuery(s2);
                    ResultSet rs3 = statement.executeQuery(s3);
                    ResultSet rs4 = statement.executeQuery(s4);
           
                    while (rs1.next()) {
                        String cID = rs1.getString(1);
                        String un = rs1.getString(2);
                        String fn = rs1.getString(3);
                        String ln = rs1.getString(4);
                        String pw = rs1.getString(5);
                        this.clients.add(new Client(un, fn, ln, pw, this, cID));
                    }
                    
                    while (rs2.next()) {
                        
                    }
                    
                    while (rs3.next()) {
                        String mID = rs1.getString(1);
                        String un = rs1.getString(2);
                        String fn = rs1.getString(3);
                        String ln = rs1.getString(4);
                        String pw = rs1.getString(5);
                        this.managers.add(new Manager(un, fn, ln, pw, this, mID));
                    }
                } catch (Exception e) {
                            
                            }
        }
        
	public String getNewClientID() {
		String ID;
		Random rng = new Random();
		int len = 6;
		boolean nonUnique;
		
		do {
			ID = "";
			for (int i = 0; i < len; i++) {
				ID += ((Integer)rng.nextInt(10)).toString();
			}
			
			nonUnique = false;
			for (Client c: this.clients) {
				if (ID.compareTo(c.getID()) == 0) {
					nonUnique = true;
					break;
				}
			}
		} while (nonUnique);
		
		return ID;
	}
	
        public String getNewManagerID() {
		String ID;
		Random rng = new Random();
		int len = 7;
		boolean nonUnique;
		
		do {
			ID = "";
			for (int i = 0; i < len; i++) {
				ID += ((Integer)rng.nextInt(10)).toString();
			}
			
			nonUnique = false;
			for (Manager m: this.managers) {
				if (ID.compareTo(m.getID()) == 0) {
					nonUnique = true;
					break;
				}
			}
		} while (nonUnique);
		
		return ID;
	}
        
	public String getNewAccountID() {
		String ID;
		Random rng = new Random();
		int len = 10;
		boolean nonUnique;
		
		do {
			ID = "";
			for (int i = 0; i < len; i++) {
				ID += ((Integer)rng.nextInt(10)).toString();
			}
			
			nonUnique = false;
			for (Account a: this.accounts) {
				if (ID.compareTo(a.getID()) == 0) {
					nonUnique = true;
					break;
				}
			}
		} while (nonUnique);
		
		return ID;
	}
	
	public void addAccount(Account account) {
		this.accounts.add(account);
	}
	
	public Client addClient(String username, String firstName, String lastName, String pin) {
		Client newclient = new Client(username, firstName, lastName, pin, this);
		this.clients.add(newclient);
		
		Account newAccount = new Account("Savings", newclient, this);
		newclient.addAccount(newAccount);
		this.accounts.add(newAccount);
		
		return newclient;
	}
	
	public Client userLogin(String userID, String pin) {
		for (Client c: this.clients) {
			if (c.getID().compareTo(userID) == 0 && c.validatePin(pin)) {
				return c;
			}
		}
		
		return null;
	}
        
        public Account accountSearch(String acctID) {
            for (Account a: this.accounts) {
                if (acctID.equals(a.getID())) {
                    return a;
                }
            }
            return null;
        }
	
	public String getName() {
		return this.name;
	}
	
	public ArrayList<Client> getClients() {
		return this.clients;
	}
}
