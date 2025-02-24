package controller;

import java.util.ArrayList;

import dao.SanPhamDAO;
import model.Products;

public class TimKiemSP {
	public static ArrayList<Products> byID(String key) {
		ArrayList<Products> list = new ArrayList<Products>();
		ArrayList<Products> all = SanPhamDAO.getInstance().selectAll();
		for (Products products : all) {
			if(products.getIdSanPham().toLowerCase().contains(key.toLowerCase()))
				list.add(products);
		}
		return list;
	}
	
	public static ArrayList<Products> byTen(String key) {
		ArrayList<Products> list = new ArrayList<Products>();
		ArrayList<Products> all = SanPhamDAO.getInstance().selectAll();
		for (Products products : all) {
			if(products.getTenSanPham().toLowerCase().contains(key.toLowerCase()))
				list.add(products);
		}
		return list;
	}
	
	public static ArrayList<Products> byTrangThai(String key) {
		ArrayList<Products> list = new ArrayList<Products>();
		ArrayList<Products> all = SanPhamDAO.getInstance().selectAll();
		for (Products products : all) {
			if(String.valueOf(products.getTrangThai()).toLowerCase().contains(key.toLowerCase()))
				list.add(products);
		}
		return list;
	}
	
	public static ArrayList<Products> byMota(String key) {
		ArrayList<Products> list = new ArrayList<Products>();
		ArrayList<Products> all = SanPhamDAO.getInstance().selectAll();
		for (Products products : all) {
			if(products.getMoTa().toLowerCase().contains(key.toLowerCase()))
				list.add(products);
		}
		return list;
	}
	
}
