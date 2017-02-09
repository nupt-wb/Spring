package com.nupt.spring.bean.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person person = (Person) ctx.getBean("person3");
		
		System.out.println(person);
		
		
		PersonCar pc =(PersonCar) ctx.getBean("personCar");
		System.out.println(pc);
		
		DataSource ds = (DataSource) ctx.getBean("dataSource");
		System.out.println(ds);
		
		Person person4 = (Person) ctx.getBean("person4");
		System.out.println(person4);
		
		Person person5 = (Person) ctx.getBean("person5");
		System.out.println(person5);
	}
}
