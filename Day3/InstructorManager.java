package Day3;

public class InstructorManager implements IUserManager{

	@Override
	public void add(User user) {
		System.out.println("Hoca eklendi: " + user.getFullName());
		
	}

	@Override
	public void delete(User user) {
		System.out.println("Hoca silindi: " + user.getFullName());
		
	}

	@Override
	public void update(User user) {
		System.out.println("Hoca güncellendi: " + user.getFullName());
		
	}
	
	
	

}
