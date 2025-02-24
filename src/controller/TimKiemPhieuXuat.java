package controller;

import java.util.ArrayList;

import dao.PhieuXuatDAO;
import model.PhieuXuat;

public class TimKiemPhieuXuat {
//	{ "ID đơn nhập",
//		"ID nhà phân phối", "Người tạo", "Tổng tiền" 

	public static ArrayList<PhieuXuat> byIDDonNhap(String key) {
		ArrayList<PhieuXuat> list = PhieuXuatDAO.getInstance().selectAll();
		ArrayList<PhieuXuat> pn = new ArrayList<PhieuXuat>();
		for (PhieuXuat PhieuXuat : list) {
			if (PhieuXuat.getIdPhieu().toLowerCase().contains(key.toLowerCase()))
				pn.add(PhieuXuat);
		}
		return pn;
	}

	public static ArrayList<PhieuXuat> byIDKhachHang(String key) {
		ArrayList<PhieuXuat> list = PhieuXuatDAO.getInstance().selectAll();
		ArrayList<PhieuXuat> pn = new ArrayList<PhieuXuat>();
		for (PhieuXuat PhieuXuat : list) {
			if (PhieuXuat.getIdKhachHang().toLowerCase().contains(key.toLowerCase()))
				pn.add(PhieuXuat);
		}
		return pn;
	}

	public static ArrayList<PhieuXuat> byNguoiTao(String key) {
		ArrayList<PhieuXuat> list = PhieuXuatDAO.getInstance().selectAll();
		ArrayList<PhieuXuat> pn = new ArrayList<PhieuXuat>();
		for (PhieuXuat PhieuXuat : list) {
			if (PhieuXuat.getNguoiTao().toLowerCase().contains(key.toLowerCase()))
				pn.add(PhieuXuat);
		}
		return pn;
	}

	public static ArrayList<PhieuXuat> byTongTien(String key) {
		ArrayList<PhieuXuat> list = PhieuXuatDAO.getInstance().selectAll();
		ArrayList<PhieuXuat> pn = new ArrayList<PhieuXuat>();
		for (PhieuXuat PhieuXuat : list) {
			if (String.valueOf(PhieuXuat.getTongTien()).contains(key.toLowerCase()))
				pn.add(PhieuXuat);
		}
		return pn;
	}
}
