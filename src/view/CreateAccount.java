package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

import color.SetColor;
import controller.BCrypt;
import controller.SendEmailSMTP;
import dao.AccountDAO;
import decor.ButtonRound;
import model.Account;

public class CreateAccount extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfuser;
	private JTextField tfname;
	private JLabel lblNewLabel_4;
	private JTextField tfmail;
	private JTextField tfotp;
	public ButtonGroup bg;
	private JPasswordField pass2;
	private JPasswordField pass1;
	private String otpNumber;
	public Font font;
	public Font font_1;
	public Font font1;
	public Font font2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new FlatLightLaf());
					CreateAccount frame = new CreateAccount();
					frame.setTitle("Tạo tài khoản");
					frame.setLocationRelativeTo(null);
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

	public static void fontRoboto() {

	}

	public CreateAccount() {
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
		setBounds(100, 100, 644, 365);
		contentPane = new JPanel() {
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
		contentPane.setOpaque(false);
//		contentPane.setBackground(SetColor.green);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tên đăng nhập");
//		lblNewLabel.setForeground(SetColor.whiteFont);
		lblNewLabel.setFont(font1);
//		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(28, 70, 154, 30);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Mật khẩu");
//		lblNewLabel_1.setForeground(SetColor.whiteFont);
		lblNewLabel_1.setFont(font1);
//		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(28, 131, 81, 30);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Nhập lại mật khẩu");
//		lblNewLabel_2.setForeground(SetColor.whiteFont);
		lblNewLabel_2.setFont(font1);
//		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(28, 191, 135, 30);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Họ và tên");
//		lblNewLabel_3.setForeground(SetColor.whiteFont);
		lblNewLabel_3.setFont(font1);
//		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(28, 255, 81, 30);
		contentPane.add(lblNewLabel_3);

		tfuser = new JTextField();
		tfuser.setBorder(null);
		tfuser.setBounds(166, 72, 195, 26);
		contentPane.add(tfuser);
		tfuser.setColumns(10);

		tfname = new JTextField();
		tfname.setBorder(null);
		tfname.setColumns(10);
		tfname.setBounds(166, 257, 195, 26);
		contentPane.add(tfname);

		lblNewLabel_4 = new JLabel("Giới tính");
//		lblNewLabel_4.setForeground(SetColor.whiteFont);
		lblNewLabel_4.setFont(font1);
//		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(371, 70, 81, 30);
		contentPane.add(lblNewLabel_4);

		JRadioButton rbtnam = new JRadioButton("Nam");
		rbtnam.setOpaque(false);
//		rbtnam.setForeground(SetColor.whiteFont);
//		rbtnam.setBackground(SetColor.green);
		rbtnam.setBounds(464, 72, 61, 23);
		rbtnam.setSelected(true);
		rbtnam.setActionCommand("nam");
		contentPane.add(rbtnam);

		JRadioButton rbtnu = new JRadioButton("Nữ");
		rbtnu.setOpaque(false);
//		rbtnu.setForeground(SetColor.whiteFont);
//		rbtnu.setBackground(SetColor.green);
		rbtnu.setBounds(561, 74, 61, 23);
		rbtnu.setActionCommand("nu");
		contentPane.add(rbtnu);

		bg = new ButtonGroup();
		bg.add(rbtnam);
		bg.add(rbtnu);

		ButtonRound btnNewButton = new ButtonRound();
		btnNewButton.setBorderColor(Color.WHITE);
		btnNewButton.setRadius(20);
		btnNewButton.setText("Đăng kí");
		btnNewButton.setBorder(null);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				String otp = tfotp.getText();
				if (tfuser.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập username!");
				} else if (pass1.getText().equals("") || pass2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập mật khẩu!");
				} else if (tfmail.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập email!");
				} else if (kiemTraUser(tfuser.getText())) {
					JOptionPane.showMessageDialog(null, "Username đã tồn tại trên hệ thống!");
				} else if (kiemTraMatKhau() == false) {
					JOptionPane.showMessageDialog(null, "Mật khẩu không trùng khớp");
				} else if (otp.equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập OTP!");
				} else {
					if (otp.length() < 6 || otp.length() > 6) {
						JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng 6 chữ số!");
					} else {
						if (otp.equals(otpNumber)) {
//		                    CardLayout forgotPassword = (CardLayout) jPanel3.getLayout();
//		                    forgotPassword.next(jPanel3);
							int i;
							if (bg.getSelection().getActionCommand().equals("nam")) {
								i = 1;
							} else
								i = 0;
							String pass = BCrypt.hashpw(pass1.getText(), BCrypt.gensalt(12));
							Account ac = new Account(tfuser.getText(), pass, tfname.getText(), tfmail.getText(), i, 1);
							AccountDAO.getInstance().insert(ac);
							JOptionPane.showMessageDialog(null, "Đăng ký thành công!");
							closeFrame();
						} else {
							JOptionPane.showMessageDialog(null, "Mã xác nhận không chính xác!");
						}
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(new Color(247, 220, 111));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new Color(253, 254, 254));
			}
		});
		btnNewButton.setFont(font2);
//		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton.setBounds(434, 244, 154, 45);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_2_1 = new JLabel("Email");
//		lblNewLabel_2_1.setForeground(SetColor.whiteFont);
		lblNewLabel_2_1.setFont(font1);
//		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(371, 131, 55, 30);
		contentPane.add(lblNewLabel_2_1);

		tfmail = new JTextField();
		tfmail.setBorder(null);
		tfmail.setColumns(10);
		tfmail.setBounds(441, 133, 181, 26);
		contentPane.add(tfmail);

		tfotp = new JTextField();
		tfotp.setBorder(null);
		tfotp.setColumns(10);
		tfotp.setBounds(510, 195, 112, 22);
		contentPane.add(tfotp);

		JButton btnNewButton_1 = new JButton("Gửi OTP");
		btnNewButton_1.setBorder(null);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = tfmail.getText();
				if (isValid(email)) {
					otpNumber = getOTP();
					SendEmailSMTP.sendOTP(email, otpNumber);
				} else {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng email!");
				}
			}
		});
		btnNewButton_1.setFont(font1);
//		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(377, 195, 112, 22);
		contentPane.add(btnNewButton_1);

		pass2 = new JPasswordField();
		pass2.setBorder(null);
		pass2.setEchoChar('*');
		pass2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pass2.setBounds(166, 193, 195, 26);
		contentPane.add(pass2);

		pass1 = new JPasswordField();
		pass1.setBorder(null);
		pass1.setEchoChar('*');
		pass1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pass1.setBounds(166, 133, 195, 26);
		contentPane.add(pass1);

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Hiển thị mật khẩu");
		chckbxNewCheckBox_1.setOpaque(false);
//		chckbxNewCheckBox_1.setBackground(SetColor.green);
		chckbxNewCheckBox_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (chckbxNewCheckBox_1.isSelected()) {
					pass1.setEchoChar((char) 0);
					pass2.setEchoChar((char) 0);
				} else {
					pass1.setEchoChar('*');
					pass2.setEchoChar('*');
				}
			}
		});
		chckbxNewCheckBox_1.setFont(font);
		chckbxNewCheckBox_1.setBounds(166, 226, 165, 17);
		contentPane.add(chckbxNewCheckBox_1);

		JLabel lblNewLabel_5 = new JLabel("***Vui lòng điền đầy đủ thông tin để hoàn tất quá trình đăng ký tài khoản!");
		lblNewLabel_5.setForeground(SetColor.copyRight);
		lblNewLabel_5.setFont(font);
		lblNewLabel_5.setBounds(50, 11, 552, 34);
		contentPane.add(lblNewLabel_5);
	}

	static boolean isValid(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}

//	private boolean checkEmail(String email) {
//		ArrayList<Account> acc = AccountDAO.getInstance().selectAll();
//		for (Account i : acc) {
//			if (i.getEmail().toLowerCase().equals(email.toLowerCase())) {
//				return true;
//			}
//		}
//		return false;
//	}

	private String getOTP() {
		int min = 100000;
		int max = 999999;
		return Integer.toString((int) ((Math.random() * (max - min)) + min));
	}

	private boolean kiemTraUser(String user) {
		ArrayList<Account> ketQua = AccountDAO.getInstance().selectAll();
		for (Account account : ketQua) {
			if (account.getUser().equals(user)) {
				return true;
			}

		}
		return false;
	}

	@SuppressWarnings("deprecation")
	private boolean kiemTraMatKhau() {
		if (pass1.getText().equals(pass2.getText())) {
			return true;
		}
		return false;
	}

	private void closeFrame() {
		this.dispose();
	}
}
