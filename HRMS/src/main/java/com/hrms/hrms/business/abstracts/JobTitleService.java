package com.hrms.hrms.business.abstracts;

import java.util.List;

import com.hrms.hrms.core.utilities.DataResult;
import com.hrms.hrms.core.utilities.Result;
import com.hrms.hrms.entities.concretes.JobTitle;

public interface JobTitleService {

	DataResult<List<JobTitle>> getAll();
	Result add(JobTitle jobTitle);
	
}
