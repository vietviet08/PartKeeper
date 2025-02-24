package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
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
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
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

import com.toedter.calendar.JDateChooser;

import color.SetColor;
import controller.TimKiemKhachHang;
import dao.KhachHangDAO;
import font.SetFont;
import model.KhachHang;

public class KhachHangForm extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTable table;
	private static DefaultTableModel tableModel;
	private static String[] columnName = { "ID khách hàng", "Tên khách hàng", "Địa chỉ", "Email", "SĐT",
			"Ngày tham gia", "Ảnh" };
	private JTextField tfID;
	private JTextField tfTen;
	public static JTextField tfSDT;
	private JTextField tfDiaChi;
	private JTextField tfEmail;
	private JTextField tfSearch;
	private JTextField tfNgayThamGia;
	private JLabel labelIMG;
	private static String insert = "";
	private JLabel labelStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhachHangForm frame = new KhachHangForm();
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
	public static void loadDataToTable(ArrayList<KhachHang> kh) {
//		SimpleDateFormat formatD = new SimpleDateFormat("dd/MM/yyyy");
		try {
			tableModel.setRowCount(0);
			for (KhachHang i : kh) {
				DefaultTableCellRenderer renderCenter = new DefaultTableCellRenderer();
				renderCenter.setHorizontalAlignment(JLabel.CENTER);

				table.getColumnModel().getColumn(5).setCellRenderer(renderCenter);

				tableModel.addRow(new Object[] { i.getIdKhachHang(), i.getTenKhachHang(), i.getDiaChi(), i.getEmail(),
						i.getSdt(), i.getNgayThamGia(), i.getImg() });
			}
		} catch (Exception e) {
		}

	}

	private void setDefaultTable() {
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columnName);
		table.setDefaultEditor(Object.class, null);
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(250);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setPreferredWidth(200);
		table.getColumnModel().getColumn(5).setPreferredWidth(200);
		table.getColumnModel().getColumn(6).setPreferredWidth(150);
		loadDataToTable(KhachHangDAO.getInstance().selectAll());
	}

	public KhachHangForm() {
		setBounds(100, 100, 1170, 730);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 11, 1162, 701);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfID.setText(setIDKhachHang());
				tfTen.setText("");
				tfDiaChi.setText("");
				tfEmail.setText("");
				tfSDT.setText("");
				tfNgayThamGia.setText(setDateNow());
				labelIMG.setIcon(null);
				labelIMG.setText("Ảnh 3 x 4");
			}
		});
		lblNewLabel_3.setToolTipText("Click Me!!!");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon(KhachHangForm.class.getResource("/icon/icons8-add-24.png")));
		lblNewLabel_3.setBounds(1026, 50, 32, 34);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setIcon(new ImageIcon(KhachHangForm.class.getResource("/icon/search-24.png")));
		lblNewLabel_2.setBounds(710, 15, 48, 24);
		panel.add(lblNewLabel_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 749, 651);
		panel.add(scrollPane);

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
				try {
					KhachHang kh = KhachHangDAO.getInstance().selectAll().get(table.getSelectedRow());

					tfID.setText(kh.getIdKhachHang());
					tfTen.setText(kh.getTenKhachHang());
					tfDiaChi.setText(kh.getDiaChi());
					tfEmail.setText(kh.getEmail());
					tfSDT.setText(kh.getSdt());
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					tfNgayThamGia.setText(sdf.format(kh.getNgayThamGia()));

					labelStatus.setText("Status: " + kh.getStatus());
					
					if (kh.getImg() == null) {
						labelIMG.setIcon(null);
						labelIMG.setText("Khách hàng chưa có ảnh!");
					} else {

						Blob blob = kh.getImg();
						byte[] by = blob.getBytes(1, (int) blob.length());
						ImageIcon ii = new ImageIcon(by);
						Image i = ii.getImage().getScaledInstance(labelIMG.getWidth(), labelIMG.getHeight(),
								Image.SCALE_SMOOTH);
						ii = new ImageIcon(i);

						labelIMG.setText("");
						labelIMG.setIcon(ii);

						
					}

				} catch (Exception e2) {
					System.out.println(e2);
				}

			}
		});
		table.getTableHeader().setFont(SetFont.font());
		table.getTableHeader().setBackground(SetColor.blueOp);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "New column", "New column", "New column", "New column" }));
		scrollPane.setViewportView(table);
		setDefaultTable();

		JLabel lblNewLabel = new JLabel("Thêm khách hàng");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		lblNewLabel.setFont(SetFont.font1());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(840, 51, 232, 34);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ID khách hàng");
		lblNewLabel_1.setFont(SetFont.font1_());
		lblNewLabel_1.setBounds(796, 114, 154, 26);
		panel.add(lblNewLabel_1);

		tfID = new JTextField();
		tfID.setEditable(false);
		tfID.setText(setIDKhachHang());
		tfID.setFont(SetFont.fontDetails());
		tfID.setBounds(795, 151, 155, 26);
		panel.add(tfID);
		tfID.setColumns(10);

		tfTen = new JTextField();
		tfTen.setFont(SetFont.fontDetails());
		tfTen.setColumns(10);
		tfTen.setBounds(988, 151, 155, 26);
		panel.add(tfTen);

		JLabel lblNewLabel_1_1 = new JLabel("Tên khách hàng");
		lblNewLabel_1_1.setFont(SetFont.font1_());
		lblNewLabel_1_1.setBounds(989, 114, 154, 26);
		panel.add(lblNewLabel_1_1);

		tfSDT = new JTextField();
		tfSDT.setFont(SetFont.fontDetails());
		tfSDT.setColumns(10);
		tfSDT.setBounds(988, 250, 155, 26);
		panel.add(tfSDT);

		JLabel lblNewLabel_1_1_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_1_1.setFont(SetFont.font1_());
		lblNewLabel_1_1_1.setBounds(989, 213, 154, 26);
		panel.add(lblNewLabel_1_1_1);

		tfDiaChi = new JTextField();
		tfDiaChi.setFont(SetFont.fontDetails());
		tfDiaChi.setColumns(10);
		tfDiaChi.setBounds(795, 250, 155, 26);
		panel.add(tfDiaChi);

		JLabel lblNewLabel_1_2 = new JLabel("Địa chỉ");
		lblNewLabel_1_2.setFont(SetFont.font1_());
		lblNewLabel_1_2.setBounds(796, 213, 154, 26);
		panel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Ảnh");
		lblNewLabel_1_1_1_1.setFont(SetFont.font1_());
		lblNewLabel_1_1_1_1.setBounds(795, 405, 93, 26);
		panel.add(lblNewLabel_1_1_1_1);

		tfEmail = new JTextField();
		tfEmail.setFont(SetFont.fontDetails());
		tfEmail.setColumns(10);
		tfEmail.setBounds(796, 347, 155, 26);
		panel.add(tfEmail);

		JLabel lblNewLabel_1_2_1 = new JLabel("Email");
		lblNewLabel_1_2_1.setFont(SetFont.font1_());
		lblNewLabel_1_2_1.setBounds(797, 310, 154, 26);
		panel.add(lblNewLabel_1_2_1);

		JButton btnHy = new JButton("Hủy");
		btnHy.setIcon(new ImageIcon(KhachHangForm.class.getResource("/icon/close-24.png")));
		btnHy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insert = "";
				tfID.setText(setIDKhachHang());
				tfTen.setText("");
				tfDiaChi.setText("");
				tfEmail.setText("");
				tfSDT.setText("");
				tfNgayThamGia.setText(setDateNow());
				labelIMG.setIcon(null);
				labelIMG.setText("Ảnh 3 x 4");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnHy.setForeground(SetColor.whiteFont);
				btnHy.setBackground(SetColor.redB);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnHy.setForeground(Color.black);
				btnHy.setBackground(Color.white);
			}
		});
		btnHy.setFont(SetFont.font1_());
		btnHy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHy.setBounds(1006, 582, 122, 30);
		panel.add(btnHy);

		JButton btnNewButton_1 = new JButton("Upload");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
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
					System.out.println(insert);

				} else
					JOptionPane.showMessageDialog(null, "Lỗi file!");
			}
		});
		btnNewButton_1.setFont(SetFont.font());
		btnNewButton_1.setBounds(824, 657, 100, 26);
		panel.add(btnNewButton_1);

		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setIcon(new ImageIcon(KhachHangForm.class.getResource("/icon/icons8-ok-24.png")));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String id = tfID.getText();
					String ten = tfTen.getText();
					String diaChi = tfDiaChi.getText();
					String email = tfEmail.getText();
					String sdt = tfSDT.getText();
					Timestamp ngayThamGia = new Timestamp(System.currentTimeMillis());
					if (ten.equals("") || ten == null || sdt.equals("") || sdt == null)
						JOptionPane.showMessageDialog(null, "Tên và SDT không được để trống!");
					else if (checkID()) {
						if (insert.equals("")) {
							KhachHang kh = new KhachHang(id, ten, diaChi, email, sdt, ngayThamGia);
							int check = KhachHangDAO.getInstance().insertNotIMG(kh);
							if (check > 0) {
								JOptionPane.showMessageDialog(null, "Thêm khách hàng thành công!");
								loadDataToTable(KhachHangDAO.getInstance().selectAll());
								insert = "";
							} else {
								JOptionPane.showMessageDialog(null, "Thêm thất bại!");
								insert = "";
							}
						} else {
							KhachHang kh = new KhachHang(id, ten, diaChi, email, sdt, ngayThamGia, null, 1);

							int check = KhachHangDAO.getInstance().insert(kh);
							if (check > 0) {
								JOptionPane.showMessageDialog(null, "Thêm khách hàng thành công!");
								loadDataToTable(KhachHangDAO.getInstance().selectAll());
								insert = "";
							} else {
								JOptionPane.showMessageDialog(null, "Thêm thất bại!");
								insert = "";
							}
						}
						tfID.setText(setIDKhachHang());
						tfTen.setText("");
						tfDiaChi.setText("");
						tfEmail.setText("");
						tfSDT.setText("");
						tfNgayThamGia.setText(setDateNow());
						labelIMG.setIcon(null);
						labelIMG.setText("Ảnh 3 x 4");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(SetColor.green);
				btnNewButton.setForeground(SetColor.whiteFont);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(Color.white);
				btnNewButton.setForeground(Color.black);
			}
		});
		btnNewButton.setFont(SetFont.font1_());
		btnNewButton.setBounds(1006, 478, 122, 30);
		panel.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectedRow() == -1)
					JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng để xóa!");
				else {
					int answ = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn xóa khách hàng này?", "Cảnh báo",
							JOptionPane.YES_NO_OPTION);
					if (answ == JOptionPane.YES_OPTION) {
						KhachHangDAO.getInstance().delete(getKhachHangSelect());
						loadDataToTable(KhachHangDAO.getInstance().selectAll());
					}
				}
			}
		});
		btnNewButton_2.setFont(SetFont.font());
		btnNewButton_2.setIcon(new ImageIcon(KhachHangForm.class.getResource("/icon/icons8-delete-24.png")));
		btnNewButton_2.setBounds(10, 11, 79, 30);
		panel.add(btnNewButton_2);

		JButton btnNewButton_2_1_1 = new JButton("Nhập excel");
		btnNewButton_2_1_1.addMouseListener(new MouseAdapter() {
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
							XSSFCell idkhachhang = excelRow.getCell(0);
							XSSFCell ten = excelRow.getCell(1);
							XSSFCell diachi = excelRow.getCell(2);
							XSSFCell email = excelRow.getCell(3);
							XSSFCell sdt = excelRow.getCell(4);
							XSSFCell ngaythamgia = excelRow.getCell(5);

							model.addRow(new Object[] { idkhachhang, ten, diachi, email, sdt, ngaythamgia });
						}
						JOptionPane.showMessageDialog(null, "Thêm thành công!");
						int answ = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm vào csdl không", "Thông báo",
								JOptionPane.YES_NO_OPTION);
						if (answ == JOptionPane.YES_OPTION) {
							for (int i = rowBanDau; i <= model.getRowCount(); i++) {

								String id = model.getValueAt(i, 0).toString();
								String ten = model.getValueAt(i, 1).toString();
								String diachi = model.getValueAt(i, 2).toString();
								String email = model.getValueAt(i, 3).toString();
								String sdt = model.getValueAt(i, 4).toString();
								java.sql.Timestamp tgnhap = (java.sql.Timestamp) model.getValueAt(i, 5);

								KhachHang kh = new KhachHang(id, ten, diachi, email, sdt, tgnhap);
								KhachHangDAO.getInstance().insertNotIMG(kh);
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
		btnNewButton_2_1_1.setFont(SetFont.font());
		btnNewButton_2_1_1.setIcon(new ImageIcon(KhachHangForm.class.getResource("/icon/icons8-import-csv-24.png")));
		btnNewButton_2_1_1.setBounds(296, 11, 115, 30);
		panel.add(btnNewButton_2_1_1);

		JButton btnNewButton_2_2 = new JButton("Xuất excel");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					JFileChooser jFileChooser = new JFileChooser();
					jFileChooser.showSaveDialog(null);
					File saveFile = jFileChooser.getSelectedFile();
					if (saveFile != null) {
						saveFile = new File(saveFile.toString() + ".xlsx");
						Workbook wb = new XSSFWorkbook();
						Sheet sheet = wb.createSheet("Khách hàng");

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
		btnNewButton_2_2.setFont(SetFont.font());
		btnNewButton_2_2.setIcon(new ImageIcon(KhachHangForm.class.getResource("/icon/icons8-export-excel-24.png")));
		btnNewButton_2_2.setBounds(180, 11, 115, 30);
		panel.add(btnNewButton_2_2);

		tfSearch = new JTextField();
		tfSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				loadDataToTable(TimKiemKhachHang.byALL(tfSearch.getText()));
			}
		});
		tfSearch.setFont(SetFont.fontDetails());
		tfSearch.setColumns(10);
		tfSearch.setBounds(644, 11, 115, 30);
		panel.add(tfSearch);

		tfNgayThamGia = new JTextField();
		tfNgayThamGia.setEditable(false);
		tfNgayThamGia.setText(setDateNow());
		tfNgayThamGia.setFont(SetFont.fontDetails());
		tfNgayThamGia.setColumns(10);
		tfNgayThamGia.setBounds(988, 347, 155, 26);
		panel.add(tfNgayThamGia);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Ngày tham gia");
		lblNewLabel_1_2_1_1.setFont(SetFont.font1_());
		lblNewLabel_1_2_1_1.setBounds(989, 310, 154, 26);
		panel.add(lblNewLabel_1_2_1_1);

		labelIMG = new JLabel("Ảnh 3 x 4");
		labelIMG.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelIMG.setHorizontalAlignment(SwingConstants.CENTER);
		labelIMG.setBounds(794, 442, 155, 204);
		panel.add(labelIMG);

		JButton btnCpNht = new JButton("Cập nhật");
		btnCpNht.setIcon(new ImageIcon(KhachHangForm.class.getResource("/icon/icons8-done-24.png")));
		btnCpNht.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {

					String id = tfID.getText();
					String ten = tfTen.getText();
					String diaChi = tfDiaChi.getText();
					String email = tfEmail.getText();
					String sdt = tfSDT.getText();

					if (insert.equals("")) {
						KhachHang kh = new KhachHang(id, ten, diaChi, email, sdt);
						int check = KhachHangDAO.getInstance().updateNotIMG(kh);
						if (check > 0) {
							JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
							loadDataToTable(KhachHangDAO.getInstance().selectAll());
						} else
							JOptionPane.showMessageDialog(null, "Cập nhật thất bại!");

					} else {
						Blob blob = null;
						KhachHang kh = new KhachHang(id, ten, diaChi, email, sdt, blob, 1);

						int check = KhachHangDAO.getInstance().update(kh);
						if (check > 0) {
							JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
							loadDataToTable(KhachHangDAO.getInstance().selectAll());
							insert = "";
						} else {
							JOptionPane.showMessageDialog(null, "Cập nhật thất bại!");
							insert = "";
						}
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnCpNht.setForeground(SetColor.green);
				btnCpNht.setBackground(SetColor.yellow);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCpNht.setForeground(Color.black);
				btnCpNht.setBackground(SetColor.whiteFont);
			}
		});
		btnCpNht.setFont(SetFont.font1_());
		btnCpNht.setBounds(1006, 531, 122, 30);
		panel.add(btnCpNht);

		JDateChooser chooseFrom = new JDateChooser();
		chooseFrom.setDateFormatString("dd/MM/yyyy");
		chooseFrom.setBounds(414, 11, 105, 30);
		panel.add(chooseFrom);

		JDateChooser chooseTo = new JDateChooser();
		chooseTo.setDateFormatString("dd/MM/yyyy");
		chooseTo.setBounds(529, 11, 105, 30);
		panel.add(chooseTo);

		JButton btnNewButton_2_1 = new JButton("Allow");
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				KhachHangDAO.getInstance().allowUser(getKhachHangSelect());
			}
		});
		btnNewButton_2_1.setIcon(new ImageIcon(KhachHangForm.class.getResource("/icon/icons8-done-24.png")));
		btnNewButton_2_1.setFont(null);
		btnNewButton_2_1.setBounds(90, 11, 90, 30);
		panel.add(btnNewButton_2_1);

		labelStatus = new JLabel("Status: ");
		labelStatus.setBounds(896, 120, 54, 14);
		panel.add(labelStatus);
	}

	private String setIDKhachHang() {
		ArrayList<KhachHang> list = KhachHangDAO.getInstance().selectAll();
		int code = 1;
		for (KhachHang khachHang : list) {
			int id = Integer.parseInt(khachHang.getIdKhachHang().substring(2, khachHang.getIdKhachHang().length()));
			if (id != code)
				return "kh" + code;
			else
				code++;
		}

		return "kh" + Math.addExact(list.size(), 1);
	}

	private String setDateNow() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(new Date());
	}

	private boolean checkID() {
		ArrayList<KhachHang> list = KhachHangDAO.getInstance().selectAll();
		for (KhachHang khachHang : list) {
			if (khachHang.getIdKhachHang().equals(tfID.getText())) {
				JOptionPane.showMessageDialog(null, "ID khách hàng đã tồn tại!");
				return false;
			}
		}
		return true;
	}

	private void openFile(String file) {
		try {
			File path = new File(file);
			Desktop.getDesktop().open(path);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static KhachHang getKhachHangSelect() {
		return KhachHangDAO.getInstance().selectAll().get(table.getSelectedRow());
	}

	public static String getInsert() {
		return insert;
	}

	public static void setInsert(String insert) {
		KhachHangForm.insert = insert;
	}
}
