/**
 * @author Shaokang Jiang & Shein George
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Window.Type;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Welcome extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JTextField pwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
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
	public Welcome() {
		setTitle("Library Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		user = new JTextField();
		user.setFont(new Font("Tahoma", Font.PLAIN, 20));
		user.setColumns(10);
		
		initial.setPath();
		
		pwd = new JTextField();
		pwd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pwd.setColumns(10);
		JLabel lblPleaseWait = new JLabel("");
		JButton Login = new JButton("Login");
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
				boolean j,j1,j2; 
				j1 = initial.getbookstatu();
				j = initial.getuserstatu();
				j2 = initial.getlibrarystatu();
				if(j1&&j2&&j);
				else {
				j = initial.userdata();
				Thread.sleep(100);
				j2 = initial.librarydata();
				Thread.sleep(100);
				j1 = initial.bookdata();
				Thread.sleep(100);
				}
				boolean l=true;
				if(j1&&j2&&j) {
					File myfile=new File(initial.getpath() + "User.txt");
					Scanner in=new Scanner(myfile);
					while(in.hasNextLine()) {
						String h="";
						h = in.nextLine();
						if(h.equals(user.getText())) {
							if(in.nextLine().equals(pwd.getText())) {
								if(in.nextLine().equals("1")) {
									
									Admin q = new Admin();
									q.setname(h);
									int j3 = Integer.parseInt(in.nextLine());
									in.close();
									administrator f2 = new administrator(h,j3);
									f2.setVisible(true);
									setVisible(false);
									l = true;
									break;
								}
								else {
									User q = new User();
									q.setname(h);
									int j3 = Integer.parseInt(in.nextLine());
									in.close();
									user1 f2 = new user1(h,j3);
									f2.setVisible(false);
									setVisible(false);
									l = true;
									break;
								}
							}else {
								JOptionPane.showMessageDialog(null, "Password error! MENTION:username and password are all capital sensitive.");
							}
						}else {
							in.nextLine();
							in.nextLine();
							in.nextLine();
							l = false;
						}
					}
					if(!l)JOptionPane.showMessageDialog(null, "Account does not exist. MENTION:username and password are all capital sensitive.");					
				}else {
					JOptionPane.showMessageDialog(null, "Some error happened. Please make sure you have internet connection. Please re-open this program.");
					System.exit(1);
				}
				} catch (InterruptedException | FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton Guest = new JButton("Guest");
		Guest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblPleaseWait.setText("Please wait...");
				boolean j1,j2;
				try {
					j2 = initial.getlibrarystatu();
					j1 = initial.getbookstatu();
					if(j1&&j2);
					else {
						j2 = initial.librarydata();
						Thread.sleep(100);
						j1 = initial.bookdata();
					}
					if(j1&&j2) {
				guest2 f2 = new guest2();
				f2.setVisible(false);
				setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null, "Some error happened. Please make sure you have internet connection. Please re-open this program.");
						System.exit(1);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("Welcome back");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		JLabel lblIfYouHave = new JLabel("If you have account, please login, and then you can borrow or renew your book. ");
		
		JLabel lblUseGuestButton = new JLabel("Use guest button to search books you need.");
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(175)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblUseGuestButton))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(117)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(Login, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
										.addGap(8)
										.addComponent(lblPleaseWait, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(Guest, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addComponent(lblUsername, Alignment.LEADING)
											.addComponent(lblPassword))
										.addGap(67)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(pwd, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
											.addComponent(user, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE))))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblIfYouHave))))
					.addContainerGap(99, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(43)
					.addComponent(lblNewLabel)
					.addGap(13)
					.addComponent(lblIfYouHave)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblUseGuestButton)
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUsername)
						.addComponent(user, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(pwd, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(Login, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(Guest, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblPleaseWait, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
					.addGap(21))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
