package Day5Homework1.business.abstracts;

import java.util.List;

import Day5Homework1.entities.concretes.ServerResponse;
import Day5Homework1.entities.concretes.User;

public interface UserService {
	ServerResponse add(User user, String validationCode);
	ServerResponse delete(User user);
	ServerResponse update(User user);
	User search(int id);
	List<User> getAll();
	ServerResponse logIn(String mail, String password);
}
