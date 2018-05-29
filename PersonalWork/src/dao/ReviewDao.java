package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import model.Review;

public class ReviewDao {
	public List<Review> createReviewList(int id) {
		Connection conn = null;
        List<Review> reviewList = new ArrayList<Review>();
        try {
            conn = DBManager.getConnection();

            String sql = "SELECT * FROM review where item_id = ?;";

            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, id);
            ResultSet rs = pStmt.executeQuery();

            while(rs.next()) {
            	int reviewId = rs.getInt("id");
            	int userId = rs.getInt("user_id");
            	int itemId = rs.getInt("item_id");
            	String review = rs.getString("review");
                String star = rs.getString("star");
                Review rev = new Review(reviewId, userId, itemId, review, star);
                reviewList.add(rev);
            }

            return reviewList;

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

	public void insertReview(int userId, int itemId, String review, String star) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = DBManager.getConnection();
			String sql = "INSERT INTO review(user_id,item_id,review,star) VALUES(?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, userId);
			pst.setInt(2, itemId);
			pst.setString(3, review);
			pst.setString(4, star);
			pst.executeUpdate();

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
