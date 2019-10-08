package ct326_assignment3;

import java.io.Serializable;
import java.math.BigDecimal;

public class Transaction implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2173609649571449861L;
	private int transactionNum = 0;
	private static int counter = 1;
	private String date;
	private String transactionType;
	private double transactionAmount;

	public Transaction(String date, String type, double amt) {
		transactionNum = counter;	
		counter++;
		this.date = date;
		transactionType = type;
		transactionAmount = amt;
		
	}

	@Override
	public String toString() {
		return transactionNum + ". " + date + " " +
				transactionType + ": " + transactionAmount;
	}
}
