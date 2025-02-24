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

import color.SetColor;
import dao.NhaPhanPhoiDAO;
import font.SetFont;
import model.NhaPhanPhoi;

public class ThemNhaPhanPhoi extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfDiaChi;
	private JTextField tfSDT;
	private JTextField tfEmail;
	private NhaPhanPhoiForm nppf;
	public Font font;
	public Font font_1;
	public Font font1;
	public Font font2;
	public Font font3;
	private JTextField tfTen;
	private JTextField tfID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemNhaPhanPhoi frame = new ThemNhaPhanPhoi();
					frame.setLocationRelativeTo(null);
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
	public ThemNhaPhanPhoi() {

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

		setUndecorated(true);
		this.nppf = (NhaPhanPhoiForm) nppf;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setTitle("Thêm nhà phân phối");

		setBounds(100, 100, 736, 296);
		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 25, 25));
		getContentPane().setLayout(null);

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
				GradientPaint gp = new GradientPaint(0, 0, new Color(102, 125, 182), 0, getHeight(),
						new Color(0, 130, 200));
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, getWidth(), getHeight());

			}
		};
		panel.setBackground(SetColor.blueOp);
		panel.setBounds(0, 0, 754, 296);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("© 2023 NGUYỄN QUỐC VIỆT - 23CE.B029");
		lblNewLabel_1.setFont(font);
		lblNewLabel_1.setForeground(SetColor.whiteFont);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(30, 264, 668, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("THÊM NHÀ PHÂN PHỐI");
		lblNewLabel_2.setFont(SetFont.fontTitle());
		lblNewLabel_2.setForeground(SetColor.yellow);
		lblNewLabel_2.setBounds(10, 11, 217, 37);
		panel.add(lblNewLabel_2);

		JButton btnHuy = new JButton("Hủy");
		btnHuy.setBounds(583, 200, 115, 30);
		panel.add(btnHuy);
		btnHuy.setBorder(null);
		btnHuy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				thoatCuaSo();
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnHuy.setBackground(SetColor.redB);
				btnHuy.setForeground(SetColor.whiteFont);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnHuy.setBackground(SetColor.whiteFont);
				btnHuy.setForeground(Color.BLACK);
			}
		});
		btnHuy.setFont(font1);

		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(412, 200, 115, 30);
		panel.add(btnThem);
		btnThem.setBorder(null);
		btnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id = tfID.getText().trim();
				String ten = tfTen.getText().trim();
				String diaChi = tfDiaChi.getText().trim();
				String email = tfEmail.getText().trim();
				int sdt = Integer.parseInt(tfSDT.getText().trim());

				if (id.equals("") || ten.equals("")) {
					JOptionPane.showMessageDialog(null, "ID và tên không được bỏ trống!");
				} else {
					if (NhaPhanPhoiDAO.getInstance().selectById(id) == null) {
						NhaPhanPhoi npp = new NhaPhanPhoi();
						npp.setIdNPP(id);
						npp.setTenNPP(ten);
						npp.setDiaChi(diaChi);
						npp.setEmail(email);
						npp.setSdt(sdt);
						NhaPhanPhoiDAO.getInstance().insert(npp);
						JOptionPane.showMessageDialog(null, "Thêm thành công!");
						NhaPhanPhoiForm.loadDataToTable(NhaPhanPhoiDAO.getInstance().selectAll());
						// nppf.loadDataToTable(NhaPhanPhoiDAO.getInstance().selectAll());
						thoatCuaSo();
					} else
						JOptionPane.showMessageDialog(null, "ID nhà phân phối đã tồn tại!");
				}

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnThem.setBackground(SetColor.green);
				btnThem.setForeground(SetColor.whiteFont);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnThem.setBackground(SetColor.whiteFont);
				btnThem.setForeground(Color.BLACK);
			}
		});
		btnThem.setFont(font1);

		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setBounds(30, 105, 321, 39);
		panel.add(lblaCh);
		lblaCh.setForeground(SetColor.whiteFont);
		lblaCh.setFont(font_1);

		tfDiaChi = new JTextField();
		tfDiaChi.setFont(SetFont.fontDetails());
		tfDiaChi.setBounds(30, 132, 321, 33);
		panel.add(tfDiaChi);
		tfDiaChi.setBorder(null);
		tfDiaChi.setColumns(10);

		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setBounds(30, 165, 321, 39);
		panel.add(lblSinThoi);
		lblSinThoi.setFont(font_1);
		lblSinThoi.setForeground(SetColor.whiteFont);

		tfSDT = new JTextField();
		tfSDT.setFont(SetFont.fontDetails());
		tfSDT.setBounds(30, 200, 321, 33);
		panel.add(tfSDT);
		tfSDT.setBorder(null);
		tfSDT.setColumns(10);

		tfEmail = new JTextField();
		tfEmail.setFont(SetFont.fontDetails());
		tfEmail.setBounds(388, 132, 321, 33);
		panel.add(tfEmail);
		tfEmail.setBorder(null);
		tfEmail.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(388, 105, 321, 39);
		panel.add(lblEmail);
		lblEmail.setForeground(SetColor.whiteFont);
		lblEmail.setFont(font_1);

		JLabel lblNewLabel = new JLabel("ID Nhà phân phối");
		lblNewLabel.setFont(SetFont.font1_());
		lblNewLabel.setForeground(new Color(254, 254, 254));
		lblNewLabel.setBounds(30, 39, 321, 39);
		panel.add(lblNewLabel);

		tfTen = new JTextField();
		tfTen.setFont(null);
		tfTen.setColumns(10);
		tfTen.setBorder(null);
		tfTen.setBounds(387, 73, 321, 33);
		panel.add(tfTen);

		tfID = new JTextField();
		tfID.setFont(null);
		tfID.setColumns(10);
		tfID.setBorder(null);
		tfID.setBounds(30, 71, 321, 33);
		panel.add(tfID);

		JLabel lblTnNhPhn = new JLabel("Tên nhà phân phối");
		lblTnNhPhn.setFont(SetFont.font1_());
		lblTnNhPhn.setForeground(new Color(254, 254, 254));
		lblTnNhPhn.setBounds(387, 39, 321, 39);
		panel.add(lblTnNhPhn);

	}

	private void thoatCuaSo() {
		this.dispose();
	}
}
