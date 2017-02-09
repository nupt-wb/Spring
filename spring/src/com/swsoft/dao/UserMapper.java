package com.swsoft.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.swsoft.entity.returnentity.User;
@Repository
public interface UserMapper {
 public int insert(Map<String,Object> map);
 public int update(Map<String,Object> map);
 public int delete(Map<String,Object> map);
 public int selectByName(Map<String,Object> map);
 public List<Map<String,Object>> selectAsListMap(Map<String,Object> map);
 public List<User> selectAsListClass();


}
