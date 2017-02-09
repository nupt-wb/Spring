package com.swsoft.service;

import java.util.List;
import java.util.Map;

import com.swsoft.entity.returnentity.Commodities;
import com.swsoft.entity.returnentity.ShoppingCart;

public interface ShoppingCartService {
	public List<Commodities> selectAll(Commodities com);
	public Commodities selectSingle(Commodities com);
	public int insertcart(Map<String,Object>map);
	public ShoppingCart selectcart(ShoppingCart sc);
	public List<ShoppingCart> selectcartall();
	 public int update(Map<String,Object> map);
}
