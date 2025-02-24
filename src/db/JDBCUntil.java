package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUntil {
	public static Connection getConnection() {
		Connection c = null;
		try {
			c = DriverManager.getConnection("jdbc:mySQL://localhost:3306/quanlilkmt", "root", "");
			if (c != null) {
				System.out.println("ket noi thanh cong");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	public static void closeConnection(Connection c) {
		if (c != null) {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
