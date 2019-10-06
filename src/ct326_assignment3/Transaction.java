package ct326_assignment3;

import java.math.BigDecimal;

public class Transaction {

	private static int transactionNum = 0;
	private static int transNumCounter = 1;
	private String transactionDate;
	private String transactionType;
	private BigDecimal transactionAmount;

	public Transaction(String date, String type, BigDecimal amt) {
		transactionNum = transNumCounter;	
		transNumCounter++;
		transactionDate = date;
		transactionType = type;
		transactionAmount = amt;
	}

	public String toString() {

		return transactionNum + " " + transactionDate + " " +
				transactionType + " " + transactionAmount;
	}
}
