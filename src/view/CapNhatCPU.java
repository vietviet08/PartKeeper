package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import color.SetColor;
import controller.Checked;
import controller.LoadIMGURL;
import dao.SanPhamDAO;
import dao.cpuDAO;
import decor.HoverButton;
import font.SetFont;
import model.Products;
import model.cpu;

public class CapNhatCPU extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField tfSoNhan;
	private static JTextField tfSoluong;
	private static JTextField tfTen;
	private static JTextField tfXungNhip;
	private static JTextField tfDienNang;
	private static JTextField tfBoNhoDem;
	private static JTextField tfGia;
	private static JComboBox<String> comboBox;
	private static JTextField tfBaoHanh;

	public static String insert = "";
	private static JLabel labelIMG;
	private JTextField tfLink;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CapNhatCPU frame = new CapNhatCPU();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					setTextToTf();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CapNhatCPU() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 763, 399);
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

		JLabel lblSNhn = new JLabel("Số nhân");
		lblSNhn.setForeground(new Color(254, 254, 254));
		lblSNhn.setFont(SetFont.font1_());
		lblSNhn.setBounds(289, 53, 83, 30);
		contentPane.add(lblSNhn);

		tfSoNhan = new JTextField();
		tfSoNhan.setFont(SetFont.fontDetails());
		tfSoNhan.setColumns(10);
		tfSoNhan.setBounds(366, 53, 35, 30);
		contentPane.add(tfSoNhan);

		tfSoluong = new JTextField();
		tfSoluong.setColumns(10);
		tfSoluong.setFont(SetFont.fontDetails());
		tfSoluong.setBounds(473, 53, 35, 30);
		contentPane.add(tfSoluong);

		JLabel lblTnCpu = new JLabel("Tên cpu");
		lblTnCpu.setForeground(new Color(254, 254, 254));
		lblTnCpu.setFont(SetFont.font1_());
		lblTnCpu.setBounds(10, 117, 71, 30);
		contentPane.add(lblTnCpu);

		tfTen = new JTextField();
		tfTen.setFont(SetFont.fontDetails());
		tfTen.setColumns(10);
		tfTen.setBounds(128, 117, 141, 30);
		contentPane.add(tfTen);

		JLabel lblXungNhp = new JLabel("Xung nhịp");
		lblXungNhp.setForeground(new Color(254, 254, 254));
		lblXungNhp.setFont(SetFont.font1_());
		lblXungNhp.setBounds(289, 118, 83, 30);
		contentPane.add(lblXungNhp);

		tfXungNhip = new JTextField();
		tfXungNhip.setColumns(10);
		tfXungNhip.setFont(SetFont.fontDetails());
		tfXungNhip.setBounds(367, 117, 141, 30);
		contentPane.add(tfXungNhip);

		JLabel lblinNngTiu = new JLabel("Điện năng tiêu thụ");
		lblinNngTiu.setForeground(new Color(254, 254, 254));
		lblinNngTiu.setFont(SetFont.font1_());
		lblinNngTiu.setBounds(10, 186, 116, 30);
		contentPane.add(lblinNngTiu);

		tfDienNang = new JTextField();
		tfDienNang.setFont(SetFont.fontDetails());
		tfDienNang.setColumns(10);
		tfDienNang.setBounds(128, 186, 141, 30);
		contentPane.add(tfDienNang);

		JLabel lblNewLabel_1_1_1 = new JLabel("Bộ nhớ đệm");
		lblNewLabel_1_1_1.setForeground(new Color(254, 254, 254));
		lblNewLabel_1_1_1.setFont(SetFont.font1_());
		lblNewLabel_1_1_1.setBounds(289, 188, 83, 30);
		contentPane.add(lblNewLabel_1_1_1);

		tfBoNhoDem = new JTextField();
		tfBoNhoDem.setFont(SetFont.fontDetails());
		tfBoNhoDem.setColumns(10);
		tfBoNhoDem.setBounds(367, 186, 141, 30);
		contentPane.add(tfBoNhoDem);

		tfGia = new JTextField();
		tfGia.setFont(SetFont.fontDetails());
		tfGia.setColumns(10);
		tfGia.setBounds(367, 257, 141, 30);
		contentPane.add(tfGia);

		JButton btnCpNht = new JButton("Cập nhật");
		btnCpNht.setBorder(null);
		btnCpNht.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					updateCPU();
				}
			}
		});
		btnCpNht.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateCPU();

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
		btnCpNht.setBounds(197, 314, 97, 30);
		contentPane.add(btnCpNht);

		JButton btnCancel = new JButton("Hủy");
		btnCancel.setBorder(null);
		btnCancel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					closeFrame();
				}
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
		btnCancel.setBounds(306, 314, 97, 30);
		contentPane.add(btnCancel);

		JLabel lblSLung = new JLabel("Số luồng");
		lblSLung.setForeground(new Color(254, 254, 254));
		lblSLung.setFont(SetFont.font1_());
		lblSLung.setBounds(414, 53, 83, 30);
		contentPane.add(lblSLung);

		JLabel lblIdSnPhm = new JLabel("ID sản phẩm");
		lblIdSnPhm.setForeground(new Color(254, 254, 254));
		lblIdSnPhm.setFont(SetFont.font1_());
		lblIdSnPhm.setBounds(10, 53, 104, 30);
		contentPane.add(lblIdSnPhm);

		ArrayList<Products> list = SanPhamDAO.getIDSanPham("cpu");
		int size = list.size();
		String choose[] = new String[size];
		for (int i = 0; i < size; i++) {
			Products pr = list.get(i);
			choose[i] = pr.getIdSanPham();
		}
		comboBox = new JComboBox<>(new DefaultComboBoxModel<String>(choose));
		comboBox.setFont(SetFont.fontDetails());
		comboBox.setBounds(128, 53, 141, 30);
		contentPane.add(comboBox);

		JLabel label = new JLabel("Đơn giá");
		label.setForeground(new Color(254, 254, 254));
		label.setFont(SetFont.font1_());
		label.setBounds(289, 257, 83, 30);
		contentPane.add(label);

		JLabel lblNewLabel = new JLabel("CẬP NHẬT CPU");
		lblNewLabel.setFont(SetFont.fontTitle());
		lblNewLabel.setForeground(SetColor.yellow);
		lblNewLabel.setBounds(10, 11, 169, 31);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("© 2023 NGUYỄN QUỐC VIỆT - 23CE.B029");
		lblNewLabel_1.setFont(SetFont.font());
		lblNewLabel_1.setForeground(new Color(224, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 374, 754, 14);
		contentPane.add(lblNewLabel_1);

		labelIMG = new JLabel("Ảnh CPU");
		labelIMG.setHorizontalAlignment(SwingConstants.CENTER);
		labelIMG.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelIMG.setBounds(529, 53, 223, 230);
		contentPane.add(labelIMG);

		JButton btnUpload = new JButton("Upload");
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
		btnUpload.setBorder(null);
		btnUpload.setBounds(663, 291, 89, 23);
		contentPane.add(btnUpload);

		JLabel lblNewLabel_1_2_1 = new JLabel("Bảo hành");
		lblNewLabel_1_2_1.setForeground(new Color(254, 254, 254));
		lblNewLabel_1_2_1.setFont(SetFont.font1_());
		lblNewLabel_1_2_1.setBounds(10, 257, 83, 30);
		contentPane.add(lblNewLabel_1_2_1);

		tfBaoHanh = new JTextField();
		tfBaoHanh.setFont(SetFont.fontDetails());
		tfBaoHanh.setColumns(10);
		tfBaoHanh.setBounds(128, 257, 141, 30);
		contentPane.add(tfBaoHanh);

		JLabel lblTnNgun_1_2_1 = new JLabel("Link hình ảnh:");
		lblTnNgun_1_2_1.setForeground(new Color(254, 254, 254));
		lblTnNgun_1_2_1.setFont(SetFont.font1_());
		lblTnNgun_1_2_1.setBounds(289, 11, 116, 21);
		contentPane.add(lblTnNgun_1_2_1);

		tfLink = new JTextField("");
		tfLink.setFont(SetFont.fontDetails());
		tfLink.setColumns(10);
		tfLink.setBounds(402, 11, 294, 20);
		contentPane.add(tfLink);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insert = LoadIMGURL.setIMG(tfLink, labelIMG, insert);
			}
		});
		btnNewButton.setBounds(700, 11, 52, 20);
		contentPane.add(btnNewButton);
	}

	private void closeFrame() {
		this.dispose();
	}

	private static void setTextToTf() {
		cpu c = CPUForm.getSelectCPU();
		comboBox.setSelectedItem(c.getIdSanPham());
		tfTen.setText(c.getNameCpu());
		tfXungNhip.setText(c.getXungNhip());
		tfBoNhoDem.setText(c.getBoNhoDem());
		tfGia.setText(String.valueOf(c.getDonGia()));
		tfDienNang.setText(c.getDienNangTieuThu());
		tfSoluong.setText(String.valueOf(c.getSoLuong()));
		tfSoNhan.setText(String.valueOf(c.getSoNhan()));
		tfBaoHanh.setText(c.getBaoHanh());

		if (c.getImg() == null)
			labelIMG.setText("Sản phẩm hiện chưa có ảnh mẫu!");
		else {
			Blob blob = c.getImg();
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

	private void updateCPU() {
		String url = tfLink.getText();

		if (insert.length() > 0 && url.length() > 0)
			JOptionPane.showMessageDialog(null, "Chỉ chọn 1 trong 2 nguồn hình ảnh!");
		else {

			String idcpu = CPUForm.getSelectCPU().getIdCpu();
			String ten = tfTen.getText();
			String xn = tfXungNhip.getText();
			int sonhan = Integer.parseInt(tfSoNhan.getText());
			int soluong = Integer.parseInt(tfSoluong.getText());
			String dien = tfDienNang.getText();
			String bonho = tfBoNhoDem.getText();
			double gia = Double.parseDouble(tfGia.getText());
			String baoHanh = tfBaoHanh.getText();

			String id = comboBox.getSelectedItem().toString();

			cpu cc = new cpu(id, idcpu, ten, xn, sonhan, soluong, dien, bonho, CPUForm.getSelectCPU().getTonKho(), gia,
					baoHanh, null);

			if (insert.equals("") && url.equals("")) {
				int check = cpuDAO.getInstance().updateNotIMG(cc);
				insert = Checked.checkedUpdate(check, insert);
			} else {
				if (url.equals("")) {
					int check = cpuDAO.getInstance().update(cc);
					insert = Checked.checkedUpdate(check, insert);
				} else if (insert.equals("")) {
					int check = cpuDAO.getInstance().updateIMGURL(cc, url);
					insert = Checked.checkedUpdate(check, insert);
				}
			}
			CPUForm.loadDataToTable(cpuDAO.getInstance().selectAll());
			closeFrame();
		}

	}

	public static String getInsert() {
		return insert;
	}

	public static void setInsert(String insert) {
		CapNhatCPU.insert = insert;
	}
}