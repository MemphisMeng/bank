package Fancy_Bank;

import java.util.ArrayList;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Client {
	private String firstName;
	private String lastName;
	private String client_ID;
	private byte pinHash[]; // Use it for security reasons
	private ArrayList<Account> accounts;
	
	public Client(String firstName, String lastName, String pin, Bank _bank) {
		this.firstName = firstName;
		this.lastName = lastName;
		
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
		
		System.out.printf("New user %s, %s with ID %s created.\n", lastName, firstName, this.client_ID);
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
	
	public void printAccountsSummary() {
		System.out.printf("\n\n%s's accounts summary\n", this.firstName);
		for (int a = 0; a < this.accounts.size(); a++) {
			System.out.printf("  %d) %s\n", a+1, this.accounts.get(a).getSummaryLine());
		}
	}
	
	public int numAccounts() {
		return this.accounts.size();
	}
	
	public void printAcctTransHistory(int acctIdx) {
		this.accounts.get(acctIdx).printTransHistory();
	}
	
	public double getAcctBalance(int acctIdx) {
		return this.accounts.get(acctIdx).getBalance();
	}
	
	public String getAcctID(int acctIdx) {
		return this.accounts.get(acctIdx).getID();
	}
	
	public void addAcctTransaction(int acctIdx, double amount, String memo) {
		this.accounts.get(acctIdx).addTransaction(amount, memo);
	}
}