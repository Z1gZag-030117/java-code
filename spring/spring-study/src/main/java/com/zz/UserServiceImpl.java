package com.zz;

import com.zz.mapper.UserMapper;
import com.zz.pojo.User;
import com.zz.util.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 朱喆
 * @version 1.0
 */
public class UserServiceImpl {


    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

//    String resource = "mybatis-config.xml";
//    InputStream inputStream;
//
//    {
//        try {
//            inputStream = Resources.getResourceAsStream(resource);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//
//
//    private UserDaoImpl userDaoImpl;
//
//    private AddressDao addressDao;
//
//
//
//
//    public UserService()  {
//    }
//
//    public UserService(UserDaoImpl userDaoImpl, AddressDao addressDao) throws IOException {
//        this.userDaoImpl = userDaoImpl;
//        this.addressDao = addressDao;
//    }
//
//
//    public void setAddressDao(AddressDao addressDao) {
//        this.addressDao = addressDao;
//    }
//    public void setUserDaoImpl(UserDaoImpl userDaoImpl) {
//        this.userDaoImpl = userDaoImpl;
//    }

    public List<User> show() {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> all = mapper.findAll();
        return all;
    }


}
