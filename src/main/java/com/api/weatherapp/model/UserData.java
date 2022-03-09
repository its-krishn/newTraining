package com.api.weatherapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserData {
	private String name;
	@Id
	private String email;
	private String mobile;
	private String city;
	private String allergicto;
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAllergicto() {
		return allergicto;
	}
	public void setAllergicto(String allergicto) {
		this.allergicto = allergicto;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserData [name=" + name + ", email=" + email + ", mobile=" + mobile + ", city=" + city + ", allergicto="
				+ allergicto + ", password=" + password + "]";
	}
	
}