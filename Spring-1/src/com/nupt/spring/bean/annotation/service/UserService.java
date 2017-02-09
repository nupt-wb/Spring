package com.nupt.spring.bean.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nupt.spring.bean.annotation.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	@Qualifier("userRepositoryImp")
	private UserRepository userRepository;
	public void add(){
		System.out.println("UserService add...");
		userRepository.save();
	}
}
