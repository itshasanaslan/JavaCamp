package com.hrms.hrms.business.abstracts;

import java.util.List;



import com.hrms.hrms.core.utilities.DataResult;
import com.hrms.hrms.core.utilities.Result;
import com.hrms.hrms.entities.concretes.User;

public interface UserService {
	DataResult<List<User>> getAll();
	Result add(User user);
	User getUser(int id);
	
	User findByeMail(String eMail);
	
	
	
}
