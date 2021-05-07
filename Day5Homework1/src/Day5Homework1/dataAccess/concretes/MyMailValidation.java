package Day5Homework1.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import Day5Homework1.dataAccess.abstracts.MailValidationDao;
import Day5Homework1.entities.concretes.MailValidation;
import Day5Homework1.entities.concretes.ServerResponse;
import Day5Homework1.entities.concretes.User;

public class MyMailValidation implements MailValidationDao{

	private int maxId = 0;
	
	public MyMailValidation() {}
	
	@Override
	public ServerResponse add(MailValidation mailValidation) {
		this.maxId++;
		return new ServerResponse();
	}

	@Override
	public ServerResponse remove(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServerResponse update(MailValidation mailValidation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MailValidation get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MailValidation> getAll() {
		// TODO Auto-generated method stub
		List<MailValidation> validations = new ArrayList<MailValidation>();
		
		validations.add(new MailValidation(1, 1, "aslanhassan98@gmail.com", "rastgeleBirKod1"));
		validations.add(new MailValidation(2, 2, "seda@gmail.com", "rastgeleBirKod2"));
		validations.add(new MailValidation(3, 3, "yavuz@gmail.com", "rastgeleBirKod3"));
		validations.add(new MailValidation(4, 4, "aslanhassan98@gmail.com", "rastgeleBirKod4"));
		validations.add(new MailValidation(5, 5, "aslanhassan98@gmail.com", "rastgeleBirKod5"));
		validations.add(new MailValidation(6, 6, "sedagulergmail.com", "rastgeleBirKod6"));
		validations.add(new MailValidation(7, 7, "cerenkara@gmail.com", "rastgeleBirKod7"));
	

		return validations;
	}

	public int getMaxId() {
		return maxId;
	}

	public void setMaxId(int maxId) {
		this.maxId = maxId;
	}

}
