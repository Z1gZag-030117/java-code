package com.itheima.service.impl;

import com.itheima.SqlSessionFactoryUtils;
import com.itheima.mapper.UserMapper;
import com.itheima.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author 朱喆
 * @version 1.0
 */
public class UserServiceImpl implements UserService {

    public UserServiceImpl() {
    }

    SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<User> show(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> all = mapper.findAll();
        return all;
    }

}
