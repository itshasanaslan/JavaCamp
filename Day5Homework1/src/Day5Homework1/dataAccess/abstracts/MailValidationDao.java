package Day5Homework1.dataAccess.abstracts;

import Day5Homework1.entities.concretes.MailValidation;
import Day5Homework1.entities.concretes.ServerResponse;
import java.util.List;

public interface MailValidationDao {
	ServerResponse add(MailValidation mailValidation);
	ServerResponse remove(int id);
	ServerResponse update(MailValidation mailValidation);
	MailValidation get(int id);
	List<MailValidation> getAll();
	int getMaxId();
}
