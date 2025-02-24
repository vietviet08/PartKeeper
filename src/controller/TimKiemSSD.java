package controller;

import java.util.ArrayList;

import dao.ssdDAO;
import model.ssd;

public class TimKiemSSD implements TimKiemInterface<ssd> {

	public static TimKiemSSD getInstance() {
		return new TimKiemSSD();
	}

	@Override
	public ArrayList<ssd> byIDSP(String key) {
		ArrayList<ssd> list = new ArrayList<ssd>();
		ArrayList<ssd> ssds = ssdDAO.getInstance().selectAll();
		for (ssd ssd : ssds)
			if (ssd.getIdSanPham().toLowerCase().contains(key.toLowerCase()))
				list.add(ssd);
		return list;
	}

	@Override
	public ArrayList<ssd> byIDRieng(String key) {
		ArrayList<ssd> list = new ArrayList<ssd>();
		ArrayList<ssd> ssds = ssdDAO.getInstance().selectAll();
		for (ssd ssd : ssds)
			if (ssd.getIdSdd().toLowerCase().contains(key.toLowerCase()))
				list.add(ssd);
		return list;
	}

	@Override
	public ArrayList<ssd> byTen(String key) {
		ArrayList<ssd> list = new ArrayList<ssd>();
		ArrayList<ssd> ssds = ssdDAO.getInstance().selectAll();
		for (ssd ssd : ssds)
			if (ssd.getTenSanPham().toLowerCase().contains(key.toLowerCase()))
				list.add(ssd);
		return list;
	}

	@Override
	public ArrayList<ssd> byHang(String key) {
		ArrayList<ssd> list = new ArrayList<ssd>();
		ArrayList<ssd> ssds = ssdDAO.getInstance().selectAll();
		for (ssd ssd : ssds)
			if (ssd.getHang().toLowerCase().contains(key.toLowerCase()))
				list.add(ssd);
		return list;
	}

	@Override
	public ArrayList<ssd> byTonKho(String key) {
		ArrayList<ssd> list = new ArrayList<ssd>();
		ArrayList<ssd> ssds = ssdDAO.getInstance().selectAll();
		for (ssd ssd : ssds)
			if (String.valueOf(ssd.getTonKho()).toLowerCase().contains(key.toLowerCase()))
				list.add(ssd);
		return list;
	}

	@Override
	public ArrayList<ssd> byGia(String key) {
		ArrayList<ssd> list = new ArrayList<ssd>();
		ArrayList<ssd> ssds = ssdDAO.getInstance().selectAll();
		for (ssd ssd : ssds)
			if (String.valueOf(ssd.getGia()).toLowerCase().contains(key.toLowerCase()))
				list.add(ssd);
		return list;
	}

	@Override
	public ArrayList<ssd> byBaoHanh(String key) {
		ArrayList<ssd> list = new ArrayList<ssd>();
		ArrayList<ssd> ssds = ssdDAO.getInstance().selectAll();
		for (ssd ssd : ssds)
			if (ssd.getBaoHanh().toLowerCase().contains(key.toLowerCase()))
				list.add(ssd);
		return list;
	}

	public ArrayList<ssd> byDungLuong(String key) {
		ArrayList<ssd> list = new ArrayList<ssd>();
		ArrayList<ssd> ssds = ssdDAO.getInstance().selectAll();
		for (ssd ssd : ssds)
			if (ssd.getDungLuong().toLowerCase().contains(key.toLowerCase()))
				list.add(ssd);
		return list;
	}

	public ArrayList<ssd> byLoai(String key) {
		ArrayList<ssd> list = new ArrayList<ssd>();
		ArrayList<ssd> ssds = ssdDAO.getInstance().selectAll();
		for (ssd ssd : ssds)
			if (ssd.getLoai().toLowerCase().contains(key.toLowerCase()))
				list.add(ssd);
		return list;
	}

	public ArrayList<ssd> byTocDoDoc(String key) {
		ArrayList<ssd> list = new ArrayList<ssd>();
		ArrayList<ssd> ssds = ssdDAO.getInstance().selectAll();
		for (ssd ssd : ssds)
			if (ssd.getTocDoDoc().toLowerCase().contains(key.toLowerCase()))
				list.add(ssd);
		return list;
	}

	public ArrayList<ssd> byTocDoGhi(String key) {
		ArrayList<ssd> list = new ArrayList<ssd>();
		ArrayList<ssd> ssds = ssdDAO.getInstance().selectAll();
		for (ssd ssd : ssds)
			if (ssd.getTocDoGhi().toLowerCase().contains(key.toLowerCase()))
				list.add(ssd);
		return list;
	}

}
