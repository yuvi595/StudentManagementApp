package com.model;

import java.sql.Date;

public class Student {
	
	private int id;
	private String name;
	private String DOB;
	private String phone;
	private String email;
	private String address;
	private String dept;
	private String passout;
	private int creatorid;
	private Date creatorat;
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
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getPassout() {
		return passout;
	}
	public void setPassout(String passout) {
		this.passout = passout;
	}
	public int getCreatorid() {
		return creatorid;
	}
	public void setCreatorid(int creatorid) {
		this.creatorid = creatorid;
	}
	public Date getCreatorat() {
		return creatorat;
	}
	public void setCreatorat(Date creatorat) {
		this.creatorat = creatorat;
	}

}
