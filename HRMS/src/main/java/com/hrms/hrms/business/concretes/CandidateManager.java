package com.hrms.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.ActivationCodeService;
import com.hrms.hrms.business.abstracts.CandidateService;
import com.hrms.hrms.core.utilities.DataResult;
import com.hrms.hrms.core.utilities.ErrorDataResult;
import com.hrms.hrms.core.utilities.ErrorResult;
import com.hrms.hrms.core.utilities.Result;
import com.hrms.hrms.core.utilities.SuccessDataResult;
import com.hrms.hrms.core.utilities.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.CandidateDao;
import com.hrms.hrms.entities.concretes.ActivationCode;
import com.hrms.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{
	private CandidateDao candidateDao;
	private ActivationCodeService activationCodeService;
	
	
	public CandidateManager() {}
	
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, ActivationCodeService activationCodeService) {
		super();
		this.candidateDao = candidateDao;
		this.activationCodeService = activationCodeService;
	}



	@Override
	public DataResult<List<Candidate>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Adaylar gönderildi.");
	}

	@Override
	public Result add(Candidate candidate) {
		boolean error = false;
		List<String> errors = new ArrayList<String>();
		if (candidate.getFirstName().equals("") || candidate.getFirstName().equals(" ")) {
			error = true;
			errors.add("İsim boş olamaz!");
		}
		if (candidate.getLastName().equals("") || candidate.getLastName().equals(" ")) {
			error = true;
			errors.add("Soyisim boş olamaz!");
		}
		
		if (candidate.getNationalityNumber().equals("") || 
				candidate.getNationalityNumber().equals(" ") ||
				candidate.getNationalityNumber().length() != 11) {
			error = true;
			errors.add("T.C. no 11 haneden oluşuyor!");
		}
		
		if (candidate.getDateOfBirth() == null) {
			error = true;
			errors.add("Doğum tarihi boş olamaz!");
		}
		
		
		ActivationCode activationCode = this.activationCodeService.findByUserId(candidate.getUser_id());
		if (activationCode == null) {
			return new ErrorResult("Kullanıcı bulunamadı");
		}
		
		
		if (!activationCode.isValidated()) {
			error = true;
			errors.add("Öncelikle mail doğrulaması yapmanız gerekiyor.");
		}
		
		if (error) {
			return new ErrorDataResult<List<String>>(errors, "Hata");
		}
		
		
		
		
		
		try {
			this.candidateDao.save(candidate);
			return new SuccessResult("Aday eklendi.");
		}
		catch(DataIntegrityViolationException f) {
			return new ErrorResult("Kullanıcı bulunamadı veya halihazırda ekli.");
		}
		
		catch (Exception e) {
			return new ErrorResult(e.getMessage());
		}
		
	}
	
	
}
