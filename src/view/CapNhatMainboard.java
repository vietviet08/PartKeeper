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
import dao.mainDAO;
import decor.HoverButton;
import font.SetFont;
import model.Products;
import model.mainboard;

public class CapNhatMainboard extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField tfBaoHanh;
	private static JTextField tfKichThuoc;
	private static JTextField tfCPU;
	private static JTextField tfTen;
	private static JTextField tfHang;
	private static JTextField tfRAM;
	private static JTextField tfGia;
	private static JComboBox<String> comboBox;

	public static String insert = "";
	private static JLabel labelIMG;
	private JButton btnUpload;
	private JTextField tfLink;

//	private static mainboard mb = MainboardForm.getMainboardSellect();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CapNhatMainboard frame = new CapNhatMainboard();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
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
	public CapNhatMainboard() {
		setBackground(Color.DARK_GRAY);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 354);
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

		JLabel lblNewLabel_2 = new JLabel("CẬP NHẬT MAINBOARD");
		lblNewLabel_2.setForeground(new Color(249, 231, 159));
		lblNewLabel_2.setFont(SetFont.fontTitle());
		lblNewLabel_2.setBounds(12, 11, 267, 36);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("ID sản phẩm");
		lblNewLabel.setForeground(new Color(254, 254, 254));
		lblNewLabel.setFont(SetFont.font1_());
		lblNewLabel.setBounds(12, 59, 81, 30);
		contentPane.add(lblNewLabel);

		JLabel lblIdMainboard_1 = new JLabel("Tên main");
		lblIdMainboard_1.setForeground(new Color(254, 254, 254));
		lblIdMainboard_1.setFont(SetFont.font1_());
		lblIdMainboard_1.setBounds(268, 59, 81, 30);
		contentPane.add(lblIdMainboard_1);

		JLabel lblIdMainboard_1_1 = new JLabel("Hỗ trợ CPU");
		lblIdMainboard_1_1.setForeground(new Color(254, 254, 254));
		lblIdMainboard_1_1.setFont(SetFont.font1_());
		lblIdMainboard_1_1.setBounds(268, 112, 81, 30);
		contentPane.add(lblIdMainboard_1_1);

		JLabel lblIdMainboard_1_2 = new JLabel("Kích thước");
		lblIdMainboard_1_2.setForeground(new Color(254, 254, 254));
		lblIdMainboard_1_2.setFont(SetFont.font1_());
		lblIdMainboard_1_2.setBounds(268, 168, 81, 30);
		contentPane.add(lblIdMainboard_1_2);

		JLabel lblIdMainboard_1_1_1 = new JLabel("Bảo hành");
		lblIdMainboard_1_1_1.setForeground(new Color(254, 254, 254));
		lblIdMainboard_1_1_1.setFont(SetFont.font1_());
		lblIdMainboard_1_1_1.setBounds(268, 222, 81, 30);
		contentPane.add(lblIdMainboard_1_1_1);

		tfBaoHanh = new JTextField();
		tfBaoHanh.setFont(SetFont.fontDetails());
		tfBaoHanh.setColumns(10);
		tfBaoHanh.setBounds(359, 222, 141, 30);
		contentPane.add(tfBaoHanh);

		tfKichThuoc = new JTextField();
		tfKichThuoc.setFont(SetFont.fontDetails());
		tfKichThuoc.setColumns(10);
		tfKichThuoc.setBounds(359, 168, 141, 30);
		contentPane.add(tfKichThuoc);

		tfCPU = new JTextField();
		tfCPU.setFont(SetFont.fontDetails());
		tfCPU.setColumns(10);
		tfCPU.setBounds(359, 112, 141, 30);
		contentPane.add(tfCPU);

		tfTen = new JTextField();
		tfTen.setFont(SetFont.fontDetails());
		tfTen.setColumns(10);
		tfTen.setBounds(359, 59, 141, 30);
		contentPane.add(tfTen);

		tfHang = new JTextField();
		tfHang.setFont(SetFont.fontDetails());
		tfHang.setColumns(10);
		tfHang.setBounds(103, 112, 141, 30);
		contentPane.add(tfHang);

		JLabel t = new JLabel("Tên hãng");
		t.setForeground(new Color(254, 254, 254));
		t.setFont(SetFont.font1_());
		t.setBounds(12, 112, 81, 30);
		contentPane.add(t);

		JLabel lblIdMainboard_2_1 = new JLabel("Hỗ trợ RAM");
		lblIdMainboard_2_1.setForeground(new Color(254, 254, 254));
		lblIdMainboard_2_1.setFont(SetFont.font1_());
		lblIdMainboard_2_1.setBounds(12, 168, 81, 30);
		contentPane.add(lblIdMainboard_2_1);

		tfRAM = new JTextField();
		tfRAM.setFont(SetFont.fontDetails());
		tfRAM.setColumns(10);
		tfRAM.setBounds(103, 168, 141, 30);
		contentPane.add(tfRAM);

		tfGia = new JTextField();
		tfGia.setFont(SetFont.fontDetails());
		tfGia.setColumns(10);
		tfGia.setBounds(103, 222, 141, 30);
		contentPane.add(tfGia);

		JLabel lblIdMainboard_2_2 = new JLabel("Đơn giá");
		lblIdMainboard_2_2.setForeground(new Color(254, 254, 254));
		lblIdMainboard_2_2.setFont(SetFont.font1_());
		lblIdMainboard_2_2.setBounds(12, 222, 81, 30);
		contentPane.add(lblIdMainboard_2_2);

		JButton btnCpNht = new JButton("Cập nhật");
		btnCpNht.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String url = tfLink.getText();
				if (insert.length() > 0 && url.length() > 0)
					JOptionPane.showMessageDialog(null, "Chỉ chọn 1 trong 2 nguồn hình ảnh!");
				else {
					String idsp = comboBox.getSelectedItem().toString();
					String idMain = MainboardForm.getMainboardSellect().getIdMainboard();
					String ten = tfTen.getText();
					String hang = tfHang.getText();
					String cpu = tfCPU.getText();
					String ram = tfRAM.getText();
					String kichThuoc = tfKichThuoc.getText();
					double gia = Double.parseDouble(tfGia.getText());
					String baoHanh = tfBaoHanh.getText();

					mainboard m = new mainboard(idsp, idMain, ten, hang, cpu, ram, kichThuoc,
							MainboardForm.getMainboardSellect().getTonKho(), gia, baoHanh, null);

					if (insert.equals("") && url.equals("")) {
						int check = mainDAO.getInstance().updateNotIMG(m);
						insert = Checked.checkedUpdate(check, insert);
					} else {
						if (url.equals("")) {
							int check = mainDAO.getInstance().update(m);
							insert = Checked.checkedUpdate(check, insert);
						} else if (insert.equals("")) {
							int check = mainDAO.getInstance().updateIMGURL(m, url);
							insert = Checked.checkedUpdate(check, insert);
						}
					}
					MainboardForm.loadDataToTable(mainDAO.getInstance().selectAll());
					closeFrame();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				HoverButton.hoverOK(btnCpNht, true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				HoverButton.hoverOK(btnCpNht, false);
			}
		});
		btnCpNht.setFont(SetFont.font1());
		btnCpNht.setBorder(null);
		btnCpNht.setBounds(197, 279, 97, 30);
		contentPane.add(btnCpNht);

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
		btnCancel.setBounds(327, 279, 97, 30);
		contentPane.add(btnCancel);

		labelIMG = new JLabel("Ảnh mainboard");
		labelIMG.setHorizontalAlignment(SwingConstants.CENTER);
		labelIMG.setFont(SetFont.font());
		labelIMG.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelIMG.setBounds(510, 59, 223, 230);
		contentPane.add(labelIMG);

		btnUpload = new JButton("Upload");
		btnUpload.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insert = LoadIMGURL.loadIMGFromDirecory(labelIMG, insert);
			}
		});
		btnUpload.setFont(null);
		btnUpload.setBorder(null);
		btnUpload.setBounds(662, 300, 71, 21);
		contentPane.add(btnUpload);

		JLabel lblNewLabel_1 = new JLabel("© 2023 NGUYỄN QUỐC VIỆT - 23CE.B029");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(224, 255, 255));
		lblNewLabel_1.setFont(SetFont.font());
		lblNewLabel_1.setBounds(0, 332, 733, 14);
		contentPane.add(lblNewLabel_1);

		ArrayList<Products> list = SanPhamDAO.getIDSanPham("mainboard");
		int size = list.size();
		String[] combo = new String[size];
		for (int i = 0; i < size; i++) {
			combo[i] = list.get(i).getIdSanPham();
		}
		comboBox = new JComboBox<>(combo);
		comboBox.setBounds(103, 59, 141, 30);
		comboBox.setFont(SetFont.fontDetails());
		contentPane.add(comboBox);

		JLabel lblTnNgun_1_2_1 = new JLabel("Link hình ảnh:");
		lblTnNgun_1_2_1.setForeground(new Color(254, 254, 254));
		lblTnNgun_1_2_1.setFont(SetFont.font1_());
		lblTnNgun_1_2_1.setBounds(268, 26, 93, 21);
		contentPane.add(lblTnNgun_1_2_1);

		tfLink = new JTextField("");
		tfLink.setFont(SetFont.fontDetails());
		tfLink.setColumns(10);
		tfLink.setBounds(359, 26, 313, 20);
		contentPane.add(tfLink);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insert = LoadIMGURL.setIMG(tfLink, labelIMG, insert);
			}
		});
		btnNewButton.setBounds(682, 26, 51, 20);
		contentPane.add(btnNewButton);
	}

	private void closeFrame() {
		this.dispose();
	}

	public static String getInsert() {
		return insert;
	}

	public static void setInsert(String insert) {
		CapNhatMainboard.insert = insert;
	}

	private static void setDefaultText() {
		mainboard mb = MainboardForm.getMainboardSellect();
		comboBox.setSelectedItem(mb.getIdSanPham());
		tfTen.setText(mb.getTenMain());
		tfHang.setText(mb.getTenHang());
		tfCPU.setText(mb.getHoTroCPU());
		tfRAM.setText(mb.getHoTroRAM());
		tfKichThuoc.setText(mb.getKichThuoc());
		tfGia.setText(String.valueOf(mb.getDonGia()));
		tfBaoHanh.setText(mb.getBaoHanh());

		if (mb.getImg() == null) {
			labelIMG.setIcon(new ImageIcon(CapNhatMainboard.class.getResource("/icon/icons8-no-image-14.png")));
			labelIMG.setText("Sản phẩm hiện chưa có ảnh mẫu!");
		} else {
			Blob blob = mb.getImg();
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
}
