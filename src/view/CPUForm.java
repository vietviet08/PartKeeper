package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
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

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
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
import controller.TimKiemCPU;
import dao.ChiTietPhieuXuatDAO;
import dao.SanPhamDAO;
import dao.cpuDAO;
import decor.SetTitleForJF;
import font.SetFont;
import model.cpu;

public class CPUForm extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4185848334864650430L;
	private static JTable table;
	private static DefaultTableModel tableModel;
	private final String columName[] = { "ID sản phẩm", "ID CPU", "Tên CPU", "Xung nhịp", "Số nhân", "Số luồng",
			"Điện năng tiêu thụ", "Bộ nhớ đệm", "Tồn kho", "Đơn giá" };
	private JTextField textField;
	public Font font;
	public Font font_1;
	public Font font1;
	public Font font2;
	private JComboBox<String> comboBoxSort;
	private JLabel labelTen;
	private JLabel labelIMG;
	private JLabel labelTien;
	private JLabel labelBaoHanh;
	private JTextArea txtrAbc;
	private JLabel labelXungNhip;
	private JLabel labelSoLuong;
	private JLabel labelDienNang;
	private JLabel labelSoNhan;
	private JLabel labelBoNhoDem;
	private JLabel labelLuot;
	private JLabel labelLuotBan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CPUForm frame = new CPUForm();
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

	public static void loadDataToTable(ArrayList<cpu> cpu) {
		try {
			tableModel.setRowCount(0);
			for (cpu i : cpu) {
				// set text column don gia ben phai
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
				tableModel.addRow(new Object[] { i.getIdSanPham(), i.getIdCpu(), i.getNameCpu(), i.getXungNhip(),
						i.getSoNhan(), i.getSoLuong(), i.getDienNangTieuThu(), i.getBoNhoDem(), i.getTonKho(), gia });
			}
		} catch (Exception e) {
		}
	}

	public void setDefaultTable() {
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columName);
		table.setDefaultEditor(Object.class, null);
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(500);
		table.getColumnModel().getColumn(3).setPreferredWidth(500);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(250);
		table.getColumnModel().getColumn(7).setPreferredWidth(250);
		table.getColumnModel().getColumn(8).setPreferredWidth(150);
		table.getColumnModel().getColumn(9).setPreferredWidth(300);
		loadDataToTable(cpuDAO.getInstance().selectAll());
	}

	public CPUForm() {
		SetTitleForJF.setTitle(this, "/icon/icons8-cpu-20.png");

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		try {
			File fontStyle = new File("src/font/Roboto-Medium.ttf");
			font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(11f);
			font_1 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(14f);
			font1 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(16f);
			font2 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(22f);

		} catch (Exception e) {
			System.out.println(e);
		}

		setBounds(100, 100, 1200 - 30, 730);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 630, 49);
		getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ThemCPU.main(null);
			}
		});
		btnNewButton_1.setFont(font);
		btnNewButton_1.setIcon(new ImageIcon(CPUForm.class.getResource("/icon/icons8-add-24.png")));
		btnNewButton_1.setBounds(10, 8, 99, 33);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn CPU để xóa");
				} else {
					int answ = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa không?", "Cảnh báo",
							JOptionPane.YES_NO_OPTION);

					if (answ == JOptionPane.YES_OPTION) {
						cpu cpu = getSelectCPU();
						cpuDAO.getInstance().delete(cpu);
						JOptionPane.showMessageDialog(null, "Xóa thành công!");
					}
				}
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(CPUForm.class.getResource("/icon/icons8-delete-24.png")));
		btnNewButton_2.setFont(font);
		btnNewButton_2.setBounds(119, 8, 99, 33);
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Sửa");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn cpu muốn sửa!");
				} else {
					CapNhatCPU.main(null);
				}

			}
		});
		btnNewButton_3.setIcon(new ImageIcon(CPUForm.class.getResource("/icon/icons8-edit-24.png")));
		btnNewButton_3.setFont(font);
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
							XSSFCell idcpu = excelRow.getCell(1);
							XSSFCell ten = excelRow.getCell(2);
							XSSFCell xn = excelRow.getCell(3);
							XSSFCell sonhan = excelRow.getCell(4);
							XSSFCell soluong = excelRow.getCell(5);
							XSSFCell diennang = excelRow.getCell(6);
							XSSFCell bonho = excelRow.getCell(7);
							XSSFCell tonkho = excelRow.getCell(8);
							XSSFCell dongia = excelRow.getCell(9);
							XSSFCell baohanh = excelRow.getCell(10);

							model.addRow(new Object[] { idsp, idcpu, ten, xn, sonhan, soluong, diennang, bonho, tonkho,
									dongia, baohanh });
						}
						JOptionPane.showMessageDialog(null, "Thêm thành công!");
						int answ = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm vào csdl không", "Thông báo",
								JOptionPane.YES_NO_OPTION);
						if (answ == JOptionPane.YES_OPTION) {
							for (int i = rowBanDau; i <= model.getRowCount(); i++) {

								String idsp = model.getValueAt(i, 0).toString();
								String idcpu = model.getValueAt(i, 1).toString();
								String ten = model.getValueAt(i, 2).toString();
								String xn = model.getValueAt(i, 3).toString();
								int sonhan = (int) model.getValueAt(i, 4);
								int soluong = (int) model.getValueAt(i, 5);
								String dien = model.getValueAt(i, 6).toString();
								String bonho = model.getValueAt(i, 7).toString();
								int tonkho = (int) model.getValueAt(i, 8);
								double dongia = (double) model.getValueAt(i, 9);
								String baohanh = model.getValueAt(i, 10).toString();

								cpu cp = new cpu(idsp, idcpu, ten, xn, sonhan, soluong, dien, bonho, tonkho, dongia,
										baohanh, null);

								cpuDAO.getInstance().insertNotIMG(cp);

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
		btnNewButton_4.setIcon(new ImageIcon(CPUForm.class.getResource("/icon/icons8-import-csv-24.png")));
		btnNewButton_4.setFont(font);
		btnNewButton_4.setBounds(329, 8, 138, 33);
		panel.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Xuất Excel");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				IEExcel.exportExcel(table, "CPU");

			}
		});
		btnNewButton_5.setIcon(new ImageIcon(CPUForm.class.getResource("/icon/icons8-export-excel-24.png")));
		btnNewButton_5.setFont(font);
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

//				cpu c = getSelectCPU();
				cpu c = cpuDAO.getInstance().selectById(String.valueOf(table.getValueAt(table.getSelectedRow(), 1)));

				labelTen.setText(c.getNameCpu());
				labelBaoHanh.setText("Bảo hành: " + c.getBaoHanh());
				labelTien.setText(FormatToVND.vnd(c.getDonGia()));
				labelXungNhip.setText("Xung nhịp: " + c.getXungNhip());
				labelSoNhan.setText("Số nhân: " + c.getSoNhan());
				labelSoLuong.setText("Số luồng: " + c.getSoLuong());
				labelDienNang.setText("Điện năng tiêu thụ: " + c.getDienNangTieuThu());
				labelBoNhoDem.setText("Bộ nhớ đệm: " + c.getBoNhoDem());
				labelLuotBan.setText(ChiTietPhieuXuatDAO.getInstance().tongDonXuatSPRieng(c.getIdCpu()) + "");

				txtrAbc.setText(SanPhamDAO.getInstance().selectById(c.getIdSanPham()).getMoTa());

				if (c.getImg() == null) {
					labelIMG.setIcon(null);
					labelIMG.setIcon(new ImageIcon(MainboardForm.class.getResource("/icon/icons8-no-image-14.png")));
					labelIMG.setText("Sản phẩm hiện chưa có ảnh mẫu!");
				} else {
					Blob blob = c.getImg();
					try {
						byte[] by = blob.getBytes(1, (int) blob.length());
						ImageIcon ii = new ImageIcon(by);
						Image i = ii.getImage().getScaledInstance(labelIMG.getWidth(), labelIMG.getHeight(),
								Image.SCALE_SMOOTH);
						ii = new ImageIcon(i);
						labelIMG.setText("");
						labelIMG.setBorder(null);
						labelIMG.setIcon(ii);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		table.getTableHeader().setBackground(SetColor.blueOp);
		table.getTableHeader().setFont(SetFont.fontHeaderTable());
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "New column", "New column", "New column",
				"New column", "New column", "New column", "New column", "New column", "New column", "New column" }));
		scrollPane.setViewportView(table);

		setDefaultTable();

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(635, 0, 527, 49);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBorder(null);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setIcon(new ImageIcon(CPUForm.class.getResource("/icon/search-24.png")));
		lblNewLabel_2.setBounds(471, 15, 48, 22);
		panel_1.add(lblNewLabel_2);
		comboBox.setFont(font);
		comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID sản phẩm", "ID CPU", "Tên CPU",
				"Xung nhịp", "Số nhân", "Số luồng", "Điện năng tiêu thụ", "Bộ nhớ đệm", "Tồn kho", "Đơn giá" }));
		comboBox.setBounds(146, 8, 89, 33);
		panel_1.add(comboBox);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				ArrayList<cpu> list = new ArrayList<cpu>();

				String choose = comboBox.getSelectedItem().toString();
				String key = textField.getText();
				if (choose.equals("ID sản phẩm")) {
					list = TimKiemCPU.byID(key);
				} else if (choose.equals("Tên CPU")) {
					list = TimKiemCPU.byTen(key);
				} else if (choose.equals("Xung nhịp")) {
					list = TimKiemCPU.byXungNhip(key);
				} else if (choose.equals("Số nhân")) {
					list = TimKiemCPU.bySoNhan(key);
				} else if (choose.equals("Số luồng")) {
					list = TimKiemCPU.bySoLuong(key);
				} else if (choose.equals("Điện năng tiêu thụ")) {
					list = TimKiemCPU.byDienNang(key);
				} else if (choose.equals("Bộ nhớ đệm")) {
					list = TimKiemCPU.byBoNhoDem(key);
				} else if (choose.equals("Đơn giá")) {
					list = TimKiemCPU.byGia(key);
				} else if (choose.equals("ID CPU")) {
					list = TimKiemCPU.byIDCPU(key);
				} else if (choose.equals("Tồn kho")) {
					list = TimKiemCPU.byTonKho(key);
				}

				loadDataToTable(list);
			}
		});
		textField.setColumns(10);
		textField.setBounds(248, 8, 277, 33);
		panel_1.add(textField);

		comboBoxSort = new JComboBox<>();
		comboBoxSort.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboBoxSort.getSelectedItem().toString().equals("Giá tăng dần")) {
					ArrayList<cpu> tangdan = giaTangDan();
					loadDataToTable(tangdan);
				} else if (comboBoxSort.getSelectedItem().toString().equals("Giá giảm dần")) {
					ArrayList<cpu> giamdan = giaGiamDan();
					loadDataToTable(giamdan);
				} else if (comboBoxSort.getSelectedItem().toString().equals("Tồn kho tăng dần")) {
					ArrayList<cpu> tang = tonKhoTang();
					loadDataToTable(tang);
				} else if (comboBoxSort.getSelectedItem().toString().equals("Tồn kho giảm dần")) {
					ArrayList<cpu> giam = tonKhoGiam();
					loadDataToTable(giam);
				}
			}
		});
//		comboBoxSort.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				if (comboBoxSort.getSelectedIndex() == 1) {
//					ArrayList<cpu> tangdan = giaTangDan();
//					loadDataToTable(tangdan);
//				} else {
//					ArrayList<cpu> giamdan = giaGiamDan();
//					loadDataToTable(giamdan);
//				}
//			}
//		});
		comboBoxSort.setFont(font);
		comboBoxSort.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

			}
		});
		comboBoxSort.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Sắp xếp", "Giá tăng dần", "Giá giảm dần", "Tồn kho tăng dần", "Tồn kho giảm dần" }));
		comboBoxSort.setBounds(0, 8, 125, 33);
		panel_1.add(comboBoxSort);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(790, 53, 372, 648);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		labelIMG = new JLabel("Ảnh sản phẩm");
		labelIMG.setFont(SetFont.font());
		labelIMG.setIcon(new ImageIcon(CPUForm.class.getResource("/icon/icons8-no-image-14.png")));
		labelIMG.setBorder(null);
		labelIMG.setHorizontalAlignment(SwingConstants.CENTER);
		labelIMG.setBounds(12, 50, 350, 350);
		panel_2.add(labelIMG);

		labelTien = new JLabel("0 đ");
		labelTien.setForeground(new Color(190, 14, 30));
		labelTien.setFont(SetFont.font1());
		labelTien.setBounds(41, 402, 131, 23);
		panel_2.add(labelTien);

		labelBaoHanh = new JLabel("Bảo hành");
		labelBaoHanh.setFont(SetFont.font1());
		labelBaoHanh.setBounds(41, 436, 143, 23);
		panel_2.add(labelBaoHanh);

		labelTen = new JLabel("Tên CPU");
		labelTen.setFont(SetFont.fontCategory());
		labelTen.setBounds(30, 8, 341, 31);
		panel_2.add(labelTen);

		txtrAbc = new JTextArea();
		txtrAbc.setOpaque(false);
		txtrAbc.setFont(SetFont.fontDetails_1());
		txtrAbc.setWrapStyleWord(true);
		txtrAbc.setLineWrap(true);
		txtrAbc.setEditable(false);
		txtrAbc.setBounds(33, 470, 310, 167);
		panel_2.add(txtrAbc);

		labelXungNhip = new JLabel("Xung nhịp: ");
		labelXungNhip.setFont(SetFont.fontDetails());
		labelXungNhip.setBounds(193, 402, 178, 14);
		panel_2.add(labelXungNhip);

		labelSoNhan = new JLabel("Số Nhân: ");
		labelSoNhan.setFont(SetFont.fontDetails());
		labelSoNhan.setBounds(193, 417, 85, 14);
		panel_2.add(labelSoNhan);

		labelDienNang = new JLabel("Điện năng tiêu thụ: ");
		labelDienNang.setFont(SetFont.fontDetails());
		labelDienNang.setBounds(193, 432, 178, 14);
		panel_2.add(labelDienNang);

		labelBoNhoDem = new JLabel("Bộ Nhớ Đệm: ");
		labelBoNhoDem.setFont(SetFont.fontDetails());
		labelBoNhoDem.setBounds(193, 446, 179, 14);
		panel_2.add(labelBoNhoDem);

		labelSoLuong = new JLabel("Số Luồng: ");
		labelSoLuong.setFont(SetFont.fontDetails());
		labelSoLuong.setBounds(280, 417, 85, 14);
		panel_2.add(labelSoLuong);

		labelLuot = new JLabel("Lượt bán: ");
		labelLuot.setFont(SetFont.fontDetails());
		labelLuot.setBounds(30, 35, 53, 14);
		panel_2.add(labelLuot);

		labelLuotBan = new JLabel("0");
		labelLuotBan.setFont(SetFont.fontDetails());
		labelLuotBan.setForeground(SetColor.blue);
		labelLuotBan.setBounds(85, 35, 51, 14);
		panel_2.add(labelLuotBan);

	}

	public static cpu getSelectCPU() {
//		cpu c = cpuDAO.getInstance().selectAll().get(table.getSelectedRow());
		return cpuDAO.getInstance().selectById(String.valueOf(table.getValueAt(table.getSelectedRow(), 1)));
	}

	private ArrayList<cpu> giaTangDan() {
		ArrayList<cpu> list = cpuDAO.getInstance().selectAll();
		Collections.sort(list, new Comparator<cpu>() {
			@Override
			public int compare(cpu o1, cpu o2) {
				if (o1.getDonGia() > o2.getDonGia())
					return 1;
				if (o1.getDonGia() < o2.getDonGia())
					return -1;
				return 0;
			}
		});
		return list;
	}

	private ArrayList<cpu> giaGiamDan() {
		ArrayList<cpu> list = cpuDAO.getInstance().selectAll();
		Collections.sort(list, new Comparator<cpu>() {
			@Override
			public int compare(cpu o1, cpu o2) {
				if (o1.getDonGia() < o2.getDonGia())
					return 1;
				if (o1.getDonGia() > o2.getDonGia())
					return -1;
				return 0;
			}
		});
		return list;
	}

	private ArrayList<cpu> tonKhoGiam() {
		ArrayList<cpu> list = cpuDAO.getInstance().selectAll();
		Collections.sort(list, new Comparator<cpu>() {
			@Override
			public int compare(cpu o1, cpu o2) {
				if (o1.getTonKho() < o2.getTonKho())
					return 1;
				if (o1.getTonKho() > o2.getTonKho())
					return -1;
				return 0;
			}
		});
		return list;
	}

	private ArrayList<cpu> tonKhoTang() {
		ArrayList<cpu> list = cpuDAO.getInstance().selectAll();
		Collections.sort(list, new Comparator<cpu>() {
			@Override
			public int compare(cpu o1, cpu o2) {
				if (o1.getTonKho() > o2.getTonKho())
					return 1;
				if (o1.getTonKho() < o2.getTonKho())
					return -1;
				return 0;
			}
		});
		return list;
	}
}
