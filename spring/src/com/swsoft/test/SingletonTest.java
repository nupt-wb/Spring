package com.swsoft.test;

public class SingletonTest {
  private String name;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
  private SingletonTest(){
	  
  }
  
  private static SingletonTest st = null;
  
  public static SingletonTest getTest(){
	  if(st==null){
		  st = new SingletonTest();
	  }
	  return st;
  }
  public void getInfo(){
	  System.out.println("out:"+name);
  }
  
  public static void main(String[] args){
	  SingletonTest s1 =SingletonTest.getTest();
	  s1.setName("胡磊 1");
	  System.out.println(s1.getName());
	  SingletonTest s2 = SingletonTest.getTest();
	  s2.setName("胡磊2");
	  System.out.println(s2.getName());
	  s1.getInfo();
	  s2.getInfo();
	  if(s1==s2){
		  System.out.println("是一个实例");
	  }else if(s1!=s2){
		  System.out.println("不是一个实例");

	  }else{
		  System.out.println("application error");

	  }

	  
  }
  
}
