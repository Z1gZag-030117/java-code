package com.zz.dao;

import com.zz.pojo.User;
import org.apache.ibatis.annotations.Insert;

/**
 * @author 朱喆
 * @version 1.0
 */
public interface UserDao {

    @Insert("insert into tb_user(name,password) values (#{name},#{password}}})))")
    void show(User user);

}
