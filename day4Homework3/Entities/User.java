

public class User implements Entity{
	int id;
	String nationalityId;
	String name;
	String lastName;
	int birthDate;
	
	public User(int id, String nationalityId, String name, String lastName, int birthDate) {
		super();
		this.id = id;
		this.nationalityId = nationalityId;
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNationalityId() {
		return nationalityId;
	}
	public void setNationalityId(String nationalityId) {
		this.nationalityId = nationalityId;
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
	public int getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(int birthDate) {
		this.birthDate = birthDate;
	}
	
	
}
