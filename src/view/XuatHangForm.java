package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import color.SetColor;
import controller.FormatToVND;
import controller.LuuTam;
import controller.TimKiemNhapHang;
import controller.XuatPDF;
import dao.ChiTietPhieuXuatDAO;
import dao.KhachHangDAO;
import dao.PhieuXuatDAO;
import dao.caseDAO;
import dao.cpuDAO;
import dao.hddDAO;
import dao.mainDAO;
import dao.psuDAO;
import dao.ramDAO;
import dao.ssdDAO;
import dao.vgaDAO;
import font.SetFont;
import model.Case;
import model.ChiTietPhieu;
import model.PhieuXuat;
import model.cpu;
import model.hdd;
import model.mainboard;
import model.psu;
import model.ram;
import model.ssd;
import model.vga;

public class XuatHangForm extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTable tableALL;
	private static JTable tableMin;
	private static DefaultTableModel tableModel;
	private static DefaultTableModel tableModelBill;
	private final String columName[] = { "ID sản phẩm", "ID", "Tên sản phẩm", "Bảo hành", "Tồn kho", "Đơn giá" };
	private final String columNameBill[] = { "ID mặt hàng", "ID sản phẩm", "Tên sản phẩm", "Bảo hành", "Số lượng",
			"Đơn giá" };
	private JTextField tfSearch;
	private JComboBox<String> comboBox_chooseProduct;
	private JButton btnNewButton_2;
	private JLabel lbTongTien1;
	private JTextField tfTongTien;
	private static double tien = 0;
	private JTextField tfSDT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhapHangForm frame = new NhapHangForm();
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

	public static void loadDataToTableCPU(ArrayList<cpu> cpu) {

		try {
			tableModel.setRowCount(0);
			for (cpu i : cpu) {
				DefaultTableCellRenderer renderRight = new DefaultTableCellRenderer();
				renderRight.setHorizontalAlignment(JLabel.RIGHT);

				DefaultTableCellRenderer renderCenter = new DefaultTableCellRenderer();
				renderCenter.setHorizontalAlignment(JLabel.CENTER);
				tableALL.getColumnModel().getColumn(4).setCellRenderer(renderCenter);

				tableALL.getColumnModel().getColumn(5).setCellRenderer(renderRight);
				String gia = FormatToVND.vnd(i.getDonGia());
				tableModel.addRow(new Object[] { i.getIdSanPham(), i.getIdCpu(), i.getNameCpu(), i.getBaoHanh(),
						i.getTonKho(), gia });
			}
		} catch (Exception e) {
		}
	}

	public static void loadDataToTableRAM(ArrayList<ram> ram) {
		try {

			tableModel.setRowCount(0);
			for (ram i : ram) {
				DefaultTableCellRenderer renderRight = new DefaultTableCellRenderer();
				renderRight.setHorizontalAlignment(JLabel.RIGHT);
				DefaultTableCellRenderer renderCenter = new DefaultTableCellRenderer();
				renderCenter.setHorizontalAlignment(JLabel.CENTER);
				tableALL.getColumnModel().getColumn(4).setCellRenderer(renderCenter);

				tableALL.getColumnModel().getColumn(5).setCellRenderer(renderRight);
				String gia = FormatToVND.vnd(i.getDonGia());
				tableModel.addRow(new Object[] { i.getIdSanPham(), i.getIdRam(), i.getTenRam(), i.getBaoHanh(),
						i.getTonkho(), gia });
			}
		} catch (Exception e) {
		}
	}

	public static void loadDataToTableVGA(ArrayList<vga> vga) {
		try {
			tableModel.setRowCount(0);
			for (vga i : vga) {
				DefaultTableCellRenderer renderRight = new DefaultTableCellRenderer();
				renderRight.setHorizontalAlignment(JLabel.RIGHT);
				DefaultTableCellRenderer renderCenter = new DefaultTableCellRenderer();
				renderCenter.setHorizontalAlignment(JLabel.CENTER);
				tableALL.getColumnModel().getColumn(4).setCellRenderer(renderCenter);

				tableALL.getColumnModel().getColumn(5).setCellRenderer(renderRight);
				String gia = FormatToVND.vnd(i.getDonGia());
				tableModel.addRow(new Object[] { i.getIdSanPham(), i.getIdVga(), i.getTenVGA(), i.getBaoHanh(),
						i.getTonKho(), gia });
			}
		} catch (Exception e) {
		}
	}

	public static void loadDataToTableMainBoard(ArrayList<mainboard> mainboards) {
		try {
			tableModel.setRowCount(0);
			for (mainboard i : mainboards) {
				DefaultTableCellRenderer renderRight = new DefaultTableCellRenderer();
				renderRight.setHorizontalAlignment(JLabel.RIGHT);
				DefaultTableCellRenderer renderCenter = new DefaultTableCellRenderer();
				renderCenter.setHorizontalAlignment(JLabel.CENTER);
				tableALL.getColumnModel().getColumn(4).setCellRenderer(renderCenter);

				tableALL.getColumnModel().getColumn(5).setCellRenderer(renderRight);
				String gia = FormatToVND.vnd(i.getDonGia());
				tableModel.addRow(new Object[] { i.getIdSanPham(), i.getIdMainboard(), i.getTenMain(), i.getBaoHanh(),
						i.getTonKho(), gia });
			}
		} catch (Exception e) {
		}
	}

	public static void loadDataToTableCASE(ArrayList<Case> cases) {
		try {
			tableModel.setRowCount(0);
			for (Case i : cases) {
				DefaultTableCellRenderer renderRight = new DefaultTableCellRenderer();
				renderRight.setHorizontalAlignment(JLabel.RIGHT);
				DefaultTableCellRenderer renderCenter = new DefaultTableCellRenderer();
				renderCenter.setHorizontalAlignment(JLabel.CENTER);
				tableALL.getColumnModel().getColumn(4).setCellRenderer(renderCenter);

				tableALL.getColumnModel().getColumn(5).setCellRenderer(renderRight);
				String gia = FormatToVND.vnd(i.getGia());
				tableModel.addRow(new Object[] { i.getIdSanPham(), i.getIdCase(), i.getTenCase(), i.getBaoHanh(),
						i.getTonKho(), gia });
			}
		} catch (Exception e) {
		}
	}

	public static void loadDataToTablePSU(ArrayList<psu> psu) {
		try {
			tableModel.setRowCount(0);
			for (psu i : psu) {
				DefaultTableCellRenderer renderRight = new DefaultTableCellRenderer();
				renderRight.setHorizontalAlignment(JLabel.RIGHT);
				DefaultTableCellRenderer renderCenter = new DefaultTableCellRenderer();
				renderCenter.setHorizontalAlignment(JLabel.CENTER);
				tableALL.getColumnModel().getColumn(4).setCellRenderer(renderCenter);

				tableALL.getColumnModel().getColumn(5).setCellRenderer(renderRight);
				String gia = FormatToVND.vnd(i.getDonGia());
				tableModel.addRow(new Object[] { i.getIdSanPham(), i.getIdNguon(), i.getTenNguon(), i.getBaoHanh(),
						i.getTonKho(), gia });
			}
		} catch (Exception e) {
		}
	}

	public static void loadDataToTableSSD(ArrayList<ssd> ssd) {
		try {
			tableModel.setRowCount(0);
			for (ssd i : ssd) {
				DefaultTableCellRenderer renderRight = new DefaultTableCellRenderer();
				renderRight.setHorizontalAlignment(JLabel.RIGHT);
				DefaultTableCellRenderer renderCenter = new DefaultTableCellRenderer();
				renderCenter.setHorizontalAlignment(JLabel.CENTER);
				tableALL.getColumnModel().getColumn(4).setCellRenderer(renderCenter);

				tableALL.getColumnModel().getColumn(5).setCellRenderer(renderRight);
				String gia = FormatToVND.vnd(i.getGia());
				tableModel.addRow(new Object[] { i.getIdSanPham(), i.getIdSdd(), i.getTenSsd(), i.getBaoHanh(),
						i.getTonKho(), gia });
			}
		} catch (Exception e) {
		}
	}

	public static void loadDataToTableHDD(ArrayList<hdd> hdd) {
		try {
			tableModel.setRowCount(0);
			for (hdd i : hdd) {
				DefaultTableCellRenderer renderRight = new DefaultTableCellRenderer();
				renderRight.setHorizontalAlignment(JLabel.RIGHT);
				DefaultTableCellRenderer renderCenter = new DefaultTableCellRenderer();
				renderCenter.setHorizontalAlignment(JLabel.CENTER);
				tableALL.getColumnModel().getColumn(4).setCellRenderer(renderCenter);

				tableALL.getColumnModel().getColumn(5).setCellRenderer(renderRight);
				String gia = FormatToVND.vnd(i.getGia());
				tableModel.addRow(new Object[] { i.getIdSanPham(), i.getIdhHdd(), i.getTenHdd(), i.getBaoHanh(),
						i.getTonKho(), gia });
			}
		} catch (Exception e) {
		}
	}

	public void setDefaultTable(String isSelect) {
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columName);
		tableALL.setDefaultEditor(Object.class, null);
		tableALL.setModel(tableModel);
		tableALL.getColumnModel().getColumn(0).setPreferredWidth(200);
		tableALL.getColumnModel().getColumn(1).setPreferredWidth(200);
		tableALL.getColumnModel().getColumn(2).setPreferredWidth(500);
		tableALL.getColumnModel().getColumn(3).setPreferredWidth(200);
		tableALL.getColumnModel().getColumn(4).setPreferredWidth(100);
		tableALL.getColumnModel().getColumn(5).setPreferredWidth(200);

		switch (isSelect) {
		case "cpu":
			loadDataToTableCPU(cpuDAO.getInstance().selectAll());
			break;
		case "ram":
			loadDataToTableRAM(ramDAO.getInstance().selectAll());
			break;
		case "vga":
			loadDataToTableVGA(vgaDAO.getInstance().selectAll());
			break;
		case "mainboard":
			loadDataToTableMainBoard(mainDAO.getInstance().selectAll());
			break;
		case "case":
			loadDataToTableCASE(caseDAO.getInstance().selectAll());
			break;
		case "psu":
			loadDataToTablePSU(psuDAO.getInstance().selectAll());
			break;
		case "hdd":
			loadDataToTableHDD(hddDAO.getInstance().selectAll());
			break;
		case "ssd":
			loadDataToTableSSD(ssdDAO.getInstance().selectAll());
			break;
//		case "banphim":
//			loadDataToTable(null);
//			break;
//		case "tainghe":
//			loadDataToTable(null);
//			break;

		default:
			break;
		}

//		loadDataToTable(SanPhamDAO.getInstance().selectAll());
	}

	public XuatHangForm() {
		setFrameIcon(new ImageIcon(NhapHangForm.class.getResource("/icon/successful-delivery-24.png")));
		setTitle("XUẤT HÀNG");
		setBounds(100, 100, 1170, 730);
		getContentPane().setLayout(null);

		tfTongTien = new JTextField();
		tfTongTien.setHorizontalAlignment(SwingConstants.TRAILING);
		tfTongTien.setText("0đ");
		tfTongTien.setFont(SetFont.font1_());
		tfTongTien.setForeground(SetColor.redB);

		tfTongTien.setOpaque(false);
		tfTongTien.setBorder(null);
		tfTongTien.setBounds(1016, 594, 136, 26);
		getContentPane().add(tfTongTien);
		tfTongTien.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setIcon(new ImageIcon(NhapHangForm.class.getResource("/icon/search-24.png")));
		lblNewLabel_1.setBounds(345, 6, 48, 22);
		getContentPane().add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 36, 750, 665);
		getContentPane().add(scrollPane);

		tableALL = new JTable() {
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
		tableALL.getTableHeader().setBackground(SetColor.blueOp);
		tableALL.getTableHeader().setFont(SetFont.fontHeaderTable());
		tableALL.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "New column", "New column", "New column", "New column" }));
		scrollPane.setViewportView(tableALL);
		setDefaultTable("cpu");

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(760, 1, 402, 585);
		getContentPane().add(scrollPane_1);

		tableMin = new JTable() {
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
		tableMin.getTableHeader().setBackground(SetColor.blueOp);
		tableMin.getTableHeader().setFont(SetFont.fontHeaderTable());
		tableMin.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "New column", "New column", "New column" }));
		scrollPane_1.setViewportView(tableMin);

//		list bill
		ArrayList<ChiTietPhieu> listXuat = new ArrayList<ChiTietPhieu>();

		ArrayList<ChiTietPhieu> sanPham = LuuTam.sanPhamXuat;

		if (sanPham.size() == 0) {
			LuuTam.tongTienXuat = 0;
			tien = LuuTam.tongTienXuat;
			tfTongTien.setText(FormatToVND.vnd(tien));
			setDefaultTableBill(listXuat);
		} else {

			for (ChiTietPhieu ChiTietPhieu : sanPham) {
				listXuat.add(ChiTietPhieu);
			}
			tien = LuuTam.tongTienXuat;
			tfTongTien.setText(FormatToVND.vnd(tien));
			setDefaultTableBill(listXuat);
		}

		JButton btnNewButton_1 = new JButton("Xóa");
		btnNewButton_1.setIcon(new ImageIcon(NhapHangForm.class.getResource("/icon/delete-24.png")));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tableMin.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm để xóa!");
				} else {
					int answ = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn xóa sản phẩm này?", "Cảnh báo",
							JOptionPane.YES_NO_OPTION);
					if (answ == JOptionPane.YES_OPTION) {
						tien -= Double.parseDouble(tableMin.getValueAt(tableMin.getSelectedRow(), 5).toString())
								* Integer.parseInt(tableMin.getValueAt(tableMin.getSelectedRow(), 4).toString());
						tfTongTien.setText(FormatToVND.vnd(tien));
						listXuat.remove(tableMin.getSelectedRow());
						JOptionPane.showMessageDialog(null, "Xóa thành công!");
						loadDataToTableBill(listXuat);
					}
				}
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(SetFont.font());
		btnNewButton_1.setBounds(885, 625, 125, 26);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("Lưu tạm");
		btnNewButton_1_1.setIcon(new ImageIcon(NhapHangForm.class.getResource("/icon/icons8-add-bookmark-24.png")));
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				ArrayList<ChiTietPhieu> list = LuuTam.sanPhamXuat;
				list.removeAll(list);

				for (ChiTietPhieu ChiTietPhieu : listXuat) {
					list.add(ChiTietPhieu);
				}

				LuuTam.tongTienXuat = tien;

			}
		});
		btnNewButton_1_1.setFont(SetFont.font());
		btnNewButton_1_1.setBounds(1026, 625, 126, 26);
		getContentPane().add(btnNewButton_1_1);

		JButton btnNewButton_1_2 = new JButton("Xuất hàng");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_2.setIcon(new ImageIcon(NhapHangForm.class.getResource("/icon/icons8-done-24.png")));
		btnNewButton_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (listXuat.size() == 0) {
					JOptionPane.showMessageDialog(null, "Không có sản phẩm nào để xuất hàng!");
				} else {

					if (tfSDT.getText().equals("") || tfSDT.getText() == null)
						JOptionPane.showMessageDialog(null, "Vui lòng nhập SDT khách hàng!");

					else if (KhachHangDAO.getInstance().selectBySDT(tfSDT.getText()) == null) {

						int themkhachhang = JOptionPane.showConfirmDialog(null,
								"Khách hàng hiện chưa tồn tại trên hệ thống, thêm khách hàng này", "Thông báo",
								JOptionPane.YES_NO_OPTION);
						if (themkhachhang == JOptionPane.YES_OPTION) {
							ArrayList<ChiTietPhieu> list = LuuTam.sanPhamXuat;
							list.removeAll(list);
							for (ChiTietPhieu ChiTietPhieu : listXuat) {
								list.add(ChiTietPhieu);
							}
							LuuTam.tongTienXuat = tien;

							LuuTam.SDT = tfSDT.getText();

							MainForm.maincontent.removeAll();
							MainForm.maincontent.add(new KhachHangForm()).setVisible(true);

							KhachHangForm.tfSDT.setText(tfSDT.getText());
						} else
							tfSDT.setText("");
					} else {

						int check = cpuDAO.getInstance().updateTonKho(listXuat, false);
						check += ramDAO.getInstance().updateTonKho(listXuat, false);
						check += vgaDAO.getInstance().updateTonKho(listXuat, false);
						check += mainDAO.getInstance().updateTonKho(listXuat, false);
						check += caseDAO.getInstance().updateTonKho(listXuat, false);
						check += psuDAO.getInstance().updateTonKho(listXuat, false);
						check += ssdDAO.getInstance().updateTonKho(listXuat, false);
						check += hddDAO.getInstance().updateTonKho(listXuat, false);
						if (check > 0) {

							JOptionPane.showMessageDialog(null, "Xuất hàng thành công!");
							System.out.println(tien);

//						String idPhieu = createIDPhieuNhap();

							Timestamp timestamp = new Timestamp(System.currentTimeMillis());

//						PhieuNhap pn = new PhieuNhap(createIDPhieuNhap(PhieuNhapDAO.getInstance().selectAll()),
//								comboBox_chooseNPP.getSelectedItem().toString(), timestamp, LoginForm.fullN, tien, 1);
//						PhieuNhapDAO.getInstance().insert(pn);

							PhieuXuat px = new PhieuXuat(createIDPhieuXuat(PhieuXuatDAO.getInstance().selectAll()),
									KhachHangDAO.getInstance().selectBySDT(tfSDT.getText()).getIdKhachHang(), timestamp,
									LoginForm.fullN, tien, 1);
							PhieuXuatDAO.getInstance().insert(px);

							for (int i = 0; i < tableMin.getRowCount(); i++) {
//							String money = (String) tableMin.getValueAt(i, 4);
//							double money1 = Double.parseDouble(money.substring(0, money.length()).trim());

//							i.getIdsanpham(), i.getIdRieng(), i.getName(),i.getBaohanh(), i.getSoLuong(), i.getGia()
								ChiTietPhieu ctp = new ChiTietPhieu(px.getIdPhieu(), (String) tableMin.getValueAt(i, 0),
										(String) tableMin.getValueAt(i, 1), (String) tableMin.getValueAt(i, 2),
										(int) tableMin.getValueAt(i, 4), (double) tableMin.getValueAt(i, 5),
										(String) tableMin.getValueAt(i, 3));
								ChiTietPhieuXuatDAO.getInstance().insert(ctp);
							}

							XuatPDF wPDF = new XuatPDF();
							wPDF.taoPhieuXuat(px.getIdPhieu());

						}
						listXuat.removeAll(listXuat);
						LuuTam.sanPhamXuat.clear();
						LuuTam.tongTienXuat = 0;
						LuuTam.SDT = "";
						tien = 0;
						tfTongTien.setText(FormatToVND.vnd(tien));
						tfSDT.setText("");
						loadDataToTableBill(listXuat);
					}

				}
			}
		});
		btnNewButton_1_2.setFont(SetFont.font());
		btnNewButton_1_2.setBounds(885, 662, 125, 26);
		getContentPane().add(btnNewButton_1_2);

		JButton btnNewButton_1_2_1 = new JButton("Hủy");
		btnNewButton_1_2_1.setIcon(new ImageIcon(NhapHangForm.class.getResource("/icon/close-24.png")));
		btnNewButton_1_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int answ = JOptionPane.showConfirmDialog(null, "Xác nhận hủy đơn hàng?", "Cảnh báo!",
						JOptionPane.YES_NO_OPTION);
				if (answ == JOptionPane.YES_OPTION) {
					listXuat.clear();
					LuuTam.sanPhamXuat.clear();
					LuuTam.tongTienXuat = 0;
					tien = 0;
					tfTongTien.setText("0đ");
					JOptionPane.showMessageDialog(null, "Đã hủy đơn hàng!");
					loadDataToTableBill(listXuat);
				}
			}
		});
		btnNewButton_1_2_1.setFont(SetFont.font());
		btnNewButton_1_2_1.setBounds(1026, 662, 126, 26);
		getContentPane().add(btnNewButton_1_2_1);

		lbTongTien1 = new JLabel("Tổng tiền:");
		lbTongTien1.setFont(SetFont.font1_());
		lbTongTien1.setForeground(SetColor.redB);
		lbTongTien1.setBounds(885, 596, 78, 23);
		getContentPane().add(lbTongTien1);

		btnNewButton_2 = new JButton("Thêm");
		btnNewButton_2.setIcon(new ImageIcon(NhapHangForm.class.getResource("/icon/icons8-add-24.png")));

		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tableALL.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Chọn sản phẩm để thêm!");
				} else {
					if (comboBox_chooseProduct.getSelectedItem().toString().equals("CPU")) {
						cpu cpu = cpuDAO.getInstance()
								.selectById(String.valueOf(tableALL.getValueAt(tableALL.getSelectedRow(), 1)));
						if (kiemTraSoLuongTonKho(cpu.getIdCpu()) == false)
							JOptionPane.showMessageDialog(null, "Sản phẩm này đã hết hàng!");
						else {
							if (kiemTraGioiHanKho(cpu.getIdCpu(), listXuat) == false)
								JOptionPane.showMessageDialog(null, "Đã đạt giới hạn số lượng trong kho");
							else {
								if (kiemTraSoLuongXuat(cpu.getIdCpu(), listXuat) == false) {
									ChiTietPhieu pn = new ChiTietPhieu(cpu.getIdSanPham(), cpu.getIdCpu(),
											cpu.getNameCpu(), 1, cpu.getDonGia(), cpu.getBaoHanh());
									listXuat.add(pn);
								}

								tien += cpu.getDonGia();
								if (listXuat.size() == 0)
									tien = 0;
								tfTongTien.setText(FormatToVND.vnd(tien));

								loadDataToTableBill(listXuat);
							}
						}
					} else if (comboBox_chooseProduct.getSelectedItem().toString().equals("RAM")) {
						ram ram = ramDAO.getInstance()
								.selectById(String.valueOf(tableALL.getValueAt(tableALL.getSelectedRow(), 1)));
						if (kiemTraSoLuongTonKho(ram.getIdRam()) == false)
							JOptionPane.showMessageDialog(null, "Sản phẩm này đã hết hàng!");
						else {
							if (kiemTraGioiHanKho(ram.getIdRam(), listXuat) == false)
								JOptionPane.showMessageDialog(null, "Đã đạt giới hạn số lượng trong kho");
							else {
								if (kiemTraSoLuongXuat(ram.getIdRam(), listXuat) == false) {
									ChiTietPhieu pn = new ChiTietPhieu(ram.getIdSanPham(), ram.getIdRam(),
											ram.getTenRam(), 1, ram.getDonGia(), ram.getBaoHanh());
									listXuat.add(pn);
								}
								tien += ram.getDonGia();
								if (listXuat.size() == 0)
									tien = 0;
								tfTongTien.setText(FormatToVND.vnd(tien));

								loadDataToTableBill(listXuat);
							}
						}
					} else if (comboBox_chooseProduct.getSelectedItem().toString().equals("VGA")) {
						vga vga = vgaDAO.getInstance()
								.selectById(String.valueOf(tableALL.getValueAt(tableALL.getSelectedRow(), 1)));
						if (kiemTraSoLuongTonKho(vga.getIdVga()) == false)
							JOptionPane.showMessageDialog(null, "Sản phẩm này đã hết hàng!");
						else {
							if (kiemTraGioiHanKho(vga.getIdVga(), listXuat) == false)
								JOptionPane.showMessageDialog(null, "Đã đạt giới hạn số lượng trong kho");
							else {
								if (kiemTraSoLuongXuat(vga.getIdVga(), listXuat) == false) {
									ChiTietPhieu pn = new ChiTietPhieu(vga.getIdSanPham(), vga.getIdVga(),
											vga.getTenVGA(), 1, vga.getDonGia(), vga.getBaoHanh());
									listXuat.add(pn);
								}
								tien += vga.getDonGia();
								if (listXuat.size() == 0)
									tien = 0;
								tfTongTien.setText(FormatToVND.vnd(tien));

								loadDataToTableBill(listXuat);
							}
						}
					} else if (comboBox_chooseProduct.getSelectedItem().toString().equals("Mainboard")) {
						mainboard mb = mainDAO.getInstance()
								.selectById(String.valueOf(tableALL.getValueAt(tableALL.getSelectedRow(), 1)));
						if (kiemTraSoLuongTonKho(mb.getIdMainboard()) == false)
							JOptionPane.showMessageDialog(null, "Sản phẩm này đã hết hàng!");
						else {
							if (kiemTraSoLuongXuat(mb.getIdMainboard(), listXuat) == false) {
								ChiTietPhieu pn = new ChiTietPhieu(mb.getIdSanPham(), mb.getIdMainboard(),
										mb.getTenMain(), 1, mb.getDonGia(), mb.getBaoHanh());
								listXuat.add(pn);
							}
							tien += mb.getDonGia();
							if (listXuat.size() == 0)
								tien = 0;
							tfTongTien.setText(FormatToVND.vnd(tien));

							loadDataToTableBill(listXuat);
						}
					} else if (comboBox_chooseProduct.getSelectedItem().toString().equals("Nguồn")) {
						psu psu = psuDAO.getInstance()
								.selectById(String.valueOf(tableALL.getValueAt(tableALL.getSelectedRow(), 1)));
						if (kiemTraSoLuongTonKho(psu.getIdNguon()) == false)
							JOptionPane.showMessageDialog(null, "Sản phẩm này đã hết hàng!");
						else {
							if (kiemTraGioiHanKho(psu.getIdNguon(), listXuat) == false)
								JOptionPane.showMessageDialog(null, "Đã đạt giới hạn số lượng trong kho");
							else {
								if (kiemTraSoLuongXuat(psu.getIdNguon(), listXuat) == false) {
									ChiTietPhieu pn = new ChiTietPhieu(psu.getIdSanPham(), psu.getIdNguon(),
											psu.getTenNguon(), 1, psu.getDonGia(), psu.getBaoHanh());
									listXuat.add(pn);
								}
								tien += psu.getDonGia();
								if (listXuat.size() == 0)
									tien = 0;
								tfTongTien.setText(FormatToVND.vnd(tien));

								loadDataToTableBill(listXuat);
							}
						}
					} else if (comboBox_chooseProduct.getSelectedItem().toString().equals("Case")) {
						Case c = caseDAO.getInstance()
								.selectById(String.valueOf(tableALL.getValueAt(tableALL.getSelectedRow(), 1)));
						if (kiemTraSoLuongTonKho(c.getIdCase()) == false)
							JOptionPane.showMessageDialog(null, "Sản phẩm này đã hết hàng!");
						else {
							if (kiemTraGioiHanKho(c.getIdCase(), listXuat) == false)
								JOptionPane.showMessageDialog(null, "Đã đạt giới hạn số lượng trong kho");
							else {
								if (kiemTraSoLuongXuat(c.getIdCase(), listXuat) == false) {
									ChiTietPhieu pn = new ChiTietPhieu(c.getIdSanPham(), c.getIdCase(), c.getTenCase(),
											1, c.getGia(), c.getBaoHanh());
									listXuat.add(pn);
								}
								tien += c.getGia();
								if (listXuat.size() == 0)
									tien = 0;
								tfTongTien.setText(FormatToVND.vnd(tien));

								loadDataToTableBill(listXuat);
							}
						}
					} else if (comboBox_chooseProduct.getSelectedItem().toString().equals("SSD")) {
						ssd ssd = ssdDAO.getInstance()
								.selectById(String.valueOf(tableALL.getValueAt(tableALL.getSelectedRow(), 1)));
						if (kiemTraSoLuongTonKho(ssd.getIdSdd()) == false)
							JOptionPane.showMessageDialog(null, "Sản phẩm này đã hết hàng!");
						else {
							if (kiemTraGioiHanKho(ssd.getIdSdd(), listXuat) == false)
								JOptionPane.showMessageDialog(null, "Đã đạt giới hạn số lượng trong kho");
							else {
								if (kiemTraSoLuongXuat(ssd.getIdSdd(), listXuat) == false) {
									ChiTietPhieu pn = new ChiTietPhieu(ssd.getIdSanPham(), ssd.getIdSdd(),
											ssd.getTenSsd(), 1, ssd.getGia(), ssd.getBaoHanh());
									listXuat.add(pn);
								}
								tien += ssd.getGia();
								if (listXuat.size() == 0)
									tien = 0;
								tfTongTien.setText(FormatToVND.vnd(tien));

								loadDataToTableBill(listXuat);
							}
						}
					} else if (comboBox_chooseProduct.getSelectedItem().toString().equals("HDD")) {
						hdd hdd = hddDAO.getInstance()
								.selectById(String.valueOf(tableALL.getValueAt(tableALL.getSelectedRow(), 1)));
						if (kiemTraSoLuongTonKho(hdd.getIdhHdd()) == false)
							JOptionPane.showMessageDialog(null, "Sản phẩm này đã hết hàng!");
						else {
							if (kiemTraGioiHanKho(hdd.getIdhHdd(), listXuat) == false)
								JOptionPane.showMessageDialog(null, "Đã đạt giới hạn số lượng trong kho");
							else {
								if (kiemTraSoLuongXuat(hdd.getIdhHdd(), listXuat) == false) {
									ChiTietPhieu pn = new ChiTietPhieu(hdd.getIdSanPham(), hdd.getIdhHdd(),
											hdd.getTenHdd(), 1, hdd.getGia(), hdd.getBaoHanh());
									listXuat.add(pn);
								}
								tien += hdd.getGia();
								if (listXuat.size() == 0)
									tien = 0;
								tfTongTien.setText(FormatToVND.vnd(tien));

								loadDataToTableBill(listXuat);
							}
						}
					}

				}
			}
		});
		btnNewButton_2.setFont(SetFont.font());
		btnNewButton_2.setBounds(648, 3, 104, 30);
		getContentPane().add(btnNewButton_2);

//		ArrayList<NhaPhanPhoi> list = NhaPhanPhoiDAO.getInstance().selectAll();
//		String[] combo = new String[list.size()];
//		for (int i = 0; i < list.size(); i++) {
//			NhaPhanPhoi npp = list.get(i);
//			combo[i] = npp.getIdNPP();
//		}

		String[] allProduct = { "CPU", "RAM", "VGA", "Mainboard", "Case", "Nguồn", "SSD", "HDD", "Bàn phím", "Tai nghe",
				"Ổ cứng" };
		comboBox_chooseProduct = new JComboBox<>(allProduct);
		comboBox_chooseProduct.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboBox_chooseProduct.getSelectedItem().toString().equals("CPU")) {
					setDefaultTable("cpu");
				} else if (comboBox_chooseProduct.getSelectedItem().toString().equals("RAM")) {
					setDefaultTable("ram");
				} else if (comboBox_chooseProduct.getSelectedItem().toString().equals("VGA")) {
					setDefaultTable("vga");
				} else if (comboBox_chooseProduct.getSelectedItem().toString().equals("Mainboard")) {
					setDefaultTable("mainboard");
				} else if (comboBox_chooseProduct.getSelectedItem().toString().equals("Case")) {
					setDefaultTable("case");
				} else if (comboBox_chooseProduct.getSelectedItem().toString().equals("Nguồn")) {
					setDefaultTable("psu");
				} else if (comboBox_chooseProduct.getSelectedItem().toString().equals("SSD")) {
					setDefaultTable("ssd");
				} else if (comboBox_chooseProduct.getSelectedItem().toString().equals("HDD")) {
					setDefaultTable("hdd");
				}

			}
		});
		comboBox_chooseProduct.setFont(SetFont.font());
		comboBox_chooseProduct.setBounds(405, 3, 116, 30);
		getContentPane().add(comboBox_chooseProduct);

		tfSearch = new JTextField();
		tfSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String prd = comboBox_chooseProduct.getSelectedItem().toString();
				String key = tfSearch.getText();
				if (prd.equals("CPU")) {
					loadDataToTableCPU(TimKiemNhapHang.byCPU(key));
				} else if (prd.equals("RAM")) {
					loadDataToTableRAM(TimKiemNhapHang.byRAM(key));
				} else if (prd.equals("VGA")) {
					loadDataToTableVGA(TimKiemNhapHang.byVGA(key));
				} else if (prd.equals("Mainboard")) {
					loadDataToTableMainBoard(TimKiemNhapHang.byMainboard(key));
				} else if (prd.equals("Case")) {
					loadDataToTableCASE(TimKiemNhapHang.byCase(key));
				} else if (prd.equals("Nguồn")) {
					loadDataToTablePSU(TimKiemNhapHang.byNguon(key));
				} else if (prd.equals("SSD")) {
					loadDataToTableSSD(TimKiemNhapHang.bySSD(key));
				} else if (prd.equals("HDD")) {
					loadDataToTableHDD(TimKiemNhapHang.byHDD(key));
				}

			}
		});
		tfSearch.setName("");
		tfSearch.setToolTipText("");
		tfSearch.setBounds(179, 3, 215, 30);
		getContentPane().add(tfSearch);
		tfSearch.setColumns(10);

		JButton btnNewButton_2_1 = new JButton("Chi tiết sản phẩm");
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (tableALL.getSelectedRow() == -1)
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm để xem!");
				else {
//					"CPU", "RAM", "VGA", "Mainboard", "Case", "Nguồn", "Màn hình", "Chuột", "Bàn phím",
//					"Tai nghe"

					String products = comboBox_chooseProduct.getSelectedItem().toString();
					if (products.equals("CPU")) {
						cpu cpu = cpuDAO.getInstance()
								.selectById(String.valueOf(tableALL.getValueAt(tableALL.getSelectedRow(), 1)));
						ChiTietSP.setId(cpu.getIdCpu());
						ChiTietSP.main(null);
					} else if (products.equals("RAM")) {
						ram ram = ramDAO.getInstance()
								.selectById(String.valueOf(tableALL.getValueAt(tableALL.getSelectedRow(), 1)));
						ChiTietSP.setId(ram.getIdRam());
						ChiTietSP.main(null);
					} else if (products.equals("VGA")) {
						vga vga = vgaDAO.getInstance()
								.selectById(String.valueOf(tableALL.getValueAt(tableALL.getSelectedRow(), 1)));
						ChiTietSP.setId(vga.getIdVga());
						ChiTietSP.main(null);
					} else if (products.equals("Mainboard")) {
						mainboard mb = mainDAO.getInstance()
								.selectById(String.valueOf(tableALL.getValueAt(tableALL.getSelectedRow(), 1)));
						ChiTietSP.setId(mb.getIdMainboard());
						ChiTietSP.main(null);
					} else if (products.equals("Case")) {
						Case c = caseDAO.getInstance()
								.selectById(tableALL.getValueAt(tableALL.getSelectedRow(), 1).toString());
						ChiTietSP.setId(c.getIdCase());
						ChiTietSP.main(null);
					} else if (products.equals("Nguồn")) {
						psu pus = psuDAO.getInstance()
								.selectById(tableALL.getValueAt(tableALL.getSelectedRow(), 1).toString());
						ChiTietSP.setId(pus.getIdNguon());
						ChiTietSP.main(null);
					} else if (products.equals("SSD")) {
						ssd ssd = ssdDAO.getInstance()
								.selectById(tableALL.getValueAt(tableALL.getSelectedRow(), 1).toString());
						ChiTietSP.setId(ssd.getIdSdd());
						ChiTietSP.main(null);
					} else if (products.equals("HDD")) {
						hdd hdd = hddDAO.getInstance()
								.selectById(tableALL.getValueAt(tableALL.getSelectedRow(), 1).toString());
						ChiTietSP.setId(hdd.getIdhHdd());
						ChiTietSP.main(null);
					}

				}

			}
		});
		btnNewButton_2_1.setIcon(new ImageIcon(NhapHangForm.class.getResource("/icon/icons8-details-24.png")));
		btnNewButton_2_1.setFont(SetFont.font());
		btnNewButton_2_1.setBounds(5, 3, 164, 30);
		getContentPane().add(btnNewButton_2_1);

		JLabel lblNewLabel = new JLabel("Nhập SDT khách hàng");
		lblNewLabel.setFont(SetFont.font());
		lblNewLabel.setBounds(760, 594, 136, 26);
		getContentPane().add(lblNewLabel);

		JButton btnNewButton_2_2 = new JButton("Giảm");
		btnNewButton_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tableMin.getSelectedRow() == -1)
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm để giảm số lượng!");
				else {
					String id = tableMin.getValueAt(tableMin.getSelectedRow(), 1).toString();

					if (id.contains("cpu")) {
						cpu cpu = cpuDAO.getInstance().selectById(id);
						tien -= cpu.getDonGia();
						tfTongTien.setText(FormatToVND.vnd(tien));
					} else if (id.contains("r")) {
						ram ram = ramDAO.getInstance().selectById(id);
						tien -= ram.getDonGia();
						tfTongTien.setText(FormatToVND.vnd(tien));
					} else if (id.contains("vga")) {
						vga vga = vgaDAO.getInstance().selectById(id);
						tien -= vga.getDonGia();
						tfTongTien.setText(FormatToVND.vnd(tien));
					} else if (id.contains("main")) {
						mainboard mb = mainDAO.getInstance().selectById(id);
						tien -= mb.getDonGia();
						tfTongTien.setText(FormatToVND.vnd(tien));
					} else if (id.contains("case")) {
						Case c = caseDAO.getInstance().selectById(id);
						tien -= c.getGia();
						tfTongTien.setText(FormatToVND.vnd(tien));
					} else if (id.contains("psu")) {
						psu psu = psuDAO.getInstance().selectById(id);
						tien -= psu.getDonGia();
						tfTongTien.setText(FormatToVND.vnd(tien));
					} else if (id.contains("ssd")) {
						ssd ssd = ssdDAO.getInstance().selectById(id);
						tien -= ssd.getGia();
						tfTongTien.setText(FormatToVND.vnd(tien));
					} else if (id.contains("hdd")) {
						hdd hdd = hddDAO.getInstance().selectById(id);
						tien -= hdd.getGia();
						tfTongTien.setText(FormatToVND.vnd(tien));
					}

					ArrayList<ChiTietPhieu> list = kiemTraSoLuongXuat1(id, listXuat);
					loadDataToTableBill(list);
				}
			}
		});
		btnNewButton_2_2.setIcon(new ImageIcon(NhapHangForm.class.getResource("/icon/icons8-minus-24.png")));
		btnNewButton_2_2.setFont(SetFont.font());
		btnNewButton_2_2.setBounds(534, 3, 104, 30);
		getContentPane().add(btnNewButton_2_2);

		tfSDT = new JTextField();
		tfSDT.setBounds(760, 625, 115, 26);
		tfSDT.setFont(SetFont.fontDetails());
		tfSDT.setText(LuuTam.SDT);
		getContentPane().add(tfSDT);
		tfSDT.setColumns(10);

	}

//	static DecimalFormat formatter = new DecimalFormat("###,###,###");
	public static void loadDataToTableBill(ArrayList<ChiTietPhieu> pn) {
		try {
			tableModelBill.setRowCount(0);
			for (ChiTietPhieu i : pn) {
				DefaultTableCellRenderer renderRight = new DefaultTableCellRenderer();
				DefaultTableCellRenderer renderCenter = new DefaultTableCellRenderer();
				renderRight.setHorizontalAlignment(JLabel.RIGHT);
				renderCenter.setHorizontalAlignment(JLabel.CENTER);
				tableMin.getColumnModel().getColumn(4).setCellRenderer(renderCenter);
				tableMin.getColumnModel().getColumn(5).setCellRenderer(renderRight);
//				String gia = FormatToVND.vnd(i.getGia());
				tableModelBill.addRow(new Object[] { i.getIdSanPham(), i.getIdRieng(), i.getTenSanPham(),
						i.getBaoHanh(), i.getSoLuong(), i.getDonGia() });
			}
		} catch (Exception e) {
		}
	}

	public void setDefaultTableBill(ArrayList<ChiTietPhieu> pn) {
		tableModelBill = new DefaultTableModel();
		tableModelBill.setColumnIdentifiers(columNameBill);
		tableMin.setDefaultEditor(Object.class, null);
		tableMin.setModel(tableModelBill);
		tableMin.getColumnModel().getColumn(0).setPreferredWidth(200);
		tableMin.getColumnModel().getColumn(1).setPreferredWidth(150);
		tableMin.getColumnModel().getColumn(2).setPreferredWidth(300);
		tableMin.getColumnModel().getColumn(3).setPreferredWidth(150);
		tableMin.getColumnModel().getColumn(4).setPreferredWidth(100);
		tableMin.getColumnModel().getColumn(5).setPreferredWidth(200);

		loadDataToTableBill(pn);
	}

	private boolean kiemTraSoLuongTonKho(String id) {
		if (id.contains("cpu")) {
			int sl = cpuDAO.getInstance().selectById(id).getTonKho();
			if (sl == 0)
				return false;
		} else if (id.contains("r")) {
			if (ramDAO.getInstance().selectById(id).getTonkho() == 0)
				return false;
		} else if (id.contains("vga")) {
			if (vgaDAO.getInstance().selectById(id).getTonKho() == 0)
				return false;
		} else if (id.contains("mba")) {
			if (mainDAO.getInstance().selectById(id).getTonKho() == 0)
				return false;
		} else if (id.contains("case")) {
			if (caseDAO.getInstance().selectById(id).getTonKho() == 0)
				return false;
		} else if (id.contains("psu")) {
			if (psuDAO.getInstance().selectById(id).getTonKho() == 0)
				return false;
		} else if (id.contains("ssd")) {
			if (ssdDAO.getInstance().selectById(id).getTonKho() == 0)
				return false;
		} else if (id.contains("hdd")) {
			if (hddDAO.getInstance().selectById(id).getTonKho() == 0)
				return false;
		}

		return true;
	}

	private boolean kiemTraGioiHanKho(String id, ArrayList<ChiTietPhieu> list) {
		for (ChiTietPhieu sp : list) {
			if (id.contains("cpu")) {
				if (sp.getIdRieng().equals(id))
					if (cpuDAO.getInstance().selectById(id).getTonKho() == sp.getSoLuong())
						return false;
			} else if (id.contains("ram")) {
				if (sp.getIdRieng().equals(id))
					if (ramDAO.getInstance().selectById(id).getTonkho() == sp.getSoLuong())
						return false;
			} else if (id.contains("vga")) {
				if (sp.getIdRieng().equals(id))
					if (vgaDAO.getInstance().selectById(id).getTonKho() == sp.getSoLuong())
						return false;
			} else if (id.contains("mba")) {
				if (sp.getIdRieng().equals(id))
					if (mainDAO.getInstance().selectById(id).getTonKho() == sp.getSoLuong())
						return false;
			} else if (id.contains("case")) {
				if (sp.getIdRieng().equals(id))
					if (caseDAO.getInstance().selectById(id).getTonKho() == sp.getSoLuong())
						return false;
			} else if (id.contains("psu")) {
				if (sp.getIdRieng().equals(id))
					if (psuDAO.getInstance().selectById(id).getTonKho() == sp.getSoLuong())
						return false;
			} else if (id.contains("ssd")) {
				if (sp.getIdRieng().equals(id))
					if (ssdDAO.getInstance().selectById(id).getTonKho() == sp.getSoLuong())
						return false;
			} else if (id.contains("hdd")) {
				if (sp.getIdRieng().equals(id))
					if (hddDAO.getInstance().selectById(id).getTonKho() == sp.getSoLuong())
						return false;
			}
		}

		return true;
	}

	private boolean kiemTraSoLuongXuat(String id, ArrayList<ChiTietPhieu> list) {
		for (ChiTietPhieu ChiTietPhieu : list) {
			if (ChiTietPhieu.getIdRieng().equals(id)) {
				ChiTietPhieu.setSoLuong(ChiTietPhieu.getSoLuong() + 1);
				return true;
			}
		}
		return false;
	}

	private ArrayList<ChiTietPhieu> kiemTraSoLuongXuat1(String id, ArrayList<ChiTietPhieu> list) {
		for (ChiTietPhieu ChiTietPhieu : list) {
			if (ChiTietPhieu.getIdRieng().equals(id)) {
				if (ChiTietPhieu.getSoLuong() == 1) {
					list.remove(tableMin.getSelectedRow());
					break;
				} else {
					ChiTietPhieu.setSoLuong(ChiTietPhieu.getSoLuong() - 1);
					break;
				}
			}
		}
		return list;
	}

	private String createIDPhieuXuat(ArrayList<PhieuXuat> arr) {
//		String id = "pn";
//		int code = 0;
//
//		ArrayList<PhieuNhap> list = PhieuNhapDAO.getInstance().selectAll();
//
////		Collections.sort(list, new Comparator<PhieuNhap>() {
////
////			@Override
////			public int compare(PhieuNhap o1, PhieuNhap o2) {
////
////				if (Double.parseDouble((String) o1.getIdPhieu().substring(2, o1.getIdPhieu().length())) > Double
////						.parseDouble((String) o2.getIdPhieu().substring(2, o2.getIdPhieu().length()))) {
////					return 1;
////				}else if(Double.parseDouble((String) o1.getIdPhieu().substring(2, o1.getIdPhieu().length())) > Double
////						.parseDouble((String) o2.getIdPhieu().substring(2, o2.getIdPhieu().length()))) return -1;
////
////				return 0;
////			}
////		});
//		for (PhieuNhap phieuNhap : list) {
//			if (phieuNhap.getIdPhieu().equals(id + code))
//				code++;
//			else
//				break;
//		}
//
//		return id + code;

		int id = arr.size() + 1;
		String check = "";
		for (PhieuXuat px : arr) {
			if (px.getIdPhieu().equals("px" + id)) {
				check = px.getIdPhieu();
			}
		}
		while (check.length() != 0) {
			String c = check;
			id++;
			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i).getIdPhieu().equals("px" + id)) {
					check = arr.get(i).getIdPhieu();
				}
			}
			if (check.equals(c)) {
				check = "";
			}
		}
		return "px" + id;
	}
}
