package com.itheima;

import com.itheima.mapper.BrandMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.Brand;
import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 朱喆
 * @version 1.0
 */
public class MybatisTest {

    @Test
    public void testSelectUser() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        System.out.println(users);
        System.out.println("住这");
    }


    @Test
    public void testSelectAll() throws IOException {

        //1. 后去sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取mapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        List<Brand> brands = mapper.selectAll();
        System.out.println(brands);
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException {

        int id=1;
        //1. 后去sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取mapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        Brand brand = mapper.selectById(id);
        System.out.println(brand);
        sqlSession.close();
    }
    @Test
    public void testSelectByCondition1() throws IOException {

        int status =1;
        String companyName="华为";
        String brandName="华为";
        companyName="%"+companyName+"%";
        brandName="%"+brandName+"%";

        //1. 后去sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取mapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        List<Brand> brands = mapper.selectByCondition1(status, companyName, brandName);
        System.out.println(brands);
        sqlSession.close();
    }



    @Test
    public void testSelectByCondition2() throws IOException {

        int status =1;
        String companyName="华为";
        String brandName="华为";
        companyName="%"+companyName+"%";
        brandName="%"+brandName+"%";
        Brand brand=new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);

        //1. 后去sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取mapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        List<Brand> brands = mapper.selectByCondition2(brand);
        System.out.println(brands);
        sqlSession.close();
    }
    @Test
    public void testSelectByCondition3() throws IOException {

        int status =1;
        String companyName="华为";
        String brandName="华为";
        companyName="%"+companyName+"%";
        brandName="%"+brandName+"%";
        Map map=new HashMap();
        map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);

        //1. 后去sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取mapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        List<Brand> brands = mapper.selectByCondition3(map);
        System.out.println(brands);
        sqlSession.close();
    }


    @Test
    public void testSelectByConditionSingle() throws IOException {

        int status =1;
        String companyName="华为";
        String brandName="华为";
        companyName="%"+companyName+"%";
        brandName="%"+brandName+"%";
        Brand brand=new Brand();
        brand.setStatus(status);
        //brand.setCompanyName(companyName);
        //brand.setBrandName(brandName);

        //1. 后去sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取mapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        List<Brand> brands = mapper.selectByConditionSingle(brand);
        System.out.println(brands);
        sqlSession.close();
    }

    @Test
    public void testAdd() throws IOException {

        int status =1;
        String companyName="oppo";
        String brandName="oppo";
        String description="oppo手机好";
        int ordered=100;
        Brand brand=new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        //1. 后去sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);


        //3.获取mapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        mapper.add(brand);
        Integer id = brand.getId();
        System.out.println(id);
        //提交事务
        //sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        int id=7;
        int status =1;
        String companyName="屁股";
        String brandName="屁股";
        String description="屁股";
        int ordered=999;

        Brand brand=new Brand();
        brand.setId(id);
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        //1. 后去sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);


        //3.获取mapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        int update = mapper.update(brand);
        System.out.println(update);
        //提交事务
        //sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDelete() throws IOException {
        int id=8;
        //1. 后去sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);


        //3.获取mapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        mapper.deleteById(id);
        //提交事务
        //sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteByIds() throws IOException {
        int[] ids={6,7,9};
        //1. 后去sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);


        //3.获取mapper接口的代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        mapper.deleteByIds(ids);
        //提交事务
        //sqlSession.commit();
        sqlSession.close();
    }



}
