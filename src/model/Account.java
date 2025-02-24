/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

public class Account {

	private String fullName;
	private String user;
	private String password;
	private int status;
	private String email;
	private int sex;

	public Account() {
		super();
	}

	public Account(String user, String password, String fullName, String email, int sex, int status) {
		super();
		this.fullName = fullName;
		this.user = user;
		this.password = password;
		this.sex = sex;
		this.status = status;
		this.email = email;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Account [fullName=" + fullName + ", user=" + user + ", password=" + password + ", status=" + status
				+ ", email=" + email + ", sex=" + sex + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, fullName, password, sex, status, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(email, other.email) && Objects.equals(fullName, other.fullName)
				&& Objects.equals(password, other.password) && sex == other.sex && status == other.status
				&& Objects.equals(user, other.user);
	}

}
