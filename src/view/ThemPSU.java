package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

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

import color.SetColor;
import controller.Checked;
import controller.LoadIMGURL;
import dao.SanPhamDAO;
import dao.psuDAO;
import font.SetFont;
import model.Products;
import model.psu;

public class ThemPSU extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField tfIDNguon;
	private JTextField tfTenNguon;
	private JTextField tfHang;
	private JTextField tfBaoHanh;
	private JTextField tfGia;
	private JTextField tfCongSuat;
	private JComboBox<String> comboBox_IDSP;
	private JLabel labelIMG;
	private JComboBox<String> comboBox_KieuDay;
	private JComboBox<String> comboBox_KichThuoc;
	private JComboBox<String> comboBox_ChuanNguon;
	private static String insert = "";

	private final String[] chuanNguon = { "80 Plus Bronze", "80 Plus Silver", "80 Plus Gold", "80 Plus Palatinum",
			"80 Plus Titanium" };
	private final String[] kieuDay = { "Full Modular", "Non Modular" };
	private final String[] kichThuoc = { "ATX", "SFX-L" };
	private JTextField tfLink;
	private JLabel labelTenSP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemPSU frame = new ThemPSU();
					setDefaultIDPSU(psuDAO.getInstance().selectAll());
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
	public ThemPSU() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 785, 465);
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
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID sản phẩm");
		lblNewLabel.setForeground(new Color(254, 254, 254));
		lblNewLabel.setFont(SetFont.font1_());
		lblNewLabel.setBounds(21, 62, 112, 30);
		contentPane.add(lblNewLabel);

		JLabel lblIdNgun = new JLabel("ID Nguồn");
		lblIdNgun.setForeground(new Color(254, 254, 254));
		lblIdNgun.setFont(SetFont.font1_());
		lblIdNgun.setBounds(299, 62, 71, 30);
		contentPane.add(lblIdNgun);

		tfIDNguon = new JTextField();
		tfIDNguon.setFont(SetFont.fontDetails());
		tfIDNguon.setEditable(false);
		tfIDNguon.setColumns(10);
		tfIDNguon.setBackground(Color.WHITE);
		tfIDNguon.setBounds(395, 62, 141, 30);
		contentPane.add(tfIDNguon);

		JLabel lblTnNgun = new JLabel("Tên nguồn");
		lblTnNgun.setForeground(new Color(254, 254, 254));
		lblTnNgun.setFont(SetFont.font1_());
		lblTnNgun.setBounds(21, 126, 71, 30);
		contentPane.add(lblTnNgun);

		tfTenNguon = new JTextField();
		tfTenNguon.setFont(SetFont.fontDetails());
		tfTenNguon.setColumns(10);
		tfTenNguon.setBounds(136, 126, 141, 30);
		contentPane.add(tfTenNguon);

		JLabel lblNewLabel_1_1_1 = new JLabel("Chuẩn nguồn");
		lblNewLabel_1_1_1.setForeground(new Color(254, 254, 254));
		lblNewLabel_1_1_1.setFont(SetFont.font1_());
		lblNewLabel_1_1_1.setBounds(299, 193, 86, 30);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblHng = new JLabel("Hãng");
		lblHng.setForeground(new Color(254, 254, 254));
		lblHng.setFont(SetFont.font1_());
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
		btnUpload.setFont(SetFont.font());
		btnUpload.setBorder(null);
		btnUpload.setBounds(698, 300, 71, 21);
		contentPane.add(btnUpload);

		JButton btnAdd = new JButton("Thêm");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String idSP = comboBox_IDSP.getSelectedItem().toString();
				String idNguon = tfIDNguon.getText();
				String ten = tfTenNguon.getText();
				String hang = tfHang.getText();
				String congSuat = tfCongSuat.getText();
				String chuanNguon = comboBox_ChuanNguon.getSelectedItem().toString();
				String kieuDay = comboBox_KieuDay.getSelectedItem().toString();
				String kichThuoc = comboBox_KichThuoc.getSelectedItem().toString();
				double gia = Double.parseDouble(tfGia.getText());
				String baoHanh = tfBaoHanh.getText();

				String url = tfLink.getText();
				if (insert.length() > 0 && url.length() > 0)
					JOptionPane.showMessageDialog(null, "Chỉ chọn 1 trong 2 nguồn hình ảnh!");
				else {

					psu psu = new psu(idSP, idNguon, ten, hang, congSuat, chuanNguon, kieuDay, kichThuoc, 0, gia,
							baoHanh, null);

					if (insert.equals("") && url.equals("")) {
						int check = psuDAO.getInstance().insertNotIMG(psu);
						insert = Checked.checkedAdd(check, insert);
					} else {
						if (url.equals("")) {
							int check = psuDAO.getInstance().insert(psu);
							insert = Checked.checkedAdd(check, insert);
						} else if (insert.equals("")) {
							int check = psuDAO.getInstance().insertIMGURL(psu, url);
							insert = Checked.checkedAdd(check, insert);
						}
					}
					PSUForm.loadDataToTable(psuDAO.getInstance().selectAll());
					closeFrame();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnAdd.setForeground(Color.white);
				btnAdd.setBackground(SetColor.green);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAdd.setForeground(Color.black);
				btnAdd.setBackground(Color.white);
			}
		});
		btnAdd.setFont(SetFont.font1());
		btnAdd.setBorder(null);
		btnAdd.setBounds(213, 381, 97, 30);
		contentPane.add(btnAdd);

		JButton btnCancel = new JButton("Hủy");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closeFrame();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnCancel.setForeground(Color.white);
				btnCancel.setBackground(SetColor.redB);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCancel.setForeground(Color.black);
				btnCancel.setBackground(Color.white);
			}
		});
		btnCancel.setFont(SetFont.font1());
		btnCancel.setBorder(null);
		btnCancel.setBounds(343, 381, 97, 30);
		contentPane.add(btnCancel);

		JLabel lblNewLabel_1 = new JLabel("© 2023 NGUYỄN QUỐC VIỆT - 23CE.B029");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(224, 255, 255));
		lblNewLabel_1.setFont(null);
		lblNewLabel_1.setBounds(21, 440, 759, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("THÊM NGUỒN");
		lblNewLabel_2.setForeground(new Color(249, 231, 159));
		lblNewLabel_2.setFont(SetFont.fontTitle());
		lblNewLabel_2.setBounds(10, 11, 267, 36);
		contentPane.add(lblNewLabel_2);

		JLabel lblCngSut = new JLabel("Công suất");
		lblCngSut.setForeground(new Color(254, 254, 254));
		lblCngSut.setFont(SetFont.font1_());
		lblCngSut.setBounds(21, 193, 71, 30);
		contentPane.add(lblCngSut);

		JLabel lblTnCpu_1_1 = new JLabel("Kiểu dây");
		lblTnCpu_1_1.setForeground(new Color(254, 254, 254));
		lblTnCpu_1_1.setFont(SetFont.font1_());
		lblTnCpu_1_1.setBounds(21, 258, 112, 30);
		contentPane.add(lblTnCpu_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Kích thước");
		lblNewLabel_1_1_1_1.setForeground(new Color(254, 254, 254));
		lblNewLabel_1_1_1_1.setFont(SetFont.font1_());
		lblNewLabel_1_1_1_1.setBounds(299, 258, 71, 30);
		contentPane.add(lblNewLabel_1_1_1_1);

		JLabel lbael = new JLabel("Bảo hành");
		lbael.setForeground(new Color(254, 254, 254));
		lbael.setFont(SetFont.font1_());
		lbael.setBounds(299, 320, 97, 30);
		contentPane.add(lbael);

		tfBaoHanh = new JTextField();
		tfBaoHanh.setFont(SetFont.fontDetails());
		tfBaoHanh.setColumns(10);
		tfBaoHanh.setBounds(395, 320, 141, 30);
		contentPane.add(tfBaoHanh);

		JLabel lblGi = new JLabel("Giá");
		lblGi.setForeground(new Color(254, 254, 254));
		lblGi.setFont(SetFont.font1_());
		lblGi.setBounds(21, 320, 71, 30);
		contentPane.add(lblGi);

		tfGia = new JTextField();
		tfGia.setFont(SetFont.fontDetails());
		tfGia.setColumns(10);
		tfGia.setBounds(136, 320, 141, 30);
		contentPane.add(tfGia);

		tfCongSuat = new JTextField();
		tfCongSuat.setFont(SetFont.fontDetails());
		tfCongSuat.setColumns(10);
		tfCongSuat.setBounds(136, 193, 141, 30);
		contentPane.add(tfCongSuat);

		ArrayList<Products> list = SanPhamDAO.getIDSanPham("psu");
		int size = list.size();
		String[] combo = new String[size];
		for (int i = 0; i < size; i++) {
			combo[i] = list.get(i).getIdSanPham();
		}

		comboBox_IDSP = new JComboBox<>(combo);
		comboBox_IDSP.setFont(SetFont.fontDetails());
		comboBox_IDSP.setBounds(136, 62, 141, 30);
		comboBox_IDSP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String src = comboBox_IDSP.getSelectedItem().toString();
				labelTenSP.setText(SanPhamDAO.getInstance().selectById(src).getTenSanPham());
			}
		});
		contentPane.add(comboBox_IDSP);

		comboBox_ChuanNguon = new JComboBox<>(chuanNguon);
		comboBox_ChuanNguon.setFont(SetFont.fontDetails());
		comboBox_ChuanNguon.setBounds(395, 193, 141, 30);
		contentPane.add(comboBox_ChuanNguon);

		comboBox_KichThuoc = new JComboBox<>(kichThuoc);
		comboBox_KichThuoc.setFont(SetFont.fontDetails());
		comboBox_KichThuoc.setBounds(395, 258, 141, 30);
		contentPane.add(comboBox_KichThuoc);

		comboBox_KieuDay = new JComboBox<>(kieuDay);
		comboBox_KieuDay.setFont(SetFont.fontDetails());
		comboBox_KieuDay.setBounds(136, 258, 141, 30);
		contentPane.add(comboBox_KieuDay);

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
				insert = LoadIMGURL.setIMG(tfLink, labelIMG, insert);
			}
		});
		btnNewButton.setBounds(718, 19, 51, 20);
		contentPane.add(btnNewButton);

		labelTenSP = new JLabel("");
		labelTenSP.setFont(SetFont.font());
		labelTenSP.setForeground(SetColor.whiteFont);
		labelTenSP.setBounds(136, 95, 141, 14);
		contentPane.add(labelTenSP);
	}

	private void closeFrame() {
		this.dispose();
	}

	public static String getInsert() {
		return insert;
	}

	public static void setInsert(String insert) {
		ThemPSU.insert = insert;
	}

	private static void setDefaultIDPSU(ArrayList<psu> arr) {

		int id = arr.size() + 1;
		String check = "";
		for (psu c : arr) {
			if (c.getIdNguon().equals("psu" + id)) {
				check = c.getIdNguon();
			}
		}
		while (check.length() != 0) {
			String c = check;
			id++;
			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i).getIdNguon().equals("psu" + id)) {
					check = arr.get(i).getIdNguon();
				}
			}
			if (check.equals(c)) {
				check = "";
			}
		}

		tfIDNguon.setText("psu" + id);
	}
}
