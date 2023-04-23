package com.itheima.service;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author 朱喆
 * @version 1.0
 */
public class BrandService {
    //1.调用BrandMapper.selectAll()
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Brand> selectAll(){

        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.调用方法
        List<Brand> brands = mapper.selectAll();

        sqlSession.close();
        return brands;
    }

    public void add(Brand brand){
        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.add(brand);

        sqlSession.commit(); //添加记录，注意提交事务
        sqlSession.close();
    }

    public Brand selectById(int id){

        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.调用方法
        Brand brand = mapper.selectById(id);

        sqlSession.close();

        return brand;

    }


    public void update(Brand brand){
        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.update(brand);

        sqlSession.commit();
        sqlSession.close();

    }



}
