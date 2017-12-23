/**
 * @author Shaokang Jiang & Shein George
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Window.Type;

public class user1 extends JFrame {

	private JPanel contentPane;
	private JTextField search;
	private String user;
	private int limit;
	private int borrowbooks;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//user1 frame = new user1();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public user1(String h,int limit1) {
		/*
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		*/
		user = h;
		limit = limit1;
		JFrame frmLibraryManagement = new JFrame();
		frmLibraryManagement.setTitle("Library Management");
	    frmLibraryManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JComboBox comboBox = new JComboBox();
	    comboBox.setModel(new DefaultComboBoxModel(new String[] {"Title", "Author"}));
	    comboBox.setSelectedIndex(0);
	    int l = 0;
	    for(int i=0;i<initial.initial.library1.size();i++) {
	    	l += initial.initial.library1.get(i).books.size();
	    }
	    Object rowData[][] = new Object[l][5];
	    l = 0 ;
	    for(int i=0;i<initial.initial.library1.size();i++) {
	    	for(int j=0;j<initial.initial.library1.get(i).books.size();j++) {
	    		rowData[l][0] = initial.initial.library1.get(i).books.get(j).getTitle();
	    		rowData[l][1] = initial.initial.library1.get(i).books.get(j).getauthor();
	    		rowData[l][2] = initial.initial.library1.get(i).books.get(j).getcall();
	    		rowData[l][3] = initial.initial.library1.get(i).books.get(j).isBorrowed1();
	    		rowData[l][4] = "" + (i+1);
	    		l++;
	    	}
	    }
	    
	    Object columnNames[] = { "Title", "Author", "Call number", "Statu", "Library" };
	    DefaultTableModel update_table =new DefaultTableModel(rowData, columnNames);
	    JTable table = new JTable(update_table);
	    new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    table.getColumnModel().getColumn(0).setPreferredWidth(700);
	    table.getColumnModel().getColumn(1).setPreferredWidth(100);
	    table.getColumnModel().getColumn(2).setPreferredWidth(150);
	    table.getColumnModel().getColumn(3).setPreferredWidth(80);
	    table.getColumnModel().getColumn(4).setPreferredWidth(48);
	    table.setAutoCreateRowSorter(true);
	    for(int i=0;i<table.getRowCount();i++) {
	    	table.setRowHeight(i, 25);
	    }
	    
	    JScrollPane scrollPane = new JScrollPane(table);
	    
	    JLabel label = new JLabel("Hello " + user);
	    label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    
	    search = new JTextField();
	    search.setColumns(10);
	    
	    JButton button_1 = new JButton("Search");
	    button_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		
	    		HashMap<Integer, Book> hmap = new HashMap<Integer, Book>();
	    		String pattern = ".*" + search.getText().toLowerCase() + ".*";
	    		int r = 0;
	    		String record = "";
	    		
	    		if(comboBox.getSelectedItem().toString().equals("Title")) {
	    	    for(int i=0;i<initial.initial.library1.size();i++) {
	    	    	for(int j=0;j<initial.initial.library1.get(i).books.size();j++) {
	    	    		if(Pattern.matches(pattern, initial.initial.library1.get(i).books.get(j).getTitle().toLowerCase())) {
	    	    			hmap.put(r, initial.initial.library1.get(i).books.get(j));
	    	    			r++;
	    	    			record = record + (i+1) + ";";//record library information.
	    	    		}
	    	    	}
	    	    }
	    	    
	    	    if(hmap.size()==0) {
	    	    	Object[][] rowData1 = new Object[1][5];
	    	    	rowData1[0][0] = "Sorry, the book is not in our catalog.";
		    		rowData1[0][1] = "";
		    		rowData1[0][2] = "";
		    		rowData1[0][3] = "";
		    		rowData1[0][4] = "";
		    		update_table.setDataVector(rowData1, columnNames); 
		    	    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		    	    table.getColumnModel().getColumn(0).setPreferredWidth(700);
		    	    table.getColumnModel().getColumn(1).setPreferredWidth(100);
		    	    table.getColumnModel().getColumn(2).setPreferredWidth(150);
		    	    table.getColumnModel().getColumn(3).setPreferredWidth(80);
		    	    table.getColumnModel().getColumn(4).setPreferredWidth(48);
		    	    table.setRowHeight(0, 25);
		    	    hmap.clear();
	    	    }else {
	    	    String[] j = record.split(";");
	    		Object[][] rowData1 = new Object[hmap.size()][5];
	    		for(int i=0;i<hmap.size();i++) {
	    			rowData1[i][0] = hmap.get(i).getTitle();
		    		rowData1[i][1] = hmap.get(i).getauthor();
		    		rowData1[i][2] = hmap.get(i).getcall();
		    		rowData1[i][3] = hmap.get(i).isBorrowed1();
		    		rowData1[i][4] = j[i];
	    		}
	    		update_table.setDataVector(rowData1, columnNames); 
	    	    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    	    table.getColumnModel().getColumn(0).setPreferredWidth(700);
	    	    table.getColumnModel().getColumn(1).setPreferredWidth(100);
	    	    table.getColumnModel().getColumn(2).setPreferredWidth(150);
	    	    table.getColumnModel().getColumn(3).setPreferredWidth(80);
	    	    table.getColumnModel().getColumn(4).setPreferredWidth(48);
	    	    table.setAutoCreateRowSorter(true);
	    	    for(int i=0;i<table.getRowCount();i++) {
	    	    	table.setRowHeight(i, 25);
	    	    }
	    	    hmap.clear();
	    		//table = new JTable(rowData, columnNames);
	    	    }
	    	    }else if(comboBox.getSelectedItem().toString().equals("Author")) {

		    	    for(int i=0;i<initial.initial.library1.size();i++) {
		    	    	for(int j=0;j<initial.initial.library1.get(i).books.size();j++) {
		    	    		if(Pattern.matches(pattern, initial.initial.library1.get(i).books.get(j).getauthor().toLowerCase())) {
		    	    			hmap.put(r, initial.initial.library1.get(i).books.get(j));
		    	    			r++;
		    	    			record = record + (i+1) + ";";//record library information.
		    	    		}
		    	    	}
		    	    }
		    	    if(hmap.size()==0) {
		    	    	Object[][] rowData1 = new Object[1][5];
		    	    	rowData1[0][0] = "Sorry, the book is not in our catalog.";
			    		rowData1[0][1] = "";
			    		rowData1[0][2] = "";
			    		rowData1[0][3] = "";
			    		rowData1[0][4] = "";
			    		update_table.setDataVector(rowData1, columnNames); 
			    	    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			    	    table.getColumnModel().getColumn(0).setPreferredWidth(700);
			    	    table.getColumnModel().getColumn(1).setPreferredWidth(100);
			    	    table.getColumnModel().getColumn(2).setPreferredWidth(150);
			    	    table.getColumnModel().getColumn(3).setPreferredWidth(80);
			    	    table.getColumnModel().getColumn(4).setPreferredWidth(48);
			    	    table.setRowHeight(0, 25);
			    	    hmap.clear();
		    	    }else {
		    	    String[] j = record.split(";");
		    		Object[][] rowData1 = new Object[hmap.size()][5];
		    		for(int i=0;i<hmap.size();i++) {
		    			rowData1[i][0] = hmap.get(i).getTitle();
			    		rowData1[i][1] = hmap.get(i).getauthor();
			    		rowData1[i][2] = hmap.get(i).getcall();
			    		rowData1[i][3] = hmap.get(i).isBorrowed1();
			    		rowData1[i][4] = j[i];
		    		}
		    		update_table.setDataVector(rowData1, columnNames); 
		    	    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		    	    table.getColumnModel().getColumn(0).setPreferredWidth(700);
		    	    table.getColumnModel().getColumn(1).setPreferredWidth(100);
		    	    table.getColumnModel().getColumn(2).setPreferredWidth(150);
		    	    table.getColumnModel().getColumn(3).setPreferredWidth(80);
		    	    table.getColumnModel().getColumn(4).setPreferredWidth(48);
		    	    table.setAutoCreateRowSorter(true);
		    	    for(int i=0;i<table.getRowCount();i++) {
		    	    	table.setRowHeight(i, 25);
		    	    }
		    	    hmap.clear();
		    		//table = new JTable(rowData, columnNames);
		    	    }
		    	    
	    	    }
	    	}
	    });
	    
	   
	    


	    JLabel label_1[] = new JLabel[initial.initial.library1.size()];
	    
	    
	    JLabel label_2[] = new JLabel[initial.initial.library1.size()];
	    
	    
	    JLabel label_3[] = new JLabel[initial.initial.library1.size()];
	    
	    int o = 30;
	    for(int i=0;i<initial.initial.library1.size();i++) {
	    	
	    	
	    	label_1[i] = new JLabel();
	    	label_1[i].setBounds(o, 49, 100, 16);
		    frmLibraryManagement.getContentPane().add(label_1[i]);
		    label_2[i] = new JLabel();
		    label_2[i].setBounds(o+10, 95, 200, 16);
		    frmLibraryManagement.getContentPane().add(label_2[i]);
		    label_3[i] = new JLabel();
		    label_3[i].setBounds(o+10, 72, 250, 16);
		    frmLibraryManagement.getContentPane().add(label_3[i]);
		    
		    label_1[i].setText("Library" + (i+1) + ":");
    		label_2[i].setText("Address: " + initial.initial.library1.get(i).getAddress());
    		label_3[i].setText("Opening hours: " + initial.initial.library1.get(i).getOpeningHours());
    		//   = "\n" + initial.initial.library1.get(i).printAvailablebook() + "\n";
    		o += 250;
    		}
	    //print borrowed books
	    HashMap<Integer, Book> hmap1 = new HashMap<Integer, Book>();//create hashmap to store books
	    //create header
	    JLabel label_4 = new JLabel();
	    label_4.setBounds(o, 49, 250, 16);
	    frmLibraryManagement.getContentPane().add(label_4);
	    label_4.setText("You have borrowed: ");
	    //check the same thing
	    int k = 0;
	    String record = "";
	    for(int i=0;i<initial.initial.library1.size();i++) {
	    	for(int j=0;j<initial.initial.library1.get(i).books.size();j++) {
	    		if(initial.initial.library1.get(i).books.get(j).getborrowuser().equals(user)&&initial.initial.library1.get(i).books.get(j).borrowed) {
	    			hmap1.put(k, initial.initial.library1.get(i).books.get(j));
	    			k++;
	    			record = record + (i+1) + ";";
	    		}
	    	}
	    }
	    borrowbooks = hmap1.size();
	    JLabel label_5[] = new JLabel[hmap1.size()];
	    String[] record1 = record.split(";");
	    int h1 = 49;
	    for(int i=0;i<hmap1.size();i++) {
	    	h1 += 23;
	    	label_5[i] = new JLabel();
	    	label_5[i].setBounds(o+10, h1, 800, 16);
		    frmLibraryManagement.getContentPane().add(label_5[i]);
		    label_5[i].setText(hmap1.get(i).getTitle() + " in " + record1[i]);//can re-get the library name?
	    }
	    
	    JButton btnBorrowThisBook = new JButton("Borrow the book you select");
	    btnBorrowThisBook.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(borrowbooks<limit) {
	    			int o = table.getSelectedRow();
	    			String title = (String) table.getValueAt(o, 0);
	    			String lib1 = (String) table.getValueAt(o, 4);
	    			int lib = Integer.parseInt(lib1);
	    			initial.initial.library1.get((lib-1)).borrowBook1(title, lib, user);
	    			borrowbooks++;
	    		}else {
	    			JOptionPane.showMessageDialog(null, "Sorry, you have the borrow limitation of " + limit + " books.");
	    		}
	    		}
	    });
	    
	    JLabel lblDoubleClickCan = new JLabel("Double click can copy data");
	    
	    
	    GroupLayout groupLayout = new GroupLayout(frmLibraryManagement.getContentPane());
	    groupLayout.setHorizontalGroup(
	    	groupLayout.createParallelGroup(Alignment.TRAILING)
	    		.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1088, Short.MAX_VALUE)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addGap(9)
	    			.addComponent(label, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
	    			.addGap(46)
	    			.addComponent(lblDoubleClickCan)
	    			.addGap(33)
	    			.addComponent(search, GroupLayout.PREFERRED_SIZE, 454, GroupLayout.PREFERRED_SIZE)
	    			.addGap(18)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
	    				.addComponent(btnBorrowThisBook, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
	    				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
	    					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
	    					.addPreferredGap(ComponentPlacement.RELATED)
	    					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
	    			.addGap(117))
	    );
	    groupLayout.setVerticalGroup(
	    	groupLayout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addGap(14)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	    				.addComponent(label, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
	    				.addComponent(lblDoubleClickCan)
	    				.addComponent(search, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
	    				.addComponent(button_1)
	    				.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    			.addPreferredGap(ComponentPlacement.RELATED)
	    			.addComponent(btnBorrowThisBook)
	    			.addPreferredGap(ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
	    			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE))
	    );
	    frmLibraryManagement.getContentPane().setLayout(groupLayout);
	    
	    
	    frmLibraryManagement.setSize(1098, 767);
	    frmLibraryManagement.setVisible(true);

	}
}
