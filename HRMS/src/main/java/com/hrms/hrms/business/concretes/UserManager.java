package com.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.ActivationCodeService;
import com.hrms.hrms.business.abstracts.UserService;
import com.hrms.hrms.core.utilities.DataResult;
import com.hrms.hrms.core.utilities.ErrorResult;
import com.hrms.hrms.core.utilities.Result;
import com.hrms.hrms.core.utilities.SuccessDataResult;
import com.hrms.hrms.core.utilities.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.UserDao;
import com.hrms.hrms.entities.concretes.ActivationCode;
import com.hrms.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService{
	private UserDao userDao;
	private ActivationCodeService activationCodeService;
	
	
	@Autowired
	public UserManager(UserDao userDao, ActivationCodeService activationCodeService) {
		super();
		this.userDao = userDao;
		this.activationCodeService = activationCodeService;
	}

	
	@Override
	public User getUser(int id) {
		return this.userDao.getOne(id);
	}
	
	@Override
	public DataResult<List<User>> getAll() {
		// TODO Auto-generated method stu
		return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Kullanıcılar gönderildi");
	}

	@Override
	public Result add(User user) {
		System.out.println("Adding user:" + user.geteMail());
		try {
			this.userDao.save(user);
			System.out.println("Added. Generating code");
			System.out.println("user id is now:" + user.getId());
			ActivationCode activationCode = new ActivationCode(user.getId(), this.activationCodeService.generateActivationCode());
			System.out.println("Generated: " + activationCode.getCode() + "  . Saving");
			this.activationCodeService.add(activationCode);
			System.out.println("Everything is okay!");
			return new SuccessResult("Kullanıcı kaydı başarılı. " + 
			user.geteMail() + " adresine bir doğrulama kodu gönderildi. Simülasyon kod: " + 
					activationCode.getCode());
		}
		catch(DataIntegrityViolationException f) {
			return new ErrorResult("Kullanıcı daha önce kayıt olmuş. Lütfen mail kutunuzu kontrol edin.");
		}
		catch (Exception e) {
			return new ErrorResult("Çözümlenemeyen hata: " + e.getMessage());
		}
		
	}


	


	@Override
	public User getUser(String email) {
		
		for (User user: this.userDao.findAll()) {
			if (user.geteMail().equals(email)) return user;
		}
		return null;
	}


	

	

}
