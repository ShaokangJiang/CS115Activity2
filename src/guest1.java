/**
 * @author Shaokang Jiang & Shein George
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;

public class guest1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guest1 frame = new guest1();
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
	public guest1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		

	    
        JFrame f = new JFrame("Welcome");
        f.getContentPane().setEnabled(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    Object rowData[][] = new Object[initial.initial.library1.size()][4];
	    for(int i=0;i<initial.initial.library1.size();i++) {
	    	for(int j=0;j<4;j++) {
	    		rowData[i][j] = ""+j;
	    	}
	    }
	    Object columnNames[] = { "Column One", "Column Two", "Column Three", "Statu" };
	    f.getContentPane().setLayout(null);
	    JTable table = new JTable(rowData, columnNames);
	    new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    table.getColumnModel().getColumn(0).setPreferredWidth(600);
	    table.getColumnModel().getColumn(1).setPreferredWidth(120);
	    table.getColumnModel().getColumn(2).setPreferredWidth(120);
	    table.getColumnModel().getColumn(3).setPreferredWidth(75);
	    table.setAutoCreateRowSorter(true);
	    for(int i=0;i<table.getRowCount();i++) {
	    	table.setRowHeight(i, 20);
	    }
	    
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(0, 68, 933, 480);
	    
        
        textField = new JTextField();
        textField.setColumns(10);
        
        JButton btnSearch = new JButton("Search");
        
        JButton btnShowAllBooks = new JButton("Show all books");
        btnShowAllBooks.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		String s="";
        		for(int i=0;i<initial.initial.library1.size();i++) {
        		
        		s += "Library" + (i+1) + ":\n";
        		s += "Address: " + initial.initial.library1.get(i).getAddress() + "\n";
        		s += "Opening hours: " + initial.initial.library1.get(i).getOpeningHours() + "\n";
        		s += "\n" + initial.initial.library1.get(i).printAvailablebook() + "\n";
        		}
        		//Author.setText(s);
        	}
        });
        
        JLabel lblNewLabel = new JLabel("Hello Guest!");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        
        JLabel lblLibrary = new JLabel("Library1:");
        
        JLabel lblLocation = new JLabel("Location:");
        
        JLabel lblOpeningHours = new JLabel("Opening hours:");
        
        
	    
	    
        GroupLayout groupLayout = new GroupLayout(f.getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(23)
        					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
        					.addGap(74)
        					.addComponent(btnShowAllBooks, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
        					.addGap(22)
        					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 542, GroupLayout.PREFERRED_SIZE)
        					.addGap(40)
        					.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(46)
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblLibrary)
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGap(10)
        							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        								.addComponent(lblOpeningHours)
        								.addComponent(lblLocation))))))
        			.addContainerGap(37, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(10)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(btnShowAllBooks)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(1)
        					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addComponent(btnSearch)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(1)
        					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblLibrary)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblLocation)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblOpeningHours)
        			.addContainerGap(542, Short.MAX_VALUE))
        );
        f.getContentPane().setLayout(groupLayout);
        // f.add(jt);
        f.setSize(1129, 693);
        f.setLocation(300, 200);
        f.setVisible(true);
	}
}
