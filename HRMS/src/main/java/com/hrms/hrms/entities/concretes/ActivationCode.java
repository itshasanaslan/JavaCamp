package com.hrms.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "activation_codes")
public class ActivationCode {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "is_validated")
	private boolean isValidated;

	public ActivationCode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ActivationCode(int id, int user_id, String code, boolean isValidated) {
		super();
		this.id = id;
		this.userId = user_id;
		this.code = code;
		this.isValidated = isValidated;
		
	}
	
	public ActivationCode(int user_id, String code) {
		this.userId = user_id;
		this.code = code;
		
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return userId;
	}

	public void setUser_id(int user_id) {
		this.userId = user_id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isValidated() {
		return isValidated;
	}

	public void setValidated(boolean isValidated) {
		this.isValidated = isValidated;
	}

	
	
	
	
	

}
