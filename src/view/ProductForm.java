package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
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
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
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
import controller.TimKiemSP;
import dao.SanPhamDAO;
import font.SetFont;
import model.Products;

public class ProductForm extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Font font;
	public Font font_1;
	public Font font1;
	public Font font2;
	private static JTable table;
	private static DefaultTableModel tableModel;
	private final String columName[] = { "ID sản phẩm", "Tên sản phẩm", "Trạng thái", "Mô tả" };
	private JTextField txtTmKim;
	private JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductForm frame = new ProductForm();
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

	public static void loadDataToTable(ArrayList<Products> pr) {
		try {
			tableModel.setRowCount(0);
			for (Products i : pr) {
				DefaultTableCellRenderer renderCenter = new DefaultTableCellRenderer();
				renderCenter.setHorizontalAlignment(JLabel.CENTER);
				table.getColumnModel().getColumn(2).setCellRenderer(renderCenter);
				tableModel.addRow(new Object[] { i.getIdSanPham(), i.getTenSanPham(), i.getTrangThai(), i.getMoTa() });
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
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(500);
		loadDataToTable(SanPhamDAO.getInstance().selectAll());
	}

	public ProductForm() {

		try {
			File fontStyle = new File("src/font/Roboto-Medium.ttf");
			font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(11f);
			font_1 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(14f);
			font1 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(16f);
			font2 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(22f);

		} catch (Exception e) {
			System.out.println(e);
		}

		setBounds(100, 100, 1170, 730);
		getContentPane().setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 629, 49);
		getContentPane().add(panel_1);

		JButton btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ThemProduct.main(null);

			}
		});
		btnNewButton_1.setFont(font);
		btnNewButton_1.setIcon(new ImageIcon(ProductForm.class.getResource("/icon/icons8-add-24.png")));
		btnNewButton_1.setBounds(10, 8, 99, 33);
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm để xóa!");
				} else {
					int answ = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn xóa sản phẩm này?", "Cảnh báo",
							JOptionPane.YES_NO_OPTION);
					if (answ == JOptionPane.YES_OPTION) {
						Products pr = SanPhamDAO.getInstance().selectAll().get(table.getSelectedRow());
						SanPhamDAO.getInstance().delete(pr);
						loadDataToTable(SanPhamDAO.getInstance().selectAll());
						JOptionPane.showMessageDialog(null, "Xóa thành công!");
					}
				}
			}
		});
		btnNewButton_2.setFont(font);
		btnNewButton_2.setIcon(new ImageIcon(ProductForm.class.getResource("/icon/icons8-delete-24.png")));
		btnNewButton_2.setBounds(119, 8, 99, 33);
		panel_1.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Sửa");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectedRow() == -1)
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm để sửa!");
				else
					CapNhatProduct.main(null);
			}
		});
		btnNewButton_3.setFont(font);
		btnNewButton_3.setIcon(new ImageIcon(ProductForm.class.getResource("/icon/icons8-edit-24.png")));
		btnNewButton_3.setBounds(228, 8, 87, 33);
		panel_1.add(btnNewButton_3);

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
							XSSFCell ten = excelRow.getCell(1);
							XSSFCell idnpp = excelRow.getCell(2);
							XSSFCell soluongtonkho = excelRow.getCell(3);

							model.addRow(new Object[] { idsp, ten, idnpp, soluongtonkho });
						}
						JOptionPane.showMessageDialog(null, "Thêm thành công!");
						int answ = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm vào csdl không", "Thông báo",
								JOptionPane.YES_NO_OPTION);
						if (answ == JOptionPane.YES_OPTION) {
							for (int i = rowBanDau; i <= model.getRowCount(); i++) {
								String idsp = model.getValueAt(i, 0).toString();
								String ten = model.getValueAt(i, 1).toString();
								int trangThai = (int) model.getValueAt(i, 2);
								String mota = model.getValueAt(i, 3).toString();

								Products p = new Products(idsp, ten, trangThai, mota);
								SanPhamDAO.getInstance().insert(p);
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
		btnNewButton_4.setFont(font);
		btnNewButton_4.setIcon(new ImageIcon(ProductForm.class.getResource("/icon/icons8-import-csv-24.png")));
		btnNewButton_4.setBounds(329, 8, 138, 33);
		panel_1.add(btnNewButton_4);

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
						Sheet sheet = wb.createSheet("Product");

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
		btnNewButton_5.setFont(font);
		btnNewButton_5.setIcon(new ImageIcon(ProductForm.class.getResource("/icon/icons8-export-excel-24.png")));
		btnNewButton_5.setBounds(477, 8, 142, 33);
		panel_1.add(btnNewButton_5);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setLayout(null);
		panel_2.setBounds(639, 1, 549, 49);
		getContentPane().add(panel_2);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setIcon(new ImageIcon(ProductForm.class.getResource("/icon/search-24.png")));
		lblNewLabel.setBounds(470, 13, 48, 24);
		panel_2.add(lblNewLabel);

		txtTmKim = new JTextField();
		txtTmKim.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (comboBox.getSelectedItem().toString().equals("ID Sản phẩm")) {
					loadDataToTable(TimKiemSP.byID(txtTmKim.getText()));
				} else if (comboBox.getSelectedItem().toString().equals("Tên sản phẩm")) {
					loadDataToTable(TimKiemSP.byTen(txtTmKim.getText()));
				} else if (comboBox.getSelectedItem().toString().equals("Trạng thái")) {
					loadDataToTable(TimKiemSP.byTrangThai(txtTmKim.getText()));
				} else if (comboBox.getSelectedItem().toString().equals("Mô tả")) {
					loadDataToTable(TimKiemSP.byMota(txtTmKim.getText()));
				}
			}
		});
		txtTmKim.setColumns(10);
		txtTmKim.setBounds(271, 8, 247, 33);
		panel_2.add(txtTmKim);

		comboBox = new JComboBox<String>();
		comboBox.setFont(font);
		comboBox.setModel(
				new DefaultComboBoxModel<>(new String[] { "ID Sản phẩm", "Tên sản phẩm", "Trạng thái", "Mô tả" }));
		comboBox.setBounds(148, 8, 113, 33);
		panel_2.add(comboBox);

		JComboBox<String> comboBox_1 = new JComboBox<>();
		comboBox_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboBox_1.getSelectedItem().toString().equals("Còn kinh doanh")) {
					loadDataToTable(ConKinhDoanh());
				} else if (comboBox_1.getSelectedItem().toString().equals("Ngừng kinh doanh")) {
					loadDataToTable(NgungKinhDoanh());
				}
			}
		});
		comboBox_1.setModel(
				new DefaultComboBoxModel<String>(new String[] { "Trạng thái", "Còn kinh doanh", "Ngừng kinh doanh" }));
		comboBox_1.setFont(font);
		comboBox_1.setBounds(10, 8, 128, 33);
		panel_2.add(comboBox_1);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(0, 53, 1160, 648);
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
		table.getTableHeader().setBackground(SetColor.blueOp);
		table.getTableHeader().setFont(SetFont.fontHeaderTable());
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID Sản phẩm", "Tên sản phẩm", "Trạng thái", "Mô tả" }));
		scrollPane.setViewportView(table);
		setDefaultTable();

	}

	public static Products getProSelect() {
//		Products p = SanPhamDAO.getInstance().selectAll().get(table.getSelectedRow());
		return SanPhamDAO.getInstance().selectById(String.valueOf(table.getValueAt(table.getSelectedRow(), 0)));

//		return p;
	}

	private void openFile(String file) {
		try {
			File path = new File(file);
			Desktop.getDesktop().open(path);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private ArrayList<Products> ConKinhDoanh() {
		ArrayList<Products> list = SanPhamDAO.getInstance().selectAll();
		ArrayList<Products> pro = new ArrayList<Products>();
		System.out.println(list.size());
		for (Products products : list) {
			if (products.getTrangThai() == 1)
				pro.add(products);
		}

		return pro;
	}

	private ArrayList<Products> NgungKinhDoanh() {
		ArrayList<Products> list = SanPhamDAO.getInstance().selectAll();
		ArrayList<Products> pro = new ArrayList<Products>();
		System.out.println(list.size());
		for (Products products : list) {
			if (products.getTrangThai() == 0)
				pro.add(products);
		}

		return pro;
	}
}
