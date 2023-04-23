package com.zz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zz.pojo.User;

import java.util.List;

/**
 * @author 朱喆
 * @version 1.0
 */
public interface UserMapper extends BaseMapper<User> {

    List<User> findAll();


}
