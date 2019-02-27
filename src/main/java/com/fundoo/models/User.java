package com.fundoo.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;




@Entity
@Table(name="User")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name="Id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="First_Name")
	private String firstName;
	@Column(name="Middle_Name")
	private String middleName;
	@Column(name="Last_Name")
	private String lastName;
	@Column(name="Date_Of_Birth")
	private String dateOfBirth;
	@Column(name="Gender")
	private String gender;
	@Column(name="Country")
	private String country;
	@Column(name="Phone")
	private String phone;
	@Column(name="Phone_Ext")
	private String phoneExt;
	@Column(name="Email_Id")
	private String emailId;
	@Column(name="Address")
	private String address;
	@Column(name="Username")
	private String userName;
	@Column(name="Password")
	private String password;
	@Column(name="Status")
	private String status;
	@Column(name="role")
	private String role;
	
	@Column(name="createdStamp")
	@DateTimeFormat(style = "dd-MM-yyy HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern ="dd-MM-yyyy HH:mm:ss")
	private Date createdStamp;
	
	@Column(name="lastloginStamp")
	@DateTimeFormat(style = "dd-MM-yyy HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern ="dd-MM-yyyy HH:mm:ss")
	private Date lastloginStamp;
	
	@Column(name="lastupdStamp")
	@DateTimeFormat(style = "dd-MM-yyy HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern ="dd-MM-yyyy HH:mm:ss")
	private Date lastupdStamp;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhoneExt() {
		return phoneExt;
	}
	public void setPhoneExt(String phoneExt) {
		this.phoneExt = phoneExt;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Date getCreatedStamp() {
		return createdStamp;
	}
	public void setCreatedStamp(Date createdStamp) {
		this.createdStamp = createdStamp;
	}
	public Date getLastloginStamp() {
		return lastloginStamp;
	}
	public void setLastloginStamp(Date lastloginStamp) {
		this.lastloginStamp = lastloginStamp;
	}
	public Date getLastupdStamp() {
		return lastupdStamp;
	}
	public void setLastupdStamp(Date lastupdStamp) {
		this.lastupdStamp = lastupdStamp;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", country=" + country + ", phone=" + phone
				+ ", phoneExt=" + phoneExt + ", emailId=" + emailId + ", address=" + address + ", userName=" + userName
				+ ", password=" + password + ", status=" + status + ", role=" + role + ", createdStamp=" + createdStamp
				+ ", lastloginStamp=" + lastloginStamp + ", lastupdStamp=" + lastupdStamp + "]";
	}
	
	
}

