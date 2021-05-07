package Day5Homework1.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Day5Homework1.business.abstracts.MailValidationService;
import Day5Homework1.business.abstracts.UserService;
import Day5Homework1.dataAccess.abstracts.UserDao;
import Day5Homework1.entities.concretes.MailValidation;
import Day5Homework1.entities.concretes.ServerResponse;
import Day5Homework1.entities.concretes.User;

public class UserManager implements UserService{
	private UserDao userDao;
	private MailValidationService mailValidationService;
	public static Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	public UserManager() {
		
	}
	
	
	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	public UserManager(UserDao userDao, MailValidationService mailValidationService) {
		super();
		this.userDao = userDao;
		this.mailValidationService = mailValidationService;
	}

	@Override
	public ServerResponse add(User user, String validationCode) {
		ServerResponse response = new ServerResponse();
		
		
		if (user.getName().length() < 2 || user.getLastName().length() < 2) {
			response.setMessage("Hata: Ad, soyad en az iki karakterden oluşmalıdır.");
			return response;
		}
		
		if (user.getPasword().length() < 6) {
			response.setMessage("Hata: Kullanıcı parolası en az 6 karakterden oluşmalıdır.");
			return response;
		}
		
		if (!this.eMailCanBeUsed(user.geteMail())) {
			response.setMessage("Hata: E-posta kullanımda : " + user.geteMail());
			return response;
		}
		
		if (!this.validateMailFormat(user.geteMail())) {
			response.setMessage("Hata: Mail formatı hatalı : " + user.geteMail());
			return response;
		}
		
		
		
		
		if (user.getCodeSent()) {
			MailValidation validationCode1 = this.mailValidationService.get(user.getId());
			ServerResponse validationResponse = this.mailValidationService.checkCodeIsValid(user.getId(), validationCode);
			
			if (validationResponse.isOperationSuccess()) {
				this.mailValidationService.remove(validationCode1.getId());
				response.setOperationSuccess(true);
				response.setMessage(validationResponse.getMessage() + " : " +user.getId());
				user.setVerified(true);
				this.userDao.add(user);
				return response;
			}
			return validationResponse;
		}else {
			MailValidation validationCode1 = new MailValidation();
			validationCode1.setUserId(user.getId());
			validationCode1.setUserEmail(user.geteMail());
			ServerResponse addResponse =
			this.mailValidationService.add(validationCode1);
			if (addResponse.isOperationSuccess()) {
				user.setCodeSent(true);
			}
			response.setMessage(addResponse.getMessage());
			return response;
		}
	}

	@Override
	public ServerResponse delete(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServerResponse update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User search(int id) {
		return this.userDao.get(id);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private boolean eMailCanBeUsed(String eMail) {
		return true;
	}
	
	private boolean validateMailFormat(String emailAddress) {
        Matcher matcher = UserManager.VALID_EMAIL_ADDRESS_REGEX.matcher(emailAddress);
        return matcher.find();
}

	@Override
	public ServerResponse logIn(String mail, String password) {
		ServerResponse response = new ServerResponse();
		User user = this.userDao.search(mail);
		if (user == null) {
			response.setMessage("Kullanıcı bulunamadı.");
			return response;
		}
		
		if (!user.isVerified()) {
			response.setMessage("Kullanıcı henüz onaylanmamış.");
			return response;

		}
		
		if (user.getPasword().equals(password)) {
			response.setMessage("Kullanıcı girişi başarılı.");
			response.setOperationSuccess(true);
		} else {
			response.setMessage("Kullanıcı parolası hatalı.");

		}
		return response;
	}
}
