import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class administrator extends JFrame {

	private JPanel contentPane;
	private String user;
	private int limit;
	private int borrowbooks;
	private int statu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					administrator frame = new administrator("dec", 1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public administrator(String h,int limit1) {
		user = h;
		limit = limit1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1265, 724);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Object rowData[][] = new Object[0][0];
	    
	    Object columnNames[] = {  };
	    DefaultTableModel update_table =new DefaultTableModel(rowData, columnNames);
	    JTable table = new JTable(update_table);
	    new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    table.setAutoCreateRowSorter(true);
	    
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(196, 256, 1053, 421);
	    contentPane.add(scrollPane);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(194, 0, 2, 677);
		contentPane.add(separator);
		setVisible(true);
		
		
		JLabel lblNewLabel = new JLabel("Instruction:");
		lblNewLabel.setBounds(277, 74, 300, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("To start, choose four buttons at left.");
		lblNewLabel_1.setBounds(310, 90, 300, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(310, 110, 300, 16);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(statu==1) {
					Addbook fr = new Addbook();
					fr.setVisible(true);
				}
			}
		});
		btnNewButton_1.setBounds(849, 76, 200, 25);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setVisible(false);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_2.setBounds(849, 129, 200, 25);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.setVisible(false);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_3.setBounds(849, 192, 200, 25);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.setVisible(false);
		
		JLabel lblNewLabel_3 = new JLabel("Hello " + user + "!");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(224, 13, 200, 32);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Manage book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				statu = 1;
				int l = 0;
			    for(int i=0;i<initial.initial.library1.size();i++) {
			    	l += initial.initial.library1.get(i).books.size();
			    }
			    Object rowData1[][] = new Object[l][5];
			    l = 0 ;
			    for(int i=0;i<initial.initial.library1.size();i++) {
			    	for(int j=0;j<initial.initial.library1.get(i).books.size();j++) {
			    		rowData1[l][0] = initial.initial.library1.get(i).books.get(j).getTitle();
			    		rowData1[l][1] = initial.initial.library1.get(i).books.get(j).getauthor();
			    		rowData1[l][2] = initial.initial.library1.get(i).books.get(j).getcall();
			    		rowData1[l][3] = initial.initial.library1.get(i).books.get(j).isBorrowed1();
			    		rowData1[l][4] = "" + (i+1);
			    		l++;
			    	}
			    }
			    Object columnNames[] = { "Title", "Author", "Call number", "Statu", "Library" };
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
			    scrollPane.setVisible(true);
			    //show a button used for search
			    lblNewLabel_1.setText("You can manage books by click button at right.");
			    lblNewLabel_2.setText("You can choose data from table for a quicker select.");
			    btnNewButton_1.setText("Add book");
			    btnNewButton_2.setText("Change book information");
			    btnNewButton_3.setText("Delete book");
			    btnNewButton_1.setVisible(true);
			    btnNewButton_2.setVisible(true);
			    btnNewButton_3.setVisible(true);

			}
		});
		btnNewButton.setBounds(25, 80, 116, 74);
		contentPane.add(btnNewButton);
		
		JButton btnManageUser = new JButton("Manage User");
		btnManageUser.setBounds(25, 196, 116, 74);
		contentPane.add(btnManageUser);
		
		JButton btnManageLibrary = new JButton("<html>Manage<br>Library</html>");
		btnManageLibrary.setBounds(25, 310, 116, 74);
		contentPane.add(btnManageLibrary);
		
		JButton btnBorrowreturn = new JButton("<html>Borrow &<br>return book</html>");
		btnBorrowreturn.setBounds(25, 421, 116, 74);
		contentPane.add(btnBorrowreturn);
		
	}
}
