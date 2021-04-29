package Day3;

public class UserManager implements IUserManager{


	@Override
	public void add(User user) {
		System.out.println("Kullanıcı eklendi: " + user.getFullName());
		
	}

	@Override
	public void delete(User user) {
		System.out.println("Kullanıcı silindi: " + user.getFullName());
		
	}

	@Override
	public void update(User user) {
		System.out.println("Kullanıcı güncellendi: " + user.getFullName());
		
	}

}
