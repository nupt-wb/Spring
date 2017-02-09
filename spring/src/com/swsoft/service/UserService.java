package com.swsoft.service;

import java.util.List;
import java.util.Map;

import com.swsoft.entity.returnentity.Commodities;
import com.swsoft.entity.returnentity.User;

public interface UserService {
  public int insert(Map<String,Object> map);
  public int update(Map<String,Object> map);
  public int delete(Map<String,Object> map);
  public int selectByName(Map<String,Object> map);
  public List<Map<String,Object>> selectAsListMap(Map<String,Object> map);
  public List<User> selectAsListClass();
}
