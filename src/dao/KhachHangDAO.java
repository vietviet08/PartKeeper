package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JDBCUntil;
import model.KhachHang;
import view.KhachHangForm;

public class KhachHangDAO implements DAOInterface<KhachHang> {

	public static KhachHangDAO getInstance() {
		return new KhachHangDAO();
	}

	@Override
	public int insert(KhachHang t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "insert into khachhang (idkhachhang, tenkhachhang, diachi, email, sdt, ngaythamgia, img) values (?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getIdKhachHang());
			ps.setString(2, t.getTenKhachHang());
			ps.setString(3, t.getDiaChi());
			ps.setString(4, t.getEmail());
			ps.setString(5, t.getSdt());
			ps.setTimestamp(6, t.getNgayThamGia());
			try {
				InputStream is = new FileInputStream(new File(KhachHangForm.getInsert()));
				ps.setBlob(7, is);
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

	public int insertNotIMG(KhachHang t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "insert into khachhang (idkhachhang, tenkhachhang, diachi, email, sdt, ngaythamgia) values (?, ?, ?, ?, ?, ?);";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getIdKhachHang());
			ps.setString(2, t.getTenKhachHang());
			ps.setString(3, t.getDiaChi());
			ps.setString(4, t.getEmail());
			ps.setString(5, t.getSdt());
			ps.setTimestamp(6, t.getNgayThamGia());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public int update(KhachHang t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "update khachhang set tenkhachhang = ?, diachi = ?, email = ?, sdt = ?, img = ? where idkhachhang = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getTenKhachHang());
			ps.setString(2, t.getDiaChi());
			ps.setString(3, t.getEmail());
			ps.setString(4, t.getSdt());
			try {
				InputStream is = new FileInputStream(new File(KhachHangForm.getInsert()));
				ps.setBlob(5, is);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			ps.setString(6, t.getIdKhachHang());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	public int updateNotIMG(KhachHang t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "update khachhang set tenkhachhang = ?, diachi = ?, email = ?, sdt = ? where idkhachhang = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getTenKhachHang());
			ps.setString(2, t.getDiaChi());
			ps.setString(3, t.getEmail());
			ps.setString(4, t.getSdt());
			ps.setString(5, t.getIdKhachHang());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public int delete(KhachHang t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "update khachhang set status = 0 where idkhachhang = ?;";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdKhachHang());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	public int allowUser(KhachHang t) {
		int check = 0;

		try {

			Connection con = JDBCUntil.getConnection();
			String sql = "update khachhang set status = 1 where idkhachhang = ?;";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdKhachHang());

			check = ps.executeUpdate();
			JDBCUntil.closeConnection(con);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return check;

	}

	@Override
	public ArrayList<KhachHang> selectAll() {
		ArrayList<KhachHang> list = new ArrayList<KhachHang>();
		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "select * from khachhang;";
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				;

				KhachHang kh = new KhachHang(rs.getString("idkhachhang"), rs.getString("tenkhachhang"),
						rs.getString("diachi"), rs.getString("email"), rs.getString("sdt"),
						rs.getTimestamp("ngaythamgia"), rs.getBlob("img"), rs.getInt("status"));
				list.add(kh);
			}

			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public KhachHang selectById(String t) {
		KhachHang kh = null;

		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "select * from khachhang where idkhachhang = ? and status = 1 ;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				kh = new KhachHang(rs.getString("idkhachhang"), rs.getString("tenkhachhang"), rs.getString("diachi"),
						rs.getString("email"), rs.getString("sdt"), rs.getTimestamp("ngaythamgia"), rs.getBlob("img"),
						rs.getInt("status"));
			}

			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kh;
	}

	public KhachHang selectBySDT(String t) {
		KhachHang kh = null;

		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "select * from khachhang where sdt = ? and status = 1;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				kh = new KhachHang(rs.getString("idkhachhang"), rs.getString("tenkhachhang"), rs.getString("diachi"),
						rs.getString("email"), rs.getString("sdt"), rs.getTimestamp("ngaythamgia"), rs.getBlob("img"),
						rs.getInt("status"));
			}

			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kh;
	}

}
