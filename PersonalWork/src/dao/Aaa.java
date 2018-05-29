package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import base.DBManager;

public class Aaa {
	public static void insertItem(String itemId) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = DBManager.getConnection();
			String sql = "INSERT INTO item(name, price, register_date) VALUES(concat('Product', ?),?*100,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, itemId);
			pst.setInt(2, new java.util.Random().nextInt(30) + 10);
			pst.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			pst.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}
	public static void main(String[] args) {

	}
}
