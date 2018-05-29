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
import model.Buy;

public class BuyDao {
	public int insertBuy(int userId, int totalPrice) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		Statement st = null;
		int id = 0;
		try {
			con = DBManager.getConnection();
			String sql = "INSERT INTO buy(user_id,total_price,buy_date) VALUES(?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, userId);
			pst.setInt(2, totalPrice);
			pst.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			pst.executeUpdate();

			sql = "select * from buy order by id desc limit 1";
			st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (!rs.next()) {
                return 0;
            }
            id = rs.getInt("id");
            return id;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException();
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public List<Buy> buyHistory(int userId) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		List<Buy> buyList = new ArrayList<Buy>();
		try {
			con = DBManager.getConnection();
			String sql = "select * from buy where user_id = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, userId);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Buy buy = new Buy();
				buy.setId(rs.getInt("id"));
				buy.setTotalPrice(rs.getInt("total_price"));
				buy.setBuyDate(rs.getDate("buy_date"));
				buyList.add(buy);
			}
			return buyList;

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
