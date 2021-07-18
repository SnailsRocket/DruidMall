package com.xubo.mall.dao;

import com.xubo.mall.entity.User;
import com.xubo.mall.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserDao {

    int insertUser(UserInfo userInfo);

    UserInfo selectByPre(int id);

    List<UserInfo> listUser();

    int update(UserInfo userInfo);

    int updateUser(User user);

    int deleteByPre(int id);
}
