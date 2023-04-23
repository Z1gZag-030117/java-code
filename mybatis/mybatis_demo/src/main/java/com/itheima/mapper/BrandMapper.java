package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 朱喆
 * @version 1.0
 */
public interface BrandMapper {

    List<Brand> selectAll();

    Brand selectById(int id);

    List<Brand> selectByCondition1(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);

    List<Brand> selectByCondition2(Brand brand);

    List<Brand> selectByCondition3(Map map);

    List<Brand> selectByConditionSingle(Brand brand);

    void add(Brand brand);

    int update(Brand brand);

    void deleteById(int id);

    void deleteByIds(@Param("ids") int[] ids);



}
