package com.hrms.hrms.business.concretes;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.ActivationCodeService;
import com.hrms.hrms.business.abstracts.UserService;
import com.hrms.hrms.core.utilities.DataResult;
import com.hrms.hrms.core.utilities.ErrorResult;
import com.hrms.hrms.core.utilities.Result;
import com.hrms.hrms.core.utilities.SuccessDataResult;
import com.hrms.hrms.core.utilities.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.ActivationCodeDao;
import com.hrms.hrms.entities.concretes.ActivationCode;
import com.hrms.hrms.entities.concretes.CodeValidation;
import com.hrms.hrms.entities.concretes.User;

@Service
public class ActivationCodeManager implements ActivationCodeService {

	private ActivationCodeDao activationCodeDao;
	
	
	
	@Autowired
	public ActivationCodeManager(ActivationCodeDao activationCodeDao) {
		super();
		this.activationCodeDao = activationCodeDao;
	}
	
	

	public ActivationCodeManager() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public DataResult<List<ActivationCode>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<ActivationCode>>(this.activationCodeDao.findAll(), "Aktivasyon kodları döndürüldü.");
	}

	@Override
	public Result add(ActivationCode activationCode) {
		this.activationCodeDao.save(activationCode);
		return new SuccessResult("Aktivasyon kodu kaydedildi.");
	}



	@Override
	public String generateActivationCode() {
		String letters = "ABCDEFGHIJKLMNOPRSTUVYZQWX0123456789";
		int letters_range = letters.length();
		char[] code = new char[8];
		Random r = new Random();
		for (int i = 0; i < 8; i++) {
			int random_index = r.nextInt(letters_range);
			code[i] = letters.charAt(random_index);
		}
		return String.valueOf(code);
	}



	@Override
	public ActivationCode findByUserId(int user_id) {
		return this.activationCodeDao.findByuserId(user_id);
	}



	@Override
	public List<ActivationCode> getAllList() {
		return this.activationCodeDao.findAll();
	}
	
	@Override
	public Result validateCode(CodeValidation codeValidation, UserService userService) {
		User user = userService.findByeMail(codeValidation.getEmail());

		if (user == null) return new ErrorResult("Kullanıcı bulunamadı");
		ActivationCode code = this.findByUserId(user.getId());
		if (code == null) return new ErrorResult("Doğrulama kodu bulunamadı.");
				
		
	
		if (code.getCode().equals(codeValidation.getCode())) {
			//System.out.println("Doğrulama kodu eşleşti.");
			code.setValidated(true);
			try {
				this.activationCodeDao.save(code);
				return new SuccessResult("Başarıyla doğrulandı");
			}
			catch (Exception e) {
				return new ErrorResult(e.getMessage());
			}
		
		}
		else {
			return new ErrorResult("Doğrulama kodu hatalı.");
		}
	
		
	
}
}
