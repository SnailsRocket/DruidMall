package com.xubo.mall.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.OncePerRequestFilter;

import com.xubo.mall.dao.User4LoginDao;
import com.xubo.mall.entity.User;
import com.xubo.mall.entity.UserInfo;
import com.xubo.mall.service.UserService;
import com.xubo.mall.service.impl.UserOncePreImpl;


/**
 * @Author Druid_Xu
 * @Description TODO
 * @Date 2020/8/14 下午 04:35
 * 配置了全局跨域类(一般都是在配置文件里面写origin，然后配置类里面获取)，所以这里把@CrossOrigin 注释掉
 * @ConfigurationProperties(prefix = "jwt", ignoreUnknownFields = true) 参考 eladmin 里面的ConfigBeanConfiguration类
 *
 */
@RestController
//@RequestMapping(value = "/user",produces = {"text/plain;charset=utf-8"}) // 解决返回String乱码问题
//@RequestMapping(value = "/user",produces = {"application/json;charset=utf-8"})
@RequestMapping(value = "/user")
//@CrossOrigin(origins = {"http://localhost:4300","http://localhost:4320","http://localhost:3000","http://localhost:63342"})
public class UserController {

    @Autowired
    UserService userService;

    //    直接在controller中 注入 mapper层的方法
    @Autowired
    private final User4LoginDao user4LoginDao;

//    不使用@Autowired 注入，使用 构造注入 或者 set 注入
    public UserController(User4LoginDao user4LoginDao) {
        this.user4LoginDao = user4LoginDao;
    }


    /**
     * 同一个id限制 每秒访问 1 次
     * 可以使用限流组件 hystrix
     * 有一个方案 : 方案有问题，参考其他人的
     * 前端传过来一个int a != 0 然后 后端 controller 也设置一个值 int b，前端这个值是怎么设置的
     * 首先判断 b == 0 ? 已经执行操作 ： b = a
     *
     *
     * @return
     */
    @GetMapping("/list")
    public List<UserInfo> findAllUser(
            ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        List<UserInfo> res = userService.findAll();
        return res;
    }

    @PostMapping("/add")
    public int addUser(@RequestBody UserInfo userInfo) {
        return userService.insertOne(userInfo);
    }

    @GetMapping("/find/{id}")
    public UserInfo findByPre(@RequestParam int id) {
        return userService.findByPre(id);
    }

    @PostMapping("/update")
    public int updateUser(@RequestParam UserInfo userInfo) {
        int res = userService.updateUser(userInfo);
        return res;
    }

    @DeleteMapping("/delete")
    public int deleteUserById(@RequestParam int id) {
        return userService.deleteUserByOne(id);
    }

//    简易版的登录  ，这个方法应该抽取出来
    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        User user = user4LoginDao.selectUserByName(username);
        if (user != null) {
            String pw_db = user.getPassword();
            if(pw_db == password) {
                return "登录成功";
            }
            return "密码错误";
        }
        return "该用户不存在，请重新登录";
    }

    @GetMapping("/getAll")
//    @CrossOrigin(origins = {"http://localhost:8090","null"})
    public List<User> findAllUsers() {
        List<User> allUser = user4LoginDao.findAllUser();
        if(allUser != null && allUser.size()!= 0) {
            return allUser;
        }
        return null; // 这个地方可以将系统的返回对象封装成一个result类，类里面有状态码，以及存储数据的集合，最好不要直接返回null
    }

//    @PostMapping("/edit")
//    @GetMapping(value = "/edit",produces = {"text/plain;charset=utf-8"})
    @GetMapping(value = "/edit")
//    public String editUser(@RequestBody User user) {
    public String editUser() {
//        if(user == null) {
//            return null;
//        }
//        int i = userService.updateUserDB(user);
        System.out.println("success");

        return "修改成功！";
    }


}
