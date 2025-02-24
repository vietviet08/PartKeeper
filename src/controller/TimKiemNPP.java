package controller;

import java.util.ArrayList;

import dao.NhaPhanPhoiDAO;
import model.NhaPhanPhoi;

public class TimKiemNPP {
	public static ArrayList<NhaPhanPhoi> all(String key) {
		ArrayList<NhaPhanPhoi> npp = new ArrayList<NhaPhanPhoi>();
		ArrayList<NhaPhanPhoi> listNpp = NhaPhanPhoiDAO.getInstance().selectAll();

		for (NhaPhanPhoi nhaPhanPhoi : listNpp) {
			String phone = String.valueOf(nhaPhanPhoi.getSdt());
			if (nhaPhanPhoi.getIdNPP().toLowerCase().contains(key.toLowerCase())
					|| nhaPhanPhoi.getTenNPP().toLowerCase().contains(key.toLowerCase())
					|| nhaPhanPhoi.getDiaChi().toLowerCase().contains(key.toLowerCase())
					|| nhaPhanPhoi.getEmail().toLowerCase().contains(key.toLowerCase())
					|| phone.toLowerCase().contains(key)) {
				npp.add(nhaPhanPhoi);
			}
		}

		return npp;
	}

	public static ArrayList<NhaPhanPhoi> byID(String key) {
		ArrayList<NhaPhanPhoi> npp = new ArrayList<NhaPhanPhoi>();
		ArrayList<NhaPhanPhoi> listNpp = NhaPhanPhoiDAO.getInstance().selectAll();
		for (NhaPhanPhoi nhaPhanPhoi : listNpp) {
			if (nhaPhanPhoi.getIdNPP().toLowerCase().contains(key.toLowerCase())) {
				npp.add(nhaPhanPhoi);
			}
		}
		return npp;
	}

	public static ArrayList<NhaPhanPhoi> byTen(String key) {
		ArrayList<NhaPhanPhoi> npp = new ArrayList<NhaPhanPhoi>();
		ArrayList<NhaPhanPhoi> listNpp = NhaPhanPhoiDAO.getInstance().selectAll();
		for (NhaPhanPhoi nhaPhanPhoi : listNpp) {
			if (nhaPhanPhoi.getTenNPP().toLowerCase().contains(key.toLowerCase())) {
				npp.add(nhaPhanPhoi);
			}
		}
		return npp;
	}

	public static ArrayList<NhaPhanPhoi> byDiaChi(String key) {
		ArrayList<NhaPhanPhoi> npp = new ArrayList<NhaPhanPhoi>();
		ArrayList<NhaPhanPhoi> listNpp = NhaPhanPhoiDAO.getInstance().selectAll();
		for (NhaPhanPhoi nhaPhanPhoi : listNpp) {
			if (nhaPhanPhoi.getDiaChi().toLowerCase().contains(key.toLowerCase())) {
				npp.add(nhaPhanPhoi);
			}
		}
		return npp;
	}

	public static ArrayList<NhaPhanPhoi> byEmail(String key) {
		ArrayList<NhaPhanPhoi> npp = new ArrayList<NhaPhanPhoi>();
		ArrayList<NhaPhanPhoi> listNpp = NhaPhanPhoiDAO.getInstance().selectAll();
		for (NhaPhanPhoi nhaPhanPhoi : listNpp) {
			if (nhaPhanPhoi.getEmail().toLowerCase().contains(key.toLowerCase())){
				npp.add(nhaPhanPhoi);
			}
		}
		return npp;
	}

	public static ArrayList<NhaPhanPhoi> bySDT(String key) {
		ArrayList<NhaPhanPhoi> npp = new ArrayList<NhaPhanPhoi>();
		ArrayList<NhaPhanPhoi> listNpp = NhaPhanPhoiDAO.getInstance().selectAll();
		for (NhaPhanPhoi nhaPhanPhoi : listNpp) {
			String sdt = String.valueOf(nhaPhanPhoi.getSdt());
			if (sdt.toLowerCase().contains(key.toLowerCase())) {
				npp.add(nhaPhanPhoi);
			}
		}
		return npp;
	}
}
