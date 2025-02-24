package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import color.SetColor;
import controller.FormatToVND;
import controller.XuatPDF;
import dao.ChiTietPhieuNhapDAO;
import font.SetFont;
import model.ChiTietPhieu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DetailPhieuNhap extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String[] columName = { "ID đơn nhập", "ID sản phẩm", "Tên sản phẩm", "Bảo hành", "Số lượng ", "Đơn giá" };
	private static JTable table;
	private static DefaultTableModel tableModel;
	private JTextField textField;
	private JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetailPhieuNhap frame = new DetailPhieuNhap();
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.setTitle("Chi tiết đơn hàng " + PhieuNhapForm.getPhieuNhapSelect().getIdPhieu());
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

	public static void loadDataToTable(ArrayList<ChiTietPhieu> phieu) {
		try {
			tableModel.setRowCount(0);
			for (ChiTietPhieu i : phieu) {
				DefaultTableCellRenderer renderRight = new DefaultTableCellRenderer();
				renderRight.setHorizontalAlignment(JLabel.RIGHT);

				DefaultTableCellRenderer renderCenter = new DefaultTableCellRenderer();
				renderCenter.setHorizontalAlignment(JLabel.CENTER);

//				table.getColumnModel().getColumn(2).setCellRenderer(renderCenter);
				table.getColumnModel().getColumn(4).setCellRenderer(renderCenter);
				table.getColumnModel().getColumn(5).setCellRenderer(renderRight);

				String gia = FormatToVND.vnd(i.getDonGia());

				tableModel.addRow(new Object[] { i.getIdPhieu(), i.getIdSanPham(), i.getTenSanPham(), i.getBaoHanh(),
						i.getSoLuong(), gia });
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
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(500);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(200);
		loadDataToTable(
				ChiTietPhieuNhapDAO.getInstance().selectAllById(PhieuNhapForm.getPhieuNhapSelect().getIdPhieu()));
	}

	public DetailPhieuNhap() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 683, 710);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Chi tiết phiếu nhập",
				new ImageIcon(DetailPhieuNhap.class.getResource("/icon/icons8-about-12.png")), panel, null);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setIcon(new ImageIcon(DetailPhieuNhap.class.getResource("/icon/icons8-search-24.png")));
		lblNewLabel_1.setBounds(626, 16, 37, 24);
		panel.add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 50, 678, 632);
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
		table.getTableHeader().setBackground(SetColor.blueOp);
		table.getTableHeader().setFont(SetFont.fontHeaderTable());
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "New column", "New column", "New column", "New column" }));
		scrollPane.setViewportView(table);
		setDefaultTable();

		JButton btnNewButton = new JButton("Chi tiết sản phẩm");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectedRow() == -1)
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm để xem chi tiết!");
				else {
					ChiTietSP.setId(getChiTietPhieuSelect().getIdRieng());
					ChiTietSP.main(null);
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(DetailPhieuNhap.class.getResource("/icon/icons8-details-24.png")));
		btnNewButton.setBounds(10, 11, 180, 33);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Xuất excel");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					JFileChooser jFileChooser = new JFileChooser();
					jFileChooser.showSaveDialog(null);
					File saveFile = jFileChooser.getSelectedFile();
					if (saveFile != null) {
						saveFile = new File(saveFile.toString() + ".xlsx");
						Workbook wb = new XSSFWorkbook();
						Sheet sheet = wb.createSheet("Phiếu nhập");

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
		btnNewButton_1.setIcon(new ImageIcon(DetailPhieuNhap.class.getResource("/icon/icons8-export-excel-24.png")));
		btnNewButton_1.setBounds(200, 11, 124, 33);
		panel.add(btnNewButton_1);

		comboBox = new JComboBox<>(new DefaultComboBoxModel<String>(
				new String[] { "Sắp xếp", "Số lượng tăng", "Số lượng giảm", "Đơn giá tăng", "Đơn giá giảm" }));
		comboBox.setBounds(334, 11, 145, 33);
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String src = comboBox.getSelectedItem().toString();
				if (src.equals("Số lượng tăng"))
					loadDataToTable(soLuongTang());
				else if (src.equals("Số lượng giảm"))
					loadDataToTable(soLuongGiam());
				else if (src.equals("Đơn giá tăng"))
					loadDataToTable(donGiaTang());
				else if (src.equals("Đơn giá giảm"))
					loadDataToTable(donGiaGiam());

			}
		});
		panel.add(comboBox);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				loadDataToTable(search(textField.getText()));
			}
		});
		textField.setBounds(489, 11, 179, 33);
		panel.add(textField);
		textField.setColumns(10);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Hóa đơn", new ImageIcon(DetailPhieuNhap.class.getResource("/icon/icons8-bill-12.png")),
				panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Hóa đơn file PNG hoặc JPG");
		lblNewLabel.setBackground(SystemColor.controlHighlight);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(22, 47, 631, 635);
		panel_1.add(lblNewLabel);

		JButton btnNewButton_3 = new JButton("In PDF");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				XuatPDF xuatpdf = new XuatPDF();
				xuatpdf.taoPhieuNhap(PhieuNhapForm.getPhieuNhapSelect().getIdPhieu());
			}
		});
		btnNewButton_3.setBounds(22, 11, 89, 23);
		panel_1.add(btnNewButton_3);
	}

	private void openFile(String file) {
		try {
			File path = new File(file);
			Desktop.getDesktop().open(path);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private ArrayList<ChiTietPhieu> soLuongTang() {
		ArrayList<ChiTietPhieu> list = ChiTietPhieuNhapDAO.getInstance()
				.selectAllById(PhieuNhapForm.getPhieuNhapSelect().getIdPhieu());
		ArrayList<ChiTietPhieu> ctp = new ArrayList<ChiTietPhieu>();

		for (ChiTietPhieu chiTietPhieu : list) {
			ctp.add(chiTietPhieu);
		}

		Collections.sort(list, new Comparator<ChiTietPhieu>() {

			@Override
			public int compare(ChiTietPhieu o1, ChiTietPhieu o2) {
				if (o1.getSoLuong() > o2.getSoLuong())
					return 1;
				if (o1.getSoLuong() < o2.getSoLuong())
					return -1;
				return 0;
			}
		});
		return ctp;
	}

	private ArrayList<ChiTietPhieu> soLuongGiam() {
		ArrayList<ChiTietPhieu> list = ChiTietPhieuNhapDAO.getInstance()
				.selectAllById(PhieuNhapForm.getPhieuNhapSelect().getIdPhieu());
		ArrayList<ChiTietPhieu> ctp = new ArrayList<ChiTietPhieu>();

		for (ChiTietPhieu chiTietPhieu : list) {
			ctp.add(chiTietPhieu);
		}

		Collections.sort(list, new Comparator<ChiTietPhieu>() {

			@Override
			public int compare(ChiTietPhieu o1, ChiTietPhieu o2) {
				if (o1.getSoLuong() > o2.getSoLuong())
					return -1;
				if (o1.getSoLuong() < o2.getSoLuong())
					return 1;
				return 0;
			}
		});
		return ctp;
	}

	private ArrayList<ChiTietPhieu> donGiaTang() {
		ArrayList<ChiTietPhieu> list = ChiTietPhieuNhapDAO.getInstance()
				.selectAllById(PhieuNhapForm.getPhieuNhapSelect().getIdPhieu());
		ArrayList<ChiTietPhieu> ctp = new ArrayList<ChiTietPhieu>();

		for (ChiTietPhieu chiTietPhieu : list) {
			ctp.add(chiTietPhieu);
		}

		Collections.sort(list, new Comparator<ChiTietPhieu>() {

			@Override
			public int compare(ChiTietPhieu o1, ChiTietPhieu o2) {
				if (o1.getDonGia() > o2.getDonGia())
					return 1;
				if (o1.getDonGia() < o2.getDonGia())
					return -1;
				return 0;
			}
		});
		return ctp;
	}

	private ArrayList<ChiTietPhieu> donGiaGiam() {
		ArrayList<ChiTietPhieu> list = ChiTietPhieuNhapDAO.getInstance()
				.selectAllById(PhieuNhapForm.getPhieuNhapSelect().getIdPhieu());
		ArrayList<ChiTietPhieu> ctp = new ArrayList<ChiTietPhieu>();

		for (ChiTietPhieu chiTietPhieu : list) {
			ctp.add(chiTietPhieu);
		}

		Collections.sort(list, new Comparator<ChiTietPhieu>() {

			@Override
			public int compare(ChiTietPhieu o1, ChiTietPhieu o2) {
				if (o1.getDonGia() > o2.getDonGia())
					return -1;
				if (o1.getDonGia() < o2.getDonGia())
					return 1;
				return 0;
			}
		});
		return ctp;
	}

	private ArrayList<ChiTietPhieu> search(String key) {
		ArrayList<ChiTietPhieu> list = ChiTietPhieuNhapDAO.getInstance()
				.selectAllById(PhieuNhapForm.getPhieuNhapSelect().getIdPhieu());
		System.out.println(list.size());
		ArrayList<ChiTietPhieu> ctp = new ArrayList<ChiTietPhieu>();

		for (ChiTietPhieu chiTietPhieu : list) {
			if (chiTietPhieu.getIdPhieu().toLowerCase().contains(key.toLowerCase())
					|| chiTietPhieu.getIdSanPham().toLowerCase().contains(key.toLowerCase())
					|| chiTietPhieu.getTenSanPham().toLowerCase().contains(key.toLowerCase())
					|| String.valueOf(chiTietPhieu.getSoLuong()).contains(key.toLowerCase())
					|| String.valueOf(chiTietPhieu.getDonGia()).contains(key.toLowerCase()))
				ctp.add(chiTietPhieu);
		}
		return ctp;
	}

	private ChiTietPhieu getChiTietPhieuSelect() {
		return ChiTietPhieuNhapDAO.getInstance().selectAllById(PhieuNhapForm.getPhieuNhapSelect().getIdPhieu())
				.get(table.getSelectedRow());
	}
}
