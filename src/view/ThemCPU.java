package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import dao.cpuDAO;
import font.SetFont;
import model.Products;
import model.cpu;

public class ThemCPU extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfSoNhan;
	private JTextField tfXungNhip;
	private JTextField tfDienNang;
	private JTextField tfSoLuong;
	private JTextField tfBoNhoDem;
	private JTextField tfTenCPU;
	private JComboBox<String> comboBox;
	private static JTextField tfIDCPU;
	private JTextField tfDonGia;
	private JButton btnUpload;
	private JLabel labelIMG;
	private JTextField tfBaoHanh;

	public static String insert = "";
	private JTextField tfLink;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemCPU frame = new ThemCPU();
					setDefaultIDCPU(cpuDAO.getInstance().selectAll());
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
	public ThemCPU() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 825, 409);
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

		JLabel lblNewLabel = new JLabel("ID sản phẩm");
		lblNewLabel.setForeground(SetColor.whiteFont);
		lblNewLabel.setFont(SetFont.font1_());
		lblNewLabel.setBounds(21, 57, 81, 30);
		contentPane.add(lblNewLabel);

		JLabel lblSNhn = new JLabel("Số nhân");
		lblSNhn.setForeground(SetColor.whiteFont);
		lblSNhn.setFont(SetFont.font1_());
		lblSNhn.setBounds(330, 57, 83, 30);
		contentPane.add(lblSNhn);

		JLabel lblNewLabel_1_1 = new JLabel("Số luồng");
		lblNewLabel_1_1.setForeground(SetColor.whiteFont);
		lblNewLabel_1_1.setFont(SetFont.font1_());
		lblNewLabel_1_1.setBounds(445, 57, 80, 30);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblXungNhp = new JLabel("Xung nhịp");
		lblXungNhp.setFont(SetFont.font1_());
		lblXungNhp.setForeground(SetColor.whiteFont);
		lblXungNhp.setBounds(330, 122, 97, 30);
		contentPane.add(lblXungNhp);

		JLabel lblinNngTiu = new JLabel("Điện năng tiêu thụ");
		lblinNngTiu.setForeground(SetColor.whiteFont);
		lblinNngTiu.setFont(SetFont.font1_());
		lblinNngTiu.setBounds(21, 257, 126, 30);
		contentPane.add(lblinNngTiu);

		tfSoNhan = new JTextField();
		tfSoNhan.setFont(SetFont.fontDetails());
		tfSoNhan.setColumns(10);
		tfSoNhan.setBounds(390, 57, 45, 30);
		contentPane.add(tfSoNhan);

		tfXungNhip = new JTextField();
		tfXungNhip.setColumns(10);
		tfXungNhip.setFont(SetFont.fontDetails());
		tfXungNhip.setBounds(431, 122, 141, 30);
		contentPane.add(tfXungNhip);

		tfDienNang = new JTextField();
		tfDienNang.setColumns(10);
		tfDienNang.setFont(SetFont.fontDetails());
		tfDienNang.setBounds(147, 257, 141, 30);
		contentPane.add(tfDienNang);

		tfSoLuong = new JTextField();
		tfSoLuong.setColumns(10);
		tfSoLuong.setFont(SetFont.fontDetails());
		tfSoLuong.setBounds(527, 57, 45, 30);
		contentPane.add(tfSoLuong);

		JButton btnAdd = new JButton("Thêm");
		btnAdd.setBorder(null);
		btnAdd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					addCPU();
				}
			}
		});
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addCPU();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnAdd.setForeground(SetColor.whiteFont);
				btnAdd.setBackground(SetColor.green);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAdd.setForeground(Color.black);
				btnAdd.setBackground(Color.white);
			}
		});
		btnAdd.setFont(SetFont.font1());
		btnAdd.setBounds(330, 319, 97, 30);
		contentPane.add(btnAdd);

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
				btnCancel.setForeground(SetColor.whiteFont);
				btnCancel.setBackground(SetColor.redB);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCancel.setForeground(Color.black);
				btnCancel.setBackground(Color.white);
			}
		});
		btnCancel.setFont(SetFont.font1());
		btnCancel.setBounds(475, 319, 97, 30);
		contentPane.add(btnCancel);

		JLabel lblNewLabel_1_1_1 = new JLabel("Bộ nhớ đệm");
		lblNewLabel_1_1_1.setForeground(SetColor.whiteFont);
		lblNewLabel_1_1_1.setFont(SetFont.font1_());
		lblNewLabel_1_1_1.setBounds(330, 192, 97, 30);
		contentPane.add(lblNewLabel_1_1_1);

		tfBoNhoDem = new JTextField();
		tfBoNhoDem.setFont(SetFont.fontDetails());
		tfBoNhoDem.setColumns(10);
		tfBoNhoDem.setBounds(431, 191, 141, 30);
		contentPane.add(tfBoNhoDem);

		ArrayList<Products> list = SanPhamDAO.getIDSanPham("cpu");
		int size = list.size();
		String choose[] = new String[size];
		for (int i = 0; i < size; i++) {
			Products pr = list.get(i);
			choose[i] = pr.getIdSanPham();
		}
		comboBox = new JComboBox<String>();
		comboBox.setFont(SetFont.fontDetails());
		comboBox.setModel(new DefaultComboBoxModel<String>(choose));
		comboBox.setBounds(147, 57, 141, 30);
		contentPane.add(comboBox);

		JLabel lblTnCpu = new JLabel("Tên cpu");
		lblTnCpu.setForeground(SetColor.whiteFont);
		lblTnCpu.setFont(SetFont.font1_());
		lblTnCpu.setBounds(21, 188, 71, 30);
		contentPane.add(lblTnCpu);

		tfTenCPU = new JTextField();
		tfTenCPU.setColumns(10);
		tfTenCPU.setFont(SetFont.fontDetails());
		tfTenCPU.setBounds(147, 188, 141, 30);
		contentPane.add(tfTenCPU);

		JLabel lblNewLabel_1 = new JLabel("© 2023 NGUYỄN QUỐC VIỆT - 23CE.B029");
		lblNewLabel_1.setForeground(SetColor.copyRight);
		lblNewLabel_1.setFont(SetFont.font());
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 384, 815, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("THÊM CPU");
		lblNewLabel_2.setFont(SetFont.fontTitle());
		lblNewLabel_2.setForeground(SetColor.yellow);
		lblNewLabel_2.setBounds(10, 10, 267, 36);
		contentPane.add(lblNewLabel_2);

		JLabel lblIdCpu = new JLabel("ID CPU");
		lblIdCpu.setForeground(new Color(254, 254, 254));
		lblIdCpu.setFont(SetFont.font1_());
		lblIdCpu.setBounds(21, 122, 71, 30);
		contentPane.add(lblIdCpu);

		tfIDCPU = new JTextField();
		tfIDCPU.setEditable(false);
		tfIDCPU.setFont(SetFont.fontDetails());
		tfIDCPU.setColumns(10);
		tfIDCPU.setBounds(147, 122, 141, 30);
		contentPane.add(tfIDCPU);

		JLabel lblNewLabel_1_2_1 = new JLabel("Đơn giá");
		lblNewLabel_1_2_1.setForeground(new Color(254, 254, 254));
		lblNewLabel_1_2_1.setFont(SetFont.font1_());
		lblNewLabel_1_2_1.setBounds(330, 257, 97, 30);
		contentPane.add(lblNewLabel_1_2_1);

		tfDonGia = new JTextField();
		tfDonGia.setColumns(10);
		tfDonGia.setFont(SetFont.fontDetails());
		tfDonGia.setBounds(431, 257, 141, 30);
		contentPane.add(tfDonGia);

		labelIMG = new JLabel("Ảnh CPU");
		labelIMG.setHorizontalAlignment(SwingConstants.CENTER);
		labelIMG.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelIMG.setBounds(592, 57, 223, 230);
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
		btnUpload.setBounds(744, 290, 71, 21);
		contentPane.add(btnUpload);

		tfBaoHanh = new JTextField();
		tfBaoHanh.setFont(SetFont.fontDetails());
		tfBaoHanh.setColumns(10);
		tfBaoHanh.setBounds(147, 319, 141, 30);
		contentPane.add(tfBaoHanh);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Bảo hành");
		lblNewLabel_1_2_1_1.setForeground(new Color(254, 254, 254));
		lblNewLabel_1_2_1_1.setFont(SetFont.font1_());
		lblNewLabel_1_2_1_1.setBounds(21, 319, 83, 30);
		contentPane.add(lblNewLabel_1_2_1_1);

		tfLink = new JTextField("");
		tfLink.setFont(SetFont.fontDetails());
		tfLink.setColumns(10);
		tfLink.setBounds(431, 23, 329, 20);
		contentPane.add(tfLink);

		JLabel lblTnNgun_1_2_1 = new JLabel("Link hình ảnh:");
		lblTnNgun_1_2_1.setForeground(new Color(254, 254, 254));
		lblTnNgun_1_2_1.setFont(SetFont.font1_());
		lblTnNgun_1_2_1.setBounds(330, 25, 103, 21);
		contentPane.add(lblTnNgun_1_2_1);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insert = LoadIMGURL.setIMG(tfLink, labelIMG, insert);
			}
		});
		btnNewButton.setBounds(770, 23, 51, 20);
		contentPane.add(btnNewButton);
	}

	private void closeFrame() {
		this.dispose();
	}

	private boolean kiemTraIDCPU() {
		ArrayList<cpu> listCPU = cpuDAO.getInstance().selectAll();
		for (cpu cpu : listCPU) {
			if (cpu.getIdCpu().equals(tfIDCPU.getText())) {
				JOptionPane.showMessageDialog(null, "ID CPU đã tồn tại!");
				return true;
			}
		}
		return false;
	}

	private static void setDefaultIDCPU(ArrayList<cpu> arr) {
		int id = arr.size() + 1;
		String check = "";
		for (cpu cpu : arr) {
			if (cpu.getIdCpu().equals("cpu" + id)) {
				check = cpu.getIdCpu();
			}
		}
		while (check.length() != 0) {
			String c = check;
			id++;
			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i).getIdCpu().equals("cpu" + id)) {
					check = arr.get(i).getIdCpu();
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
		tfIDCPU.setText("cpu" + id);
	}

	private void addCPU() {
		if (kiemTraIDCPU()) {
			JOptionPane.showMessageDialog(null, "ID CPU đã tồn tại");
		} else {
			String url = tfLink.getText() + "";
			String id = (String) comboBox.getSelectedItem();
			String idcpu = tfIDCPU.getText();
			String ten = tfTenCPU.getText();
			String xungNhip = tfXungNhip.getText();
			int soNhan = Integer.parseInt(tfSoNhan.getText());
			int soLuong = Integer.parseInt(tfSoLuong.getText());
			String dienNang = tfDienNang.getText();
			String boNho = tfBoNhoDem.getText();
			double gia = Double.parseDouble(tfDonGia.getText());
			String baoHanh = tfBaoHanh.getText();

			cpu cc = new cpu(id, idcpu, ten, xungNhip, soNhan, soLuong, dienNang, boNho, 0, gia, baoHanh, null);

			if (insert.length() > 0 && url.length() > 0)
				JOptionPane.showMessageDialog(null, "Chỉ chọn được 1 trong 2 nguồn ảnh!");
			else {
				if (insert.equals("") && url.equals("")) {
					int check = cpuDAO.getInstance().insertNotIMG(cc);
					insert = Checked.checkedAdd(check, insert);
				} else {
					if (url.equals("")) {
						int check = cpuDAO.getInstance().insert(cc);
						insert = Checked.checkedAdd(check, insert);
					} else if (insert.equals("")) {
						int check = cpuDAO.getInstance().insertIMGURL(cc, url);
						insert = Checked.checkedAdd(check, insert);
					}
				}
				CPUForm.loadDataToTable(cpuDAO.getInstance().selectAll());
				closeFrame();
			}

		}

	}

	public static String getInsert() {
		return insert;
	}

	public static void setInsert(String insert) {
		ThemCPU.insert = insert;
	}

}
