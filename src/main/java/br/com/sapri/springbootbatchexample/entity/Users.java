package br.com.sapri.springbootbatchexample.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {

	@Id
	private Long userId;
	
	private String name;
	
	private String dept;
	
	private BigDecimal account;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public BigDecimal getAccount() {
		return account;
	}

	public void setAccount(BigDecimal account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", name=" + name + ", dept=" + dept + ", account=" + account + "]";
	}
	
}
