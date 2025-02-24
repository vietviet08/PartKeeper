package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.JDBCUntil;
import model.PhieuXuat;

public class PhieuXuatDAO implements DAOInterface<PhieuXuat> {

	public static PhieuXuatDAO getInstance() {
		return new PhieuXuatDAO();
	}

	@Override
	public int insert(PhieuXuat t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "insert into donxuathang (iddonxuat, idkhachhang, thoigianxuat, nguoitao, tongtien, trangthai) values (?, ?, ?, ?, ?, ?)";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdPhieu());
			ps.setString(2, t.getIdKhachHang());
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
	public int delete(PhieuXuat t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "delete from donxuathang where iddonxuat = ?)";

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
	public int update(PhieuXuat t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "update donxuathang set idkhachhang = ?, thoigianxuat = ?, nguoitao = ?, tongtien = ?, trangthai = ? where iddonxuat = ?)";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdKhachHang());
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
	public ArrayList<PhieuXuat> selectAll() {
		ArrayList<PhieuXuat> list = new ArrayList<PhieuXuat>();

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "select * from donxuathang";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PhieuXuat pn = new PhieuXuat(rs.getString("iddonxuat"), rs.getString("idkhachhang"),
						rs.getTimestamp("thoigianxuat"), rs.getString("nguoitao"), rs.getDouble("tongtien"),
						rs.getInt("trangthai"));

				list.add(pn);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	@Override
	public PhieuXuat selectById(String t) {
		PhieuXuat pn = null;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "select * from donxuathang where iddonxuat = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pn = new PhieuXuat(rs.getString("iddonxuat"), rs.getString("idkhachhang"),
						rs.getTimestamp("thoigianxuat"), rs.getString("nguoitao"), rs.getDouble("tongtien"),
						rs.getInt("trangthai"));

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return pn;
	}

}
