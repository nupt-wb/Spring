package com.swsoft.service.imp;

import org.aspectj.lang.annotation.Aspect;

@Aspect
public class UserHelper {
  public UserHelper(){}
  
  public void beforeInsert(){
	  System.out.println("bforeinsert=====");
  }
  public void afterInsert(){
	  System.out.println("afterinsert=====");
  }
}
