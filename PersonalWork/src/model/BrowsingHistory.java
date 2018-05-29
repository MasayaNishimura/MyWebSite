package model;

import java.sql.Date;

public class BrowsingHistory {
	private int userId;
	private int itemId;
	private Date browsingDate;

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
	public Date getBrowsingDate() {
		return browsingDate;
	}
	public void setBrowsingDate(Date browsingDate) {
		this.browsingDate = browsingDate;
	}

}
