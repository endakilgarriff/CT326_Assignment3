/*
 * Name: Enda Kilgarriff
 * Student ID: 17351606
 */

package ct326_assignment3;

import java.io.Serializable;

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
	private String transaction = "";

	public BankAccount(String date, String name, double balance) {
		accNum = counter;
		counter++;
		this.name = name;
		this.balance = balance;
		this.date = date;
		Transaction t = new Transaction(date, "Open Account", balance);
		transaction += t.toString();
	}

	public void deposit(String date, double amount) {
		balance += amount;
		Transaction t = new Transaction(date, "Deposit", amount);
		transaction += t.toString();
	}

	public void withdraw(String date, double amount) {
		if (amount > (balance + overdraft)) {
			System.out.println("Insufficient funds");
		} else {
			balance -= amount;
			Transaction t = new Transaction(date, "Deposit", amount);
			transaction += t.toString();
		}
	}

	public String getTransactionDetails() {
		return transaction;
	}

	@Override
	public String toString() {
		return "Account Number: " + accNum + " Name: " + name + " Balance: " + balance;
	}

}
