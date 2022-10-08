package com.zohocrm.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zohocrm.entity.Contacts;

@Service
public class ContactsServiceImpl implements ContactsService {

	@Autowired
	private ContactsService contactservice;
	
	@Override
	public void SaveContacts(Contacts contact) {
		contactservice.SaveContacts(contact);
	}

}
