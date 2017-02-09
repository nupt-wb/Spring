package com.swsoft.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swsoft.dao.UserMapper;
import com.swsoft.entity.returnentity.User;
import com.swsoft.service.UserService;
@Service
public class UserServiceImp implements UserService{
  @Autowired
  private UserMapper userMapper;
	
  public int insert(Map<String,Object> map){
	 return userMapper.insert(map); 
  }
  public int update(Map<String,Object> map){
		 return userMapper.update(map); 
	  }
  public int delete(Map<String,Object> map){
		 return userMapper.delete(map); 
	  }
  public int selectByName(Map<String,Object> map){
		 return userMapper.selectByName(map); 
	  }
  
  public List<Map<String,Object>>  selectAsListMap(Map<String,Object> map){
	  return userMapper.selectAsListMap(map);
  }
  public List<User> selectAsListClass(){
	  return userMapper.selectAsListClass();
  }
}
