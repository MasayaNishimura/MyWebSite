package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import base.DBManager;
import model.Item;

public class BuyDetailDao {
	public void insertBuyDetail(int userId, int buyId, List<Item> itemList) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			for (Item item : itemList) {
				for (int i = 0; i < item.getOverLappedNum(); i++) {
					String sql = "INSERT INTO buy_detail(user_id, buy_id, item_id, buy_num) VALUES(?,?,?,?)";
					st = con.prepareStatement(sql);
					st.setInt(1, userId);
					st.setInt(2, buyId);
					st.setInt(3, item.getId());
					st.setInt(4, item.getOverLappedNum());
					st.executeUpdate();
				}
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException();
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

}
