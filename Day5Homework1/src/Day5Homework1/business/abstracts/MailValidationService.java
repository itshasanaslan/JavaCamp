package Day5Homework1.business.abstracts;

import java.util.List;

import Day5Homework1.entities.concretes.MailValidation;
import Day5Homework1.entities.concretes.ServerResponse;

public interface MailValidationService {
	ServerResponse add(MailValidation mailValidation);
	ServerResponse remove(int id);
	ServerResponse update(MailValidation mailValidation);
	MailValidation get(int id);
	List<MailValidation> getAll();
	String generateCode();
	public ServerResponse checkCodeIsValid(int userId, String validationCode);

}
