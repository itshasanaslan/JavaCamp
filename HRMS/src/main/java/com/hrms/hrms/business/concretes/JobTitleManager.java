package com.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.JobTitleService;
import com.hrms.hrms.dataAccess.abstracts.JobTitleDao;
import com.hrms.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{

	private JobTitleDao jobTitleDao;
	
	public JobTitleManager() {}
	
	@Autowired
	public JobTitleManager(JobTitleDao dao) {
		super();
		this.jobTitleDao = dao;
	}


	@Override
	public List<JobTitle> getAll() {
		// TODO Auto-generated method stub
		return this.jobTitleDao.findAll();
	}
	
}
