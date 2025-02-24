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
import dao.SanPhamDAO;
import dao.vgaDAO;
import decor.HoverButton;
import font.SetFont;
import model.Products;
import model.vga;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CapNhatVGA extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField tfTen;
	private static JTextField tfBoNho;
	private static JTextField tfDonGia;
	private static JTextField tfHang;
	private static JComboBox<String> comboBox;
	private static JTextField tfBaoHanh;
	private static JLabel labelIMG;
	private JButton btnUpload;

	public static String insert = "";
	private JTextField tfLink;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CapNhatVGA frame = new CapNhatVGA();
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
	public CapNhatVGA() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 781, 351);
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

		JLabel lblNewLabel = new JLabel("CẬP NHẬT VGA");
		lblNewLabel.setFont(SetFont.fontTitle());
		lblNewLabel.setForeground(SetColor.yellow);
		lblNewLabel.setBounds(10, 11, 158, 29);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("© 2023 NGUYỄN QUỐC VIỆT - 23CE.B029");
		lblNewLabel_1.setForeground(SetColor.copyRight);
		lblNewLabel_1.setFont(SetFont.font());
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 326, 762, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblTnVga = new JLabel("Tên VGA");
		lblTnVga.setForeground(SetColor.whiteFont);
		lblTnVga.setFont(SetFont.font1_());
		lblTnVga.setBounds(281, 60, 90, 25);
		contentPane.add(lblTnVga);

		tfTen = new JTextField();
		tfTen.setFont(SetFont.fontDetails());
		tfTen.setBorder(null);
		tfTen.setBounds(381, 57, 158, 30);
		contentPane.add(tfTen);
		tfTen.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Hãng");
		lblNewLabel_2_1.setForeground(SetColor.whiteFont);
		lblNewLabel_2_1.setFont(SetFont.font1_());
		lblNewLabel_2_1.setBounds(20, 127, 78, 25);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Đơn giá");
		lblNewLabel_2_1_1.setForeground(SetColor.whiteFont);
		lblNewLabel_2_1_1.setFont(SetFont.font1_());
		lblNewLabel_2_1_1.setBounds(281, 192, 90, 25);
		contentPane.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_2 = new JLabel("Bộ nhớ");
		lblNewLabel_2_2.setForeground(SetColor.whiteFont);
		lblNewLabel_2_2.setFont(SetFont.font1_());
		lblNewLabel_2_2.setBounds(281, 127, 90, 25);
		contentPane.add(lblNewLabel_2_2);

		JButton btnNewButton = new JButton("Cập nhật");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String url = tfLink.getText();
				if (insert.length() > 0 && url.length() > 0)
					JOptionPane.showMessageDialog(null, "Chỉ chọn 1 trong 2 nguồn hình ảnh!");
				else {
					vga v = VGAForm.getVGASelect();

					vga vvga = new vga(comboBox.getSelectedItem().toString(), v.getIdVga(), tfTen.getText(),
							tfHang.getText(), tfBoNho.getText(), v.getTonKho(), Double.parseDouble(tfDonGia.getText()),
							tfBaoHanh.getText(), null);

					if (insert.equals("") && url.equals("")) {
						int check = vgaDAO.getInstance().updateNotIMG(vvga);
						insert = Checked.checkedUpdate(check, insert);

					} else {
						if (url.equals("")) {
							int check = vgaDAO.getInstance().update(vvga);
							insert = Checked.checkedUpdate(check, insert);
						} else if (insert.equals("")) {
							int check = vgaDAO.getInstance().updateIMGURL(vvga, url);
							insert = Checked.checkedUpdate(check, insert);
						}
					}

					VGAForm.loadDataToTable(vgaDAO.getInstance().selectAll());
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
		btnNewButton.setBounds(188, 259, 89, 30);
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
		btnHy.setFont(SetFont.font1());
		btnHy.setBorder(null);
		btnHy.setBounds(316, 259, 89, 30);
		contentPane.add(btnHy);

		tfBoNho = new JTextField();
		tfBoNho.setFont(SetFont.fontDetails());
		tfBoNho.setColumns(10);
		tfBoNho.setBorder(null);
		tfBoNho.setBounds(381, 124, 158, 30);
		contentPane.add(tfBoNho);

		tfDonGia = new JTextField();
		tfDonGia.setFont(SetFont.fontDetails());
		tfDonGia.setColumns(10);
		tfDonGia.setBorder(null);
		tfDonGia.setBounds(381, 189, 158, 30);
		contentPane.add(tfDonGia);

		tfHang = new JTextField();
		tfHang.setFont(SetFont.fontDetails());
		tfHang.setColumns(10);
		tfHang.setBorder(null);
		tfHang.setBounds(101, 124, 158, 30);
		contentPane.add(tfHang);

		JLabel lblNewLabel_2_1_2 = new JLabel("ID sản phẩm");
		lblNewLabel_2_1_2.setForeground(new Color(254, 254, 254));
		lblNewLabel_2_1_2.setFont(SetFont.font1_());
		lblNewLabel_2_1_2.setBounds(20, 60, 78, 25);
		contentPane.add(lblNewLabel_2_1_2);

		ArrayList<Products> list = SanPhamDAO.getIDSanPham("vga");
		String[] combo = new String[list.size()];

		for (int i = 0; i < list.size(); i++) {
			Products p = list.get(i);
			combo[i] = p.getIdSanPham();
		}

		comboBox = new JComboBox<>(new DefaultComboBoxModel<String>(combo));
		comboBox.setFont(SetFont.fontDetails());
		comboBox.setBounds(101, 57, 158, 30);
		contentPane.add(comboBox);

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
		btnUpload.setFont(SetFont.font());
		btnUpload.setBorder(null);
		btnUpload.setBounds(701, 298, 71, 21);
		contentPane.add(btnUpload);

		labelIMG = new JLabel("Ảnh VGA");
		labelIMG.setHorizontalAlignment(SwingConstants.CENTER);
		labelIMG.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelIMG.setBounds(549, 57, 223, 230);
		contentPane.add(labelIMG);

		JLabel lblNewLabel_2_1_3_1 = new JLabel("Bảo hành");
		lblNewLabel_2_1_3_1.setForeground(new Color(254, 254, 254));
		lblNewLabel_2_1_3_1.setFont(SetFont.font1_());
		lblNewLabel_2_1_3_1.setBounds(20, 192, 78, 25);
		contentPane.add(lblNewLabel_2_1_3_1);

		tfBaoHanh = new JTextField();
		tfBaoHanh.setFont(SetFont.fontDetails());
		tfBaoHanh.setColumns(10);
		tfBaoHanh.setBorder(null);
		tfBaoHanh.setBounds(101, 189, 158, 30);
		contentPane.add(tfBaoHanh);

		tfLink = new JTextField("");
		tfLink.setFont(SetFont.fontDetails());
		tfLink.setColumns(10);
		tfLink.setBounds(381, 11, 335, 20);
		contentPane.add(tfLink);

		JButton btnNewButton_2 = new JButton("OK");
		btnNewButton_2.setBounds(720, 11, 52, 20);
		contentPane.add(btnNewButton_2);

		JLabel lblTnNgun_1_2_1 = new JLabel("Link hình ảnh:");
		lblTnNgun_1_2_1.setForeground(new Color(254, 254, 254));
		lblTnNgun_1_2_1.setFont(SetFont.font1_());
		lblTnNgun_1_2_1.setBounds(281, 11, 96, 21);
		contentPane.add(lblTnNgun_1_2_1);
	}

	private void closeFrame() {
		this.dispose();
	}

	private static void setDefaultTF() {
		vga v = VGAForm.getVGASelect();
		comboBox.setSelectedItem(v.getIdSanPham());
		tfTen.setText(v.getTenVGA());
		tfBoNho.setText(v.getBoNho());
		tfDonGia.setText(String.valueOf(v.getDonGia()));
		tfHang.setText(v.getHangVGA());
		tfBaoHanh.setText(v.getBaoHanh());

		if (v.getImg() == null)
			labelIMG.setText("Sản phẩm hiện chưa có ảnh mẫu!");
		else {
			Blob blob = v.getImg();
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
		CapNhatVGA.insert = insert;
	}

}
