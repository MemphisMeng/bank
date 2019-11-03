package Fancy_Bank;

import java.util.ArrayList;
import java.util.Random;

public class Bank {
	private String name;
	private ArrayList<Client> clients; 
	private ArrayList<Account> accounts;
	
	public Bank(String name) {
		this.name = name;
		this.clients = new ArrayList<Client>();
		this.accounts = new ArrayList<Account>();
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
	
	public Client addClient(String firstName, String lastName, String pin) {
		Client newclient = new Client(firstName, lastName, pin, this);
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
	
	public String getName() {
		return this.name;
	}
	
	public ArrayList<Client> getClients() {
		return this.clients;
	}
}
