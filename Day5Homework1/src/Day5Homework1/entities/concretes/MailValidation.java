package Day5Homework1.entities.concretes;

import Day5Homework1.entities.abstracts.Entity;

public class MailValidation implements Entity{
	private int id;
	private int userId;
	private String userEmail;
	private String validationCode;
	public MailValidation() {}
	
	
	public MailValidation(int id, int userId, String userEmail, String validationCode) {
		super();
		this.id = id;
		this.userId = userId;
		this.userEmail = userEmail;
		this.validationCode = validationCode;
	}
	
	public MailValidation(int id, User user) {
		this.id = id;
		this.userId = user.getId();
		this.userEmail = user.geteMail();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getValidationCode() {
		return validationCode;
	}

	public void setValidationCode(String validationCode) {
		this.validationCode = validationCode;
	}
	
	
}
