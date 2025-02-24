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
import model.ram;
import view.CapNhatRAM;
import view.ThemRAM;

public class ramDAO implements DAOInterface<ram> {

	public static ramDAO getInstance() {
		return new ramDAO();
	}

	@Override
	public int insert(ram t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "INSERT INTO ram (idsanpham, idram, tenram, loairam, dungluong, bus, tonkho, dongia, baohanh, img) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdRam());
			ps.setString(3, t.getTenRam());
			ps.setString(4, t.getLoai());
			ps.setString(5, t.getDungLuong());
			ps.setString(6, t.getBus());
			ps.setInt(7, t.getTonkho());
			ps.setDouble(8, t.getDonGia());
			ps.setString(9, t.getBaoHanh());

			try {
				InputStream is = new FileInputStream(new File(ThemRAM.getInsert()));
				ps.setBlob(10, is);
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

	public int insertIMGURL(ram t, String stringUrl) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "INSERT INTO ram (idsanpham, idram, tenram, loairam, dungluong, bus, tonkho, dongia, baohanh, img) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdRam());
			ps.setString(3, t.getTenRam());
			ps.setString(4, t.getLoai());
			ps.setString(5, t.getDungLuong());
			ps.setString(6, t.getBus());
			ps.setInt(7, t.getTonkho());
			ps.setDouble(8, t.getDonGia());
			ps.setString(9, t.getBaoHanh());

			@SuppressWarnings("deprecation")
			URL url = new URL(stringUrl);
			InputStream is = url.openStream();
			ps.setBlob(10, is);

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return check;
	}

	public int insertNotIMG(ram t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "INSERT INTO ram (idsanpham, idram, tenram, loairam, dungluong, bus, tonkho, dongia, baohanh) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdRam());
			ps.setString(3, t.getTenRam());
			ps.setString(4, t.getLoai());
			ps.setString(5, t.getDungLuong());
			ps.setString(6, t.getBus());
			ps.setInt(7, t.getTonkho());
			ps.setDouble(8, t.getDonGia());
			ps.setString(9, t.getBaoHanh());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public int update(ram t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "UPDATE ram SET idsanpham = ?, tenram = ?, loairam = ?, dungluong = ?, bus = ?, tonkho = ?, dongia = ?, baohanh = ?, img = ? WHERE idram = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenRam());
			ps.setString(3, t.getLoai());
			ps.setString(4, t.getDungLuong());
			ps.setString(5, t.getBus());
			ps.setInt(6, t.getTonkho());
			ps.setDouble(7, t.getDonGia());
			ps.setString(8, t.getBaoHanh());

			try {
				InputStream is = new FileInputStream(new File(CapNhatRAM.getInsert()));
				ps.setBlob(9, is);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			ps.setString(10, t.getIdRam());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	public int updateIMGURL(ram t, String stringUrl) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "UPDATE ram SET idsanpham = ?, tenram = ?, loairam = ?, dungluong = ?, bus = ?, tonkho = ?, dongia = ?, baohanh = ?, img = ? WHERE idram = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenRam());
			ps.setString(3, t.getLoai());
			ps.setString(4, t.getDungLuong());
			ps.setString(5, t.getBus());
			ps.setInt(6, t.getTonkho());
			ps.setDouble(7, t.getDonGia());
			ps.setString(8, t.getBaoHanh());

			@SuppressWarnings("deprecation")
			URL url = new URL(stringUrl);
			InputStream is = url.openStream();
			ps.setBlob(9, is);

			ps.setString(10, t.getIdRam());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return check;
	}

	public int updateNotIMG(ram t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "UPDATE ram SET idsanpham = ?, tenram = ?, loairam = ?, dungluong = ?, bus = ?, tonkho = ?, dongia = ? WHERE idram = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenRam());
			ps.setString(3, t.getLoai());
			ps.setString(4, t.getDungLuong());
			ps.setString(5, t.getBus());
			ps.setInt(6, t.getTonkho());
			ps.setDouble(7, t.getDonGia());
			ps.setString(8, t.getIdRam());

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

			String sql = "UPDATE ram SET tonkho = tonkho + ? WHERE idram = ? ;";
			if (nhapHang == false)
				sql = "UPDATE ram SET tonkho = tonkho - ? WHERE idram = ? ;";

			for (ChiTietPhieu productNhap : pn) {
				if (productNhap.getIdRieng().contains("r")) {
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
	public int delete(ram t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "DELETE FORM ram WHERE idram = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdRam());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public ArrayList<ram> selectAll() {
		ArrayList<ram> r = new ArrayList<ram>();

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM ram;";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ram ram = new ram(rs.getString("idsanpham"), rs.getString("idram"), rs.getString("tenram"),
						rs.getString("loairam"), rs.getString("dungluong"), rs.getString("bus"), rs.getInt("tonkho"),
						rs.getDouble("dongia"), rs.getString("baohanh"), rs.getBlob("img"));
				r.add(ram);
			}

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return r;
	}

	public ArrayList<ram> selectNhapHang() {
		ArrayList<ram> list = new ArrayList<ram>();

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM ram;";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ram ram = new ram(rs.getString("idsanpham"), rs.getString("idram"), rs.getString("tenram"),
						rs.getDouble("dongia"), rs.getString("baohanh"));
				list.add(ram);
			}

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public ram selectById(String t) {
		ram r = null;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM ram WHERE idram = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				r = new ram(rs.getString("idsanpham"), rs.getString("idram"), rs.getString("tenram"),
						rs.getString("loairam"), rs.getString("dungluong"), rs.getString("bus"), rs.getInt("tonkho"),
						rs.getDouble("dongia"), rs.getString("baohanh"), rs.getBlob("img"));
			}

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return r;
	}

	public static int tongTonKho() {
		int tonkho = 0;
		String sql = "SELECT SUM(ram.tonkho) AS total\r\n" + "FROM ram";
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
