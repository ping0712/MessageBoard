package messageboard;

import java.sql.*;
import java.util.*;

public class MessageBoardDao {
	private Connection con = null;
	private Statement stat = null;
	// 執行,傳入之sql為完整字串
	private ResultSet rs = null;
	// 結果集
	private PreparedStatement ps = null;

	public ArrayList<MessageBoard> selectAll() {
		ArrayList<MessageBoard> result = new ArrayList<>();
		db.Dbconnect db = new db.Dbconnect();
		con = db.getcon();
		String sql = "select * from message";
		try {
			stat = con.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				result.add(new MessageBoard(rs.getString("uid"), rs.getString("text")));
			}
			return result;
		} catch (SQLException e) {
			System.out.println("DropDB Exception :" + e.toString());
		} finally {
			db.close(con);
			db.close(stat);
			db.close(rs);
		}
		return null;
	}

	public void insertTable(String uid, String text) {
		db.Dbconnect db = new db.Dbconnect();
		con = db.getcon();
		String sql = "insert into message(uid,text) values(?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, uid);
			ps.setString(2, text);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("InsertDB Exception :" + e.toString());
		} finally {
			db.close(con);
			db.close(ps);
		}
	}

	public int selectSerial(int index) {
		db.Dbconnect db = new db.Dbconnect();
		con = db.getcon();
		String sql = "select serial_number from message limit ?";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, index + 1);
			rs = ps.executeQuery();
			while (rs.next()) {
				result = rs.getInt("serial_number");
			}
			return result;
		} catch (SQLException e) {
			System.out.println("DropDB Exception :" + e.toString());
		} finally {
			db.close(con);
			db.close(ps);
			db.close(rs);
		}
		return -1;
	}

	public void deleteData(int index) {
		int i = selectSerial(index);
		db.Dbconnect db = new db.Dbconnect();
		con = db.getcon();
		String sql = "delete from message where serial_number=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, i);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("InsertDB Exception :" + e.toString());
		} finally {
			db.close(con);
			db.close(ps);
		}
	}
	public void updateData(int index,String msg) {
		db.Dbconnect db = new db.Dbconnect();
		con = db.getcon();
		String sql = "update message set text = ? where serial_number = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, msg);
			ps.setInt(2, index);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("InsertDB Exception :" + e.toString());
		} finally {
			db.close(con);
			db.close(ps);
		}
	}
}
