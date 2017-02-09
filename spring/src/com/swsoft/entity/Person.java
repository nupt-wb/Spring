package com.swsoft.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class Person {
	@NotEmpty(message = "{name.not.empty}")
	private String name;

	@Range(min = 0, max = 200, message = "{age.not.inrange}")
	private String age;
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getAge(){
		return age;
	}
	
	public void setAge(String age){
		this.age = age;
	}
}

