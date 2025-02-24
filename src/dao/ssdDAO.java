package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JDBCUntil;
import model.ChiTietPhieu;
import model.ssd;
import view.CapNhatSSD;
import view.ThemSSD;

public class ssdDAO implements DAOInterface<ssd> {

	public static ssdDAO getInstance() {
		return new ssdDAO();
	}

	@Override
	public int insert(ssd t) {
		int check = 0;
		try {

			Connection con = JDBCUntil.getConnection();
			String sql = "insert into ssd (idsanpham, idssd, tenssd, hang, dungluong, loai, tocdodoc, tocdoghi, tonkho, gia, baohanh, img) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdSdd());
			ps.setString(3, t.getTenSsd());
			ps.setString(4, t.getHang());
			ps.setString(5, t.getDungLuong());
			ps.setString(6, t.getLoai());
			ps.setString(7, t.getTocDoDoc());
			ps.setString(8, t.getTocDoGhi());
			ps.setInt(9, 0);
			ps.setDouble(10, t.getGia());
			ps.setString(11, t.getBaoHanh());

			InputStream is = new FileInputStream(new File(ThemSSD.getInsert()));

			ps.setBlob(12, is);

			check = ps.executeUpdate();
			JDBCUntil.closeConnection(con);
		} catch (Exception e) {
			System.out.println(e);
		}

		return check;
	}

	public int insertIMGURL(ssd t, String stringUrl) {
		int check = 0;
		try {

			Connection con = JDBCUntil.getConnection();
			String sql = "insert into ssd (idsanpham, idssd, tenssd, hang, dungluong, loai, tocdodoc, tocdoghi, tonkho, gia, baohanh, img) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdSdd());
			ps.setString(3, t.getTenSsd());
			ps.setString(4, t.getHang());
			ps.setString(5, t.getDungLuong());
			ps.setString(6, t.getLoai());
			ps.setString(7, t.getTocDoDoc());
			ps.setString(8, t.getTocDoGhi());
			ps.setInt(9, 0);
			ps.setDouble(10, t.getGia());
			ps.setString(11, t.getBaoHanh());

			@SuppressWarnings("deprecation")
			URL url = new URL(stringUrl);

			InputStream is = url.openStream();

			ps.setBlob(12, is);

			check = ps.executeUpdate();
			JDBCUntil.closeConnection(con);
		} catch (Exception e) {
			System.out.println(e);
		}

		return check;
	}

	public int insertNotIMG(ssd t) {
		int check = 0;
		try {

			Connection con = JDBCUntil.getConnection();
			String sql = "insert into ssd (idsanpham, idssd, tenssd, hang, dungluong, loai, tocdodoc, tocdoghi, tonkho, gia, baohanh) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdSdd());
			ps.setString(3, t.getTenSsd());
			ps.setString(4, t.getHang());
			ps.setString(5, t.getDungLuong());
			ps.setString(6, t.getLoai());
			ps.setString(7, t.getTocDoDoc());
			ps.setString(8, t.getTocDoGhi());
			ps.setInt(9, 0);
			ps.setDouble(10, t.getGia());
			ps.setString(11, t.getBaoHanh());

			check = ps.executeUpdate();
			JDBCUntil.closeConnection(con);
		} catch (Exception e) {
			System.out.println(e);
		}

		return check;
	}

	@Override
	public int update(ssd t) {
		int check = 0;
		try {

			Connection con = JDBCUntil.getConnection();
			String sql = "update ssd set idsanpham = ? , tenssd = ?, hang = ?, dungluong = ?, loai = ?, tocdodoc = ?, tocdoghi = ?, tonkho = ?, gia = ?, baohanh = ?, img = ? where idssd = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenSsd());
			ps.setString(3, t.getHang());
			ps.setString(4, t.getDungLuong());
			ps.setString(5, t.getLoai());
			ps.setString(6, t.getTocDoDoc());
			ps.setString(7, t.getTocDoGhi());
			ps.setInt(8, t.getTonKho());
			ps.setDouble(9, t.getGia());
			ps.setString(10, t.getBaoHanh());

			InputStream is = new FileInputStream(new File(CapNhatSSD.getInsert()));

			ps.setBlob(11, is);

			ps.setString(12, t.getIdSdd());
			check = ps.executeUpdate();
			JDBCUntil.closeConnection(con);
		} catch (Exception e) {
			System.out.println(e);
		}

		return check;
	}

	public int updateIMGURL(ssd t, String stringUrl) {
		int check = 0;
		try {

			Connection con = JDBCUntil.getConnection();
			String sql = "update ssd set idsanpham = ? , tenssd = ?, hang = ?, dungluong = ?, loai = ?, tocdodoc = ?, tocdoghi = ?, tonkho = ?, gia = ?, baohanh = ?, img = ? where idssd = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenSsd());
			ps.setString(3, t.getHang());
			ps.setString(4, t.getDungLuong());
			ps.setString(5, t.getLoai());
			ps.setString(6, t.getTocDoDoc());
			ps.setString(7, t.getTocDoGhi());
			ps.setInt(8, t.getTonKho());
			ps.setDouble(9, t.getGia());
			ps.setString(10, t.getBaoHanh());

			@SuppressWarnings("deprecation")
			URL url = new URL(stringUrl);
			InputStream is = url.openStream();

			ps.setBlob(11, is);

			ps.setString(12, t.getIdSdd());
			check = ps.executeUpdate();
			JDBCUntil.closeConnection(con);
		} catch (Exception e) {
			System.out.println(e);
		}

		return check;
	}

	public int updateNotIMG(ssd t) {
		int check = 0;
		try {

			Connection con = JDBCUntil.getConnection();
			String sql = "update ssd set idsanpham = ? , tenssd = ?, hang = ?, dungluong = ?, loai = ?, tocdodoc = ?, tocdoghi = ?, tonkho = ?, gia = ?, baohanh = ? where idssd = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenSsd());
			ps.setString(3, t.getHang());
			ps.setString(4, t.getDungLuong());
			ps.setString(5, t.getLoai());
			ps.setString(6, t.getTocDoDoc());
			ps.setString(7, t.getTocDoGhi());
			ps.setInt(8, t.getTonKho());
			ps.setDouble(9, t.getGia());
			ps.setString(10, t.getBaoHanh());

			ps.setString(12, t.getIdSdd());
			check = ps.executeUpdate();
			JDBCUntil.closeConnection(con);
		} catch (Exception e) {
			System.out.println(e);
		}

		return check;
	}

	public int updateTonKho(ArrayList<ChiTietPhieu> pn, boolean nhapHang) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "UPDATE ssd SET  tonkho = tonkho + ? WHERE idssd = ?;";
			if (nhapHang == false)
				sql = "UPDATE ssd SET  tonkho = tonkho - ? WHERE idssd = ?;";

			for (ChiTietPhieu productNhap : pn) {

				if (productNhap.getIdRieng().contains("ssd")) {

					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, productNhap.getSoLuong());
					ps.setString(2, productNhap.getIdRieng());
					check = ps.executeUpdate();
				}

			}
			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public int delete(ssd t) {
		int check = 0;
		try {

			Connection con = JDBCUntil.getConnection();
			String sql = "delete from ssd where idssd = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSdd());
			check = ps.executeUpdate();
			JDBCUntil.closeConnection(con);
		} catch (Exception e) {
			System.out.println(e);
		}

		return check;
	}

	@Override
	public ArrayList<ssd> selectAll() {
		ArrayList<ssd> list = new ArrayList<ssd>();

		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "select * from ssd;";
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
//			idsanpham, idssd, tenssd, hang, dungluong, loai, tocdodoc, tocdoghi, tonkho, gia, baohanh
			while (rs.next()) {
				ssd ssd = new ssd(rs.getString("idsanpham"), rs.getString("idssd"), rs.getString("tenssd"),
						rs.getString("hang"), rs.getString("dungluong"), rs.getString("loai"), rs.getString("tocdodoc"),
						rs.getString("tocdoghi"), rs.getInt("tonkho"), rs.getDouble("gia"), rs.getString("baohanh"),
						rs.getBlob("img"));
				list.add(ssd);
			}
			JDBCUntil.closeConnection(con);
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	@Override
	public ssd selectById(String t) {
		ssd ssd = null;
		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "select * from ssd where idssd = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t);
			ResultSet rs = ps.executeQuery();
//			idsanpham, idssd, tenssd, hang, dungluong, loai, tocdodoc, tocdoghi, tonkho, gia, baohanh
			while (rs.next()) {
				ssd = new ssd(rs.getString("idsanpham"), rs.getString("idssd"), rs.getString("tenssd"),
						rs.getString("hang"), rs.getString("dungluong"), rs.getString("loai"), rs.getString("tocdodoc"),
						rs.getString("tocdoghi"), rs.getInt("tonkho"), rs.getDouble("gia"), rs.getString("baohanh"),
						rs.getBlob("img"));
			}
			JDBCUntil.closeConnection(con);
		} catch (Exception e) {
			System.out.println(e);
		}
		return ssd;
	}

	public static int tongTonKho() {
		int tonkho = 0;
		String sql = "SELECT SUM(ssd.tonkho) AS total\r\n" + "FROM ssd";
		try {
			Connection con = JDBCUntil.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tonkho = rs.getInt("total");
			}
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tonkho;
	}

}
