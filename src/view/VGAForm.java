package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
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
import java.io.FileOutputStream;
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

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import color.SetColor;
import controller.FormatToVND;
import controller.TimKiemVGA;
import dao.ChiTietPhieuXuatDAO;
import dao.SanPhamDAO;
import dao.vgaDAO;
import decor.SetTitleForJF;
import font.SetFont;
import model.vga;

public class VGAForm extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTable table;
	private static DefaultTableModel tableModel;
	private final String columName[] = { "ID sản phẩm", "ID VGA", "Tên VGA", "Hãng VGA", "Bộ nhớ", "Tồn kho",
			"Đơn giá" };
	private JTextField textField;
	public Font font;
	public Font font_1;
	public Font font1;
	public Font font2;
	private JTextArea txtrAbc;
	private JLabel labelBaoHanh;
	private JLabel labelTien;
	private JLabel lblTnVga;
	private JLabel labelIMG;
	private JLabel labelBoNho;
	private JLabel labelHang;
	private JLabel labelLuotBan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VGAForm frame = new VGAForm();
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

	public static void loadDataToTable(ArrayList<vga> v) {
		try {
			tableModel.setRowCount(0);
			for (vga i : v) {
				DefaultTableCellRenderer right = new DefaultTableCellRenderer();
				right.setHorizontalAlignment(SwingConstants.RIGHT);

				DefaultTableCellRenderer center = new DefaultTableCellRenderer();
				center.setHorizontalAlignment(SwingConstants.CENTER);

				table.getColumnModel().getColumn(6).setCellRenderer(right);
				table.getColumnModel().getColumn(5).setCellRenderer(center);

				String gia = FormatToVND.vnd(i.getDonGia());

				tableModel.addRow(new Object[] { i.getIdSanPham(), i.getIdVga(), i.getTenVGA(), i.getHangVGA(),
						i.getBoNho(), i.getTonKho(), gia });
			}
		} catch (Exception e) {
		}
	}

	public void setDefaultTable() {
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columName);
		table.setDefaultEditor(Object.class, null);
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(500);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setPreferredWidth(200);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(300);
		loadDataToTable(vgaDAO.getInstance().selectAll());
	}

	public VGAForm() {
		SetTitleForJF.setTitle(this, "/icon/icons8-video-card-20.png");

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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 53, 781, 648);
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
//				vga v = getVGASelect();

				vga v = vgaDAO.getInstance().selectById(String.valueOf(table.getValueAt(table.getSelectedRow(), 1)));

				lblTnVga.setText(v.getTenVGA());
				labelTien.setText(FormatToVND.vnd(v.getDonGia()));
				labelBaoHanh.setText("Bảo hành: " + v.getBaoHanh());
				labelLuotBan.setText(ChiTietPhieuXuatDAO.getInstance().tongDonXuatSPRieng(v.getIdVga()) + "");
				labelHang.setText("Hãng: " + v.getHangVGA());
				labelBoNho.setText("Bộ nhớ: " + v.getBoNho());
				txtrAbc.setText(SanPhamDAO.getInstance().selectById(v.getIdSanPham()).getMoTa());

				if (v.getImg() == null) {
					labelIMG.setIcon(null);
					labelIMG.setIcon(new ImageIcon(MainboardForm.class.getResource("/icon/icons8-no-image-14.png")));
					labelIMG.setText("Sản phẩm hiện chưa có ảnh mẫu");
				} else {
					labelIMG.setBorder(null);
					Blob blob = v.getImg();
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
		table.getTableHeader().setBackground(SetColor.blueOp);
		table.getTableHeader().setFont(SetFont.fontHeaderTable());
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "New column", "New column", "New column", "New column" }));
		scrollPane.setViewportView(table);

		setDefaultTable();

		JButton btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ThemVGA.main(null);
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
				if (table.getRowCount() == -1) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn VGA để xóa");
				} else {
					int answ = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn xóa sản phẩm này?", "Cảnh báo",
							JOptionPane.YES_NO_OPTION);
					if (answ == JOptionPane.YES_OPTION) {
						vga v = getVGASelect();
						vgaDAO.getInstance().delete(v);
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
					JOptionPane.showMessageDialog(null, "Vui lòng chọn VGA để sửa");
				} else {
					CapNhatVGA.main(null);
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
							XSSFCell id = excelRow.getCell(0);
							XSSFCell ten = excelRow.getCell(1);
							XSSFCell hang = excelRow.getCell(2);
							XSSFCell bonho = excelRow.getCell(3);
							XSSFCell dongia = excelRow.getCell(4);

							model.addRow(new Object[] { id, ten, hang, bonho, dongia });
						}
						JOptionPane.showMessageDialog(null, "Thêm thành công!");
						int answ = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm vào csdl không", "Thông báo",
								JOptionPane.YES_NO_OPTION);
						if (answ == JOptionPane.YES_OPTION) {
							for (int i = rowBanDau; i <= model.getRowCount(); i++) {
								String id = model.getValueAt(i, 0).toString();
								String idram = model.getValueAt(i, 1).toString();
								String ten = model.getValueAt(i, 2).toString();
								String hang = model.getValueAt(i, 3).toString();
								String bonho = model.getValueAt(i, 4).toString();
								int tonkho = (int) model.getValueAt(i, 5);
								double dongia = (double) model.getValueAt(i, 6);
								String baohanh = model.getValueAt(i, 7).toString();

								vga vga = new vga(id, idram, ten, hang, bonho, tonkho, dongia, baohanh, null);

								vgaDAO.getInstance().insertNotIMG(vga);
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
				try {
					JFileChooser jFileChooser = new JFileChooser();
					jFileChooser.showSaveDialog(null);
					File saveFile = jFileChooser.getSelectedFile();
					if (saveFile != null) {
						saveFile = new File(saveFile.toString() + ".xlsx");
						Workbook wb = new XSSFWorkbook();
						Sheet sheet = wb.createSheet("VGA");

						Row rowCol = sheet.createRow(0);
						for (int i = 0; i < table.getColumnCount(); i++) {
							org.apache.poi.ss.usermodel.Cell cell = rowCol.createCell(i);
							cell.setCellValue(table.getColumnName(i));
						}

						for (int j = 0; j < table.getRowCount(); j++) {
							Row row = sheet.createRow(j + 1);
							for (int k = 0; k < table.getColumnCount(); k++) {
								org.apache.poi.ss.usermodel.Cell ce = row.createCell(k);
								if (table.getValueAt(j, k) != null) {
									ce.setCellValue(table.getValueAt(j, k).toString());
								}

							}
						}
						FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
						wb.write(out);
						wb.close();
						out.close();
						openFile(saveFile.toString());
					}
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		});
		btnNewButton_5.setIcon(new ImageIcon(CPUForm.class.getResource("/icon/icons8-export-excel-24.png")));
		btnNewButton_5.setFont(font);
		btnNewButton_5.setBounds(477, 8, 142, 33);
		panel.add(btnNewButton_5);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(635, 0, 557, 49);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VGAForm.class.getResource("/icon/search-24.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(471, 13, 48, 25);
		panel_1.add(lblNewLabel);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(font);
		comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "ID sản phẩm", "ID VGA", "Tên VGA", "Hãng VGA", "Bộ nhớ", "Tồn kho", "Đơn giá" }));
		comboBox.setBounds(146, 8, 99, 33);
		panel_1.add(comboBox);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
//				SEt tìm kiếm cho VGA
				ArrayList<vga> list = new ArrayList<vga>();
				String choose = comboBox.getSelectedItem().toString();
				String key = textField.getText();

				switch (choose) {
				case "ID sản phẩm":
					list = TimKiemVGA.byID(key);
					break;
				case "ID VGA":
					list = TimKiemVGA.byIDVGA(key);
					break;
				case "Tên VGA":
					list = TimKiemVGA.byTen(key);
					break;
				case "Hãng VGA":
					list = TimKiemVGA.byHang(key);
					break;
				case "Bộ nhớ":
					list = TimKiemVGA.byBoNho(key);
					break;
				case "Tồn kho":
					list = TimKiemVGA.byTonKho(key);
					break;
				case "Đơn giá":
					list = TimKiemVGA.byGia(key);
					break;

				default:
					break;
				}

				loadDataToTable(list);

			}
		});
		textField.setColumns(10);
		textField.setBounds(255, 8, 271, 33);
		panel_1.add(textField);

		JComboBox<String> comboBox_1 = new JComboBox<>();
		comboBox_1.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Sắp xếp", "Giá tăng dần", "Giá giảm dần", "Tồn kho tăng", "Tồn kho giảm" }));
		comboBox_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboBox_1.getSelectedItem().toString().equals("Giá tăng dần")) {
					loadDataToTable(sxTangDan());
				} else if (comboBox_1.getSelectedItem().toString().equals("Giá giảm dần")) {
					loadDataToTable(sxGiamDan());
				} else if (comboBox_1.getSelectedItem().toString().equals("Tồn kho tăng")) {
					loadDataToTable(tonKhoTang());
				} else if (comboBox_1.getSelectedItem().toString().equals("Tồn kho giảm")) {
					loadDataToTable(tonKhoGiam());
				}
			}
		});
		comboBox_1.setFont(SetFont.font());
		comboBox_1.setBounds(10, 8, 126, 33);
		panel_1.add(comboBox_1);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(790, 53, 372, 648);
		getContentPane().add(panel_2);

		labelIMG = new JLabel("Ảnh sản phẩm");
		labelIMG.setIcon(new ImageIcon(VGAForm.class.getResource("/icon/icons8-no-image-14.png")));
		labelIMG.setFont(SetFont.font());
		labelIMG.setHorizontalAlignment(SwingConstants.CENTER);
		labelIMG.setBorder(null);
		labelIMG.setBounds(10, 50, 350, 350);
		panel_2.add(labelIMG);

		labelTien = new JLabel("0 đ");
		labelTien.setForeground(new Color(190, 14, 30));
		labelTien.setFont(SetFont.font1());
		labelTien.setBounds(41, 402, 174, 23);
		panel_2.add(labelTien);

		labelBaoHanh = new JLabel("Bảo hành");
		labelBaoHanh.setFont(SetFont.font1());
		labelBaoHanh.setBounds(41, 436, 143, 23);
		panel_2.add(labelBaoHanh);

		lblTnVga = new JLabel("Tên VGA");
		lblTnVga.setFont(SetFont.fontCategory());
		lblTnVga.setBounds(30, 8, 343, 31);
		panel_2.add(lblTnVga);

		txtrAbc = new JTextArea();
		txtrAbc.setBounds(38, 459, 300, 178);
		panel_2.add(txtrAbc);
		txtrAbc.setBorder(null);
		txtrAbc.setWrapStyleWord(true);
		txtrAbc.setOpaque(false);
		txtrAbc.setLineWrap(true);
		txtrAbc.setFont(SetFont.fontDetails_1());
		txtrAbc.setEditable(false);

		JLabel labelLuot = new JLabel("Lượt bán: ");
		labelLuot.setFont(SetFont.fontDetails());
		labelLuot.setBounds(30, 35, 53, 14);
		panel_2.add(labelLuot);

		labelLuotBan = new JLabel("0");
		labelLuotBan.setForeground(new Color(64, 143, 221));
		labelLuotBan.setFont(SetFont.fontDetails());
		labelLuotBan.setBounds(85, 35, 51, 14);
		panel_2.add(labelLuotBan);

		labelHang = new JLabel("Hãng: ");
		labelHang.setFont(SetFont.fontDetails());
		labelHang.setBounds(225, 406, 148, 14);
		panel_2.add(labelHang);

		labelBoNho = new JLabel("Bộ nhớ: ");
		labelBoNho.setFont(SetFont.fontDetails());
		labelBoNho.setBounds(225, 431, 148, 14);
		panel_2.add(labelBoNho);
	}

	public static vga getVGASelect() {
//		vga v = vgaDAO.getInstance().selectAll().get(table.getSelectedRow());
		return vgaDAO.getInstance().selectById(String.valueOf(table.getValueAt(table.getSelectedRow(), 1)));
	}

	private ArrayList<vga> sxTangDan() {
		ArrayList<vga> list = vgaDAO.getInstance().selectAll();

		Collections.sort(list, new Comparator<vga>() {

			@Override
			public int compare(vga o1, vga o2) {
				if (o1.getDonGia() > o2.getDonGia())
					return 1;
				if (o1.getDonGia() < o2.getDonGia())
					return -1;
				return 0;
			}
		});
		return list;
	}

	private ArrayList<vga> sxGiamDan() {
		ArrayList<vga> list = vgaDAO.getInstance().selectAll();
		Collections.sort(list, new Comparator<vga>() {

			@Override
			public int compare(vga o1, vga o2) {
				if (o1.getDonGia() < o2.getDonGia())
					return 1;
				if (o1.getDonGia() > o2.getDonGia())
					return -1;
				return 0;
			}
		});
		return list;
		
	}

	private ArrayList<vga> tonKhoTang() {
		ArrayList<vga> list = vgaDAO.getInstance().selectAll();
		Collections.sort(list, new Comparator<vga>() {

			@Override
			public int compare(vga o1, vga o2) {
				if (o1.getTonKho() > o2.getTonKho())
					return 1;
				if (o1.getTonKho() < o2.getTonKho())
					return -1;
				return 0;
			}
		});
		return list;
	}

	private ArrayList<vga> tonKhoGiam() {
		ArrayList<vga> list = vgaDAO.getInstance().selectAll();
		Collections.sort(list, new Comparator<vga>() {

			@Override
			public int compare(vga o1, vga o2) {
				if (o1.getTonKho() < o2.getTonKho())
					return 1;
				if (o1.getTonKho() > o2.getTonKho())
					return -1;
				return 0;
			}
		});
		return list;
	}

	private void openFile(String file) {
		try {
			File path = new File(file);
			Desktop.getDesktop().open(path);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
