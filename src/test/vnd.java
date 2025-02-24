package test;

import java.awt.EventQueue;
import java.awt.Font;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class vnd extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vnd frame = new vnd();
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
	public vnd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		double vnd = 10000000;
        
	    // tạo 1 NumberFormat để định dạng tiền tệ theo tiêu chuẩn của Việt Nam
	    // đơn vị tiền tệ của Việt Nam là đồng
//	    Locale localeVN = new Locale("vi", "VN");
	    NumberFormat currencyVN = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
	    String str1 = currencyVN.format(vnd);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setText(str1);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(85, 162, 436, 104);
		contentPane.add(lblNewLabel);
	}
}
