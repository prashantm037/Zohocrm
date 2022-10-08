package com.zohocrm.Service;

import com.zohocrm.entity.Lead;

public interface LeadService {
	
	public void saveLead(Lead lead);

	public Lead getOneLead(long id);

	public void deleteLead(long id);

}
