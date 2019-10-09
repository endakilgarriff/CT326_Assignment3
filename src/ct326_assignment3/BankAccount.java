/*
 * Name: Enda Kilgarriff
 * Student ID: 17351606
 */

package ct326_assignment3;

import java.io.Serializable;
import java.util.ArrayList;

public class BankAccount implements Serializable {

	// Initialize variables and add generated serialVersionID to remove warnings.
	// Makes sure deserialized objects are compatible
	private static final long serialVersionUID = 4362913432545795666L;
	private int accNum = 0;
	private static int counter = 1000;
	private String name;
	private double balance;
	private String date;
	private transient double overdraft = 50; // Not serializable
	ArrayList<Transaction> transaction = new ArrayList<Transaction>();

	
	// Constructor
	public BankAccount(String date, String name, double balance) {
		accNum = counter;
		counter++;
		this.name = name;
		this.balance = balance;
		this.date = date;
		
		Transaction t = new Transaction(date, "Open Account", balance);
		transaction.add(t);
	}

	// Method takes deposited money and adds it to balance. Adds transaction to transaction ArrayList
	public void deposit(String date, double amount) {
		balance += amount;
		Transaction t = new Transaction(date, "Deposit", amount);
		transaction.add(t);
	}

	// Method checks if you have enough money (incl overdraft) in your account
	public void withdraw(String date, double amount) {
		if (amount > (balance + overdraft)) {
			System.out.println("Insufficient funds - Cannot withdraw " + amount);
		} else {
			balance -= amount;
			Transaction t = new Transaction(date, "Withdraw", amount);
			transaction.add(t);
		}
	}

	// Returns ArrayList of transactions that have been done
	public ArrayList<Transaction> getTransactionDetails() {
		return transaction;
	}

	@Override
	public String toString() {
		return "Account Number: " + accNum + " Name: " + name + " Balance: " + balance;
	}

}
