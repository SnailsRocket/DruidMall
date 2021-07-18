package com.xubo.mall.dao;

import com.xubo.mall.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface User4LoginDao {

    int addUser(User user);

    User selectUserByName(String name);

    List<User> findAllUser();

    int updateUser(User user);

    int deleteUserById(int id);

}
