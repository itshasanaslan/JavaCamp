package com.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.business.abstracts.ActivationCodeService;
import com.hrms.hrms.business.abstracts.EmployerService;
import com.hrms.hrms.core.utilities.DataResult;
import com.hrms.hrms.core.utilities.Result;
import com.hrms.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {
	private EmployerService employersService;
	private ActivationCodeService activationCodeService;

	@Autowired
	public EmployersController(EmployerService employersService, ActivationCodeService activationCodeService) {
		super();
		this.employersService = employersService;
		this.activationCodeService = activationCodeService;
	}

	public EmployersController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@GetMapping("/getall")
	DataResult<List<Employer>> getAll(){
		return this.employersService.getAll();
	}
	
	@PostMapping("/add")
	Result add(@RequestBody Employer employer) {
		return this.employersService.add(employer, this.activationCodeService );
	}
	
}