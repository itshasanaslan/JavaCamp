package com.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.JobTitleService;
import com.hrms.hrms.core.utilities.DataResult;
import com.hrms.hrms.core.utilities.Result;
import com.hrms.hrms.core.utilities.SuccessDataResult;
import com.hrms.hrms.core.utilities.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.JobTitleDao;
import com.hrms.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{

	private JobTitleDao jobTitleDao;
	
	public JobTitleManager() {
		super();
	}
	
	@Autowired
	public JobTitleManager(JobTitleDao dao) {
		super();
		this.jobTitleDao = dao;
	}


	@Override
	public DataResult<List<JobTitle>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(), "İş isimleri döndürüldü");
	}

	@Override
	public Result add(JobTitle jobTitle) {
		this.jobTitleDao.save(jobTitle);
		return new SuccessResult("İş pozisyonu başarıyla kaydedildi.");
	}
	
}
