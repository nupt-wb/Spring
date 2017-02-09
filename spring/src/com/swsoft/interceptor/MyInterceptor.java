package com.swsoft.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor{
	 //perHandle是在函数执行前执行
   @Override
   public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
       System.out.println("class: " + arg2.getClass());
       System.out.println("toString: " + arg2.toString());
       HandlerMethod handlerMethod = (HandlerMethod)arg2;
       System.out.println("method: " + handlerMethod.toString());
       
       System.out.println("MyInterceptor preHandle");
       //如果我们返回false, 就不会往下面执行 参看 page 147 to 157
       return true;
       //return false;
   }
    
   //postHanle是在函数执行完成后再执行
   @Override
   public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {
       System.out.println("MyInterceptor postHandle");
   }

   @Override
   public void afterCompletion(HttpServletRequest arg0,HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
       System.out.println("MyInterceptor afterCompletion");
   }
}
