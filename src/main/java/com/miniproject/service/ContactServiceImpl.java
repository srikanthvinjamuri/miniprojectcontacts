package com.miniproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.entities.Contact;
import com.miniproject.repo.ContactRepository;
@Service
public class ContactServiceImpl implements ContactService{
	@Autowired
	private  ContactRepository repo;

	@Override
	public String saveContact(Contact contact) {

		contact =repo.save(contact);
		if(contact.getContactId()!=null)
			return "Contact Saved succefully";
		else{

			return "Contact Save Failed ";
		}
	}

	@Override	
	public List<Contact> getAllContacts() {


		List<Contact> contacts=	repo.findAll();

		return contacts;
	}

	@Override
	public Contact getContactById(Integer contactId) {
		// TODO Auto-generated method stub
		Optional<Contact> findById	=repo.findById(contactId);

		if(findById.isPresent())
		{
			return findById.get();	

		}
		return 	 null;
	}

	@Override
	public String updateContact(Contact contact) {
		// TODO Auto-generated method stub
		if(repo.existsById(contact.getContactId())) {
			repo.save(contact);
			return "updated succesfully";
		}
		else {

			return "no record found ";
		}


	}

	@Override
	public String deleteContactById(Integer contactId) {
		// TODO Auto-generated method stub
		if(repo.existsById(contactId)) {
			repo.deleteById(contactId);	
			return "record deleted succesfully";
		}
		else {
			return "No record Found";
		}

	}



}
