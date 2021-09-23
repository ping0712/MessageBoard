package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.Dbconnect;

public class LoginDao {
	private static Connection con = null;
	private static Statement stat = null; 
	  //執行,傳入之sql為完整字串 
	private static ResultSet rs = null; 
	  //結果集 
	private static PreparedStatement ps = null;
	public String selectUser(String uid) {
		db.Dbconnect db = new db.Dbconnect();
		con = db.getcon();
		String result = "";
		String sql = "select password from users where uid = ?";
	    try { 
	    	ps = con.prepareStatement(sql); 
	    	ps.setString(1, uid);
	    	rs = ps.executeQuery(); 
	    	while(rs.next()) { 
	    		result = rs.getString("password");
	    		//System.out.println(rs.getString("id")+"\t\t"+rs.getString("password")); 
	        } 
    		return result;
	    } catch(SQLException e){ 
	      System.out.println("DropDB Exception :" + e.toString()); 
	    } finally { 
	    	db.close(con);
	    	db.close(ps);
	    	db.close(rs);
	    } 
	    return null;
	}
}
