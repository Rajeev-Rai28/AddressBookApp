package com.addressbookapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.addressbookapp.model.Contact;

@SpringBootApplication
public class AddressbookappApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressbookappApplication.class, args);

// You can temporarily test(feature/uc-02-add-contact-console) it inside AddressBookApplication:
//
//		Contact contact = new Contact(
//		        "Rajeev",
//		        "Rai",
//		        "ABC Street",
//		        "Indore",
//		        "MP",
//		        "452001",
//		        "9999999999",
//		        "rajeev@gmail.com"
//		);
//
//		System.out.println(contact);
		
	}

}