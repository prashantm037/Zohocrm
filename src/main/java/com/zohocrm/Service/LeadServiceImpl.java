package com.zohocrm.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zohocrm.Repository.LeadRepository;
import com.zohocrm.entity.Lead;

@Service
public class LeadServiceImpl implements LeadService {
	
	@Autowired
	private LeadRepository leadrepo;

	@Override
	public void saveLead(Lead lead) {
		leadrepo.save(lead);
	}

	@Override
	public Lead getOneLead(long id) {
		Optional<Lead> findById = leadrepo.findById(id);
		return findById.get();
	}

	@Override
	public void deleteLead(long id) {
		leadrepo.deleteById(id);
		
	}

}
