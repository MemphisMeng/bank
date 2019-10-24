/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.ArrayList;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 *
 * @author Anzhe Meng U50590533
 */


public class Client {
	private String firstName;
	private String lastName;
	private String client_ID;
        private String username;
	private byte pinHash[]; // Use it for security reasons
	private ArrayList<Account> accounts;
	
	public Client(String username, String firstName, String lastName, String pin, Bank _bank) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			this.pinHash = md.digest(pin.getBytes());
		} catch (NoSuchAlgorithmException e) {
			System.err.println("error, caught NoSuchAlgorithmException");
			e.printStackTrace();
			System.exit(1);
		}
		
		this.client_ID = _bank.getNewClientID();
		
		this.accounts = new ArrayList<Account>();
		
//		System.out.printf("New user %s, %s with ID %s created.\n", lastName, firstName, this.client_ID);
	}
	
	public Client(String username, String firstName, String lastName, String pin, Bank _bank, String ID) {
            this(username, firstName, lastName, pin, _bank);
            this.client_ID = ID;
        }
        
        public void addAccount(Account account) {
		this.accounts.add(account);
	}
	
	public String getID() {
		return this.client_ID;
	}
	
	public boolean validatePin(String aPin) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			return MessageDigest.isEqual(md.digest(aPin.getBytes()), this.pinHash);
		} catch (NoSuchAlgorithmException e) {
			System.err.println("error, caught NoSuchAlgorithmException");
			e.printStackTrace();
			System.exit(1);
		}
		return false;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
        
        public String getLastName() {
                return this.lastName;
        }
	
        public String getUsername() {
                return this.username;
        }
        
//	public void printAccountsSummary() {
//		System.out.printf("\n\n%s's accounts summary\n", this.firstName);
//		for (int a = 0; a < this.accounts.size(); a++) {
//			System.out.printf("  %d) %s\n", a+1, this.accounts.get(a).getSummaryLine());
//		}
//	}
	
	public int numAccounts() {
		return this.accounts.size();
	}
	
	public void printAcctTransHistory(int acctIdx) {
		this.accounts.get(acctIdx).printTransHistory();
	}
	
	public double[] getAcctBalance(int acctIdx) {
		return this.accounts.get(acctIdx).getBalance();
	}
	
	public String getAcctID(int acctIdx) {
		return this.accounts.get(acctIdx).getID();
	}
        
        public ArrayList<Account> getAccounts() {
                return this.accounts;
        }
	
	public void addAcctTransaction(int acctIdx, double amount, String memo, Currency cur) {
		this.accounts.get(acctIdx).addTransaction(amount, memo, cur);
	}
        
        public String getPassword() {
            return Arrays.toString(this.pinHash);
        }
}
