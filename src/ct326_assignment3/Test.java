package ct326_assignment3;

import java.io.*;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.ObjectOutputStream;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;

public class Test {

	public static void main(String[] args) {
		Test task = new Test();
		
		//task.task1();
		task.task2();
	}
	
	public void task1() {
		File file;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		FileInputStream fis = null;
		ObjectInputStream ois = null;
		Transaction[] read = new Transaction[3];

		Transaction[] t = new Transaction[3];
		Transaction t1 = new Transaction("16/08/2019", "Open Account", 100);
		Transaction t2 = new Transaction("22/08/2019", "Withdraw", 50);
		Transaction t3 = new Transaction("23/08/2019", "Deposit", 100);

		t[0] = t1;
		t[1] = t2;
		t[2] = t3;

		try {
			file = new File("transactions.bin");
			fos = new FileOutputStream(file);

			if (!file.exists()) {
				file.createNewFile();
			}

			oos = new ObjectOutputStream(fos);
			oos.writeObject(t);

		} catch (IOException e) {
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

		try {
			fis = new FileInputStream("transactions.bin");
			ois = new ObjectInputStream(fis);
			System.out.println("Reading File: \n");
			read = (Transaction[]) ois.readObject();
			
			for (Transaction transaction : read) {
				System.out.println(transaction.toString());
			}
			
		} catch (IOException e) {
			System.out.println("Failed to read file" + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to create object from file" + e.getMessage());
		}
		
	}
	
	public void task2() {
		
		BankAccount b1 = new BankAccount("16/08/2017" ,"Jenny, Lee", 150);
		
		b1.withdraw("16/08/2019", 200); // This will fail
		b1.deposit("22/08/2019", 100);
		b1.withdraw("01/09/2019", 50);
		
		System.out.println(b1.getTransactionDetails());
		
		
		
	}
	
}
