package controller;

import java.util.ArrayList;

import dao.hddDAO;
import model.hdd;

public class TimKiemHDD implements TimKiemInterface<hdd> {

	public static TimKiemHDD getInstance() {
		return new TimKiemHDD();
	}

	@Override
	public ArrayList<hdd> byIDSP(String key) {
		ArrayList<hdd> list = new ArrayList<hdd>();
		ArrayList<hdd> hdds = hddDAO.getInstance().selectAll();
		for (hdd hdd : hdds)
			if (hdd.getIdSanPham().toLowerCase().contains(key.toLowerCase()))
				list.add(hdd);
		return list;
	}

	@Override
	public ArrayList<hdd> byIDRieng(String key) {
		ArrayList<hdd> list = new ArrayList<hdd>();
		ArrayList<hdd> hdds = hddDAO.getInstance().selectAll();
		for (hdd hdd : hdds)
			if (hdd.getIdhHdd().toLowerCase().contains(key.toLowerCase()))
				list.add(hdd);
		return list;
	}

	@Override
	public ArrayList<hdd> byTen(String key) {
		ArrayList<hdd> list = new ArrayList<hdd>();
		ArrayList<hdd> hdds = hddDAO.getInstance().selectAll();
		for (hdd hdd : hdds)
			if (hdd.getTenHdd().toLowerCase().contains(key.toLowerCase()))
				list.add(hdd);
		return list;
	}

	@Override
	public ArrayList<hdd> byHang(String key) {
		ArrayList<hdd> list = new ArrayList<hdd>();
		ArrayList<hdd> hdds = hddDAO.getInstance().selectAll();
		for (hdd hdd : hdds)
			if (hdd.getHang().toLowerCase().contains(key.toLowerCase()))
				list.add(hdd);
		return list;
	}

	@Override
	public ArrayList<hdd> byTonKho(String key) {
		ArrayList<hdd> list = new ArrayList<hdd>();
		ArrayList<hdd> hdds = hddDAO.getInstance().selectAll();
		for (hdd hdd : hdds)
			if (String.valueOf(hdd.getTonKho()).toLowerCase().contains(key.toLowerCase()))
				list.add(hdd);
		return list;
	}

	@Override
	public ArrayList<hdd> byGia(String key) {
		ArrayList<hdd> list = new ArrayList<hdd>();
		ArrayList<hdd> hdds = hddDAO.getInstance().selectAll();
		for (hdd hdd : hdds)
			if (String.valueOf(hdd.getGia()).toLowerCase().contains(key.toLowerCase()))
				list.add(hdd);
		return list;
	}

	@Override
	public ArrayList<hdd> byBaoHanh(String key) {
		ArrayList<hdd> list = new ArrayList<hdd>();
		ArrayList<hdd> hdds = hddDAO.getInstance().selectAll();
		for (hdd hdd : hdds)
			if (hdd.getBaoHanh().toLowerCase().contains(key.toLowerCase()))
				list.add(hdd);
		return list;
	}

	public ArrayList<hdd> byDungLuong(String key) {
		ArrayList<hdd> list = new ArrayList<hdd>();
		ArrayList<hdd> hdds = hddDAO.getInstance().selectAll();
		for (hdd hdd : hdds)
			if (hdd.getDungLuong().toLowerCase().contains(key.toLowerCase()))
				list.add(hdd);
		return list;
	}

	public ArrayList<hdd> byBoNhoDem(String key) {
		ArrayList<hdd> list = new ArrayList<hdd>();
		ArrayList<hdd> hdds = hddDAO.getInstance().selectAll();
		for (hdd hdd : hdds)
			if (hdd.getBoNhoDem().toLowerCase().contains(key.toLowerCase()))
				list.add(hdd);
		return list;
	}

	public ArrayList<hdd> byTocDoVongQuay(String key) {
		ArrayList<hdd> list = new ArrayList<hdd>();
		ArrayList<hdd> hdds = hddDAO.getInstance().selectAll();
		for (hdd hdd : hdds)
			if (hdd.getTocDoVongQuay().toLowerCase().contains(key.toLowerCase()))
				list.add(hdd);
		return list;
	}

}
