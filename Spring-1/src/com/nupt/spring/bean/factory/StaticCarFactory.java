package com.nupt.spring.bean.factory;

import java.util.HashMap;
import java.util.Map;

public class StaticCarFactory {
	/*
	 * 静态工厂方法：直接调用某一个类的静态方法就可以返回Bean的实例
	 * 
	*/
	private static Map<String,Car> cars= new HashMap<String,Car>();
	
	static{
		cars.put("奥迪", new Car("奥迪",200000));
		cars.put("宝马", new Car("宝马",400000));
		
	}
	//静态工厂方法
	public static Car getCar(String name){
		return cars.get(name);
	}
}
