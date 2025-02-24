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
import dao.mainDAO;
import font.SetFont;
import model.Products;
import model.mainboard;

public class ThemMainboard extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField tfIDMainboard;
	private static JTextField tfTen;
	private static JTextField tfTenHang;
	private static JTextField tfHoTroRam;
	private static JTextField tfHoTroCpu;
	private static JTextField tfBaoHanh;
	private static JTextField tfKichThuoc;
	private static JTextField tfDonGia;

	public static String insert = "";
	private JComboBox<String> comboBox;
	private JTextField tfLink;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemMainboard frame = new ThemMainboard();
					frame.setLocationRelativeTo(null);
					setDefaultIDMainboard(mainDAO.getInstance().selectAll());
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
	public ThemMainboard() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 757, 379);
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
		lblNewLabel.setBounds(20, 59, 81, 30);
		contentPane.add(lblNewLabel);

		ArrayList<Products> list = SanPhamDAO.getIDSanPham("mainboard");
		int size = list.size();
		String[] combo = new String[size];
		for (int i = 0; i < size; i++)
			combo[i] = list.get(i).getIdSanPham();

		comboBox = new JComboBox<String>(combo);
		comboBox.setFont(SetFont.fontDetails());
		comboBox.setBounds(111, 59, 141, 30);
		contentPane.add(comboBox);

		tfIDMainboard = new JTextField();
		tfIDMainboard.setBackground(Color.WHITE);
		tfIDMainboard.setEditable(false);
		tfIDMainboard.setFont(SetFont.fontDetails());
		tfIDMainboard.setColumns(10);
		tfIDMainboard.setBounds(367, 59, 141, 30);
		contentPane.add(tfIDMainboard);

		JLabel labelIMG = new JLabel("Ảnh mainboard");
		labelIMG.setFont(SetFont.font());
		labelIMG.setHorizontalAlignment(SwingConstants.CENTER);
		labelIMG.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelIMG.setBounds(518, 59, 223, 230);
		contentPane.add(labelIMG);

		JButton btnAdd = new JButton("Thêm");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addMainboard();
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
		btnAdd.setFont(SetFont.font1_());
		btnAdd.setBorder(null);
		btnAdd.setBounds(281, 281, 97, 30);
		contentPane.add(btnAdd);

		JButton btnCancel = new JButton("Hủy");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closeFram();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnCancel.setForeground(SetColor.whiteFont);
				btnCancel.setBackground(SetColor.redB);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCancel.setForeground(Color.black);
				btnCancel.setBackground(Color.white);
			}
		});
		btnCancel.setFont(SetFont.font1_());
		btnCancel.setBorder(null);
		btnCancel.setBounds(411, 281, 97, 30);
		contentPane.add(btnCancel);

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
		btnUpload.setBounds(670, 300, 71, 21);
		contentPane.add(btnUpload);

		JLabel lblNewLabel_1 = new JLabel("© 2023 NGUYỄN QUỐC VIỆT - 23CE.B029");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(224, 255, 255));
		lblNewLabel_1.setFont(SetFont.font());
		lblNewLabel_1.setBounds(8, 347, 733, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("THÊM MAINBOARD");
		lblNewLabel_2.setForeground(new Color(249, 231, 159));
		lblNewLabel_2.setFont(SetFont.fontTitle());
		lblNewLabel_2.setBounds(20, 11, 267, 36);
		contentPane.add(lblNewLabel_2);

		JLabel lblIdMainboard = new JLabel("ID mainboard");
		lblIdMainboard.setForeground(new Color(254, 254, 254));
		lblIdMainboard.setFont(SetFont.font1_());
		lblIdMainboard.setBounds(276, 59, 81, 30);
		contentPane.add(lblIdMainboard);

		JLabel lblIdMainboard_1 = new JLabel("Tên mainboard");
		lblIdMainboard_1.setForeground(new Color(254, 254, 254));
		lblIdMainboard_1.setFont(SetFont.font1_());
		lblIdMainboard_1.setBounds(20, 112, 81, 30);
		contentPane.add(lblIdMainboard_1);

		tfTen = new JTextField();
		tfTen.setFont(SetFont.fontDetails());
		tfTen.setColumns(10);
		tfTen.setBounds(111, 112, 141, 30);
		contentPane.add(tfTen);

		tfTenHang = new JTextField();
		tfTenHang.setFont(SetFont.fontDetails());
		tfTenHang.setColumns(10);
		tfTenHang.setBounds(367, 112, 141, 30);
		contentPane.add(tfTenHang);

		JLabel t = new JLabel("Tên hãng");
		t.setForeground(new Color(254, 254, 254));
		t.setFont(SetFont.font1_());
		t.setBounds(276, 112, 81, 30);
		contentPane.add(t);

		tfHoTroRam = new JTextField();
		tfHoTroRam.setFont(SetFont.fontDetails());
		tfHoTroRam.setColumns(10);
		tfHoTroRam.setBounds(367, 166, 141, 30);
		contentPane.add(tfHoTroRam);

		JLabel lblIdMainboard_2_1 = new JLabel("Hỗ trợ RAM");
		lblIdMainboard_2_1.setForeground(new Color(254, 254, 254));
		lblIdMainboard_2_1.setFont(SetFont.font1_());
		lblIdMainboard_2_1.setBounds(276, 166, 81, 30);
		contentPane.add(lblIdMainboard_2_1);

		tfHoTroCpu = new JTextField();
		tfHoTroCpu.setFont(SetFont.fontDetails());
		tfHoTroCpu.setColumns(10);
		tfHoTroCpu.setBounds(111, 166, 141, 30);
		contentPane.add(tfHoTroCpu);

		JLabel lblIdMainboard_1_1 = new JLabel("Hỗ trợ CPU");
		lblIdMainboard_1_1.setForeground(new Color(254, 254, 254));
		lblIdMainboard_1_1.setFont(SetFont.font1_());
		lblIdMainboard_1_1.setBounds(20, 166, 81, 30);
		contentPane.add(lblIdMainboard_1_1);

		tfBaoHanh = new JTextField();
		tfBaoHanh.setFont(SetFont.fontDetails());
		tfBaoHanh.setColumns(10);
		tfBaoHanh.setBounds(111, 281, 141, 30);
		contentPane.add(tfBaoHanh);

		JLabel lblIdMainboard_1_1_1 = new JLabel("Bảo hành");
		lblIdMainboard_1_1_1.setForeground(new Color(254, 254, 254));
		lblIdMainboard_1_1_1.setFont(SetFont.font1_());
		lblIdMainboard_1_1_1.setBounds(20, 281, 81, 30);
		contentPane.add(lblIdMainboard_1_1_1);

		JLabel lblIdMainboard_1_2 = new JLabel("Kích thước");
		lblIdMainboard_1_2.setForeground(new Color(254, 254, 254));
		lblIdMainboard_1_2.setFont(SetFont.font1_());
		lblIdMainboard_1_2.setBounds(20, 222, 81, 30);
		contentPane.add(lblIdMainboard_1_2);

		tfKichThuoc = new JTextField();
		tfKichThuoc.setFont(SetFont.fontDetails());
		tfKichThuoc.setColumns(10);
		tfKichThuoc.setBounds(111, 222, 141, 30);
		contentPane.add(tfKichThuoc);

		JLabel lblIdMainboard_2_2 = new JLabel("Đơn giá");
		lblIdMainboard_2_2.setForeground(new Color(254, 254, 254));
		lblIdMainboard_2_2.setFont(SetFont.font1_());
		lblIdMainboard_2_2.setBounds(276, 222, 81, 30);
		contentPane.add(lblIdMainboard_2_2);

		tfDonGia = new JTextField();
		tfDonGia.setFont(SetFont.fontDetails());
		tfDonGia.setColumns(10);
		tfDonGia.setBounds(367, 222, 141, 30);
		contentPane.add(tfDonGia);

		JLabel lblTnNgun_1_2_1 = new JLabel("Link hình ảnh:");
		lblTnNgun_1_2_1.setForeground(new Color(254, 254, 254));
		lblTnNgun_1_2_1.setFont(SetFont.font1_());
		lblTnNgun_1_2_1.setBounds(276, 11, 91, 21);
		contentPane.add(lblTnNgun_1_2_1);

		tfLink = new JTextField("");
		tfLink.setFont(SetFont.fontDetails());
		tfLink.setColumns(10);
		tfLink.setBounds(367, 11, 313, 20);
		contentPane.add(tfLink);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insert = LoadIMGURL.setIMG(tfLink, labelIMG, insert);
			}
		});
		btnNewButton.setBounds(690, 11, 51, 20);
		contentPane.add(btnNewButton);
	}

	private void closeFram() {
		this.dispose();
	}

	private static void setDefaultIDMainboard(ArrayList<mainboard> arr) {
		int id = arr.size() + 1;
		String check = "";
		for (mainboard mainboard : arr) {
			if (mainboard.getIdMainboard().equals("mba" + id)) {
				check = mainboard.getIdMainboard();
			}
		}
		while (check.length() != 0) {
			String c = check;
			id++;
			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i).getIdMainboard().equals("mba" + id)) {
					check = arr.get(i).getIdMainboard();
				}
			}
			if (check.equals(c)) {
				check = "";
			}
		}
//		int code = 1;
//		for (cpu cpu : arr) {
//			int id = Integer.parseInt(cpu.getIdCpu().substring(3, cpu.getIdCpu().length()));
//			if (code != id) {
//				tfIDCPU.setText("cpu" + code);
//				return;
//			}
//			code++;
//		}
//		tfIDCPU.setText("cpu" + Math.addExact(arr.size(), 1));
		tfIDMainboard.setText("mba" + id);
	}

	private void addMainboard() {
		String idSP = comboBox.getSelectedItem().toString();
		String idMainboard = tfIDMainboard.getText();
		String ten = tfTen.getText();
		String tenHang = tfTenHang.getText();
		String hoTroCPU = tfHoTroCpu.getText();
		String hoTroRAM = tfHoTroRam.getText();
		String kichThuoc = tfKichThuoc.getText();
		double donGia = Double.parseDouble(tfDonGia.getText());
		String baoHanh = tfBaoHanh.getText();

		String url = tfLink.getText();
		if (insert.length() > 0 && url.length() > 0)
			JOptionPane.showMessageDialog(null, "Chỉ chọn 1 trong 2 nguồn hình ảnh!");
		else {
			mainboard mb = new mainboard(idSP, idMainboard, ten, tenHang, hoTroCPU, hoTroRAM, kichThuoc, 0, donGia,
					baoHanh, null);

			if (insert.equals("") && url.equals("")) {
				int check = mainDAO.getInstance().insertNotIMG(mb);
				insert = Checked.checkedAdd(check, insert);
			} else {
				if (url.equals("")) {
					int check = mainDAO.getInstance().insert(mb);
					insert = Checked.checkedAdd(check, insert);
				} else if (insert.equals("")) {
					int check = mainDAO.getInstance().insertIMGURL(mb, url);
					insert = Checked.checkedAdd(check, insert);
				}
			}
			MainboardForm.loadDataToTable(mainDAO.getInstance().selectAll());
			closeFram();
		}
	}

	public static String getInsert() {
		return insert;
	}

	public static void setInsert(String insert) {
		ThemMainboard.insert = insert;
	}

}
