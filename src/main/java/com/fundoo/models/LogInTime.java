package com.fundoo.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="LogInTime")
public class LogInTime implements Serializable{
 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name="userid")
	private int id;
	
	@Column(name="loginTime")
	private Date loginTime;
	
	
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "LogInTime [loginTime=" + loginTime + ", id=" + id + "]";
	}
	
}
