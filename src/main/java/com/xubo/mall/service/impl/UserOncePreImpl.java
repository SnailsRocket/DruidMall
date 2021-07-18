package com.xubo.mall.service.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Executors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.executor.BaseExecutor;
import org.apache.ibatis.executor.BatchExecutor;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.ReuseExecutor;
import org.apache.ibatis.executor.SimpleExecutor;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.transaction.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.google.common.collect.Maps;

/**
 * @Author Druid_Xu
 * @Date 2020/11/13 上午 11:05
 * @Description
 */
@Component
public class UserOncePreImpl /*extends OncePerRequestFilter*/ {

    /*@Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

//        String header = response.getHeader("");
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();
        String remoteUser = request.getRemoteUser();
        System.out.println(remoteUser);
//        System.out.println("UserOncePreImpl header "+header); // null
        System.out.println("UserOncePreImpl session "+session.toString()); //

        Maps.newHashMap();

//        BaseExecutor()

        Configuration configuration = new Configuration();
        Transaction transaction = new Transaction() {
            @Override
            public Connection getConnection() throws SQLException {
                return null;
            }

            @Override
            public void commit() throws SQLException {

            }

            @Override
            public void rollback() throws SQLException {

            }

            @Override
            public void close() throws SQLException {

            }

            @Override
            public Integer getTimeout() throws SQLException {
                return null;
            }
        };
        Executor executor = new SimpleExecutor(configuration,transaction);
        Executor executor1 = new ReuseExecutor(configuration,transaction);
        Executor executor2 = new BatchExecutor(configuration,transaction);

    }*/
}
