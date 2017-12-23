/**
 * @author Shaokang Jiang & Shein George
 */
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Library {
	public List<Book> books = new ArrayList<Book>();
	private String address;
	private String open;
	private String close;

	public Library(String libAddress) {
		address = libAddress;
	}
	public Library(String libAddress,String open1,String close1) {
		address = libAddress;
		open = open1;
		close = close1;
	}
	
	public static void main(String[] args) {
		// Create two libraries
		Library firstLibrary = new Library("10 Main St.");
		Library secondLibrary = new Library("228 Liberty St.");

		// Add four books to the first library
		firstLibrary.addBook(new Book("The Da Vinci Code"));
		firstLibrary.addBook(new Book("Le Petit Prince"));
		firstLibrary.addBook(new Book("A Tale of Two Cities"));
		firstLibrary.addBook(new Book("The Lord of the Rings"));

		// Print opening hours and the addresses
		System.out.println("Library hours:");
		printOpeningHours();
		System.out.println();

		System.out.println("Library addresses:");
		firstLibrary.printAddress();
		secondLibrary.printAddress();
		System.out.println();

		// Try to borrow The Lords of the Rings from both libraries
		System.out.println("Borrowing The Lord of the Rings:");
		firstLibrary.borrowBook("The Lord of the Rings");
		firstLibrary.borrowBook("The Lord of the Rings");
		secondLibrary.borrowBook("The Lord of the Rings");
		System.out.println();

		// Print the titles of all available books from both libraries
		System.out.println("Books available in the first library:");
		firstLibrary.printAvailableBooks();
		System.out.println();
		System.out.println("Books available in the second library:");
		secondLibrary.printAvailableBooks();
		System.out.println();

		// Return The Lords of the Rings to the first library
		System.out.println("Returning The Lord of the Rings:");
		firstLibrary.returnBook("The Lord of the Rings");
		System.out.println();

		// Print the titles of available from the first library
		System.out.println("Books available in the first library:");
		firstLibrary.printAvailableBooks();
	}
	
	public static void printOpeningHours() {
		System.out.println("Open from 9am to 5 pm.");
	}
	
	public String getOpeningHours() {
		return "Open from " + open + " to " + close;
	}
	
	public void setopen(String h) {
		open = h;
	}
	
	public void setclose(String h) {
		close = h;
	}
	
	public void addBook(Book newBook) {
		books.add(newBook);
	}
	
	public void printAddress() {
		System.out.println(address);
	}
	
	public String getAddress() {
		return address;
	}
	
	public void borrowBook(String title) {
		
		int q = books.size();
		for(int i=0; i<q; i++)
			if(books.get(i).getTitle().equals(title)) 
				if(books.get(i).isBorrowed()) {
					System.out.println("Sorry, this book is already borrowed.");
					return;
				}
				else {
					System.out.println("You successfully borrowed " + title);
					books.get(i).borrowed();
					books.get(i).borrowed = true;
					return;
				}
					
		System.out.println("Sorry, this book is not in our catalog.");
	
	}
	/**
	 * 
	 * @param title
	 * 			book title
	 * @param q1
	 * 			library order(at show)
	 * @param user
	 * 			Who borrow this book?
	 */
	public void borrowBook1(String title, int q1, String user) {//q1 present for library order.
		boolean l = false, l1 = false;;
		int q = books.size();
		for(int i=0; i<q; i++)
			if(books.get(i).getTitle().equals(title)) {
				l = true;
				if(books.get(i).isBorrowed()) {
					l1 = false;
				}
				else {
					if(books.get(i).borrowed1(q1,user)) {
						l1 = true;
						JOptionPane.showMessageDialog(null, "You successfully borrowed " + title);
					}
					else JOptionPane.showMessageDialog(null, "Unknown error happened!");
				}
			}
		if(!l1)JOptionPane.showMessageDialog(null, "Sorry, this book is already borrowed.");
		if(!l) JOptionPane.showMessageDialog(null, "Sorry, this book is not in our catalog.");
		
	
	}
	
	public void returnBook(String title) {
		int q = books.size();
		for(int i=0;i<q;i++) {
			if(books.get(i).getTitle().equals(title)) 
				if(books.get(i).isBorrowed()) {
					System.out.println("You successfully returned " + title);
					books.get(i).returned();
					return;
				}
				else {
					System.out.println("This book was not borrowed.");
					return;
				}
					
		System.out.println("Sorry, this book is not in our catalog.");	
	
		}

	}
	/**
	 * 
	 * @param title
	 * 			book title
	 * @param q1
	 * 			library order(at show)
	 * @param user
	 * 			Who borrow this book?
	 */
	public void returnBook1(String title, int q1, String user) {
		boolean l = false, l1 = false;
		int q = books.size();
		for(int i=0; i<q; i++)
			if(books.get(i).getTitle().equals(title)) {
				l = true;
				if(books.get(i).isBorrowed()) {
					l1 = false;
				}
				else {
					if(books.get(i).returned1(q1,user)) {
						l1 = true;
						JOptionPane.showMessageDialog(null, "You successfully returned " + title);
					}else JOptionPane.showMessageDialog(null, "Unknown error happened!");
				}
			}
		if(!l1)JOptionPane.showMessageDialog(null, "Sorry, this book is already borrowed.");
		if(!l) JOptionPane.showMessageDialog(null, "Sorry, this book is not in our catalog.");

	}
	
	public void printAvailableBooks() {
		if(books.size() == 0)
			System.out.println("No book in catalogue");
		for(int i=0; i<books.size(); i++) {
			if(!books.get(i).isBorrowed()) {
				System.out.print(books.get(i).getTitle());	
			}
		}
}
	public String printAvailablebook() {
		String s = "";
		s += "Title:";	
		for(int j=0;j<187;j++) {
			s += " ";
		}
		s += "Author:";
		for(int j=0;j<20;j++) {
			s += " ";
		}
		s += "Call number:";
		for(int j=0;j<18;j++) {
			s += " ";
		}
		s += "\n\n";
		if(books.size() == 0)
			s+="No book in catalogue";
		for(int i=0; i<books.size(); i++) {
			if(!books.get(i).isBorrowed()) {
				s += books.get(i).getTitle();	
				s += books.get(i).getTitle().length();
				for(int j=0;j<180-books.get(i).getTitle().length();j++) {
					s += " ";
				}
				s += books.get(i).getauthor();
				for(int j=0;j<20-books.get(i).getauthor().length();j++) {
					s += " ";
				}
				s += books.get(i).getcall();
				for(int j=0;j<30-books.get(i).getcall().length();j++) {
					s += " ";
				}
				s += "\n";
			}
		}
		s += "";
		s += "Borrowed books:\n";
		for(int i=0; i<books.size(); i++) {
			if(books.get(i).isBorrowed()) {
				s += books.get(i).getTitle();	
				for(int j=0;j<180-books.get(i).getTitle().length();j++) {
					s += " ";
				}
				s += books.get(i).getauthor();
				for(int j=0;j<20-books.get(i).getauthor().length();j++) {
					s += " ";
				}
				s += books.get(i).getcall();
				for(int j=0;j<30-books.get(i).getcall().length();j++) {
					s += " ";
				}
				s += "\n";
			}
		}
		
		return s;
	}
}

