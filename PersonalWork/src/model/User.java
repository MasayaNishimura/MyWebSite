package model;

import java.sql.Date;

/**
 * Userテーブルのデータを格納するためのBeans
 * @author takano
 *
 */
public class User {
	private int id;
	private String loginId;
	private String name;
	private Date birthDate;
	private String password;
	private Date createDate;
	private Date updateDate;

	// ログインセッションを保存するためのコンストラクタ
	public User(String loginId, String name) {
		this.loginId = loginId;
		this.name = name;
	}

	// 全てのデータをセットするコンストラクタ
	public User(int id, String loginId, String name, Date birthDate, String password, Date createDate,
			Date updateDate) {
		this.id = id;
		this.loginId = loginId;
		this.name = name;
		this.birthDate = birthDate;
		this.password = password;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
