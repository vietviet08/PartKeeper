package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.ArrayList;

import dao.KhachHangDAO;
import dao.SanPhamDAO;
import model.Products;
import view.KhachHangForm;

public class chooseID {
	public static void main(String[] args) throws FileNotFoundException {
//		ArrayList<Products> list = SanPhamDAO.getIDSanPham("cpu");
//		int size = list.size();
//		String choose[] = new String[size];
//		for (int i = 0; i < size ; i++) {
//			Products pr = list.get(i);
//			choose[i] = pr.getIdSanPham();
//		}
		
//		System.out.println(KhachHangDAO.getInstance().selectAll().size());
		
//		System.out.println(KhachHangForm.setIDKhachHang());
		
		InputStream is = new FileInputStream(new File(""));
		
		Blob blob = (Blob) is;
	}
}
