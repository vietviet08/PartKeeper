/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.JDBCUntil;
import model.Account;

public class AccountDAO implements DAOInterface<Account> {

	public static AccountDAO getInstance() {
		return new AccountDAO();
	}

	@Override
	public int insert(Account t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "INSERT INTO account (username, password, email, fullname, sex, status) VALUES (?,?,?,?,?,?)";

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(4, t.getFullName());
			pst.setString(1, t.getUser());
			pst.setString(2, t.getPassword());
			pst.setInt(5, t.getSex());
			pst.setInt(6, t.getStatus());
			pst.setString(3, t.getEmail());

			ketQua = pst.executeUpdate();

			JDBCUntil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int update(Account t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "UPDATE account SET username=?, password=?, email=?, fullname=?, sex=?, status=? WHERE username=?";

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(4, t.getFullName());
			pst.setString(2, t.getPassword());
			pst.setInt(6, t.getStatus());
			pst.setInt(5, t.getSex());
			pst.setString(1, t.getUser());
			pst.setString(3, t.getEmail());

			ketQua = pst.executeUpdate();

			JDBCUntil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int delete(Account t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "DELETE FROM account WHERE username=?";

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getUser());

			ketQua = pst.executeUpdate();

			JDBCUntil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ArrayList<Account> selectAll() {
		ArrayList<Account> ketQua = new ArrayList<Account>();
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "SELECT * FROM account";

			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String userName = rs.getString("userName");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String fullName = rs.getString("fullName");
				int status = rs.getInt("status");
				int sex = rs.getInt("sex");

				Account acc = new Account(fullName, userName, password, email, sex, status);
				ketQua.add(acc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public Account selectById(String t) {
		Account acc = null;
		try {
			Connection con = JDBCUntil.getConnection();
			String sql = "SELECT * FROM account WHERE username=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String userName = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String fullName = rs.getString("fullName");
				int status = rs.getInt("status");
				int sex = rs.getInt("sex");
				acc = new Account(userName, password, fullName, email, sex, status);
			}
			JDBCUntil.closeConnection(con);
		} catch (Exception e) {
		}
		return acc;
	}

	public int updatePassword(String email, String password) {
		int ketQua = 0;
		try {
			Connection con = JDBCUntil.getConnection();

			String sql = "UPDATE account SET password=? WHERE email=?";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, password);
			pst.setString(2, email);

			ketQua = pst.executeUpdate();
			JDBCUntil.closeConnection(con);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}
}
