package com.xubo.mall.service;

import com.xubo.mall.entity.User;
import com.xubo.mall.entity.UserInfo;

import java.util.List;

/**
 * @Author Druid_Xu
 * @Description TODO
 * @Date 2020/8/14 下午 04:14
 */
public interface UserService {
    public List<UserInfo> findAll();

    public int insertOne(UserInfo userInfo);

    public UserInfo findByPre(int id);

    public int updateUser(UserInfo userInfo);

    public int updateUserDB(User user);

    public int deleteUserByOne(int id);

}
