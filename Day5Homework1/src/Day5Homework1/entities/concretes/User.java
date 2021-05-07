package Day5Homework1.entities.concretes;

import Day5Homework1.entities.abstracts.Entity;

public class User implements Entity{
	int id;
	private String name;
	private String lastName;
	private String eMail;
	private String pasword;
	private int birthYear;
	private boolean codeSent;
	private boolean verified;
	public User() {
		super();
	}

	public User(int id, String name, String lastName, String eMail, String pasword, int birthYear) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.eMail = eMail;
		this.pasword = pasword;
		this.birthYear = birthYear;
		this.codeSent = false;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPasword() {
		return pasword;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public boolean getCodeSent() {
		return codeSent;
	}

	public void setCodeSent(boolean codeSent) {
		this.codeSent = codeSent;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	

}
