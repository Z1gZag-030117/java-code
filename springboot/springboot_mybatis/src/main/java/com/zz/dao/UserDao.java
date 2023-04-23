package com.zz.dao;

import com.zz.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author 朱喆
 * @version 1.0
 */
@Mapper
public interface UserDao {

    @Select("select * from tb_user where id=#{id}")
    User getById(int id);

}
