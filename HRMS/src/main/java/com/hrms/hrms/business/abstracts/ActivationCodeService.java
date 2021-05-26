package com.hrms.hrms.business.abstracts;

import java.util.List;

import com.hrms.hrms.core.utilities.DataResult;
import com.hrms.hrms.core.utilities.Result;
import com.hrms.hrms.entities.concretes.ActivationCode;
import com.hrms.hrms.entities.concretes.CodeValidation;


public interface ActivationCodeService {
	DataResult<List<ActivationCode>> getAll();
	Result add(ActivationCode activationCode);
	String generateActivationCode();
	ActivationCode findByUserId(int user_id);
	List<ActivationCode> getAllList();
	Result validateCode(CodeValidation validation, UserService userService);
}
