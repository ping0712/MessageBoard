package db;

import java.sql.*;

public class Dbconnect {
	private Connection conn = null;

	public Dbconnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 註冊driver
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "root", "ss134679456");
			// 取得connection
			// jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=UTF-8
			// localhost是主機名,test是database名
			// useUnicode=true&characterEncoding=UTF-8使用的編碼
		} catch (ClassNotFoundException e) {
			System.out.println("DriverClassNotFound :" + e.toString());
		} // 有可能會產生sqlexception
		catch (SQLException x) {
			System.out.println("Exception :" + x.toString());
		}
	}

	public Connection getcon() {
		return conn;
	}

	public void close(Connection con) {
		try {
			if (con != null) {
				con.close();
				con = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}

		} catch (SQLException e) {
			System.out.println("Close Exception :" + e.toString());
		}
	}
	public void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}

		} catch (SQLException e) {
			System.out.println("Close Exception :" + e.toString());
		}
	}
	public void close(PreparedStatement ps) {
		try {
			if (ps != null) {
				ps.close();
				ps = null;
			}
			
		} catch (SQLException e) {
			System.out.println("Close Exception :" + e.toString());
		}
	}
	public void close(Statement stat) {
		try {
			if (stat != null) {
				stat.close();
				stat = null;
			}
			
		} catch (SQLException e) {
			System.out.println("Close Exception :" + e.toString());
		}
	}
}
