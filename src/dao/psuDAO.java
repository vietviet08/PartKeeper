package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JDBCUntil;
import model.ChiTietPhieu;
import model.psu;
import view.CapNhatPSU;
import view.ThemPSU;

public class psuDAO implements DAOInterface<psu> {
	public static psuDAO getInstance() {
		return new psuDAO();
	}

	@Override
	public int insert(psu t) {
		int check = 0;
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "insert into psu (idsanpham, idnguon, tennguon, hang, congsuat, chuannguon, kieuday, kichthuoc, tonkho, gia, baohanh, img) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdNguon());
			ps.setString(3, t.getTenNguon());
			ps.setString(4, t.getHang());
			ps.setString(5, t.getCongSuat());
			ps.setString(6, t.getChuanNguon());
			ps.setString(7, t.getKieuDay());
			ps.setString(8, t.getKichThuoc());
			ps.setInt(9, 0);
			ps.setDouble(10, t.getDonGia());
			ps.setString(11, t.getBaoHanh());

			try {
				InputStream is = new FileInputStream(new File(ThemPSU.getInsert()));
				ps.setBlob(12, is);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			check = ps.executeUpdate();
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	public int insertIMGURL(psu t, String stringUrl) {
		int check = 0;
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "insert into psu (idsanpham, idnguon, tennguon, hang, congsuat, chuannguon, kieuday, kichthuoc, tonkho, gia, baohanh, img) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdNguon());
			ps.setString(3, t.getTenNguon());
			ps.setString(4, t.getHang());
			ps.setString(5, t.getCongSuat());
			ps.setString(6, t.getChuanNguon());
			ps.setString(7, t.getKieuDay());
			ps.setString(8, t.getKichThuoc());
			ps.setInt(9, 0);
			ps.setDouble(10, t.getDonGia());
			ps.setString(11, t.getBaoHanh());

			@SuppressWarnings("deprecation")
			URL url = new URL(stringUrl);
			InputStream is = url.openStream();
			ps.setBlob(12, is);
			check = ps.executeUpdate();
			JDBCUntil.closeConnection(con);
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return check;
	}

	public int insertNotIMG(psu t) {
		int check = 0;
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "insert into psu (idsanpham, idnguon, tennguon, hang, congsuat, chuannguon, kieuday, kichthuoc, tonkho, gia, baohanh) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdNguon());
			ps.setString(3, t.getTenNguon());
			ps.setString(4, t.getHang());
			ps.setString(5, t.getCongSuat());
			ps.setString(6, t.getChuanNguon());
			ps.setString(7, t.getKieuDay());
			ps.setString(8, t.getKichThuoc());
			ps.setInt(9, 0);
			ps.setDouble(10, t.getDonGia());
			ps.setString(11, t.getBaoHanh());
			check = ps.executeUpdate();
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public int update(psu t) {
		int check = 0;
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "update psu set idsanpham = ?, tennguon = ?, hang = ?, congsuat = ?, chuannguon = ?, kieuday = ?, kichthuoc = ?, tonkho = ?, gia = ?, baohanh = ?, img = ? where idnguon = ?;";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenNguon());
			ps.setString(3, t.getHang());
			ps.setString(4, t.getCongSuat());
			ps.setString(5, t.getChuanNguon());
			ps.setString(6, t.getKieuDay());
			ps.setString(7, t.getKichThuoc());
			ps.setInt(8, 0);
			ps.setDouble(9, t.getDonGia());
			ps.setString(10, t.getBaoHanh());

			InputStream is = new FileInputStream(new File(CapNhatPSU.getInsert()));
			ps.setBlob(11, is);

			ps.setString(12, t.getIdNguon());
			check = ps.executeUpdate();
			JDBCUntil.closeConnection(con);
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return check;
	}

	public int updateIMGURL(psu t, String stringUrl) {
		int check = 0;
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "update psu set idsanpham = ?, tennguon = ?, hang = ?, congsuat = ?, chuannguon = ?, kieuday = ?, kichthuoc = ?, tonkho = ?, gia = ?, baohanh = ?, img = ? where idnguon = ?;";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenNguon());
			ps.setString(3, t.getHang());
			ps.setString(4, t.getCongSuat());
			ps.setString(5, t.getChuanNguon());
			ps.setString(6, t.getKieuDay());
			ps.setString(7, t.getKichThuoc());
			ps.setInt(8, 0);
			ps.setDouble(9, t.getDonGia());
			ps.setString(10, t.getBaoHanh());

			@SuppressWarnings("deprecation")
			URL url = new URL(stringUrl);
			InputStream is = url.openStream();
			ps.setBlob(11, is);

			ps.setString(12, t.getIdNguon());
			check = ps.executeUpdate();
			JDBCUntil.closeConnection(con);
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return check;
	}

	public int updateNotIMG(psu t) {
		int check = 0;
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "update psu set idsanpham = ?, tennguon = ?, hang = ?, congsuat = ?, chuannguon = ?, kieuday = ?, kichthuoc = ?, tonkho = ?, gia = ?, baohanh = ? where idnguon = ?;";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenNguon());
			ps.setString(3, t.getHang());
			ps.setString(4, t.getCongSuat());
			ps.setString(5, t.getChuanNguon());
			ps.setString(6, t.getKieuDay());
			ps.setString(7, t.getKichThuoc());
			ps.setInt(8, 0);
			ps.setDouble(9, t.getDonGia());
			ps.setString(10, t.getBaoHanh());

			ps.setString(11, t.getIdNguon());
			check = ps.executeUpdate();
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	public int updateTonKho(ArrayList<ChiTietPhieu> pn, boolean nhapHang) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "UPDATE psu SET tonkho = tonkho + ? WHERE idnguon = ? ;";
			if (nhapHang == false)
				sql = "UPDATE psu SET tonkho = tonkho - ? WHERE idnguon = ? ;";
			for (ChiTietPhieu productNhap : pn) {
				if (productNhap.getIdRieng().contains("psu")) {
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
	public int delete(psu t) {
		int check = 0;
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "delete from psu where idnguon = ?;";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getIdNguon());
			check = ps.executeUpdate();
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public ArrayList<psu> selectAll() {
		ArrayList<psu> list = new ArrayList<psu>();

		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "select * from psu";
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
//				idsanpham, idnguon, tennguon, hang, congsuat, chuannguon, kieuday, kichthuoc, tonkho, gia, baohanh
				psu psu = new psu(rs.getString("idsanpham"), rs.getString("idnguon"), rs.getString("tennguon"),
						rs.getString("hang"), rs.getString("congsuat"), rs.getString("chuannguon"),
						rs.getString("kieuday"), rs.getString("kichthuoc"), rs.getInt("tonkho"), rs.getDouble("gia"),
						rs.getString("baohanh"), rs.getBlob("img"));
				list.add(psu);
			}
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public psu selectById(String t) {
		psu psu = null;
		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "select * from psu where idnguon = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
//				idsanpham, idnguon, tennguon, hang, congsuat, chuannguon, kieuday, kichthuoc, tonkho, gia, baohanh
				psu = new psu(rs.getString("idsanpham"), rs.getString("idnguon"), rs.getString("tennguon"),
						rs.getString("hang"), rs.getString("congsuat"), rs.getString("chuannguon"),
						rs.getString("kieuday"), rs.getString("kichthuoc"), rs.getInt("tonkho"), rs.getDouble("gia"),
						rs.getString("baohanh"), rs.getBlob("img"));
			}
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return psu;
	}

	public static int tongTonKho() {
		int tonkho = 0;
		String sql = "SELECT SUM(psu.tonkho) AS total\r\n" + "FROM psu";
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
