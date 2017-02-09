package com.nupt.spring.bean.annotation.repository;

import org.springframework.stereotype.Repository;


@Repository
public class UserJdbcRepository implements UserRepository {

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("UserJdbcRepository save...");
	}

}
