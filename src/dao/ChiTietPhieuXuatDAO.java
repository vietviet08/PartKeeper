package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JDBCUntil;
import model.ChiTietPhieu;

public class ChiTietPhieuXuatDAO implements DAOInterface<ChiTietPhieu> {

	public static ChiTietPhieuXuatDAO getInstance() {
		return new ChiTietPhieuXuatDAO();
	}

	@Override
	public int insert(ChiTietPhieu t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "insert into chitietdonxuat (iddonxuat, idsanpham, idrieng , tensanpham, soluong, dongia, baohanh) values (?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdPhieu());
			ps.setString(2, t.getIdSanPham());
			ps.setString(3, t.getIdRieng());
			ps.setString(4, t.getTenSanPham());
			ps.setInt(5, t.getSoLuong());
			ps.setDouble(6, t.getDonGia());
			ps.setString(7, t.getBaoHanh());

			check = ps.executeUpdate();
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public int update(ChiTietPhieu t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "update chitietdonxuat set  idsanpham = ?, idrieng = ?, tensanpham = ?, soluong = ?, dongia = ?, baohanh = ? where iddonxuat = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdRieng());
			ps.setString(3, t.getTenSanPham());
			ps.setInt(4, t.getSoLuong());
			ps.setDouble(5, t.getDonGia());
			ps.setString(6, t.getBaoHanh());
			ps.setString(7, t.getIdPhieu());

			check = ps.executeUpdate();
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int delete(ChiTietPhieu t) {

		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "delete from chitietdonxuat where iddonxuat = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdPhieu());

			check = ps.executeUpdate();
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	public int deleteByID(String t) {

		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "delete from chitietdonxuat where iddonxuat = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t);

			check = ps.executeUpdate();
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public ArrayList<ChiTietPhieu> selectAll() {
		ArrayList<ChiTietPhieu> ttp = new ArrayList<ChiTietPhieu>();

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "select * from chitietdonxuat";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ChiTietPhieu ct = new ChiTietPhieu(rs.getString("iddonxuat"), rs.getString("idsanpham"),
						rs.getString("idrieng"), rs.getString("tensanpham"), rs.getInt("soluong"),
						rs.getDouble("dongia"), rs.getString("baohanh"));

				ttp.add(ct);

			}
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ttp;
	}

	public ArrayList<ChiTietPhieu> selectAllByID(String t) {
		ArrayList<ChiTietPhieu> ttp = new ArrayList<ChiTietPhieu>();

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "select * from chitietdonxuat where iddonxuat = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ChiTietPhieu ct = new ChiTietPhieu(rs.getString("iddonxuat"), rs.getString("idsanpham"),
						rs.getString("idrieng"), rs.getString("tensanpham"), rs.getInt("soluong"),
						rs.getDouble("dongia"), rs.getString("baohanh"));

				ttp.add(ct);

			}
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ttp;
	}

	@Override
	public ChiTietPhieu selectById(String t) {

		ChiTietPhieu ttp = null;
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "select * from chitietdonxuat where iddonxuat = ?";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ttp = new ChiTietPhieu(rs.getString("iddonxuat"), rs.getString("idsanpham"), rs.getString("tensanpham"),
						rs.getString("idrieng"), rs.getInt("soluong"), rs.getDouble("dongia"), rs.getString("baohanh"));
			}
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ttp;
	}

	public ArrayList<ChiTietPhieu> sanPhamBanChay() {
		String sql = "SELECT *, sum(chitietdonxuat.soluong) AS total\r\n" + "FROM chitietdonxuat\r\n"
				+ "GROUP BY idrieng\r\n" + "ORDER BY total DESC ";

		ArrayList<ChiTietPhieu> ttp = new ArrayList<ChiTietPhieu>();

		try {
			Connection con = JDBCUntil.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ChiTietPhieu ct = new ChiTietPhieu(rs.getString("iddonxuat"), rs.getString("idsanpham"),
						rs.getString("idrieng"), rs.getString("tensanpham"), rs.getInt("total"), rs.getDouble("dongia"),
						rs.getString("baohanh"));

				ttp.add(ct);

			}
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ttp;
	}

	public int tongDonXuat(String t) {
		int total = 0;
		try {
			String sql = "SELECT SUM(tbcpu.soluong) AS total " + "FROM ( " + "SELECT * " + "FROM chitietdonxuat AS dx "
					+ "WHERE dx.idrieng LIKE 'cpu%' " + ") AS tbcpu";
			switch (t) {
			case "cpu":
				sql = "SELECT SUM(tb.soluong) AS total " + "FROM ( " + "SELECT * " + "FROM chitietdonxuat AS dx "
						+ "WHERE dx.idrieng LIKE 'cpu%' " + ") AS tb";
				break;
			case "ram":
				sql = "SELECT SUM(tb.soluong) AS total " + "FROM ( " + "SELECT * " + "FROM chitietdonxuat AS dx "
						+ "WHERE dx.idrieng LIKE 'r%' " + ") AS tb";
				break;
			case "vga":
				sql = "SELECT SUM(tb.soluong) AS total " + "FROM ( " + "SELECT * " + "FROM chitietdonxuat AS dx "
						+ "WHERE dx.idrieng LIKE 'vga%' " + ") AS tb";
				break;
			case "cases":
				sql = "SELECT SUM(tb.soluong) AS total " + "FROM ( " + "SELECT * " + "FROM chitietdonxuat AS dx "
						+ "WHERE dx.idrieng LIKE 'cs%' " + ") AS tb";
				break;
			case "main":
				sql = "SELECT SUM(tb.soluong) AS total " + "FROM ( " + "SELECT * " + "FROM chitietdonxuat AS dx "
						+ "WHERE dx.idrieng LIKE 'main%' " + ") AS tb";
				break;
			case "psu":
				sql = "SELECT SUM(tb.soluong) AS total " + "FROM ( " + "SELECT * " + "FROM chitietdonxuat AS dx "
						+ "WHERE dx.idrieng LIKE 'psu%' " + ") AS tb";
				break;
			case "ssd":
				sql = "SELECT SUM(tb.soluong) AS total " + "FROM ( " + "SELECT * " + "FROM chitietdonxuat AS dx "
						+ "WHERE dx.idrieng LIKE 'ssd%' " + ") AS tb";
				break;
			case "hdd":
				sql = "SELECT SUM(tb.soluong) AS total " + "FROM ( " + "SELECT * " + "FROM chitietdonxuat AS dx "
						+ "WHERE dx.idrieng LIKE 'hdd%' " + ") AS tb";
				break;

			default:
				break;
			}
			
			Connection con = JDBCUntil.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);


			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				total = rs.getInt("total");
			}
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}
	
	public int tongDonXuatSPRieng(String t) {
		int total = 0;
		try {
			String sql = "SELECT SUM(tb.soluong) AS total " + "FROM ( " + "SELECT * " + "FROM chitietdonxuat AS dx "
					+ "WHERE dx.idrieng LIKE ? " + ") AS tb";
			
			
			Connection con = JDBCUntil.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, t);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				total = rs.getInt("total");
			}
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}

}
