package ct326_assignment3;

import java.io.Serializable;
import java.math.BigDecimal;

public class Transaction implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2173609649571449861L;
	private int transactionNum = 0;
	private static int transNumCounter = 1;
	private String transactionDate;
	private String transactionType;
	private BigDecimal transactionAmount;

	public Transaction(String date, String type, int amt) {
		transactionNum = transNumCounter;	
		transNumCounter++;
		transactionDate = date;
		transactionType = type;
		transactionAmount = new BigDecimal(amt);
		
	}

	@Override
	public String toString() {
		return transactionNum + " " + transactionDate + " " +
				transactionType + " " + transactionAmount.toString();
	}
}
