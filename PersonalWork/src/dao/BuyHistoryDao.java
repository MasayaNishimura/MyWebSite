package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import model.BuyHistory;

public class BuyHistoryDao {
	public List<BuyHistory> showBuyHistoryDetail(int buyId) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		List<BuyHistory> buyHistoryList = new ArrayList<BuyHistory>();
		try {
			con = DBManager.getConnection();
			String sql = "select distinct item_id, buy_num, name, price, total_price from buy_detail " +
					"inner join item on buy_detail.item_id = item.id " +
					"inner join buy on buy_detail.buy_id = buy.id " +
					"where buy_detail.buy_id = ? " +
					"order by item_id asc;";
			pst = con.prepareStatement(sql);
			pst.setInt(1, buyId);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int itemId = rs.getInt("item_id");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				int totalPrice = rs.getInt("total_price");
				int buyNum = rs.getInt("buy_num");
				BuyHistory bh = new BuyHistory(itemId,name,price,totalPrice,buyNum);
				buyHistoryList.add(bh);
			}

			return buyHistoryList;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}
}
