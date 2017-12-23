import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class ii extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ii frame = new ii();
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
	public ii() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrTt = new JTextArea();
		
		txtrTt.setLocation(164, 168);
		txtrTt.setRows(3);
		txtrTt.setColumns(2);
		System.out.print(txtrTt.getColumns() + " " + txtrTt.getRows());
		txtrTt.setText("vghvhjbkbhkbkjknjknkjnjnkkjnjknjhbhjbjhbkjbjkbkjbkjbkjnbkjbnkjn");
		contentPane.add(txtrTt);
		
		//

	}
}
