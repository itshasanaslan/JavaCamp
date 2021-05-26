package com.hrms.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.business.abstracts.UserService;
import com.hrms.hrms.core.utilities.DataResult;
import com.hrms.hrms.core.utilities.Result;
import com.hrms.hrms.entities.concretes.User;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	private UserService userService;
	
	public UsersController() {}

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/get_all")
	DataResult<List<User>> getAll(){
		return this.userService.getAll();
	}
	
	@PostMapping("/add")
	Result add(@RequestBody User user) {
		return this.userService.add(user);
	}
	
	@PostMapping("/find_email")
	User findEmail(@RequestBody String eMail) {
		return this.userService.findByeMail(eMail);
	}
	
	
	
	
}
