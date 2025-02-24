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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import color.SetColor;
import dao.SanPhamDAO;
import font.SetFont;
import model.Products;

public class CapNhatProduct extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField tfTen;
	private static JTextField tfTrangThai;
	private static JTextArea txtMoTa;
//	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CapNhatProduct frame = new CapNhatProduct();
					frame.setVisible(true);
					setTextToTF();
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
	public CapNhatProduct() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 533, 310);
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
				 GradientPaint gp = new GradientPaint(0, 0,new Color(102,125,182), 0, getHeight(), new Color(0,130,200));
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, getWidth(), getHeight());

			}
		};

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics grphcs) {
				super.paintComponent(grphcs);
				Graphics2D g2d = (Graphics2D) grphcs;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				 GradientPaint gp = new GradientPaint(0, 0,new Color(102,125,182), 0, getHeight(), new Color(0,130,200));
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, getWidth(), getHeight());

			}
		};
		panel.setBounds(0, 0, 533, 310);
		panel.setBackground(SetColor.blueOp);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tên sản phẩm");
		lblNewLabel.setFont(SetFont.font1_());
		lblNewLabel.setForeground(SetColor.whiteFont);
		lblNewLabel.setBounds(36, 56, 173, 28);
		panel.add(lblNewLabel);

		tfTen = new JTextField();
		tfTen.setFont(SetFont.fontDetails());
		tfTen.setBorder(null);
		tfTen.setBounds(37, 78, 210, 28);
		panel.add(tfTen);
		tfTen.setColumns(10);

		JLabel lblIdNhPhn = new JLabel("Trạng thái");
		lblIdNhPhn.setFont(SetFont.font1_());
		lblIdNhPhn.setBounds(290, 56, 173, 28);
		lblIdNhPhn.setForeground(SetColor.whiteFont);
		panel.add(lblIdNhPhn);

		JLabel lblNewLabel_1_1 = new JLabel("Mô tả");
		lblNewLabel_1_1.setForeground(SetColor.whiteFont);
		lblNewLabel_1_1.setFont(SetFont.font1_());
		lblNewLabel_1_1.setBounds(37, 129, 173, 19);
		panel.add(lblNewLabel_1_1);

		JButton btnNewButton = new JButton("Cập nhật");
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					updateProduct();
				}
			}
		});
		btnNewButton.setBorder(null);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateProduct();
			}
		});
		btnNewButton.setFont(SetFont.font1());
		btnNewButton.setBounds(290, 192, 89, 34);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Hủy");
		btnNewButton_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					closeFrame();
				}
			}
		});
		btnNewButton_1.setBorder(null);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closeFrame();
			}
		});
		btnNewButton_1.setFont(SetFont.font1());
		btnNewButton_1.setBounds(411, 192, 89, 34);
		panel.add(btnNewButton_1);

		JLabel lblNewLabel_1 = new JLabel("CẬP NHẬT SẢN PHẨM");
		lblNewLabel_1.setFont(SetFont.fontTitle());
		lblNewLabel_1.setForeground(SetColor.yellow);
		lblNewLabel_1.setBounds(10, 11, 253, 28);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("© 2023 NGUYỄN QUỐC VIỆT - 23CE.B029");
		lblNewLabel_2.setFont(SetFont.font());
		lblNewLabel_2.setForeground(SetColor.copyRight);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(66, 279, 397, 19);
		panel.add(lblNewLabel_2);

		tfTrangThai = new JTextField();
		tfTrangThai.setColumns(10);
		tfTrangThai.setFont(SetFont.fontDetails());
		tfTrangThai.setBorder(null);
		tfTrangThai.setBounds(290, 78, 210, 28);
		panel.add(tfTrangThai);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 150, 210, 118);
		panel.add(scrollPane);
		
				txtMoTa = new JTextArea();
				scrollPane.setViewportView(txtMoTa);
				txtMoTa.setLineWrap(true);
				txtMoTa.setFont(SetFont.fontDetails());
				txtMoTa.setWrapStyleWord(true);
		contentPane.setLayout(null);
	}

	private void closeFrame() {
		this.dispose();
	}

	private static void setTextToTF() {
		Products pr = ProductForm.getProSelect();
		tfTen.setText(pr.getTenSanPham());
		tfTrangThai.setText(String.valueOf(pr.getTrangThai()));
		txtMoTa.setText(pr.getMoTa());
//		tfSoLuongTonKho.setText(String.valueOf(pr.getSoLuongTonKho()));
	}
	
	private void updateProduct() {
		if (tfTrangThai.getText().equals("") || tfTen.equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!");

		} else {
			Products old = ProductForm.getProSelect();

			String idsp = old.getIdSanPham();
			String tensp = tfTen.getText();
			int trangthai = Integer.parseInt(tfTrangThai.getText());
			String mota = txtMoTa.getText();

			Products p = new Products(idsp, tensp, trangthai, mota);

			SanPhamDAO.getInstance().update(p);

			JOptionPane.showInternalMessageDialog(null, "Cập nhật thành công!");
			ProductForm.loadDataToTable(SanPhamDAO.getInstance().selectAll());
			closeFrame();
		}
	}
}
