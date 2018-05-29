package model;

public class Review {
	private int id;
	private int userId;
	private int itemId;
	private String review;
	private String star;

	public Review(int id, int userId, int itemId, String review, String star) {
		this.id = id;
		this.userId = userId;
		this.itemId = itemId;
		this.review = review;
		this.star = star;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}


}
