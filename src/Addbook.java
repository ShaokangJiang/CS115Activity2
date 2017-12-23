import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Addbook extends JFrame {

	private JPanel contentPane;
	private JTextField Title;
	private JTextField Author;
	private JTextField Call;
	private String h;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addbook frame = new Addbook();
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
	public Addbook() {
		setTitle("Add book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 399);
		contentPane =  new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JLabel lblTitle = new JLabel("Title: ");
		lblTitle.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblAuthor = new JLabel("Author: ");
		lblAuthor.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblCall = new JLabel("Call: ");
		lblCall.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		Title = new JTextField();
		Title.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		Title.setColumns(10);
		
		Author = new JTextField();
		Author.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		Author.setColumns(10);
		
		Call = new JTextField();
		Call.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		Call.setColumns(10);
		
		JLabel lblLibrary = new JLabel("Library:");
		lblLibrary.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JComboBox comboBox = new JComboBox();
		String[] u = new String[initial.initial.library1.size()];
		for(int i=0;i<initial.initial.library1.size();i++) {
			u[i] = "" + (i+1) + " - " + initial.initial.library1.get(i).getAddress();
		}
		comboBox.setModel(new DefaultComboBoxModel(u));
		comboBox.setSelectedIndex(0);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((!Title.getText().equals(""))) {
				String lib1 = (String) comboBox.getSelectedItem();
				int lib = lib1.charAt(0);
				lib -= 49;
				h = Title.getText();
				initial.addbook(Title.getText(), Author.getText(), Call.getText(), lib);
				}
				initial.upbook();
				JOptionPane.showMessageDialog(null, "Successfully add!");
				setVisible(false);
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		JButton btnNewButton = new JButton("Next -->");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String lib1 = (String) comboBox.getSelectedItem();
				int lib = lib1.charAt(0);
				lib -= 49;
				initial.addbook(Title.getText(), Author.getText(), Call.getText(), lib);
				h = Title.getText();
				Title.setText("");
				Author.setText("");
				Call.setText("");
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(106)
							.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(btnNewButton)
							.addGap(18)
							.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(65)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblAuthor, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCall, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblTitle))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(Title, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(Call, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
											.addComponent(Author, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblLibrary, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)))))
					.addGap(95))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(79)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTitle)
						.addComponent(Title, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAuthor, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(Author, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCall, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(Call, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLibrary, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(29))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
