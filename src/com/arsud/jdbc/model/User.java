package com.arsud.jdbc.model;

public class User implements IModel {

	private int id;
	private String userid;
	private String userpw;
	private String nickname;

	public User() {

	}

	public User(int id, String userid, String userpw, String nickname) {
		super();
		this.id = id;
		this.userid = userid;
		this.userpw = userpw;
		this.nickname = nickname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public Object[] toArray() {
		return new Object[] { id, userid, userpw, nickname };
	}

}
