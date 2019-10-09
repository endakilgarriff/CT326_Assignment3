/*
 * Name: Enda Kilgarriff
 * Student ID: 17351606
 */

package ct326_assignment3;

import java.io.Serializable;

public class Transaction implements Serializable{
	
	// Initialize variables and add generated serialVersionID to remove warnings.
	// Makes sure deserialized objects are compatible 
	private static final long serialVersionUID = -2173609649571449861L;
	private int transactionNum = 0;
	private static int counter = 1;
	private String date;
	private String type;
	private double amount;

	// Constructor
	public Transaction(String date, String type, double amt) {
		transactionNum = counter++; 
		this.date = date;
		this.type = type;
		amount = amt;
		
	}

	@Override
	public String toString() {
		return transactionNum + ". " + date + " " +	type + ": " + amount;
	}
}
