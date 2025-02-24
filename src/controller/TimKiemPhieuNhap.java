package controller;

import java.util.ArrayList;

import dao.PhieuNhapDAO;
import model.PhieuNhap;

public class TimKiemPhieuNhap {
//	{ "ID đơn nhập",
//		"ID nhà phân phối", "Người tạo", "Tổng tiền" 

	public static ArrayList<PhieuNhap> byIDDonNhap(String key) {
		ArrayList<PhieuNhap> list = PhieuNhapDAO.getInstance().selectAll();
		ArrayList<PhieuNhap> pn = new ArrayList<PhieuNhap>();
		for (PhieuNhap phieuNhap : list) {
			if (phieuNhap.getIdPhieu().toLowerCase().contains(key.toLowerCase()))
				pn.add(phieuNhap);
		}
		return pn;
	}

	public static ArrayList<PhieuNhap> byIDNPP(String key) {
		ArrayList<PhieuNhap> list = PhieuNhapDAO.getInstance().selectAll();
		ArrayList<PhieuNhap> pn = new ArrayList<PhieuNhap>();
		for (PhieuNhap phieuNhap : list) {
			if (phieuNhap.getIdNPP().toLowerCase().contains(key.toLowerCase()))
				pn.add(phieuNhap);
		}
		return pn;
	}

	public static ArrayList<PhieuNhap> byNguoiTao(String key) {
		ArrayList<PhieuNhap> list = PhieuNhapDAO.getInstance().selectAll();
		ArrayList<PhieuNhap> pn = new ArrayList<PhieuNhap>();
		for (PhieuNhap phieuNhap : list) {
			if (phieuNhap.getNguoiTao().toLowerCase().contains(key.toLowerCase()))
				pn.add(phieuNhap);
		}
		return pn;
	}

	public static ArrayList<PhieuNhap> byTongTien(String key) {
		ArrayList<PhieuNhap> list = PhieuNhapDAO.getInstance().selectAll();
		ArrayList<PhieuNhap> pn = new ArrayList<PhieuNhap>();
		for (PhieuNhap phieuNhap : list) {
			if (String.valueOf(phieuNhap.getTongTien()).contains(key.toLowerCase()))
				pn.add(phieuNhap);
		}
		return pn;
	}
}
