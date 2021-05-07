package Day5Homework1.dataAccess.concretes;

import java.util.List;

import Day5Homework1.dataAccess.abstracts.UserDao;
import Day5Homework1.entities.concretes.User;

public class GoogleDao implements UserDao{

	@Override
	public void add(User user) {
		System.out.println("Google ile kayıt olundu.");
		
	}

	@Override
	public void remove(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User search(String eMail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
