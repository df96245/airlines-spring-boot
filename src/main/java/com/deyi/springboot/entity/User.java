package com.deyi.springboot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="user")
public class User {
	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@Column(name="user_id",unique = true, nullable = false)
	private long id;
	
	@Column(unique=true,nullable=false)
	private String userName;
	
	@Column(unique=true,nullable=false)
	private String passWord;
	
	private String address;
	
	private int age;
	
	private long phoneNumber;
	
	private String customer;
	
	private String citizenIdNum;
	
	private String sex;
	
	private Date birthday;
	
	private String province;
	
	private String city;
	
	private String email;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getCitizenIdNum() {
		return citizenIdNum;
	}

	public void setCitizenIdNum(String citizenIdNum) {
		this.citizenIdNum = citizenIdNum;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", address=" + address
				+ ", age=" + age + ", phoneNumber=" + phoneNumber + ", customer=" + customer + ", citizenIdNum="
				+ citizenIdNum + ", sex=" + sex + ", birthday=" + birthday + ", province=" + province + ", city=" + city
				+ ", email=" + email + "]";
	}
	
	
	
}
