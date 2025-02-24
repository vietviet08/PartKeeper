package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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
import dao.hddDAO;
import font.SetFont;
import model.Products;
import model.hdd;

public class ThemHDD extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfTen;
	private static JTextField tfIDHDD;
	private JTextField tfHang;
	private JTextField tfDungLuong;
	private JTextField tfBoNhoDem;
	private JTextField tfTocDo;
	private JTextField tfBaoHanh;
	private JTextField tfGia;
	private JLabel labelIMG;
	private JComboBox<String> comboBox;
	private static String insert = "";
	private JTextField tfLink;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemHDD frame = new ThemHDD();
					setDefaultIDHDD(hddDAO.getInstance().selectAll());
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
	public ThemHDD() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 785, 397);
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

		JLabel lblNewLabel_2 = new JLabel("THÊM HDD");
		lblNewLabel_2.setForeground(new Color(249, 231, 159));
		lblNewLabel_2.setFont(SetFont.fontTitle());
		lblNewLabel_2.setBounds(10, 11, 267, 36);
		contentPane.add(lblNewLabel_2);

		labelIMG = new JLabel("Ảnh HDD");
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
		btnCancel.setBounds(440, 323, 97, 30);
		contentPane.add(btnCancel);

		JButton btnAdd = new JButton("Thêm");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String url = tfLink.getText();

				if (insert.length() > 0 && url.length() > 0)
					JOptionPane.showMessageDialog(null, "Chỉ chọn 1 trong 2 nguồn hình ảnh!");
				else {
					String idSP = comboBox.getSelectedItem().toString();
					String idHDD = tfIDHDD.getText();
					String ten = tfTen.getText().toUpperCase();
					String hang = tfHang.getText().toUpperCase();
					String dungLuong = tfDungLuong.getText().toUpperCase();
					String boNhoDem = tfBoNhoDem.getText().toUpperCase();
					String tocDoVongQuay = tfTocDo.getText().toUpperCase();
					double donGia = Double.parseDouble(tfGia.getText());
					String baoHanh = tfBaoHanh.getText();

					hdd hdd = new hdd(idSP, idHDD, ten, hang, dungLuong, boNhoDem, tocDoVongQuay, 0, donGia, baoHanh,
							null);

					if (insert.equals("") && url.equals("")) {
						int check = hddDAO.getInstance().insertNotIMG(hdd);
						insert = Checked.checkedAdd(check, insert);
					} else {
						if (url.equals("")) {
							int check = hddDAO.getInstance().insert(hdd);
							insert = Checked.checkedAdd(check, insert);
						} else if (insert.equals("")) {
							int check = hddDAO.getInstance().insertIMGURL(hdd, url);
							insert = Checked.checkedAdd(check, insert);
						}
					}

					HDDForm.loadDataToTable(hddDAO.getInstance().selectAll());
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
		btnAdd.setBounds(284, 323, 97, 30);
		contentPane.add(btnAdd);

		JLabel lblNewLabel_1 = new JLabel("© 2023 NGUYỄN QUỐC VIỆT - 23CE.B029");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(224, 255, 255));
		lblNewLabel_1.setFont(SetFont.font());
		lblNewLabel_1.setBounds(10, 369, 759, 14);
		contentPane.add(lblNewLabel_1);

		tfTen = new JTextField();
		tfTen.setFont(null);
		tfTen.setColumns(10);
		tfTen.setBounds(133, 119, 141, 30);
		contentPane.add(tfTen);

		JLabel lblTnHdd = new JLabel("Tên HDD");
		lblTnHdd.setForeground(new Color(254, 254, 254));
		lblTnHdd.setFont(SetFont.font1_());
		lblTnHdd.setBounds(21, 119, 71, 30);
		contentPane.add(lblTnHdd);

		ArrayList<Products> list = SanPhamDAO.getIDSanPham("hdd");
		int size = list.size();
		String combo[] = new String[size];
		for (int i = 0; i < size; i++) {
			combo[i] = list.get(i).getIdSanPham();
		}

		comboBox = new JComboBox<>(combo);
		comboBox.setBounds(133, 58, 141, 30);
		contentPane.add(comboBox);

		JLabel lblIdHdd = new JLabel("ID HDD");
		lblIdHdd.setForeground(new Color(254, 254, 254));
		lblIdHdd.setFont(SetFont.font1_());
		lblIdHdd.setBounds(284, 58, 71, 30);
		contentPane.add(lblIdHdd);

		tfIDHDD = new JTextField();
		tfIDHDD.setBackground(Color.WHITE);
		tfIDHDD.setEditable(false);
		tfIDHDD.setFont(null);
		tfIDHDD.setColumns(10);
		tfIDHDD.setBounds(396, 58, 141, 30);
		contentPane.add(tfIDHDD);

		JLabel lblHng_2 = new JLabel("Hãng");
		lblHng_2.setForeground(new Color(254, 254, 254));
		lblHng_2.setFont(SetFont.font1_());
		lblHng_2.setBounds(283, 119, 71, 30);
		contentPane.add(lblHng_2);

		tfHang = new JTextField();
		tfHang.setFont(null);
		tfHang.setColumns(10);
		tfHang.setBounds(395, 119, 141, 30);
		contentPane.add(tfHang);

		tfDungLuong = new JTextField();
		tfDungLuong.setFont(null);
		tfDungLuong.setColumns(10);
		tfDungLuong.setBounds(133, 188, 141, 30);
		contentPane.add(tfDungLuong);

		JLabel lblDungLng = new JLabel("Dung lượng");
		lblDungLng.setForeground(new Color(254, 254, 254));
		lblDungLng.setFont(SetFont.font1_());
		lblDungLng.setBounds(21, 188, 71, 30);
		contentPane.add(lblDungLng);

		JLabel lblHng_2_1 = new JLabel("Bộ nhớ đệm");
		lblHng_2_1.setForeground(new Color(254, 254, 254));
		lblHng_2_1.setFont(SetFont.font1_());
		lblHng_2_1.setBounds(283, 188, 112, 30);
		contentPane.add(lblHng_2_1);

		tfBoNhoDem = new JTextField();
		tfBoNhoDem.setFont(null);
		tfBoNhoDem.setColumns(10);
		tfBoNhoDem.setBounds(395, 188, 141, 30);
		contentPane.add(tfBoNhoDem);

		tfTocDo = new JTextField();
		tfTocDo.setFont(null);
		tfTocDo.setColumns(10);
		tfTocDo.setBounds(133, 258, 141, 30);
		contentPane.add(tfTocDo);

		JLabel lblTcQv = new JLabel("Tốc độ QV");
		lblTcQv.setForeground(new Color(254, 254, 254));
		lblTcQv.setFont(SetFont.font1_());
		lblTcQv.setBounds(21, 258, 112, 30);
		contentPane.add(lblTcQv);

		JLabel lblHng_2_2 = new JLabel("Bảo hành");
		lblHng_2_2.setForeground(new Color(254, 254, 254));
		lblHng_2_2.setFont(SetFont.font1_());
		lblHng_2_2.setBounds(283, 258, 71, 30);
		contentPane.add(lblHng_2_2);

		tfBaoHanh = new JTextField();
		tfBaoHanh.setFont(null);
		tfBaoHanh.setColumns(10);
		tfBaoHanh.setBounds(395, 258, 141, 30);
		contentPane.add(tfBaoHanh);

		JLabel lblHng_2_2_1 = new JLabel("Đơn giá");
		lblHng_2_2_1.setForeground(new Color(254, 254, 254));
		lblHng_2_2_1.setFont(SetFont.font1_());
		lblHng_2_2_1.setBounds(21, 323, 71, 30);
		contentPane.add(lblHng_2_2_1);

		tfGia = new JTextField();
		tfGia.setFont(null);
		tfGia.setColumns(10);
		tfGia.setBounds(133, 323, 141, 30);
		contentPane.add(tfGia);

		JLabel lblTnNgun_1_2_1 = new JLabel("Link hình ảnh:");
		lblTnNgun_1_2_1.setForeground(new Color(254, 254, 254));
		lblTnNgun_1_2_1.setFont(SetFont.font());
		lblTnNgun_1_2_1.setBounds(287, 11, 108, 21);
		contentPane.add(lblTnNgun_1_2_1);

		tfLink = new JTextField("");
		tfLink.setFont(SetFont.fontDetails());
		tfLink.setColumns(10);
		tfLink.setBounds(396, 11, 317, 20);
		contentPane.add(tfLink);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insert = LoadIMGURL.setIMG(tfLink, labelIMG, insert);
			}
		});
		btnNewButton.setBounds(717, 11, 52, 20);
		contentPane.add(btnNewButton);
	}

	public static String getInsert() {
		return insert;
	}

	public static void setInsert(String insert) {
		ThemHDD.insert = insert;
	}

	private void closeFrame() {
		this.dispose();
	}

	private static void setDefaultIDHDD(ArrayList<hdd> arr) {

		int id = arr.size() + 1;
		String check = "";
		for (hdd c : arr) {
			if (c.getIdhHdd().equals("hdd" + id)) {
				check = c.getIdhHdd();
			}
		}
		while (check.length() != 0) {
			String c = check;
			id++;
			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i).getIdhHdd().equals("hdd" + id)) {
					check = arr.get(i).getIdhHdd();
				}
			}
			if (check.equals(c)) {
				check = "";
			}
		}

		tfIDHDD.setText("hdd" + id);
	}
}
