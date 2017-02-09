package com.swsoft.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.swsoft.entity.returnentity.Commodities;
import com.swsoft.entity.returnentity.ShoppingCart;

@Repository
public interface ShoppingCartMapper {
	public List<Commodities> selectAll(Commodities com);
/*	public Map<String,Object> selectsl(Commodities com);
*/ 
	public Commodities selectSingle(Commodities com);
	public int insertcart(Map<String,Object>map);
	public ShoppingCart selectcart(ShoppingCart sc);
	public List<ShoppingCart> selectcartall();
	 public int update(Map<String,Object> map);
}
