package com.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.business.abstracts.ActivationCodeService;
import com.hrms.hrms.business.abstracts.UserService;
import com.hrms.hrms.core.utilities.DataResult;
import com.hrms.hrms.core.utilities.Result;
import com.hrms.hrms.entities.concretes.ActivationCode;
import com.hrms.hrms.entities.concretes.CodeValidation;

@RestController
@RequestMapping("/api/activation_codes")
public class ActivationCodesController {
	private ActivationCodeService activationCodeService;
	private UserService userService;

	public ActivationCodesController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public ActivationCodesController(ActivationCodeService activationCodeService
			, UserService userService) {
		super();
		this.activationCodeService = activationCodeService;
		this.userService = userService;
	}
	
	
	@GetMapping("/get_all")
	DataResult<List<ActivationCode>> getAll(){
		return this.activationCodeService.getAll();
	}
	
	@PostMapping("/add")
	Result add(@RequestBody ActivationCode activationCode) {
				
		return this.activationCodeService.add(activationCode);
	}
	
	
	@PostMapping("/validate_code")
	Result validateCode(@RequestBody CodeValidation codeValidation) {
		return this.activationCodeService.validateCode(codeValidation, this.userService);
	}
	
	
	
}
