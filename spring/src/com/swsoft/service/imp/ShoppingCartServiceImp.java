package com.swsoft.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swsoft.dao.ShoppingCartMapper;
import com.swsoft.entity.returnentity.Commodities;
import com.swsoft.entity.returnentity.ShoppingCart;
import com.swsoft.service.ShoppingCartService;
@Service
public class ShoppingCartServiceImp implements ShoppingCartService {
	@Autowired
	private ShoppingCartMapper  scm;
	public List<Commodities> selectAll(Commodities com){
		return scm.selectAll(com);
	}

	public Commodities selectSingle(Commodities com){
		return scm.selectSingle(com);
	}
	public int insertcart(Map<String,Object>map) {
		return scm.insertcart(map);
	}
	public ShoppingCart selectcart(ShoppingCart sc){
		return scm.selectcart(sc);
	}
	public List<ShoppingCart> selectcartall(){
		return scm.selectcartall();
	}
	  public int update(Map<String,Object> map){
		  return scm.update(map);
	  }
}
