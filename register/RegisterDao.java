package register;

import java.sql.*;

public class RegisterDao {
	private Connection con = null;
	// 執行,傳入之sql為完整字串
	private ResultSet rs = null;
	// 結果集
	private PreparedStatement ps = null;

	public String selectUid(String uid) {
		db.Dbconnect db = new db.Dbconnect();
		con = db.getcon();
		String result = "";
		String sql = "select password from users where uid = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, uid);
			rs = ps.executeQuery();
			while (rs.next()) {
				result = rs.getString("password");
			}
			return result;
		} catch (SQLException e) {
			System.out.println("DropDB Exception :" + e.toString());
		} finally {
			db.close(con);
			db.close(ps);
			db.close(rs);
		}
		return null;
	}
	public void insertTable(String uid,String pwd) {
		db.Dbconnect db = new db.Dbconnect();
		con = db.getcon();
		String sql = "insert into users(uid,password) values(?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, uid);
			ps.setString(2, pwd);
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println("InsertDB Exception :" + e.toString());	
		} finally {
			db.close(con);
			db.close(ps);
		}
	}
}
