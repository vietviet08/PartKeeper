package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JDBCUntil;
import model.Products;

public class SanPhamDAO implements DAOInterface<Products> {

	public static SanPhamDAO getInstance() {
		return new SanPhamDAO();
	}

	@Override
	public int insert(Products t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "INSERT INTO sanpham (idsanpham, tensanpham, trangthai, motasanpham) VALUES (?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenSanPham());
			ps.setInt(3, t.getTrangThai());
			ps.setString(4, t.getMoTa());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public int update(Products t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "update sanpham set tensanpham = ?, trangthai = ? , motasanpham = ? where idsanpham = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getTenSanPham());
			ps.setInt(2, t.getTrangThai());
			ps.setString(3, t.getMoTa());
			ps.setString(4, t.getIdSanPham());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int delete(Products t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "delete from sanpham where idsanpham = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public ArrayList<Products> selectAll() {
		ArrayList<Products> list = new ArrayList<>();

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "select * from sanpham;";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Products p = new Products(rs.getString("idsanpham"), rs.getString("tensanpham"), rs.getInt("trangthai"),
						rs.getString("motasanpham"));

				list.add(p);
			}

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Products selectById(String t) {
		Products p = null;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "select * from sanpham where idsanpham = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				p = new Products(rs.getString("idsanpham"), rs.getString("tensanpham"), rs.getInt("trangthai"),
						rs.getString("motasanpham"));

			}

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}

	public static ArrayList<Products> getIDSanPham(String name) {
		ArrayList<Products> list = new ArrayList<>();
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "select * from sanpham where idsanpham like 'cpu%';";

			switch (name) {
			case "cpu":
				sql = "select * from sanpham where idsanpham like 'cpu%';";
				break;
			case "ram":
				sql = "select * from sanpham where idsanpham like 'ram%';";
				break;
			case "vga":
				sql = "select * from sanpham where idsanpham like 'RTX%' or idsanpham like 'GTX%';";
				break;

			case "mainboard":
				sql = "select * from sanpham where idsanpham like 'main%';";
				break;
			case "psu":
				sql = "select * from sanpham where idsanpham like 'psu%';";
				break;

			case "chuot":
				sql = "select * from sanpham where idsanpham like 'mou%';";
				break;

			case "banphim":
				sql = "select * from sanpham where idsanpham like 'keyb%';";
				break;

			case "manhinh":
				sql = "select * from sanpham where idsanpham like 'scr%';";
				break;

			case "ssd":
				sql = "select * from sanpham where idsanpham like 'ssd%';";
				break;
			case "hdd":
				sql = "select * from sanpham where idsanpham like 'hdd%';";
				break;

			case "headphone":
				sql = "select * from sanpham where idsanpham like 'hp%';";
				break;
			case "case":
				sql = "select * from sanpham where idsanpham like 'cs%';";
				break;
			default:
				break;
			}

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Products p = new Products(rs.getString("idsanpham"), rs.getString("tensanpham"), rs.getInt("trangthai"),
						rs.getString("motasanpham"));

				list.add(p);
			}

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
