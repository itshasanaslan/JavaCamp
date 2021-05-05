import java.util.Date;

public class Campaign implements Entity{
	int id;
	String name;
	float discountRate;
	Date startDate;

	Date endDate;
	
	public Campaign() {
		
	}
	
	public Campaign(int id, String name, float discountRate) {
		super();
		this.id = id;
		this.name = name;
		this.discountRate = discountRate;
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
	public float getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(float discountRate) {
		this.discountRate = discountRate;
	}
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
