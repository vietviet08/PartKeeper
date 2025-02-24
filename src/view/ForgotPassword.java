package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatIntelliJLaf;

import color.SetColor;
import controller.BCrypt;
import controller.SendEmailSMTP;
import dao.AccountDAO;
import model.Account;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ForgotPassword extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private String otpNumber;
	private JPasswordField pass1;
	private JPasswordField pass2;
	public Font font;
	public Font font_1;
	public Font font1;
	public Font font2;
	private JButton btnNewButton;
	private JButton btnHonThnh;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPassword frame = new ForgotPassword();
					frame.setLocationRelativeTo(null);
					frame.setTitle("Quên mật khẩu");
					UIManager.setLookAndFeel(new FlatIntelliJLaf());
					frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
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

	public ForgotPassword() {
		setResizable(false);
		
		try {
			File fontStyle = new File("src/font/Roboto-Medium.ttf");
			font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(11f);
			font_1 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(14f);
			font1 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(16f);
			font2 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(22f);

		} catch (Exception e) {
			System.out.println(e);
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 183);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		JPanel panel = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics grphcs) {
				super.paintComponent(grphcs);
				Graphics2D g2d = (Graphics2D) grphcs;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				GradientPaint gp = new GradientPaint(0, 0,new Color(16,141,199), 240, getHeight(), new Color(239,142,56));
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, getWidth(), getHeight());

			}
		};
//		panel.setBackground(SetColor.blueOp);
		contentPane.add(panel, "name_110486029726200");
		panel.setLayout(null);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					checkPanel1();
				}
			}
		});
		textField.setBorder(null);
		textField.setColumns(10);
		textField.setBounds(180, 30, 173, 22);
		panel.add(textField);

		btnNewButton = new JButton("Xác nhận");
		btnNewButton.setFont(font_1);
		btnNewButton.setBorder(null);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				checkPanel1();
			}
		});
		btnNewButton.setBounds(117, 78, 125, 32);
		panel.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Nhập email khôi phục ");
		lblNewLabel.setForeground(SetColor.whiteFont);
		lblNewLabel.setFont(font);
		lblNewLabel.setBounds(31, 29, 139, 22);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics grphcs) {
				super.paintComponent(grphcs);
				Graphics2D g2d = (Graphics2D) grphcs;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				GradientPaint gp = new GradientPaint(0, 0,new Color(16,141,199), 240, getHeight(), new Color(239,142,56));
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, getWidth(), getHeight());

			}
		};
//		panel_1.setBackground(SetColor.blueOp);
		contentPane.add(panel_1, "name_110530074295400");
		panel_1.setLayout(null);

		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					checkPanel2();
				}
			}
		});
		textField_1.setBorder(null);
		textField_1.setColumns(10);
		textField_1.setBounds(148, 57, 96, 20);
		panel_1.add(textField_1);

		btnHonThnh = new JButton("Xác nhận");
		btnHonThnh.setFont(font);
		btnHonThnh.setBorder(null);
		btnHonThnh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				checkPanel2();
			}
		});
		btnHonThnh.setBounds(281, 56, 89, 23);
		panel_1.add(btnHonThnh);

		JLabel lblNhapMaXac = new JLabel("Nhập mã xác nhận:");
		lblNhapMaXac.setForeground(SetColor.whiteFont);
		lblNhapMaXac.setFont(font);
		lblNhapMaXac.setBounds(10, 56, 116, 22);
		panel_1.add(lblNhapMaXac);

		JPanel panel_2 = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics grphcs) {
				super.paintComponent(grphcs);
				Graphics2D g2d = (Graphics2D) grphcs;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				GradientPaint gp = new GradientPaint(0, 0,new Color(16,141,199), 240, getHeight(), new Color(239,142,56));
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, getWidth(), getHeight());

			}
		};
//		panel_2.setBackground(SetColor.blueOp);
		contentPane.add(panel_2, "name_111129428559600");
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Nhập mật khẩu mới");
		lblNewLabel_1.setFont(font);
		lblNewLabel_1.setForeground(SetColor.whiteFont);
		lblNewLabel_1.setBounds(36, 32, 117, 25);
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Nhập lại mật khẩu");
		lblNewLabel_1_1.setForeground(SetColor.whiteFont);
		lblNewLabel_1_1.setFont(font);
		lblNewLabel_1_1.setBounds(36, 68, 117, 25);
		panel_2.add(lblNewLabel_1_1);

		btnNewButton_1 = new JButton("Hoàn thành");
		btnNewButton_1.setFont(font);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				checkPanel3();
			}
		});
		btnNewButton_1.setBounds(36, 104, 117, 23);
		panel_2.add(btnNewButton_1);

		JCheckBox checkbox = new JCheckBox("Hiển thị mật khẩu");
		checkbox.setOpaque(false);
		checkbox.setForeground(SetColor.whiteFont);
//		checkbox.setBackground(SetColor.blueOp);
		checkbox.setFont(font);
		checkbox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (checkbox.isSelected()) {
					pass1.setEchoChar((char) 0);
					pass2.setEchoChar((char) 0);
				} else {
					pass1.setEchoChar('*');
					pass2.setEchoChar('*');
				}
			}
		});
		checkbox.setBounds(204, 104, 141, 23);
		panel_2.add(checkbox);

		pass1 = new JPasswordField();
		pass1.setBorder(null);
		pass1.setEchoChar('*');
		pass1.setBounds(204, 32, 141, 22);
		panel_2.add(pass1);

		pass2 = new JPasswordField();
		pass2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				checkPanel3();
			}
		});
		pass2.setBorder(null);
		pass2.setEchoChar('*');
		pass2.setBounds(204, 70, 141, 22);
		panel_2.add(pass2);
	}

	@SuppressWarnings("deprecation")
	private void checkPanel3() {
		if (pass1.getText().equals("") || pass2.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Mật khẩu không được để trống!");
		} else {
			if (pass1.getText().equals(pass2.getText())) {
				String pass = BCrypt.hashpw(pass1.getText(), BCrypt.gensalt(12));
				AccountDAO.getInstance().updatePassword(textField.getText(), pass);
				JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
				closeFrame();
			} else
				JOptionPane.showMessageDialog(null, "Mật khẩu không trùng khớp!");
		}
	}

	private void checkPanel2() {
		String otp = textField_1.getText();
		if (otp.equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập OTP!");
		} else {
			if (otp.length() < 6 || otp.length() > 6) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng 6 chữ số!");
			} else {
				if (otp.equals(otpNumber)) {
					CardLayout forgotPassword = (CardLayout) contentPane.getLayout();
					forgotPassword.next(contentPane);
				} else
					JOptionPane.showMessageDialog(null, "Mã xác nhận không chính xác!");
			}
		}
	}

	private void checkPanel1() {
		if (isValid(textField.getText())) {
			if (checkEmail(textField.getText())) {
				otpNumber = getOTP();
				SendEmailSMTP.sendOTP(textField.getText(), otpNumber);
				JOptionPane.showMessageDialog(null, "Mã xác nhận đã gửi về hòm thư của bạn!");
				CardLayout forgotPassword = (CardLayout) contentPane.getLayout();
				forgotPassword.next(contentPane);
			} else
				JOptionPane.showMessageDialog(null, "Email không tồn tại trên hệ thống!");
		} else
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng email!");

		
	}

	static boolean isValid(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}

	private boolean checkEmail(String email) {
		ArrayList<Account> acc = AccountDAO.getInstance().selectAll();
		for (Account i : acc) {
			if (i.getEmail().toLowerCase().equals(email.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	private String getOTP() {
		int min = 100000;
		int max = 999999;
		return Integer.toString((int) ((Math.random() * (max - min)) + min));
	}
	
	private void closeFrame() {
		this.dispose();
	}
}
