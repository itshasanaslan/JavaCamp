package Day5Homework1;

import Day5Homework1.business.abstracts.MailValidationService;
import Day5Homework1.business.concretes.MailValidationManager;
import Day5Homework1.business.concretes.UserManager;
import Day5Homework1.dataAccess.abstracts.MailValidationDao;
import Day5Homework1.dataAccess.abstracts.UserDao;
import Day5Homework1.dataAccess.concretes.AbcUserDao;
import Day5Homework1.dataAccess.concretes.GoogleDao;
import Day5Homework1.dataAccess.concretes.MyMailValidation;
import Day5Homework1.entities.concretes.ServerResponse;
import Day5Homework1.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		MailValidationDao mailValidationDao = new MyMailValidation();
		MailValidationService mailValidationService = new MailValidationManager(mailValidationDao);
		UserDao userDao = new AbcUserDao();
		
		// okey
		User user1 = new User(1, "Hasan", "Aslan", "aslanhassan98@gmail.com", "123162",1998); // ok
		User user2 = new User(2, "S", "Polatlı", "seda@gmail.com", "123162",1998); // ad soyad hata
		User user3 = new User(3, "Yavuz", "Çetin", "yavuz@gmail.com", "1231",1998); // parola eksik
		User user4 = new User(4, "Engin", "Demir", "aslanhassan98@gmail.com", "123162",1998); // e posta kullanımda
		User user5 = new User(5, "Ayşe", "Çokgülen", "aslanhassan98@gmail.com", "123162",1998); // mail format hatası
		User user6 = new User(6, "Seda", "Güler", "sedagulergmail.com", "123162",1998);
		User user7 = new User(7, "Ceren", "Kara", "cerenkara@gmail.com", "123162",1998);
		
		String[] codes = {"rastgeleBirKod1", "rastgeleBirKod2", "rastgeleBirKod3", 
				"rastgeleBirKod4", "rastgeleBirKod5", "rastgeleBirKod6", "rastgeleBirsKod7"};
		
		User[] users = {user1, user2, user3, user4, user5, user6, user7};
		UserManager userManager = new UserManager(userDao, mailValidationService);
		
		int operationId = 0;
		
		for (User user : users) {
			System.out.println("Operation " + operationId++);
			ServerResponse response = userManager.add(user, "");
			System.out.print(user.getId() + ")" + user.getName() + " " + user.getLastName() + ":");
		
			System.out.print(response.getMessage());
			System.out.println("\n");
		}
		System.out.println("*************************************");
		System.out.println("Kod doğrulamalarına geçiliyor.");
		System.out.println("*************************************");
		operationId = 0;
		for (int i = 0; i < codes.length; i++) {
			System.out.println("Operation " + operationId++);
			ServerResponse response = userManager.add(users[i], codes[i]);
			System.out.print(users[i].getId() + ")" + users[i].getName() + " " + users[i].getLastName() + ":");
		
			System.out.print(response.getMessage());
			System.out.println("\n");
		}
		
		
		ServerResponse response = userManager.logIn("aslanhassan98@gmail.com", "123162");
		
		System.out.println(response.getMessage());
		
		
		userManager.setUserDao(new GoogleDao());
		userManager.add(user7,  "rastgeleBirKod7");
		
		
		
	}

}
