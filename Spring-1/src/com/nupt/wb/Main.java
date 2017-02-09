package com.nupt.wb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args){
		/*
		//1、创建对象
		HelloWorld helloWorld = new HelloWorld();
		//2、为name属性赋值
		helloWorld.setName("wb");
		*/
		
		
		//1、创建Spring的IOC容器对象
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		/*
		//2、从IOC容器中获取Bean实例
		HelloWorld helloWorld =(HelloWorld) ctx.getBean("helloWorld");
		
		//3、调用hello方法
		helloWorld.hello();
		*/
		
		Car car = (Car) ctx.getBean("car");
		System.out.println(car);
		
		Car car2 = (Car) ctx.getBean("car2");
		System.out.println(car2);
		
		Person person = (Person) ctx.getBean("person");
		System.out.println(person);
		
		Person person2= (Person) ctx.getBean("person2");
		System.out.println(person2);
	}
}
