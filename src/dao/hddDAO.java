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
import model.hdd;
import view.CapNhatHDD;
import view.ThemHDD;

public class hddDAO implements DAOInterface<hdd> {
	public static hddDAO getInstance() {
		return new hddDAO();
	}

	@Override
	public int insert(hdd t) {
		int check = 0;
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "insert into hdd (idsanpham, idhdd, tenhdd, hang, dungluong, bonhodem, tocdovongquay, tonkho, dongia, baohanh, img) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdhHdd());
			ps.setString(3, t.getTenHdd());
			ps.setString(4, t.getHang());
			ps.setString(5, t.getDungLuong());
			ps.setString(6, t.getBoNhoDem());
			ps.setString(7, t.getTocDoVongQuay());
			ps.setInt(8, 0);
			ps.setDouble(9, t.getGia());
			ps.setString(10, t.getBaoHanh());
			InputStream is = new FileInputStream(new File(ThemHDD.getInsert()));
			ps.setBlob(11, is);

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (Exception e) {
			System.out.println(e);
		}
		return check;
	}

	public int insertIMGURL(hdd t, String stringUrl) {
		int check = 0;
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "insert into hdd (idsanpham, idhdd, tenhdd, hang, dungluong, bonhodem, tocdovongquay, tonkho, dongia, baohanh, img) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdhHdd());
			ps.setString(3, t.getTenHdd());
			ps.setString(4, t.getHang());
			ps.setString(5, t.getDungLuong());
			ps.setString(6, t.getBoNhoDem());
			ps.setString(7, t.getTocDoVongQuay());
			ps.setInt(8, 0);
			ps.setDouble(9, t.getGia());
			ps.setString(10, t.getBaoHanh());

			@SuppressWarnings("deprecation")
			URL url = new URL(stringUrl);
			InputStream is = url.openStream();
			ps.setBlob(11, is);

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (Exception e) {
			System.out.println(e);
		}
		return check;
	}

	public int insertNotIMG(hdd t) {
		int check = 0;
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "insert into hdd (idsanpham, idhdd, tenhdd, hang, dungluong, bonhodem, tocdovongquay, tonkho, dongia, baohanh) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdhHdd());
			ps.setString(3, t.getTenHdd());
			ps.setString(4, t.getHang());
			ps.setString(5, t.getDungLuong());
			ps.setString(6, t.getBoNhoDem());
			ps.setString(7, t.getTocDoVongQuay());
			ps.setInt(8, 0);
			ps.setDouble(9, t.getGia());
			ps.setString(10, t.getBaoHanh());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (Exception e) {
			System.out.println(e);
		}
		return check;
	}

	@Override
	public int update(hdd t) {
		int check = 0;
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "update hdd set idsanpham = ?, tenhdd = ?, hang = ?, dungluong = ?, bonhodem = ?, tocdovongquay = ?, tonkho = ?, dongia = ?, baohanh = ?, img = ? where idhdd = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenHdd());
			ps.setString(3, t.getHang());
			ps.setString(4, t.getDungLuong());
			ps.setString(5, t.getBoNhoDem());
			ps.setString(6, t.getTocDoVongQuay());
			ps.setInt(7, t.getTonKho());
			ps.setDouble(8, t.getGia());
			ps.setString(9, t.getBaoHanh());
			InputStream is = new FileInputStream(new File(CapNhatHDD.getInsert()));
			ps.setBlob(10, is);

			ps.setString(11, t.getIdhHdd());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (Exception e) {
			System.out.println(e);
		}
		return check;
	}

	public int updateIMGURL(hdd t, String stringUrl) {

		int check = 0;
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "update hdd set idsanpham = ?, tenhdd = ?, hang = ?, dungluong = ?, bonhodem = ?, tocdovongquay = ?, tonkho = ?, dongia = ?, baohanh = ?, img = ? where idhdd = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenHdd());
			ps.setString(3, t.getHang());
			ps.setString(4, t.getDungLuong());
			ps.setString(5, t.getBoNhoDem());
			ps.setString(6, t.getTocDoVongQuay());
			ps.setInt(7, t.getTonKho());
			ps.setDouble(8, t.getGia());
			ps.setString(9, t.getBaoHanh());

			@SuppressWarnings("deprecation")
			URL url = new URL(stringUrl);
			InputStream is = url.openStream();
			ps.setBlob(10, is);

			ps.setString(11, t.getIdhHdd());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (Exception e) {
			System.out.println(e);
		}
		return check;
	}

	public int updateNotIMG(hdd t) {
		int check = 0;
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "update hdd set idsanpham = ?, tenhdd = ?, hang = ?, dungluong = ?, bonhodem = ?, tocdovongquay = ?, tonkho = ?, dongia = ?, baohanh = ? where idhdd = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenHdd());
			ps.setString(3, t.getHang());
			ps.setString(4, t.getDungLuong());
			ps.setString(5, t.getBoNhoDem());
			ps.setString(6, t.getTocDoVongQuay());
			ps.setInt(7, t.getTonKho());
			ps.setDouble(8, t.getGia());
			ps.setString(9, t.getBaoHanh());

			ps.setString(10, t.getIdhHdd());

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
			String sql = "UPDATE hdd SET  tonkho = tonkho + ? WHERE idhdd = ?;";
			if (nhapHang == false)
				sql = "UPDATE hdd SET  tonkho = tonkho - ? WHERE idhdd = ?;";
			for (ChiTietPhieu productNhap : pn) {

				if (productNhap.getIdRieng().contains("hdd")) {

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
	public int delete(hdd t) {
		int check = 0;
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "delete from hdd where idhdd = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdhHdd());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (Exception e) {
			System.out.println(e);
		}
		return check;
	}

	@Override
	public ArrayList<hdd> selectAll() {
		ArrayList<hdd> list = new ArrayList<hdd>();

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "select * from hdd";
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
//			idsanpham, idhdd, tenhdd, hang, dungluong, bonhodem, tocdovongquay, tonkho, dongia, baohanh, img
			while (rs.next()) {
				hdd hdd = new hdd(rs.getString("idsanpham"), rs.getString("idhdd"), rs.getString("tenhdd"),
						rs.getString("hang"), rs.getString("dungluong"), rs.getString("bonhodem"),
						rs.getString("tocdovongquay"), rs.getInt("tonkho"), rs.getDouble("dongia"),
						rs.getString("baohanh"), rs.getBlob("img"));
				list.add(hdd);
			}

			JDBCUntil.closeConnection(con);

		} catch (Exception e) {
			System.out.println(e);
		}

		return list;
	}

	@Override
	public hdd selectById(String t) {
		hdd hdd = null;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "select * from hdd where idhdd = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t);

			ResultSet rs = ps.executeQuery();
//			idsanpham, idhdd, tenhdd, hang, dungluong, bonhodem, tocdovongquay, tonkho, dongia, baohanh, img
			while (rs.next()) {
				hdd = new hdd(rs.getString("idsanpham"), rs.getString("idhdd"), rs.getString("tenhdd"),
						rs.getString("hang"), rs.getString("dungluong"), rs.getString("bonhodem"),
						rs.getString("tocdovongquay"), rs.getInt("tonkho"), rs.getDouble("dongia"),
						rs.getString("baohanh"), rs.getBlob("img"));
			}

			JDBCUntil.closeConnection(con);

		} catch (Exception e) {
			System.out.println(e);
		}

		return hdd;
	}
	
	public static int tongTonKho() {
		int tonkho = 0;
		String sql = "SELECT SUM(hdd.tonkho) AS total\r\n" + "FROM hdd";
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
