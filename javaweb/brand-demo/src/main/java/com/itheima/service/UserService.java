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

    public User login(String username,String password){

        //1.获取sqlSession
        SqlSession sqlSession = factory.openSession();

        //2.获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //3.调用方法
        User user = mapper.select(username, password);

        sqlSession.close();
        return user;
    }

    public boolean register(User user){

        //1.获取sqlSession
        SqlSession sqlSession = factory.openSession();

        //2.获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //判断这个要注册的用户名是否存在
        User u = mapper.selectByUsername(user.getUsername());

        if (u==null){
            mapper.add(user);
            sqlSession.commit();
        }
        sqlSession.close();

        return u==null;
    }

}
