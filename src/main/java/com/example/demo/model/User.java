package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_tbl")
public class User{
@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
private int id;
private String name;
private String email;
private String password;
private String mobileno;
private String city;



public User() {
	super();
	// TODO Auto-generated constructor stub
}



public User(int id, String name, String email, String pass, String mobileno, String city) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.password = password;
	this.mobileno = mobileno;
	this.city = city;
}

public User( String email, String pass) {
	super();
	
	this.email = email;
	this.password= password;
	
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

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getMobileno() {
	return mobileno;
}

public void setMobileno(String mobileno) {
	this.mobileno = mobileno;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}



@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", mobileno=" + mobileno
			+ ", city=" + city + "]";
}

private String role;



public String getRole() {
	return role;
}



public void setRole(String role) {
	this.role = role;
}


}

