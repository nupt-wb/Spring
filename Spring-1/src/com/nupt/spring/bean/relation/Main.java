package com.nupt.spring.bean.relation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nupt.spring.bean.autowire.Address;

public class Main {
	
	public static void main(String[] args){
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-relation.xml");
		
		Address address = (Address) ctx.getBean("address");
		System.out.println(address);
		
		Address address2 = (Address) ctx.getBean("address2");
		System.out.println(address2);
	}
}
