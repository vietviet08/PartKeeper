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
import java.io.File;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.Checked;
import controller.LoadIMGURL;
import dao.SanPhamDAO;
import dao.caseDAO;
import decor.HoverButton;
import font.SetFont;
import model.Case;
import model.Products;

public class CapNhatCase extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField tfTen;
	private static JTextField tfHang;
	private static JTextField tfChatLieu;
	private static JTextField tfGia;
	private static JTextField tfBaoHanh;
	private static JLabel labelIMG;
	private static JButton btnUpload;

	public static String insert = "";
	private static JComboBox<String> comboBox;
	private static JComboBox<String> comboBox_Loai;
	private static JComboBox<String> comboBox_KichThuoc;
	private JTextField tfLink;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CapNhatCase frame = new CapNhatCase();
					frame.setLocationRelativeTo(null);
					setDefaultText();
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
	public CapNhatCase() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 792, 395);
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
		lblNewLabel.setBounds(21, 58, 81, 30);
		contentPane.add(lblNewLabel);

		ArrayList<Products> list = SanPhamDAO.getIDSanPham("case");
		int size = list.size();
		String[] combo = new String[size];
		for (int i = 0; i < size; i++) {
			combo[i] = list.get(i).getIdSanPham();
		}

		comboBox = new JComboBox<String>(combo);
		comboBox.setFont(SetFont.fontDetails());
		comboBox.setBounds(133, 58, 141, 30);
		contentPane.add(comboBox);

		JLabel lblTnCpu = new JLabel("Tên case");
		lblTnCpu.setForeground(new Color(254, 254, 254));
		lblTnCpu.setFont(SetFont.font1_());
		lblTnCpu.setBounds(299, 58, 71, 30);
		contentPane.add(lblTnCpu);

		tfTen = new JTextField();
		tfTen.setFont(SetFont.fontDetails());
		tfTen.setColumns(10);
		tfTen.setBounds(380, 58, 141, 30);
		contentPane.add(tfTen);

		JLabel lblNewLabel_1_1_1 = new JLabel("Chất liệu");
		lblNewLabel_1_1_1.setForeground(new Color(254, 254, 254));
		lblNewLabel_1_1_1.setFont(SetFont.font1_());
		lblNewLabel_1_1_1.setBounds(299, 184, 102, 30);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblHng = new JLabel("Hãng");
		lblHng.setForeground(new Color(254, 254, 254));
		lblHng.setFont(SetFont.font1_());
		lblHng.setBounds(21, 119, 71, 30);
		contentPane.add(lblHng);

		tfHang = new JTextField();
		tfHang.setFont(SetFont.fontDetails());
		tfHang.setColumns(10);
		tfHang.setBounds(133, 119, 141, 30);
		contentPane.add(tfHang);

		tfChatLieu = new JTextField();
		tfChatLieu.setFont(SetFont.fontDetails());
		tfChatLieu.setColumns(10);
		tfChatLieu.setBounds(380, 184, 141, 30);
		contentPane.add(tfChatLieu);

		labelIMG = new JLabel("Ảnh CPU");
		labelIMG.setHorizontalAlignment(SwingConstants.CENTER);
		labelIMG.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelIMG.setBounds(546, 58, 223, 230);
		contentPane.add(labelIMG);

		btnUpload = new JButton("Upload");
		btnUpload.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
				fileChooser.addChoosableFileFilter(
						new FileNameExtensionFilter("*.IMAGE", "webp", "jpg", "jpeg", "gif", "png"));
				int result = fileChooser.showSaveDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectFile = fileChooser.getSelectedFile();
					ImageIcon ii = new ImageIcon(selectFile.getAbsolutePath());
					Image i = ii.getImage();
					i = i.getScaledInstance(labelIMG.getWidth(), labelIMG.getHeight(), Image.SCALE_SMOOTH);
					labelIMG.setText("");
					labelIMG.setIcon(new ImageIcon(i));
					insert = selectFile.getAbsolutePath();
				} else
					JOptionPane.showMessageDialog(null, "Lỗi file!");
			}
		});
		btnUpload.setFont(null);
		btnUpload.setBorder(null);
		btnUpload.setBounds(698, 300, 71, 21);
		contentPane.add(btnUpload);

		JButton btnCpNht = new JButton("Cập nhật");
		btnCpNht.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String url = tfLink.getText();
				if (insert.length() > 0 && url.length() > 0)
					JOptionPane.showMessageDialog(null, "Chỉ chọn 1 trong 2 nguồn hình ảnh");
				else {

					Case old = CaseForm.getSelectCase();

					String idsp = comboBox.getSelectedItem().toString();
					String idCase = old.getIdCase();
					String ten = tfTen.getText();
					String hang = tfHang.getText();
					String loai = comboBox_Loai.getSelectedItem().toString();
					String chatLieu = tfChatLieu.getText();
					String kichThuoc = comboBox_KichThuoc.getSelectedItem().toString();
					double gia = Double.parseDouble(tfGia.getText());
					String baoHanh = tfBaoHanh.getText();

					Case c = new Case(idsp, idCase, ten, hang, loai, chatLieu, kichThuoc, old.getTonKho(), gia, baoHanh,
							null);

					if (insert.equals("") && url.equals("")) {
						int check = caseDAO.getInstance().updateNotIMG(c);
						insert = Checked.checkedUpdate(check, insert);
					} else {
						if (url.equals("")) {
							int check = caseDAO.getInstance().update(c);
							insert = Checked.checkedUpdate(check, insert);
						} else if (insert.equals("")) {
							int check = caseDAO.getInstance().updateIMGURL(c, url);
							insert = Checked.checkedUpdate(check, insert);
						}
					}
					CaseForm.loadDataToTable(caseDAO.getInstance().selectAll());
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
		btnCpNht.setBounds(205, 314, 97, 30);
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
		btnCancel.setBounds(335, 314, 97, 30);
		contentPane.add(btnCancel);

		JLabel lblNewLabel_1 = new JLabel("© 2023 NGUYỄN QUỐC VIỆT - 23CE.B029");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(224, 255, 255));
		lblNewLabel_1.setFont(null);
		lblNewLabel_1.setBounds(10, 369, 759, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("CẬP NHẬT CASE");
		lblNewLabel_2.setForeground(new Color(249, 231, 159));
		lblNewLabel_2.setFont(SetFont.fontTitle());
		lblNewLabel_2.setBounds(10, 11, 267, 36);
		contentPane.add(lblNewLabel_2);

		JLabel lblLoi = new JLabel("Loại");
		lblLoi.setForeground(new Color(254, 254, 254));
		lblLoi.setFont(SetFont.font1_());
		lblLoi.setBounds(299, 119, 71, 30);
		contentPane.add(lblLoi);

		JLabel lblTnCpu_1_1 = new JLabel("Kích thước mb");
		lblTnCpu_1_1.setForeground(new Color(254, 254, 254));
		lblTnCpu_1_1.setFont(SetFont.font1_());
		lblTnCpu_1_1.setBounds(21, 184, 112, 30);
		contentPane.add(lblTnCpu_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Giá");
		lblNewLabel_1_1_1_1.setForeground(new Color(254, 254, 254));
		lblNewLabel_1_1_1_1.setFont(SetFont.font1_());
		lblNewLabel_1_1_1_1.setBounds(21, 250, 71, 30);
		contentPane.add(lblNewLabel_1_1_1_1);

		tfGia = new JTextField();
		tfGia.setFont(SetFont.fontDetails());
		tfGia.setColumns(10);
		tfGia.setBounds(133, 250, 141, 30);
		contentPane.add(tfGia);

		JLabel lblTnCpu_1_1_1 = new JLabel("Bảo hành");
		lblTnCpu_1_1_1.setForeground(new Color(254, 254, 254));
		lblTnCpu_1_1_1.setFont(SetFont.font1_());
		lblTnCpu_1_1_1.setBounds(299, 250, 71, 30);
		contentPane.add(lblTnCpu_1_1_1);

		tfBaoHanh = new JTextField();
		tfBaoHanh.setFont(SetFont.fontDetails());
		tfBaoHanh.setColumns(10);
		tfBaoHanh.setBounds(380, 250, 141, 30);
		contentPane.add(tfBaoHanh);

		comboBox_Loai = new JComboBox<>(
				new String[] { "ULTRA TOWER", "FULL TOWER", "MID TOWER", "MINI TOWER", "SMALL FORM FACTOR", "HTPC" });
		comboBox_Loai.setBounds(380, 119, 141, 30);
		comboBox_Loai.setFont(SetFont.fontDetails());
		contentPane.add(comboBox_Loai);

		comboBox_KichThuoc = new JComboBox<>(new String[] { "E-ATX", "ATX", "M-ATX", "mini-ITX", "E-ATX / ATX",
				"ATX / M-ATX", "ATX / M-ATX / mini-ITX", "M-ATX / mini-ITX", "E-ATX / ATX / M-ATX / mini-ITX" });
		comboBox_KichThuoc.setFont(SetFont.fontDetails());
		comboBox_KichThuoc.setBounds(133, 188, 141, 30);
		contentPane.add(comboBox_KichThuoc);

		tfLink = new JTextField("");
		tfLink.setFont(SetFont.fontDetails());
		tfLink.setColumns(10);
		tfLink.setBounds(380, 11, 328, 20);
		contentPane.add(tfLink);

		JLabel lblTnNgun_1_2_1 = new JLabel("Link hình ảnh:");
		lblTnNgun_1_2_1.setForeground(new Color(254, 254, 254));
		lblTnNgun_1_2_1.setFont(SetFont.font1_());
		lblTnNgun_1_2_1.setBounds(295, 11, 90, 21);
		contentPane.add(lblTnNgun_1_2_1);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insert = LoadIMGURL.setIMG(tfLink, labelIMG, insert);
			}
		});
		btnNewButton.setBounds(718, 11, 51, 20);
		contentPane.add(btnNewButton);
	}

	public static String getInsert() {
		return insert;
	}

	public static void setInsert(String insert) {
		CapNhatCase.insert = insert;
	}

	private void closeFrame() {
		this.dispose();
	}

	public static void setDefaultText() {
		Case c = CaseForm.getSelectCase();
		comboBox.setSelectedItem(c.getIdSanPham());
		tfTen.setText(c.getTenCase());
		tfHang.setText(c.getHangCase());
		tfChatLieu.setText(c.getChatLieu());
		comboBox_KichThuoc.setSelectedItem(c.getKichThuocMainboard());
		comboBox_Loai.setSelectedItem(c.getLoaiCase());
		tfGia.setText(String.valueOf(c.getGia()));
		tfBaoHanh.setText(c.getBaoHanh());

		if (c.getImg() == null) {
			labelIMG.setIcon(new ImageIcon(CapNhatCase.class.getResource("/icon/icons8-no-image-14.png")));
			labelIMG.setText("Hiện sản phẩm chưa có ảnh mẫu");
		} else {
			Blob blob = c.getImg();
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
