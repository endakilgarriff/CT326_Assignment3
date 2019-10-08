/*
 * Name: Enda Kilgarriff
 * Student ID: 17351606
 */

package ct326_assignment3;

import java.io.*;

public class Test {

	public static void main(String[] args) {
		Test task = new Test();

		task.task1();
		task.task2();
	}

	public void task1() {
		Transaction[] t = new Transaction[3];
		Transaction t1 = new Transaction("16/08/2019", "Open Account", 100);
		Transaction t2 = new Transaction("22/08/2019", "Withdraw", 50);
		Transaction t3 = new Transaction("23/08/2019", "Deposit", 100);

		t[0] = t1;
		t[1] = t2;
		t[2] = t3;

		serializeFile("transaction.bin", t);

//		try {
//			file = new File("transactions.bin");
//			fos = new FileOutputStream(file);
//
//			if (!file.exists()) {
//				file.createNewFile();
//			}
//
//			oos = new ObjectOutputStream(fos);
//			oos.writeObject(t);
//
//		} catch (IOException e) {
//			System.out.println("File unsuccesfully created" + e.getMessage());
//		} finally {
//			if (fos != null) {
//				try {
//					fos.close();
//				} catch (IOException e) {
//					System.out.println("Error closing the File stream" + e.getMessage());
//				}
//			}
//			if (oos != null) {
//				try {
//					oos.close();
//				} catch (IOException e) {
//					System.out.println("Error closing the Object stream" + e.getMessage());
//				}
//			}
//		}

//		try {
//			fis = new FileInputStream("transactions.bin");
//			ois = new ObjectInputStream(fis);
//			System.out.println("Reading File: \n");
//			read = (Transaction[]) ois.readObject();
//
//			for (Transaction transaction : read) {
//				System.out.println(transaction.toString());
//			}
//
//		} catch (IOException e) {
//			System.out.println("Failed to read file" + e.getMessage());
//		} catch (ClassNotFoundException e) {
//			System.out.println("Failed to create object from file" + e.getMessage());
//		}

		Transaction[] readTransactions = (Transaction[]) deserializeFile("transaction.bin");

		for (Transaction transaction : readTransactions) {
			System.out.println(transaction.toString());
		}
	}

	public void task2() {

		BankAccount b1 = new BankAccount("16/08/2017", "Jenny, Lee", 150);

		b1.withdraw("16/08/2019", 200); // This will fail
		b1.deposit("22/08/2019", 100);
		b1.withdraw("01/09/2019", 50);
		
		serializeFile("accountDetails.bin", b1);
		BankAccount b1Read = (BankAccount) deserializeFile("accountDetails.bin");
		
		System.out.println(b1Read.getTransactionDetails());

	}

	public void serializeFile(String fileName, Object object) {
		File file;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			file = new File(fileName);
			fos = new FileOutputStream(file);

			if (!file.exists()) {
				file.createNewFile();
			}

			oos = new ObjectOutputStream(fos);
			oos.writeObject(object);

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
	}

	public Object deserializeFile(String fileName) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		Object read = null;

		try {
			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);
			System.out.println("Reading File: \n");
			read = ois.readObject();

		} catch (IOException e) {
			System.out.println("Failed to read file" + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to create object from file" + e.getMessage());
		}

		return read;
	}

}
