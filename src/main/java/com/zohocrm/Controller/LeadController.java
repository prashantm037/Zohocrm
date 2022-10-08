package com.zohocrm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.Service.LeadService;
import com.zohocrm.entity.Contacts;
import com.zohocrm.entity.Lead;
import com.zohocrm.utility.ContactsService;
import com.zohocrm.utility.EmailService;

@Controller
public class LeadController {
	@Autowired
	private ContactsService contactservice;
	
	@Autowired
	private LeadService leadservice;
	
	@Autowired
	private EmailService emailservice;
	
	
	@RequestMapping("/ViewLead")
	public String ViewleadPage() {
		return "Create_Lead";
	}
	
	@RequestMapping("/saveLead")
	public String SaveLead(@ModelAttribute("lead") Lead lead) {
		leadservice.saveLead(lead);
		return "lead_info";
	}
	
	@RequestMapping("/composeEmail")
	public String composeEmail(@RequestParam("email") String email,ModelMap model) {
		model.addAttribute("email", email);
		return "compose_email";
	}

	@RequestMapping("/SendEmail")
	public String SendEmail(@RequestParam("to") String to,@RequestParam("sub") String sub,@RequestParam("emailBody")String emailBody) {
		emailservice.SendEmail(to, sub, emailBody);
		return "compose_email";
	}
	@RequestMapping("/ConvertLead")
	public String convertLead(@RequestParam("id") long id) {
		Lead lead = leadservice.getOneLead(id);
		
		Contacts con=new Contacts();
		con.setId(lead.getId());
		con.setFirstName(lead.getFirstName());
		con.setLastName(lead.getLastName());
		con.setEmail(lead.getEmail());
		con.setMobile(lead.getMobile());
		con.setSource(lead.getSource());
		
		contactservice.SaveContacts(con);
		
		leadservice.deleteLead(id);
		return "compose_email";
	}
}
