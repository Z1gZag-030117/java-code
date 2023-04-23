package com.ydl.mapper;

import com.ydl.entity.User;

import java.util.List;

/**
 * @author 朱喆
 * @version 1.0
 */
public interface UserMapper {

    /**
     * 查询所有用户
     * @return
     */
    List<User> selectAllUsers();

    User selectById(int id);


}
