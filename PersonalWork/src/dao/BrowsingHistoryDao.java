package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import model.BrowsingHistory;

public class BrowsingHistoryDao {
	public void insertBrowsingHistory(int userId, int itemId) {
		Connection con = null;
		PreparedStatement pst = null;
		Statement st = null;
		List<BrowsingHistory> bhList = new ArrayList<BrowsingHistory>();
		try {
			con = DBManager.getConnection();
			String sql = "insert into browsing_history(user_id, item_id, browsing_date) values(?,?,?);";
			pst = con.prepareStatement(sql);
			pst.setInt(1, userId);
			pst.setInt(2, itemId);
			pst.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


		try {

			String sql = "select * from browsing_history where user_id = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, userId);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				BrowsingHistory bh = new BrowsingHistory();
				bh.setItemId(rs.getInt("item_id"));
				bhList.add(bh);
			}
			System.out.println(bhList.size());
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		if (bhList.size() > 10) {
			String sql = "delete from browsing_history where user_id = " + userId + " order by browsing_date limit 1";
			try {
				st = con.createStatement();
				st.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}
	}
}
