package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import color.SetColor;
import dao.NhaPhanPhoiDAO;
import decor.HoverButton;
import font.SetFont;
import model.NhaPhanPhoi;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CapNhatNhaPhanPhoi extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public Font font;
	public Font font_1;
	public Font font1;
	public Font font2;
	public Font font3;
	private static JTextField tfTen;
	private static JTextField tfDiaChi;
	private static JTextField tfSDT;
	private static JTextField tfEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CapNhatNhaPhanPhoi frame = new CapNhatNhaPhanPhoi();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					setDefaultJtextFiel();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CapNhatNhaPhanPhoi() {

		setUndecorated(true);
		try {
			File fontStyle = new File("src/font/Roboto-Medium.ttf");
			font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(11f);
			font_1 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(14f);
			font1 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(16f);
			font2 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(22f);
			File fontStyle1 = new File("src/font/Oswald-Medium.ttf");
			font3 = Font.createFont(Font.TRUETYPE_FONT, fontStyle1).deriveFont(18f);

		} catch (Exception e) {
			System.out.println(e);
		}

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 476, 295);
		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 25, 25));
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
				GradientPaint gp = new GradientPaint(0, 0, new Color(102, 125, 182), 0, getHeight(),
						new Color(0, 130, 200));
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, getWidth(), getHeight());

			}
		};
		contentPane.setBackground(SetColor.blueOp);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("CẬP NHẬT NHÀ PHÂN PHỐI");
		lblNewLabel.setFont(font3);
		lblNewLabel.setForeground(SetColor.yellow);
		lblNewLabel.setBounds(29, 11, 409, 40);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tên nhà phân phối");
		lblNewLabel_1.setFont(font_1);
		lblNewLabel_1.setForeground(SetColor.whiteFont);
		lblNewLabel_1.setBounds(29, 58, 201, 37);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Địa chỉ");
		lblNewLabel_1_1.setFont(font_1);
		lblNewLabel_1_1.setForeground(SetColor.whiteFont);
		lblNewLabel_1_1.setBounds(262, 58, 201, 37);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Email");
		lblNewLabel_1_2.setFont(font_1);
		lblNewLabel_1_2.setForeground(SetColor.whiteFont);
		lblNewLabel_1_2.setBounds(29, 122, 201, 37);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_1_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_1_1.setFont(font_1);
		lblNewLabel_1_1_1.setForeground(SetColor.whiteFont);
		lblNewLabel_1_1_1.setBounds(262, 122, 201, 37);
		contentPane.add(lblNewLabel_1_1_1);

		JButton btnNewButton = new JButton("Cập nhật");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBorder(null);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				HoverButton.hoverCancel(btnNewButton, true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				HoverButton.hoverCancel(btnNewButton, false);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				NhaPhanPhoi n = NhaPhanPhoiForm.getNppSelect();
				String id = n.getIdNPP();
				String ten = tfTen.getText();
				String diaChi = tfDiaChi.getText();
				String email = tfEmail.getText();
				int sdt = Integer.parseInt(tfSDT.getText());

				NhaPhanPhoi npp = new NhaPhanPhoi(id, ten, diaChi, email, sdt);
				NhaPhanPhoiDAO.getInstance().update(npp);
				NhaPhanPhoiForm.loadDataToTable(NhaPhanPhoiDAO.getInstance().selectAll());

				JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
				closeFrame();
			}
		});
		btnNewButton.setFont(font1);
		btnNewButton.setBounds(115, 207, 115, 30);
		contentPane.add(btnNewButton);

		JButton btnHy = new JButton("Hủy");
		btnHy.setBorder(null);
		btnHy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				HoverButton.hoverOK(btnHy, true);
			}

			public void mouseExited(MouseEvent e) {
				HoverButton.hoverOK(btnHy, false);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				closeFrame();
			}
		});
		btnHy.setFont(font1);
		btnHy.setBounds(262, 207, 115, 30);
		contentPane.add(btnHy);

		tfTen = new JTextField();
		tfTen.setFont(SetFont.fontDetails());
		tfTen.setBorder(null);
		tfTen.setBounds(29, 93, 201, 30);
		contentPane.add(tfTen);
		tfTen.setColumns(10);

		tfDiaChi = new JTextField();
		tfDiaChi.setFont(SetFont.fontDetails());
		tfDiaChi.setBorder(null);
		tfDiaChi.setColumns(10);
		tfDiaChi.setBounds(262, 93, 201, 30);
		contentPane.add(tfDiaChi);

		tfSDT = new JTextField();
		tfSDT.setFont(SetFont.fontDetails());
		tfSDT.setBorder(null);
		tfSDT.setColumns(10);
		tfSDT.setBounds(262, 153, 201, 30);
		contentPane.add(tfSDT);

		tfEmail = new JTextField();
		tfEmail.setFont(SetFont.fontDetails());
		tfEmail.setBorder(null);
		tfEmail.setColumns(10);
		tfEmail.setBounds(29, 153, 201, 30);
		contentPane.add(tfEmail);

		JLabel lblNewLabel_2 = new JLabel("© 2023 NGUYỄN QUỐC VIỆT - 23CE.B029");
		lblNewLabel_2.setForeground(SetColor.whiteFont);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 272, 478, 14);
		contentPane.add(lblNewLabel_2);
	}

	public void closeFrame() {
		this.dispose();
	}

	private static void setDefaultJtextFiel() {
		NhaPhanPhoi npp = NhaPhanPhoiForm.getNppSelect();
		tfTen.setText(npp.getTenNPP());
		tfDiaChi.setText(npp.getDiaChi());
		tfEmail.setText(npp.getEmail());
		tfSDT.setText(String.valueOf(npp.getSdt()));
	}

}
