/**
 * @author Shaokang Jiang & Shein George
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class initial {

	private static String path;
	private static boolean userstatu = false;
	private static String Admin;
	private static String Book;
	private static String user;
	private static boolean bookstatu = false;
	private static boolean librarystatu = false;
	public static int bookversion = 0;
	public static int userversion = 0;
	public static int libraryversion = 0;
	/**
	 * library object
	 */
	public List<Library> library1 = new ArrayList<Library>();
	public static initial initial = new initial();
	
	public initial() {
	}
	
	public static void setPath() {
		path = System.getProperty("java.io.tmpdir");
	}
	
	public static String getpath() {
		return path;
	}
	
	public static boolean getuserstatu() {
		return userstatu;
	}
	
	public static boolean getbookstatu() {
		return bookstatu;
	}
	
	public static boolean getlibrarystatu() {
		return librarystatu;
	}
	
	public static boolean userdata() throws InterruptedException {
		userstatu = false;
		int i=0;
		while(userstatu==false) {
			userstatu = FTP.downFile("*SERVER*", 21, "*USERNAME*", "*PASSWORD*", "/", "User.txt", getpath());  
			i++;
			if(i>5) {
				JOptionPane.showMessageDialog(null, "Some error happened. Please make sure you have internet connection. Please re-open program.");
				Thread.sleep(5000);
				System.exit(1);
				break;
			}
		}
		return userstatu;
	}
	/**
	 * 
	 * @param name
	 * 			username
	 * @param password
	 * @param usertype
	 * 			1 for admin, 2 for other users, no other choice
	 * @param limitation
	 * 			limit books that he can borrow
	 * @return
	 */
	public static boolean adduser(String name,String password, int usertype, int limitation) {
			boolean l = true;
			try {
				String user1 = "";
				if(userversion==0) user1 = "User.txt";
				else user1 = "User" + userversion + ".txt";
				File w = new File(path + user1);
				Scanner in = new Scanner(w);
				while(in.hasNextLine()) {
				if((in.nextLine().equals(name))) {
					in.nextLine();
					int y = Integer.parseInt(in.nextLine());
					if(y==usertype) {
					JOptionPane.showMessageDialog(null, "User exist.");
					in.close();
					l = false;
					return false;
					}
				}
				in.nextLine();
				}
				in.close();
				if(l) {
					FileOutputStream r = new FileOutputStream(path + user1,true);
					PrintWriter t = new PrintWriter(r);
					t.println(name);
					t.println(password);
					t.println(usertype);
					t.println(limitation);
					t.close();
					r.close();
				}
			} catch (IOException e) {
				l = false;
				e.printStackTrace();
			}
		return l;
	}
	/**
	 * 
	 * @param address
	 * 			library address
	 * @param open
	 * 			open hour
	 * @param close
	 * 			close hour
	 * @return
	 */
	public static boolean addlibrary(String address,String open, String close) {
		boolean l = true;
		try {
			String Library = "";
			if(libraryversion==0) Library = "Library.txt";
			else Library = "Library" + libraryversion + ".txt";
			File w = new File(path + Library);
			Scanner in = new Scanner(w);
			while(in.hasNextLine()) {
			if(in.nextLine().equals(address)) {
				JOptionPane.showMessageDialog(null, "Library exist.");
				in.close();
				l = false;
				return false;
			}
			}
			in.close();
			if(l) {
				FileOutputStream r = new FileOutputStream(path + Library,true);
				PrintWriter t = new PrintWriter(r);
				t.println(address);
				t.println(open);
				t.println(close);
				t.close();
				r.close();
			}
		} catch (IOException e) {
			l = false;
			e.printStackTrace();
		}
	return l;
}
	
	
/**
 * 
 * @param address
 * 			only need library address
 * @return
 */
	public static boolean deletelibrary(String address) {
		boolean l = true;
		boolean l1 = true;
		try {
			String Library = "";
			if(libraryversion==0) Library = "Library.txt";
			else Library = "Library" + libraryversion + ".txt";
			File w = new File(path + Library);
			Scanner in = new Scanner(w);
			libraryversion ++;
			Library = "Library" + libraryversion + ".txt";
			FileOutputStream r = new FileOutputStream(path + Library);
			PrintWriter t = new PrintWriter(r); 
			while(in.hasNextLine()) {
				String y = in.nextLine();
				if(y.equals(address)) {
					in.nextLine();
					in.nextLine();
					l1 = false;
				}else {
					t.println(y);
					t.println(in.nextLine());
					t.println(in.nextLine());
				}
			}
			t.close();
			r.close();
			in.close();
		} catch (IOException e) {
			l = false;
			e.printStackTrace();
		}
		if(l1) JOptionPane.showMessageDialog(null, "Sorry, library does not exist.");
	return l;
}
	
	
	
	public static boolean changelibrary(String address,String open, String close) {
		boolean l = true;
		boolean l1 = true;
		try {
			String Library = "";
			if(libraryversion==0) Library = "Library.txt";
			else Library = "Library" + libraryversion + ".txt";
			File w = new File(path + Library);
			Scanner in = new Scanner(w);
			libraryversion ++;
			Library = "Library" + libraryversion + ".txt";
			FileOutputStream r = new FileOutputStream(path + Library);
			PrintWriter t = new PrintWriter(r); 
			while(in.hasNextLine()) {
				String y = in.nextLine();
				if(y.equals(address)) {
					t.println(y);
					t.println(open);
					t.println(close);
					in.nextLine();
					in.nextLine();
					l1 = false;
				}else {
					t.println(y);
					t.println(in.nextLine());
					t.println(in.nextLine());
				}
			}
			t.close();
			r.close();
			in.close();
		} catch (IOException e) {
			l = false;
			e.printStackTrace();
		}
		if(l1) JOptionPane.showMessageDialog(null, "Sorry, library does not exist.");
	return l;
}
	/**
	 * 
	 * @param name
	 * 			username
	 * @param usertype
	 * 			1 = admin, 2 = normal user
	 * @return
	 */
	public static boolean deleteuser(String name,int usertype) {
		boolean l = true;
		try {
			String user1 = "";
			if(userversion==0) user1 = "User.txt";
			else user1 = "User" + userversion + ".txt";
			File w = new File(path + user1);
			Scanner in = new Scanner(w);
			userversion ++;
			user1 = "User" + userversion + ".txt";
			FileOutputStream r = new FileOutputStream(path + user1);
			PrintWriter t = new PrintWriter(r); 
			while(in.hasNextLine()) {
				String y = in.nextLine();
				String y1 = in.nextLine();
				int y2 = Integer.parseInt(in.nextLine());
				if((y.equals(name))&&(y2==usertype)) {
					in.nextLine();
				}else {
					t.println(y);
					t.println(y1);
					t.println(y2);
					t.println(in.nextLine());
				}
			}
			t.close();
			r.close();
			in.close();
			l = true;
		} catch (IOException e) {
			l = false;
			e.printStackTrace();
		}
	return l;
}
	/**
	 * 
	 * @param name
	 * 			username
	 * @param password
	 * @param usertype
	 * 			1 for admin, 2 for other users, no other choice
	 * @param limitation
	 * 			limit books that he can borrow
	 * @return
	 */
	public static boolean changeuser(String name,String password, int usertype, int limitation) {
		boolean l = true;
		try {
			String user1 = "";
			if(userversion==0) user1 = "User.txt";
			else user1 = "User" + userversion + ".txt";
			File w = new File(path + user1);
			Scanner in = new Scanner(w);
			userversion ++;
			user1 = "User" + userversion + ".txt";
			FileOutputStream r = new FileOutputStream(path + user1);
			PrintWriter t = new PrintWriter(r);
			while(in.hasNextLine()) {
				String y = in.nextLine();
				String y1 = in.nextLine();
				int y2 = Integer.parseInt(in.nextLine());
				if((y.equals(name))&&(y2==usertype)) {
					t.println(y);
					t.println(password);
					t.println(usertype);
					t.println(limitation);
					in.nextLine();
				}else {
					t.println(y);
					t.println(y1);
					t.println(y2);
					t.println(in.nextLine());
				}
			}
			t.close();
			r.close();
			in.close();
			l = true;
		} catch (IOException e) {
			l = false;
			e.printStackTrace();
		}
	return l;
}
/**
 * 
 * @param name
 * 			book name
 * @param lib
 * 			in which library(What looks like in file)
 * @param lastborrow
 * 			last borrowed by
 * @return
 */
	public static boolean deletebook(String name,String Author, int lib, String lastborrow) {
		boolean l = true;
		try {
			String book = "";
			if(bookversion==0) book = "Book.txt";
			else book = "Book" + bookversion + ".txt";
			File w = new File(path + book);
			Scanner in = new Scanner(w);
			bookversion ++;
			book = "Book" + bookversion + ".txt";
			FileOutputStream r = new FileOutputStream(path + book);
			PrintWriter t = new PrintWriter(r); 
			while(in.hasNextLine()) {
				String y = in.nextLine();
				String y0 = in.nextLine();
				String y1 = in.nextLine();
				String y2 = in.nextLine();
				String[] y21 = y2.split(",");
				int y22 = Integer.parseInt(y21[0]);
				String y3 = in.nextLine();
				String[] y4 = y3.split(",");
				if((y.equals(name))&&(y4[1].equals(lastborrow))&&(y22==lib)&&(Author.equals(y0))) {
				}else {
					t.println(y);
					t.println(y0);
					t.println(y1);
					t.println(y2);
					t.println(y3);
				}
			}
			t.close();
			r.close();
			in.close();
			l = true;
		} catch (IOException e) {
			l = false;
			e.printStackTrace();
		}
	return l;
}
	/**
	 * 
	 * @param name
	 * @param Author
	 * @param call
	 * @param lib
	 * 			will be written to file directly
	 * @return
	 */
	public static boolean addbook(String name,String Author, String call,int lib) {
		boolean l = true;
		try {
			String book = "";
			if(bookversion==0) book = "Book.txt";
			else book = "Book" + bookversion + ".txt";
			if(l) {
				FileOutputStream r = new FileOutputStream(path + book,true);
				PrintWriter t = new PrintWriter(r);
				t.println(name);
				t.println(Author);
				t.println(call);
				t.println(lib + ",");
				t.println("false,0,");
				t.close();
				r.close();
			}
		} catch (IOException e) {
			l = false;
			e.printStackTrace();
		}
	return l;
}
	
	
	public static boolean changebook(String name,String Author, String call, int lib, String lastborrow, String statu) {
		boolean l = true;
		try {
			String book = "";
			if(bookversion==0) book = "Book.txt";
			else book = "Book" + bookversion + ".txt";
			File w = new File(path + book);
			Scanner in = new Scanner(w);
			bookversion ++;
			book = "Book" + bookversion + ".txt";
			FileOutputStream r = new FileOutputStream(path + book);
			PrintWriter t = new PrintWriter(r);
			while(in.hasNextLine()) {
				String y = in.nextLine();
				String y0 = in.nextLine();
				String y1 = in.nextLine();
				String y2 = in.nextLine();
				String[] y21 = y2.split(",");
				int y22 = Integer.parseInt(y21[0]);
				String y3 = in.nextLine();
				String[] y4 = y3.split(",");
				if((y.equals(name))&&(y4[1].equals(lastborrow))&&(y22==lib)) {
					t.println(y);
					t.println(Author);
					t.println(call);
					t.println(lib + ",");
					t.println(statu + "," + lastborrow + ",");
				}else {
					t.println(y);
					t.println(y0);
					t.println(y1);
					t.println(y2);
					t.println(y3);
				}
			}
			t.close();
			r.close();
			in.close();
			l = true;
		} catch (IOException e) {
			l = false;
			e.printStackTrace();
		}
	return l;
}
	
	/**
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public static boolean bookdata() throws InterruptedException {
		bookstatu = false;
		boolean bookstatu1 = false;
		boolean bookstatu2 = false;
		int i=0;
		while(bookstatu1==false) {
			bookstatu1 = FTP.downFile("*SERVER*", 21, "*USERNAME*", "*PASSWORD*", "/", "Book.txt", getpath());  
			i++;
			if(i>5) {
				JOptionPane.showMessageDialog(null, "Some error happened. Please make sure you have internet connection. Please re-open program.");
				Thread.sleep(5000);
				System.exit(1);
				break;
			}
		}
		if(bookstatu1==true) {
			File myfile=new File(path + "Book.txt");
			try {
				Scanner in = new Scanner(myfile);
				while(in.hasNextLine()) {
					String book = in.nextLine();
					String author = in.nextLine();
					String call = in.nextLine();
					String library = in.nextLine();
					String borrow = in.nextLine();
					String[] borrow1 = borrow.split(",");
					boolean[] borrow2 = new boolean[borrow1.length/2];
					String[] borrowuser = new String[borrow1.length/2];
					String[] library3 = library.split(",");
					int[] library4 = new int[library3.length];
					for(int i1=0;i1<borrow1.length/2;i1++) {
						borrow2[i1] = Boolean.parseBoolean(borrow1[i1*2]);
						borrowuser[i1] = borrow1[i1*2+1];
						//System.out.println(borrow);
						library4[i1] = Integer.parseInt(library3[i1]);
						//System.out.println(borrow);
						initial.library1.get(library4[i1]).addBook(new Book(book, call, author, borrow2[i1], borrowuser[i1]));
					}
					
				}
				bookstatu2 = true;
				in.close();
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Some error happened. Please make sure you have internet connection. Please re-open program.");
				e.printStackTrace();
			}
		}
		if((bookstatu1==true)&&(bookstatu2==true)) bookstatu = true;
		return bookstatu;
	}
	
	public static boolean librarydata() throws InterruptedException {
		librarystatu = false;
		boolean librarystatu1 = false;
		boolean librarystatu2 = false;
		int i=0;
		while(librarystatu1==false) {
			Thread.sleep(500);
			librarystatu1 = FTP.downFile("*SERVER*", 21, "*USERNAME*", "*PASSWORD*", "/", "Library.txt", getpath());  
			i++;
			if(i>5) {
				JOptionPane.showMessageDialog(null, "Some error happened. Please make sure you have internet connection. Please re-open program.");
				Thread.sleep(5000);
				System.exit(1);
				break;
			}
			
		}
		if(librarystatu1) {
			File myfile=new File(path + "Library.txt");
			try {
				Scanner in = new Scanner(myfile);
				while(in.hasNextLine()) {
					String address = in.nextLine();
					String open = in.nextLine();
					String close = in.nextLine();
					initial.addlibrary(new Library(address,open,close));
					
					librarystatu2 = true;
				}
				in.close();
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Some error happened. Please make sure you have internet connection. Please re-open program.");
				e.printStackTrace();
			}
		}
		if((librarystatu1==true)&&(librarystatu2==true)) librarystatu = true;
		return librarystatu;
	}
	
	public static boolean uplibrary() {
		boolean l = false;
		try {  
			String Library = "";
			if(libraryversion==0) Library = "Library.txt";
			else Library = "Library" + libraryversion + ".txt";
	        FileInputStream in=new FileInputStream(path + Library);  
	        l = FTP.uploadFile("*SERVER*", 21, "*USERNAME*", "*PASSWORD*", "/", "Library.txt", in);
	    } catch (FileNotFoundException e) {  
	        e.printStackTrace();  
	    }  
		return l;
	}
	
	public static boolean upbook() {
		boolean l = false;
		try {  
			String book = "";
			if(bookversion==0) book = "Book.txt";
			else book = "Book" + bookversion + ".txt";
	        FileInputStream in=new FileInputStream(path + book);  
	        l = FTP.uploadFile("*SERVER*", 21, "*USERNAME*", "*PASSWORD*", "/", "Book.txt", in);
	    } catch (FileNotFoundException e) {  
	        e.printStackTrace();  
	    }  
		return l;
	}
	
	public static boolean upuser() {
		boolean l = false;
		try {
			String user1 = "";
			if(userversion==0) user1 = "User.txt";
			else user1 = "User" + userversion + ".txt";
	        FileInputStream in=new FileInputStream(path + user1);  
	        l = FTP.uploadFile("*SERVER*", 21, "*USERNAME*", "*PASSWORD*", "/", "User.txt", in);
	    } catch (FileNotFoundException e) {  
	        e.printStackTrace();  
	    }  
		return l;
	}

	private void addlibrary(Library library2) {
		library1.add(library2);
	}
}
