package com.springrest.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.ContactUsDao;
import com.springrest.springrest.entities.ContactUs;

@Service
public class ContactUsSeviceImpl implements ContactUsService{

	@Autowired
	private ContactUsDao contactUsDao;
	
	@Override
	public ContactUs addUser(ContactUs contactus) {
		return contactUsDao.save(contactus);
	}
	
	@Override
	public List<ContactUs> getAllUsers() {
		return contactUsDao.findAll();
	}
	
}
