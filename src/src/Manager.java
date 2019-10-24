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
public class Manager {
    private String firstName;
    private String lastName;
    private String manager_ID;
    private String username;
    private byte pinHash[]; // Use it for security reasons
    
    public Manager(String username, String firstName, String lastName, String pin, Bank _bank) {
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
        this.manager_ID = _bank.getNewManagerID();
     }
    
    public Manager(String username, String firstName, String lastName, String pin, Bank _bank, String ID) {
        this(username, firstName, lastName, pin, _bank);
        this.manager_ID = ID;
     }
    
    public String getID() {
        return this.manager_ID;
    }
    
    public String getManagerAlias() {
        return this.username;
    }
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public String getPassword() {
        return Arrays.toString(this.pinHash);
    }
}