package Day4Homework2;

import java.sql.Date;

public class Customer implements IEntity{
	int id;
	String firstName;
	String lastName;
	String nationalityId;
	Date dateOfBirth;
	
	public Customer() {
		
	}
	public Customer(int id, String first, String last, String nationalityId, Date dateOfBirth ) {
		this.id = id;
		this.firstName = first;
		this.lastName = last;
		this.nationalityId = nationalityId;
		this.dateOfBirth = dateOfBirth;
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
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getNationalityId() {
		return nationalityId;
	}
	public void setNationalityId(int nationalityId) {
		this.nationalityId = nationalityId;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	

}
