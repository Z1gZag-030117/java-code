package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author 朱喆
 * @version 1.0
 */
public interface UserMapper {


    @Select("select * from tb_user where username=#{username}")
    User selectByUsername(@Param("username") String username);

}
