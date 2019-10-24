/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.Date;

/**
 *
 * @author Anzhe Meng U50590533
 */
public class Transaction {
	private double amount;
	private Date timestamp;
	private String memo;
        private Currency currency;
	private Account account;
	
	public Transaction(double amount, Account account, Currency cur) {
		this.amount = amount;
		this.account = account;
		this.timestamp = new Date();
		this.memo = "";
                this.currency = cur;
	}
	
	public Transaction(double amount, String memo, Account account, Currency cur) {
		this(amount, account, cur);
		this.memo = memo;
	}
	
	public double getAmount() {
		return this.amount;
	}
        
        public Currency getCurrency() {
                return this.currency;
        }
	
	public String getSummaryLine() {
		if (this.amount >= 0) {
			return String.format("%s : $%.02f : %s", this.timestamp.toString(), this.amount, this.memo);
		} else {
			return String.format("%s : $(%.02f) : %s", this.timestamp.toString(), -this.amount, this.memo);
		}
	}
}

