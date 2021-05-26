package com.hrms.hrms.business.concretes;

import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.MernisService;
import com.hrms.hrms.entities.concretes.Candidate;

@Service
public class MernisManager implements MernisService{

	@Override
	public boolean validate(Candidate candidate) {
		// TODO Auto-generated method stub
		return true;
	}
	

}
