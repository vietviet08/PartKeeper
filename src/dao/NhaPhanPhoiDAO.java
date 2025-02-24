package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JDBCUntil;
import model.NhaPhanPhoi;

public class NhaPhanPhoiDAO implements DAOInterface<NhaPhanPhoi> {

	public static NhaPhanPhoiDAO getInstance() {
		return new NhaPhanPhoiDAO();
	}

	@Override
	public int insert(NhaPhanPhoi t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "INSERT INTO nhaphanphoi (idnpp, tennpp, diachi, email, sdt) VALUES (?, ?, ?, ?, ?);";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdNPP());
			ps.setString(2, t.getTenNPP());
			ps.setString(3, t.getDiaChi());
			ps.setString(4, t.getEmail());
			ps.setInt(5, t.getSdt());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}

	@Override
	public int update(NhaPhanPhoi t) {

		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "UPDATE nhaphanphoi SET tennpp = ?, diachi = ?, email = ?, sdt = ? WHERE idnpp = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getTenNPP());
			ps.setString(2, t.getDiaChi());
			ps.setString(3, t.getEmail());
			ps.setInt(4, t.getSdt());
			ps.setString(5, t.getIdNPP());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int delete(NhaPhanPhoi t) {
		int check = 0;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "DELETE FROM nhaphanphoi WHERE idnpp = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t.getIdNPP());

			check = ps.executeUpdate();

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public ArrayList<NhaPhanPhoi> selectAll() {
		ArrayList<NhaPhanPhoi> npp = new ArrayList<NhaPhanPhoi>();

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM nhaphanphoi;";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				NhaPhanPhoi nhapp = new NhaPhanPhoi(rs.getString("idnpp"), rs.getString("tennpp"),
						rs.getString("diachi"), rs.getString("email"), rs.getInt("sdt"));
				npp.add(nhapp);
			}

			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return npp;
	}

	@Override
	public NhaPhanPhoi selectById(String t) {
		NhaPhanPhoi npp = null;

		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM nhaphanphoi WHERE idnpp = ?;";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, t);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				npp = new NhaPhanPhoi(rs.getString("idnpp"), rs.getString("tennpp"), rs.getString("diachi"),
						rs.getString("email"), rs.getInt("sdt"));
			}
			JDBCUntil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return npp;
	}

}
