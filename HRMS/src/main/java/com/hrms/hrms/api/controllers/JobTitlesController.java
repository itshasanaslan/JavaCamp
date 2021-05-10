package com.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.business.abstracts.JobTitleService;
import com.hrms.hrms.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/job_titles")
public class JobTitlesController {
	private JobTitleService jobTitleService;
	
	public JobTitlesController() {}

	@Autowired
	public JobTitlesController(JobTitleService jobTitleService) {
		super();
		this.jobTitleService = jobTitleService;
	}
	
	@GetMapping("/get_all")
	public List<JobTitle> getAll(){
		return this.jobTitleService.getAll();
	}
	
}
