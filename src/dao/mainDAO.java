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
import model.mainboard;
import view.CapNhatMainboard;
import view.ThemMainboard;

public class mainDAO implements DAOInterface<mainboard> {
	public static mainDAO getInstance() {
		return new mainDAO();
	}

	@Override
	public int insert(mainboard t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "insert into mainboard (idsanpham, idmainboard, tenmain, tenhang, hotrocpu, hotroram, kichthuoc, tonkho, dongia, baohanh, img) values (?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdMainboard());
			ps.setString(3, t.getTenMain());
			ps.setString(4, t.getTenHang());
			ps.setString(5, t.getHoTroCPU());
			ps.setString(6, t.getHoTroRAM());
			ps.setString(7, t.getKichThuoc());
			ps.setInt(8, 0);
			ps.setDouble(9, t.getDonGia());
			ps.setString(10, t.getBaoHanh());

			try {
				InputStream is = new FileInputStream(new File(ThemMainboard.getInsert()));
				ps.setBlob(11, is);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			check = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	public int insertIMGURL(mainboard t, String stringUrl) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "insert into mainboard (idsanpham, idmainboard, tenmain, tenhang, hotrocpu, hotroram, kichthuoc, tonkho, dongia, baohanh, img) values (?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdMainboard());
			ps.setString(3, t.getTenMain());
			ps.setString(4, t.getTenHang());
			ps.setString(5, t.getHoTroCPU());
			ps.setString(6, t.getHoTroRAM());
			ps.setString(7, t.getKichThuoc());
			ps.setInt(8, 0);
			ps.setDouble(9, t.getDonGia());
			ps.setString(10, t.getBaoHanh());

			@SuppressWarnings("deprecation")
			URL url = new URL(stringUrl);
			InputStream is = url.openStream();
			ps.setBlob(11, is);

			check = ps.executeUpdate();

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return check;
	}

	public int insertNotIMG(mainboard t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "insert into mainboard (idsanpham, idmainboard, tenmain, tenhang, hotrocpu, hotroram, kichthuoc, tonkho, dongia, baohanh) values (?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdMainboard());
			ps.setString(3, t.getTenMain());
			ps.setString(4, t.getTenHang());
			ps.setString(5, t.getHoTroCPU());
			ps.setString(6, t.getHoTroRAM());
			ps.setString(7, t.getKichThuoc());
			ps.setInt(8, 0);
			ps.setDouble(9, t.getDonGia());
			ps.setString(10, t.getBaoHanh());

			check = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public int update(mainboard t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "update mainboard set idsanpham = ?, tenmain = ?, tenhang = ?, hotrocpu = ?,"
					+ " hotroram = ?, kichthuoc = ?, dongia = ?," + " baohanh = ?, img = ? where idmainboard = ?;";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenMain());
			ps.setString(3, t.getTenHang());
			ps.setString(4, t.getHoTroCPU());
			ps.setString(5, t.getHoTroRAM());
			ps.setString(6, t.getKichThuoc());
			ps.setDouble(7, t.getDonGia());
			ps.setString(8, t.getBaoHanh());

			try {
				InputStream is = new FileInputStream(new File(CapNhatMainboard.getInsert()));
				ps.setBlob(9, is);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			ps.setString(10, t.getIdMainboard());

			check = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	public int updateIMGURL(mainboard t, String stringUrl) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "update mainboard set idsanpham = ?, tenmain = ?, tenhang = ?, hotrocpu = ?,"
					+ " hotroram = ?, kichthuoc = ?, dongia = ?," + " baohanh = ?, img = ? where idmainboard = ?;";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenMain());
			ps.setString(3, t.getTenHang());
			ps.setString(4, t.getHoTroCPU());
			ps.setString(5, t.getHoTroRAM());
			ps.setString(6, t.getKichThuoc());
			ps.setDouble(7, t.getDonGia());
			ps.setString(8, t.getBaoHanh());

			@SuppressWarnings("deprecation")
			URL url = new URL(stringUrl);
			InputStream is = url.openStream();
			ps.setBlob(9, is);

			ps.setString(10, t.getIdMainboard());

			check = ps.executeUpdate();

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return check;
	}

	public int updateNotIMG(mainboard t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "update mainboard set idsanpham = ?, tenmain = ?, tenhang = ?, hotrocpu = ?,"
					+ " hotroram = ?, kichthuoc = ?, dongia = ?," + " baohanh = ? where idmainboard = ?;";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getTenMain());
			ps.setString(3, t.getTenHang());
			ps.setString(4, t.getHoTroCPU());
			ps.setString(5, t.getHoTroRAM());
			ps.setString(6, t.getKichThuoc());
			ps.setDouble(7, t.getDonGia());
			ps.setString(8, t.getBaoHanh());
			ps.setString(9, t.getIdMainboard());

			check = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	public int updateTonKho(ArrayList<ChiTietPhieu> pn, boolean nhapHang) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "UPDATE mainboard SET  tonkho = tonkho + ? WHERE idmainboard = ?;";
			if (nhapHang == false)
				sql = "UPDATE mainboard SET  tonkho = tonkho - ? WHERE idmainboard = ?;";
			for (ChiTietPhieu productNhap : pn) {

				if (productNhap.getIdRieng().contains("mba")) {

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
	public int delete(mainboard t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "delete from mainboard where idmainboard = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getIdMainboard());
			check = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public ArrayList<mainboard> selectAll() {
		ArrayList<mainboard> list = new ArrayList<mainboard>();
		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "select * from mainboard;";
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				mainboard mb = new mainboard(rs.getString("idsanpham"), rs.getString("idmainboard"),
						rs.getString("tenmain"), rs.getString("tenhang"), rs.getString("hotrocpu"),
						rs.getString("hotroram"), rs.getString("kichthuoc"), rs.getInt("tonkho"),
						rs.getDouble("dongia"), rs.getString("baohanh"), rs.getBlob("img"));

				list.add(mb);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public mainboard selectById(String t) {
		mainboard mb = null;

		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "select * from mainboard where idmainboard = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				mb = new mainboard(rs.getString("idsanpham"), rs.getString("idmainboard"), rs.getString("tenmain"),
						rs.getString("tenhang"), rs.getString("hotrocpu"), rs.getString("hotroram"),
						rs.getString("kichthuoc"), rs.getInt("tonkho"), rs.getDouble("dongia"), rs.getString("baohanh"),
						rs.getBlob("img"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mb;

	}

	public ArrayList<mainboard> selectNhapHang() {
		ArrayList<mainboard> c = new ArrayList<mainboard>();
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM mainboard;";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				mainboard mb = new mainboard(rs.getString("idsanpham"), rs.getString("idcpu"), rs.getString("tencpu"),
						rs.getDouble("dongia"), rs.getString("baohanh"));
				c.add(mb);
			}
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	public ArrayList<mainboard> selectByIdSanPham(String t) {
		ArrayList<mainboard> list = new ArrayList<mainboard>();
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM mainboard WHERE idsanpham = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				mainboard mb = new mainboard(rs.getString("idsanpham"), rs.getString("idmainboard"),
						rs.getString("tenmain"), rs.getString("tenhang"), rs.getString("hotrocpu"),
						rs.getString("hotroram"), rs.getString("kichthuoc"), rs.getInt("tonkho"),
						rs.getDouble("dongia"), rs.getString("baohanh"), rs.getBlob("img"));
				list.add(mb);
			}
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public static int tongTonKho() {
		int tonkho = 0;
		String sql = "SELECT SUM(mainboard.tonkho) AS total\r\n" + "FROM mainboard";
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
