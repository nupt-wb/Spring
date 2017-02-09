package com.nupt.string.aop.helloworld;

public class Main {
	
	public static void main(String[] args) {
//		ArithmeticCalculator arithmeticCalculator = null;
//		arithmeticCalculator = new ArithmeticCalculatorLoggingImp();
		
		ArithmeticCalculator target = new ArithmeticCalculatorImp();
		ArithmeticCalculator proxy = new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();
		
		
		int result = proxy.add(1,2);
		System.out.println("--->" + result);
		
		result = proxy.div(4,2);
		System.out.println("--->" + result);
	}
}
