package com.springboot.phonebook.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "phoneBook_App")
public class PhoneBookPOJO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	
	@Column(name = "phono_id")
	private int id;
	
	@Column(name = "user_name")
	private String name;
	
	@Column(name = "contact_no")
	private long contact;
	
	@Column(name = "user_email")
	private String email;

}
