package com.miniproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproject.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{

	
	
}
