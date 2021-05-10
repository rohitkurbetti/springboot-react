package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entities.ContactUs;

public interface ContactUsService {
	public ContactUs addUser(ContactUs contactus);

	public List<ContactUs> getAllUsers();
}
