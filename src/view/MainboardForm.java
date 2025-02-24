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
import controller.TimKiemMainboard;
import dao.ChiTietPhieuXuatDAO;
import dao.SanPhamDAO;
import dao.mainDAO;
import decor.SetTitleForJF;
import font.SetFont;
import model.mainboard;

public class MainboardForm extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfSearch;
	private static JTable table;
	private static DefaultTableModel tableModel;
	private final String columName[] = { "ID sản phẩm", "ID mainboard", "Tên mainboard", "Hãng", "Hỗ trợ CPU",
			"Hỗ trợ RAM", "Kích thước", "Tồn kho", "Đơn giá" };
	private JLabel labelIMG;
	private JLabel labelTen;
	private JLabel labelTien;
	private JLabel labelBaoHanh;
	private JTextArea txtrAbc;
	private JLabel labelHoTroRAM;
	private JLabel labelHoTroCPU;
	private JLabel labelKichThuoc;
	private JComboBox<String> comboBoxSort;
	private JComboBox<String> comboBox;

	private final String[] comboSort = { "Sắp xếp", "Giá tăng dần", "Giá giảm dần", "Tồn kho tăng", "Tồn kho giảm" };
	private final String[] comboSearch = columName;
	private JLabel labelLuotBan;
	private JLabel labelLuot;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainboardForm frame = new MainboardForm();
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

	public static void loadDataToTable(ArrayList<mainboard> mainboard) {
		try {
			tableModel.setRowCount(0);
			for (mainboard i : mainboard) {
				DefaultTableCellRenderer renderRight = new DefaultTableCellRenderer();
				renderRight.setHorizontalAlignment(JLabel.RIGHT);

				DefaultTableCellRenderer renderCenter = new DefaultTableCellRenderer();
				renderCenter.setHorizontalAlignment(JLabel.CENTER);

				table.getColumnModel().getColumn(7).setCellRenderer(renderCenter);
				table.getColumnModel().getColumn(8).setCellRenderer(renderRight);

				String gia = FormatToVND.vnd(i.getDonGia());
				tableModel.addRow(new Object[] { i.getIdSanPham(), i.getIdMainboard(), i.getTenMain(), i.getTenHang(),
						i.getHoTroCPU(), i.getHoTroRAM(), i.getKichThuoc(), i.getTonKho(), gia });
			}
		} catch (Exception e) {
		}
	}

	public void setDefaultTable() {
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columName);
		table.setDefaultEditor(Object.class, null);
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(500);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setPreferredWidth(300);
		table.getColumnModel().getColumn(5).setPreferredWidth(300);
		table.getColumnModel().getColumn(6).setPreferredWidth(200);
		table.getColumnModel().getColumn(7).setPreferredWidth(100);
		table.getColumnModel().getColumn(8).setPreferredWidth(250);
		loadDataToTable(mainDAO.getInstance().selectAll());
	}

	public MainboardForm() {
		SetTitleForJF.setTitle(this, "/icon/icons8-motherboard-20.png");

		setBounds(100, 100, 1170, 730);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 630, 49);
		getContentPane().add(panel);

		JButton btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemMainboard.main(null);
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(MainboardForm.class.getResource("/icon/icons8-add-24.png")));
		btnNewButton_1.setFont(SetFont.font());
		btnNewButton_1.setBounds(10, 8, 99, 33);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectedRow() == -1)
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm để xóa!");
				else {
					int answ = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn xóa sản phẩm này!", "Cảnh báo",
							JOptionPane.YES_NO_OPTION);
					if (answ == JOptionPane.YES_OPTION) {
						mainDAO.getInstance().delete(getMainboardSellect());
						JOptionPane.showMessageDialog(null, "Xóa thành công");
						loadDataToTable(mainDAO.getInstance().selectAll());
					}
				}
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(MainboardForm.class.getResource("/icon/icons8-delete-24.png")));
		btnNewButton_2.setFont(SetFont.font());
		btnNewButton_2.setBounds(119, 8, 99, 33);
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Sửa");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectedRow() == -1)
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm để cập nhật!");
				else
					CapNhatMainboard.main(null);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(MainboardForm.class.getResource("/icon/icons8-edit-24.png")));
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
				String defaultCurrentDirectoryPath = "user.dir";
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
							XSSFCell idmb = excelRow.getCell(1);
							XSSFCell ten = excelRow.getCell(2);
							XSSFCell hang = excelRow.getCell(3);
							XSSFCell hotrocpu = excelRow.getCell(4);
							XSSFCell hotroram = excelRow.getCell(5);
							XSSFCell kichthuoc = excelRow.getCell(6);
							XSSFCell tonkho = excelRow.getCell(7);
							XSSFCell dongia = excelRow.getCell(8);

							model.addRow(new Object[] { idsp, idmb, ten, hang, hotrocpu, hotroram, kichthuoc, tonkho,
									dongia });
						}
						JOptionPane.showMessageDialog(null, "Thêm thành công!");
						int answ = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm vào csdl không", "Thông báo",
								JOptionPane.YES_NO_OPTION);
						if (answ == JOptionPane.YES_OPTION) {
							for (int i = rowBanDau; i <= model.getRowCount(); i++) {

								String idsp = model.getValueAt(i, 0).toString();
								String idmb = model.getValueAt(i, 1).toString();
								String ten = model.getValueAt(i, 2).toString();
								String hang = model.getValueAt(i, 3).toString();
								String hotrocpu = model.getValueAt(i, 4).toString();
								String hotroram = model.getValueAt(i, 5).toString();
								String kichthuoc = model.getValueAt(i, 6).toString();
								int tonkho = (int) model.getValueAt(i, 7);
								double dongia = (double) model.getValueAt(i, 8);

								mainboard mb = new mainboard(idsp, idmb, ten, hang, hotrocpu, hotroram, kichthuoc,
										tonkho, dongia, "", null);

								mainDAO.getInstance().insertNotIMG(mb);
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
		btnNewButton_4.setIcon(new ImageIcon(MainboardForm.class.getResource("/icon/icons8-import-csv-24.png")));
		btnNewButton_4.setFont(SetFont.font());
		btnNewButton_4.setBounds(329, 8, 138, 33);
		panel.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Xuất Excel");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IEExcel.exportExcel(table, "Mainboard");
			}
		});
		btnNewButton_5.setIcon(new ImageIcon(MainboardForm.class.getResource("/icon/icons8-export-excel-24.png")));
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
		table.getTableHeader().setFont(SetFont.font());
		table.getTableHeader().setBackground(SetColor.blueOp);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				mainboard mb = getMainboardSellect();

				mainboard mb = mainDAO.getInstance()
						.selectById(String.valueOf(table.getValueAt(table.getSelectedRow(), 1)));

				labelTen.setText(mb.getTenMain());
				labelTien.setText(FormatToVND.vnd(mb.getDonGia()));
				labelBaoHanh.setText("Bảo hành: " + mb.getBaoHanh());
				txtrAbc.setText(SanPhamDAO.getInstance().selectById(mb.getIdSanPham()).getMoTa());
				labelHoTroCPU.setText(mb.getHoTroCPU());
				labelHoTroRAM.setText(mb.getHoTroRAM());
				labelKichThuoc.setText(mb.getKichThuoc());
				labelLuotBan.setText(ChiTietPhieuXuatDAO.getInstance().tongDonXuatSPRieng(mb.getIdMainboard()) + "");
				if (mb.getImg() == null) {
					labelIMG.setIcon(null);
					labelIMG.setIcon(new ImageIcon(MainboardForm.class.getResource("/icon/icons8-no-image-14.png")));
					labelIMG.setText("Hiện sản phẩm chưa có ảnh mẫu");
				} else {
					Blob blob = mb.getImg();
					try {
						byte[] by = blob.getBytes(1, (int) blob.length());

						ImageIcon ii = new ImageIcon(by);
						Image i = ii.getImage().getScaledInstance(labelIMG.getWidth(), labelIMG.getHeight(),
								Image.SCALE_SMOOTH);
						ii = new ImageIcon(i);

						labelIMG.setBorder(null);
						labelIMG.setText("");
						labelIMG.setIcon(ii);

					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				}

			}
		});
		scrollPane.setViewportView(table);
		setDefaultTable();

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(635, 0, 527, 49);
		getContentPane().add(panel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(MainboardForm.class.getResource("/icon/search-24.png")));
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
				String src = comboBox.getSelectedItem().toString();
				// "ID sản phẩm", "ID mainboard", "Tên mainboard", "Hãng", "Hỗ trợ CPU",
				// "Hỗ trợ RAM", "Kích thước", "Tồn kho", "Đơn giá"

				if (src.equals("ID sản phẩm"))
					loadDataToTable(TimKiemMainboard.byIDSP(tfSearch.getText()));
				else if (src.equals("ID mainboard"))
					loadDataToTable(TimKiemMainboard.byIDMB(tfSearch.getText()));
				else if (src.equals("Tên mainboard"))
					loadDataToTable(TimKiemMainboard.byTen(tfSearch.getText()));
				else if (src.equals("Hãng"))
					loadDataToTable(TimKiemMainboard.byHang(tfSearch.getText()));
				else if (src.equals("Hỗ trợ CPU"))
					loadDataToTable(TimKiemMainboard.byHoTroCPU(tfSearch.getText()));
				else if (src.equals("Hỗ trợ RAM"))
					loadDataToTable(TimKiemMainboard.byHoTroRAM(tfSearch.getText()));
				else if (src.equals("Kích thước"))
					loadDataToTable(TimKiemMainboard.byKichThuoc(tfSearch.getText()));
				else if (src.equals("Tồn kho"))
					loadDataToTable(TimKiemMainboard.byTonKho(tfSearch.getText()));
				else if (src.equals("Đơn giá"))
					loadDataToTable(TimKiemMainboard.byDonGia(tfSearch.getText()));

			}
		});
		tfSearch.setColumns(10);
		tfSearch.setBounds(248, 8, 277, 33);
		panel_1.add(tfSearch);

		comboBoxSort = new JComboBox<String>(comboSort);
		comboBoxSort.setFont(SetFont.font());
		comboBoxSort.setBounds(0, 8, 125, 32);
		comboBoxSort.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String src = comboBoxSort.getSelectedItem().toString();
				if (src.equals("Giá tăng dần"))
					loadDataToTable(sortByGiaTangDan());
				else if (src.equals("Giá giảm dần"))
					loadDataToTable(sortByGiaGiamDan());
				else if (src.equals("Tồn kho tăng"))
					loadDataToTable(sortByTonKhoTang());
				else if (src.equals("Tồn kho giảm"))
					loadDataToTable(sortByTonKhoGiam());
			}
		});
		panel_1.add(comboBoxSort);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(790, 53, 372, 648);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);

		labelIMG = new JLabel("Ảnh sản phẩm");
		labelIMG.setFont(SetFont.font());
		labelIMG.setIcon(new ImageIcon(MainboardForm.class.getResource("/icon/icons8-no-image-14.png")));
		labelIMG.setHorizontalAlignment(SwingConstants.CENTER);
		labelIMG.setBorder(null);
		labelIMG.setBounds(12, 50, 350, 350);
		panel_2.add(labelIMG);

		labelTien = new JLabel("0 đ");
		labelTien.setForeground(new Color(190, 14, 30));
		labelTien.setFont(SetFont.font1());
		labelTien.setBounds(41, 402, 153, 23);
		panel_2.add(labelTien);

		labelBaoHanh = new JLabel("Bảo hành");
		labelBaoHanh.setFont(SetFont.font1());
		labelBaoHanh.setBounds(41, 436, 153, 23);
		panel_2.add(labelBaoHanh);

		labelTen = new JLabel("Tên mainboard");
		labelTen.setFont(SetFont.fontCategory());
		labelTen.setBounds(30, 8, 342, 31);
		panel_2.add(labelTen);

		txtrAbc = new JTextArea();
		txtrAbc.setBounds(33, 470, 329, 167);
		panel_2.add(txtrAbc);
		txtrAbc.setWrapStyleWord(true);
		txtrAbc.setOpaque(false);
		txtrAbc.setLineWrap(true);
		txtrAbc.setFont(SetFont.fontDetails_1());
		txtrAbc.setEditable(false);

		labelHoTroCPU = new JLabel("");
		labelHoTroCPU.setFont(SetFont.fontDetails());
		labelHoTroCPU.setBounds(202, 406, 160, 14);
		panel_2.add(labelHoTroCPU);

		labelHoTroRAM = new JLabel("");
		labelHoTroRAM.setFont(SetFont.fontDetails());
		labelHoTroRAM.setBounds(202, 423, 160, 14);
		panel_2.add(labelHoTroRAM);

		labelKichThuoc = new JLabel("");
		labelKichThuoc.setFont(SetFont.fontDetails());
		labelKichThuoc.setBounds(202, 440, 160, 14);
		panel_2.add(labelKichThuoc);

		labelLuotBan = new JLabel("0");
		labelLuotBan.setForeground(new Color(64, 143, 221));
		labelLuotBan.setFont(SetFont.fontDetails());
		labelLuotBan.setBounds(85, 33, 51, 14);
		panel_2.add(labelLuotBan);

		labelLuot = new JLabel("Lượt bán: ");
		labelLuot.setFont(SetFont.fontDetails());
		labelLuot.setBounds(30, 33, 53, 14);
		panel_2.add(labelLuot);
	}

	public static mainboard getMainboardSellect() {
		return mainDAO.getInstance().selectAll().get(table.getSelectedRow());
	}

	private ArrayList<mainboard> sortByGiaTangDan() {
		ArrayList<mainboard> mb = mainDAO.getInstance().selectAll();
		ArrayList<mainboard> list = new ArrayList<mainboard>();
		for (mainboard mainboard : mb) {
			list.add(mainboard);
		}
		Collections.sort(list, new Comparator<mainboard>() {

			@Override
			public int compare(mainboard o1, mainboard o2) {
				if (o1.getDonGia() > o2.getDonGia())
					return 1;
				else if (o1.getDonGia() < o2.getDonGia())
					return -1;
				return 0;
			}
		});
		return list;
	}

	private ArrayList<mainboard> sortByGiaGiamDan() {
		ArrayList<mainboard> mb = mainDAO.getInstance().selectAll();
		ArrayList<mainboard> list = new ArrayList<mainboard>();
		for (mainboard mainboard : mb) {
			list.add(mainboard);
		}
		Collections.sort(list, new Comparator<mainboard>() {

			@Override
			public int compare(mainboard o1, mainboard o2) {
				if (o1.getDonGia() > o2.getDonGia())
					return -1;
				else if (o1.getDonGia() < o2.getDonGia())
					return 1;
				return 0;
			}
		});
		return list;
	}

	private ArrayList<mainboard> sortByTonKhoTang() {
		ArrayList<mainboard> mb = mainDAO.getInstance().selectAll();
		ArrayList<mainboard> list = new ArrayList<mainboard>();
		for (mainboard mainboard : mb) {
			list.add(mainboard);
		}
		Collections.sort(list, new Comparator<mainboard>() {

			@Override
			public int compare(mainboard o1, mainboard o2) {
				if (o1.getTonKho() > o2.getTonKho())
					return 1;
				else if (o1.getTonKho() < o2.getTonKho())
					return -1;
				return 0;
			}
		});
		return list;
	}

	private ArrayList<mainboard> sortByTonKhoGiam() {
		ArrayList<mainboard> mb = mainDAO.getInstance().selectAll();
		ArrayList<mainboard> list = new ArrayList<mainboard>();
		for (mainboard mainboard : mb) {
			list.add(mainboard);
		}
		Collections.sort(list, new Comparator<mainboard>() {

			@Override
			public int compare(mainboard o1, mainboard o2) {
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
