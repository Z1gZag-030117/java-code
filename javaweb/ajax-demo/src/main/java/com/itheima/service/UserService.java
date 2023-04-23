package com.itheima.service;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author 朱喆
 * @version 1.0
 */
public class UserService {

    SqlSessionFactory factory= SqlSessionFactoryUtils.getSqlSessionFactory();
    public User selectByUsername(String username){
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectByUsername(username);
        return user;
    }

}
