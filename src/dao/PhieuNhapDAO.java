package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.JDBCUntil;
import model.PhieuNhap;

public class PhieuNhapDAO implements DAOInterface<PhieuNhap> {

	public static PhieuNhapDAO getInstance() {
		return new PhieuNhapDAO();
	}

	@Override
	public int insert(PhieuNhap t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "insert into donnhaphang (iddonnhap, idnpp, thoigiannhap, nguoitao, tongtien, trangthai) values (?, ?, ?, ?, ?, ?)";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdPhieu());
			ps.setString(2, t.getIdNPP());
			ps.setTimestamp(3, t.getThoiGianTao());
			ps.setString(4, t.getNguoiTao());
			ps.setDouble(5, t.getTongTien());
			ps.setInt(6, t.getTrangThai());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);
		} catch (Exception e) {
			System.out.println(e);
		}

		return check;
	}

	@Override
	public int delete(PhieuNhap t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "delete from donnhaphang where iddonnhap = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdPhieu());
			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);
		} catch (Exception e) {
			System.out.println(e);
		}

		return check;
	}

	@Override
	public int update(PhieuNhap t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "update donnhaphang set idnpp = ?, thoigiannhap = ?, nguoitao = ?, tongtien = ?, trangthai = ? where iddonnhap = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdNPP());
			ps.setTimestamp(2, t.getThoiGianTao());
			ps.setString(3, t.getNguoiTao());
			ps.setDouble(4, t.getTongTien());
			ps.setInt(5, t.getTrangThai());
			ps.setString(6, t.getIdPhieu());
			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);
		} catch (Exception e) {
			System.out.println(e);
		}

		return check;
	}

	@Override
	public ArrayList<PhieuNhap> selectAll() {
		ArrayList<PhieuNhap> list = new ArrayList<PhieuNhap>();

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "select * from donnhaphang";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PhieuNhap pn = new PhieuNhap(rs.getString("iddonnhap"), rs.getString("idnpp"),
						rs.getTimestamp("thoigiannhap"), rs.getString("nguoitao"), rs.getDouble("tongtien"),
						rs.getInt("trangthai"));

				list.add(pn);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	@Override
	public PhieuNhap selectById(String t) {
		PhieuNhap pn = null;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "select * from donnhaphang where iddonnhap = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pn = new PhieuNhap(rs.getString("iddonnhap"), rs.getString("idnpp"), rs.getTimestamp("thoigiannhap"),
						rs.getString("nguoitao"), rs.getDouble("tongtien"), rs.getInt("trangthai"));

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return pn;
	}

}
