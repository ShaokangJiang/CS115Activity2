import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class guest2 extends JFrame {

	private JPanel contentPane;
	private JTextField search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//guest2 frame = new guest2();
					//frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public guest2() {
		/*
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 0, 0);
		setUndecorated(true);
		setVisible(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0,0,0,0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);*/
		JFrame frmLibraryManagement = new JFrame();
		frmLibraryManagement.setTitle("Library Management");
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
	    
	    JLabel label = new JLabel("Hello Guest!");
	    label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    
	    search = new JTextField();
	    search.setColumns(10);
	    
	    JButton button_1 = new JButton("Search");
	    button_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		;
	    		
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
	    
	    JLabel lblDoubleClickCan = new JLabel("Double click can copy data.");
	    
	    
	    GroupLayout groupLayout = new GroupLayout(frmLibraryManagement.getContentPane());
	    groupLayout.setHorizontalGroup(
	    	groupLayout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addGap(9)
	    			.addComponent(label, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
	    			.addPreferredGap(ComponentPlacement.RELATED)
	    			.addComponent(lblDoubleClickCan)
	    			.addGap(79)
	    			.addComponent(search, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
	    			.addGap(18)
	    			.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
	    			.addGap(18)
	    			.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
	    			.addGap(22))
	    		.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1090, Short.MAX_VALUE)
	    );
	    groupLayout.setVerticalGroup(
	    	groupLayout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addGap(13)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addGap(1)
	    					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	    						.addComponent(label, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
	    						.addComponent(lblDoubleClickCan)))
	    				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	    					.addComponent(button_1)
	    					.addComponent(search, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
	    					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
	    			.addGap(98)
	    			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
	    );
	    frmLibraryManagement.getContentPane().setLayout(groupLayout);

	    JLabel label_1[] = new JLabel[initial.initial.library1.size()];
	    
	    
	    JLabel label_2[] = new JLabel[initial.initial.library1.size()];
	    
	    
	    JLabel label_3[] = new JLabel[initial.initial.library1.size()];
	    
	    int o = 60;
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
    		o += 300;
    		}
	    
	    

	    frmLibraryManagement.setSize(1108, 717);
	    frmLibraryManagement.setVisible(true);

	}
}
