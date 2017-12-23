import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * @author Shaokang Jiang & Shein George
 */
public class Book {

	String title;
	String call;
	String author;
	boolean borrowed = false;
	String borrowuser;

	// Creates a new Book
	public Book(String bookTitle) {
		title = bookTitle;
	}
	
	public Book(String bookTitle, String call1, String author1, boolean a, String borrow1) {
		title = bookTitle;
		call = call1;
		author = author1;
		borrowed = a;
		borrowuser = borrow1;
		
	}
	
	public String getborrowuser() {
		return borrowuser;
	}
	
	public void setborrowed(boolean d) {
		borrowed = d;
	}
	
	// Marks the book as borrowed
	public void borrowed() {
		borrowed = true;
	}
	/**
	 * 
	 * @param q1
	 * 			library order on screen
	 * @param user
	 * @return
	 */
	public boolean borrowed1(int q1, String user) {
		try {
		borrowed = true;
		String book = "";
		if(initial.bookversion==0) book = "Book.txt";
		else book = "Book" + initial.bookversion + ".txt";
		File myfile1 = new File(initial.getpath() + book);
		Scanner in = new Scanner(myfile1);
		initial.bookversion ++;
		book = "Book" + initial.bookversion + ".txt";
		FileOutputStream myfile=new FileOutputStream(initial.getpath() + book);
		PrintWriter myPW=new PrintWriter(myfile);
		while(in.hasNextLine()) {
			String j = in.nextLine();
			if(j.equals(title)) {
				myPW.println(j);
				myPW.println(in.nextLine());
				myPW.println(in.nextLine());
				String u1 = in.nextLine();
				String[] u2 = u1.split(",");
				String u3 = in.nextLine();
				String[] u4 = u3.split(",");
				int u = Integer.parseInt(u2[0]);
				if(u==(q1-1)&&(!Boolean.getBoolean(u4[0]))) {
					myPW.println(u1);
					myPW.println("true," + user + ",");
				}else {
					myPW.println(u1);
					myPW.println(u3);
				}
			}else {
				myPW.println(j);
				myPW.println(in.nextLine());
				myPW.println(in.nextLine());
				myPW.println(in.nextLine());
				myPW.println(in.nextLine());
			}
		}
		in.close();
		myPW.close();
		myfile.close();
		if(initial.upbook()) return true;
		else return false;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Sorry, some error happened.");
			e.printStackTrace();
			return false;
		}
		
	}
	
	// Marks the book as not borrowed
	public void returned() {
		borrowed = false;
	}
	/**
	 * 
	 * @param q1
	 * library order on screen
	 * @param user
	 * @return
	 */
	public boolean returned1(int q1, String user) {
		try {
			borrowed = true;
			String book = "";
			if(initial.bookversion==0) book = "Book.txt";
			else book = "Book" + initial.bookversion + ".txt";
			File myfile1 = new File(initial.getpath() + book);
			Scanner in = new Scanner(myfile1);
			initial.bookversion ++;
			book = "Book" + initial.bookversion + ".txt";
			FileOutputStream myfile=new FileOutputStream(initial.getpath() + book);
			PrintWriter myPW=new PrintWriter(myfile);
			while(in.hasNextLine()) {
				String j = in.nextLine();
				if(j.equals(title)) {
					myPW.println(j);
					myPW.println(in.nextLine());
					myPW.println(in.nextLine());
					String u1 = in.nextLine();
					String[] u2 = u1.split(",");
					String u3 = in.nextLine();
					String[] u4 = u3.split(",");
					int u = Integer.parseInt(u2[0]);
					if(u==(q1-1)&&(Boolean.getBoolean(u4[0]))) {
						myPW.println(u1);
						myPW.println("false," + user + ",");
					}else {
						myPW.println(u1);
						myPW.println(u3);
					}
				}else {
					myPW.println(j);
					myPW.println(in.nextLine());
					myPW.println(in.nextLine());
					myPW.println(in.nextLine());
					myPW.println(in.nextLine());
				}
			}
			in.close();
			myPW.close();
			myfile.close();
			if(initial.upbook()) return true;
			else return false;
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Sorry, some error happened.");
				e.printStackTrace();
				return false;
			}
		
	}
	
	// Returns true if the book is borrowed, false otherwise
	public boolean isBorrowed() {
		return borrowed;
	}
	
	public String isBorrowed1() {
		String h = "";
		if(borrowed) h = "Borrowed";
		else h = "In library";
		return h;
	}
	
	// Returns the title of the book
	public String getTitle() {
		return title;
	}
	
	public String getcall() {
		return call;
	}
	
	public String getauthor() {
		return author;
	}

	public static void main(String[] arguments) {
		// Small test of the Book class
		Book example = new Book("The Da Vinci Code");
		System.out.println("Title (should be The Da Vinci Code): " + example.getTitle());
		System.out.println("Borrowed? (should be false): " + example.isBorrowed());
		example.borrowed();
		System.out.println("Borrowed? (should be true): " + example.isBorrowed());
		example.returned();
		System.out.println("Borrowed? (should be false): " + example.isBorrowed());
	}
}
