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
	private BigDecimal transactionAmount;

	public Transaction(String date, String type, int amt) {
		transactionNum = counter;	
		counter++;
		this.date = date;
		transactionType = type;
		transactionAmount = new BigDecimal(amt);
		
	}

	@Override
	public String toString() {
		return transactionNum + " " + date + " " +
				transactionType + " " + transactionAmount.toString();
	}
}
