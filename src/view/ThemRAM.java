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

import javax.swing.DefaultComboBoxModel;
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
import dao.ramDAO;
import decor.HoverButton;
import font.SetFont;
import model.Products;
import model.ram;

public class ThemRAM extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfTen;
	private JTextField tfDungLuong;
	private JTextField tfBus;
	private JTextField tfGia;
	private JComboBox<String> comboBox;
	private static JTextField tfIDRAM;
	private JTextField tfBaoHanh;

	public static String insert = "";
	private JComboBox<String> comboBox_Loai;
	private JTextField tfLink;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemRAM frame = new ThemRAM();
					frame.setLocationRelativeTo(null);
					setDefaultIDRAM(ramDAO.getInstance().selectAll());
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
	public ThemRAM() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 735, 332);
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
		contentPane.setBackground(SetColor.blueOp);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("THÊM RAM");
		lblNewLabel.setFont(SetFont.fontTitle());
		lblNewLabel.setForeground(SetColor.yellow);
		lblNewLabel.setBounds(10, 0, 212, 35);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tên RAM");
		lblNewLabel_1.setFont(SetFont.font1_());
		lblNewLabel_1.setForeground(SetColor.whiteFont);
		lblNewLabel_1.setBounds(257, 94, 83, 23);
		contentPane.add(lblNewLabel_1);

		tfTen = new JTextField();
		tfTen.setFont(SetFont.fontDetails());
		tfTen.setBorder(null);
		tfTen.setBounds(350, 90, 142, 30);
		contentPane.add(tfTen);
		tfTen.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Loại RAM");
		lblNewLabel_1_1.setFont(SetFont.font1_());
		lblNewLabel_1_1.setForeground(SetColor.whiteFont);
		lblNewLabel_1_1.setBounds(6, 92, 83, 23);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("BUS");
		lblNewLabel_1_1_1.setFont(SetFont.font1_());
		lblNewLabel_1_1_1.setForeground(SetColor.whiteFont);
		lblNewLabel_1_1_1.setBounds(6, 148, 83, 23);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Dung lượng");
		lblNewLabel_1_2.setFont(SetFont.font1_());
		lblNewLabel_1_2.setForeground(SetColor.whiteFont);
		lblNewLabel_1_2.setBounds(257, 148, 83, 23);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Đơn giá");
		lblNewLabel_1_3.setFont(SetFont.font1_());
		lblNewLabel_1_3.setForeground(SetColor.whiteFont);
		lblNewLabel_1_3.setBounds(257, 200, 83, 23);
		contentPane.add(lblNewLabel_1_3);

		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (kiemTraIDRAM())
					JOptionPane.showMessageDialog(null, "ID RAM đã tồn tại!");
				else {
					String url = tfLink.getText();

					String id = comboBox.getSelectedItem().toString();
					String idram = tfIDRAM.getText();
					String ten = tfTen.getText();
					String loai = comboBox_Loai.getSelectedItem().toString();
					String dungluong = tfDungLuong.getText();
					String bus = tfBus.getText();
					double gia = Double.parseDouble(tfGia.getText());
					String baoHanh = tfBaoHanh.getText();

					if (tfTen.getText().equals("") || tfDungLuong.getText().equals("") || tfBus.getText().equals("")
							|| tfGia.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
					} else {

						ram r = new ram(id, idram, ten, loai, dungluong, bus, 0, gia, baoHanh, null);

						if (insert.length() > 0 && url.length() > 0)
							JOptionPane.showMessageDialog(btnNewButton, "Chỉ chọn 1 trong 2 nguồn hình ảnh!");
						else {
							if (insert.equals("") && url.equals("")) {
								int check = ramDAO.getInstance().insertNotIMG(r);
								insert = Checked.checkedAdd(check, insert);
							} else {
								if (url.equals("")) {
									int check = ramDAO.getInstance().insert(r);
									insert = Checked.checkedAdd(check, insert);
								} else if (insert.equals("")) {
									int check = ramDAO.getInstance().insertIMGURL(r, url);
									insert = Checked.checkedAdd(check, insert);
								}

							}
							RAMForm.loadDataToTable(ramDAO.getInstance().selectAll());
							closeFrame();
						}
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				HoverButton.hoverOK(btnNewButton, true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				HoverButton.hoverOK(btnNewButton, false);
			}
		});
		btnNewButton.setBorder(null);
		btnNewButton.setFont(SetFont.font1());
		btnNewButton.setBounds(210, 263, 89, 30);
		contentPane.add(btnNewButton);

		JButton btnHy = new JButton("Hủy");
		btnHy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closeFrame();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				HoverButton.hoverCancel(btnHy, true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				HoverButton.hoverCancel(btnHy, false);
			}
		});
		btnHy.setBorder(null);
		btnHy.setFont(SetFont.font1());
		btnHy.setBounds(321, 263, 89, 30);
		contentPane.add(btnHy);

		tfDungLuong = new JTextField();
		tfDungLuong.setFont(SetFont.fontDetails());
		tfDungLuong.setBorder(null);
		tfDungLuong.setColumns(10);
		tfDungLuong.setBounds(350, 145, 142, 30);
		contentPane.add(tfDungLuong);

		tfBus = new JTextField();
		tfBus.setFont(SetFont.fontDetails());
		tfBus.setBorder(null);
		tfBus.setColumns(10);
		tfBus.setBounds(99, 145, 144, 30);
		contentPane.add(tfBus);

		tfGia = new JTextField();
		tfGia.setFont(SetFont.fontDetails());
		tfGia.setBorder(null);
		tfGia.setColumns(10);
		tfGia.setBounds(350, 198, 142, 30);
		contentPane.add(tfGia);

		JLabel lblNewLabel_2 = new JLabel("© 2023 NGUYỄN QUỐC VIỆT - 23CE.B029");
		lblNewLabel_2.setForeground(SetColor.copyRight);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 307, 715, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_1_4 = new JLabel("ID sản phẩm");
		lblNewLabel_1_4.setForeground(new Color(254, 254, 254));
		lblNewLabel_1_4.setFont(SetFont.font1_());
		lblNewLabel_1_4.setBounds(10, 46, 83, 23);
		contentPane.add(lblNewLabel_1_4);

		ArrayList<Products> list = SanPhamDAO.getIDSanPham("ram");
		String[] combo = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			Products p = list.get(i);
			combo[i] = p.getIdSanPham();
		}

		comboBox = new JComboBox<>(new DefaultComboBoxModel<String>(combo));
		comboBox.setBounds(99, 39, 144, 30);
		contentPane.add(comboBox);

		JLabel lblNewLabel_1_5 = new JLabel("ID RAM");
		lblNewLabel_1_5.setForeground(new Color(254, 254, 254));
		lblNewLabel_1_5.setFont(SetFont.font1_());
		lblNewLabel_1_5.setBounds(261, 41, 83, 23);
		contentPane.add(lblNewLabel_1_5);

		tfIDRAM = new JTextField();
		tfIDRAM.setEditable(false);
		tfIDRAM.setFont(SetFont.fontDetails());
		tfIDRAM.setColumns(10);
		tfIDRAM.setBorder(null);
		tfIDRAM.setBounds(350, 41, 142, 30);
		contentPane.add(tfIDRAM);

		JLabel labelIMG = new JLabel("Ảnh RAM");
		labelIMG.setHorizontalAlignment(SwingConstants.CENTER);
		labelIMG.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelIMG.setBounds(502, 41, 223, 225);
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
		btnUpload.setBounds(654, 272, 71, 21);
		contentPane.add(btnUpload);

		tfBaoHanh = new JTextField();
		tfBaoHanh.setFont(SetFont.fontDetails());
		tfBaoHanh.setColumns(10);
		tfBaoHanh.setBorder(null);
		tfBaoHanh.setBounds(99, 200, 144, 30);
		contentPane.add(tfBaoHanh);

		JLabel lblNewLabel_1_5_1_1 = new JLabel("Bảo hành");
		lblNewLabel_1_5_1_1.setForeground(new Color(254, 254, 254));
		lblNewLabel_1_5_1_1.setFont(SetFont.font1_());
		lblNewLabel_1_5_1_1.setBounds(10, 205, 83, 23);
		contentPane.add(lblNewLabel_1_5_1_1);

		comboBox_Loai = new JComboBox<>(new String[] { "DDR3", "DDR4", "DDR5" });
		comboBox_Loai.setBounds(99, 90, 148, 30);
		contentPane.add(comboBox_Loai);

		JLabel lblTnNgun_1_2_1 = new JLabel("Link hình ảnh:");
		lblTnNgun_1_2_1.setForeground(new Color(254, 254, 254));
		lblTnNgun_1_2_1.setFont(SetFont.font1_());
		lblTnNgun_1_2_1.setBounds(261, 7, 89, 21);
		contentPane.add(lblTnNgun_1_2_1);

		tfLink = new JTextField("");
		tfLink.setFont(SetFont.fontDetails());
		tfLink.setColumns(10);
		tfLink.setBounds(350, 7, 314, 20);
		contentPane.add(tfLink);

		JButton btnNewButton_1 = new JButton("OK");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insert = LoadIMGURL.setIMG(tfLink, labelIMG, insert);
			}
		});
		btnNewButton_1.setBounds(674, 7, 51, 20);
		contentPane.add(btnNewButton_1);
	}

	private void closeFrame() {
		this.dispose();
	}

	private boolean kiemTraIDRAM() {
		ArrayList<ram> list = ramDAO.getInstance().selectAll();

		for (ram ram : list) {
			if (ram.getIdRam().equals(tfIDRAM.getText()))
				return true;
		}
		return false;
	}

	private static void setDefaultIDRAM(ArrayList<ram> arr) {
		int id = arr.size() + 1;
		String check = "";
		for (ram ram : arr) {
			if (ram.getIdRam().equals("ram" + id)) {
				check = ram.getIdRam();
			}
		}
		while (check.length() != 0) {
			String c = check;
			id++;
			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i).getIdRam().equals("ram" + id)) {
					check = arr.get(i).getIdRam();
				}
			}
			if (check.equals(c)) {
				check = "";
			}
		}
		tfIDRAM.setText("ram" + id);
	}

	public static String getInsert() {
		return insert;
	}

	public static void setInsert(String insert) {
		ThemRAM.insert = insert;
	}

}
