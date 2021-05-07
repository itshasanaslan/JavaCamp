package Day5Homework1.business.concretes;

import java.util.ArrayList;
import java.util.List;

import Day5Homework1.business.abstracts.MailValidationService;
import Day5Homework1.dataAccess.abstracts.MailValidationDao;
import Day5Homework1.entities.concretes.MailValidation;
import Day5Homework1.entities.concretes.ServerResponse;

public class MailValidationManager implements MailValidationService{

	MailValidationDao mailValidationDao;
	List<MailValidation> validationCodes;
	private int maxId;
	
	public MailValidationManager() {
		this.validationCodes = this.getAll();
	}
	public MailValidationManager(MailValidationDao dao) {
		this.mailValidationDao = dao;
		this.validationCodes = this.getAll();
	}
	
	@Override
	public ServerResponse add(MailValidation mailValidation) {
		System.out.println(mailValidation.getValidationCode() + "asaas");
		mailValidation.setValidationCode(this.generateCode());
		mailValidation.setId(this.mailValidationDao.getMaxId());
		this.mailValidationDao.add(mailValidation);
		this.validationCodes.add(mailValidation);
		System.out.println("Kullanıcı '" + mailValidation.getUserId() + "' için doğrulama kodu gönderildi: " + mailValidation.getValidationCode());
		ServerResponse r = new ServerResponse();
		r.setOperationSuccess(true);
		return r;
	}

	@Override
	public ServerResponse remove(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServerResponse update(MailValidation mailValidation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MailValidation get(int id) {
		//return this.mailValidationDao.get(id);
		
		for (MailValidation validation : this.validationCodes) {
			if (validation.getUserId() == id) {
				return validation;
			}
		}
		return null;
	}

	@Override
	public List<MailValidation> getAll() {
		return this.mailValidationDao.getAll();
	}

	@Override
	public String generateCode() {
		
		/*
		 String code = "";
		 
		do {
			 code  = "rastgeleBirKod";
			 
		} while(this.checkCodeExists(code));
		
		return code;
		*/
		
		 return "rastgeleBirKod" + this.maxId++;
		
	}
	
	private boolean checkCodeExists(String code) {
		//Aynı doğrulama linki/kodu veritabanında var mı
		return false;
	}
	
	public ServerResponse checkCodeIsValid(int userId, String validationCode) {
		ServerResponse response = new ServerResponse();
		for (MailValidation validation : this.validationCodes) {
			if (validation.getUserId() == userId) {
				if (validation.getValidationCode().equals(validationCode)) {
					response.setOperationSuccess(true);
					response.setMessage("Kod onaylandı. Hoşgeldiniz.");
					break;
				}
				response.setMessage("Kod hatalı.");
			
			}
		}
		
		if (response.getMessage().equals(" ")) {
			response.setMessage(validationCode);
		}
		
		return response;
	}
	
}
