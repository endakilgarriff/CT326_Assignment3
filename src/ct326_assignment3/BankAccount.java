package ct326_assignment3;

import java.io.Serializable;
import java.math.BigDecimal;

public class BankAccount implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4362913432545795666L;
	private int accNum = 0;
	private static int counter = 1000;
	private String name;
	private double balance;
	private String date;
	private double overdraft = 0;
	//private String transaction;

	
	public BankAccount(String date, String name , double balance) { 
		accNum = counter;
		counter++;
		this.name = name;
		this.balance = balance;
		this.date = date;
	
	}
	
	public String deposit(String date, double amount) {
		balance += amount;
		return getTransactionDetails(date, "Deposit", amount);
	}
	
	public String withdraw(String date, double amount) {
		if(amount > (balance + overdraft)) {
			return "Insufficient funds";
		} 
		else {
			balance -= amount;
		}
		return getTransactionDetails(date, "Withdraw", amount);
		
		
	}
	
	public String getTransactionDetails(String date, String type, double amount) {
		Transaction t = new Transaction(date, type, amount);
		return t.toString();
	}
	
	@Override
	public String toString() {
		return "Account Number: " + accNum + " Name: " + name + " Balance: " + balance;
	}

}
