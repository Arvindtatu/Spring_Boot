package com.springboot.phonebook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.phonebook.pojo.PhoneBookPOJO;
import com.springboot.phonebook.service.PhoneBookService;

@RestController
public class PhoneBookController {

	@Autowired
	private PhoneBookService bookService;

	// add contact handler
	@PostMapping("/contact")
	public ResponseEntity<PhoneBookPOJO> addContact(@RequestBody PhoneBookPOJO bookPOJO) {
		PhoneBookPOJO pojo = null;
		try {
			pojo = bookService.addContact(bookPOJO);
			System.out.println(bookPOJO);
			return ResponseEntity.of(Optional.of(pojo));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

	}

	// get all contact handler
	@GetMapping("/contact")
	public ResponseEntity<List<PhoneBookPOJO>> getAllContact() {

		List<PhoneBookPOJO> list = bookService.getAllCotact();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);

	}

	// get contact by id handler
	@GetMapping("/contact/{id}")
	public ResponseEntity<PhoneBookPOJO> getContactById(@PathVariable("id") int id) {

		PhoneBookPOJO bookPOJO = bookService.getContactById(id);
		if (bookPOJO == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(bookPOJO));

	}

	// update contact handler
//	@PutMapping("/contact/{id}")
//	public ResponseEntity<PhoneBookPOJO> updateContact(@RequestBody PhoneBookPOJO bookPOJO,
//			@PathVariable("id") int id) {
//		try {
//			bookService.updateContact(bookPOJO, id);
//			
//			return ResponseEntity.ok().body(bookPOJO);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//
//		}
//	}

	// delete contact handler
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> deleteContact(@PathVariable("id") int id) {
		try {
			bookService.deleteContact(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		}

	}
}
