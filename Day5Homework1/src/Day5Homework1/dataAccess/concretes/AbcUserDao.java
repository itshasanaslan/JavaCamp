package Day5Homework1.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import Day5Homework1.dataAccess.abstracts.UserDao;
import Day5Homework1.entities.concretes.User;

public class AbcUserDao implements UserDao{
	List<User> users;
	
	public AbcUserDao() {
		this.users = new ArrayList<User>();
	}

	
	
	@Override
	public void add(User user) {
		System.out.println("Abc ile eklendi: " + user.getName());
		this.users.add(user);
	
		
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
		for (User user : this.users) {
			if (user.geteMail().equals(eMail)) {
				return user;
			}
		}
		
		return null;
		
	}

	@Override
	public User get(int id) {
		
		for (User user : this.users) {
			if (user.getId() == id) {
				return user;
			}
		}
		
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
