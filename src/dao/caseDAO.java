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
import model.Case;
import model.ChiTietPhieu;
import view.CapNhatCase;
import view.ThemCase;

public class caseDAO implements DAOInterface<Case> {

	public static caseDAO getInstance() {
		return new caseDAO();
	}

	@Override
	public int insert(Case t) {
		int check = 0;
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "insert into cases (idsanpham, idcase, tencase, hang, loai, chatlieu, kichthuocmb, tonkho, gia, baohanh, img) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdCase());
			ps.setString(3, t.getTenCase());
			ps.setString(4, t.getHangCase());
			ps.setString(5, t.getLoaiCase());
			ps.setString(6, t.getChatLieu());
			ps.setString(7, t.getKichThuocMainboard());
			ps.setInt(8, 0);
			ps.setDouble(9, t.getGia());
			ps.setString(10, t.getBaoHanh());

			try {
				InputStream is = new FileInputStream(new File(ThemCase.getInsert()));
				ps.setBlob(11, is);
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

	public int insertIMGURL(Case t, String stringUrl) {
		int check = 0;
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "insert into cases (idsanpham, idcase, tencase, hang, loai, chatlieu, kichthuocmb, tonkho, gia, baohanh, img) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdCase());
			ps.setString(3, t.getTenCase());
			ps.setString(4, t.getHangCase());
			ps.setString(5, t.getLoaiCase());
			ps.setString(6, t.getChatLieu());
			ps.setString(7, t.getKichThuocMainboard());
			ps.setInt(8, 0);
			ps.setDouble(9, t.getGia());
			ps.setString(10, t.getBaoHanh());

			@SuppressWarnings("deprecation")
			URL url = new URL(stringUrl);
			InputStream is = url.openStream();
			ps.setBlob(11, is);

			check = ps.executeUpdate();
			JDBCUntil.closeConnection(con);
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return check;
	}

	public int insertNotIMG(Case t) {
		int check = 0;
		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "insert into cases  (idsanpham, idcase , tencase , hang , loai , chatlieu , kichthuocmb , tonkho , gia , baohanh  ) values(?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdCase());
			ps.setString(3, t.getTenCase());
			ps.setString(4, t.getHangCase());
			ps.setString(5, t.getLoaiCase());
			ps.setString(6, t.getChatLieu());
			ps.setString(7, t.getKichThuocMainboard());
			ps.setInt(8, 0);
			ps.setDouble(9, t.getGia());
			ps.setString(10, t.getBaoHanh());

			check = ps.executeUpdate();
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public int update(Case t) {
		int check = 0;
		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "update cases set  idsanpham = ?, tencase = ?, hang = ?, loai = ?, chatlieu = ?, kichthuocmb = ?, tonkho = ?, gia = ?, baohanh = ?, img = ? where idcase = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenCase());
			ps.setString(3, t.getHangCase());
			ps.setString(4, t.getLoaiCase());
			ps.setString(5, t.getChatLieu());
			ps.setString(6, t.getKichThuocMainboard());
			ps.setInt(7, t.getTonKho());
			ps.setDouble(8, t.getGia());
			ps.setString(9, t.getBaoHanh());

			try {
				InputStream is = new FileInputStream(new File(CapNhatCase.getInsert()));
				ps.setBlob(10, is);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			ps.setString(11, t.getIdCase());
			check = ps.executeUpdate();
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	public int updateIMGURL(Case t, String stringUrl) {
		int check = 0;
		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "update cases set  idsanpham = ?, tencase = ?, hang = ?, loai = ?, chatlieu = ?, kichthuocmb = ?, tonkho = ?, gia = ?, baohanh = ?, img = ? where idcase = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenCase());
			ps.setString(3, t.getHangCase());
			ps.setString(4, t.getLoaiCase());
			ps.setString(5, t.getChatLieu());
			ps.setString(6, t.getKichThuocMainboard());
			ps.setInt(7, t.getTonKho());
			ps.setDouble(8, t.getGia());
			ps.setString(9, t.getBaoHanh());

			@SuppressWarnings("deprecation")
			URL url = new URL(stringUrl);
			InputStream is = url.openStream();
			ps.setBlob(10, is);

			ps.setString(11, t.getIdCase());
			check = ps.executeUpdate();
			JDBCUntil.closeConnection(con);
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return check;
	}

	public int updateNotIMG(Case t) {
		int check = 0;
		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "update cases set  idsanpham = ?, tencase = ?, hang = ?, loai = ?, chatlieu = ?, kichthuocmb = ?, tonkho = ?, gia = ?, baohanh = ? where idcase = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenCase());
			ps.setString(3, t.getHangCase());
			ps.setString(4, t.getLoaiCase());
			ps.setString(5, t.getChatLieu());
			ps.setString(6, t.getKichThuocMainboard());
			ps.setInt(7, t.getTonKho());
			ps.setDouble(8, t.getGia());
			ps.setString(9, t.getBaoHanh());
			ps.setString(10, t.getIdCase());
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

			String sql = "UPDATE cases SET tonkho = tonkho + ? WHERE idcase = ? ;";
			if (nhapHang == false)
				sql = "UPDATE cases SET tonkho = tonkho - ? WHERE idcase = ? ;";
			for (ChiTietPhieu productNhap : pn) {
				if (productNhap.getIdRieng().contains("case")) {

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
	public int delete(Case t) {
		int check = 0;
		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "delete from cases  where idcase = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getIdCase());
			check = ps.executeUpdate();
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public ArrayList<Case> selectAll() {
		ArrayList<Case> list = new ArrayList<Case>();

		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "select * from cases;";
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Case c = new Case(rs.getString("idsanpham"), rs.getString("idcase"), rs.getString("tencase"),
						rs.getString("hang"), rs.getString("loai"), rs.getString("chatlieu"),
						rs.getString("kichthuocmb"), rs.getInt("tonkho"), rs.getDouble("gia"), rs.getString("baohanh"),
						rs.getBlob("img"));
				list.add(c);
			}

			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Case selectById(String t) {
		Case c = null;
		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "select * from cases where idcase = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				c = new Case(rs.getString("idsanpham"), rs.getString("idcase"), rs.getString("tencase"),
						rs.getString("hang"), rs.getString("loai"), rs.getString("chatlieu"),
						rs.getString("kichthuocmb"), rs.getInt("tonkho"), rs.getDouble("gia"), rs.getString("baohanh"),
						rs.getBlob("img"));
			}
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return c;
	}

	public static int tongTonKho() {
		int tonkho = 0;
		String sql = "SELECT SUM(cases.tonkho) AS total\r\n" + "FROM cases";
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
