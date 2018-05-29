package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import base.DBManager;
import model.Item;

public class ItemDao {
	public List<Item> createItemList() {
        Connection conn = null;
        List<Item> itemList = new ArrayList<Item>();
        try {
            conn = DBManager.getConnection();

            String sql = "SELECT * FROM item;";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {
            	int id = rs.getInt("id");
            	String name = rs.getString("name");
                int price = rs.getInt("price");
                Item item = new Item(id, name, price);
                itemList.add(item);
            }


            return itemList;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }

	public List<Item> randomItemList() {
		List<Item> itemList = this.createItemList();
		if (itemList.size() < 4) {
			return itemList;
		} else {
			Collections.shuffle(itemList);
			for (int i = itemList.size() - 1; i >= 4; i--) {
				itemList.remove(i);
			}
			return itemList;
		}
	}

	public Item findItemById(int id) {
		Connection conn = null;
        try {
            conn = DBManager.getConnection();

            String sql = "SELECT * FROM item where id = ?;";

            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, id);
            ResultSet rs = pStmt.executeQuery();

            if (!rs.next()) {
                return null;
            }

            String name = rs.getString("name");
            int price = rs.getInt("price");
            return new Item(id, name, price);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }

	public List<Item> referItemList(int sPrice, int ePrice, String word) {
        Connection conn = null;
        List<Item> itemList = new ArrayList<Item>();
        try {
            conn = DBManager.getConnection();

            String sql = "SELECT * FROM item where id >= 1";

            if (sPrice > 0) {
            	sql += " and price >= " + sPrice;
            }
            if (ePrice > 0) {
            	sql += " and price <= " + ePrice;
            }
            if (!word.equals("")) {
            	sql += " and name like '%" + word + "%'";
            }

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {
            	int id = rs.getInt("id");
            	String name = rs.getString("name");
                int price = rs.getInt("price");
                Item item = new Item(id, name, price);
                itemList.add(item);
            }


            return itemList;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }
}
