package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import color.SetColor;
import font.SetFont;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ThongTinTaiKhoan extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongTinTaiKhoan frame = new ThongTinTaiKhoan();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ThongTinTaiKhoan() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 543, 387);
		contentPane = new JPanel();
		contentPane.setBackground(SetColor.blueOp);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				closeFrame();
			}
		});
		btnNewButton.setBorder(null);
		btnNewButton.setFont(SetFont.font1());
		btnNewButton.setBounds(208, 244, 97, 35);
		contentPane.add(btnNewButton);

		JButton btnHy = new JButton("Hủy");
		btnHy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHy.setFont(SetFont.font1());
		btnHy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closeFrame();
			}
		});
		btnHy.setBorder(null);
		btnHy.setBounds(370, 244, 97, 35);
		contentPane.add(btnHy);

		JLabel lblNewLabel = new JLabel("User name");
		lblNewLabel.setForeground(SetColor.whiteFont);
		lblNewLabel.setFont(SetFont.font1_());
		lblNewLabel.setBounds(60, 55, 168, 29);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBorder(null);
		textField.setBounds(60, 87, 168, 29);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBounds(299, 87, 168, 29);
		contentPane.add(textField_1);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(SetColor.whiteFont);
		lblEmail.setFont(SetFont.font1_());
		lblEmail.setBounds(299, 55, 168, 29);
		contentPane.add(lblEmail);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBounds(299, 177, 168, 29);
		contentPane.add(textField_2);

		JLabel lblNewLabel_1_1 = new JLabel("Giới tính");
		lblNewLabel_1_1.setForeground(SetColor.whiteFont);
		lblNewLabel_1_1.setFont(SetFont.font1_());
		lblNewLabel_1_1.setBounds(299, 145, 168, 29);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblHVTn = new JLabel("Họ và tên");
		lblHVTn.setForeground(SetColor.whiteFont);
		lblHVTn.setFont(SetFont.font1_());
		lblHVTn.setBounds(60, 145, 168, 29);
		contentPane.add(lblHVTn);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		textField_3.setBounds(60, 177, 168, 29);
		contentPane.add(textField_3);

		JButton btnThayiMt = new JButton("Thay đổi mật khẩu");
		btnThayiMt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThayiMt.setFont(SetFont.font1());
		btnThayiMt.setBorder(null);
		btnThayiMt.setBounds(60, 244, 97, 35);
		contentPane.add(btnThayiMt);

		JLabel lblNewLabel_1 = new JLabel("© Copyright 2023, Bản quyền thuộc về NGUYỄN QUỐC VIỆT - 23CE.B029");
		lblNewLabel_1.setFont(SetFont.font());
		lblNewLabel_1.setForeground(SetColor.redB);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(60, 330, 407, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("THÔNG TIN TÀI KHOẢN");
		lblNewLabel_2.setFont(SetFont.fontTitle());
		lblNewLabel_2.setForeground(SetColor.yellow);
		lblNewLabel_2.setBounds(10, 11, 207, 33);
		contentPane.add(lblNewLabel_2);
	}

	private void closeFrame() {
		this.dispose();
	}
}
