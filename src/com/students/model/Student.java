package com.students.model;

public class Student {
	private String userName;
	private String email;

	public Student() {
		super();
	}

	
	public Student(String userName, String email) {
		super();
		this.userName = userName;
		this.email = email;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
