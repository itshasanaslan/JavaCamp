package Day5Homework1.dataAccess.abstracts;

import java.util.List;

import Day5Homework1.entities.concretes.User;

public interface UserDao {
	void add(User user);
	void remove(User user);
	void update(User user);
	User search(String eMail);
	User get(int id);
	List<User> getAll();
	
}
