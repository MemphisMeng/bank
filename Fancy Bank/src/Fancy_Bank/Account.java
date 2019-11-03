package Fancy_Bank;

import java.util.ArrayList;

public class Account {
	private String name;
	private double balance;
	private String account_ID;
	private Client holder;
	private ArrayList<Transaction> transactions;
	
	public Account(String name, Client holder, Bank _bank) {
		this.name = name;
		this.holder = holder;
		
		this.account_ID = _bank.getNewAccountID();
		this.transactions = new ArrayList<Transaction>();
	}
	
	public String getID() {
		return this.account_ID;
	}
	
	public String getSummaryLine() {
		double balance = this.getBalance();
		
		if (balance >= 0) {
			return String.format("%s: $%.02f : %s", this.account_ID, balance, this.name);
		} else {
			return String.format("%s: $(%.02f) : %s", this.account_ID, balance, this.name);
		}
	}
	
	public double getBalance() {
		double balance = 0;
		for (Transaction t: this.transactions) {
			balance += t.getAmount();
		}
		return balance;
	}
	
	public void printTransHistory() {
		System.out.printf("\nTransaction history for account %s\n", this.account_ID);
		for (int t = this.transactions.size() - 1; t >= 0; t--) {
			System.out.println(this.transactions.get(t).getSummaryLine());
		}
		System.out.println();
	}
	
	public void addTransaction(double amount, String memo) {
		Transaction newTrans = new Transaction(amount, memo, this);
		this.transactions.add(newTrans);
	}
}