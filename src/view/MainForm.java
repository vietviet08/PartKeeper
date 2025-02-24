package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import color.SetColor;
import decor.BooleanClick;
import decor.PanelRound;
import font.SetFont;

public class MainForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public Font font;
	public Font font_1;
	public Font font1;
	public Font font2;
	public static JPanel maincontent;
	private JLabel btnNhaCungCap;
	private JLabel btnNhapHang;
	private JLabel btnPhieuNhap;
	private JLabel btnXuatHang;
	private JLabel btnPhieuXuat;
	private JLabel btnThongKe;
	private JLabel btnKhchHng;
	private JLabel btnCpu;
//	JButton
	private JLabel btnBnPhm;
	private JLabel btnChut;
	private JLabel btnMnHnh;
	private JLabel btnRam;
	private JLabel btnVga;
	private JLabel btnMainboard;
	private JLabel btnNgun;
	private static JLabel btnAllProduct;
	private JLabel btnCase;
	private JLabel btnTaiNghe;
	private JLabel lblNewLabel;
	private JPanel panel_3;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_4;
	private JPanel panel_10;
	private JLabel lblNewLabel_2;
	private JLabel btnSSD;
	private JLabel btnHDD;
	private JLabel btnTrangChu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new FlatLightLaf());
//					UIManager.put("Table.showVerticalLines", true);
//					UIManager.put("Table.showHorizontalLines", true);
					MainForm frame = new MainForm();
//					setDateToLable();
					frame.setResizable(false);
					ProductForm pf = new ProductForm();
					maincontent.add(pf).setVisible(true);
					MainForm.btnAllProduct.setForeground(new Color(130, 224, 170));
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

	public MainForm() {
		Color whiteFont = new Color(254, 254, 254);

		Color green = new Color(130, 224, 170);
//		Color redB = new Color(220, 19, 46);
		Color blue = new Color(64, 143, 221);
		Color blueOp = new Color(98, 181, 244);
//		Color orange = new Color(230, 126, 34);
//
//		Color clickButton = new Color(211, 84, 0);
//		Color defaultColor = new Color(230, 126, 24);

		try {
			File fontStyle = new File("src/font/Roboto-Medium.ttf");
			font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(11f);
			font_1 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(14f);
			font1 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(16f);
			font2 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(22f);

		} catch (Exception e) {
			System.out.println(e);
		}

		this.setTitle("Quản lý linh kiện máy tính");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1410, 802);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		PanelRound navbar = new PanelRound() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
//			@Override
//			protected void paintComponent(Graphics grphcs) {
//				super.paintComponent(grphcs);
//				Graphics2D g2d = (Graphics2D) grphcs;
//				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//				GradientPaint gp = new GradientPaint(0, 0,new Color(15,18,57), 180, getHeight(), new Color(64, 143, 221));
//				g2d.setPaint(gp);
//				g2d.fillRect(0, 0, getWidth(), getHeight());
//
//			}
		};
		navbar.setRoundTopRight(30);
		navbar.setRoundTopLeft(30);
		navbar.setRoundBottomRight(30);
		navbar.setRoundBottomLeft(30);
		navbar.setBorder(null);
		navbar.setBackground(blue);
		navbar.setForeground(whiteFont);
		navbar.setFont(font_1);
		navbar.setBounds(220, 0, 1175, 37);
		contentPane.add(navbar);
		navbar.setLayout(null);

		btnAllProduct = new JLabel("Tất cả sản phẩm");
		btnAllProduct.setOpaque(false);
		btnAllProduct.setForeground(whiteFont);
		btnAllProduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
				ProductForm pf = new ProductForm();
				maincontent.add(pf).setVisible(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnAllProduct.setForeground(green);
				btnCpu.setForeground(whiteFont);
				btnRam.setForeground(whiteFont);
				btnVga.setForeground(whiteFont);
				btnMainboard.setForeground(whiteFont);
				btnCase.setForeground(whiteFont);
				btnNgun.setForeground(whiteFont);
				btnMnHnh.setForeground(whiteFont);
				btnChut.setForeground(whiteFont);
				btnBnPhm.setForeground(whiteFont);
				btnTaiNghe.setForeground(whiteFont);
				btnSSD.setForeground(whiteFont);
				btnHDD.setForeground(whiteFont);
			}
		});
		btnAllProduct.setBackground(blue);
		btnAllProduct.setFont(SetFont.fontCategoryPr());
		btnAllProduct.setBounds(10, 11, 94, 15);
		navbar.add(btnAllProduct);
		btnAllProduct.setBorder(null);

		btnCpu = new JLabel("CPU");
		btnCpu.setIcon(new ImageIcon(MainForm.class.getResource("/icon/icons8-cpu-20.png")));
		btnCpu.setHorizontalAlignment(SwingConstants.CENTER);
		btnCpu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
				CPUForm cf = new CPUForm();
				maincontent.add(cf).setVisible(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnAllProduct.setForeground(whiteFont);
				btnCpu.setForeground(green);
				btnRam.setForeground(whiteFont);
				btnVga.setForeground(whiteFont);
				btnMainboard.setForeground(whiteFont);
				btnCase.setForeground(whiteFont);
				btnNgun.setForeground(whiteFont);
				btnMnHnh.setForeground(whiteFont);
				btnChut.setForeground(whiteFont);
				btnBnPhm.setForeground(whiteFont);
				btnTaiNghe.setForeground(whiteFont);
				btnSSD.setForeground(whiteFont);
				btnHDD.setForeground(whiteFont);
			}
		});
		btnCpu.setBackground(blue);
		btnCpu.setFont(SetFont.fontCategoryPr());
		btnCpu.setForeground(whiteFont);
		btnCpu.setBorder(null);
		btnCpu.setBounds(110, 7, 65, 22);
		navbar.add(btnCpu);

		btnRam = new JLabel("RAM");
		btnRam.setIcon(new ImageIcon(MainForm.class.getResource("/icon/icons8-memory-slot-20.png")));
		btnRam.setHorizontalAlignment(SwingConstants.CENTER);
		btnRam.setOpaque(false);
		btnRam.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
				RAMForm rf = new RAMForm();
				maincontent.add(rf).setVisible(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnAllProduct.setForeground(whiteFont);
				btnCpu.setForeground(whiteFont);
				btnRam.setForeground(green);
				btnVga.setForeground(whiteFont);
				btnMainboard.setForeground(whiteFont);
				btnCase.setForeground(whiteFont);
				btnNgun.setForeground(whiteFont);
				btnMnHnh.setForeground(whiteFont);
				btnChut.setForeground(whiteFont);
				btnBnPhm.setForeground(whiteFont);
				btnTaiNghe.setForeground(whiteFont);
				btnSSD.setForeground(whiteFont);
				btnHDD.setForeground(whiteFont);
			}
		});
		btnRam.setBackground(blue);
		btnRam.setForeground(whiteFont);
		btnRam.setFont(SetFont.fontCategoryPr());
		btnRam.setBorder(null);
		btnRam.setBounds(187, 7, 65, 22);
		navbar.add(btnRam);

		btnVga = new JLabel("VGA");
		btnVga.setIcon(new ImageIcon(MainForm.class.getResource("/icon/icons8-video-card-20.png")));
		btnVga.setHorizontalAlignment(SwingConstants.CENTER);
		btnVga.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
				VGAForm vf = new VGAForm();
				maincontent.add(vf).setVisible(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnAllProduct.setForeground(whiteFont);
				btnCpu.setForeground(whiteFont);
				btnRam.setForeground(whiteFont);
				btnVga.setForeground(green);
				btnMainboard.setForeground(whiteFont);
				btnCase.setForeground(whiteFont);
				btnNgun.setForeground(whiteFont);
				btnMnHnh.setForeground(whiteFont);
				btnChut.setForeground(whiteFont);
				btnBnPhm.setForeground(whiteFont);
				btnTaiNghe.setForeground(whiteFont);
				btnSSD.setForeground(whiteFont);
				btnHDD.setForeground(whiteFont);
			}
		});
		btnVga.setBackground(blue);
		btnVga.setForeground(whiteFont);
		btnVga.setFont(SetFont.fontCategoryPr());
		btnVga.setBorder(null);
		btnVga.setBounds(262, 7, 65, 22);
		navbar.add(btnVga);

		btnMainboard = new JLabel("Main Board");
		btnMainboard.setIcon(new ImageIcon(MainForm.class.getResource("/icon/icons8-motherboard-20.png")));
		btnMainboard.setHorizontalAlignment(SwingConstants.CENTER);
		btnMainboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
				MainboardForm mf = new MainboardForm();
				maincontent.add(mf);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnAllProduct.setForeground(whiteFont);
				btnCpu.setForeground(whiteFont);
				btnRam.setForeground(whiteFont);
				btnVga.setForeground(whiteFont);
				btnMainboard.setForeground(green);
				btnCase.setForeground(whiteFont);
				btnNgun.setForeground(whiteFont);
				btnMnHnh.setForeground(whiteFont);
				btnChut.setForeground(whiteFont);
				btnBnPhm.setForeground(whiteFont);
				btnTaiNghe.setForeground(whiteFont);
				btnSSD.setForeground(whiteFont);
				btnHDD.setForeground(whiteFont);
			}
		});
		btnMainboard.setBackground(blue);
		btnMainboard.setForeground(whiteFont);
		btnMainboard.setFont(SetFont.fontCategoryPr());
		btnMainboard.setBorder(null);
		btnMainboard.setBounds(337, 7, 95, 22);
		navbar.add(btnMainboard);

		btnNgun = new JLabel("Nguồn");
		btnNgun.setIcon(new ImageIcon(MainForm.class.getResource("/icon/icons8-electrical-20.png")));
		btnNgun.setHorizontalAlignment(SwingConstants.CENTER);
		btnNgun.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
				maincontent.add(new PSUForm());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnAllProduct.setForeground(whiteFont);
				btnCpu.setForeground(whiteFont);
				btnRam.setForeground(whiteFont);
				btnVga.setForeground(whiteFont);
				btnMainboard.setForeground(whiteFont);
				btnCase.setForeground(whiteFont);
				btnNgun.setForeground(green);
				btnMnHnh.setForeground(whiteFont);
				btnChut.setForeground(whiteFont);
				btnBnPhm.setForeground(whiteFont);
				btnTaiNghe.setForeground(whiteFont);
				btnSSD.setForeground(whiteFont);
				btnHDD.setForeground(whiteFont);
			}
		});
		btnNgun.setForeground(whiteFont);
		btnNgun.setFont(SetFont.fontCategoryPr());
		btnNgun.setBackground(blue);
		btnNgun.setBorder(null);
		btnNgun.setBounds(517, 7, 75, 22);
		navbar.add(btnNgun);

		btnMnHnh = new JLabel("Màn hình");
		btnMnHnh.setIcon(new ImageIcon(MainForm.class.getResource("/icon/icons8-screen-20.png")));
		btnMnHnh.setHorizontalAlignment(SwingConstants.CENTER);
		btnMnHnh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnAllProduct.setForeground(whiteFont);
				btnCpu.setForeground(whiteFont);
				btnRam.setForeground(whiteFont);
				btnVga.setForeground(whiteFont);
				btnMainboard.setForeground(whiteFont);
				btnCase.setForeground(whiteFont);
				btnNgun.setForeground(whiteFont);
				btnMnHnh.setForeground(green);
				btnChut.setForeground(whiteFont);
				btnBnPhm.setForeground(whiteFont);
				btnTaiNghe.setForeground(whiteFont);
				btnSSD.setForeground(whiteFont);
				btnHDD.setForeground(whiteFont);
			}
		});
		btnMnHnh.setForeground(whiteFont);
		btnMnHnh.setFont(SetFont.fontCategoryPr());
		btnMnHnh.setBackground(blue);
		btnMnHnh.setBorder(null);
		btnMnHnh.setBounds(602, 7, 95, 22);
		navbar.add(btnMnHnh);

		btnChut = new JLabel("Chuột");
		btnChut.setIcon(new ImageIcon(MainForm.class.getResource("/icon/icons8-mouse-20.png")));
		btnChut.setHorizontalAlignment(SwingConstants.CENTER);
		btnChut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnAllProduct.setForeground(whiteFont);
				btnCpu.setForeground(whiteFont);
				btnRam.setForeground(whiteFont);
				btnVga.setForeground(whiteFont);
				btnMainboard.setForeground(whiteFont);
				btnCase.setForeground(whiteFont);
				btnNgun.setForeground(whiteFont);
				btnMnHnh.setForeground(whiteFont);
				btnChut.setForeground(green);
				btnBnPhm.setForeground(whiteFont);
				btnTaiNghe.setForeground(whiteFont);
				btnSSD.setForeground(whiteFont);
				btnHDD.setForeground(whiteFont);
			}
		});
		btnChut.setForeground(whiteFont);
		btnChut.setFont(SetFont.fontCategoryPr());
		btnChut.setBackground(blue);
		btnChut.setBorder(null);
		btnChut.setBounds(705, 7, 75, 22);
		navbar.add(btnChut);

		btnBnPhm = new JLabel("Bàn phím");
		btnBnPhm.setIcon(new ImageIcon(MainForm.class.getResource("/icon/icons8-keyboard-20.png")));
		btnBnPhm.setHorizontalAlignment(SwingConstants.CENTER);
		btnBnPhm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnAllProduct.setForeground(whiteFont);
				btnCpu.setForeground(whiteFont);
				btnRam.setForeground(whiteFont);
				btnVga.setForeground(whiteFont);
				btnMainboard.setForeground(whiteFont);
				btnCase.setForeground(whiteFont);
				btnNgun.setForeground(whiteFont);
				btnMnHnh.setForeground(whiteFont);
				btnChut.setForeground(whiteFont);
				btnBnPhm.setForeground(green);
				btnTaiNghe.setForeground(whiteFont);
				btnSSD.setForeground(whiteFont);
				btnHDD.setForeground(whiteFont);
			}
		});
		btnBnPhm.setForeground(whiteFont);
		btnBnPhm.setFont(SetFont.fontCategoryPr());
		btnBnPhm.setBackground(blue);
		btnBnPhm.setBorder(null);
		btnBnPhm.setBounds(790, 7, 95, 22);
		navbar.add(btnBnPhm);

		btnCase = new JLabel("Case");
		btnCase.setIcon(new ImageIcon(MainForm.class.getResource("/icon/icons8-workstation-20 (1).png")));
		btnCase.setHorizontalAlignment(SwingConstants.CENTER);
		btnCase.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnAllProduct.setForeground(whiteFont);
				btnCpu.setForeground(whiteFont);
				btnRam.setForeground(whiteFont);
				btnVga.setForeground(whiteFont);
				btnMainboard.setForeground(whiteFont);
				btnCase.setForeground(green);
				btnNgun.setForeground(whiteFont);
				btnMnHnh.setForeground(whiteFont);
				btnChut.setForeground(whiteFont);
				btnBnPhm.setForeground(whiteFont);
				btnTaiNghe.setForeground(whiteFont);
				btnSSD.setForeground(whiteFont);
				btnHDD.setForeground(whiteFont);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
				maincontent.add(new CaseForm());
			}
		});
		btnCase.setForeground(whiteFont);
		btnCase.setFont(SetFont.fontCategoryPr());
		btnCase.setBorder(null);
		btnCase.setBackground(blue);
		btnCase.setBounds(442, 7, 65, 22);
		navbar.add(btnCase);

		btnTaiNghe = new JLabel("Tai nghe");
		btnTaiNghe.setIcon(new ImageIcon(MainForm.class.getResource("/icon/icons8-headphone-20.png")));
		btnTaiNghe.setHorizontalAlignment(SwingConstants.CENTER);
		btnTaiNghe.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnAllProduct.setForeground(whiteFont);
				btnCpu.setForeground(whiteFont);
				btnRam.setForeground(whiteFont);
				btnVga.setForeground(whiteFont);
				btnMainboard.setForeground(whiteFont);
				btnCase.setForeground(whiteFont);
				btnNgun.setForeground(whiteFont);
				btnMnHnh.setForeground(whiteFont);
				btnChut.setForeground(whiteFont);
				btnBnPhm.setForeground(whiteFont);
				btnTaiNghe.setForeground(green);
				btnSSD.setForeground(whiteFont);
				btnHDD.setForeground(whiteFont);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
			}
		});
		btnTaiNghe.setForeground(whiteFont);
		btnTaiNghe.setFont(SetFont.fontCategoryPr());
		btnTaiNghe.setBorder(null);
		btnTaiNghe.setBackground(blue);
		btnTaiNghe.setBounds(888, 7, 95, 22);
		navbar.add(btnTaiNghe);

		btnSSD = new JLabel("SSD");
		btnSSD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
				maincontent.add(new SSDForm());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnAllProduct.setForeground(whiteFont);
				btnCpu.setForeground(whiteFont);
				btnRam.setForeground(whiteFont);
				btnVga.setForeground(whiteFont);
				btnMainboard.setForeground(whiteFont);
				btnCase.setForeground(whiteFont);
				btnNgun.setForeground(whiteFont);
				btnMnHnh.setForeground(whiteFont);
				btnChut.setForeground(whiteFont);
				btnBnPhm.setForeground(whiteFont);
				btnTaiNghe.setForeground(whiteFont);
				btnSSD.setForeground(green);
				btnHDD.setForeground(whiteFont);
			}

		});
		btnSSD.setIcon(new ImageIcon(MainForm.class.getResource("/icon/icons8-ssd-20.png")));
		btnSSD.setHorizontalAlignment(SwingConstants.CENTER);
		btnSSD.setForeground(new Color(254, 254, 254));
		btnSSD.setFont(SetFont.fontCategoryPr());
		btnSSD.setBorder(null);
		btnSSD.setBackground(new Color(64, 143, 221));
		btnSSD.setBounds(985, 7, 95, 22);
		navbar.add(btnSSD);

		btnHDD = new JLabel("HDD");
		btnHDD.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnAllProduct.setForeground(whiteFont);
				btnCpu.setForeground(whiteFont);
				btnRam.setForeground(whiteFont);
				btnVga.setForeground(whiteFont);
				btnMainboard.setForeground(whiteFont);
				btnCase.setForeground(whiteFont);
				btnNgun.setForeground(whiteFont);
				btnMnHnh.setForeground(whiteFont);
				btnChut.setForeground(whiteFont);
				btnBnPhm.setForeground(whiteFont);
				btnTaiNghe.setForeground(whiteFont);
				btnSSD.setForeground(whiteFont);
				btnHDD.setForeground(green);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
				maincontent.add(new HDDForm());
			}
		});
		btnHDD.setIcon(new ImageIcon(MainForm.class.getResource("/icon/icons8-hdd-20.png")));
		btnHDD.setHorizontalAlignment(SwingConstants.CENTER);
		btnHDD.setForeground(new Color(254, 254, 254));
		btnHDD.setFont(SetFont.fontCategoryPr());
		btnHDD.setBorder(null);
		btnHDD.setBackground(new Color(64, 143, 221));
		btnHDD.setBounds(1075, 7, 95, 22);
		navbar.add(btnHDD);

		maincontent = new JPanel();
		maincontent.setBounds(220, 37, 1175, 730);
		contentPane.add(maincontent);
		maincontent.setLayout(new CardLayout(0, 0));

		PanelRound panel_1 = new PanelRound() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

//			@Override
//			protected void paintComponent(Graphics grphcs) {
//				super.paintComponent(grphcs);
//				Graphics2D g2d = (Graphics2D) grphcs;
//				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//				GradientPaint gp = new GradientPaint(0, 0,new Color(15,18,57), 120, getHeight(), new Color(64, 143, 221));
//				g2d.setPaint(gp);
//				g2d.fillRect(0, 0, getWidth(), getHeight());
//
//			}
		};
		panel_1.setRoundTopRight(50);
// blue 64,143,221
//orig 230, 126, 34
		panel_1.setBackground(SetColor.blue);
		panel_1.setBounds(0, 0, 213, 767);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
//		btnNhaCungCap.setRadius(10);
//		btnNhaCungCap.setBorderColor(new Color(64, 143, 221));
		BooleanClick.setBtnNhaCungCap(true);

		JPanel panelDateTime = new JPanel();
//		panelDateTime.setBackground(blue);
		panelDateTime.setOpaque(false);
		ClockPane cp = new ClockPane();
		cp.setBackground(blue);
		cp.setOpaque(false);

		JSeparator separator = new JSeparator();
		separator.setBackground(Color.WHITE);
		separator.setBounds(7, 135, 200, 2);
		panel_1.add(separator);
		panelDateTime.add(cp);
//		 cp.BOTTOM_ALIGNMENT
		panelDateTime.setBounds(5, 5, 200, 32);
		panel_1.add(panelDateTime);
		panelDateTime.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblNewLabel = new JLabel(LoginForm.fullN);
		lblNewLabel.setIcon(new ImageIcon(MainForm.class.getResource("/icon/icons8-male-user-32-white.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(254, 254, 254));
		lblNewLabel.setFont(SetFont.font1_());
		lblNewLabel.setBounds(0, 95, 207, 32);
		panel_1.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBounds(0, 189, 210, 45);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		btnNhaCungCap = new JLabel();
		BooleanClick.setBtnNhaCungCap(false);
		btnNhaCungCap.setBounds(25, 5, 160, 34);
		panel_2.add(btnNhaCungCap);
		btnNhaCungCap.setHorizontalAlignment(SwingConstants.LEADING);
		btnNhaCungCap.setText("Nhà phân phối");
		btnNhaCungCap.setIconTextGap(15);
		btnNhaCungCap.setIcon(new ImageIcon(MainForm.class.getResource("/icon/icons8-flyer-distributor-male-32.png")));
		btnNhaCungCap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				220, 118, 51

//				btnNhaCungCap.setBackground(new Color(211, 84, 0));

				NhaPhanPhoiForm nppf = new NhaPhanPhoiForm();
				maincontent.removeAll();
				maincontent.add(nppf).setVisible(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
//				btnNhaCungCap.setForeground(green);
//				btnNhaCungCap.setBackground(blueOp);
//				btnNhapHang.setBackground(blue);
//				btnXuatHang.setBackground(blue);
//				btnPhieuXuat.setBackground(blue);
//				btnPhieuNhap.setBackground(blue);
//				btnKhchHng.setBackground(blue);
//				btnThongKe.setBackground(blue);
				btnTrangChu.setForeground(whiteFont);
				btnNhaCungCap.setForeground(green);
				btnNhapHang.setForeground(whiteFont);
				btnXuatHang.setForeground(whiteFont);
				btnPhieuXuat.setForeground(whiteFont);
				btnPhieuNhap.setForeground(whiteFont);
				btnKhchHng.setForeground(whiteFont);
				btnThongKe.setForeground(whiteFont);

				BooleanClick.setBtnTrangChu(false);
				BooleanClick.setBtnNhaCungCap(true);
				BooleanClick.setBtnNhapHang(false);
				BooleanClick.setBtnPhieuNhap(false);
				BooleanClick.setBtnXuatHang(false);
				BooleanClick.setBtnPhieuXuat(false);
				BooleanClick.setBtnKhchHng(false);
				BooleanClick.setBtnThongKe(false);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
//				btnNhaCungCap.setBackground(blueOp);

				btnNhaCungCap.setForeground(green);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (BooleanClick.isBtnNhaCungCap()) {
					btnNhaCungCap.setForeground(green);
				} else {
					btnNhaCungCap.setForeground(whiteFont);
				}

			}
		});
		// btnNhaCungCap.setFont(font1);
		btnNhaCungCap.setFont(SetFont.fontCategory());
		btnNhaCungCap.setBackground(SetColor.blueOp);
		btnNhaCungCap.setForeground(whiteFont);
		btnNhaCungCap.setBorder(null);

		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setOpaque(false);
		panel_3.setBounds(0, 235, 210, 45);
		panel_1.add(panel_3);

		btnNhapHang = new JLabel();
		btnNhapHang.setBounds(25, 5, 160, 34);
		panel_3.add(btnNhapHang);
		// btnNhapHang.setRadius(10);
		// btnNhapHang.setBorderColor(new Color(64, 143, 221));
		btnNhapHang.setText("Nhập hàng");
		btnNhapHang.setIconTextGap(15);
		btnNhapHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhapHang.setIcon(new ImageIcon(MainForm.class.getResource("/icon/icons8-load-cargo-32.png")));
		btnNhapHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
				NhapHangForm pnf = new NhapHangForm();
				maincontent.add(pnf).setVisible(true);
				;
			}

			@Override
			public void mousePressed(MouseEvent e) {
//				btnNhaCungCap.setBackground(blue);
//				btnNhapHang.setBackground(blueOp);
////				btnNhapHang.setColor(blueOp);
//				btnXuatHang.setBackground(blue);
//				btnPhieuXuat.setBackground(blue);
//				btnPhieuNhap.setBackground(blue);
//				btnKhchHng.setBackground(blue);
//				btnThongKe.setBackground(blue);
				btnTrangChu.setForeground(whiteFont);
				btnNhaCungCap.setForeground(whiteFont);
				btnNhapHang.setForeground(green);
				btnXuatHang.setForeground(whiteFont);
				btnPhieuXuat.setForeground(whiteFont);
				btnPhieuNhap.setForeground(whiteFont);
				btnKhchHng.setForeground(whiteFont);
				btnThongKe.setForeground(whiteFont);

				BooleanClick.setBtnTrangChu(false);
				BooleanClick.setBtnNhaCungCap(false);
				BooleanClick.setBtnNhapHang(true);
				BooleanClick.setBtnPhieuNhap(false);
				BooleanClick.setBtnXuatHang(false);
				BooleanClick.setBtnPhieuXuat(false);
				BooleanClick.setBtnKhchHng(false);
				BooleanClick.setBtnThongKe(false);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
//				btnNhapHang.setBackground(blueOp);
				btnNhapHang.setForeground(green);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (BooleanClick.isBtnNhapHang()) {
//					btnNhapHang.setBackground(blueOp);
					btnNhapHang.setForeground(green);
				} else
					btnNhapHang.setForeground(whiteFont);
//					btnNhapHang.setBackground(blue);
			}
		});
		btnNhapHang.setFont(SetFont.fontCategory());
		btnNhapHang.setBackground(blue);
		btnNhapHang.setForeground(whiteFont);
		btnNhapHang.setBorder(null);

		panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setOpaque(false);
		panel_5.setBounds(0, 459, 210, 45);
		panel_1.add(panel_5);

		btnThongKe = new JLabel();
		btnThongKe.setBounds(20, 5, 160, 34);
		panel_5.add(btnThongKe);
		// btnThongKe.setRadius(10);
		// btnThongKe.setBorderColor(new Color(64, 143, 221));
		btnThongKe.setText("Thống kê");
		btnThongKe.setIconTextGap(15);
		btnThongKe.setIcon(new ImageIcon(MainForm.class.getResource("/icon/icons8-stocks-32.png")));
		btnThongKe.setHorizontalAlignment(SwingConstants.LEFT);

		btnThongKe.setBackground(blue);
		btnThongKe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
				ThongKeForm tkf = new ThongKeForm();
				maincontent.add(tkf);
//				btnThongKe.setBackground(new Color(211, 84, 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
//				btnNhaCungCap.setBackground(blue);
//				btnNhapHang.setBackground(blue);
//				btnXuatHang.setBackground(blue);
//				btnPhieuXuat.setBackground(blue);
//				btnPhieuNhap.setBackground(blue);
//				btnThongKe.setBackground(blueOp);
//				btnKhchHng.setBackground(blue);
////				btnThongKe.setColor(blueOp);
				btnTrangChu.setForeground(whiteFont);
				btnNhaCungCap.setForeground(whiteFont);
				btnNhapHang.setForeground(whiteFont);
				btnXuatHang.setForeground(whiteFont);
				btnPhieuXuat.setForeground(whiteFont);
				btnPhieuNhap.setForeground(whiteFont);
				btnKhchHng.setForeground(whiteFont);
				btnThongKe.setForeground(green);

				BooleanClick.setBtnTrangChu(false);
				BooleanClick.setBtnNhaCungCap(false);
				BooleanClick.setBtnNhapHang(false);
				BooleanClick.setBtnPhieuNhap(false);
				BooleanClick.setBtnXuatHang(false);
				BooleanClick.setBtnPhieuXuat(false);
				BooleanClick.setBtnKhchHng(false);
				BooleanClick.setBtnThongKe(true);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
//					btnThongKe.setColor(blueOp);
				btnThongKe.setForeground(green);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (BooleanClick.isBtnThongKe()) {
//					btnThongKe.setColor(blueOp);
					btnThongKe.setForeground(green);
				}
//					else btnThongKe.setColor(blue);
				else
					btnThongKe.setForeground(whiteFont);
			}
		});
		btnThongKe.setFont(SetFont.fontCategory());

		btnThongKe.setForeground(whiteFont);
		btnThongKe.setBorder(null);

		panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setOpaque(false);
		panel_6.setBounds(0, 280, 210, 45);
		panel_1.add(panel_6);

		btnPhieuNhap = new JLabel();
		btnPhieuNhap.setBounds(25, 5, 160, 34);
		panel_6.add(btnPhieuNhap);
		// btnPhieuNhap.setRadius(10);
		// btnPhieuNhap.setBorderColor(new Color(64, 143, 221));
		btnPhieuNhap.setText("Phiếu nhập");
		btnPhieuNhap.setIconTextGap(15);
		btnPhieuNhap.setIcon(new ImageIcon(MainForm.class.getResource("/icon/icons8-parchment-32.png")));
		btnPhieuNhap.setHorizontalAlignment(SwingConstants.LEFT);
		btnPhieuNhap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
//				btnPhieuNhap.setBackground(new Color(211, 84, 0));
				PhieuNhapForm pnf = new PhieuNhapForm();
				maincontent.add(pnf).setVisible(true);
				;

			}

			@Override
			public void mousePressed(MouseEvent e) {
//				btnNhaCungCap.setBackground(blue);
//				btnNhapHang.setBackground(blue);
//				btnXuatHang.setBackground(blue);
//				btnPhieuXuat.setBackground(blue);
////				btnPhieuNhap.setBackground(blueOp);
//				btnPhieuNhap.setBackground(blueOp);
//				btnKhchHng.setBackground(blue);
//				btnThongKe.setBackground(blue);
				btnTrangChu.setForeground(whiteFont);
				btnNhaCungCap.setForeground(whiteFont);
				btnNhapHang.setForeground(whiteFont);
				btnXuatHang.setForeground(whiteFont);
				btnPhieuXuat.setForeground(whiteFont);
				btnPhieuNhap.setForeground(green);
				btnKhchHng.setForeground(whiteFont);
				btnThongKe.setForeground(whiteFont);

				BooleanClick.setBtnTrangChu(false);
				BooleanClick.setBtnNhaCungCap(false);
				BooleanClick.setBtnNhapHang(false);
				BooleanClick.setBtnPhieuNhap(true);
				BooleanClick.setBtnXuatHang(false);
				BooleanClick.setBtnPhieuXuat(false);
				BooleanClick.setBtnKhchHng(false);
				BooleanClick.setBtnThongKe(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
//				btnPhieuNhap.setBackground(blueOp);
				btnPhieuNhap.setForeground(green);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (BooleanClick.isBtnPhieuNhap()) {
//					btnPhieuNhap.setBackground(blueOp);
					btnPhieuNhap.setForeground(green);
				} else
					btnPhieuNhap.setForeground(whiteFont);
//					btnPhieuNhap.setBackground(blue);
			}
		});
		btnPhieuNhap.setFont(SetFont.fontCategory());
		btnPhieuNhap.setBackground(blue);
		btnPhieuNhap.setForeground(whiteFont);
		btnPhieuNhap.setBorder(null);

		panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setOpaque(false);
		panel_7.setBounds(0, 325, 210, 45);
		panel_1.add(panel_7);

		btnXuatHang = new JLabel();
		btnXuatHang.setBounds(24, 5, 160, 34);
		panel_7.add(btnXuatHang);
		// btnXuatHang.setRadius(10);
		// btnXuatHang.setBorderColor(new Color(64, 143, 221));
		btnXuatHang.setText("Xuất hàng");
		btnXuatHang.setIconTextGap(15);
		btnXuatHang.setIcon(new ImageIcon(MainForm.class.getResource("/icon/icons8-successful-delivery-32.png")));
		btnXuatHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnXuatHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
				XuatHangForm xhf = new XuatHangForm();
				maincontent.add(xhf);
//				btnXuatHang.setBackground(new Color(211, 84, 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
//				btnNhaCungCap.setBackground(blue);
//				btnNhapHang.setBackground(blue);
////				btnXuatHang.setBackground(blueOp);
//				btnXuatHang.setBackground(blueOp);
//				btnPhieuXuat.setBackground(blue);
//				btnPhieuNhap.setBackground(blue);
//				btnKhchHng.setBackground(blue);
//				btnThongKe.setBackground(blue);
				btnTrangChu.setForeground(whiteFont);
				btnNhaCungCap.setForeground(whiteFont);
				btnNhapHang.setForeground(whiteFont);
				btnXuatHang.setForeground(green);
				btnPhieuXuat.setForeground(whiteFont);
				btnPhieuNhap.setForeground(whiteFont);
				btnKhchHng.setForeground(whiteFont);
				btnThongKe.setForeground(whiteFont);

				BooleanClick.setBtnTrangChu(false);
				BooleanClick.setBtnNhaCungCap(false);
				BooleanClick.setBtnNhapHang(false);
				BooleanClick.setBtnPhieuNhap(false);
				BooleanClick.setBtnXuatHang(true);
				BooleanClick.setBtnPhieuXuat(false);
				BooleanClick.setBtnKhchHng(false);
				BooleanClick.setBtnThongKe(false);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnXuatHang.setBackground(blueOp);
				btnXuatHang.setForeground(green);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (BooleanClick.isBtnXuatHang()) {
//					btnXuatHang.setBackground(blueOp);
					btnXuatHang.setForeground(green);
				} else
					btnXuatHang.setForeground(whiteFont);
//					btnXuatHang.setBackground(blue);
			}
		});
		btnXuatHang.setFont(SetFont.fontCategory());
		btnXuatHang.setBackground(blue);
		btnXuatHang.setForeground(whiteFont);
		btnXuatHang.setBorder(null);

		panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setOpaque(false);
		panel_8.setBounds(0, 369, 210, 45);
		panel_1.add(panel_8);

		btnPhieuXuat = new JLabel();
		btnPhieuXuat.setBounds(24, 5, 160, 34);
		panel_8.add(btnPhieuXuat);
		// btnPhieuXuat.setRadius(10);
		// btnPhieuXuat.setBorderColor(new Color(64, 143, 221));
		btnPhieuXuat.setText("Phiếu xuất");
		btnPhieuXuat.setIconTextGap(15);
		btnPhieuXuat.setIcon(new ImageIcon(MainForm.class.getResource("/icon/icons8-scroll-32.png")));
		btnPhieuXuat.setHorizontalAlignment(SwingConstants.LEFT);
		btnPhieuXuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
				PhieuXuatForm pxf = new PhieuXuatForm();
				maincontent.add(pxf);
//				btnPhieuXuat.setBackground(new Color(211, 84, 0));
			}

			@Override
			public void mousePressed(MouseEvent e) {
//				btnNhaCungCap.setBackground(blue);
//				btnNhapHang.setBackground(blue);
//				btnXuatHang.setBackground(blue);
////				btnPhieuXuat.setBackground(blueOp);
//				btnPhieuXuat.setBackground(blueOp);
//				btnPhieuNhap.setBackground(blue);
//				btnKhchHng.setBackground(blue);
//				btnThongKe.setBackground(blue);
				btnTrangChu.setForeground(whiteFont);
				btnNhaCungCap.setForeground(whiteFont);
				btnNhapHang.setForeground(whiteFont);
				btnXuatHang.setForeground(whiteFont);
				btnPhieuXuat.setForeground(green);
				btnPhieuNhap.setForeground(whiteFont);
				btnKhchHng.setForeground(whiteFont);
				btnThongKe.setForeground(whiteFont);

				BooleanClick.setBtnTrangChu(false);
				BooleanClick.setBtnNhaCungCap(false);
				BooleanClick.setBtnNhapHang(false);
				BooleanClick.setBtnPhieuNhap(false);
				BooleanClick.setBtnXuatHang(false);
				BooleanClick.setBtnPhieuXuat(true);
				BooleanClick.setBtnKhchHng(false);
				BooleanClick.setBtnThongKe(false);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
//				btnPhieuXuat.setBackground(blueOp);
				btnPhieuXuat.setForeground(green);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (BooleanClick.isBtnPhieuXuat()) {
//					btnPhieuXuat.setBackground(blueOp);
					btnPhieuXuat.setForeground(green);
				} else
//					btnPhieuXuat.setBackground(blue);
					btnPhieuXuat.setForeground(whiteFont);
			}
		});
		btnPhieuXuat.setFont(SetFont.fontCategory());
		btnPhieuXuat.setBackground(blue);
		btnPhieuXuat.setForeground(whiteFont);
		btnPhieuXuat.setBorder(null);

		panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setOpaque(false);
		panel_9.setBounds(0, 415, 210, 45);
		panel_1.add(panel_9);

		btnKhchHng = new JLabel();
		btnKhchHng.setBounds(23, 5, 160, 34);
		panel_9.add(btnKhchHng);
		btnKhchHng.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
				KhachHangForm khf = new KhachHangForm();
				maincontent.add(khf);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
//				btnKhchHng.setBackground(blueOp);
				btnKhchHng.setForeground(green);
			}

			@Override

			public void mouseExited(MouseEvent e) {
				if (BooleanClick.isBtnKhchHng()) {
//					btnKhchHng.setBackground(blueOp);
					btnKhchHng.setForeground(green);
				} else
//					btnKhchHng.setBackground(blue);
					btnKhchHng.setForeground(whiteFont);
			}

			@Override
			public void mousePressed(MouseEvent e) {
//				btnNhaCungCap.setBackground(blue);
//				btnNhapHang.setBackground(blue);
//				btnXuatHang.setBackground(blue);
//				btnPhieuXuat.setBackground(blue);
//				btnPhieuNhap.setBackground(blue);
//				btnKhchHng.setBackground(blueOp);
//				btnThongKe.setBackground(blue);
				btnTrangChu.setForeground(whiteFont);
				btnNhaCungCap.setForeground(whiteFont);
				btnNhapHang.setForeground(whiteFont);
				btnXuatHang.setForeground(whiteFont);
				btnPhieuXuat.setForeground(whiteFont);
				btnPhieuNhap.setForeground(whiteFont);
				btnKhchHng.setForeground(green);
				btnThongKe.setForeground(whiteFont);

				BooleanClick.setBtnTrangChu(false);
				BooleanClick.setBtnNhaCungCap(false);
				BooleanClick.setBtnNhapHang(false);
				BooleanClick.setBtnPhieuNhap(false);
				BooleanClick.setBtnXuatHang(false);
				BooleanClick.setBtnPhieuXuat(false);
				BooleanClick.setBtnKhchHng(true);
				BooleanClick.setBtnThongKe(false);
			}
		});
		// btnKhchHng.setRadius(10);
		// btnKhchHng.setBorderColor(new Color(64, 143, 221));
		btnKhchHng.setText("Khách hàng");
		btnKhchHng.setIcon(new ImageIcon(MainForm.class.getResource("/icon/icons8-myspace-32.png")));
		btnKhchHng.setIconTextGap(15);
		btnKhchHng.setHorizontalAlignment(SwingConstants.LEFT);
		btnKhchHng.setForeground(new Color(254, 254, 254));
		btnKhchHng.setFont(SetFont.fontCategory());
		btnKhchHng.setBorder(null);
		btnKhchHng.setBackground(new Color(64, 143, 221));

		panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setOpaque(false);
		panel_4.setBounds(0, 666, 210, 45);
		panel_1.add(panel_4);

		JLabel btnThayDoiTT = new JLabel();
		btnThayDoiTT.setIconTextGap(15);
		btnThayDoiTT.setBounds(10, 11, 160, 30);
		panel_4.add(btnThayDoiTT);
		btnThayDoiTT.setForeground(whiteFont);
		btnThayDoiTT.setBackground(blue);
		// btnThayDoiTT.setBorderColor(new Color(64, 143, 221));
		// btnThayDoiTT.setRadius(10);
		btnThayDoiTT.setText("About");
		btnThayDoiTT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnThayDoiTT.setBackground(new Color(251, 252, 252));
				btnThayDoiTT.setForeground(Color.BLACK);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnThayDoiTT.setBackground(blue);
				btnThayDoiTT.setForeground(whiteFont);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				ThongTinTaiKhoan.main(null);
			}
		});
		btnThayDoiTT.setIcon(new ImageIcon(MainForm.class.getResource("/icon/icons8-info-32.png")));
		btnThayDoiTT.setBorder(null);
		btnThayDoiTT.setFont(SetFont.fontCategory());

		panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setOpaque(false);
		panel_10.setBounds(0, 722, 210, 45);
		panel_1.add(panel_10);

		JLabel btnDangXuat = new JLabel();
		btnDangXuat.setIconTextGap(15);
		btnDangXuat.setBounds(10, 0, 160, 34);
		panel_10.add(btnDangXuat);
		btnDangXuat.setForeground(whiteFont);
		btnDangXuat.setBackground(blue);
		// btnDangXuat.setBorderColor(new Color(64, 143, 221));
		// btnDangXuat.setRadius(10);
		btnDangXuat.setText("Đăng xuất");
		btnDangXuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDangXuat.setBackground(new Color(231, 76, 60));
				btnDangXuat.setForeground(SetColor.redB);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnDangXuat.setBackground(blue);
				btnDangXuat.setForeground(whiteFont);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int answ = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn đăng xuất?", "Cảnh báo",
						JOptionPane.YES_NO_OPTION);
				if (answ == JOptionPane.YES_OPTION) {
					closeFrame();
					LoginForm.main(null);
				}
			}
		});
		btnDangXuat.setIcon(new ImageIcon(MainForm.class.getResource("/icon/icons8-shutdown-32.png")));
		btnDangXuat.setBorder(null);
		btnDangXuat.setFont(SetFont.fontCategory());

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(35, -15, 150, 150);
		ImageIcon ii = new ImageIcon(new File("src/icon/viequoc-computer-re.png").getAbsolutePath());
		Image i = ii.getImage();
		i = i.getScaledInstance(lblNewLabel_2.getWidth(), lblNewLabel_2.getHeight(), Image.SCALE_SMOOTH);
		lblNewLabel_2.setIcon(new ImageIcon(i));

		panel_1.add(lblNewLabel_2);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setOpaque(false);
		panel_2_1.setBounds(0, 143, 210, 45);
		panel_1.add(panel_2_1);

		btnTrangChu = new JLabel();
		btnTrangChu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				maincontent.removeAll();
				maincontent.add(new TrangChuForm());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btnTrangChu.setForeground(green);
				btnNhaCungCap.setForeground(whiteFont);
				btnNhapHang.setForeground(whiteFont);
				btnXuatHang.setForeground(whiteFont);
				btnPhieuXuat.setForeground(whiteFont);
				btnPhieuNhap.setForeground(whiteFont);
				btnKhchHng.setForeground(whiteFont);
				btnThongKe.setForeground(whiteFont);

				BooleanClick.setBtnTrangChu(true);
				BooleanClick.setBtnNhaCungCap(false);
				BooleanClick.setBtnNhapHang(false);
				BooleanClick.setBtnPhieuNhap(false);
				BooleanClick.setBtnXuatHang(false);
				BooleanClick.setBtnPhieuXuat(false);
				BooleanClick.setBtnKhchHng(false);
				BooleanClick.setBtnThongKe(false);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
//				btnNhaCungCap.setBackground(blueOp);

				btnTrangChu.setForeground(green);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (BooleanClick.isBtnTrangChu()) {
					btnTrangChu.setForeground(green);
				} else {
					btnTrangChu.setForeground(whiteFont);
				}

			}
		});
		btnTrangChu.setIcon(new ImageIcon(MainForm.class.getResource("/icon/icons8-home-address-32.png")));
		btnTrangChu.setText("Trang chủ");
		btnTrangChu.setIconTextGap(15);
		btnTrangChu.setHorizontalAlignment(SwingConstants.LEADING);
		btnTrangChu.setForeground(new Color(254, 254, 254));
		btnTrangChu.setFont(SetFont.fontCategory());
		btnTrangChu.setBorder(null);
		btnTrangChu.setBackground(new Color(98, 181, 244));
		btnTrangChu.setBounds(25, 5, 160, 34);
		panel_2_1.add(btnTrangChu);

//		btnNewButton = new JButton("Light");
//		btnNewButton.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				toLight();
//			}
//		});
//		btnNewButton.setBorder(null);
//		btnNewButton.setBounds(0, 390, 95, 23);
//		panel_1.add(btnNewButton);
//		
//		btnDark = new JButton("Dark");
//		btnDark.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				toDark();
//			}
//		});
//		btnDark.setForeground(new Color(243, 243, 243));
//		btnDark.setBackground(Color.DARK_GRAY);
//		btnDark.setBorder(null);
//		btnDark.setBounds(90, 390, 89, 23);
//		panel_1.add(btnDark);

//		JScrollPane panelPane = new JScrollPane(panel);
//		panelPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//		panelPane.setBounds(0, 197, 183, 175);
//		contentPane.add(panelPane);

//		javax.swing.GroupLayout MainContentLayout = new javax.swing.GroupLayout(maincontent);
//		maincontent.setLayout(MainContentLayout);
//        MainContentLayout.setHorizontalGroup(
//            MainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 1180, Short.MAX_VALUE)
//        );
//        MainContentLayout.setVerticalGroup(
//            MainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 750, Short.MAX_VALUE)
//        );
//
//        getContentPane().add(maincontent, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1180, 750));
	}

	public void toLight() {
		try {
			UIManager.setLookAndFeel(new FlatLightLaf());
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void toDark() {
		try {
			UIManager.setLookAndFeel(new FlatDarkLaf());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

//	private static void setDateToLable() {
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//		LocalDateTime now = LocalDateTime.now();
//		lbDateTime.setText(dtf.format(now));
//	}

	class ClockPane extends JPanel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JLabel clock = new JLabel();

		public ClockPane() {

			setLayout(new BorderLayout());
			tickTock();
			clock.setForeground(SetColor.whiteFont);
//			clock.setBackground(SetColor.blue);
			clock.setFont(SetFont.font1_());
			clock.setOpaque(false);
			add(clock);
			Timer timer = new Timer(500, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					tickTock();
				}
			});
			timer.setRepeats(true);
			timer.setCoalesce(true);
			timer.setInitialDelay(0);
			timer.start();
		}

		public void tickTock() {
			SimpleDateFormat sdf = new SimpleDateFormat("EEE dd-MM-yyy hh:mm:ss aaa");
//			clock.setText(DateFormat.getDateTimeInstance().format(new Date()));
			clock.setText(sdf.format(new Date()));
		}
	}

	@SuppressWarnings("deprecation")
	private void closeFrame() {
		this.disable();
		this.dispose();
	}
}
