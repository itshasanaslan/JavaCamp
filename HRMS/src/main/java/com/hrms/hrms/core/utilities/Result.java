package com.hrms.hrms.core.utilities;

public class Result {
	private boolean success;
	private String message;
	
	public Result() {}
	public Result(boolean success) {
		this.success = success;
	}
	
	public Result(boolean success, String message) {
		this(success); //kendi constructorı.
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public String getMessage() {
		return message;
	}
	
	
	
}
