package ct326_assignment3;

import java.math.BigDecimal;

public class BankAccount {
	
	private String transaction;
	private int accNum = 0;
	private static int counter = 1000;
	private String name;
	private BigDecimal balance;
	private String date;

//	deposit(String date, double amount), withdraw(String date, double amount), 
//	getTransactionDetail(), and toString() override
	
	public BankAccount(String name, String date, BigDecimal amount) { 
		accNum = counter;
		counter++;
		this.name = name;
		balance = amount;
		this.date = date;
	
	}
	
	public void deposit(String date, double amount) {
		
	}
	
	public void withdraw(String date, double amount) {
		
	}
	
	public String getTransactionDetails() {
		return transaction;
	}
	
	@Override
	public String toString() {
		return accNum + " " + name + " " + balance;
	}

}
