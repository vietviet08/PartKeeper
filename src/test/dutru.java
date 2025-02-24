package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class dutru extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dutru frame = new dutru();
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
	public dutru() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 653);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(183, 93, 191, 392);
		contentPane.add(panel);
		
		JButton btnNewButton_2 = new JButton("CPU");
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBounds(0, 0, 191, 37);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("RAM");
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBounds(0, 37, 191, 37);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2_1 = new JButton("VGA");
		btnNewButton_2_1.setBorder(null);
		btnNewButton_2_1.setBounds(0, 75, 191, 37);
		panel.add(btnNewButton_2_1);
		
		JButton btnNewButton_3 = new JButton("Main Board");
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setBounds(0, 113, 191, 37);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_2_2 = new JButton("Case");
		btnNewButton_2_2.setBorder(null);
		btnNewButton_2_2.setBounds(0, 148, 191, 37);
		panel.add(btnNewButton_2_2);
		
		JButton btnNewButton_2_4 = new JButton("Nguồn");
		btnNewButton_2_4.setBorder(null);
		btnNewButton_2_4.setBounds(0, 183, 191, 37);
		panel.add(btnNewButton_2_4);
		
		JButton btnNewButton_1_1 = new JButton("Màn hình");
		btnNewButton_1_1.setBorder(null);
		btnNewButton_1_1.setBounds(0, 220, 191, 37);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_2_1_1 = new JButton("Bàn phím");
		btnNewButton_2_1_1.setBorder(null);
		btnNewButton_2_1_1.setBounds(0, 258, 191, 37);
		panel.add(btnNewButton_2_1_1);
		
		JButton btnNewButton_3_1 = new JButton("Chuột");
		btnNewButton_3_1.setBorder(null);
		btnNewButton_3_1.setBounds(0, 296, 191, 37);
		panel.add(btnNewButton_3_1);
		
		JButton btnNewButton_2_2_1 = new JButton("Tai nghe");
		btnNewButton_2_2_1.setBorder(null);
		btnNewButton_2_2_1.setBounds(0, 331, 191, 37);
		panel.add(btnNewButton_2_2_1);
		
		JButton btnNewButton = new JButton("Danh sach tất cả sản phẩm");
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(183, 54, 191, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBorder(null);
		btnNewButton_4.setBounds(528, 65, 191, 37);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_2_3 = new JButton("New button");
		btnNewButton_2_3.setBorder(null);
		btnNewButton_2_3.setBounds(528, 103, 191, 37);
		contentPane.add(btnNewButton_2_3);
	}

}
