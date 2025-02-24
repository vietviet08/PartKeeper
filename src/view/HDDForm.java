package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import color.SetColor;
import controller.FormatToVND;
import controller.TimKiemHDD;
import dao.ChiTietPhieuXuatDAO;
import dao.SanPhamDAO;
import dao.hddDAO;
import decor.SetTitleForJF;
import font.SetFont;
import model.hdd;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class HDDForm extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfSearch;
	private JLabel labelTocDoVongQuay;
	private JLabel labelBoNhoDem;
	private JLabel labelDungLuong;
	private JTextArea txtrAbc;
	private JLabel labelTen;
	private JLabel labelBaoHanh;
	private JLabel labelTien;
	private JLabel labelIMG;
	private static JTable table;
	private static DefaultTableModel tableModel;
	private final String columnName[] = { "ID Sản phẩm", "ID HDD", "Tên HDD", "Hãng", "Dung lượng", "Bộ nhớ đệm",
			"Tốc độ vòng quay", "Tồn kho", "Bảo hành", "Đơn giá" };
	private JComboBox<String> comboBoxSort;
	private JComboBox<String> comboBox;

	private final String[] comboSearch = columnName;
	private final String[] comboSort = { "Sắp xếp", "Tăng theo giá", "Giảm theo giá", "Tồn kho tăng", "Tồn kho giảm" };
	private JLabel labelLuot;
	private JLabel labelLuotBan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HDDForm frame = new HDDForm();
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
	public static void loadDataToTable(ArrayList<hdd> hdd) {
		try {
			tableModel.setRowCount(0);
			for (hdd i : hdd) {
				DefaultTableCellRenderer renderRight = new DefaultTableCellRenderer();
				renderRight.setHorizontalAlignment(JLabel.RIGHT);

				DefaultTableCellRenderer renderCenter = new DefaultTableCellRenderer();
				renderCenter.setHorizontalAlignment(JLabel.CENTER);
				table.getColumnModel().getColumn(7).setCellRenderer(renderCenter);
				table.getColumnModel().getColumn(9).setCellRenderer(renderRight);
				String gia = FormatToVND.vnd(i.getGia());
				tableModel.addRow(new Object[] { i.getIdSanPham(), i.getIdhHdd(), i.getTenHdd(), i.getHang(),
						i.getDungLuong(), i.getBoNhoDem(), i.getTocDoVongQuay(), i.getTonKho(), i.getBaoHanh(), gia });
			}
		} catch (Exception e) {
		}
	}

	public void setDefaultTable() {
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columnName);
		table.setDefaultEditor(Object.class, null);
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(500);
		table.getColumnModel().getColumn(3).setPreferredWidth(250);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(250);
		table.getColumnModel().getColumn(7).setPreferredWidth(120);
		table.getColumnModel().getColumn(8).setPreferredWidth(200);
		table.getColumnModel().getColumn(9).setPreferredWidth(200);
		loadDataToTable(hddDAO.getInstance().selectAll());
	}

	public HDDForm() {
		SetTitleForJF.setTitle(this, "/icon/icons8-hdd-20.png");

		setBounds(100, 100, 1170, 730);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 630, 49);
		getContentPane().add(panel);

		JButton btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ThemHDD.main(null);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(HDDForm.class.getResource("/icon/icons8-add-24.png")));
		btnNewButton_1.setFont(SetFont.font());
		btnNewButton_1.setBounds(10, 8, 99, 33);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectedRow() == -1)
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm để xóa!");
				else {
					int check = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn xóa sản phẩm này?");
					if (check == JOptionPane.YES_OPTION) {
						hddDAO.getInstance().delete(getHddSelect());
						loadDataToTable(hddDAO.getInstance().selectAll());

					}
				}
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(HDDForm.class.getResource("/icon/icons8-delete-24.png")));
		btnNewButton_2.setFont(SetFont.font());
		btnNewButton_2.setBounds(119, 8, 99, 33);
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Sửa");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectedRow() == -1)
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm để sửa!");
				else
					CapNhatHDD.main(null);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(HDDForm.class.getResource("/icon/icons8-edit-24.png")));
		btnNewButton_3.setFont(SetFont.font());
		btnNewButton_3.setBounds(228, 8, 87, 33);
		panel.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Nhập Excel");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(HDDForm.class.getResource("/icon/icons8-import-csv-24.png")));
		btnNewButton_4.setFont(SetFont.font());
		btnNewButton_4.setBounds(329, 8, 138, 33);
		panel.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Xuất Excel");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_5.setIcon(new ImageIcon(HDDForm.class.getResource("/icon/icons8-export-excel-24.png")));
		btnNewButton_5.setFont(SetFont.font());
		btnNewButton_5.setBounds(477, 8, 142, 33);
		panel.add(btnNewButton_5);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 53, 780, 648);
		getContentPane().add(scrollPane);

		table = new JTable() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component returnComp = super.prepareRenderer(renderer, row, column);
				if (!returnComp.getBackground().equals(getSelectionBackground())) {
					Color bg = (row % 2 == 0 ? SetColor.blueBaby : Color.WHITE);
					returnComp.setBackground(bg);
					bg = null;
				}
				return returnComp;
			}
		};
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				hdd hdd = getHddSelect();

				labelTen.setText(hdd.getTenHdd());
				labelBaoHanh.setText("Bảo hành: " + hdd.getBaoHanh());
				labelTien.setText(FormatToVND.vnd(hdd.getGia()));
				labelBoNhoDem.setText(hdd.getBoNhoDem());
				labelDungLuong.setText(hdd.getDungLuong());
				labelTocDoVongQuay.setText(hdd.getTocDoVongQuay());
				labelLuotBan.setText(ChiTietPhieuXuatDAO.getInstance().tongDonXuatSPRieng(hdd.getIdhHdd()) + "");
				txtrAbc.setText(SanPhamDAO.getInstance().selectById(hdd.getIdSanPham()).getMoTa());

				if (hdd.getImg() == null) {
					labelIMG.setIcon(new ImageIcon(HDDForm.class.getResource("/icon/icons8-no-image-14.png")));
					labelIMG.setText("Sản phẩm hiện chưa có ảnh mẫu");
				} else {
					Blob blob = hdd.getImg();
					try {
						byte[] by = blob.getBytes(1, (int) blob.length());
						ImageIcon ii = new ImageIcon(by);
						Image i = ii.getImage().getScaledInstance(labelIMG.getWidth(), labelIMG.getHeight(),
								Image.SCALE_SMOOTH);
						ii = new ImageIcon(i);
						labelIMG.setIcon(ii);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		table.getTableHeader().setFont(SetFont.font());
		table.getTableHeader().setBackground(SetColor.blueOp);
		scrollPane.setViewportView(table);
		setDefaultTable();

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(635, 0, 527, 49);
		getContentPane().add(panel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(HDDForm.class.getResource("/icon/search-24.png")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setBorder(null);
		lblNewLabel_2.setBounds(471, 15, 48, 22);
		panel_1.add(lblNewLabel_2);

		comboBox = new JComboBox<String>(comboSearch);
		comboBox.setFont(SetFont.font());
		comboBox.setBounds(146, 8, 89, 33);
		panel_1.add(comboBox);

		tfSearch = new JTextField();
		tfSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
//				"ID Sản phẩm", "ID HDD", "Tên HDD", "Hãng", "Dung lượng", "Bộ nhớ đệm",
//				"Tốc độ vòng quay", "Tồn kho", "Bảo hành", "Đơn giá"
				String src = comboBox.getSelectedItem().toString();
				switch (src) {
				case "ID Sản phẩm":
					loadDataToTable(TimKiemHDD.getInstance().byIDSP(tfSearch.getText()));
					break;
				case "ID HDD":
					loadDataToTable(TimKiemHDD.getInstance().byIDRieng(tfSearch.getText()));
					break;
				case "Tên HDD":
					loadDataToTable(TimKiemHDD.getInstance().byTen(tfSearch.getText()));
					break;
				case "Hãng":
					loadDataToTable(TimKiemHDD.getInstance().byHang(tfSearch.getText()));
					break;
				case "Dung lượng":
					loadDataToTable(TimKiemHDD.getInstance().byDungLuong(tfSearch.getText()));
					break;
				case "Bộ nhớ đệm":
					loadDataToTable(TimKiemHDD.getInstance().byBoNhoDem(tfSearch.getText()));
					break;
				case "Tốc độ vòng quay":
					loadDataToTable(TimKiemHDD.getInstance().byTocDoVongQuay(tfSearch.getText()));
					break;
				case "Tồn kho":
					loadDataToTable(TimKiemHDD.getInstance().byTonKho(tfSearch.getText()));
					break;
				case "Bảo hành":
					loadDataToTable(TimKiemHDD.getInstance().byBaoHanh(tfSearch.getText()));
					break;
				case "Đơn giá":
					loadDataToTable(TimKiemHDD.getInstance().byGia(tfSearch.getText()));
					break;

				default:
					break;
				}
			}
		});
		tfSearch.setFont(SetFont.fontDetails());
		tfSearch.setColumns(10);
		tfSearch.setBounds(248, 8, 277, 33);
		panel_1.add(tfSearch);

		comboBoxSort = new JComboBox<String>(comboSort);
		comboBoxSort.setFont(SetFont.font());
		comboBoxSort.setBounds(0, 8, 125, 33);
		comboBoxSort.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String src = comboBoxSort.getSelectedItem().toString();
				if (src.equals("Tăng theo giá"))
					loadDataToTable(sortGiaTangDan());
				else if (src.equals("Giảm theo giá"))
					loadDataToTable(sortGiaGiamDan());
				else if (src.equals("Tồn kho tăng"))
					loadDataToTable(sortTonKhoTangDan());
				else if (src.equals("Tồn kho giảm"))
					loadDataToTable(sortTonKhoGiamDan());
			}
		});
		panel_1.add(comboBoxSort);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(790, 53, 372, 648);
		getContentPane().add(panel_2);

		labelIMG = new JLabel("Ảnh sản phẩm");
		labelIMG.setIcon(new ImageIcon(HDDForm.class.getResource("/icon/icons8-no-image-14.png")));
		labelIMG.setHorizontalAlignment(SwingConstants.CENTER);
		labelIMG.setFont(SetFont.font());
		labelIMG.setBorder(null);
		labelIMG.setBounds(12, 50, 350, 350);
		panel_2.add(labelIMG);

		labelTien = new JLabel("0 đ");
		labelTien.setForeground(new Color(190, 14, 30));
		labelTien.setFont(SetFont.font1());
		labelTien.setBounds(41, 402, 131, 23);
		panel_2.add(labelTien);

		labelBaoHanh = new JLabel("Bảo hành");
		labelBaoHanh.setFont(SetFont.font1());
		labelBaoHanh.setBounds(41, 436, 178, 23);
		panel_2.add(labelBaoHanh);

		labelTen = new JLabel("Tên HDD");
		labelTen.setFont(SetFont.fontCategory());
		labelTen.setBounds(30, 11, 341, 31);
		panel_2.add(labelTen);

		txtrAbc = new JTextArea();
		txtrAbc.setWrapStyleWord(true);
		txtrAbc.setOpaque(false);
		txtrAbc.setLineWrap(true);
		txtrAbc.setFont(SetFont.fontDetails_1());
		txtrAbc.setEditable(false);
		txtrAbc.setBounds(33, 461, 329, 187);
		panel_2.add(txtrAbc);

		labelDungLuong = new JLabel("");
		labelDungLuong.setFont(SetFont.fontDetails());
		labelDungLuong.setBounds(218, 402, 144, 14);
		panel_2.add(labelDungLuong);

		labelBoNhoDem = new JLabel("");
		labelBoNhoDem.setFont(SetFont.fontDetails());
		labelBoNhoDem.setBounds(218, 422, 144, 14);
		panel_2.add(labelBoNhoDem);

		labelTocDoVongQuay = new JLabel("");
		labelTocDoVongQuay.setFont(SetFont.fontDetails());
		labelTocDoVongQuay.setBounds(218, 440, 144, 14);
		panel_2.add(labelTocDoVongQuay);

		labelLuot = new JLabel("Lượt bán: ");
		labelLuot.setFont(SetFont.fontDetails());
		labelLuot.setBounds(30, 38, 53, 14);
		panel_2.add(labelLuot);

		labelLuotBan = new JLabel("0");
		labelLuotBan.setForeground(new Color(64, 143, 221));
		labelLuotBan.setFont(SetFont.fontDetails());
		labelLuotBan.setBounds(85, 38, 51, 14);
		panel_2.add(labelLuotBan);

	}

	public static hdd getHddSelect() {
		return hddDAO.getInstance().selectById(table.getValueAt(table.getSelectedRow(), 1).toString());
	}

	private ArrayList<hdd> sortGiaTangDan() {
		ArrayList<hdd> list = hddDAO.getInstance().selectAll();
		Collections.sort(list, new Comparator<hdd>() {

			@Override
			public int compare(hdd o1, hdd o2) {
				if (o1.getGia() > o2.getGia())
					return 1;
				else if (o1.getGia() < o2.getGia())
					return -1;
				return 0;
			}
		});
		return list;
	}

	private ArrayList<hdd> sortGiaGiamDan() {
		ArrayList<hdd> list = hddDAO.getInstance().selectAll();
		Collections.sort(list, new Comparator<hdd>() {

			@Override
			public int compare(hdd o1, hdd o2) {
				if (o1.getGia() > o2.getGia())
					return -1;
				else if (o1.getGia() < o2.getGia())
					return 1;
				return 0;
			}
		});
		return list;
	}

	private ArrayList<hdd> sortTonKhoTangDan() {
		ArrayList<hdd> list = hddDAO.getInstance().selectAll();
		Collections.sort(list, new Comparator<hdd>() {

			@Override
			public int compare(hdd o1, hdd o2) {
				if (o1.getTonKho() > o2.getTonKho())
					return 1;
				else if (o1.getTonKho() < o2.getTonKho())
					return -1;
				return 0;
			}
		});
		return list;
	}

	private ArrayList<hdd> sortTonKhoGiamDan() {
		ArrayList<hdd> list = hddDAO.getInstance().selectAll();
		Collections.sort(list, new Comparator<hdd>() {

			@Override
			public int compare(hdd o1, hdd o2) {
				if (o1.getTonKho() > o2.getTonKho())
					return -1;
				else if (o1.getTonKho() < o2.getTonKho())
					return 1;
				return 0;
			}
		});
		return list;
	}
}
