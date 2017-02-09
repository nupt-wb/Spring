package com.swsoft.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;











import org.springframework.web.servlet.ModelAndView;

import com.swsoft.entity.Person;
import com.swsoft.entity.returnentity.User;
import com.swsoft.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	private final Log logger = LogFactory.getLog(UserController.class);
	//http://localhost:8080/spring/user/index
  @RequestMapping(value="/index",method={RequestMethod.GET,RequestMethod.POST})
  public String index(){
	  return "index";
  }
	//http://localhost:8080/spring/user/insert
  @RequestMapping(value="/insert",method={RequestMethod.GET,RequestMethod.POST})
  public String insert(@RequestParam("name")String name,@RequestParam("age")String age){
	  Map<String,Object> map = new HashMap<String,Object>();
	  map.put("name", name);
	  map.put("age", age);
	  int ret =userService.insert(map);
	 if(ret>0){
		  return "success";
	  }else{
	  return "index";
	  }
  }
//http://localhost:8080/spring/user/update
  @RequestMapping(value="/update",method={RequestMethod.GET,RequestMethod.POST})
  public String update(@RequestParam("name")String name,@RequestParam("age")String age){
	  Map<String,Object> map = new HashMap<String,Object>();
	  map.put("name", name);
	  map.put("age", age);
	  int ret =userService.update(map);
	  if(ret>0){
		  return "success";
	  }else{
	  return "failed";
	  }
  }
//http://localhost:8080/spring/user/delete
  @RequestMapping(value="/delete",method={RequestMethod.GET,RequestMethod.POST})
  public String delete(@RequestParam("name")String name){
	  Map<String,Object> map = new HashMap<String,Object>();
	  map.put("name", name);

	  int ret =userService.delete(map);
	  if(ret>0){
		  return "success";
	  }else{
	  return "failed";
	  }
  }
  
//http://localhost:8080/spring/user/selectByName
  @RequestMapping(value="/selectByName",method={RequestMethod.GET,RequestMethod.POST})
  public String selectByName(@RequestParam("name")String name){
	  Map<String,Object> map = new HashMap<String,Object>();
	  map.put("name", name);

	  int ret =userService.selectByName(map);
	 System.out.println(ret);
	  if(ret>0){
		 
		  return "success";
		  
	  }else{
	  return "failed";
	  }
  }
//http://localhost:8080/spring/user/selectAsListMap
  @RequestMapping(value="/selectAsListMap",method={RequestMethod.GET,RequestMethod.POST})
  public String selectAsListMap(@RequestParam("name")String name){
   Map<String,Object> map = new HashMap<String,Object>();
	  map.put("name", name);
	  List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();
	  listMap= userService.selectAsListMap(map);
	  for (Map<String, Object> m : listMap)  
	    {  
	      for (String key : m.keySet())  
	      {  
	        System.out.println(key + " : " + m.get(key));  
	      }  
	  
	    }  
    return "success";
 
  }
//http://localhost:8080/spring/user/selectAsListMap
  @RequestMapping(value="/selectAsListClass",method={RequestMethod.GET,RequestMethod.POST})
  public ModelAndView selectAsListClass(HttpServletRequest request,HttpServletResponse response){
  /* Map<String,Object> map = new HashMap<String,Object>();
	  map.put("name", name);*/
	/*  User u=new User();
	  List<User> listMap = new ArrayList<User>();
	  listMap= userService.selectAsListClass();
	 
		  System.out.print("id:"+u.getI()+"  "+"name:"+u.getN()+"  "+"age:"+u.getA()+"  "+"submitDate:"+u.getS()); 
	     System.out.println();*/
		ModelAndView mv = new ModelAndView();
		 List<User> listMap = new ArrayList<User>();
		 listMap= userService.selectAsListClass();
		mv.addObject("userInfo",listMap);
		mv.setViewName("success");
		
	  
   return mv;
 
  }
//http://localhost:8080/spring/user/objectinsert
  @RequestMapping(value="/objectinsert", method = RequestMethod.POST)
	public ModelAndView objectInsert(@Valid @ModelAttribute("modelValid") Person person,BindingResult result,HttpServletRequest request,HttpServletResponse response,@RequestParam("name")String name,@RequestParam("age")String age) {
	
		ModelAndView mv = new ModelAndView();


		if (result.hasErrors()) {
			logger.error("验证错误");
			mv.setViewName("/usermanage/insert");
		}else{
			 Map<String,Object> map = new HashMap<String,Object>();
			  map.put("name",name);
			  map.put("age", age);
			  userService.insert(map);
			  mv.setViewName("success");
		   
		}
		 List<User> listMap = new ArrayList<User>();
		 listMap= userService.selectAsListClass();
		 mv.addObject("userInfo",listMap);
		 return mv;
	}

//	http://localhost:8080/spring/user/topics/123
	
	@RequestMapping(value="/topics/{topicId}")
	public String topic(@PathVariable("topicId") String topicId){
		System.out.println(topicId);
		return "/usermanage/insert";
	}


}
