/*
 * Name: Enda Kilgarriff
 * Student ID: 17351606
 */

package ct326_assignment3;

import java.io.*;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		Test task = new Test();

		// Calls separate methods for each task
		System.out.println("TASK 1");
		task.task1();
		System.out.println("\nTASK 2");
		task.task2();
		System.out.println("\nTASK 3");
		task.task3();
	}

	public void task1() {

		// Create transaction array and transaction objects as per assignment example
		Transaction[] t = new Transaction[3];
		Transaction t1 = new Transaction("16/08/2019", "Open Account", 100);
		Transaction t2 = new Transaction("22/08/2019", "Withdraw", 50);
		Transaction t3 = new Transaction("23/08/2019", "Deposit", 100);

		// Add objects to transaction object array
		t[0] = t1;
		t[1] = t2;
		t[2] = t3;

		// Send array and specified file name to be serialized
		serializeFile("transaction.bin", t);

		// Create new transaction array to hold transactions read back from file. Cast
		// read object.
		Transaction[] readTransactions = (Transaction[]) deserializeFile("transaction.bin");

		// Loop through array of transactions and print each one
		for (Transaction transaction : readTransactions) {
			System.out.println(transaction.toString());
		}
	}

	public void task2() {

		// Create bank account object
		BankAccount b1 = new BankAccount("16/08/2017", "Jenny, Lee", 150);

		// Add transactions made with created object
		b1.withdraw("16/08/2019", 200);
		b1.deposit("22/08/2019", 100);
		b1.withdraw("01/09/2019", 50);

		// Send bank account object to a file
		serializeFile("accountDetails.bin", b1);

		// Read bank account back from file and print transactions. Cast read object.
		BankAccount b1Read = (BankAccount) deserializeFile("accountDetails.bin");
		System.out.println(b1Read.toString());
		for (Transaction transaction : b1Read.getTransactionDetails()) {
			System.out.println(transaction.toString());
		}
	}

	public void task3() {

		// Initialize
		String fileName = "overdraft.txt";
		RandomAccessFile raf = null;
		Scanner input = null;

		// Try and catch to handle errors using IO stream, and finally statement to
		// always close resources
		try {
			// Finds created text file and reads contents
			raf = new RandomAccessFile(fileName, "rw");
			System.out.println(raf.readLine());
			raf.seek(raf.length());
			input = new Scanner(System.in);
			String answer = input.nextLine();

			if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no")) {
				raf.writeBytes(answer);
				System.out.println("Thank you, your request has been saved");
			} else {
				System.out.println("Please only type yes or no for an answer");
			}

		} catch (IOException e) {
			System.out.println("Failed to extract and append to file" + e.getMessage());
		} finally {
			try {
				input.close();
				raf.close();
			} catch (IOException e) {
				System.out.println("Failed to close resources " + e.getMessage());
			}
		}

	}

	// This method handles serializing of an object to a file
	public void serializeFile(String fileName, Object object) {

		// Initialize objects
		File file;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			file = new File(fileName);
			fos = new FileOutputStream(file);

			// Create new file if it doesn't exist
			if (!file.exists()) {
				file.createNewFile();
			}

			// Write chosen object to file
			oos = new ObjectOutputStream(fos);
			oos.writeObject(object);

		}
		// Errors that might occur when serializing are caught and resources are closed
		catch (IOException e) {
			System.out.println("File unsuccesfully created" + e.getMessage());
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					System.out.println("Error closing the File stream" + e.getMessage());
				}
			}
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					System.out.println("Error closing the Object stream" + e.getMessage());
				}
			}
		}
	}

	// This method handles reading an object from the stored file
	public Object deserializeFile(String fileName) {

		// Initialized variables
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		Object read = null;

		// Try/catch for IOStream,
		try {

			// Find file and read object from that file
			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);
			System.out.println("Reading File: ");
			read = ois.readObject();

		} catch (IOException e) {
			System.out.println("Failed to read file" + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to create object from file" + e.getMessage());
		}

		// Returns object read from file
		return read;
	}

}
