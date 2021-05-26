package com.hrms.hrms.entities.concretes;

public class CodeValidation {
	private String email;
	private String code;
	public CodeValidation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CodeValidation(String email, String code) {
		super();
		this.email = email;
		this.code = code;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	

}
