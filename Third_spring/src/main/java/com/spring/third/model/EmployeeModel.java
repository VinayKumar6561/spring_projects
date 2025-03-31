package com.spring.third.model;

public class EmployeeModel {
	
	 private int id;
	 private String ename;
     private String role;
		 
	 public EmployeeModel(int id, String ename, String role) {
		super();
		this.id = id;
		this.ename = ename;
		this.role = role;
	}

	 public int getId() {
		return id;
	} 
	public void setId(int id) {
		this.id = id;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
