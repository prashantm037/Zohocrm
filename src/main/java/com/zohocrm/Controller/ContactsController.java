package com.zohocrm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.zohocrm.utility.ContactsService;

@Controller
public class ContactsController {

	@Autowired
	private ContactsService contactservice;
}
