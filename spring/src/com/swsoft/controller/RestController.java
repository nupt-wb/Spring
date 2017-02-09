package com.swsoft.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/rest")
public class RestController {
	//http://localhost:8080/spring/rest/getName

	  @RequestMapping(value="/getName",method={RequestMethod.GET,RequestMethod.POST},
			  produces="application/json",consumes="application/json")
	  @ResponseBody
	  public String getName(@RequestBody String str){
		  System.out.println(str);
		ObjectMapper oM = new  ObjectMapper();
		Map map = null;
		try{
			map=oM.readValue(str, Map.class);
		}catch(Exception e){
			
		}
		System.out.println(map.get("userName").toString());
		System.out.println(map.get("address").toString());
		
		//输出
		String name = "hulei";
		String uuid="123";
		String jsonObj = "{\"uuid\":\""+uuid+"\",\"name\":\""+name+"\"}";
				
return jsonObj;
	  }
}
