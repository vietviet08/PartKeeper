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
import dao.caseDAO;
import font.SetFont;
import model.Case;
import model.Products;

public class ThemCase extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField tfIDcase;
	private JTextField tfTen;
	private JTextField tfHang;
	private JTextField tfChatLieu;
	private JTextField tfGia;
	private JTextField tfBaoHanh;
	private JComboBox<String> comboBox;
	private JLabel labelIMG;
	private JButton btnUpload;

	public static String insert = "";
	private JComboBox<String> comboBox_Loai;
	private JComboBox<String> comboBox_KichThuoc;
	private JTextField tfLink;
	private JLabel labelTenSP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemCase frame = new ThemCase();
					frame.setLocationRelativeTo(null);
					setDefaultIDCase(caseDAO.getInstance().selectAll());
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
	public ThemCase() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 783, 392);
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
		lblNewLabel.setBounds(21, 58, 112, 30);
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
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String src = comboBox.getSelectedItem().toString();
				labelTenSP.setText(SanPhamDAO.getInstance().selectById(src).getTenSanPham());
			}
		});
		contentPane.add(comboBox);

		JLabel lblIdCase = new JLabel("ID case");
		lblIdCase.setForeground(new Color(254, 254, 254));
		lblIdCase.setFont(SetFont.font1_());
		lblIdCase.setBounds(299, 58, 71, 30);
		contentPane.add(lblIdCase);

		tfIDcase = new JTextField();
		tfIDcase.setBackground(Color.WHITE);
		tfIDcase.setEditable(false);
		tfIDcase.setFont(SetFont.fontDetails());
		tfIDcase.setColumns(10);
		tfIDcase.setBounds(385, 58, 141, 30);
		contentPane.add(tfIDcase);

		JLabel lblTnCpu = new JLabel("Tên case");
		lblTnCpu.setForeground(new Color(254, 254, 254));
		lblTnCpu.setFont(SetFont.font1_());
		lblTnCpu.setBounds(21, 123, 71, 30);
		contentPane.add(lblTnCpu);

		tfTen = new JTextField();
		tfTen.setFont(SetFont.fontDetails());
		tfTen.setColumns(10);
		tfTen.setBounds(133, 123, 141, 30);
		contentPane.add(tfTen);

		JLabel lblNewLabel_1_1_1 = new JLabel("Chất liệu");
		lblNewLabel_1_1_1.setForeground(new Color(254, 254, 254));
		lblNewLabel_1_1_1.setFont(SetFont.font1_());
		lblNewLabel_1_1_1.setBounds(299, 193, 86, 30);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblHng = new JLabel("Hãng");
		lblHng.setForeground(new Color(254, 254, 254));
		lblHng.setFont(SetFont.font1_());
		lblHng.setBounds(299, 123, 71, 30);
		contentPane.add(lblHng);

		tfHang = new JTextField();
		tfHang.setFont(SetFont.fontDetails());
		tfHang.setColumns(10);
		tfHang.setBounds(385, 123, 141, 30);
		contentPane.add(tfHang);

		tfChatLieu = new JTextField();
		tfChatLieu.setFont(SetFont.fontDetails());
		tfChatLieu.setColumns(10);
		tfChatLieu.setBounds(385, 192, 141, 30);
		contentPane.add(tfChatLieu);

		labelIMG = new JLabel("Ảnh CASE");
		labelIMG.setHorizontalAlignment(SwingConstants.CENTER);
		labelIMG.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelIMG.setBounds(546, 58, 223, 230);
		contentPane.add(labelIMG);

		btnUpload = new JButton("Upload");
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
				addCase();
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
		btnAdd.setBounds(299, 320, 97, 30);
		contentPane.add(btnAdd);

		JButton btnCancel = new JButton("Hủy");
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
		btnCancel.setBounds(429, 320, 97, 30);
		contentPane.add(btnCancel);

		JLabel lblNewLabel_1 = new JLabel("© 2023 NGUYỄN QUỐC VIỆT - 23CE.B029");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(224, 255, 255));
		lblNewLabel_1.setFont(null);
		lblNewLabel_1.setBounds(10, 369, 759, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("THÊM CASE");
		lblNewLabel_2.setForeground(new Color(249, 231, 159));
		lblNewLabel_2.setFont(SetFont.fontTitle());
		lblNewLabel_2.setBounds(10, 11, 267, 36);
		contentPane.add(lblNewLabel_2);

		JLabel lblLoi = new JLabel("Loại");
		lblLoi.setForeground(new Color(254, 254, 254));
		lblLoi.setFont(SetFont.font1_());
		lblLoi.setBounds(21, 193, 71, 30);
		contentPane.add(lblLoi);

		JLabel lblTnCpu_1_1 = new JLabel("Kích thước mb");
		lblTnCpu_1_1.setForeground(new Color(254, 254, 254));
		lblTnCpu_1_1.setFont(SetFont.font1_());
		lblTnCpu_1_1.setBounds(21, 258, 112, 30);
		contentPane.add(lblTnCpu_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Giá");
		lblNewLabel_1_1_1_1.setForeground(new Color(254, 254, 254));
		lblNewLabel_1_1_1_1.setFont(SetFont.font1_());
		lblNewLabel_1_1_1_1.setBounds(299, 258, 71, 30);
		contentPane.add(lblNewLabel_1_1_1_1);

		tfGia = new JTextField();
		tfGia.setFont(SetFont.fontDetails());
		tfGia.setColumns(10);
		tfGia.setBounds(385, 257, 141, 30);
		contentPane.add(tfGia);

		JLabel lblTnCpu_1_1_1 = new JLabel("Bảo hành");
		lblTnCpu_1_1_1.setForeground(new Color(254, 254, 254));
		lblTnCpu_1_1_1.setFont(SetFont.font1_());
		lblTnCpu_1_1_1.setBounds(21, 320, 112, 30);
		contentPane.add(lblTnCpu_1_1_1);

		tfBaoHanh = new JTextField();
		tfBaoHanh.setFont(SetFont.fontDetails());
		tfBaoHanh.setColumns(10);
		tfBaoHanh.setBounds(133, 320, 141, 30);
		contentPane.add(tfBaoHanh);

		comboBox_Loai = new JComboBox<>(
				new String[] { "ULTRA TOWER", "FULL TOWER", "MID TOWER", "MINI TOWER", "SMALL FORM FACTOR", "HTPC" });
		comboBox_Loai.setFont(SetFont.fontDetails());
		comboBox_Loai.setBounds(133, 193, 141, 30);
		contentPane.add(comboBox_Loai);

		comboBox_KichThuoc = new JComboBox<>(new String[] { "E-ATX", "ATX", "M-ATX", "mini-ITX", "E-ATX / ATX",
				"ATX / M-ATX", "ATX / M-ATX / mini-ITX", "M-ATX / mini-ITX", "E-ATX / ATX / M-ATX / mini-ITX" });
		comboBox_KichThuoc.setFont(SetFont.fontDetails());
		comboBox_KichThuoc.setBounds(133, 258, 141, 30);
		contentPane.add(comboBox_KichThuoc);

		JLabel lblTnNgun_1_2_1 = new JLabel("Link hình ảnh:");
		lblTnNgun_1_2_1.setForeground(new Color(254, 254, 254));
		lblTnNgun_1_2_1.setFont(SetFont.font1_());
		lblTnNgun_1_2_1.setBounds(295, 20, 90, 21);
		contentPane.add(lblTnNgun_1_2_1);

		tfLink = new JTextField("");
		tfLink.setFont(SetFont.fontDetails());
		tfLink.setColumns(10);
		tfLink.setBounds(385, 20, 323, 20);
		contentPane.add(tfLink);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insert = LoadIMGURL.setIMG(tfLink, labelIMG, insert);
			}
		});
		btnNewButton.setBounds(718, 20, 51, 20);
		contentPane.add(btnNewButton);

		labelTenSP = new JLabel("");
		labelTenSP.setFont(SetFont.font());
		labelTenSP.setForeground(SetColor.whiteFont);
		labelTenSP.setBounds(133, 93, 141, 15);
		contentPane.add(labelTenSP);
	}

	private void closeFrame() {
		this.dispose();
	}

	public static String getInsert() {
		return insert;
	}

	public static void setInsert(String insert) {
		ThemCase.insert = insert;
	}

	private void addCase() {
		String idSP = comboBox.getSelectedItem().toString();
		String idCase = tfIDcase.getText();
		String ten = tfTen.getText();
		String hang = tfHang.getText();
		String loai = comboBox_Loai.getSelectedItem().toString();
		String chatLieu = tfChatLieu.getText();
		String kichThuoc = comboBox_KichThuoc.getSelectedItem().toString();
		double gia = Double.parseDouble(tfGia.getText());
		String baoHanh = tfBaoHanh.getText();

		String url = tfLink.getText();

		if (insert.length() > 0 && url.length() > 0)
			JOptionPane.showMessageDialog(null, "Chỉ chọn 1 trong 2 nguồn hình ảnh!");
		else {

			Case c = new Case(idSP, idCase, ten, hang, loai, chatLieu, kichThuoc, 0, gia, baoHanh, null);

			if (insert.equals("") && url.equals("")) {
				int check = caseDAO.getInstance().insertNotIMG(c);
				Checked.checkedAdd(check, insert);
			} else {
				if (url.equals("")) {
					int check = caseDAO.getInstance().insert(c);
					Checked.checkedAdd(check, insert);
				} else if (insert.equals("")) {
					int check = caseDAO.getInstance().insertIMGURL(c, url);
					Checked.checkedAdd(check, insert);
				}
			}
			CaseForm.loadDataToTable(caseDAO.getInstance().selectAll());
			closeFrame();
		}
	}

	private static void setDefaultIDCase(ArrayList<Case> arr) {

		int id = arr.size() + 1;
		String check = "";
		for (Case c : arr) {
			if (c.getIdCase().equals("case" + id)) {
				check = c.getIdCase();
			}
		}
		while (check.length() != 0) {
			String c = check;
			id++;
			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i).getIdCase().equals("case" + id)) {
					check = arr.get(i).getIdCase();
				}
			}
			if (check.equals(c)) {
				check = "";
			}
		}

		tfIDcase.setText("case" + id);
	}
}
