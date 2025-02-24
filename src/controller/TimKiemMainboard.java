package controller;

import java.util.ArrayList;

import dao.mainDAO;
import model.mainboard;

//"ID sản phẩm", "ID mainboard", "Tên mainboard", "Hãng", "Hỗ trợ CPU",
//"Hỗ trợ RAM", "Kích thước", "Tồn kho", "Đơn giá"

public class TimKiemMainboard {
	public static ArrayList<mainboard> byIDSP(String key) {
		ArrayList<mainboard> list = new ArrayList<mainboard>();
		ArrayList<mainboard> mbs = mainDAO.getInstance().selectAll();
		for (mainboard mb : mbs) {
			if (mb.getIdSanPham().toLowerCase().contains(key.toLowerCase()))
				list.add(mb);
		}
		return list;
	}

	public static ArrayList<mainboard> byIDMB(String key) {
		ArrayList<mainboard> list = new ArrayList<mainboard>();
		ArrayList<mainboard> mbs = mainDAO.getInstance().selectAll();
		for (mainboard mb : mbs) {
			if (mb.getIdMainboard().toLowerCase().contains(key.toLowerCase()))
				list.add(mb);
		}
		return list;
	}

	public static ArrayList<mainboard> byTen(String key) {
		ArrayList<mainboard> list = new ArrayList<mainboard>();
		ArrayList<mainboard> mbs = mainDAO.getInstance().selectAll();
		for (mainboard mb : mbs) {
			if (mb.getTenMain().toLowerCase().contains(key.toLowerCase()))
				list.add(mb);
		}
		return list;
	}

	public static ArrayList<mainboard> byHang(String key) {
		ArrayList<mainboard> list = new ArrayList<mainboard>();
		ArrayList<mainboard> mbs = mainDAO.getInstance().selectAll();
		for (mainboard mb : mbs) {
			if (mb.getTenHang().toLowerCase().contains(key.toLowerCase()))
				list.add(mb);
		}
		return list;
	}

	public static ArrayList<mainboard> byHoTroCPU(String key) {
		ArrayList<mainboard> list = new ArrayList<mainboard>();
		ArrayList<mainboard> mbs = mainDAO.getInstance().selectAll();
		for (mainboard mb : mbs) {
			if (mb.getHoTroCPU().toLowerCase().contains(key.toLowerCase()))
				list.add(mb);
		}
		return list;
	}

	public static ArrayList<mainboard> byHoTroRAM(String key) {
		ArrayList<mainboard> list = new ArrayList<mainboard>();
		ArrayList<mainboard> mbs = mainDAO.getInstance().selectAll();
		for (mainboard mb : mbs) {
			if (mb.getHoTroRAM().toLowerCase().contains(key.toLowerCase()))
				list.add(mb);
		}
		return list;
	}

	public static ArrayList<mainboard> byKichThuoc(String key) {
		ArrayList<mainboard> list = new ArrayList<mainboard>();
		ArrayList<mainboard> mbs = mainDAO.getInstance().selectAll();
		for (mainboard mb : mbs) {
			if (mb.getKichThuoc().toLowerCase().contains(key.toLowerCase()))
				list.add(mb);
		}
		return list;
	}

	public static ArrayList<mainboard> byTonKho(String key) {
		ArrayList<mainboard> list = new ArrayList<mainboard>();
		ArrayList<mainboard> mbs = mainDAO.getInstance().selectAll();
		for (mainboard mb : mbs) {
			if (String.valueOf(mb.getTonKho()).toLowerCase().contains(key.toLowerCase()))
				list.add(mb);
		}
		return list;
	}

	public static ArrayList<mainboard> byDonGia(String key) {
		ArrayList<mainboard> list = new ArrayList<mainboard>();
		ArrayList<mainboard> mbs = mainDAO.getInstance().selectAll();
		for (mainboard mb : mbs) {
			if (String.valueOf(mb.getDonGia()).toLowerCase().contains(key.toLowerCase()))
				list.add(mb);
		}
		return list;
	}

}
