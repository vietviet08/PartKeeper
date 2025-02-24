package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import color.SetColor;
import controller.FormatToVND;
import controller.IEExcel;
import controller.TimKiemPSU;
import dao.ChiTietPhieuXuatDAO;
import dao.SanPhamDAO;
import dao.psuDAO;
import decor.SetTitleForJF;
import font.SetFont;
import model.psu;

public class PSUForm extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JLabel labelTen;
	private JLabel labelIMG;
	private JLabel labelTien;
	private JLabel labelBaoHanh;
	private JTextArea txtrAbc;
	private static JTable table;
	private static DefaultTableModel tableModel;
//	idsanpham, idnguon, tennguon, hang, congsuat, chuannguon, kieuday, kichthuoc, tonkho, gia, baohanh
	private static final String[] columnName = { "ID sản phẩm", "ID nguồn", "Tên nguồn", "Hãng", "Công suất",
			"Chuẩn nguồn", "Kiểu dây", "Kích thước", "Tồn kho", "Giá" };
	private JLabel labelCongSuat;
	private JLabel labelChuanNguon;
	private JLabel labelKieuDay;
	private JLabel labelKichThuoc;
	private final String[] comboSort = { "Sắp xếp", "Tăng theo giá", "Giảm theo giá", "Tồn kho tăng", "Tồn kho giảm" };
	private final String[] comboSearch = columnName;
	private JComboBox<String> comboBoxSort;
	private JComboBox<String> comboBox;
	private JLabel labelLuot;
	private JLabel labelLuotBan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PSUForm frame = new PSUForm();
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
	public static void loadDataToTable(ArrayList<psu> psu) {
		try {
			tableModel.setRowCount(0);
			for (psu i : psu) {
				DefaultTableCellRenderer renderRight = new DefaultTableCellRenderer();
				renderRight.setHorizontalAlignment(JLabel.RIGHT);

				DefaultTableCellRenderer renderCenter = new DefaultTableCellRenderer();
				renderCenter.setHorizontalAlignment(JLabel.CENTER);

				table.getColumnModel().getColumn(4).setCellRenderer(renderCenter);
				table.getColumnModel().getColumn(5).setCellRenderer(renderCenter);
				table.getColumnModel().getColumn(7).setCellRenderer(renderCenter);
				table.getColumnModel().getColumn(8).setCellRenderer(renderCenter);
				table.getColumnModel().getColumn(9).setCellRenderer(renderRight);
				String gia = FormatToVND.vnd(i.getDonGia());
				tableModel.addRow(new Object[] { i.getIdSanPham(), i.getIdNguon(), i.getTenNguon(), i.getHang(),
						i.getCongSuat(), i.getChuanNguon(), i.getKieuDay(), i.getKichThuoc(), i.getTonKho(), gia });
			}
		} catch (Exception e) {
		}
	}

	public void setDefaultTable() {
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columnName);
		table.setDefaultEditor(Object.class, null);
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(500);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.getColumnModel().getColumn(5).setPreferredWidth(250);
		table.getColumnModel().getColumn(6).setPreferredWidth(250);
		table.getColumnModel().getColumn(7).setPreferredWidth(150);
		table.getColumnModel().getColumn(8).setPreferredWidth(100);
		table.getColumnModel().getColumn(9).setPreferredWidth(200);
		loadDataToTable(psuDAO.getInstance().selectAll());
	}

	public PSUForm() {
		SetTitleForJF.setTitle(this, "/icon/icons8-electrical-20.png");

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
				ThemPSU.main(null);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(PSUForm.class.getResource("/icon/icons8-add-24.png")));
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
					int check = JOptionPane.showConfirmDialog(null, "Bạn chắn chắn xóa sản phẩm này?", "Cảnh báo",
							JOptionPane.YES_NO_OPTION);
					if (check == JOptionPane.YES_OPTION)
						psuDAO.getInstance().delete(getPSUSelect());
				}
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(PSUForm.class.getResource("/icon/icons8-delete-24.png")));
		btnNewButton_2.setFont(SetFont.font());
		btnNewButton_2.setBounds(119, 8, 99, 33);
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Sửa");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectedRow() == -1)
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm để sửa!");
				else {
					CapNhatPSU.main(null);
				}
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(PSUForm.class.getResource("/icon/icons8-edit-24.png")));
		btnNewButton_3.setFont(SetFont.font());
		btnNewButton_3.setBounds(228, 8, 87, 33);
		panel.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Nhập Excel");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();

				int rowBanDau = model.getRowCount();

				File excelFile;
				FileInputStream excelFIS = null;
				BufferedInputStream excelBIS = null;
				XSSFWorkbook excelImportToJTable = null;
				String defaultCurrentDirectoryPath = "C:\\Users\\DELL\\Desktop";
				JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
				excelFileChooser.setDialogTitle("Select Excel File");
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
				excelFileChooser.setFileFilter(fnef);
				int excelChooser = excelFileChooser.showOpenDialog(null);
				if (excelChooser == JFileChooser.APPROVE_OPTION) {
					try {
						excelFile = excelFileChooser.getSelectedFile();
//		                jExcelFilePath.setText(excelFile.toString());
						excelFIS = new FileInputStream(excelFile);
						excelBIS = new BufferedInputStream(excelFIS);
						excelImportToJTable = new XSSFWorkbook(excelBIS);
						XSSFSheet excelSheet = excelImportToJTable.getSheetAt(0);

						for (int row = 1; row <= excelSheet.getLastRowNum(); row++) {
							XSSFRow excelRow = excelSheet.getRow(row);
							XSSFCell idsp = excelRow.getCell(0);
							XSSFCell idpsu = excelRow.getCell(1);
							XSSFCell ten = excelRow.getCell(2);
							XSSFCell hang = excelRow.getCell(3);
							XSSFCell congsuat = excelRow.getCell(4);
							XSSFCell chuannguon = excelRow.getCell(5);
							XSSFCell kieuday = excelRow.getCell(6);
							XSSFCell kichthuoc = excelRow.getCell(7);
							XSSFCell tonkho = excelRow.getCell(8);
							XSSFCell dongia = excelRow.getCell(9);

							model.addRow(new Object[] { idsp, idpsu, ten, hang, congsuat, chuannguon, kieuday,
									kichthuoc, tonkho, dongia });
						}
						JOptionPane.showMessageDialog(null, "Thêm thành công!");
						int answ = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm vào csdl không", "Thông báo",
								JOptionPane.YES_NO_OPTION);
						if (answ == JOptionPane.YES_OPTION) {
							for (int i = rowBanDau; i <= model.getRowCount(); i++) {

								String idsp = model.getValueAt(i, 0).toString();
								String idpsu = model.getValueAt(i, 1).toString();
								String ten = model.getValueAt(i, 2).toString();
								String hang = model.getValueAt(i, 3).toString();
								String congsuat = model.getValueAt(i, 4).toString();
								String chuannguon = model.getValueAt(i, 5).toString();
								String kieuday = model.getValueAt(i, 6).toString();
								String kichthuoc = model.getValueAt(i, 7).toString();
								int tonkho = (int) model.getValueAt(i, 8);
								double dongia = (double) model.getValueAt(i, 9);

								psu psu = new psu(idsp, idpsu, ten, hang, congsuat, chuannguon, kieuday, kichthuoc,
										tonkho, dongia, "", null);
								psuDAO.getInstance().insertNotIMG(psu);
							}
						}
					} catch (IOException iOException) {
						JOptionPane.showMessageDialog(null, iOException.getMessage());
					} finally {
						try {
							if (excelFIS != null) {
								excelFIS.close();
							}
							if (excelBIS != null) {
								excelBIS.close();
							}
							if (excelImportToJTable != null) {
								excelImportToJTable.close();
							}
						} catch (IOException iOException) {
							JOptionPane.showMessageDialog(null, iOException.getMessage());
						}
					}
				}
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(PSUForm.class.getResource("/icon/icons8-import-csv-24.png")));
		btnNewButton_4.setFont(SetFont.font());
		btnNewButton_4.setBounds(329, 8, 138, 33);
		panel.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Xuất Excel");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IEExcel.exportExcel(table, "Nguồn");
			}
		});
		btnNewButton_5.setIcon(new ImageIcon(PSUForm.class.getResource("/icon/icons8-export-excel-24.png")));
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
				psu psu = getPSUSelect();
				labelTen.setText(psu.getTenNguon());
				labelTien.setText(FormatToVND.vnd(psu.getDonGia()));
				labelBaoHanh.setText("Bảo hành: " + psu.getBaoHanh());
				txtrAbc.setText(SanPhamDAO.getInstance().selectById(psu.getIdSanPham()).getMoTa());
				labelCongSuat.setText("Công suất: " + psu.getCongSuat());
				labelChuanNguon.setText("Chuẩn nguồn: " + psu.getChuanNguon());
				labelKieuDay.setText(psu.getKieuDay());
				labelKichThuoc.setText("Kích thước: " + psu.getKichThuoc());
				labelLuotBan.setText(ChiTietPhieuXuatDAO.getInstance().tongDonXuatSPRieng(psu.getIdNguon()) + "");

				if (psu.getImg() == null) {
					labelIMG.setIcon(new ImageIcon(PSUForm.class.getResource("/icon/icons8-no-image-14.png")));
					labelIMG.setText("Sản phẩm hiện chưa có ảnh mẫu!");
				} else {
					Blob blob = psu.getImg();
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
		lblNewLabel_2.setIcon(new ImageIcon(PSUForm.class.getResource("/icon/search-24.png")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setBorder(null);
		lblNewLabel_2.setBounds(471, 15, 48, 22);
		panel_1.add(lblNewLabel_2);

		comboBox = new JComboBox<String>(comboSearch);
		comboBox.setFont(SetFont.font());
		comboBox.setBounds(146, 8, 89, 33);
		panel_1.add(comboBox);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String src = comboBox.getSelectedItem().toString();
//				 "ID sản phẩm", "ID nguồn", "Tên nguồn", "Hãng", "Công suất",
//				"Chuẩn nguồn", "Kiểu dây", "Kích thước", "Tồn kho", "Giá"
				if (src.equals("ID sản phẩm"))
					loadDataToTable(TimKiemPSU.byIDSP(textField.getText()));
				else if (src.equals("ID sản phẩm"))
					loadDataToTable(TimKiemPSU.byIDPSU(textField.getText()));
				else if (src.equals("ID nguồn"))
					loadDataToTable(TimKiemPSU.byTen(textField.getText()));
				else if (src.equals("Tên nguồn"))
					loadDataToTable(TimKiemPSU.byHang(textField.getText()));
				else if (src.equals("Công suất"))
					loadDataToTable(TimKiemPSU.byCongSuat(textField.getText()));
				else if (src.equals("Chuẩn nguồn"))
					loadDataToTable(TimKiemPSU.byChuanNguon(textField.getText()));
				else if (src.equals("Kiểu dây"))
					loadDataToTable(TimKiemPSU.byKieuDay(textField.getText()));
				else if (src.equals("Kích thước"))
					loadDataToTable(TimKiemPSU.byKichThuoc(textField.getText()));
				else if (src.equals("Tồn kho"))
					loadDataToTable(TimKiemPSU.byTonKho(textField.getText()));
				else if (src.equals("Giá"))
					loadDataToTable(TimKiemPSU.byDonGia(textField.getText()));

			}
		});
		textField.setFont(SetFont.font());
		textField.setColumns(10);
		textField.setBounds(248, 8, 277, 33);
		panel_1.add(textField);

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
		labelIMG.setIcon(new ImageIcon(PSUForm.class.getResource("/icon/icons8-no-image-14.png")));
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
		labelBaoHanh.setBounds(41, 436, 156, 23);
		panel_2.add(labelBaoHanh);

		labelTen = new JLabel("Tên PSU");
		labelTen.setFont(SetFont.fontCategory());
		labelTen.setBounds(30, 11, 341, 31);
		panel_2.add(labelTen);

		txtrAbc = new JTextArea();
		txtrAbc.setWrapStyleWord(true);
		txtrAbc.setOpaque(false);
		txtrAbc.setLineWrap(true);
		txtrAbc.setFont(SetFont.fontDetails_1());
		txtrAbc.setEditable(false);
		txtrAbc.setBounds(33, 470, 310, 167);
		panel_2.add(txtrAbc);

		labelCongSuat = new JLabel("Công suất: ");
		labelCongSuat.setFont(SetFont.fontDetails());
		labelCongSuat.setBounds(206, 406, 156, 14);
		panel_2.add(labelCongSuat);

		labelChuanNguon = new JLabel("Chuẩn nguồn");
		labelChuanNguon.setFont(SetFont.fontDetails());
		labelChuanNguon.setBounds(206, 421, 156, 14);
		panel_2.add(labelChuanNguon);

		labelKichThuoc = new JLabel("Kích thước: ");
		labelKichThuoc.setFont(SetFont.fontDetails());
		labelKichThuoc.setBounds(206, 451, 156, 14);
		panel_2.add(labelKichThuoc);

		labelKieuDay = new JLabel("Kiểu dây: ");
		labelKieuDay.setFont(SetFont.fontDetails());
		labelKieuDay.setBounds(206, 436, 156, 14);
		panel_2.add(labelKieuDay);

		labelLuot = new JLabel("Lượt bán: ");
		labelLuot.setFont(SetFont.fontDetails());
		labelLuot.setBounds(30, 35, 53, 14);
		panel_2.add(labelLuot);

		labelLuotBan = new JLabel("0");
		labelLuotBan.setForeground(new Color(64, 143, 221));
		labelLuotBan.setFont(SetFont.fontDetails());
		labelLuotBan.setBounds(85, 35, 51, 14);
		panel_2.add(labelLuotBan);
	}

	public static psu getPSUSelect() {
		return psuDAO.getInstance().selectById(table.getValueAt(table.getSelectedRow(), 1).toString());

	}

	private ArrayList<psu> sortGiaTangDan() {
		ArrayList<psu> list = psuDAO.getInstance().selectAll();

		Collections.sort(list, new Comparator<psu>() {

			@Override
			public int compare(psu o1, psu o2) {
				if (o1.getDonGia() > o2.getDonGia())
					return 1;
				if (o1.getDonGia() < o2.getDonGia())
					return -1;
				else
					return 0;
			}
		});
		return list;
	}

	private ArrayList<psu> sortGiaGiamDan() {
		ArrayList<psu> list = psuDAO.getInstance().selectAll();

		Collections.sort(list, new Comparator<psu>() {

			@Override
			public int compare(psu o1, psu o2) {
				if (o1.getDonGia() > o2.getDonGia())
					return -1;
				if (o1.getDonGia() < o2.getDonGia())
					return 1;
				else
					return 0;
			}
		});
		return list;
	}

	private ArrayList<psu> sortTonKhoTangDan() {
		ArrayList<psu> list = psuDAO.getInstance().selectAll();

		Collections.sort(list, new Comparator<psu>() {

			@Override
			public int compare(psu o1, psu o2) {
				if (o1.getTonKho() > o2.getTonKho())
					return 1;
				if (o1.getTonKho() < o2.getTonKho())
					return -1;
				else
					return 0;
			}
		});
		return list;
	}

	private ArrayList<psu> sortTonKhoGiamDan() {
		ArrayList<psu> list = psuDAO.getInstance().selectAll();

		Collections.sort(list, new Comparator<psu>() {

			@Override
			public int compare(psu o1, psu o2) {
				if (o1.getTonKho() > o2.getTonKho())
					return -1;
				if (o1.getTonKho() < o2.getTonKho())
					return 1;
				else
					return 0;
			}
		});
		return list;
	}
}
