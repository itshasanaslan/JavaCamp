package com.hrms.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.ActivationCodeService;
import com.hrms.hrms.business.abstracts.EmployerService;
import com.hrms.hrms.core.utilities.DataResult;
import com.hrms.hrms.core.utilities.ErrorDataResult;
import com.hrms.hrms.core.utilities.ErrorResult;
import com.hrms.hrms.core.utilities.Result;
import com.hrms.hrms.core.utilities.SuccessDataResult;
import com.hrms.hrms.core.utilities.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.EmployerDao;
import com.hrms.hrms.entities.concretes.ActivationCode;
import com.hrms.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	private EmployerDao dao;
	
	@Autowired
	public EmployerManager(EmployerDao dao) {
		super();
		this.dao = dao;
	}

	public EmployerManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.dao.findAll(), "İşverenler gönderildi.");
	}

	@Override
	public Result add(Employer employer, ActivationCodeService activationCodeService) {
		
		boolean error = false;
		List<String> errors = new ArrayList<String>();
		
		if(employer.getCompanyName().equals(" ") || employer.getCompanyName().equals("")) {
			errors.add("Şirket adı boş olamaz!");
			error = true;
		}
		if(employer.getWebAddress().equals(" ") || employer.getWebAddress().equals("")) {
			errors.add("Şirket web adresi boş olamaz!");
			error = true;
		}if(employer.getPhoneNumber().equals(" ") || employer.getPhoneNumber().equals("")) {
			errors.add("Telefon numarası boş olamaz!");
			error = true;
		}
		
		if (error) {
			return new ErrorDataResult<List<String>>(errors, "Hata");
		}
		
		
		ActivationCode code = activationCodeService.findByUserId(employer.getUser_id());
		if (code == null) {
			return new ErrorResult("Kullanıcı bulunamadı");
		}
		
		if (!code.isValidated()) {
			return new ErrorResult("Öncelikle mail doğrulaması yapmanız gerekiyor.");
		}
		
		
		try {
			this.dao.save(employer);
			
			return new SuccessResult("İşveren eklendi.");
		}
		catch(Exception f) {
			return new ErrorResult(f.getMessage());
		}
	}

}
