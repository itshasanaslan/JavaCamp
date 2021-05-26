package com.hrms.hrms.business.abstracts;

import com.hrms.hrms.entities.concretes.Candidate;

public interface MernisService {
	public boolean validate(Candidate candidate);
}
