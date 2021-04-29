package Day3;

public class StudentManager implements IUserManager{

	@Override
	public void add(User user) {
		System.out.println("Öğrenci eklendi: " + user.getFullName());
		
	}

	@Override
	public void delete(User user) {
		System.out.println("Öğrenci silindi: " + user.getFullName());
		
	}

	@Override
	public void update(User user) {
		System.out.println("Öğrenci güncellendi: " + user.getFullName());
		
	}
	

}
