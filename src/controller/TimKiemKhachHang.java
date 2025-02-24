package controller;

import java.util.ArrayList;

import dao.KhachHangDAO;
import model.KhachHang;

public class TimKiemKhachHang {
	public static ArrayList<KhachHang> byALL(String key){
		ArrayList<KhachHang> list = new ArrayList<KhachHang>();
		ArrayList<KhachHang> KhachHang = KhachHangDAO.getInstance().selectAll();
		//ten, diachi, email, sdt
		for (KhachHang kh : KhachHang) {
			if(kh.getTenKhachHang().toLowerCase().contains(key.toLowerCase()) 
					|| kh.getDiaChi().toLowerCase().contains(key.toLowerCase())
					|| kh.getEmail().toLowerCase().contains(key.toLowerCase())
					|| kh.getSdt().contains(key)) 
				list.add(kh);
		}
		return list;
	}
}
