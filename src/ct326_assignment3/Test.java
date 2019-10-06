package ct326_assignment3;

import java.io.*;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		File file;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		List<Transaction> read = new ArrayList<Transaction>();
		
		ArrayList<Transaction> t = new ArrayList<Transaction>();
//		Transaction[] t = new Transaction[3];
		Transaction t1 = new Transaction("16/08/2019", "Open Account", 100);
		Transaction t2 = new Transaction("22/08/2019", "Withdraw", 50);
		Transaction t3 = new Transaction("23/08/2019", "Deposit", 100);

//		t[0] = t1;
//		t[1] = t2;
//		t[2] = t3;

		t.add(t1);
		t.add(t2);
		t.add(t3);

		try {
			file = new File("transactions.bin");
			fos = new FileOutputStream(file);

			if (!file.exists()) {
				file.createNewFile();
			}

			oos = new ObjectOutputStream(fos);
			oos.writeObject(t);
			System.out.println("File created successfully");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File unsuccesfully created" + e.getMessage());
			e.printStackTrace();
		} finally {
			if(fos != null) {
				try {
					fos.close();
				} catch(IOException e) {
					System.out.println("Error closing the File stream");
					e.printStackTrace();	
				}
			}
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					System.out.println("Error closing the Object stream");
					e.printStackTrace();
				}
			}
		}
		
		try {
			fis = new FileInputStream("transactions.bin");
			ois = new ObjectInputStream(fis);
			System.out.println("Reading File: \n");
			read = (List <Transaction>) ois.readObject();
			System.out.println(read.toString());
			System.out.println(read[0]);
			for(Transaction transaction: read) {
				System.out.println(read.toString());
			}
			
			
		} catch (IOException e) {
			System.out.println("Failed to read file" + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to create object from file" + e.getMessage());
		}
		
		
	}
}
