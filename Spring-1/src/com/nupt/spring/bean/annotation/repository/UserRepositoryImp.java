package com.nupt.spring.bean.annotation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nupt.spring.bean.annotation.TestObject;


@Repository
public class UserRepositoryImp implements UserRepository{
	
	@Autowired(required=false)
	private TestObject testObject;
	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("UserRepository Save...");
		System.out.println(testObject);
	}
	
	
}
