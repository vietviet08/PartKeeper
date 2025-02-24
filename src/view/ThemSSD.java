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

import controller.Checked;
import controller.LoadIMGURL;
import dao.SanPhamDAO;
import dao.ssdDAO;
import decor.HoverButton;
import font.SetFont;
import model.Products;
import model.ssd;

public class ThemSSD extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfTen;
	private JTextField tfTocDoDoc;
	private JTextField tfDungLuong;
	private JTextField tfHang;
	private static JTextField tfIDSSD;
	private JTextField tfTocDoGhi;
	private JTextField tfGia;
	private JTextField tfBaoHanh;
	private JLabel labelIMG;

	private static String insert = "";
	private JComboBox<String> comboBox_Loai;
	private JComboBox<String> comboBox_IDSP;

	private final String[] comboLoai = { "2.5'SATA", "M.2 SATA", "M.2 NVMe", "USB" };
	private JTextField tfLink;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemSSD frame = new ThemSSD();
					setDefaultIDSSD(ssdDAO.getInstance().selectAll());
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
	public ThemSSD() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 798, 447);
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

		JLabel lblTnSsd = new JLabel("Tên SSD");
		lblTnSsd.setForeground(new Color(254, 254, 254));
		lblTnSsd.setFont(SetFont.font1_());
		lblTnSsd.setBounds(21, 118, 115, 30);
		contentPane.add(lblTnSsd);

		tfTen = new JTextField();
		tfTen.setFont(null);
		tfTen.setColumns(10);
		tfTen.setBounds(136, 118, 141, 30);
		contentPane.add(tfTen);

		JLabel lblNewLabel_2 = new JLabel("THÊM SSD");
		lblNewLabel_2.setForeground(new Color(249, 231, 159));
		lblNewLabel_2.setFont(SetFont.fontTitle());
		lblNewLabel_2.setBounds(10, 11, 267, 36);
		contentPane.add(lblNewLabel_2);

		labelIMG = new JLabel("Ảnh SSD");
		labelIMG.setHorizontalAlignment(SwingConstants.CENTER);
		labelIMG.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelIMG.setBounds(565, 58, 223, 230);
		contentPane.add(labelIMG);

		JButton btnUpload = new JButton("Upload");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert = LoadIMGURL.loadIMGFromDirecory(labelIMG, insert);
			}
		});
		btnUpload.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnUpload.setFont(SetFont.font());
		btnUpload.setBorder(null);
		btnUpload.setBounds(717, 294, 71, 21);
		contentPane.add(btnUpload);

		JLabel lblNewLabel_1 = new JLabel("© 2023 NGUYỄN QUỐC VIỆT - 23CE.B029");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(224, 255, 255));
		lblNewLabel_1.setFont(null);
		lblNewLabel_1.setBounds(26, 422, 787, 14);
		contentPane.add(lblNewLabel_1);

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
				HoverButton.hoverCancel(btnCancel, true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				HoverButton.hoverCancel(btnCancel, false);
			}
		});
		btnCancel.setFont(SetFont.font1());
		btnCancel.setBorder(null);
		btnCancel.setBounds(362, 361, 97, 30);
		contentPane.add(btnCancel);

		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String url = tfLink.getText() + "";
				if (insert.length() > 0 && url.length() > 0) {
					JOptionPane.showMessageDialog(null, "Chỉ được chọn 1 trong 2 nguồn hình ảnh!");
				} else {

					String idsp = comboBox_IDSP.getSelectedItem().toString();
					String idssd = tfIDSSD.getText();
					String tenssd = tfTen.getText();
					String hang = tfHang.getText();
					String dungLuong = tfDungLuong.getText();
					String loai = comboBox_Loai.getSelectedItem().toString();
					String tocdodoc = tfTocDoDoc.getText();
					String tocdoghi = tfTocDoGhi.getText();
					double gia = Double.parseDouble(tfGia.getText());
					String baohanh = tfBaoHanh.getText();

					ssd ssd = new ssd(idsp, idssd, tenssd, hang, dungLuong, loai, tocdodoc, tocdoghi, 0, gia, baohanh,
							null);

					if (insert.equals("") && url.equals("")) {
						int check = ssdDAO.getInstance().insertNotIMG(ssd);
						insert = Checked.checkedAdd(check, insert);
					} else {
						if (url.equals("")) {
							int check = ssdDAO.getInstance().insert(ssd);
							insert = Checked.checkedAdd(check, insert);
						} else if (insert.equals("")) {
							int check = ssdDAO.getInstance().insertIMGURL(ssd, url);
							insert = Checked.checkedAdd(check, insert);
						}
					}
					SSDForm.loadDataToTable(ssdDAO.getInstance().selectAll());
					closeFrame();
				}
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
		btnAdd.setBounds(232, 361, 97, 30);
		contentPane.add(btnAdd);

		JLabel lblIdSnPhm = new JLabel("ID sản phẩm");
		lblIdSnPhm.setForeground(new Color(254, 254, 254));
		lblIdSnPhm.setFont(SetFont.font1_());
		lblIdSnPhm.setBounds(21, 58, 115, 30);
		contentPane.add(lblIdSnPhm);

		tfTocDoDoc = new JTextField();
		tfTocDoDoc.setFont(null);
		tfTocDoDoc.setColumns(10);
		tfTocDoDoc.setBounds(136, 237, 141, 30);
		contentPane.add(tfTocDoDoc);

		JLabel lblTcc = new JLabel("Tốc độ đọc");
		lblTcc.setForeground(new Color(254, 254, 254));
		lblTcc.setFont(SetFont.font1_());
		lblTcc.setBounds(21, 237, 115, 30);
		contentPane.add(lblTcc);

		JLabel lblTnNgun_1_1 = new JLabel("Dung lượng");
		lblTnNgun_1_1.setForeground(new Color(254, 254, 254));
		lblTnNgun_1_1.setFont(SetFont.font1_());
		lblTnNgun_1_1.setBounds(21, 177, 115, 30);
		contentPane.add(lblTnNgun_1_1);

		tfDungLuong = new JTextField();
		tfDungLuong.setFont(null);
		tfDungLuong.setColumns(10);
		tfDungLuong.setBounds(136, 177, 141, 30);
		contentPane.add(tfDungLuong);

		tfHang = new JTextField();
		tfHang.setFont(null);
		tfHang.setColumns(10);
		tfHang.setBounds(402, 118, 141, 30);
		contentPane.add(tfHang);

		JLabel lblHng = new JLabel("Hãng");
		lblHng.setForeground(new Color(254, 254, 254));
		lblHng.setFont(SetFont.font1_());
		lblHng.setBounds(287, 118, 71, 30);
		contentPane.add(lblHng);

		JLabel lblTnNgun_1_2 = new JLabel("ID SSD");
		lblTnNgun_1_2.setForeground(new Color(254, 254, 254));
		lblTnNgun_1_2.setFont(SetFont.font1_());
		lblTnNgun_1_2.setBounds(287, 58, 115, 30);
		contentPane.add(lblTnNgun_1_2);

		tfIDSSD = new JTextField();
		tfIDSSD.setBackground(Color.WHITE);
		tfIDSSD.setEditable(false);
		tfIDSSD.setFont(null);
		tfIDSSD.setColumns(10);
		tfIDSSD.setBounds(402, 58, 141, 30);
		contentPane.add(tfIDSSD);

		tfTocDoGhi = new JTextField();
		tfTocDoGhi.setFont(null);
		tfTocDoGhi.setColumns(10);
		tfTocDoGhi.setBounds(402, 237, 141, 30);
		contentPane.add(tfTocDoGhi);

		JLabel lblTcGhi = new JLabel("Tốc độ ghi");
		lblTcGhi.setForeground(new Color(254, 254, 254));
		lblTcGhi.setFont(SetFont.font1_());
		lblTcGhi.setBounds(287, 237, 115, 30);
		contentPane.add(lblTcGhi);

		JLabel lblTnNgun_1_3 = new JLabel("Loại");
		lblTnNgun_1_3.setForeground(new Color(254, 254, 254));
		lblTnNgun_1_3.setFont(SetFont.font1_());
		lblTnNgun_1_3.setBounds(287, 177, 71, 30);
		contentPane.add(lblTnNgun_1_3);

		tfGia = new JTextField();
		tfGia.setFont(null);
		tfGia.setColumns(10);
		tfGia.setBounds(136, 300, 141, 30);
		contentPane.add(tfGia);

		JLabel lblTnNgun_2_1 = new JLabel("Giá");
		lblTnNgun_2_1.setForeground(new Color(254, 254, 254));
		lblTnNgun_2_1.setFont(SetFont.font1_());
		lblTnNgun_2_1.setBounds(21, 300, 71, 30);
		contentPane.add(lblTnNgun_2_1);

		tfBaoHanh = new JTextField();
		tfBaoHanh.setFont(null);
		tfBaoHanh.setColumns(10);
		tfBaoHanh.setBounds(402, 300, 141, 30);
		contentPane.add(tfBaoHanh);

		JLabel lblTnNgun_2_2 = new JLabel("Bảo hành");
		lblTnNgun_2_2.setForeground(new Color(254, 254, 254));
		lblTnNgun_2_2.setFont(SetFont.font1_());
		lblTnNgun_2_2.setBounds(287, 300, 115, 30);
		contentPane.add(lblTnNgun_2_2);

		ArrayList<Products> list = SanPhamDAO.getIDSanPham("ssd");
		int size = list.size();
		String[] combo = new String[size];
		for (int i = 0; i < size; i++) {
			combo[i] = list.get(i).getIdSanPham();
		}
		comboBox_IDSP = new JComboBox<>(combo);
		comboBox_IDSP.setBounds(136, 58, 141, 30);
		contentPane.add(comboBox_IDSP);

		comboBox_Loai = new JComboBox<>(comboLoai);
		comboBox_Loai.setBounds(402, 181, 141, 30);
		contentPane.add(comboBox_Loai);

		tfLink = new JTextField("");
		tfLink.setFont(SetFont.fontDetails());
		tfLink.setBounds(402, 19, 330, 20);
		contentPane.add(tfLink);
		tfLink.setColumns(10);

		JLabel lblTnNgun_1_2_1 = new JLabel("Link hình ảnh:");
		lblTnNgun_1_2_1.setForeground(new Color(254, 254, 254));
		lblTnNgun_1_2_1.setFont(SetFont.font());
		lblTnNgun_1_2_1.setBounds(320, 20, 82, 21);
		contentPane.add(lblTnNgun_1_2_1);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insert = LoadIMGURL.setIMG(tfLink, labelIMG, insert);
			}
		});
		btnNewButton.setBounds(736, 19, 52, 20);
		contentPane.add(btnNewButton);
	}

	public static String getInsert() {
		return insert;
	}

	public static void setInsert(String insert) {
		ThemSSD.insert = insert;
	}

	private static void setDefaultIDSSD(ArrayList<ssd> arr) {
		int id = arr.size() + 1;
		String check = "";
		for (ssd c : arr) {
			if (c.getIdSdd().equals("ssd" + id)) {
				check = c.getIdSdd();
			}
		}
		while (check.length() != 0) {
			String c = check;
			id++;
			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i).getIdSdd().equals("ssd" + id)) {
					check = arr.get(i).getIdSdd();
				}
			}
			if (check.equals(c)) {
				check = "";
			}
		}

		tfIDSSD.setText("ssd" + id);
	}

	private void closeFrame() {
		this.dispose();
	}

}
