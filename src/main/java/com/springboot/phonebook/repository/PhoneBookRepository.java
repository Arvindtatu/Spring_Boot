package com.springboot.phonebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.phonebook.pojo.PhoneBookPOJO;

public interface PhoneBookRepository extends JpaRepository<PhoneBookPOJO, Integer> {

	public PhoneBookPOJO findByAllId(int id);

}
