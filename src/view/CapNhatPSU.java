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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.Checked;
import controller.LoadIMGURL;
import dao.SanPhamDAO;
import dao.psuDAO;
import decor.HoverButton;
import font.SetFont;
import model.Products;
import model.psu;

public class CapNhatPSU extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField tfTenNguon;
	private static JTextField tfHang;
	private static JTextField tfBaoHanh;
	private static JTextField tfGia;
	private static JTextField tfCongSuat;
	private static JTextField tfLink;
	private static String insert = "";
	private static JComboBox<String> comboBox_KichThuoc;
	private static JComboBox<String> comboBox_IDSP;
	private static JComboBox<String> comboBox_ChuanNguon;
	private static JComboBox<String> comboBox_KieuDay;

	private final String[] chuanNguon = { "80 Plus Bronze", "80 Plus Silver", "80 Plus Gold", "80 Plus Palatinum",
			"80 Plus Titanium" };
	private final String[] kieuDay = { "Full Modular", "Non Modular" };
	private final String[] kichThuoc = { "ATX", "SFX-L" };
	private static JLabel labelIMG;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CapNhatPSU frame = new CapNhatPSU();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					setDefaultText();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CapNhatPSU() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 817, 451);
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

		JLabel lblNewLabel = new JLabel("ID sản phẩm");
		lblNewLabel.setForeground(new Color(254, 254, 254));
		lblNewLabel.setFont(SetFont.font1_());
		lblNewLabel.setBounds(20, 66, 112, 30);
		contentPane.add(lblNewLabel);

		JLabel lblTnNgun = new JLabel("Tên nguồn");
		lblTnNgun.setForeground(new Color(254, 254, 254));
		lblTnNgun.setFont(SetFont.font1_());
		lblTnNgun.setBounds(299, 66, 71, 30);
		contentPane.add(lblTnNgun);

		tfTenNguon = new JTextField();
		tfTenNguon.setFont(SetFont.fontDetails());
		tfTenNguon.setColumns(10);
		tfTenNguon.setBounds(395, 66, 141, 30);
		contentPane.add(tfTenNguon);

		JLabel lblNewLabel_1_1_1 = new JLabel("Chuẩn nguồn");
		lblNewLabel_1_1_1.setForeground(new Color(254, 254, 254));
		lblNewLabel_1_1_1.setFont(SetFont.font1_());
		lblNewLabel_1_1_1.setBounds(299, 193, 86, 30);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblHng = new JLabel("Hãng");
		lblHng.setForeground(new Color(254, 254, 254));
		lblHng.setFont(null);
		lblHng.setBounds(299, 126, 71, 30);
		contentPane.add(lblHng);

		tfHang = new JTextField();
		tfHang.setFont(SetFont.fontDetails());
		tfHang.setColumns(10);
		tfHang.setBounds(395, 126, 141, 30);
		contentPane.add(tfHang);

		labelIMG = new JLabel("Ảnh PSU");
		labelIMG.setHorizontalAlignment(SwingConstants.CENTER);
		labelIMG.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelIMG.setBounds(546, 58, 223, 230);
		contentPane.add(labelIMG);

		JButton btnUpload = new JButton("Upload");
		btnUpload.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insert = LoadIMGURL.loadIMGFromDirecory(labelIMG, insert);
			}
		});
		btnUpload.setFont(null);
		btnUpload.setBorder(null);
		btnUpload.setBounds(698, 300, 71, 21);
		contentPane.add(btnUpload);

		JButton btnAdd = new JButton("Cập nhật");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updatePSU();
				closeFrame();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				HoverButton.hoverOK(btnAdd, true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				HoverButton.hoverOK(btnAdd, false);
			}
		});
		btnAdd.setFont(SetFont.font1());
		btnAdd.setBorder(null);
		btnAdd.setBounds(299, 321, 97, 30);
		contentPane.add(btnAdd);

		JButton btnCancel = new JButton("Hủy");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closeFrame();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				HoverButton.hoverCancel(btnCancel, true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				HoverButton.hoverCancel(btnCancel, false);
			}
		});
		btnCancel.setFont(SetFont.font1());
		btnCancel.setBorder(null);
		btnCancel.setBounds(439, 321, 97, 30);
		contentPane.add(btnCancel);

		JLabel lblNewLabel_1 = new JLabel("© 2023 NGUYỄN QUỐC VIỆT - 23CE.B029");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(224, 255, 255));
		lblNewLabel_1.setFont(SetFont.font());
		lblNewLabel_1.setBounds(36, 388, 759, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("CẬP NHẬT NGUỒN");
		lblNewLabel_2.setForeground(new Color(249, 231, 159));
		lblNewLabel_2.setFont(SetFont.fontTitle());
		lblNewLabel_2.setBounds(10, 11, 267, 36);
		contentPane.add(lblNewLabel_2);

		JLabel lblCngSut = new JLabel("Công suất");
		lblCngSut.setForeground(new Color(254, 254, 254));
		lblCngSut.setFont(SetFont.font1_());
		lblCngSut.setBounds(21, 126, 112, 30);
		contentPane.add(lblCngSut);

		JLabel lblTnCpu_1_1 = new JLabel("Kiểu dây");
		lblTnCpu_1_1.setForeground(new Color(254, 254, 254));
		lblTnCpu_1_1.setFont(SetFont.font1_());
		lblTnCpu_1_1.setBounds(21, 193, 112, 30);
		contentPane.add(lblTnCpu_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Kích thước");
		lblNewLabel_1_1_1_1.setForeground(new Color(254, 254, 254));
		lblNewLabel_1_1_1_1.setFont(SetFont.font1_());
		lblNewLabel_1_1_1_1.setBounds(299, 258, 71, 30);
		contentPane.add(lblNewLabel_1_1_1_1);

		JLabel lbael = new JLabel("Bảo hành");
		lbael.setForeground(new Color(254, 254, 254));
		lbael.setFont(SetFont.font1_());
		lbael.setBounds(21, 321, 97, 30);
		contentPane.add(lbael);

		tfBaoHanh = new JTextField();
		tfBaoHanh.setFont(SetFont.fontDetails());
		tfBaoHanh.setColumns(10);
		tfBaoHanh.setBounds(136, 321, 141, 30);
		contentPane.add(tfBaoHanh);

		JLabel lblGi = new JLabel("Giá");
		lblGi.setForeground(new Color(254, 254, 254));
		lblGi.setFont(SetFont.font1_());
		lblGi.setBounds(21, 258, 122, 30);
		contentPane.add(lblGi);

		tfGia = new JTextField();
		tfGia.setFont(SetFont.fontDetails());
		tfGia.setColumns(10);
		tfGia.setBounds(136, 258, 141, 30);
		contentPane.add(tfGia);

		tfCongSuat = new JTextField();
		tfCongSuat.setFont(SetFont.fontDetails());
		tfCongSuat.setColumns(10);
		tfCongSuat.setBounds(136, 126, 141, 30);
		contentPane.add(tfCongSuat);

		tfLink = new JTextField("");
		tfLink.setFont(SetFont.fontDetails());
		tfLink.setColumns(10);
		tfLink.setBounds(395, 19, 313, 20);
		contentPane.add(tfLink);

		JLabel lblTnNgun_1_2_1 = new JLabel("Link hình ảnh:");
		lblTnNgun_1_2_1.setForeground(new Color(254, 254, 254));
		lblTnNgun_1_2_1.setFont(SetFont.font1_());
		lblTnNgun_1_2_1.setBounds(299, 19, 97, 21);
		contentPane.add(lblTnNgun_1_2_1);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoadIMGURL.setIMG(tfLink, labelIMG, insert);
			}
		});
		btnNewButton.setBounds(718, 19, 51, 20);
		contentPane.add(btnNewButton);

		JLabel labelTenSP = new JLabel("");
		labelTenSP.setForeground(new Color(254, 254, 254));
		labelTenSP.setFont(SetFont.font1());
		labelTenSP.setBounds(136, 95, 141, 14);
		contentPane.add(labelTenSP);

		ArrayList<Products> list = SanPhamDAO.getIDSanPham("psu");
		int size = list.size();
		String[] combo = new String[size];
		for (int i = 0; i < size; i++)
			combo[i] = list.get(i).getIdSanPham();
		comboBox_IDSP = new JComboBox<>(combo);
		comboBox_IDSP.setBounds(136, 66, 141, 30);
		comboBox_IDSP.setFont(SetFont.fontDetails());
		contentPane.add(comboBox_IDSP);

		comboBox_KieuDay = new JComboBox<>(kieuDay);
		comboBox_KieuDay.setBounds(136, 193, 141, 30);
		comboBox_KieuDay.setFont(SetFont.fontDetails());
		contentPane.add(comboBox_KieuDay);

		comboBox_ChuanNguon = new JComboBox<>(chuanNguon);
		comboBox_ChuanNguon.setBounds(395, 193, 141, 30);
		comboBox_ChuanNguon.setFont(SetFont.fontDetails());
		contentPane.add(comboBox_ChuanNguon);

		comboBox_KichThuoc = new JComboBox<>(kichThuoc);
		comboBox_KichThuoc.setBounds(395, 258, 141, 30);
		comboBox_KichThuoc.setFont(SetFont.fontDetails());
		contentPane.add(comboBox_KichThuoc);
	}

	private void closeFrame() {
		this.dispose();
	}

	public static String getInsert() {
		return insert;
	}

	public static void setInsert(String insert) {
		CapNhatPSU.insert = insert;
	}

	private static void setDefaultText() {
		psu psu = getPSUSelect();
		comboBox_IDSP.setSelectedItem(psu.getIdSanPham());
		comboBox_KieuDay.setSelectedItem(psu.getKieuDay());
		comboBox_KichThuoc.setSelectedItem(psu.getKichThuoc());
		comboBox_ChuanNguon.setSelectedItem(psu.getChuanNguon());
		tfBaoHanh.setText(psu.getBaoHanh());
		tfCongSuat.setText(psu.getCongSuat());
		tfGia.setText(String.valueOf(psu.getDonGia()));
		tfHang.setText(psu.getHang());
		tfTenNguon.setText(psu.getTenNguon());

		if (psu.getImg() == null) {
			labelIMG.setIcon(new ImageIcon(CapNhatCase.class.getResource("/icon/icons8-no-image-14.png")));
			labelIMG.setText("Hiện sản phẩm chưa có ảnh mẫu");
		} else {
			Blob blob = psu.getImg();
			try {
				byte[] by = blob.getBytes(1, (int) blob.length());
				ImageIcon ii = new ImageIcon(by);
				Image i = ii.getImage().getScaledInstance(labelIMG.getWidth(), labelIMG.getHeight(),
						Image.SCALE_SMOOTH);
				ii = new ImageIcon(i);
				labelIMG.setText("");
				labelIMG.setIcon(ii);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	private static void updatePSU() {
		psu psu = getPSUSelect();
		String idsp = comboBox_IDSP.getSelectedItem().toString();
		String kieuday = comboBox_KieuDay.getSelectedItem().toString();
		String kichthuoc = comboBox_KichThuoc.getSelectedItem().toString();
		String chuannguon = comboBox_ChuanNguon.getSelectedItem().toString();
		String baohanh = tfBaoHanh.getText();
		String congsuat = tfCongSuat.getText();
		double gia = Double.valueOf(tfGia.getText());
		String hang = tfHang.getText();
		String ten = tfTenNguon.getText();

		psu p = new psu(idsp, psu.getIdNguon(), ten, hang, congsuat, chuannguon, kieuday, kichthuoc, psu.getTonKho(),
				gia, baohanh, null);

		String url = tfLink.getText();
		if (insert.length() > 0 && url.length() > 0)
			JOptionPane.showMessageDialog(null, "Chỉ chọn 1 trong 2 nguồn hình ảnh!");
		else {

			if (insert.equals("") && url.equals("")) {
				int check = psuDAO.getInstance().updateNotIMG(p);
				insert = Checked.checkedUpdate(check, insert);
			} else {
				if (url.equals("")) {
					int check = psuDAO.getInstance().update(p);
					insert = Checked.checkedUpdate(check, insert);
				} else if (insert.equals("")) {
					int check = psuDAO.getInstance().updateIMGURL(p, url);
					insert = Checked.checkedUpdate(check, insert);
				}
			}
			PSUForm.loadDataToTable(psuDAO.getInstance().selectAll());
		}
	}

	private static psu getPSUSelect() {
		return PSUForm.getPSUSelect();
	}

}
