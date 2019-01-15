package com.Tripodo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Email implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "token")
	private String token;
	
	@Column(name = "email")
	private String Email;
	
	@Column(name = "expirationdate")
	private Long expirationdate;

	public Long getExpirationdate() {
		return expirationdate;
	}

	public void setExpirationdate(Long expirationdate) {
		this.expirationdate = expirationdate;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}



}
