package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import dao.ssdDAO;
import decor.HoverButton;
import font.SetFont;
import model.Products;
import model.ssd;

public class CapNhatSSD extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField tfTenSSD;
	private static JTextField tfTocDoDoc;
	private static JTextField tfHang;
	private static JTextField tfDungLuong;
	private static JTextField tfGia;
	private static JTextField tfTocDoGhi;
	private static JTextField tfBaoHanh;
	private static JTextField tfLink;
	private static JComboBox<String> comboBox_IDSP;
	private static JComboBox<String> comboBox_Loai;

	private final String[] comboLoai = { "2.5'SATA", "M.2 SATA", "M.2 NVMe", "USB" };
	private static JLabel labelIMG;
	private static String insert = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CapNhatSSD frame = new CapNhatSSD();
					setDefaultText();
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
	public CapNhatSSD() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 808, 392);
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
		lblTnSsd.setBounds(292, 58, 110, 30);
		contentPane.add(lblTnSsd);

		tfTenSSD = new JTextField();
		tfTenSSD.setFont(SetFont.fontDetails());
		tfTenSSD.setColumns(10);
		tfTenSSD.setBounds(402, 58, 141, 30);
		contentPane.add(tfTenSSD);

		JLabel lblNewLabel_2 = new JLabel("CẬP NHẬT SSD");
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
		btnUpload.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insert = LoadIMGURL.loadIMGFromDirecory(labelIMG, insert);
			}
		});
		btnUpload.setFont(SetFont.font());
		btnUpload.setBorder(null);
		btnUpload.setBounds(717, 294, 71, 21);
		contentPane.add(btnUpload);

		JLabel lblNewLabel_1 = new JLabel("© 2023 NGUYỄN QUỐC VIỆT - 23CE.B029");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(224, 255, 255));
		lblNewLabel_1.setFont(SetFont.font());
		lblNewLabel_1.setBounds(26, 364, 787, 14);
		contentPane.add(lblNewLabel_1);

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
		btnCancel.setBounds(446, 299, 97, 30);
		contentPane.add(btnCancel);

		JButton btnAdd = new JButton("Cập nhật");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateSSD();
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
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setFont(SetFont.font1());
		btnAdd.setBorder(null);
		btnAdd.setBounds(292, 299, 97, 30);
		contentPane.add(btnAdd);

		JLabel lblIdSnPhm = new JLabel("ID sản phẩm");
		lblIdSnPhm.setForeground(new Color(254, 254, 254));
		lblIdSnPhm.setFont(SetFont.font1_());
		lblIdSnPhm.setBounds(26, 58, 115, 30);
		contentPane.add(lblIdSnPhm);

		tfTocDoDoc = new JTextField();
		tfTocDoDoc.setFont(SetFont.fontDetails());
		tfTocDoDoc.setColumns(10);
		tfTocDoDoc.setBounds(136, 177, 141, 30);
		contentPane.add(tfTocDoDoc);

		JLabel lblTcc = new JLabel("Tốc độ đọc");
		lblTcc.setForeground(new Color(254, 254, 254));
		lblTcc.setFont(SetFont.font1_());
		lblTcc.setBounds(26, 177, 110, 30);
		contentPane.add(lblTcc);

		JLabel lblTnNgun_1_1 = new JLabel("Hãng");
		lblTnNgun_1_1.setForeground(new Color(254, 254, 254));
		lblTnNgun_1_1.setFont(SetFont.font1_());
		lblTnNgun_1_1.setBounds(26, 118, 97, 30);
		contentPane.add(lblTnNgun_1_1);

		tfHang = new JTextField();
		tfHang.setFont(SetFont.fontDetails());
		tfHang.setColumns(10);
		tfHang.setBounds(136, 118, 141, 30);
		contentPane.add(tfHang);

		tfDungLuong = new JTextField();
		tfDungLuong.setFont(SetFont.fontDetails());
		tfDungLuong.setColumns(10);
		tfDungLuong.setBounds(402, 118, 141, 30);
		contentPane.add(tfDungLuong);

		JLabel lblHng = new JLabel("Dung lượng");
		lblHng.setForeground(new Color(254, 254, 254));
		lblHng.setFont(SetFont.font1_());
		lblHng.setBounds(292, 118, 71, 30);
		contentPane.add(lblHng);

		tfGia = new JTextField();
		tfGia.setFont(SetFont.fontDetails());
		tfGia.setColumns(10);
		tfGia.setBounds(402, 237, 141, 30);
		contentPane.add(tfGia);

		JLabel lblTcGhi = new JLabel("Giá");
		lblTcGhi.setForeground(new Color(254, 254, 254));
		lblTcGhi.setFont(SetFont.font1_());
		lblTcGhi.setBounds(292, 237, 110, 30);
		contentPane.add(lblTcGhi);

		JLabel lblTnNgun_1_3 = new JLabel("Loại");
		lblTnNgun_1_3.setForeground(new Color(254, 254, 254));
		lblTnNgun_1_3.setFont(SetFont.font1_());
		lblTnNgun_1_3.setBounds(292, 177, 71, 30);
		contentPane.add(lblTnNgun_1_3);

		tfTocDoGhi = new JTextField();
		tfTocDoGhi.setFont(SetFont.fontDetails());
		tfTocDoGhi.setColumns(10);
		tfTocDoGhi.setBounds(136, 237, 141, 30);
		contentPane.add(tfTocDoGhi);

		JLabel lblTnNgun_2_1 = new JLabel("Tốc độ ghi");
		lblTnNgun_2_1.setForeground(new Color(254, 254, 254));
		lblTnNgun_2_1.setFont(SetFont.font1_());
		lblTnNgun_2_1.setBounds(26, 237, 97, 30);
		contentPane.add(lblTnNgun_2_1);

		tfBaoHanh = new JTextField();
		tfBaoHanh.setFont(SetFont.fontDetails());
		tfBaoHanh.setColumns(10);
		tfBaoHanh.setBounds(136, 299, 141, 30);
		contentPane.add(tfBaoHanh);

		JLabel lblTnNgun_2_2 = new JLabel("Bảo hành");
		lblTnNgun_2_2.setForeground(new Color(254, 254, 254));
		lblTnNgun_2_2.setFont(SetFont.font1_());
		lblTnNgun_2_2.setBounds(26, 299, 115, 30);
		contentPane.add(lblTnNgun_2_2);

		tfLink = new JTextField("");
		tfLink.setFont(SetFont.fontDetails());
		tfLink.setColumns(10);
		tfLink.setBounds(402, 19, 330, 20);
		contentPane.add(tfLink);

		JLabel lblTnNgun_1_2_1 = new JLabel("Link hình ảnh:");
		lblTnNgun_1_2_1.setForeground(new Color(254, 254, 254));
		lblTnNgun_1_2_1.setFont(SetFont.font1_());
		lblTnNgun_1_2_1.setBounds(292, 19, 110, 21);
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

		comboBox_Loai = new JComboBox<>(comboLoai);
		comboBox_Loai.setFont(SetFont.fontDetails());
		comboBox_Loai.setBounds(402, 177, 141, 30);
		contentPane.add(comboBox_Loai);

		ArrayList<Products> list = SanPhamDAO.getIDSanPham("ssd");
		int size = list.size();
		String[] combo = new String[size];
		for (int i = 0; i < size; i++) {
			combo[i] = list.get(i).getIdSanPham();
		}

		comboBox_IDSP = new JComboBox<>(combo);
		comboBox_IDSP.setFont(SetFont.fontDetails());
		comboBox_IDSP.setBounds(136, 58, 141, 30);
		contentPane.add(comboBox_IDSP);
	}

	private static ssd getSSDSelect() {
		return SSDForm.getSsdSelect();
	}

	public static String getInsert() {
		return insert;
	}

	public static void setInsert(String insert) {
		CapNhatSSD.insert = insert;
	}

	private static void setDefaultText() {
		ssd ssd = getSSDSelect();
		comboBox_IDSP.setSelectedItem(ssd.getIdSanPham());
		tfTenSSD.setText(ssd.getTenSsd());
		tfHang.setText(ssd.getHang());
		tfDungLuong.setText(ssd.getDungLuong());
		tfTocDoDoc.setText(ssd.getTocDoDoc());
		tfTocDoGhi.setText(ssd.getTocDoGhi());
		comboBox_Loai.setSelectedItem(ssd.getLoai());
		tfGia.setText(String.valueOf(ssd.getGia()));
		tfBaoHanh.setText(ssd.getBaoHanh());

		if (ssd.getImg() == null) {
			labelIMG.setText("Sản phẩm hiện chưa có ảnh mẫu!");
			labelIMG.setIcon(new ImageIcon(CapNhatSSD.class.getResource("/icon/icons8-no-image-14.png")));

		} else {
			Blob blob = ssd.getImg();
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

	private void updateSSD() {
		ssd ssd = getSSDSelect();

		String url = tfLink.getText();

		if (insert.length() > 0 && url.length() > 0)
			JOptionPane.showMessageDialog(null, "Chỉ chọn 1 trong 2 nguồn hình ảnh");
		else {

			String idsp = comboBox_IDSP.getSelectedItem().toString();
			String ten = tfTenSSD.getText();
			String hang = tfHang.getText();
			String dungluong = tfDungLuong.getText();
			String tocdodoc = tfTocDoDoc.getText();
			String tocdoghi = tfTocDoGhi.getText();
			String loai = comboBox_Loai.getSelectedItem().toString();
			double gia = Double.parseDouble(tfGia.getText());
			String baohanh = tfBaoHanh.getText();

			ssd newssd = new ssd(idsp, ssd.getIdSdd(), ten, hang, dungluong, loai, tocdodoc, tocdoghi, ssd.getTonKho(),
					gia, baohanh, null);

			if (insert.equals("") && url.equals("")) {
				int check = ssdDAO.getInstance().updateNotIMG(newssd);
				insert = Checked.checkedUpdate(check, insert);
			} else {
				if (url.equals("")) {
					int check = ssdDAO.getInstance().update(newssd);
					insert = Checked.checkedUpdate(check, insert);
				} else if (insert.equals("")) {
					int check = ssdDAO.getInstance().updateIMGURL(newssd, url);
					insert = Checked.checkedUpdate(check, insert);
				}

			}

			SSDForm.loadDataToTable(ssdDAO.getInstance().selectAll());
		}
	}

	private void closeFrame() {
		this.dispose();
	}

}
