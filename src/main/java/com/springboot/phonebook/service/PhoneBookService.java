package com.springboot.phonebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.phonebook.pojo.PhoneBookPOJO;
import com.springboot.phonebook.repository.PhoneBookRepository;

@Service
public class PhoneBookService {

	@Autowired
	private PhoneBookRepository bookRepository;

	// add contact
	public PhoneBookPOJO addContact(PhoneBookPOJO bookPOJO) {
		PhoneBookPOJO result = bookRepository.save(bookPOJO);
		return result;

	}
	//get all contact 
	public List<PhoneBookPOJO> getAllCotact() {
	List<PhoneBookPOJO> bookPOJOs = bookRepository.findAll();
		return bookPOJOs;
		
		
	}

	//get contact by id
	public PhoneBookPOJO getContactById(int id) {
	PhoneBookPOJO bookPOJO=	bookRepository.findById(id).orElse(null);
		
		return bookPOJO;
	}
	
	//update contact
	public void updateContact(PhoneBookPOJO bookPOJO, int id) {
		
		bookPOJO.setId(id);
		bookRepository.save(bookPOJO);
		
	}
	
	//delete perticular book
		public void deleteContact(int id) {
			bookRepository.deleteById(id);
			
			
		}

}
