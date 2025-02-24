package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.Blob;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import color.SetColor;
import dao.caseDAO;
import dao.cpuDAO;
import dao.hddDAO;
import dao.mainDAO;
import dao.psuDAO;
import dao.ramDAO;
import dao.ssdDAO;
import dao.vgaDAO;
import font.SetFont;
import model.Case;
import model.cpu;
import model.hdd;
import model.mainboard;
import model.psu;
import model.ram;
import model.ssd;
import model.vga;

public class ChiTietSP extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextArea textArea;
	private static String id;
	private static JLabel labelIMG;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					setId(key);
					ChiTietSP frame = new ChiTietSP();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					if (id.contains("cpu"))
						setDetailToCPU();
					else if (id.contains("r"))
						setDetailToRAM();
					else if (id.contains("vga"))
						setDetailToVGA();
					else if (id.contains("mba"))
						setDetailToMainboard();
					else if (id.contains("psu")) {
						setDetailToPSU();
					} else if (id.contains("case")) {
						setDetailToCase();
					} else if (id.contains("ssd")) {
						setDetailToSSD();
					} else if (id.contains("hdd")) {
						setDetailToHDD();
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChiTietSP() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 698, 428);
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
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textArea = new JTextArea();
		textArea.setFont(SetFont.fontDetails1());
		textArea.setWrapStyleWord(true);
		textArea.setWrapStyleWord(true);
		textArea.setBounds(10, 39, 361, 300);
		contentPane.add(textArea);

		JButton btnNewButton = new JButton("Đóng");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closeFrame();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(SetColor.redB);
				btnNewButton.setForeground(SetColor.whiteFont);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(SetColor.whiteFont);
				btnNewButton.setForeground(Color.black);

			}
		});
		btnNewButton.setFont(SetFont.font());
		btnNewButton.setBounds(320, 370, 107, 34);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("CHI TIẾT");
		lblNewLabel.setFont(SetFont.fontTitle());
		lblNewLabel.setForeground(SetColor.yellow);
		lblNewLabel.setBounds(10, 11, 378, 26);
		contentPane.add(lblNewLabel);

		labelIMG = new JLabel("Ảnh sản phẩm");
		labelIMG.setHorizontalAlignment(SwingConstants.CENTER);
		labelIMG.setBounds(381, 41, 300, 300);
		contentPane.add(labelIMG);
	}

	private void closeFrame() {
		this.dispose();
	}

	public static String getId() {
		return id;
	}

	public static void setId(String id) {
		ChiTietSP.id = id;
	}

	private static void setIMGToLabel(Blob blob) {
		try {
			byte[] by = blob.getBytes(1, (int) blob.length());
			ImageIcon ii = new ImageIcon(by);
			Image i = ii.getImage().getScaledInstance(labelIMG.getWidth(), labelIMG.getHeight(), Image.SCALE_SMOOTH);
			ii = new ImageIcon(i);
			labelIMG.setText("");
			labelIMG.setIcon(ii);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void setDetailToCPU() {
		cpu cpu = cpuDAO.getInstance().selectById(id);
		textArea.setText("-- ID sản phẩm: " + cpu.getIdSanPham() + "\n-- ID CPU: " + cpu.getIdCpu() + "\n-- Tên CPU: "
				+ cpu.getNameCpu() + "\n-- Xung nhịp: " + cpu.getXungNhip() + "\n-- Số nhân: " + cpu.getSoNhan()
				+ "\n-- Số luồng: " + cpu.getSoLuong() + "\n-- Điện năng tiêu thụ: " + cpu.getDienNangTieuThu()
				+ "\n-- Bộ nhớ đệm: " + cpu.getBoNhoDem());

		if (cpu.getImg() == null) {
			labelIMG.setIcon(null);
			labelIMG.setText("Sản phẩm hiện chưa có ảnh mẫu!");
			labelIMG.setIcon(new ImageIcon(ChiTietSP.class.getResource("/icon/icons8-no-image-14.png")));
		} else
			setIMGToLabel(cpu.getImg());

	}

	private static void setDetailToRAM() {
		ram ram = ramDAO.getInstance().selectById(id);
		System.out.println(id);
		textArea.setText("-- ID sản phẩm: " + ram.getIdSanPham() + "\n-- ID RAM: " + ram.getIdRam() + "\n-- Tên RAM: "
				+ ram.getTenRam() + "\n-- Loại RAM: " + ram.getLoai() + "\n-- Dung Lượng: " + ram.getDungLuong()
				+ "\n-- BUS: " + ram.getBus());

		if (ram.getImg() == null) {
			labelIMG.setIcon(null);
			labelIMG.setText("Sản phẩm hiện chưa có ảnh mẫu!");
			labelIMG.setIcon(new ImageIcon(ChiTietSP.class.getResource("/icon/icons8-no-image-14.png")));
		} else
			setIMGToLabel(ram.getImg());
	}

	private static void setDetailToVGA() {
		vga vga = vgaDAO.getInstance().selectById(id);
		textArea.setText("-- ID sản phẩm: " + vga.getIdSanPham() + "\n-- ID VGA: " + vga.getIdVga() + "\n-- Tên VGA: "
				+ vga.getTenVGA() + "\n-- Hãng VGA: " + vga.getHangVGA() + "\n-- Bộ nhớ: " + vga.getBoNho());

		if (vga.getImg() == null) {
			labelIMG.setIcon(null);
			labelIMG.setText("Sản phẩm hiện chưa có ảnh mẫu!");
			labelIMG.setIcon(new ImageIcon(ChiTietSP.class.getResource("/icon/icons8-no-image-14.png")));
		} else
			setIMGToLabel(vga.getImg());
	}

	private static void setDetailToMainboard() {
		mainboard mb = mainDAO.getInstance().selectById(id);
		textArea.setText("-- ID sản phẩm: " + mb.getIdSanPham() + "\n-- ID mainboard: " + mb.getIdMainboard()
				+ "\n-- Tên mainboard: " + mb.getTenMain() + "\n-- Tên hãng: " + mb.getTenHang() + "\n-- Hỗ trợ CPU: "
				+ mb.getHoTroCPU() + "\n-- Hỗ trợ RAM: " + mb.getHoTroRAM() + "\n-- Kích thước: " + mb.getKichThuoc());

		if (mb.getImg() == null) {
			labelIMG.setIcon(null);
			labelIMG.setText("Sản phẩm hiện chưa có ảnh mẫu!");
			labelIMG.setIcon(new ImageIcon(ChiTietSP.class.getResource("/icon/icons8-no-image-14.png")));
		} else
			setIMGToLabel(mb.getImg());
	}

	private static void setDetailToCase() {
		Case c = caseDAO.getInstance().selectById(id);
		textArea.setText("-- ID sản phẩm: " + c.getIdSanPham() + "\n-- ID Case: " + c.getIdCase() + "\n-- Tên Case: "
				+ c.getTenCase() + "\n-- Hãng: " + c.getHangCase() + "\n-- Chất liệu: " + c.getChatLieu()
				+ "\n-- Kích thước mainboard: " + c.getKichThuocMainboard());
		if (c.getImg() == null) {
			labelIMG.setIcon(null);
			labelIMG.setText("Sản phẩm hiện chưa có ảnh mẫu!");
			labelIMG.setIcon(new ImageIcon(ChiTietSP.class.getResource("/icon/icons8-no-image-14.png")));
		} else
			setIMGToLabel(c.getImg());
	}

	private static void setDetailToPSU() {
		psu psu = psuDAO.getInstance().selectById(id);
		textArea.setText("-- ID sản phẩm: " + psu.getIdSanPham() + "\n-- ID nguồn: " + psu.getIdNguon()
				+ "\n-- Tên nguồn: " + psu.getTenNguon() + "\n-- Hãng: " + psu.getHang() + "\n-- Công suất: "
				+ psu.getCongSuat() + "\n-- Chuẩn nguồn: " + psu.getChuanNguon() + "\n-- Kiểu dây: " + psu.getKieuDay()
				+ "\n-- Kích thước: " + psu.getKichThuoc());

		if (psu.getImg() == null) {
			labelIMG.setIcon(null);
			labelIMG.setText("Sản phẩm hiện chưa có ảnh mẫu!");
			labelIMG.setIcon(new ImageIcon(ChiTietSP.class.getResource("/icon/icons8-no-image-14.png")));
		} else
			setIMGToLabel(psu.getImg());
	}

	private static void setDetailToSSD() {
		ssd ssd = ssdDAO.getInstance().selectById(id);
		textArea.setText("-- ID sản phẩm: " + ssd.getIdSanPham() + "\n-- ID SSD: " + ssd.getIdSdd() + "\n-- Tên SSD: "
				+ ssd.getTenSsd() + "\n-- Hãng: " + ssd.getHang() + "\n-- Dung lượng: " + ssd.getDungLuong()
				+ "\n-- Loại SSD: " + ssd.getLoai() + "\n-- Tốc độ đọc: " + ssd.getTocDoDoc() + "\n-- Tốc độ ghi: "
				+ ssd.getTocDoGhi());
		if (ssd.getImg() == null) {
			labelIMG.setIcon(null);
			labelIMG.setText("Sản phẩm hiện chưa có ảnh mẫu!");
			labelIMG.setIcon(new ImageIcon(ChiTietSP.class.getResource("/icon/icons8-no-image-14.png")));
		} else
			setIMGToLabel(ssd.getImg());
	}

	private static void setDetailToHDD() {
		hdd hdd = hddDAO.getInstance().selectById(id);
		textArea.setText("-- ID sản phẩm: " + hdd.getIdSanPham() + "\n-- ID HDD: " + hdd.getIdhHdd()
				+ "\n-- Dung lượng: " + hdd.getDungLuong() + "\n-- Bộ nhớ đệm: " + hdd.getBoNhoDem()
				+ "\n-- Tốc độ vòng quay: " + hdd.getTocDoVongQuay());

		if (hdd.getImg() == null) {
			labelIMG.setIcon(null);
			labelIMG.setText("Sản phẩm hiện chưa có ảnh mẫu!");
			labelIMG.setIcon(new ImageIcon(ChiTietSP.class.getResource("/icon/icons8-no-image-14.png")));
		} else
			setIMGToLabel(hdd.getImg());
	}
}
