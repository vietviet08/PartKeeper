package controller;

import java.util.ArrayList;

import dao.psuDAO;
import model.psu;

public class TimKiemPSU {
//	 "ID sản phẩm", "ID nguồn", "Tên nguồn", "Hãng", "Công suất",
//		"Chuẩn nguồn", "Kiểu dây", "Kích thước", "Tồn kho", "Giá"
	public static ArrayList<psu> byIDSP(String key) {
		ArrayList<psu> list = new ArrayList<psu>();
		ArrayList<psu> psus = psuDAO.getInstance().selectAll();
		for (psu psu : psus)
			if (psu.getIdSanPham().toLowerCase().contains(key.toLowerCase()))
				list.add(psu);
		return list;
	}

	public static ArrayList<psu> byIDPSU(String key) {
		ArrayList<psu> list = new ArrayList<psu>();
		ArrayList<psu> psus = psuDAO.getInstance().selectAll();
		for (psu psu : psus)
			if (psu.getIdNguon().toLowerCase().contains(key.toLowerCase()))
				list.add(psu);
		return list;
	}

	public static ArrayList<psu> byTen(String key) {
		ArrayList<psu> list = new ArrayList<psu>();
		ArrayList<psu> psus = psuDAO.getInstance().selectAll();
		for (psu psu : psus)
			if (psu.getTenNguon().toLowerCase().contains(key.toLowerCase()))
				list.add(psu);
		return list;
	}

	public static ArrayList<psu> byHang(String key) {
		ArrayList<psu> list = new ArrayList<psu>();
		ArrayList<psu> psus = psuDAO.getInstance().selectAll();
		for (psu psu : psus)
			if (psu.getHang().toLowerCase().contains(key.toLowerCase()))
				list.add(psu);
		return list;
	}

	public static ArrayList<psu> byCongSuat(String key) {
		ArrayList<psu> list = new ArrayList<psu>();
		ArrayList<psu> psus = psuDAO.getInstance().selectAll();
		for (psu psu : psus)
			if (psu.getCongSuat().toLowerCase().contains(key.toLowerCase()))
				list.add(psu);
		return list;
	}

	public static ArrayList<psu> byChuanNguon(String key) {
		ArrayList<psu> list = new ArrayList<psu>();
		ArrayList<psu> psus = psuDAO.getInstance().selectAll();
		for (psu psu : psus)
			if (psu.getChuanNguon().toLowerCase().contains(key.toLowerCase()))
				list.add(psu);
		return list;
	}

	public static ArrayList<psu> byKieuDay(String key) {
		ArrayList<psu> list = new ArrayList<psu>();
		ArrayList<psu> psus = psuDAO.getInstance().selectAll();
		for (psu psu : psus)
			if (psu.getKieuDay().toLowerCase().contains(key.toLowerCase()))
				list.add(psu);
		return list;
	}

	public static ArrayList<psu> byKichThuoc(String key) {
		ArrayList<psu> list = new ArrayList<psu>();
		ArrayList<psu> psus = psuDAO.getInstance().selectAll();
		for (psu psu : psus)
			if (psu.getKichThuoc().toLowerCase().contains(key.toLowerCase()))
				list.add(psu);
		return list;
	}

	public static ArrayList<psu> byTonKho(String key) {
		ArrayList<psu> list = new ArrayList<psu>();
		ArrayList<psu> psus = psuDAO.getInstance().selectAll();
		for (psu psu : psus)
			if (String.valueOf(psu.getTonKho()).toLowerCase().contains(key.toLowerCase()))
				list.add(psu);
		return list;
	}

	public static ArrayList<psu> byDonGia(String key) {
		ArrayList<psu> list = new ArrayList<psu>();
		ArrayList<psu> psus = psuDAO.getInstance().selectAll();
		for (psu psu : psus)
			if (String.valueOf(psu.getDonGia()).toLowerCase().contains(key.toLowerCase()))
				list.add(psu);
		return list;
	}

}
