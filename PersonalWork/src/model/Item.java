package model;

import java.sql.Date;

public class Item {
	private int id;
	private String name;
	private int price;
	private int overLappedNum = 0;
	private Date registerDate;

	public Item(int id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Date getRegisterDate() {
		return registerDate;
	}
	public void plusNum(int i) {
		this.overLappedNum += i;
	}
	public void minusNum() {
		this.overLappedNum--;
	}
	public int getOverLappedNum() {
		return this.overLappedNum;
	}
}
