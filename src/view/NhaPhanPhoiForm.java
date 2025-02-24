package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
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
import controller.TimKiemNPP;
import dao.NhaPhanPhoiDAO;
import font.SetFont;
import model.NhaPhanPhoi;

public class NhaPhanPhoiForm extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfSeach;
	public static JTable tableNpp;
	private static DefaultTableModel tableModel;
	private final String columName[] = { "Mã nhà phân phối", "Tên nhà phân phối", "Địa chỉ", "Email", "Số điện thoại" };
	public Font font;
	public Font font_1;
	public Font font1;
	public Font font2;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					NhaPhanPhoiForm frame = new NhaPhanPhoiForm();
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

	// method load data
	public static void loadDataToTable(ArrayList<NhaPhanPhoi> npp) {
		try {
			tableModel.setRowCount(0);
			for (NhaPhanPhoi i : npp) {
				tableModel
						.addRow(new Object[] { i.getIdNPP(), i.getTenNPP(), i.getDiaChi(), i.getEmail(), i.getSdt() });
			}
		} catch (Exception e) {
		}
	}

	public void setDefaultTable() {
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columName);
		tableNpp.setDefaultEditor(Object.class, null);
		tableNpp.setModel(tableModel);
		tableNpp.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableNpp.getColumnModel().getColumn(1).setPreferredWidth(300);
		tableNpp.getColumnModel().getColumn(2).setPreferredWidth(350);
		tableNpp.getColumnModel().getColumn(3).setPreferredWidth(200);
		loadDataToTable(NhaPhanPhoiDAO.getInstance().selectAll());
	}

	public NhaPhanPhoiForm() {
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

		setBounds(100, 100, 1170, 630);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 51, 1152, 550);
		getContentPane().add(scrollPane);

		tableNpp = new JTable() {
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
		tableNpp.getTableHeader().setBackground(SetColor.blueOp);
		tableNpp.getTableHeader().setFont(SetFont.fontHeaderTable());
		tableNpp.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "new", "new", "new", "new", "new" }));
		scrollPane.setViewportView(tableNpp);

		setDefaultTable();

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 631, 48);
		getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.setIcon(new ImageIcon(NhaPhanPhoiForm.class.getResource("/icon/icons8-add-24.png")));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ThemNhaPhanPhoi tnpp = new ThemNhaPhanPhoi();
				tnpp.setVisible(true);
				tnpp.setLocationRelativeTo(null);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		btnNewButton_1.setFont(font);
		btnNewButton_1.setBounds(10, 8, 99, 33);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.setIcon(new ImageIcon(NhaPhanPhoiForm.class.getResource("/icon/icons8-delete-24.png")));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tableNpp.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn nhà phân phối muốn xóa!");
				} else {
					int answ = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa không", "Thông báo",
							JOptionPane.YES_NO_OPTION);
					if (answ == JOptionPane.YES_OPTION) {
						NhaPhanPhoi npp = NhaPhanPhoiDAO.getInstance().selectAll().get(tableNpp.getSelectedRow());
						NhaPhanPhoiDAO.getInstance().delete(npp);
						loadDataToTable(NhaPhanPhoiDAO.getInstance().selectAll());
						JOptionPane.showMessageDialog(null, "Xóa thành công");
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		btnNewButton_2.setFont(font);
		btnNewButton_2.setBounds(119, 8, 99, 33);
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Sửa");
		btnNewButton_3.setIcon(new ImageIcon(NhaPhanPhoiForm.class.getResource("/icon/icons8-edit-24.png")));
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tableNpp.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn nhà phân phối muốn sửa!");
				} else {
					CapNhatNhaPhanPhoi.main(null);
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		btnNewButton_3.setFont(font);
		btnNewButton_3.setBounds(228, 8, 87, 33);
		panel.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Nhập Excel");
		btnNewButton_4.setIcon(new ImageIcon(NhaPhanPhoiForm.class.getResource("/icon/icons8-import-csv-24.png")));
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				DefaultTableModel model = (DefaultTableModel) tableNpp.getModel();

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
							XSSFCell diaChi = excelRow.getCell(2);
							XSSFCell email = excelRow.getCell(3);
							XSSFCell sdt = excelRow.getCell(4);
							model.addRow(new Object[] { id, ten, diaChi, email, sdt });
						}
						JOptionPane.showMessageDialog(null, "Thêm thành công!");
						int answ = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm vào csdl không", "Thông báo",
								JOptionPane.YES_NO_OPTION);
						if (answ == JOptionPane.YES_OPTION) {
							for (int i = rowBanDau; i <= model.getRowCount(); i++) {
								String id = model.getValueAt(i, 0).toString();
								String ten = model.getValueAt(i, 1).toString();
								String diaChi = model.getValueAt(i, 2).toString();
								String email = model.getValueAt(i, 3).toString();
								int sdt = Integer.parseInt(model.getValueAt(i, 4).toString());

								NhaPhanPhoi npp = new NhaPhanPhoi(id, ten, diaChi, email, sdt);

								NhaPhanPhoiDAO.getInstance().insert(npp);
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

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		btnNewButton_4.setFont(font);
		btnNewButton_4.setBounds(329, 8, 138, 33);
		panel.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Xuất Excel");
		btnNewButton_5.setFont(font);
		btnNewButton_5.setIcon(new ImageIcon(NhaPhanPhoiForm.class.getResource("/icon/icons8-export-excel-24.png")));
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
						Sheet sheet = wb.createSheet("NhaPhanPhoi");

						Row rowCol = sheet.createRow(0);
						for (int i = 0; i < tableNpp.getColumnCount(); i++) {
							org.apache.poi.ss.usermodel.Cell cell = rowCol.createCell(i);
							cell.setCellValue(tableNpp.getColumnName(i));
						}

						for (int j = 0; j < tableNpp.getRowCount(); j++) {
							Row row = sheet.createRow(j + 1);
							for (int k = 0; k < tableNpp.getColumnCount(); k++) {
								org.apache.poi.ss.usermodel.Cell ce = row.createCell(k);
								if (tableNpp.getValueAt(j, k) != null) {
									ce.setCellValue(tableNpp.getValueAt(j, k).toString());
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

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		btnNewButton_5.setBounds(477, 8, 142, 33);
		panel.add(btnNewButton_5);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(632, 0, 556, 48);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

//		String[] item = { "Tất cả", "ID Nhà phân phối", "Tên nhà phân phối", "Email", "SDT" };

		JComboBox<String> comboBox = new javax.swing.JComboBox<>();
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "Tất cả", "ID Nhà phân phối", "Tên nhà phân phối", "Địa chỉ", "Email", "SDT", }));
		comboBox.addKeyListener(new KeyAdapter() {

		});
		comboBox.setFont(font);
		comboBox.setBounds(0, 8, 99, 33);
		panel_1.add(comboBox);

		tfSeach = new JTextField();
		tfSeach.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				String choose = (String) comboBox.getSelectedItem();
				System.out.println(choose);
				String key = tfSeach.getText();
				ArrayList<NhaPhanPhoi> list = new ArrayList<>();

				if (choose.equals("ID Nhà phân phối")) {
					list = TimKiemNPP.byID(key);
				} else if (choose.equals("Tên nhà phân phối")) {
					list = TimKiemNPP.byTen(key);
				}
				if (choose.equals("Địa chỉ")) {
					list = TimKiemNPP.byDiaChi(key);
				} else if (choose.equals("SDT")) {
					list = TimKiemNPP.bySDT(key);
				} else if (choose.equals("Tất cả")) {
					list = TimKiemNPP.all(key);
				} else if (choose.equals("Email")) {
					list = TimKiemNPP.byEmail(key);
				}
				loadDataToTable(list);
			}
		});
		tfSeach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}

		});
		tfSeach.setColumns(10);
		tfSeach.setBounds(109, 8, 283, 33);
		panel_1.add(tfSeach);

		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.setFont(font);
		btnNewButton.setIcon(new ImageIcon(NhaPhanPhoiForm.class.getResource("/icon/search-24.png")));
		btnNewButton.setBounds(402, 8, 118, 33);
		panel_1.add(btnNewButton);
	}

	public String getIDNhaCungCap() {
		String id = (String) tableNpp.getModel().getValueAt(tableNpp.getSelectedRow(), 0);
		return id;
	}

	public static NhaPhanPhoi getNppSelect() {
//		NhaPhanPhoi npp = NhaPhanPhoiDAO.getInstance().selectAll().get(tableNpp.getSelectedRow());
//		return npp;
		return NhaPhanPhoiDAO.getInstance().selectById(String.valueOf(tableNpp.getValueAt(tableNpp.getSelectedRow(), 0)));
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
