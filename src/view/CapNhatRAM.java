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

import javax.swing.DefaultComboBoxModel;
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

import color.SetColor;
import controller.Checked;
import controller.LoadIMGURL;
import dao.SanPhamDAO;
import dao.ramDAO;
import decor.HoverButton;
import font.SetFont;
import model.Products;
import model.ram;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CapNhatRAM extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField tfTen;
	private static JTextField tfLoai;
	private static JTextField tfBus;
	private static JTextField tfDungLuong;
	private static JTextField tfGia;
	private static JComboBox<String> comboBox;
	private JButton btnUpload;
	private static JLabel labelIMG;
	private static JTextField tfBaoHanh;

	public static String insert = "";
	private JTextField tfLink;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CapNhatRAM frame = new CapNhatRAM();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					setDefaultTF();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CapNhatRAM() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 790, 374);
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SetColor.blueOp);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("CẬP NHẬT RAM");
		lblNewLabel.setForeground(SetColor.yellow);
		lblNewLabel.setFont(SetFont.fontTitle());
		lblNewLabel.setBounds(10, 11, 155, 39);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("© 2023 NGUYỄN QUỐC VIỆT - 23CE.B029");
		lblNewLabel_1.setFont(SetFont.font());
		lblNewLabel_1.setForeground(SetColor.copyRight);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(40, 342, 740, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Tên RAM");
		lblNewLabel_2.setFont(SetFont.font1_());
		lblNewLabel_2.setForeground(SetColor.whiteFont);
		lblNewLabel_2.setBounds(289, 74, 96, 28);
		contentPane.add(lblNewLabel_2);

		tfTen = new JTextField();
		tfTen.setFont(SetFont.fontDetails());
		tfTen.setBorder(null);
		tfTen.setBounds(382, 74, 164, 28);
		contentPane.add(tfTen);
		tfTen.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Loại RAM");
		lblNewLabel_2_1.setFont(SetFont.font1_());
		lblNewLabel_2_1.setForeground(SetColor.whiteFont);
		lblNewLabel_2_1.setBounds(35, 136, 84, 28);
		contentPane.add(lblNewLabel_2_1);

		tfLoai = new JTextField();
		tfLoai.setFont(SetFont.fontDetails());
		tfLoai.setBorder(null);
		tfLoai.setColumns(10);
		tfLoai.setBounds(115, 136, 164, 28);
		contentPane.add(tfLoai);

		JLabel lblNewLabel_2_1_1 = new JLabel("BUS");
		lblNewLabel_2_1_1.setFont(SetFont.font1_());
		lblNewLabel_2_1_1.setForeground(SetColor.whiteFont);
		lblNewLabel_2_1_1.setBounds(35, 205, 84, 28);
		contentPane.add(lblNewLabel_2_1_1);

		tfBus = new JTextField();
		tfBus.setFont(SetFont.fontDetails());
		tfBus.setBorder(null);
		tfBus.setColumns(10);
		tfBus.setBounds(115, 205, 164, 28);
		contentPane.add(tfBus);

		tfDungLuong = new JTextField();
		tfDungLuong.setFont(SetFont.fontDetails());
		tfDungLuong.setBorder(null);
		tfDungLuong.setColumns(10);
		tfDungLuong.setBounds(382, 136, 164, 28);
		contentPane.add(tfDungLuong);

		JLabel lblNewLabel_2_2 = new JLabel("Dung lượng");
		lblNewLabel_2_2.setFont(SetFont.font1_());
		lblNewLabel_2_2.setForeground(SetColor.whiteFont);
		lblNewLabel_2_2.setBounds(289, 136, 96, 28);
		contentPane.add(lblNewLabel_2_2);

		tfGia = new JTextField();
		tfGia.setFont(SetFont.fontDetails());
		tfGia.setBorder(null);
		tfGia.setColumns(10);
		tfGia.setBounds(115, 272, 164, 28);
		contentPane.add(tfGia);

		JLabel lblNewLabel_2_3 = new JLabel("Đơn giá");
		lblNewLabel_2_3.setFont(SetFont.font1_());
		lblNewLabel_2_3.setForeground(SetColor.whiteFont);
		lblNewLabel_2_3.setBounds(35, 272, 84, 28);
		contentPane.add(lblNewLabel_2_3);

		JButton btnNewButton = new JButton("Cập nhật");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String url = tfLink.getText();
				if (insert.length() > 0 && url.length() > 0)
					JOptionPane.showMessageDialog(null, "Chỉ chọn 1 trong 2 nguồn hình ảnh!");
				else {
					ram old = RAMForm.getSelectRAM();

					String idsp = comboBox.getSelectedItem().toString();

					String idram = old.getIdRam();
					ram r = new ram(idsp, idram, tfTen.getText(), tfLoai.getText(), tfDungLuong.getText(),
							tfBus.getText(), old.getTonkho(), Double.parseDouble(tfGia.getText()), tfBaoHanh.getText(),
							null);
					if (insert.equals("") && url.equals("")) {
						int check = ramDAO.getInstance().updateNotIMG(r);
						insert = Checked.checkedUpdate(check, insert);

					} else {
						if (url.equals("")) {
							int check = ramDAO.getInstance().update(r);
							insert = Checked.checkedUpdate(check, insert);
						} else if (insert.equals("")) {
							int check = ramDAO.getInstance().updateIMGURL(r, url);
							insert = Checked.checkedUpdate(check, insert);
						}
					}

					RAMForm.loadDataToTable(ramDAO.getInstance().selectAll());
					closeFrame();
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
		btnNewButton.setFont(SetFont.font1());
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(289, 272, 112, 28);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Hủy");
		btnNewButton_1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				closeFrame();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				HoverButton.hoverCancel(btnNewButton_1, true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				HoverButton.hoverCancel(btnNewButton_1, false);
			}
		});
		btnNewButton_1.setFont(SetFont.font1());
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBounds(434, 272, 112, 28);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_2_1_2 = new JLabel("ID sản phẩm");
		lblNewLabel_2_1_2.setForeground(new Color(254, 254, 254));
		lblNewLabel_2_1_2.setFont(SetFont.font1_());
		lblNewLabel_2_1_2.setBounds(35, 74, 84, 28);
		contentPane.add(lblNewLabel_2_1_2);

		ArrayList<Products> list = SanPhamDAO.getIDSanPham("ram");
		String[] combo = new String[list.size()];

		for (int i = 0; i < list.size(); i++) {
			Products p = list.get(i);
			combo[i] = p.getIdSanPham();
		}

		comboBox = new JComboBox<>(new DefaultComboBoxModel<String>(combo));
		comboBox.setFont(SetFont.fontDetails());
		comboBox.setBounds(115, 74, 164, 28);
		contentPane.add(comboBox);

		labelIMG = new JLabel("Ảnh RAM");
		labelIMG.setHorizontalAlignment(SwingConstants.CENTER);
		labelIMG.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelIMG.setBounds(557, 74, 223, 230);
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
		btnUpload.setBounds(709, 310, 71, 21);
		contentPane.add(btnUpload);

		tfBaoHanh = new JTextField();
		tfBaoHanh.setFont(SetFont.fontDetails());
		tfBaoHanh.setColumns(10);
		tfBaoHanh.setBorder(null);
		tfBaoHanh.setBounds(382, 205, 164, 28);
		contentPane.add(tfBaoHanh);

		JLabel lblBaoHanh = new JLabel("Bảo hành");
		lblBaoHanh.setForeground(new Color(254, 254, 254));
		lblBaoHanh.setFont(SetFont.font1_());
		lblBaoHanh.setBounds(289, 205, 96, 28);
		contentPane.add(lblBaoHanh);

		tfLink = new JTextField("");
		tfLink.setFont(SetFont.fontDetails());
		tfLink.setColumns(10);
		tfLink.setBounds(382, 29, 342, 20);
		contentPane.add(tfLink);

		JLabel lblTnNgun_1_2_1 = new JLabel("Link hình ảnh:");
		lblTnNgun_1_2_1.setForeground(new Color(254, 254, 254));
		lblTnNgun_1_2_1.setFont(SetFont.font1_());
		lblTnNgun_1_2_1.setBounds(289, 29, 96, 21);
		contentPane.add(lblTnNgun_1_2_1);

		JButton btnNewButton_2 = new JButton("OK");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insert = LoadIMGURL.setIMG(tfLink, labelIMG, insert);
			}
		});
		btnNewButton_2.setBounds(728, 29, 52, 20);
		contentPane.add(btnNewButton_2);
	}

	private void closeFrame() {
		this.dispose();
	}

	private static void setDefaultTF() {
		ram r = RAMForm.getSelectRAM();
		comboBox.setSelectedItem(r.getIdSanPham());
		tfTen.setText(r.getTenRam());
		tfLoai.setText(r.getLoai());
		tfBus.setText(r.getBus());
		tfGia.setText(String.valueOf(r.getDonGia()));
		tfDungLuong.setText(r.getDungLuong());
		tfBaoHanh.setText(r.getBaoHanh());

		if (r.getImg() == null)
			labelIMG.setText("Sản phẩm hiện chưa có ảnh mẫu!");
		else {
			Blob blob = r.getImg();
			byte[] by;
			try {
				by = blob.getBytes(1, (int) blob.length());
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

	public static String getInsert() {
		return insert;
	}

	public static void setInsert(String insert) {
		CapNhatRAM.insert = insert;
	}

}
