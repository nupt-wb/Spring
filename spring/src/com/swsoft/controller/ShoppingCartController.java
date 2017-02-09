package com.swsoft.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.swsoft.entity.returnentity.Commodities;
import com.swsoft.entity.returnentity.ShoppingCart;
import com.swsoft.service.ShoppingCartService;
import com.swsoft.utils.CookieUtils;

@Controller
@RequestMapping("/shoppingcart")
public class ShoppingCartController {
@Autowired
private ShoppingCartService  scs;
//http://localhost:8080/spring/shoppingcart/myshoppingcart
@RequestMapping(value="/myshoppingcart",method={RequestMethod.GET,RequestMethod.POST})
public String myshoppingcart(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
/*	HttpSession httpSession = request.getSession();*/
	List<ShoppingCart> listMap = null;
	listMap=scs.selectcartall();
request.setAttribute("mycartInfo", listMap);

	 


  request.setAttribute("mycartInfo", listMap);
	  return "/shoppingcart/shoppingcart";
}
//http://localhost:8080/spring/shoppingcart/selectAll
@RequestMapping(value="/selectAll",method={RequestMethod.GET,RequestMethod.POST})
public ModelAndView selectAll(HttpServletRequest request,HttpServletResponse response,@RequestParam("zlbh")String zlbh){

		ModelAndView mv = new ModelAndView();
		 List<Commodities> listMap = new ArrayList<Commodities>();
		 Commodities com=new Commodities();
		 com.setZlbh(zlbh);
		 zlbh = com.getZlbh();
		listMap = scs.selectAll(com);
		mv.addObject("commInfo",listMap);
		mv.setViewName("/shoppingcart/commInfo");
		
	  
 return mv;

}
//http://localhost:8080/spring/shoppingcart/selectAll
@RequestMapping(value="/addtocart",method={RequestMethod.GET,RequestMethod.POST})
public String addtocart(Commodities com,@RequestParam("spbh")String spbh,HttpServletRequest request,HttpServletResponse response){

	com.setSpbh(spbh);
	 spbh = com.getSpbh();
	com=scs.selectSingle(com);
	 List<ShoppingCart> listMap = new ArrayList<ShoppingCart>();
	ShoppingCart sc = new ShoppingCart();
	sc.setSpbh(spbh);
	String spbh1=sc.getSpbh();
	sc=scs.selectcart(sc);
if(sc==null){	
Map<String,Object> map = new HashMap<String,Object>();
map.put("id",com.getId());
map.put("zlbh",  com.getZlbh());
map.put("spbh",  com.getSpbh());
map.put("sl",  1);

map.put("zj", String.valueOf(1*(Integer.parseInt(com.getPrice()))));
map.put("submitDate",com.getSubmitDate());
	 scs.insertcart(map);
}else {
	Map<String,Object> map = new HashMap<String,Object>();
	map.put("sl",  (sc.getSl()+1));
	map.put("zj",  String.valueOf((sc.getSl()+1)*(Integer.parseInt(com.getPrice()))));
	map.put("spbh",  sc.getSpbh());
	scs.update(map);


}
List<Commodities> listMap1 = new ArrayList<Commodities>();
Commodities com1=new Commodities();
com1.setZlbh(com.getZlbh());
String zlbh1 = com1.getZlbh();
listMap1 = scs.selectAll(com1);
request.setAttribute("commInfo",listMap1);	 
return "/shoppingcart/commInfo";
}
//http://localhost:8080/spring/shoppingcart/addtocart

@SuppressWarnings("null")
@RequestMapping(value="/addtocart1",method={RequestMethod.GET,RequestMethod.POST}
)

public void addtocart1(
		@CookieValue(value="cartCookie",required = false)String cartCookieStr,
		@RequestParam("spbh")String spbh,
		HttpServletRequest request,HttpServletResponse response,
		Commodities com,ShoppingCart cart) throws UnsupportedEncodingException{
	 System.out.println("1");
	 com.setSpbh(spbh);
	 System.out.println("1");
	 spbh = com.getSpbh();
	com=scs.selectSingle(com);
	System.out.println(com.getZlbh());
    Cookie cookie = new Cookie("zlbh",  com.getZlbh());  
    cookie.setMaxAge(60 * 60 * 24 * 7);  
    cookie.setPath("/");  
    response.addCookie(cookie);
	CookieUtils.addCookie(response, "zlbh", com.getZlbh());
	HttpSession httpSession=null;
	List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();
 if(cartCookieStr==null){
		CookieUtils.addCookie(response, "id", String.valueOf(com.getId()));
		CookieUtils.addCookie(response, "zlbh", com.getZlbh());
		CookieUtils.addCookie(response, "spbh", com.getSpbh());
		CookieUtils.addCookie(response, "name", com.getName());
		CookieUtils.addCookie(response, "price", com.getPrice());
		CookieUtils.addCookie(response, "sl", "1");
		 Map<String,Object> map = new HashMap<String,Object>();
		 map.put("id",CookieUtils.findCookie(request, "id"));
		 map.put("zlbh",CookieUtils.findCookie(request, "zlbh"));
		 map.put("spbh", CookieUtils.findCookie(request, "spbh"));
		 map.put( "name", CookieUtils.findCookie(request, "name"));
		 map.put("sl", CookieUtils.findCookie(request, "sl"));
		 map.put( "price", CookieUtils.findCookie(request, "price"));
		 listMap.add(map);
		 CookieUtils.addCookie(response, "cartCookie", "cartCookieStr");	

	 }else {
		 if(CookieUtils.findCookie(request, "spbh").equals(spbh)){
				CookieUtils.addCookie(response, "sl", String.valueOf(Integer.parseInt(CookieUtils.findCookie(request, "sl"))+1));
				 Map<String,Object> map = new HashMap<String,Object>();
				 map.put("id",CookieUtils.findCookie(request, "id"));
				 map.put("zlbh",CookieUtils.findCookie(request, "zlbh"));
				 map.put("spbh", CookieUtils.findCookie(request, "spbh"));
				 map.put( "name", CookieUtils.findCookie(request, "name"));
				 map.put("sl", CookieUtils.findCookie(request, "sl"));
				 map.put( "price", CookieUtils.findCookie(request, "price"));
				 listMap.add(map);
		 }else{
				CookieUtils.addCookie(response, "id", String.valueOf(com.getId()));
				CookieUtils.addCookie(response, "zlbh", com.getZlbh());
				CookieUtils.addCookie(response, "spbh", com.getSpbh());
				CookieUtils.addCookie(response, "name", com.getName());
				CookieUtils.addCookie(response, "price", com.getPrice());
				CookieUtils.addCookie(response, "sl", "1");
				 Map<String,Object> map = new HashMap<String,Object>();
				 map.put("id",CookieUtils.findCookie(request, "id"));
				 map.put("zlbh",CookieUtils.findCookie(request, "zlbh"));
				 map.put("spbh", CookieUtils.findCookie(request, "spbh"));
				 map.put( "name", CookieUtils.findCookie(request, "name"));
				 map.put("sl", CookieUtils.findCookie(request, "sl"));
				 map.put( "price", CookieUtils.findCookie(request, "price"));
				 listMap.add(map);
		 }
		 httpSession.setAttribute("listMap", listMap);
	 }
	
}
	  




//http://localhost:8080/spring/shoppingcart/cookie
    //,required=false,defaultValue="jessionid:null"(当报错时，也就是没有cookie在请求头中时，加入这个)
/*    @RequestMapping("/cookie")
    public ModelAndView zwcr(@CookieValue(value="JSESSIONID") String cookie){        
        ModelAndView mv = new ModelAndView();
        System.out.println("cookie(JSESSIONID): " + cookie);        
        mv.setViewName("hello");
        return mv;
    } */

}
