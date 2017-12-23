/**
 * @author Shaokang Jiang & Shein George
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Window.Type;
import javax.swing.JButton;


public class Welpic {

	private JFrame frame;
	private static String q1="";
	private static String q2="";
	private static String q3="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welpic window = new Welpic();
					window.frame.setVisible(true);
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws InterruptedException 
	 */
	public Welpic() throws InterruptedException {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws InterruptedException 
	 */
	private void initialize() throws InterruptedException {
		frame = new JFrame();
		frame.setType(Type.POPUP);
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblWelcome = new JLabel("Welcome!");
		lblWelcome.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		JLabel lblNewLabel = new JLabel("program is preparing data now, please wait.");
		initial.setPath();
		
		JLabel lblNewLabel_1 = new JLabel("Get user date...");
		JLabel label = new JLabel(q1);

		
		JLabel lblNewLabel_2 = new JLabel("Get book date...");
		JLabel label_1 = new JLabel(q2);

		
		JLabel lblNewLabel_3 = new JLabel("Get library information...");
		JLabel label_2 = new JLabel(q3);

		

        
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(50)
							.addComponent(lblWelcome))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(18)
									.addComponent(label))
								.addComponent(lblNewLabel)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addGap(18)
									.addComponent(label_1))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addGap(18)
									.addComponent(label_2)))))
					.addContainerGap(168, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addComponent(lblWelcome)
					.addGap(88)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(label_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(label_2))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
