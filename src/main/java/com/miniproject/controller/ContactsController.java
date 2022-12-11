package com.miniproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.entities.Contact;
import com.miniproject.service.ContactService;

@RestController
public class ContactsController {

	@Autowired
	ContactService cntcsrve;

@GetMapping("/contact")
	private List<Contact> getContacts()
	{	
	return cntcsrve.getAllContacts();
	}

@GetMapping("/contact/{contactid}")
private Contact cts(@PathVariable("contactid") Integer contactid)
{	
return cntcsrve.getContactById(contactid);
}


	
@DeleteMapping("/contact/{contactid}")
	private String deleteContact(@PathVariable("contactid") Integer contactid )
	{
	
	return cntcsrve.deleteContactById(contactid);
	
	}
	
@PutMapping("/contact")
private String updateContact(@RequestBody Contact contact)

{	
	return cntcsrve.updateContact(contact);
}



}
