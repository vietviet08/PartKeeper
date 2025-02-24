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
import model.cpu;
import view.CapNhatCPU;
import view.ThemCPU;

public class cpuDAO implements DAOInterface<cpu> {

	public static cpuDAO getInstance() {
		return new cpuDAO();
	}

	@Override
	public int insert(cpu t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "INSERT INTO cpu (idsanpham, idcpu, tencpu, xungnhip, sonhan, soluong, diennangtieuthu, bonhodem, tonkho, dongia, baohanh, img) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdCpu());
			ps.setString(3, t.getNameCpu());
			ps.setString(4, t.getXungNhip());
			ps.setInt(5, t.getSoNhan());
			ps.setInt(6, t.getSoLuong());
			ps.setString(7, t.getDienNangTieuThu());
			ps.setString(8, t.getBoNhoDem());
			ps.setInt(9, 0);
			ps.setDouble(10, t.getDonGia());
			ps.setString(11, t.getBaoHanh());

			try {
				InputStream is = new FileInputStream(new File(ThemCPU.getInsert()));
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

	@SuppressWarnings("deprecation")
	public int insertIMGURL(cpu t, String stringUrl) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "INSERT INTO cpu (idsanpham, idcpu, tencpu, xungnhip, sonhan, soluong, diennangtieuthu, bonhodem, tonkho, dongia, baohanh, img) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdCpu());
			ps.setString(3, t.getNameCpu());
			ps.setString(4, t.getXungNhip());
			ps.setInt(5, t.getSoNhan());
			ps.setInt(6, t.getSoLuong());
			ps.setString(7, t.getDienNangTieuThu());
			ps.setString(8, t.getBoNhoDem());
			ps.setInt(9, 0);
			ps.setDouble(10, t.getDonGia());
			ps.setString(11, t.getBaoHanh());

			InputStream is;
			URL url;
			url = new URL(stringUrl);
			is = url.openStream();
			ps.setBlob(12, is);

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return check;
	}

	public int insertNotIMG(cpu t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "INSERT INTO cpu (idsanpham, idcpu, tencpu, xungnhip, sonhan, soluong, diennangtieuthu, bonhodem,tonkho, dongia, baohanh) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getIdCpu());
			ps.setString(3, t.getNameCpu());
			ps.setString(4, t.getXungNhip());
			ps.setInt(5, t.getSoNhan());
			ps.setInt(6, t.getSoLuong());
			ps.setString(7, t.getDienNangTieuThu());
			ps.setString(8, t.getBoNhoDem());
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
	public int update(cpu t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "UPDATE cpu SET idsanpham = ?, tencpu = ?, xungnhip = ?, sonhan = ?, soluong = ?, diennangtieuthu = ?, bonhodem = ?, dongia = ?, baohanh = ?, img = ? WHERE idcpu = ?;";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getNameCpu());
			ps.setString(3, t.getXungNhip());
			ps.setInt(4, t.getSoNhan());
			ps.setInt(5, t.getSoLuong());
			ps.setString(6, t.getDienNangTieuThu());
			ps.setString(7, t.getBoNhoDem());
//			ps.setInt(8, t.getTonKho());
			ps.setDouble(8, t.getDonGia());
			ps.setString(9, t.getBaoHanh());

			try {
				InputStream is = new FileInputStream(new File(CapNhatCPU.getInsert()));
				ps.setBlob(10, is);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			ps.setString(11, t.getIdCpu());
			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	public int updateIMGURL(cpu t, String stringUrl) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "UPDATE cpu SET idsanpham = ?, tencpu = ?, xungnhip = ?, sonhan = ?, soluong = ?, diennangtieuthu = ?, bonhodem = ?, dongia = ?, baohanh = ?, img = ? WHERE idcpu = ?;";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getNameCpu());
			ps.setString(3, t.getXungNhip());
			ps.setInt(4, t.getSoNhan());
			ps.setInt(5, t.getSoLuong());
			ps.setString(6, t.getDienNangTieuThu());
			ps.setString(7, t.getBoNhoDem());
//			ps.setInt(8, t.getTonKho());
			ps.setDouble(8, t.getDonGia());
			ps.setString(9, t.getBaoHanh());

			@SuppressWarnings("deprecation")
			URL url = new URL(stringUrl);
			InputStream is = url.openStream();
			ps.setBlob(10, is);

			ps.setString(11, t.getIdCpu());
			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return check;
	}

	public int updateNotIMG(cpu t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "UPDATE cpu SET idsanpham = ?, tencpu = ?, xungnhip = ?, sonhan = ?, soluong = ?, diennangtieuthu = ?, bonhodem = ?, dongia = ?, baohanh = ? WHERE idcpu = ?;";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, t.getIdSanPham());
			ps.setString(2, t.getNameCpu());
			ps.setString(3, t.getXungNhip());
			ps.setInt(4, t.getSoNhan());
			ps.setInt(5, t.getSoLuong());
			ps.setString(6, t.getDienNangTieuThu());
			ps.setString(7, t.getBoNhoDem());
//			ps.setInt(8, t.getTonKho());
			ps.setDouble(8, t.getDonGia());
			ps.setString(9, t.getBaoHanh());
			ps.setString(10, t.getIdCpu());
			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

//	cần tạo method update số lượng sản phẩm khi được nhập hàng hoặc xuất hàng

	public int updateTonKho(ArrayList<ChiTietPhieu> pn, boolean nhapHang) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "";
			if (nhapHang) {
				sql = "UPDATE cpu SET  tonkho = tonkho + ? WHERE idcpu = ?;";

			} else
				sql = "UPDATE cpu SET  tonkho = tonkho - ? WHERE idcpu = ?;";
			for (ChiTietPhieu productNhap : pn) {

				if (productNhap.getIdRieng().contains("cpu")) {

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
	public int delete(cpu t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "DELETE FROM cpu WHERE idcpu = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdCpu());
			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public ArrayList<cpu> selectAll() {
		ArrayList<cpu> c = new ArrayList<cpu>();
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM cpu;";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				cpu chip = new cpu(rs.getString("idsanpham"), rs.getString("idcpu"), rs.getString("tencpu"),
						rs.getString("xungnhip"), rs.getInt("sonhan"), rs.getInt("soluong"),
						rs.getString("diennangtieuthu"), rs.getString("bonhodem"), rs.getInt("tonkho"),
						rs.getDouble("dongia"), rs.getString("baohanh"), rs.getBlob("img"));
				c.add(chip);
			}
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	public ArrayList<cpu> selectNhapHang() {
		ArrayList<cpu> c = new ArrayList<cpu>();
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM cpu;";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				cpu chip = new cpu(rs.getString("idsanpham"), rs.getString("idcpu"), rs.getString("tencpu"),
						rs.getDouble("dongia"), rs.getString("baohanh"));
				c.add(chip);
			}
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public cpu selectById(String t) {
		cpu c = null;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM cpu WHERE idcpu = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				c = new cpu(rs.getString("idsanpham"), rs.getString("idcpu"), rs.getString("tencpu"),
						rs.getString("xungnhip"), rs.getInt("sonhan"), rs.getInt("soluong"),
						rs.getString("diennangtieuthu"), rs.getString("bonhodem"), rs.getInt("tonkho"),
						rs.getDouble("dongia"), rs.getString("baohanh"), rs.getBlob("img"));
			}
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return c;
	}

	public ArrayList<cpu> selectByIdSanPham(String t) {
		ArrayList<cpu> list = new ArrayList<cpu>();
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM cpu WHERE idsanpham = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				cpu c = new cpu(rs.getString("idsanpham"), rs.getString("idcpu"), rs.getString("tencpu"),
						rs.getString("xungnhip"), rs.getInt("sonhan"), rs.getInt("soluong"),
						rs.getString("diennangtieuthu"), rs.getString("bonhodem"), rs.getInt("tonkho"),
						rs.getDouble("dongia"), rs.getString("baohanh"), rs.getBlob("img"));
				list.add(c);
			}
			JDBCUntil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public static int tongTonKho() {
		int tonkho = 0;
		String sql = "SELECT SUM(cpu.tonkho) AS total\r\n" + "FROM cpu";
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
