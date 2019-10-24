/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.ArrayList;
import java.util.HashMap; 
import java.util.Map; 

/**
 *
 * @author Anzhe Meng U50590533
 */
public class Account {
	private String name;
//	private double balance;
        private HashMap<Currency, Double> balance_map = new Hashmap<>();
	private String account_ID;
	private Client holder;
	private ArrayList<Transaction> transactions;
	
	public Account(String name, Client holder, Bank _bank) {
		this.name = name;
		this.holder = holder;
		this.balance_map.put(Currency.USD,0.0);
                this.balance_map.put(Currency.RMB,0.0);
                this.balance_map.put(Currency.HKD,0.0);
		this.account_ID = _bank.getNewAccountID();
		this.transactions = new ArrayList<Transaction>();
	}
	
        public Account(String name, Client holder, Bank _bank, double usd, double rmb, double hkd) {
            this(name, holder, _bank);
            this.balance_map.put(Currency.USD, usd);
            this.balance_map.put(Currency.RMB, rmb);
            this.balance_map.put(Currency.HKD, hkd);
        }
        
	public String getID() {
		return this.account_ID;
	}
        
        public String getName() {
                return this.name;
        }
	
	public double[] getBalance() {
                double[] balanceList = new double[Currency.values().length];
		for (int i = 0; i < balanceList.length; i++) {
                    balanceList[i] = 0;
                }
		for (Transaction t: this.transactions) {
                    for (int i =0; i < balanceList.length; i++) {
			if (t.getCurrency().ordinal() == i) {
                            balanceList[i] += t.getAmount();
                        }
                    }
		}
		return balanceList;
	}
	
	public void printTransHistory() {
		System.out.printf("\nTransaction history for account %s\n", this.account_ID);
		for (int t = this.transactions.size() - 1; t >= 0; t--) {
			System.out.println(this.transactions.get(t).getSummaryLine());
		}
		System.out.println();
	}
	
	public void addTransaction(double amount, String memo, Currency cur) {
		Transaction newTrans = new Transaction(amount, memo, this, cur);
		this.transactions.add(newTrans);
	}
}
