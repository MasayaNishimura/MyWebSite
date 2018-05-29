package model;

public class BuyHistory {
	private int itemId;
	private String name;
	private int price;
	private int totalPrice;
	private int overlappedNum;

	public BuyHistory(int itemId, String name, int price, int totalPrice, int overlappedNum) {
		this.itemId = itemId;
		this.name = name;
		this.price = price;
		this.totalPrice = totalPrice;
		this.overlappedNum = overlappedNum;
	}

	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getOverlappedNum() {
		return overlappedNum;
	}
	public void setOverlappedNum(int overlappedNum) {
		this.overlappedNum = overlappedNum;
	}
}
