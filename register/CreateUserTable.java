package register;

import java.sql.*;

public class CreateUserTable {
	private static Connection con = null;
	private static ResultSet rs = null; 
	private static Statement stat = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		db.Dbconnect db = new db.Dbconnect();
		con = db.getcon();
		String createSQL = "create table message(uid VARCHAR(20), text VARCHAR(200))";
		try {
			stat = con.createStatement(); 
		    stat.executeUpdate(createSQL); 
			
		} catch (SQLException e) {
			System.out.println("DropDB Exception :" + e.toString());
		} finally {
			db.close(con);
			db.close(stat);
			db.close(rs);
		}
	}

}
